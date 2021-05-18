package d.b.c.b.f;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public interface b {

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f65790a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f65791b;

        /* renamed from: c  reason: collision with root package name */
        public String f65792c;

        /* renamed from: d  reason: collision with root package name */
        public long f65793d;

        /* renamed from: e  reason: collision with root package name */
        public long f65794e;

        /* renamed from: f  reason: collision with root package name */
        public long f65795f;

        /* renamed from: g  reason: collision with root package name */
        public long f65796g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f65797h = Collections.emptyMap();

        /* renamed from: i  reason: collision with root package name */
        public List<d.b.c.b.d.a> f65798i;

        public boolean a() {
            return this.f65795f < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f65796g < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);
}
