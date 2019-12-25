package com.tb.airbnb.lottie.model.a;

import android.graphics.Path;
import com.tb.airbnb.lottie.model.a.n;
import com.tb.airbnb.lottie.model.content.h;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends o<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path mNU;

    private h(List<com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.content.h>> list, com.tb.airbnb.lottie.model.content.h hVar) {
        super(list, hVar);
        this.mNU = new Path();
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.h, Path> dBq() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(bD((com.tb.airbnb.lottie.model.content.h) this.mNB)) : new com.tb.airbnb.lottie.a.b.l(this.gD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.model.a.o
    /* renamed from: a */
    public Path bD(com.tb.airbnb.lottie.model.content.h hVar) {
        this.mNU.reset();
        com.tb.airbnb.lottie.c.e.a(hVar, this.mNU);
        return this.mNU;
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static h k(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            n.a dBK = n.a(jSONObject, eVar.dAZ(), eVar, h.a.mOI).dBK();
            return new h(dBK.gD, (com.tb.airbnb.lottie.model.content.h) dBK.mNB);
        }
    }
}
