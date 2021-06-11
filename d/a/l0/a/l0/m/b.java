package d.a.l0.a.l0.m;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.searchbox.http.HttpManager;
import d.a.l0.a.k;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46999f = k.f46875a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f47000g;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f47001a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<ValueCallback<String>>> f47002b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f47005e = new Object();

    /* renamed from: d  reason: collision with root package name */
    public HttpManager f47004d = d.a.l0.a.c1.b.l().b();

    /* renamed from: c  reason: collision with root package name */
    public String f47003c = d.a.l0.a.c1.b.f().a();

    public static b e() {
        if (f47000g == null) {
            synchronized (b.class) {
                if (f47000g == null) {
                    f47000g = new b();
                }
            }
        }
        return f47000g;
    }

    @Override // d.a.l0.a.l0.m.a
    public void a(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f47005e) {
            if (f(str) && (arrayList = this.f47002b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).onReceiveValue(str2);
                    if (f46999f) {
                        Log.e("ImageDownloadManager", i2 + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f47001a.remove(str);
            }
        }
    }

    public final void b(String str, ValueCallback<String> valueCallback) {
        if (this.f47002b.containsKey(str)) {
            this.f47002b.get(str).add(valueCallback);
            return;
        }
        ArrayList<ValueCallback<String>> arrayList = new ArrayList<>();
        arrayList.add(valueCallback);
        this.f47002b.put(str, arrayList);
    }

    public final void c(String str) {
        if (f46999f) {
            Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.f47004d, this.f47003c, str, this);
        this.f47001a.put(str, cVar);
        cVar.e();
    }

    public final String d(String str) throws MalformedURLException {
        return this.f47003c + d.a.l0.a.c1.b.f().c(str);
    }

    public final boolean f(String str) {
        return this.f47001a.containsKey(str);
    }

    @Override // d.a.l0.a.l0.m.a
    public void fail(int i2, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f47005e) {
            if (f(str) && (arrayList = this.f47002b.get(str)) != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.get(i3).onReceiveValue("");
                }
                this.f47001a.remove(str);
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
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            File file = new File(d(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(d2);
                    return;
                }
                return;
            }
            synchronized (this.f47005e) {
                if (!f(str)) {
                    c(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e2) {
            if (f46999f) {
                e2.printStackTrace();
            }
        }
    }
}
