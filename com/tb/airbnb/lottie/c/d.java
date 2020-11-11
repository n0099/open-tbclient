package com.tb.airbnb.lottie.c;

import android.support.annotation.Nullable;
import android.util.JsonReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes16.dex */
public class d {
    public static com.tb.airbnb.lottie.model.a.b f(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar) throws IOException {
        return a(jsonReader, eVar, true);
    }

    public static com.tb.airbnb.lottie.model.a.b a(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar, boolean z) throws IOException {
        return new com.tb.airbnb.lottie.model.a.b(a(jsonReader, z ? com.tb.airbnb.lottie.d.f.lb() : 1.0f, eVar, i.pKp));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.d g(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar) throws IOException {
        return new com.tb.airbnb.lottie.model.a.d(a(jsonReader, eVar, o.pKq));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.f h(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar) throws IOException {
        return new com.tb.airbnb.lottie.model.a.f(a(jsonReader, com.tb.airbnb.lottie.d.f.lb(), eVar, y.pKs));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.g i(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar) throws IOException {
        return new com.tb.airbnb.lottie.model.a.g(a(jsonReader, eVar, ac.pKt));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.h j(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar) throws IOException {
        return new com.tb.airbnb.lottie.model.a.h(a(jsonReader, com.tb.airbnb.lottie.d.f.lb(), eVar, ad.pKu));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.j k(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar) throws IOException {
        return new com.tb.airbnb.lottie.model.a.j(a(jsonReader, eVar, h.pKo));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.a l(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar) throws IOException {
        return new com.tb.airbnb.lottie.model.a.a(a(jsonReader, eVar, f.pKn));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.c a(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar, int i) throws IOException {
        return new com.tb.airbnb.lottie.model.a.c(a(jsonReader, eVar, new l(i)));
    }

    @Nullable
    private static <T> List<com.tb.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar, aj<T> ajVar) throws IOException {
        return r.a(jsonReader, eVar, 1.0f, ajVar);
    }

    @Nullable
    private static <T> List<com.tb.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, float f, com.tb.airbnb.lottie.e eVar, aj<T> ajVar) throws IOException {
        return r.a(jsonReader, eVar, f, ajVar);
    }
}
