package d.b.m0.a.e;

import com.baidu.android.common.others.lang.StringUtil;
import d.b.m0.a.c;
import java.util.Map;
/* loaded from: classes5.dex */
public final class j {

    /* loaded from: classes5.dex */
    public static class a extends d.b.m0.a.f.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f64087e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.baidu.ubs.analytics.a.a f64088f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f64089g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f64090h;

        public a(Map map, com.baidu.ubs.analytics.a.a aVar, String str, String str2) {
            this.f64087e = map;
            this.f64088f = aVar;
            this.f64089g = str;
            this.f64090h = str2;
        }

        @Override // d.b.m0.a.f.c
        public final void a() {
            if (this.f64087e != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(StringUtil.ARRAY_START);
                for (Map.Entry entry : this.f64087e.entrySet()) {
                    stringBuffer.append("\"");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("\":\"");
                    stringBuffer.append(entry.getValue().toString().replace("\"", "\\\""));
                    stringBuffer.append("\",");
                }
                StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.subSequence(0, stringBuffer.length() - 1));
                stringBuffer2.append("}");
                this.f64088f.w(stringBuffer2.toString());
            }
            try {
                this.f64088f.x(m.d().I());
                this.f64088f.u(String.valueOf(System.currentTimeMillis()));
                this.f64088f.t(this.f64089g);
                this.f64088f.s(this.f64090h == null ? "" : this.f64090h);
                new c.b().c(this.f64088f);
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    d.b.m0.a.f.a.b(e2.getMessage());
                }
            }
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        com.baidu.ubs.analytics.a.a aVar = new com.baidu.ubs.analytics.a.a();
        aVar.v(str);
        d.b.m0.a.f.b.c(new a(map, aVar, str2, str3));
    }
}
