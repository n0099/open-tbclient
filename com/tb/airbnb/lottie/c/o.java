package com.tb.airbnb.lottie.c;

import android.util.JsonReader;
import java.io.IOException;
/* loaded from: classes6.dex */
public class o implements aj<Integer> {
    public static final o nkB = new o();

    private o() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.c.aj
    /* renamed from: a */
    public Integer b(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(p.c(jsonReader) * f));
    }
}
