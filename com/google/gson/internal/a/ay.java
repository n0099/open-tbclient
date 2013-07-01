package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
/* loaded from: classes.dex */
/* synthetic */ class ay {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f1625a = new int[JsonToken.values().length];

    static {
        try {
            f1625a[JsonToken.NUMBER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1625a[JsonToken.BOOLEAN.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1625a[JsonToken.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1625a[JsonToken.NULL.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1625a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f1625a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f1625a[JsonToken.END_DOCUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f1625a[JsonToken.NAME.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f1625a[JsonToken.END_OBJECT.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f1625a[JsonToken.END_ARRAY.ordinal()] = 10;
        } catch (NoSuchFieldError e10) {
        }
    }
}
