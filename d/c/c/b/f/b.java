package d.c.c.b.f;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f66608a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f66609b;

        /* renamed from: c  reason: collision with root package name */
        public String f66610c;

        /* renamed from: d  reason: collision with root package name */
        public long f66611d;

        /* renamed from: e  reason: collision with root package name */
        public long f66612e;

        /* renamed from: f  reason: collision with root package name */
        public long f66613f;

        /* renamed from: g  reason: collision with root package name */
        public long f66614g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f66615h = Collections.emptyMap();
        public List<d.c.c.b.d.a> i;

        public boolean a() {
            return this.f66613f < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f66614g < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);
}
