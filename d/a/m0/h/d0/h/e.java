package d.a.m0.h.d0.h;

import android.util.Log;
import d.a.m0.a.k;
import d.a.m0.a.v2.q;
import d.a.m0.h.d0.h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f51081e = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.m0.h.d0.h.a> f51082a;

    /* renamed from: b  reason: collision with root package name */
    public String f51083b;

    /* renamed from: c  reason: collision with root package name */
    public String f51084c;

    /* renamed from: d  reason: collision with root package name */
    public int f51085d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f51086e;

        public a(c cVar) {
            this.f51086e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<long[]> e2 = e.this.e();
            d dVar = new d();
            dVar.f51078a = e.this.f51083b;
            dVar.f51079b = e2;
            dVar.f51080c = e.this.f51084c;
            d.a.m0.h.t.a.h().b(dVar, this.f51086e);
        }
    }

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (f51081e) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        ArrayList<d.a.m0.h.d0.h.a> d2 = d(arrayList);
        this.f51082a = d2;
        this.f51083b = str;
        this.f51084c = str2;
        this.f51085d = d2.size();
    }

    public void c(c cVar) {
        if (cVar == null) {
            return;
        }
        q.k(new a(cVar), "clipVideo");
    }

    public final ArrayList<d.a.m0.h.d0.h.a> d(ArrayList<b> arrayList) {
        d.a.m0.h.d0.h.a a2;
        ArrayList<d.a.m0.h.d0.h.a> arrayList2 = new ArrayList<>();
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
        if (this.f51085d == 0) {
            return arrayList;
        }
        if (f51081e) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.f51082a);
        }
        Collections.sort(this.f51082a, new a.C1079a());
        d.a.m0.h.d0.h.a aVar = this.f51082a.get(0);
        for (int i2 = 1; i2 < this.f51085d; i2++) {
            d.a.m0.h.d0.h.a aVar2 = this.f51082a.get(i2);
            if (!aVar.b(aVar2)) {
                arrayList.add(d.a.m0.h.d0.h.a.a(aVar));
                aVar = aVar2;
            }
        }
        arrayList.add(d.a.m0.h.d0.h.a.a(aVar));
        if (f51081e) {
            Log.d("ClipVideoTask", "mergeRange mergeList = " + arrayList);
        }
        return arrayList;
    }
}
