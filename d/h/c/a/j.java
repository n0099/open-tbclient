package d.h.c.a;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class j {

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f67089a;

        /* renamed from: b  reason: collision with root package name */
        public final a f67090b;

        /* renamed from: c  reason: collision with root package name */
        public a f67091c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67092d;

        /* loaded from: classes6.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public String f67093a;

            /* renamed from: b  reason: collision with root package name */
            public Object f67094b;

            /* renamed from: c  reason: collision with root package name */
            public a f67095c;

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
            this.f67091c.f67095c = aVar;
            this.f67091c = aVar;
            return aVar;
        }

        public final b f(Object obj) {
            e().f67094b = obj;
            return this;
        }

        public final b g(String str, Object obj) {
            a e2 = e();
            e2.f67094b = obj;
            n.p(str);
            e2.f67093a = str;
            return this;
        }

        public b h(Object obj) {
            f(obj);
            return this;
        }

        public String toString() {
            boolean z = this.f67092d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f67089a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f67090b.f67095c; aVar != null; aVar = aVar.f67095c) {
                Object obj = aVar.f67094b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = aVar.f67093a;
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
            this.f67090b = aVar;
            this.f67091c = aVar;
            this.f67092d = false;
            n.p(str);
            this.f67089a = str;
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
