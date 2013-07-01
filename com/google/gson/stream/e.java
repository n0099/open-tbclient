package com.google.gson.stream;
/* loaded from: classes.dex */
/* synthetic */ class e {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f1678a = new int[JsonScope.values().length];

    static {
        try {
            f1678a[JsonScope.NONEMPTY_DOCUMENT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1678a[JsonScope.EMPTY_DOCUMENT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1678a[JsonScope.EMPTY_ARRAY.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1678a[JsonScope.NONEMPTY_ARRAY.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1678a[JsonScope.DANGLING_NAME.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
