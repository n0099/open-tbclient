package d.a.i0.h.d0.h;

import android.util.Log;
import d.a.i0.a.k;
import d.a.i0.a.v2.q;
import d.a.i0.h.d0.h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47123e = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.i0.h.d0.h.a> f47124a;

    /* renamed from: b  reason: collision with root package name */
    public String f47125b;

    /* renamed from: c  reason: collision with root package name */
    public String f47126c;

    /* renamed from: d  reason: collision with root package name */
    public int f47127d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47128e;

        public a(c cVar) {
            this.f47128e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<long[]> e2 = e.this.e();
            d dVar = new d();
            dVar.f47120a = e.this.f47125b;
            dVar.f47121b = e2;
            dVar.f47122c = e.this.f47126c;
            d.a.i0.h.t.a.h().b(dVar, this.f47128e);
        }
    }

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (f47123e) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        ArrayList<d.a.i0.h.d0.h.a> d2 = d(arrayList);
        this.f47124a = d2;
        this.f47125b = str;
        this.f47126c = str2;
        this.f47127d = d2.size();
    }

    public void c(c cVar) {
        if (cVar == null) {
            return;
        }
        q.k(new a(cVar), "clipVideo");
    }

    public final ArrayList<d.a.i0.h.d0.h.a> d(ArrayList<b> arrayList) {
        d.a.i0.h.d0.h.a a2;
        ArrayList<d.a.i0.h.d0.h.a> arrayList2 = new ArrayList<>();
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
        if (this.f47127d == 0) {
            return arrayList;
        }
        if (f47123e) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.f47124a);
        }
        Collections.sort(this.f47124a, new a.C1009a());
        d.a.i0.h.d0.h.a aVar = this.f47124a.get(0);
        for (int i2 = 1; i2 < this.f47127d; i2++) {
            d.a.i0.h.d0.h.a aVar2 = this.f47124a.get(i2);
            if (!aVar.b(aVar2)) {
                arrayList.add(d.a.i0.h.d0.h.a.a(aVar));
                aVar = aVar2;
            }
        }
        arrayList.add(d.a.i0.h.d0.h.a.a(aVar));
        if (f47123e) {
            Log.d("ClipVideoTask", "mergeRange mergeList = " + arrayList);
        }
        return arrayList;
    }
}
