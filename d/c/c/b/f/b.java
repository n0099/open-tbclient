package d.c.c.b.f;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f65763a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f65764b;

        /* renamed from: c  reason: collision with root package name */
        public String f65765c;

        /* renamed from: d  reason: collision with root package name */
        public long f65766d;

        /* renamed from: e  reason: collision with root package name */
        public long f65767e;

        /* renamed from: f  reason: collision with root package name */
        public long f65768f;

        /* renamed from: g  reason: collision with root package name */
        public long f65769g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f65770h = Collections.emptyMap();
        public List<d.c.c.b.d.a> i;

        public boolean a() {
            return this.f65768f < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f65769g < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);
}
