package com.ksad.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private boolean f5369a = false;
    private final Set<a> b = new ArraySet();
    private final Map<String, com.ksad.lottie.d.d> c = new HashMap();
    private final Comparator<Pair<String, Float>> d = new Comparator<Pair<String, Float>>() { // from class: com.ksad.lottie.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.second.floatValue();
            float floatValue2 = pair2.second.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(float f);
    }

    public void a(String str, float f) {
        if (this.f5369a) {
            com.ksad.lottie.d.d dVar = this.c.get(str);
            if (dVar == null) {
                dVar = new com.ksad.lottie.d.d();
                this.c.put(str, dVar);
            }
            dVar.a(f);
            if (str.equals("__container")) {
                for (a aVar : this.b) {
                    aVar.a(f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f5369a = z;
    }
}
