package com.google.gson.stream;
/* loaded from: classes.dex */
/* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f1676a = new int[JsonScope.values().length];

    static {
        try {
            f1676a[JsonScope.EMPTY_DOCUMENT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1676a[JsonScope.EMPTY_ARRAY.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1676a[JsonScope.NONEMPTY_ARRAY.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1676a[JsonScope.EMPTY_OBJECT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1676a[JsonScope.DANGLING_NAME.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f1676a[JsonScope.NONEMPTY_OBJECT.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f1676a[JsonScope.NONEMPTY_DOCUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f1676a[JsonScope.CLOSED.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
    }
}
