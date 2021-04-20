package d.b.c.e.j.a;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f42294a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f42295b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f42296c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f42297d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f42298e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f42299f = "";

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f42300g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f42301h;
    public int i;

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f42295b = httpURLConnection.getResponseCode();
            this.f42297d = httpURLConnection.getContentEncoding();
            this.f42298e = httpURLConnection.getContentType();
            this.f42299f = httpURLConnection.getContentLength() + "";
            this.f42300g = httpURLConnection.getHeaderFields();
        }
    }

    public boolean b() {
        return this.f42295b == 200;
    }
}
