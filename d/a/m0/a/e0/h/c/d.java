package d.a.m0.a.e0.h.c;

import android.util.Log;
import com.baidu.searchbox.bddownload.core.Util;
import d.a.m0.a.e0.h.c.c;
import d.a.m0.a.k;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public static class a extends c.b {

        /* renamed from: b  reason: collision with root package name */
        public static final boolean f45337b = k.f46983a;

        public a(c.a aVar) {
            super(aVar);
        }

        @Override // d.a.m0.a.e0.h.c.c.b
        public Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("Upgrade", "websocket");
            hashMap.put(HTTP.CONN_DIRECTIVE, "Upgrade");
            try {
                hashMap.put("Sec-WebSocket-Accept", d.a.m0.a.e0.h.d.a.g(this.f45336a.f45331a.get("sec-websocket-key")));
            } catch (NoSuchAlgorithmException e2) {
                if (f45337b) {
                    Log.e("HandShakeResponse", "make accept key fail for error invalid algorithm", e2);
                }
            }
            return hashMap;
        }

        @Override // d.a.m0.a.e0.h.c.c.b
        public String c() {
            return "101 Switching Protocols";
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends c.b {

        /* renamed from: b  reason: collision with root package name */
        public String f45338b;

        public b(c.a aVar) {
            super(aVar);
        }

        @Override // d.a.m0.a.e0.h.c.c.b
        public String a() {
            if (this.f45338b == null) {
                this.f45338b = new d.a.m0.a.e0.h.b().toString();
            }
            return this.f45338b;
        }

        @Override // d.a.m0.a.e0.h.c.c.b
        public Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json; charset=UTF-8");
            hashMap.put(Util.ACCEPT_RANGES, "bytes");
            hashMap.put(HTTP.CONN_DIRECTIVE, "keep-alive");
            return hashMap;
        }

        @Override // d.a.m0.a.e0.h.c.c.b
        public String c() {
            return "200 OK";
        }
    }

    public static c.b a(c.a aVar) {
        Map<String, String> map;
        if (aVar == null || (map = aVar.f45331a) == null || map.size() < 1) {
            return null;
        }
        if (d.a.m0.a.e0.h.d.a.f(aVar.f45331a)) {
            aVar.f45335e = true;
            return new a(aVar);
        }
        aVar.f45335e = false;
        return new b(aVar);
    }
}
