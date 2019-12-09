package com.tb.airbnb.lottie.model.a;

import com.tb.airbnb.lottie.model.a.n;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends o<Integer, Integer> {
    private a(List<com.tb.airbnb.lottie.a.a<Integer>> list, Integer num) {
        super(list, num);
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<Integer, Integer> cLl() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(this.fg) : new com.tb.airbnb.lottie.a.b.b(this.eR);
    }

    @Override // com.tb.airbnb.lottie.model.a.o
    public String toString() {
        return "AnimatableColorValue{initialValue=" + this.fg + '}';
    }

    /* renamed from: com.tb.airbnb.lottie.model.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0573a {
        public static a d(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            n.a cLC = n.a(jSONObject, 1.0f, eVar, com.tb.airbnb.lottie.model.a.ksX).cLC();
            return new a(cLC.eR, (Integer) cLC.fg);
        }
    }
}
