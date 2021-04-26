package d.a.h0.g.c.i;

import android.util.Log;
import d.a.h0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46149f = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public String f46152c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.g.w.b f46153d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f46150a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<a>> f46151b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f46154e = new Object();

    public b(String str) {
        this.f46152c = str;
    }

    @Override // d.a.h0.g.c.i.a
    public void a(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.f46154e) {
            if (d(str) && (arrayList = this.f46151b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).a(str, str2);
                    if (f46149f) {
                        Log.e("AudioDownloadManager", i2 + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f46150a.remove(str);
            }
        }
    }

    public final void b(String str, a aVar) {
        if (this.f46151b.containsKey(str)) {
            this.f46151b.get(str).add(aVar);
            return;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        this.f46151b.put(str, arrayList);
    }

    public void c(String str) {
        if (f46149f) {
            Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
        }
        if (this.f46153d == null) {
            this.f46153d = d.a.h0.g.w.b.d();
        }
        c cVar = new c(this.f46153d, this.f46152c, str, this);
        this.f46150a.put(str, cVar);
        cVar.e();
    }

    public final boolean d(String str) {
        return this.f46150a.containsKey(str);
    }

    public void e(String str, a aVar) {
        synchronized (this.f46154e) {
            if (!d(str)) {
                if (f46149f) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                c(str);
            } else if (f46149f) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    @Override // d.a.h0.g.c.i.a
    public void fail(int i2, String str) {
        ArrayList<a> arrayList;
        synchronized (this.f46154e) {
            if (d(str) && (arrayList = this.f46151b.get(str)) != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.get(i3).fail(i2, str);
                }
                this.f46150a.remove(str);
            }
        }
    }
}
