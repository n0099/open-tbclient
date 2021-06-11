package d.a.l0.h.d0.h;

import android.util.Log;
import d.a.l0.a.k;
import d.a.l0.a.v2.q;
import d.a.l0.h.d0.h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f50973e = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.l0.h.d0.h.a> f50974a;

    /* renamed from: b  reason: collision with root package name */
    public String f50975b;

    /* renamed from: c  reason: collision with root package name */
    public String f50976c;

    /* renamed from: d  reason: collision with root package name */
    public int f50977d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f50978e;

        public a(c cVar) {
            this.f50978e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<long[]> e2 = e.this.e();
            d dVar = new d();
            dVar.f50970a = e.this.f50975b;
            dVar.f50971b = e2;
            dVar.f50972c = e.this.f50976c;
            d.a.l0.h.t.a.h().b(dVar, this.f50978e);
        }
    }

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (f50973e) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        ArrayList<d.a.l0.h.d0.h.a> d2 = d(arrayList);
        this.f50974a = d2;
        this.f50975b = str;
        this.f50976c = str2;
        this.f50977d = d2.size();
    }

    public void c(c cVar) {
        if (cVar == null) {
            return;
        }
        q.k(new a(cVar), "clipVideo");
    }

    public final ArrayList<d.a.l0.h.d0.h.a> d(ArrayList<b> arrayList) {
        d.a.l0.h.d0.h.a a2;
        ArrayList<d.a.l0.h.d0.h.a> arrayList2 = new ArrayList<>();
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
        if (this.f50977d == 0) {
            return arrayList;
        }
        if (f50973e) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.f50974a);
        }
        Collections.sort(this.f50974a, new a.C1076a());
        d.a.l0.h.d0.h.a aVar = this.f50974a.get(0);
        for (int i2 = 1; i2 < this.f50977d; i2++) {
            d.a.l0.h.d0.h.a aVar2 = this.f50974a.get(i2);
            if (!aVar.b(aVar2)) {
                arrayList.add(d.a.l0.h.d0.h.a.a(aVar));
                aVar = aVar2;
            }
        }
        arrayList.add(d.a.l0.h.d0.h.a.a(aVar));
        if (f50973e) {
            Log.d("ClipVideoTask", "mergeRange mergeList = " + arrayList);
        }
        return arrayList;
    }
}
