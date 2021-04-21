package d.b.c.e.j.a;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f42534a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f42535b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f42536c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f42537d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f42538e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f42539f = "";

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f42540g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f42541h;
    public int i;

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f42535b = httpURLConnection.getResponseCode();
            this.f42537d = httpURLConnection.getContentEncoding();
            this.f42538e = httpURLConnection.getContentType();
            this.f42539f = httpURLConnection.getContentLength() + "";
            this.f42540g = httpURLConnection.getHeaderFields();
        }
    }

    public boolean b() {
        return this.f42535b == 200;
    }
}
