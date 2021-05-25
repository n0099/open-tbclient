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
    public static final boolean f47299e = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.l0.h.d0.h.a> f47300a;

    /* renamed from: b  reason: collision with root package name */
    public String f47301b;

    /* renamed from: c  reason: collision with root package name */
    public String f47302c;

    /* renamed from: d  reason: collision with root package name */
    public int f47303d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47304e;

        public a(c cVar) {
            this.f47304e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<long[]> e2 = e.this.e();
            d dVar = new d();
            dVar.f47296a = e.this.f47301b;
            dVar.f47297b = e2;
            dVar.f47298c = e.this.f47302c;
            d.a.l0.h.t.a.h().b(dVar, this.f47304e);
        }
    }

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (f47299e) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        ArrayList<d.a.l0.h.d0.h.a> d2 = d(arrayList);
        this.f47300a = d2;
        this.f47301b = str;
        this.f47302c = str2;
        this.f47303d = d2.size();
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
        if (this.f47303d == 0) {
            return arrayList;
        }
        if (f47299e) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.f47300a);
        }
        Collections.sort(this.f47300a, new a.C1020a());
        d.a.l0.h.d0.h.a aVar = this.f47300a.get(0);
        for (int i2 = 1; i2 < this.f47303d; i2++) {
            d.a.l0.h.d0.h.a aVar2 = this.f47300a.get(i2);
            if (!aVar.b(aVar2)) {
                arrayList.add(d.a.l0.h.d0.h.a.a(aVar));
                aVar = aVar2;
            }
        }
        arrayList.add(d.a.l0.h.d0.h.a.a(aVar));
        if (f47299e) {
            Log.d("ClipVideoTask", "mergeRange mergeList = " + arrayList);
        }
        return arrayList;
    }
}
