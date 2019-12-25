package com.tb.airbnb.lottie.model.a;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a;
import com.tb.airbnb.lottie.model.a.m;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n<T> {
    private final com.tb.airbnb.lottie.e composition;
    @Nullable
    private final JSONObject mOj;
    private final m.a<T> mOk;
    private final float scale;

    private n(@Nullable JSONObject jSONObject, float f, com.tb.airbnb.lottie.e eVar, m.a<T> aVar) {
        this.mOj = jSONObject;
        this.scale = f;
        this.composition = eVar;
        this.mOk = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> n<T> a(@Nullable JSONObject jSONObject, float f, com.tb.airbnb.lottie.e eVar, m.a<T> aVar) {
        return new n<>(jSONObject, f, eVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a<T> dBK() {
        List<com.tb.airbnb.lottie.a.a<T>> dBL = dBL();
        return new a<>(dBL, fw(dBL));
    }

    private List<com.tb.airbnb.lottie.a.a<T>> dBL() {
        if (this.mOj != null) {
            Object opt = this.mOj.opt("k");
            if (bC(opt)) {
                return a.C0685a.a((JSONArray) opt, this.composition, this.scale, this.mOk);
            }
            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    @Nullable
    private T fw(List<com.tb.airbnb.lottie.a.a<T>> list) {
        if (this.mOj != null) {
            if (!list.isEmpty()) {
                return list.get(0).kn;
            }
            return this.mOk.c(this.mOj.opt("k"), this.scale);
        }
        return null;
    }

    private static boolean bC(Object obj) {
        if (obj instanceof JSONArray) {
            Object opt = ((JSONArray) obj).opt(0);
            return (opt instanceof JSONObject) && ((JSONObject) opt).has("t");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> {
        final List<com.tb.airbnb.lottie.a.a<T>> gD;
        @Nullable
        final T mNB;

        a(List<com.tb.airbnb.lottie.a.a<T>> list, @Nullable T t) {
            this.gD = list;
            this.mNB = t;
        }
    }
}
