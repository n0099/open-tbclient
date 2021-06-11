package d.a.t.a.f;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import d.a.t.a.c.a;
import d.a.t.a.c.f;
import d.a.t.a.h.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public a.d f68346b = null;

    public d(Context context) {
        this.f68342a = context;
    }

    public void a(a.d dVar) {
        this.f68346b = dVar;
    }

    @Override // d.a.t.a.f.c.b
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Host", IMHttpDnsUrlRequest.HTTP_DNS_HOST);
        return hashMap;
    }

    @Override // d.a.t.a.f.c.b
    public String getHost() {
        return IMHttpDnsUrlRequest.HTTP_DNS_URL;
    }

    @Override // d.a.t.a.f.c.b
    public String getMediaType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // d.a.t.a.f.a, d.a.t.a.f.c.b
    public String getMethod() {
        return "GET";
    }

    @Override // d.a.t.a.f.c.b
    public byte[] getRequestParameter() {
        return ("type=ipv4,ipv6&dn=" + f.S(this.f68342a).x).getBytes();
    }

    @Override // d.a.t.a.f.c.d
    public void onFailure(int i2, String str) {
        e.b("LCPHttpDnsUrlRequest", "HttpDns failure errorcode:" + i2 + ",errormsg:" + str);
        d.a.t.a.c.a.f(true);
        d.a.t.a.c.a.c(this.f68342a).b(f.S(this.f68342a).x, this.f68346b);
    }

    @Override // d.a.t.a.f.c.d
    public void onSuccess(byte[] bArr) {
        String str = new String(bArr);
        e.a("LCPHttpDnsUrlRequest", "onSuccess----ip of " + f.S(this.f68342a).x + " is " + str);
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject(f.S(this.f68342a).x);
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
                d.a.t.a.c.a.j(arrayList);
                if (this.f68346b == null || d.a.t.a.c.a.f68272c.size() <= 0) {
                    return;
                }
                this.f68346b.a(0, "ok", d.a.t.a.c.a.f68272c.get(0));
                if (d.a.t.a.c.a.f68272c.size() > 1) {
                    d.a.t.a.c.a.f68273d++;
                    return;
                }
                return;
            }
            e.b("LCPHttpDnsUrlRequest", "HttpDnsResponse ips is null ");
            d.a.t.a.c.a.f(true);
            d.a.t.a.c.a.c(this.f68342a).b(f.S(this.f68342a).x, this.f68346b);
        } catch (Exception e2) {
            e.b("LCPHttpDnsUrlRequest", "HttpDnsRequester ip parse exception " + e2.getMessage());
            d.a.t.a.c.a.f(true);
            d.a.t.a.c.a.c(this.f68342a).b(f.S(this.f68342a).x, this.f68346b);
        }
    }
}
