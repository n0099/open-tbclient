package d.a.l0.h.c.i;

import android.util.Log;
import d.a.l0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f50877f = k.f46875a;

    /* renamed from: c  reason: collision with root package name */
    public String f50880c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.h.y.b f50881d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f50878a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<a>> f50879b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f50882e = new Object();

    public b(String str) {
        this.f50880c = str;
    }

    @Override // d.a.l0.h.c.i.a
    public void a(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.f50882e) {
            if (d(str) && (arrayList = this.f50879b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).a(str, str2);
                    if (f50877f) {
                        Log.e("AudioDownloadManager", i2 + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f50878a.remove(str);
            }
        }
    }

    public final void b(String str, a aVar) {
        if (this.f50879b.containsKey(str)) {
            this.f50879b.get(str).add(aVar);
            return;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        this.f50879b.put(str, arrayList);
    }

    public void c(String str) {
        if (f50877f) {
            Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
        }
        if (this.f50881d == null) {
            this.f50881d = d.a.l0.h.y.b.d();
        }
        c cVar = new c(this.f50881d, this.f50880c, str, this);
        this.f50878a.put(str, cVar);
        cVar.e();
    }

    public final boolean d(String str) {
        return this.f50878a.containsKey(str);
    }

    public void e(String str, a aVar) {
        synchronized (this.f50882e) {
            if (!d(str)) {
                if (f50877f) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                c(str);
            } else if (f50877f) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    @Override // d.a.l0.h.c.i.a
    public void fail(int i2, String str) {
        ArrayList<a> arrayList;
        synchronized (this.f50882e) {
            if (d(str) && (arrayList = this.f50879b.get(str)) != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.get(i3).fail(i2, str);
                }
                this.f50878a.remove(str);
            }
        }
    }
}
