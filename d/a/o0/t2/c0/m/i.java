package d.a.o0.t2.c0.m;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public int f64837c;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f64840f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f64841g;

    /* renamed from: h  reason: collision with root package name */
    public int f64842h;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f64835a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f64836b = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f64838d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f64839e = "";

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f64836b = httpURLConnection.getResponseCode();
            this.f64838d = httpURLConnection.getContentEncoding();
            httpURLConnection.getContentType();
            this.f64839e = httpURLConnection.getContentLength() + "";
            this.f64840f = httpURLConnection.getHeaderFields();
        }
    }
}
