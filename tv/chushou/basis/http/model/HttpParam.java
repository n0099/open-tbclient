package tv.chushou.basis.http.model;

import android.os.Build;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import tv.chushou.basis.d.a.b.b;
import tv.chushou.basis.d.a.b.c;
import tv.chushou.basis.d.a.b.d;
import tv.chushou.basis.d.a.b.e;
/* loaded from: classes5.dex */
public class HttpParam {
    private static final Comparator<String> a = new Comparator<String>() { // from class: tv.chushou.basis.http.model.HttpParam.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    private final Map<String, String> c;
    private final RequestTag oiU;

    public HttpParam(RequestTag requestTag) {
        this.oiU = requestTag == null ? RequestTag.normal() : requestTag;
        this.c = new TreeMap(a);
    }

    private String e() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.c.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                sb.append(ETAG.ITEM_SEPARATOR).append(key).append(ETAG.EQUAL);
            } else {
                sb.append(ETAG.ITEM_SEPARATOR).append(key).append(ETAG.EQUAL).append(value);
            }
        }
        return sb.toString();
    }

    public void a() {
        Map<String, String> dKX;
        if (this.oiU.signType == 2) {
            return;
        }
        b bVar = (b) tv.chushou.basis.d.b.dWk().S(b.class);
        if (bVar != null) {
            b("_appkey", bVar.getAppKey());
            b("_xappkey", bVar.dKT());
            b("_appSource", bVar.ada());
            b("_appVersion", bVar.getSdkVersion());
            String token = bVar.getToken();
            if (!TextUtils.isEmpty(token)) {
                b("token", token);
            }
            b("_cssdkVersion", bVar.dKW());
        }
        d dVar = (d) tv.chushou.basis.d.b.dWk().S(d.class);
        if (dVar != null) {
            b("_identifier", dVar.getIdentifier());
            b("_imei", dVar.auX());
            b("device_cs", dVar.dWa());
            b("device_ds", dVar.dWb());
            for (Map.Entry<String, String> entry : dVar.dWc().entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
        }
        if (bVar != null && (dKX = bVar.dKX()) != null) {
            for (Map.Entry<String, String> entry2 : dKX.entrySet()) {
                b(entry2.getKey(), entry2.getValue());
            }
        }
        b("os_version", String.valueOf(Build.VERSION.SDK_INT));
    }

    public void a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.put(str, obj == null ? "" : obj.toString());
    }

    public void b() {
        if (this.oiU.signType == 2) {
            return;
        }
        c cVar = (c) tv.chushou.basis.d.b.dWk().S(c.class);
        if (cVar == null) {
            this.c.put("_t", String.valueOf(System.currentTimeMillis()));
            return;
        }
        this.c.put("_t", cVar.dKZ());
    }

    public void b(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        String obj2 = obj.toString();
        if (TextUtils.isEmpty(obj2)) {
            return;
        }
        this.c.put(str, obj2);
    }

    public void c() {
        if (this.oiU.signType == 2) {
            return;
        }
        String str = this.oiU.signKey;
        String str2 = this.oiU.signSecret;
        String str3 = TextUtils.isEmpty(str) ? "_sign" : str;
        b bVar = (b) tv.chushou.basis.d.b.dWk().S(b.class);
        String dKU = (!TextUtils.isEmpty(str2) || bVar == null) ? str2 : bVar.dKU();
        this.c.remove(str3);
        e eVar = (e) tv.chushou.basis.d.b.dWk().S(e.class);
        if (bVar == null || eVar == null) {
            return;
        }
        this.c.put(str3, eVar.fW(dKU, e()));
    }

    public Set<Map.Entry<String, String>> dWh() {
        return this.c.entrySet();
    }

    @Keep
    public Map<String, String> getSystemParam() {
        a();
        return this.c;
    }
}
