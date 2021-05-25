package d.g.c.a;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class j {

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f66233a;

        /* renamed from: b  reason: collision with root package name */
        public final a f66234b;

        /* renamed from: c  reason: collision with root package name */
        public a f66235c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66236d;

        /* loaded from: classes6.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public String f66237a;

            /* renamed from: b  reason: collision with root package name */
            public Object f66238b;

            /* renamed from: c  reason: collision with root package name */
            public a f66239c;

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
            this.f66235c.f66239c = aVar;
            this.f66235c = aVar;
            return aVar;
        }

        public final b f(Object obj) {
            e().f66238b = obj;
            return this;
        }

        public final b g(String str, Object obj) {
            a e2 = e();
            e2.f66238b = obj;
            n.p(str);
            e2.f66237a = str;
            return this;
        }

        public b h(Object obj) {
            f(obj);
            return this;
        }

        public String toString() {
            boolean z = this.f66236d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f66233a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f66234b.f66239c; aVar != null; aVar = aVar.f66239c) {
                Object obj = aVar.f66238b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = aVar.f66237a;
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
            this.f66234b = aVar;
            this.f66235c = aVar;
            this.f66236d = false;
            n.p(str);
            this.f66233a = str;
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
