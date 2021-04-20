package d.g.c.a;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class j {

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f66942a;

        /* renamed from: b  reason: collision with root package name */
        public final a f66943b;

        /* renamed from: c  reason: collision with root package name */
        public a f66944c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66945d;

        /* loaded from: classes6.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public String f66946a;

            /* renamed from: b  reason: collision with root package name */
            public Object f66947b;

            /* renamed from: c  reason: collision with root package name */
            public a f66948c;

            public a() {
            }
        }

        public b a(String str, double d2) {
            g(str, String.valueOf(d2));
            return this;
        }

        public b b(String str, int i) {
            g(str, String.valueOf(i));
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
            this.f66944c.f66948c = aVar;
            this.f66944c = aVar;
            return aVar;
        }

        public final b f(Object obj) {
            e().f66947b = obj;
            return this;
        }

        public final b g(String str, Object obj) {
            a e2 = e();
            e2.f66947b = obj;
            n.p(str);
            e2.f66946a = str;
            return this;
        }

        public b h(Object obj) {
            f(obj);
            return this;
        }

        public String toString() {
            boolean z = this.f66945d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f66942a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f66943b.f66948c; aVar != null; aVar = aVar.f66948c) {
                Object obj = aVar.f66947b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = aVar.f66946a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append(com.alipay.sdk.encrypt.a.f1922h);
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
            this.f66943b = aVar;
            this.f66944c = aVar;
            this.f66945d = false;
            n.p(str);
            this.f66942a = str;
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
