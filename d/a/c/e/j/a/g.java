package d.a.c.e.j.a;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f38977a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f38978b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f38979c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f38980d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f38981e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f38982f = "";

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f38983g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f38984h;

    /* renamed from: i  reason: collision with root package name */
    public int f38985i;

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f38978b = httpURLConnection.getResponseCode();
            this.f38980d = httpURLConnection.getContentEncoding();
            this.f38981e = httpURLConnection.getContentType();
            this.f38982f = httpURLConnection.getContentLength() + "";
            this.f38983g = httpURLConnection.getHeaderFields();
        }
    }

    public boolean b() {
        return this.f38978b == 200;
    }
}
