package com.tb.airbnb.lottie.model.a;

import com.tb.airbnb.lottie.model.a.n;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends o<Integer, Integer> {
    private a(List<com.tb.airbnb.lottie.a.a<Integer>> list, Integer num) {
        super(list, num);
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<Integer, Integer> dBq() {
        return !hasAnimation() ? new com.tb.airbnb.lottie.a.b.n(this.mNB) : new com.tb.airbnb.lottie.a.b.b(this.gD);
    }

    @Override // com.tb.airbnb.lottie.model.a.o
    public String toString() {
        return "AnimatableColorValue{initialValue=" + this.mNB + '}';
    }

    /* renamed from: com.tb.airbnb.lottie.model.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0688a {
        public static a d(JSONObject jSONObject, com.tb.airbnb.lottie.e eVar) {
            n.a dBK = n.a(jSONObject, 1.0f, eVar, com.tb.airbnb.lottie.model.a.mNN).dBK();
            return new a(dBK.gD, (Integer) dBK.mNB);
        }
    }
}
