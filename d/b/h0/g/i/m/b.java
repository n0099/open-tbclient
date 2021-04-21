package d.b.h0.g.i.m;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import d.b.h0.a.k;
import d.b.h0.g.c.f;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48912f = k.f45772a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f48913g;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f48914a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<ValueCallback<String>>> f48915b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f48918e = new Object();

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.g.w.b f48917d = d.b.h0.g.w.b.d();

    /* renamed from: c  reason: collision with root package name */
    public String f48916c = f.g();

    public static b e() {
        if (f48913g == null) {
            synchronized (b.class) {
                if (f48913g == null) {
                    f48913g = new b();
                }
            }
        }
        return f48913g;
    }

    @Override // d.b.h0.g.i.m.a
    public void a(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f48918e) {
            if (f(str) && (arrayList = this.f48915b.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (f48912f) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f48914a.remove(str);
            }
        }
    }

    public final void b(String str, ValueCallback<String> valueCallback) {
        if (this.f48915b.containsKey(str)) {
            this.f48915b.get(str).add(valueCallback);
            return;
        }
        ArrayList<ValueCallback<String>> arrayList = new ArrayList<>();
        arrayList.add(valueCallback);
        this.f48915b.put(str, arrayList);
    }

    public final void c(String str) {
        if (f48912f) {
            Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.f48917d, this.f48916c, str, this);
        this.f48914a.put(str, cVar);
        cVar.e();
    }

    public final String d(String str) throws MalformedURLException {
        return this.f48916c + f.d(str);
    }

    public final boolean f(String str) {
        return this.f48914a.containsKey(str);
    }

    @Override // d.b.h0.g.i.m.a
    public void fail(int i, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f48918e) {
            if (f(str) && (arrayList = this.f48915b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).onReceiveValue("");
                }
                this.f48914a.remove(str);
            }
        }
    }

    public void g(String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            valueCallback.onReceiveValue(null);
            return;
        }
        try {
            String d2 = d(str);
            File file = new File(d(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(d2);
                    return;
                }
                return;
            }
            synchronized (this.f48918e) {
                if (!f(str)) {
                    c(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e2) {
            if (f48912f) {
                e2.printStackTrace();
            }
        }
    }
}
