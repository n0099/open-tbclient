package d.b.c.b.f;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f65104a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f65105b;

        /* renamed from: c  reason: collision with root package name */
        public String f65106c;

        /* renamed from: d  reason: collision with root package name */
        public long f65107d;

        /* renamed from: e  reason: collision with root package name */
        public long f65108e;

        /* renamed from: f  reason: collision with root package name */
        public long f65109f;

        /* renamed from: g  reason: collision with root package name */
        public long f65110g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f65111h = Collections.emptyMap();

        /* renamed from: i  reason: collision with root package name */
        public List<d.b.c.b.d.a> f65112i;

        public boolean a() {
            return this.f65109f < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f65110g < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);
}
