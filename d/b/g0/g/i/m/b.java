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
    public static final boolean f48190f = k.f45050a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f48191g;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f48192a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<ValueCallback<String>>> f48193b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f48196e = new Object();

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.g.w.b f48195d = d.b.g0.g.w.b.d();

    /* renamed from: c  reason: collision with root package name */
    public String f48194c = f.g();

    public static b e() {
        if (f48191g == null) {
            synchronized (b.class) {
                if (f48191g == null) {
                    f48191g = new b();
                }
            }
        }
        return f48191g;
    }

    @Override // d.b.g0.g.i.m.a
    public void a(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f48196e) {
            if (f(str) && (arrayList = this.f48193b.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (f48190f) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f48192a.remove(str);
            }
        }
    }

    public final void b(String str, ValueCallback<String> valueCallback) {
        if (this.f48193b.containsKey(str)) {
            this.f48193b.get(str).add(valueCallback);
            return;
        }
        ArrayList<ValueCallback<String>> arrayList = new ArrayList<>();
        arrayList.add(valueCallback);
        this.f48193b.put(str, arrayList);
    }

    public final void c(String str) {
        if (f48190f) {
            Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.f48195d, this.f48194c, str, this);
        this.f48192a.put(str, cVar);
        cVar.e();
    }

    public final String d(String str) throws MalformedURLException {
        return this.f48194c + f.d(str);
    }

    public final boolean f(String str) {
        return this.f48192a.containsKey(str);
    }

    @Override // d.b.g0.g.i.m.a
    public void fail(int i, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f48196e) {
            if (f(str) && (arrayList = this.f48193b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).onReceiveValue("");
                }
                this.f48192a.remove(str);
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
            synchronized (this.f48196e) {
                if (!f(str)) {
                    c(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e2) {
            if (f48190f) {
                e2.printStackTrace();
            }
        }
    }
}
