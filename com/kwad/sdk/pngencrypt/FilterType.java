package com.kwad.sdk.pngencrypt;

import java.util.HashMap;
/* loaded from: classes8.dex */
public enum FilterType {
    FILTER_NONE(0),
    FILTER_SUB(1),
    FILTER_UP(2),
    FILTER_AVERAGE(3),
    FILTER_PAETH(4),
    FILTER_DEFAULT(-1),
    FILTER_AGGRESSIVE(-2),
    FILTER_VERYAGGRESSIVE(-4),
    FILTER_ADAPTIVE_FULL(-4),
    FILTER_ADAPTIVE_MEDIUM(-3),
    FILTER_ADAPTIVE_FAST(-2),
    FILTER_SUPER_ADAPTIVE(-10),
    FILTER_PRESERVE(-40),
    FILTER_CYCLIC(-50),
    FILTER_UNKNOWN(-100);
    
    public static HashMap<Integer, FilterType> byVal = new HashMap<>();
    public final int val;

    static {
        FilterType[] values;
        for (FilterType filterType : values()) {
            byVal.put(Integer.valueOf(filterType.val), filterType);
        }
    }

    FilterType(int i2) {
        this.val = i2;
    }

    public static FilterType[] getAllStandard() {
        return new FilterType[]{FILTER_NONE, FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH};
    }

    public static FilterType[] getAllStandardExceptNone() {
        return new FilterType[]{FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH};
    }

    public static FilterType[] getAllStandardForFirstRow() {
        return new FilterType[]{FILTER_SUB, FILTER_NONE};
    }

    public static FilterType[] getAllStandardNoneLast() {
        return new FilterType[]{FILTER_SUB, FILTER_UP, FILTER_AVERAGE, FILTER_PAETH, FILTER_NONE};
    }

    public static FilterType getByVal(int i2) {
        return byVal.get(Integer.valueOf(i2));
    }

    public static boolean isAdaptive(FilterType filterType) {
        int i2 = filterType.val;
        return i2 <= -2 && i2 >= -4;
    }

    public static boolean isValidStandard(int i2) {
        return i2 >= 0 && i2 <= 4;
    }

    public static boolean isValidStandard(FilterType filterType) {
        return filterType != null && isValidStandard(filterType.val);
    }
}
