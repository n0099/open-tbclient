package d.b.g0.g.a0.h;

import android.util.Log;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.g.a0.h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47872e = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.b.g0.g.a0.h.a> f47873a;

    /* renamed from: b  reason: collision with root package name */
    public String f47874b;

    /* renamed from: c  reason: collision with root package name */
    public String f47875c;

    /* renamed from: d  reason: collision with root package name */
    public int f47876d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47877e;

        public a(c cVar) {
            this.f47877e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<long[]> e2 = e.this.e();
            d dVar = new d();
            dVar.f47869a = e.this.f47874b;
            dVar.f47870b = e2;
            dVar.f47871c = e.this.f47875c;
            d.b.g0.g.r.a.e().b(dVar, this.f47877e);
        }
    }

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (f47872e) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        ArrayList<d.b.g0.g.a0.h.a> d2 = d(arrayList);
        this.f47873a = d2;
        this.f47874b = str;
        this.f47875c = str2;
        this.f47876d = d2.size();
    }

    public void c(c cVar) {
        if (cVar == null) {
            return;
        }
        p.l(new a(cVar), "clipVideo");
    }

    public final ArrayList<d.b.g0.g.a0.h.a> d(ArrayList<b> arrayList) {
        d.b.g0.g.a0.h.a a2;
        ArrayList<d.b.g0.g.a0.h.a> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && (a2 = next.a()) != null) {
                    arrayList2.add(a2);
                }
            }
        }
        return arrayList2;
    }

    public ArrayList<long[]> e() {
        ArrayList<long[]> arrayList = new ArrayList<>();
        if (this.f47876d == 0) {
            return arrayList;
        }
        if (f47872e) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.f47873a);
        }
        Collections.sort(this.f47873a, new a.C0948a());
        d.b.g0.g.a0.h.a aVar = this.f47873a.get(0);
        for (int i = 1; i < this.f47876d; i++) {
            d.b.g0.g.a0.h.a aVar2 = this.f47873a.get(i);
            if (!aVar.b(aVar2)) {
                arrayList.add(d.b.g0.g.a0.h.a.a(aVar));
                aVar = aVar2;
            }
        }
        arrayList.add(d.b.g0.g.a0.h.a.a(aVar));
        if (f47872e) {
            Log.d("ClipVideoTask", "mergeRange mergeList = " + arrayList);
        }
        return arrayList;
    }
}
