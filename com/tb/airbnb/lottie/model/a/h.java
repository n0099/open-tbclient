package com.tb.airbnb.lottie.model.a;

import android.graphics.Path;
import com.tb.airbnb.lottie.model.a.n;
import com.tb.airbnb.lottie.model.content.h;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h extends o<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path ga;

    private h(List<com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.content.h>> list, com.tb.airbnb.lottie.model.content.h hVar) {
        super(list, hVar);
        this.ga = new Path();
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.h, Path> cLl() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(k((com.tb.airbnb.lottie.model.content.h) this.fg)) : new com.tb.airbnb.lottie.a.b.l(this.eR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.model.a.o
    /* renamed from: a */
    public Path k(com.tb.airbnb.lottie.model.content.h hVar) {
        this.ga.reset();
        com.tb.airbnb.lottie.c.e.a(hVar, this.ga);
        return this.ga;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static h k(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            n.a cLC = n.a(jSONObject, eVar.bb(), eVar, h.a.ktP).cLC();
            return new h(cLC.eR, (com.tb.airbnb.lottie.model.content.h) cLC.fg);
        }
    }
}
