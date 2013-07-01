package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
/* loaded from: classes.dex */
/* synthetic */ class o {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f1635a = new int[JsonToken.values().length];

    static {
        try {
            f1635a[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1635a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1635a[JsonToken.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1635a[JsonToken.NUMBER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1635a[JsonToken.BOOLEAN.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f1635a[JsonToken.NULL.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
