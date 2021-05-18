package d.a.k0.s2.c0.m;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public int f60918c;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f60921f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f60922g;

    /* renamed from: h  reason: collision with root package name */
    public int f60923h;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f60916a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f60917b = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f60919d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f60920e = "";

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f60917b = httpURLConnection.getResponseCode();
            this.f60919d = httpURLConnection.getContentEncoding();
            httpURLConnection.getContentType();
            this.f60920e = httpURLConnection.getContentLength() + "";
            this.f60921f = httpURLConnection.getHeaderFields();
        }
    }
}
