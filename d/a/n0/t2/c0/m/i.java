package d.a.n0.t2.c0.m;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public int f61020c;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f61023f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f61024g;

    /* renamed from: h  reason: collision with root package name */
    public int f61025h;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f61018a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f61019b = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f61021d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f61022e = "";

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f61019b = httpURLConnection.getResponseCode();
            this.f61021d = httpURLConnection.getContentEncoding();
            httpURLConnection.getContentType();
            this.f61022e = httpURLConnection.getContentLength() + "";
            this.f61023f = httpURLConnection.getHeaderFields();
        }
    }
}
