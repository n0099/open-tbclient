package com.ksad.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public boolean f31826a = false;

    /* renamed from: b  reason: collision with root package name */
    public final Set<a> f31827b = new ArraySet();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, com.ksad.lottie.d.d> f31828c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Comparator<Pair<String, Float>> f31829d = new Comparator<Pair<String, Float>>() { // from class: com.ksad.lottie.l.1
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

    /* loaded from: classes6.dex */
    public interface a {
        void a(float f2);
    }

    public void a(String str, float f2) {
        if (this.f31826a) {
            com.ksad.lottie.d.d dVar = this.f31828c.get(str);
            if (dVar == null) {
                dVar = new com.ksad.lottie.d.d();
                this.f31828c.put(str, dVar);
            }
            dVar.a(f2);
            if (str.equals("__container")) {
                for (a aVar : this.f31827b) {
                    aVar.a(f2);
                }
            }
        }
    }

    public void a(boolean z) {
        this.f31826a = z;
    }
}
