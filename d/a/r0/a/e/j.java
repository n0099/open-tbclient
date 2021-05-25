package d.a.r0.a.e;

import com.baidu.android.common.others.lang.StringUtil;
import d.a.r0.a.c;
import java.util.Map;
/* loaded from: classes5.dex */
public final class j {

    /* loaded from: classes5.dex */
    public static class a extends d.a.r0.a.f.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f64430e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.baidu.ubs.analytics.a.a f64431f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f64432g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f64433h;

        public a(Map map, com.baidu.ubs.analytics.a.a aVar, String str, String str2) {
            this.f64430e = map;
            this.f64431f = aVar;
            this.f64432g = str;
            this.f64433h = str2;
        }

        @Override // d.a.r0.a.f.c
        public final void a() {
            if (this.f64430e != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(StringUtil.ARRAY_START);
                for (Map.Entry entry : this.f64430e.entrySet()) {
                    stringBuffer.append("\"");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("\":\"");
                    stringBuffer.append(entry.getValue().toString().replace("\"", "\\\""));
                    stringBuffer.append("\",");
                }
                StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.subSequence(0, stringBuffer.length() - 1));
                stringBuffer2.append("}");
                this.f64431f.w(stringBuffer2.toString());
            }
            try {
                this.f64431f.x(m.d().I());
                this.f64431f.u(String.valueOf(System.currentTimeMillis()));
                this.f64431f.t(this.f64432g);
                this.f64431f.s(this.f64433h == null ? "" : this.f64433h);
                new c.b().c(this.f64431f);
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    d.a.r0.a.f.a.b(e2.getMessage());
                }
            }
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        com.baidu.ubs.analytics.a.a aVar = new com.baidu.ubs.analytics.a.a();
        aVar.v(str);
        d.a.r0.a.f.b.c(new a(map, aVar, str2, str3));
    }
}
