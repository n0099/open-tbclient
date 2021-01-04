package com.ksad.lottie.c;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: classes5.dex */
public class d {
    public static com.ksad.lottie.model.a.b a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return a(jsonReader, dVar, true);
    }

    public static com.ksad.lottie.model.a.b a(JsonReader jsonReader, com.ksad.lottie.d dVar, boolean z) {
        return new com.ksad.lottie.model.a.b(a(jsonReader, z ? com.ksad.lottie.d.f.a() : 1.0f, dVar, i.f8272a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.a.c a(JsonReader jsonReader, com.ksad.lottie.d dVar, int i) {
        return new com.ksad.lottie.model.a.c(a(jsonReader, dVar, new l(i)));
    }

    @Nullable
    private static <T> List<com.ksad.lottie.e.a<T>> a(JsonReader jsonReader, float f, com.ksad.lottie.d dVar, aj<T> ajVar) {
        return r.a(jsonReader, dVar, f, ajVar);
    }

    @Nullable
    private static <T> List<com.ksad.lottie.e.a<T>> a(JsonReader jsonReader, com.ksad.lottie.d dVar, aj<T> ajVar) {
        return r.a(jsonReader, dVar, 1.0f, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.a.d b(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return new com.ksad.lottie.model.a.d(a(jsonReader, dVar, o.f8274a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.a.f c(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return new com.ksad.lottie.model.a.f(a(jsonReader, com.ksad.lottie.d.f.a(), dVar, y.f8279a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.a.g d(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return new com.ksad.lottie.model.a.g(a(jsonReader, dVar, ac.f8268a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.a.h e(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return new com.ksad.lottie.model.a.h(a(jsonReader, com.ksad.lottie.d.f.a(), dVar, ad.f8269a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.a.j f(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return new com.ksad.lottie.model.a.j(a(jsonReader, dVar, h.f8271a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.a.a g(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        return new com.ksad.lottie.model.a.a(a(jsonReader, dVar, f.f8270a));
    }
}
