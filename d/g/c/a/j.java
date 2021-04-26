package d.g.c.a;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class j {

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f65504a;

        /* renamed from: b  reason: collision with root package name */
        public final a f65505b;

        /* renamed from: c  reason: collision with root package name */
        public a f65506c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65507d;

        /* loaded from: classes6.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public String f65508a;

            /* renamed from: b  reason: collision with root package name */
            public Object f65509b;

            /* renamed from: c  reason: collision with root package name */
            public a f65510c;

            public a() {
            }
        }

        public b a(String str, double d2) {
            g(str, String.valueOf(d2));
            return this;
        }

        public b b(String str, int i2) {
            g(str, String.valueOf(i2));
            return this;
        }

        public b c(String str, long j) {
            g(str, String.valueOf(j));
            return this;
        }

        public b d(String str, Object obj) {
            g(str, obj);
            return this;
        }

        public final a e() {
            a aVar = new a();
            this.f65506c.f65510c = aVar;
            this.f65506c = aVar;
            return aVar;
        }

        public final b f(Object obj) {
            e().f65509b = obj;
            return this;
        }

        public final b g(String str, Object obj) {
            a e2 = e();
            e2.f65509b = obj;
            n.p(str);
            e2.f65508a = str;
            return this;
        }

        public b h(Object obj) {
            f(obj);
            return this;
        }

        public String toString() {
            boolean z = this.f65507d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f65504a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f65505b.f65510c; aVar != null; aVar = aVar.f65510c) {
                Object obj = aVar.f65509b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = aVar.f65508a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append(com.alipay.sdk.encrypt.a.f1873h);
                    }
                    if (obj != null && obj.getClass().isArray()) {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    } else {
                        sb.append(obj);
                    }
                    str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
                }
            }
            sb.append('}');
            return sb.toString();
        }

        public b(String str) {
            a aVar = new a();
            this.f65505b = aVar;
            this.f65506c = aVar;
            this.f65507d = false;
            n.p(str);
            this.f65504a = str;
        }
    }

    public static <T> T a(T t, T t2) {
        if (t != null) {
            return t;
        }
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
