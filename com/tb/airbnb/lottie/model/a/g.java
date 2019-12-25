package com.tb.airbnb.lottie.model.a;

import com.tb.airbnb.lottie.model.a.n;
import com.tb.airbnb.lottie.model.k;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends o<com.tb.airbnb.lottie.model.k, com.tb.airbnb.lottie.model.k> {
    private g() {
        super(new com.tb.airbnb.lottie.model.k());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(List<com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.k>> list, com.tb.airbnb.lottie.model.k kVar) {
        super(list, kVar);
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.k, com.tb.airbnb.lottie.model.k> dBq() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(this.mNB) : new com.tb.airbnb.lottie.a.b.k(this.gD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static g j(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            n.a dBK = n.a(jSONObject, 1.0f, eVar, k.a.mNQ).dBK();
            return new g(dBK.gD, (com.tb.airbnb.lottie.model.k) dBK.mNB);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static g dBy() {
            return new g();
        }
    }
}
