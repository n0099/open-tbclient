package com.tb.airbnb.lottie;

import android.support.v4.util.ArraySet;
import android.support.v4.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes16.dex */
public class m {
    private boolean enabled = false;
    private final Set<a> CC = new ArraySet();
    private final Map<String, com.tb.airbnb.lottie.d.d> CD = new HashMap();
    private final Comparator<Pair<String, Float>> CE = new Comparator<Pair<String, Float>>() { // from class: com.tb.airbnb.lottie.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.second.floatValue();
            float floatValue2 = pair2.second.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            if (floatValue > floatValue2) {
                return -1;
            }
            return 0;
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void h(float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void b(String str, float f) {
        if (this.enabled) {
            com.tb.airbnb.lottie.d.d dVar = this.CD.get(str);
            if (dVar == null) {
                dVar = new com.tb.airbnb.lottie.d.d();
                this.CD.put(str, dVar);
            }
            dVar.add(f);
            if (str.equals("__container")) {
                for (a aVar : this.CC) {
                    aVar.h(f);
                }
            }
        }
    }
}
