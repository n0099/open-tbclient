package d.a.s.a.e;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import d.a.s.a.c.a;
import d.a.s.a.c.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public a.d f63940b = null;

    public d(Context context) {
        this.f63936a = context;
    }

    public void a(a.d dVar) {
        this.f63940b = dVar;
    }

    @Override // d.a.s.a.e.c.b
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Host", IMHttpDnsUrlRequest.HTTP_DNS_HOST);
        return hashMap;
    }

    @Override // d.a.s.a.e.c.b
    public String getHost() {
        return IMHttpDnsUrlRequest.HTTP_DNS_URL;
    }

    @Override // d.a.s.a.e.c.b
    public String getMediaType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // d.a.s.a.e.a, d.a.s.a.e.c.b
    public String getMethod() {
        return "GET";
    }

    @Override // d.a.s.a.e.c.b
    public byte[] getRequestParameter() {
        return ("type=ipv4,ipv6&dn=" + f.T(this.f63936a).x).getBytes();
    }

    @Override // d.a.s.a.e.c.d
    public void onFailure(int i2, String str) {
        d.a.s.a.g.d.b("LCPHttpDnsUrlRequest", "HttpDns failure errorcode:" + i2 + ",errormsg:" + str);
        d.a.s.a.c.a.g(true);
        d.a.s.a.c.a.d(this.f63936a).b(f.T(this.f63936a).x, this.f63940b);
    }

    @Override // d.a.s.a.e.c.d
    public void onSuccess(byte[] bArr) {
        String str = new String(bArr);
        d.a.s.a.g.d.a("LCPHttpDnsUrlRequest", "onSuccess----ip of " + f.T(this.f63936a).x + " is " + str);
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject(f.T(this.f63936a).x);
            JSONArray optJSONArray = jSONObject.optJSONArray("ip");
            JSONArray optJSONArray2 = jSONObject.optJSONArray(HttpDnsCacheForHost.JSON_KEY_IPV6);
            int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
            int length2 = optJSONArray == null ? 0 : optJSONArray.length();
            if (length2 + length > 0) {
                ArrayList arrayList = new ArrayList();
                if (optJSONArray != null && length2 > 0) {
                    arrayList.add(optJSONArray.getString(0));
                }
                if (optJSONArray2 != null && length > 0) {
                    arrayList.add(optJSONArray2.getString(0));
                }
                d.a.s.a.c.a.k(arrayList);
                if (this.f63940b == null || d.a.s.a.c.a.f63869c.size() <= 0) {
                    return;
                }
                this.f63940b.a(0, "ok", d.a.s.a.c.a.f63869c.get(0));
                if (d.a.s.a.c.a.f63869c.size() > 1) {
                    d.a.s.a.c.a.f63870d++;
                    return;
                }
                return;
            }
            d.a.s.a.g.d.b("LCPHttpDnsUrlRequest", "HttpDnsResponse ips is null ");
            d.a.s.a.c.a.g(true);
            d.a.s.a.c.a.d(this.f63936a).b(f.T(this.f63936a).x, this.f63940b);
        } catch (Exception e2) {
            d.a.s.a.g.d.b("LCPHttpDnsUrlRequest", "HttpDnsRequester ip parse exception " + e2.getMessage());
            d.a.s.a.c.a.g(true);
            d.a.s.a.c.a.d(this.f63936a).b(f.T(this.f63936a).x, this.f63940b);
        }
    }
}
