package d.a.m0.h.c.i;

import android.util.Log;
import d.a.m0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f50985f = k.f46983a;

    /* renamed from: c  reason: collision with root package name */
    public String f50988c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.h.y.b f50989d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f50986a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<a>> f50987b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f50990e = new Object();

    public b(String str) {
        this.f50988c = str;
    }

    @Override // d.a.m0.h.c.i.a
    public void a(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.f50990e) {
            if (d(str) && (arrayList = this.f50987b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).a(str, str2);
                    if (f50985f) {
                        Log.e("AudioDownloadManager", i2 + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f50986a.remove(str);
            }
        }
    }

    public final void b(String str, a aVar) {
        if (this.f50987b.containsKey(str)) {
            this.f50987b.get(str).add(aVar);
            return;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        this.f50987b.put(str, arrayList);
    }

    public void c(String str) {
        if (f50985f) {
            Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
        }
        if (this.f50989d == null) {
            this.f50989d = d.a.m0.h.y.b.d();
        }
        c cVar = new c(this.f50989d, this.f50988c, str, this);
        this.f50986a.put(str, cVar);
        cVar.e();
    }

    public final boolean d(String str) {
        return this.f50986a.containsKey(str);
    }

    public void e(String str, a aVar) {
        synchronized (this.f50990e) {
            if (!d(str)) {
                if (f50985f) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                c(str);
            } else if (f50985f) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    @Override // d.a.m0.h.c.i.a
    public void fail(int i2, String str) {
        ArrayList<a> arrayList;
        synchronized (this.f50990e) {
            if (d(str) && (arrayList = this.f50987b.get(str)) != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.get(i3).fail(i2, str);
                }
                this.f50986a.remove(str);
            }
        }
    }
}
