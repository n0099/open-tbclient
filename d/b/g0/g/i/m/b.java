package d.b.g0.g.i.m;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import d.b.g0.a.k;
import d.b.g0.g.c.f;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48583f = k.f45443a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f48584g;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f48585a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<ValueCallback<String>>> f48586b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f48589e = new Object();

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.g.w.b f48588d = d.b.g0.g.w.b.d();

    /* renamed from: c  reason: collision with root package name */
    public String f48587c = f.g();

    public static b e() {
        if (f48584g == null) {
            synchronized (b.class) {
                if (f48584g == null) {
                    f48584g = new b();
                }
            }
        }
        return f48584g;
    }

    @Override // d.b.g0.g.i.m.a
    public void a(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f48589e) {
            if (f(str) && (arrayList = this.f48586b.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (f48583f) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f48585a.remove(str);
            }
        }
    }

    public final void b(String str, ValueCallback<String> valueCallback) {
        if (this.f48586b.containsKey(str)) {
            this.f48586b.get(str).add(valueCallback);
            return;
        }
        ArrayList<ValueCallback<String>> arrayList = new ArrayList<>();
        arrayList.add(valueCallback);
        this.f48586b.put(str, arrayList);
    }

    public final void c(String str) {
        if (f48583f) {
            Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.f48588d, this.f48587c, str, this);
        this.f48585a.put(str, cVar);
        cVar.e();
    }

    public final String d(String str) throws MalformedURLException {
        return this.f48587c + f.d(str);
    }

    public final boolean f(String str) {
        return this.f48585a.containsKey(str);
    }

    @Override // d.b.g0.g.i.m.a
    public void fail(int i, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f48589e) {
            if (f(str) && (arrayList = this.f48586b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).onReceiveValue("");
                }
                this.f48585a.remove(str);
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
            synchronized (this.f48589e) {
                if (!f(str)) {
                    c(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e2) {
            if (f48583f) {
                e2.printStackTrace();
            }
        }
    }
}
