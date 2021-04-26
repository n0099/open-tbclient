package d.a.h0.a.c0.f.c;

import android.util.Log;
import com.baidu.searchbox.bddownload.core.Util;
import d.a.h0.a.c0.f.c.c;
import d.a.h0.a.k;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static class a extends c.b {

        /* renamed from: b  reason: collision with root package name */
        public static final boolean f41728b = k.f43101a;

        public a(c.a aVar) {
            super(aVar);
        }

        @Override // d.a.h0.a.c0.f.c.c.b
        public Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("Upgrade", "websocket");
            hashMap.put(HTTP.CONN_DIRECTIVE, "Upgrade");
            try {
                hashMap.put("Sec-WebSocket-Accept", d.a.h0.a.c0.f.d.a.g(this.f41727a.f41722a.get("sec-websocket-key")));
            } catch (NoSuchAlgorithmException e2) {
                if (f41728b) {
                    Log.e("HandShakeResponse", "make accept key fail for error invalid algorithm", e2);
                }
            }
            return hashMap;
        }

        @Override // d.a.h0.a.c0.f.c.c.b
        public String c() {
            return "101 Switching Protocols";
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends c.b {

        /* renamed from: b  reason: collision with root package name */
        public String f41729b;

        public b(c.a aVar) {
            super(aVar);
        }

        @Override // d.a.h0.a.c0.f.c.c.b
        public String a() {
            if (this.f41729b == null) {
                this.f41729b = new d.a.h0.a.c0.f.b().toString();
            }
            return this.f41729b;
        }

        @Override // d.a.h0.a.c0.f.c.c.b
        public Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json; charset=UTF-8");
            hashMap.put(Util.ACCEPT_RANGES, "bytes");
            hashMap.put(HTTP.CONN_DIRECTIVE, "keep-alive");
            return hashMap;
        }

        @Override // d.a.h0.a.c0.f.c.c.b
        public String c() {
            return "200 OK";
        }
    }

    public static c.b a(c.a aVar) {
        Map<String, String> map;
        if (aVar == null || (map = aVar.f41722a) == null || map.size() < 1) {
            return null;
        }
        if (d.a.h0.a.c0.f.d.a.f(aVar.f41722a)) {
            aVar.f41726e = true;
            return new a(aVar);
        }
        aVar.f41726e = false;
        return new b(aVar);
    }
}
