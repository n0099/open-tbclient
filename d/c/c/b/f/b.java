package d.c.c.b.f;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f65762a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f65763b;

        /* renamed from: c  reason: collision with root package name */
        public String f65764c;

        /* renamed from: d  reason: collision with root package name */
        public long f65765d;

        /* renamed from: e  reason: collision with root package name */
        public long f65766e;

        /* renamed from: f  reason: collision with root package name */
        public long f65767f;

        /* renamed from: g  reason: collision with root package name */
        public long f65768g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f65769h = Collections.emptyMap();
        public List<d.c.c.b.d.a> i;

        public boolean a() {
            return this.f65767f < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f65768g < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);
}
