package com.tb.airbnb.lottie.model.a;

import android.graphics.Path;
import com.tb.airbnb.lottie.model.a.n;
import com.tb.airbnb.lottie.model.content.h;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h extends o<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path gz;

    private h(List<com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.content.h>> list, com.tb.airbnb.lottie.model.content.h hVar) {
        super(list, hVar);
        this.gz = new Path();
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<com.tb.airbnb.lottie.model.content.h, Path> cLn() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(k((com.tb.airbnb.lottie.model.content.h) this.fI)) : new com.tb.airbnb.lottie.a.b.l(this.fu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.model.a.o
    /* renamed from: a */
    public Path k(com.tb.airbnb.lottie.model.content.h hVar) {
        this.gz.reset();
        com.tb.airbnb.lottie.c.e.a(hVar, this.gz);
        return this.gz;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static h k(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            n.a cLE = n.a(jSONObject, eVar.bb(), eVar, h.a.kuG).cLE();
            return new h(cLE.fu, (com.tb.airbnb.lottie.model.content.h) cLE.fI);
        }
    }
}
