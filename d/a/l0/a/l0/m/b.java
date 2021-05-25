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
/* loaded from: classes2.dex */
public class b implements a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f43323f = k.f43199a;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f43324g;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, c> f43325a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<ValueCallback<String>>> f43326b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final Object f43329e = new Object();

    /* renamed from: d  reason: collision with root package name */
    public HttpManager f43328d = d.a.l0.a.c1.b.l().b();

    /* renamed from: c  reason: collision with root package name */
    public String f43327c = d.a.l0.a.c1.b.f().a();

    public static b e() {
        if (f43324g == null) {
            synchronized (b.class) {
                if (f43324g == null) {
                    f43324g = new b();
                }
            }
        }
        return f43324g;
    }

    @Override // d.a.l0.a.l0.m.a
    public void a(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f43329e) {
            if (f(str) && (arrayList = this.f43326b.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).onReceiveValue(str2);
                    if (f43323f) {
                        Log.e("ImageDownloadManager", i2 + " load success url = " + str + " path = " + str2);
                    }
                }
                this.f43325a.remove(str);
            }
        }
    }

    public final void b(String str, ValueCallback<String> valueCallback) {
        if (this.f43326b.containsKey(str)) {
            this.f43326b.get(str).add(valueCallback);
            return;
        }
        ArrayList<ValueCallback<String>> arrayList = new ArrayList<>();
        arrayList.add(valueCallback);
        this.f43326b.put(str, arrayList);
    }

    public final void c(String str) {
        if (f43323f) {
            Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.f43328d, this.f43327c, str, this);
        this.f43325a.put(str, cVar);
        cVar.e();
    }

    public final String d(String str) throws MalformedURLException {
        return this.f43327c + d.a.l0.a.c1.b.f().c(str);
    }

    public final boolean f(String str) {
        return this.f43325a.containsKey(str);
    }

    @Override // d.a.l0.a.l0.m.a
    public void fail(int i2, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.f43329e) {
            if (f(str) && (arrayList = this.f43326b.get(str)) != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.get(i3).onReceiveValue("");
                }
                this.f43325a.remove(str);
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
            synchronized (this.f43329e) {
                if (!f(str)) {
                    c(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e2) {
            if (f43323f) {
                e2.printStackTrace();
            }
        }
    }
}
