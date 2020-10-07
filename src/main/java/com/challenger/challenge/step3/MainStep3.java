package com.challenger.challenge.step3;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainStep3 {

    private StringBuilder result;

    public String print(int start, int end) {
        validateRange(start, end);
        StringBuilder result = new StringBuilder();
        for(int count = start; count <= end; count++) {
            fillResult(result, count, MultipleEnum.strategy(count));
        }
        this.result = result;
        return replaceLastCharacter(result);
    }

    public String report() {
        Map<String, Long> mapResult = new LinkedHashMap<>();
        StringBuilder report = new StringBuilder();
        List<String> resultList = List.of(result.toString().split(" "));
        resultList.stream().distinct().forEach(item -> {
            Long count = resultList.stream().filter(input -> input.equals(item)).count();
            mapResult.put(item, count);
        });
        mapResult.forEach((key, value) -> report.append(key+": "+value+"\n"));
        return report.toString();
    }

    private void validateRange(int start, int end) {
        if(start > end) {
            throw new IllegalArgumentException("The range informed was wrong.");
        }
    }

    private void fillResult(StringBuilder result, int count, List<Strategy> strategys) {
        if(Objects.nonNull(strategys) && !strategys.isEmpty()) {
            strategys.forEach(item -> result.append(item.printStrategy()));
        } else {
            result.append(count);
        }
        result.append(" ");
    }

    private String replaceLastCharacter(StringBuilder result) {
        return result.substring(0, result.length() - 1)+".";
    }
}
