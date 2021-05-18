package d.a.i0.h.c.i;

import android.util.Log;
import d.a.i0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47027f = k.f43025a;

    /* renamed from: c  reason: collision with root package name */
    public String f47030c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.h.y.b f47031d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f47028a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<a>> f47029b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f47032e = new Object();

    public b(String str) {
        this.f47030c = str;
    }

    @Override // d.a.i0.h.c.i.a
    public void a(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.f47032e) {
            if (d(str) && (arrayList = this.f47029b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).a(str, str2);
                    if (f47027f) {
                        Log.e("AudioDownloadManager", i2 + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f47028a.remove(str);
            }
        }
    }

    public final void b(String str, a aVar) {
        if (this.f47029b.containsKey(str)) {
            this.f47029b.get(str).add(aVar);
            return;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        this.f47029b.put(str, arrayList);
    }

    public void c(String str) {
        if (f47027f) {
            Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
        }
        if (this.f47031d == null) {
            this.f47031d = d.a.i0.h.y.b.d();
        }
        c cVar = new c(this.f47031d, this.f47030c, str, this);
        this.f47028a.put(str, cVar);
        cVar.e();
    }

    public final boolean d(String str) {
        return this.f47028a.containsKey(str);
    }

    public void e(String str, a aVar) {
        synchronized (this.f47032e) {
            if (!d(str)) {
                if (f47027f) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                c(str);
            } else if (f47027f) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    @Override // d.a.i0.h.c.i.a
    public void fail(int i2, String str) {
        ArrayList<a> arrayList;
        synchronized (this.f47032e) {
            if (d(str) && (arrayList = this.f47029b.get(str)) != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.get(i3).fail(i2, str);
                }
                this.f47028a.remove(str);
            }
        }
    }
}
