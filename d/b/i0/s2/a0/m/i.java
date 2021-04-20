package d.b.i0.s2.a0.m;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public int f61583c;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f61586f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f61587g;

    /* renamed from: h  reason: collision with root package name */
    public int f61588h;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f61581a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f61582b = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f61584d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f61585e = "";

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f61582b = httpURLConnection.getResponseCode();
            this.f61584d = httpURLConnection.getContentEncoding();
            httpURLConnection.getContentType();
            this.f61585e = httpURLConnection.getContentLength() + "";
            this.f61586f = httpURLConnection.getHeaderFields();
        }
    }
}
