package d.b.i0.r2.x.m;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public int f59982c;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f59985f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f59986g;

    /* renamed from: h  reason: collision with root package name */
    public int f59987h;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f59980a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f59981b = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f59983d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f59984e = "";

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f59981b = httpURLConnection.getResponseCode();
            this.f59983d = httpURLConnection.getContentEncoding();
            httpURLConnection.getContentType();
            this.f59984e = httpURLConnection.getContentLength() + "";
            this.f59985f = httpURLConnection.getHeaderFields();
        }
    }
}
