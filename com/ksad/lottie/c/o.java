package com.ksad.lottie.c;

import android.util.JsonReader;
/* loaded from: classes3.dex */
public class o implements aj<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final o f7977a = new o();

    private o() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.c.aj
    /* renamed from: a */
    public Integer b(JsonReader jsonReader, float f) {
        return Integer.valueOf(Math.round(p.b(jsonReader) * f));
    }
}
