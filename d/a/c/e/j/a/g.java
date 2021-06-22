package d.a.c.e.j.a;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f42397a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f42398b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f42399c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f42400d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f42401e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f42402f = "";

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f42403g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f42404h;

    /* renamed from: i  reason: collision with root package name */
    public int f42405i;

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f42398b = httpURLConnection.getResponseCode();
            this.f42400d = httpURLConnection.getContentEncoding();
            this.f42401e = httpURLConnection.getContentType();
            this.f42402f = httpURLConnection.getContentLength() + "";
            this.f42403g = httpURLConnection.getHeaderFields();
        }
    }

    public boolean b() {
        return this.f42398b == 200;
    }
}
