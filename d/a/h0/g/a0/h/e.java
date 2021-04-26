package d.a.h0.g.a0.h;

import android.util.Log;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
import d.a.h0.g.a0.h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46055e = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.h0.g.a0.h.a> f46056a;

    /* renamed from: b  reason: collision with root package name */
    public String f46057b;

    /* renamed from: c  reason: collision with root package name */
    public String f46058c;

    /* renamed from: d  reason: collision with root package name */
    public int f46059d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f46060e;

        public a(c cVar) {
            this.f46060e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<long[]> e2 = e.this.e();
            d dVar = new d();
            dVar.f46052a = e.this.f46057b;
            dVar.f46053b = e2;
            dVar.f46054c = e.this.f46058c;
            d.a.h0.g.r.a.e().b(dVar, this.f46060e);
        }
    }

    public e(ArrayList<b> arrayList, String str, String str2) {
        if (f46055e) {
            Log.d("ClipVideoTask", "videoPath=" + str + "clipList=" + arrayList);
        }
        ArrayList<d.a.h0.g.a0.h.a> d2 = d(arrayList);
        this.f46056a = d2;
        this.f46057b = str;
        this.f46058c = str2;
        this.f46059d = d2.size();
    }

    public void c(c cVar) {
        if (cVar == null) {
            return;
        }
        p.l(new a(cVar), "clipVideo");
    }

    public final ArrayList<d.a.h0.g.a0.h.a> d(ArrayList<b> arrayList) {
        d.a.h0.g.a0.h.a a2;
        ArrayList<d.a.h0.g.a0.h.a> arrayList2 = new ArrayList<>();
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
        if (this.f46059d == 0) {
            return arrayList;
        }
        if (f46055e) {
            Log.d("ClipVideoTask", "mergeRange mRangeList = " + this.f46056a);
        }
        Collections.sort(this.f46056a, new a.C0919a());
        d.a.h0.g.a0.h.a aVar = this.f46056a.get(0);
        for (int i2 = 1; i2 < this.f46059d; i2++) {
            d.a.h0.g.a0.h.a aVar2 = this.f46056a.get(i2);
            if (!aVar.b(aVar2)) {
                arrayList.add(d.a.h0.g.a0.h.a.a(aVar));
                aVar = aVar2;
            }
        }
        arrayList.add(d.a.h0.g.a0.h.a.a(aVar));
        if (f46055e) {
            Log.d("ClipVideoTask", "mergeRange mergeList = " + arrayList);
        }
        return arrayList;
    }
}
