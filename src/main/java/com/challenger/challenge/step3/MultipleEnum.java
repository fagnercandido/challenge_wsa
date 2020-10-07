package com.challenger.challenge.step3;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum MultipleEnum {

    THREE(3) {
        @Override
        public Strategy getStrategy() {
            return new Strategy3();
        }
    },
    FIVE(5) {
        @Override
        public Strategy getStrategy() {
            return new Strategy5();
        }
    },
    FIFTEEN(15) {
        @Override
        public Strategy getStrategy() {
            return new Strategy15();
        }
    };


    abstract Strategy getStrategy();

    private final int number;

    MultipleEnum(int number) {
        this.number = number;
    }

    public static List<Strategy> strategy(int number) {
        List<MultipleEnum> strategys = Arrays
                .stream(MultipleEnum.values())
                .sequential()
                .filter(item -> number % item.number == 0)
                .collect(Collectors.toList());
        return Objects.nonNull(strategys) ?
                strategys
                        .stream()
                        .map(item -> item.getStrategy())
                        .collect(Collectors.toList())
                : null;

    }
}
