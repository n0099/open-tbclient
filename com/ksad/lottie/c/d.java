package com.ksad.lottie.c;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public static com.ksad.lottie.model.a.b a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return a(jsonReader, dVar, true);
    }

    public static com.ksad.lottie.model.a.b a(JsonReader jsonReader, com.ksad.lottie.d dVar, boolean z) {
        return new com.ksad.lottie.model.a.b(a(jsonReader, z ? com.ksad.lottie.d.f.a() : 1.0f, dVar, i.f31965a));
    }

    public static com.ksad.lottie.model.a.c a(JsonReader jsonReader, com.ksad.lottie.d dVar, int i2) {
        return new com.ksad.lottie.model.a.c(a(jsonReader, dVar, new l(i2)));
    }

    @Nullable
    public static <T> List<com.ksad.lottie.e.a<T>> a(JsonReader jsonReader, float f2, com.ksad.lottie.d dVar, aj<T> ajVar) {
        return r.a(jsonReader, dVar, f2, ajVar);
    }

    @Nullable
    public static <T> List<com.ksad.lottie.e.a<T>> a(JsonReader jsonReader, com.ksad.lottie.d dVar, aj<T> ajVar) {
        return r.a(jsonReader, dVar, 1.0f, ajVar);
    }

    public static com.ksad.lottie.model.a.d b(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return new com.ksad.lottie.model.a.d(a(jsonReader, dVar, o.f31967a));
    }

    public static com.ksad.lottie.model.a.f c(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return new com.ksad.lottie.model.a.f(a(jsonReader, com.ksad.lottie.d.f.a(), dVar, y.f31972a));
    }

    public static com.ksad.lottie.model.a.g d(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return new com.ksad.lottie.model.a.g(a(jsonReader, dVar, ac.f31961a));
    }

    public static com.ksad.lottie.model.a.h e(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return new com.ksad.lottie.model.a.h(a(jsonReader, com.ksad.lottie.d.f.a(), dVar, ad.f31962a));
    }

    public static com.ksad.lottie.model.a.j f(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return new com.ksad.lottie.model.a.j(a(jsonReader, dVar, h.f31964a));
    }

    public static com.ksad.lottie.model.a.a g(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return new com.ksad.lottie.model.a.a(a(jsonReader, dVar, f.f31963a));
    }
}
