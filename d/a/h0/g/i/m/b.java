package d.a.h0.g.i.m;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import d.a.h0.a.k;
import d.a.h0.g.c.f;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46386f = k.f43101a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f46387g;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f46388a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<ValueCallback<String>>> f46389b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f46392e = new Object();

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.g.w.b f46391d = d.a.h0.g.w.b.d();

    /* renamed from: c  reason: collision with root package name */
    public String f46390c = f.g();

    public static b e() {
        if (f46387g == null) {
            synchronized (b.class) {
                if (f46387g == null) {
                    f46387g = new b();
                }
            }
        }
        return f46387g;
    }

    @Override // d.a.h0.g.i.m.a
    public void a(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f46392e) {
            if (f(str) && (arrayList = this.f46389b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).onReceiveValue(str2);
                    if (f46386f) {
                        Log.e("ImageDownloadManager", i2 + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f46388a.remove(str);
            }
        }
    }

    public final void b(String str, ValueCallback<String> valueCallback) {
        if (this.f46389b.containsKey(str)) {
            this.f46389b.get(str).add(valueCallback);
            return;
        }
        ArrayList<ValueCallback<String>> arrayList = new ArrayList<>();
        arrayList.add(valueCallback);
        this.f46389b.put(str, arrayList);
    }

    public final void c(String str) {
        if (f46386f) {
            Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.f46391d, this.f46390c, str, this);
        this.f46388a.put(str, cVar);
        cVar.e();
    }

    public final String d(String str) throws MalformedURLException {
        return this.f46390c + f.d(str);
    }

    public final boolean f(String str) {
        return this.f46388a.containsKey(str);
    }

    @Override // d.a.h0.g.i.m.a
    public void fail(int i2, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f46392e) {
            if (f(str) && (arrayList = this.f46389b.get(str)) != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.get(i3).onReceiveValue("");
                }
                this.f46388a.remove(str);
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
            synchronized (this.f46392e) {
                if (!f(str)) {
                    c(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e2) {
            if (f46386f) {
                e2.printStackTrace();
            }
        }
    }
}
