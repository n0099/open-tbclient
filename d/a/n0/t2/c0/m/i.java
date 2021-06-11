package d.a.n0.t2.c0.m;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public int f64712c;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f64715f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f64716g;

    /* renamed from: h  reason: collision with root package name */
    public int f64717h;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f64710a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f64711b = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f64713d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f64714e = "";

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f64711b = httpURLConnection.getResponseCode();
            this.f64713d = httpURLConnection.getContentEncoding();
            httpURLConnection.getContentType();
            this.f64714e = httpURLConnection.getContentLength() + "";
            this.f64715f = httpURLConnection.getHeaderFields();
        }
    }
}
