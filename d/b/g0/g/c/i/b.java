package d.b.g0.g.c.i;

import android.util.Log;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47961f = k.f45050a;

    /* renamed from: c  reason: collision with root package name */
    public String f47964c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.g.w.b f47965d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f47962a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<a>> f47963b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f47966e = new Object();

    public b(String str) {
        this.f47964c = str;
    }

    @Override // d.b.g0.g.c.i.a
    public void a(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.f47966e) {
            if (d(str) && (arrayList = this.f47963b.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).a(str, str2);
                    if (f47961f) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f47962a.remove(str);
            }
        }
    }

    public final void b(String str, a aVar) {
        if (this.f47963b.containsKey(str)) {
            this.f47963b.get(str).add(aVar);
            return;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        this.f47963b.put(str, arrayList);
    }

    public void c(String str) {
        if (f47961f) {
            Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
        }
        if (this.f47965d == null) {
            this.f47965d = d.b.g0.g.w.b.d();
        }
        c cVar = new c(this.f47965d, this.f47964c, str, this);
        this.f47962a.put(str, cVar);
        cVar.e();
    }

    public final boolean d(String str) {
        return this.f47962a.containsKey(str);
    }

    public void e(String str, a aVar) {
        synchronized (this.f47966e) {
            if (!d(str)) {
                if (f47961f) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                c(str);
            } else if (f47961f) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    @Override // d.b.g0.g.c.i.a
    public void fail(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.f47966e) {
            if (d(str) && (arrayList = this.f47963b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).fail(i, str);
                }
                this.f47962a.remove(str);
            }
        }
    }
}
