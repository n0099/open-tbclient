package d.c.c.b.f;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f66703a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f66704b;

        /* renamed from: c  reason: collision with root package name */
        public String f66705c;

        /* renamed from: d  reason: collision with root package name */
        public long f66706d;

        /* renamed from: e  reason: collision with root package name */
        public long f66707e;

        /* renamed from: f  reason: collision with root package name */
        public long f66708f;

        /* renamed from: g  reason: collision with root package name */
        public long f66709g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f66710h = Collections.emptyMap();
        public List<d.c.c.b.d.a> i;

        public boolean a() {
            return this.f66708f < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f66709g < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);
}
