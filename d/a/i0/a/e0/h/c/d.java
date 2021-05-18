package d.a.i0.a.e0.h.c;

import android.util.Log;
import com.baidu.searchbox.bddownload.core.Util;
import d.a.i0.a.e0.h.c.c;
import d.a.i0.a.k;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static class a extends c.b {

        /* renamed from: b  reason: collision with root package name */
        public static final boolean f41379b = k.f43025a;

        public a(c.a aVar) {
            super(aVar);
        }

        @Override // d.a.i0.a.e0.h.c.c.b
        public Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("Upgrade", "websocket");
            hashMap.put(HTTP.CONN_DIRECTIVE, "Upgrade");
            try {
                hashMap.put("Sec-WebSocket-Accept", d.a.i0.a.e0.h.d.a.g(this.f41378a.f41373a.get("sec-websocket-key")));
            } catch (NoSuchAlgorithmException e2) {
                if (f41379b) {
                    Log.e("HandShakeResponse", "make accept key fail for error invalid algorithm", e2);
                }
            }
            return hashMap;
        }

        @Override // d.a.i0.a.e0.h.c.c.b
        public String c() {
            return "101 Switching Protocols";
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends c.b {

        /* renamed from: b  reason: collision with root package name */
        public String f41380b;

        public b(c.a aVar) {
            super(aVar);
        }

        @Override // d.a.i0.a.e0.h.c.c.b
        public String a() {
            if (this.f41380b == null) {
                this.f41380b = new d.a.i0.a.e0.h.b().toString();
            }
            return this.f41380b;
        }

        @Override // d.a.i0.a.e0.h.c.c.b
        public Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json; charset=UTF-8");
            hashMap.put(Util.ACCEPT_RANGES, "bytes");
            hashMap.put(HTTP.CONN_DIRECTIVE, "keep-alive");
            return hashMap;
        }

        @Override // d.a.i0.a.e0.h.c.c.b
        public String c() {
            return "200 OK";
        }
    }

    public static c.b a(c.a aVar) {
        Map<String, String> map;
        if (aVar == null || (map = aVar.f41373a) == null || map.size() < 1) {
            return null;
        }
        if (d.a.i0.a.e0.h.d.a.f(aVar.f41373a)) {
            aVar.f41377e = true;
            return new a(aVar);
        }
        aVar.f41377e = false;
        return new b(aVar);
    }
}
