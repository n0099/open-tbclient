package d.a.m0.a.l0.m;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.searchbox.http.HttpManager;
import d.a.m0.a.k;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47107f = k.f46983a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f47108g;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f47109a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<ValueCallback<String>>> f47110b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f47113e = new Object();

    /* renamed from: d  reason: collision with root package name */
    public HttpManager f47112d = d.a.m0.a.c1.b.l().b();

    /* renamed from: c  reason: collision with root package name */
    public String f47111c = d.a.m0.a.c1.b.f().a();

    public static b e() {
        if (f47108g == null) {
            synchronized (b.class) {
                if (f47108g == null) {
                    f47108g = new b();
                }
            }
        }
        return f47108g;
    }

    @Override // d.a.m0.a.l0.m.a
    public void a(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f47113e) {
            if (f(str) && (arrayList = this.f47110b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).onReceiveValue(str2);
                    if (f47107f) {
                        Log.e("ImageDownloadManager", i2 + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f47109a.remove(str);
            }
        }
    }

    public final void b(String str, ValueCallback<String> valueCallback) {
        if (this.f47110b.containsKey(str)) {
            this.f47110b.get(str).add(valueCallback);
            return;
        }
        ArrayList<ValueCallback<String>> arrayList = new ArrayList<>();
        arrayList.add(valueCallback);
        this.f47110b.put(str, arrayList);
    }

    public final void c(String str) {
        if (f47107f) {
            Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.f47112d, this.f47111c, str, this);
        this.f47109a.put(str, cVar);
        cVar.e();
    }

    public final String d(String str) throws MalformedURLException {
        return this.f47111c + d.a.m0.a.c1.b.f().c(str);
    }

    public final boolean f(String str) {
        return this.f47109a.containsKey(str);
    }

    @Override // d.a.m0.a.l0.m.a
    public void fail(int i2, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f47113e) {
            if (f(str) && (arrayList = this.f47110b.get(str)) != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.get(i3).onReceiveValue("");
                }
                this.f47109a.remove(str);
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
            synchronized (this.f47113e) {
                if (!f(str)) {
                    c(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e2) {
            if (f47107f) {
                e2.printStackTrace();
            }
        }
    }
}
