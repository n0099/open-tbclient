package d.b.h0.g.c.i;

import android.util.Log;
import d.b.h0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48683f = k.f45772a;

    /* renamed from: c  reason: collision with root package name */
    public String f48686c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.g.w.b f48687d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f48684a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<a>> f48685b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f48688e = new Object();

    public b(String str) {
        this.f48686c = str;
    }

    @Override // d.b.h0.g.c.i.a
    public void a(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.f48688e) {
            if (d(str) && (arrayList = this.f48685b.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).a(str, str2);
                    if (f48683f) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f48684a.remove(str);
            }
        }
    }

    public final void b(String str, a aVar) {
        if (this.f48685b.containsKey(str)) {
            this.f48685b.get(str).add(aVar);
            return;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        this.f48685b.put(str, arrayList);
    }

    public void c(String str) {
        if (f48683f) {
            Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
        }
        if (this.f48687d == null) {
            this.f48687d = d.b.h0.g.w.b.d();
        }
        c cVar = new c(this.f48687d, this.f48686c, str, this);
        this.f48684a.put(str, cVar);
        cVar.e();
    }

    public final boolean d(String str) {
        return this.f48684a.containsKey(str);
    }

    public void e(String str, a aVar) {
        synchronized (this.f48688e) {
            if (!d(str)) {
                if (f48683f) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                c(str);
            } else if (f48683f) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    @Override // d.b.h0.g.c.i.a
    public void fail(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.f48688e) {
            if (d(str) && (arrayList = this.f48685b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).fail(i, str);
                }
                this.f48684a.remove(str);
            }
        }
    }
}
