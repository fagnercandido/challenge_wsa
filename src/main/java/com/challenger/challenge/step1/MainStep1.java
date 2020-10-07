package com.challenger.challenge.step1;

import java.util.List;
import java.util.Objects;

public class MainStep1 {

    public String print(int start, int end) {
        validateRange(start, end);
        StringBuilder result = new StringBuilder();
        for(int count = start; count <= end; count++) {
            fillResult(result, count, MultipleEnum.strategy(count));
        }
        return replaceLastCharacter(result);
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
