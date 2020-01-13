package tv.chushou.basis.http.model;

import android.os.Build;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.webkit.internal.ETAG;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import tv.chushou.basis.d.a.b.b;
import tv.chushou.basis.d.a.b.c;
import tv.chushou.basis.d.a.b.d;
import tv.chushou.basis.d.a.b.e;
/* loaded from: classes4.dex */
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
    private final RequestTag nUn;

    public HttpParam(RequestTag requestTag) {
        this.nUn = requestTag == null ? RequestTag.normal() : requestTag;
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
        Map<String, String> dCY;
        if (this.nUn.signType == 2) {
            return;
        }
        b bVar = (b) tv.chushou.basis.d.b.dOE().T(b.class);
        if (bVar != null) {
            b("_appkey", bVar.getAppKey());
            b("_xappkey", bVar.dCV());
            b("_appSource", bVar.OM());
            b("_appVersion", bVar.getSdkVersion());
            String token = bVar.getToken();
            if (!TextUtils.isEmpty(token)) {
                b("token", token);
            }
        }
        d dVar = (d) tv.chushou.basis.d.b.dOE().T(d.class);
        if (dVar != null) {
            b("_identifier", dVar.getIdentifier());
            b("_imei", dVar.aeR());
            b("device_cs", dVar.dOt());
            b("device_ds", dVar.dOu());
            for (Map.Entry<String, String> entry : dVar.dOv().entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
        }
        if (bVar != null && (dCY = bVar.dCY()) != null) {
            for (Map.Entry<String, String> entry2 : dCY.entrySet()) {
                b(entry2.getKey(), entry2.getValue());
            }
        }
        b(BdStatsConstant.StatsKey.OS_VERSION, String.valueOf(Build.VERSION.SDK_INT));
    }

    public void a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.put(str, obj == null ? "" : obj.toString());
    }

    public void b() {
        if (this.nUn.signType == 2) {
            return;
        }
        c cVar = (c) tv.chushou.basis.d.b.dOE().T(c.class);
        if (cVar == null) {
            this.c.put("_t", String.valueOf(System.currentTimeMillis()));
            return;
        }
        this.c.put("_t", cVar.dDa());
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
        if (this.nUn.signType == 2) {
            return;
        }
        String str = this.nUn.signKey;
        String str2 = this.nUn.signSecret;
        String str3 = TextUtils.isEmpty(str) ? "_sign" : str;
        b bVar = (b) tv.chushou.basis.d.b.dOE().T(b.class);
        String dCW = (!TextUtils.isEmpty(str2) || bVar == null) ? str2 : bVar.dCW();
        this.c.remove(str3);
        e eVar = (e) tv.chushou.basis.d.b.dOE().T(e.class);
        if (bVar == null || eVar == null) {
            return;
        }
        this.c.put(str3, eVar.fn(dCW, e()));
    }

    public Set<Map.Entry<String, String>> dOA() {
        return this.c.entrySet();
    }

    @Keep
    public Map<String, String> getSystemParam() {
        a();
        return this.c;
    }
}
