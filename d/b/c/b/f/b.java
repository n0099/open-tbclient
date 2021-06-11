package d.b.c.b.f;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public interface b {

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f69564a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f69565b;

        /* renamed from: c  reason: collision with root package name */
        public String f69566c;

        /* renamed from: d  reason: collision with root package name */
        public long f69567d;

        /* renamed from: e  reason: collision with root package name */
        public long f69568e;

        /* renamed from: f  reason: collision with root package name */
        public long f69569f;

        /* renamed from: g  reason: collision with root package name */
        public long f69570g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f69571h = Collections.emptyMap();

        /* renamed from: i  reason: collision with root package name */
        public List<d.b.c.b.d.a> f69572i;

        public boolean a() {
            return this.f69569f < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f69570g < System.currentTimeMillis();
        }
    }

    a a(String str);

    void a();

    void a(String str, a aVar);
}
