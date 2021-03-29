package d.b.i0.r2.x.m;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public int f59983c;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f59986f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f59987g;

    /* renamed from: h  reason: collision with root package name */
    public int f59988h;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f59981a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f59982b = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f59984d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f59985e = "";

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f59982b = httpURLConnection.getResponseCode();
            this.f59984d = httpURLConnection.getContentEncoding();
            httpURLConnection.getContentType();
            this.f59985e = httpURLConnection.getContentLength() + "";
            this.f59986f = httpURLConnection.getHeaderFields();
        }
    }
}
