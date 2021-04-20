package d.b.g0.a.c0.f.c;

import android.util.Log;
import com.baidu.searchbox.bddownload.core.Util;
import d.b.g0.a.c0.f.c.c;
import d.b.g0.a.k;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static class a extends c.b {

        /* renamed from: b  reason: collision with root package name */
        public static final boolean f44109b = k.f45443a;

        public a(c.a aVar) {
            super(aVar);
        }

        @Override // d.b.g0.a.c0.f.c.c.b
        public Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("Upgrade", "websocket");
            hashMap.put(HTTP.CONN_DIRECTIVE, "Upgrade");
            try {
                hashMap.put("Sec-WebSocket-Accept", d.b.g0.a.c0.f.d.a.g(this.f44108a.f44103a.get("sec-websocket-key")));
            } catch (NoSuchAlgorithmException e2) {
                if (f44109b) {
                    Log.e("HandShakeResponse", "make accept key fail for error invalid algorithm", e2);
                }
            }
            return hashMap;
        }

        @Override // d.b.g0.a.c0.f.c.c.b
        public String c() {
            return "101 Switching Protocols";
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends c.b {

        /* renamed from: b  reason: collision with root package name */
        public String f44110b;

        public b(c.a aVar) {
            super(aVar);
        }

        @Override // d.b.g0.a.c0.f.c.c.b
        public String a() {
            if (this.f44110b == null) {
                this.f44110b = new d.b.g0.a.c0.f.b().toString();
            }
            return this.f44110b;
        }

        @Override // d.b.g0.a.c0.f.c.c.b
        public Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json; charset=UTF-8");
            hashMap.put(Util.ACCEPT_RANGES, "bytes");
            hashMap.put(HTTP.CONN_DIRECTIVE, "keep-alive");
            return hashMap;
        }

        @Override // d.b.g0.a.c0.f.c.c.b
        public String c() {
            return "200 OK";
        }
    }

    public static c.b a(c.a aVar) {
        Map<String, String> map;
        if (aVar == null || (map = aVar.f44103a) == null || map.size() < 1) {
            return null;
        }
        if (d.b.g0.a.c0.f.d.a.f(aVar.f44103a)) {
            aVar.f44107e = true;
            return new a(aVar);
        }
        aVar.f44107e = false;
        return new b(aVar);
    }
}
