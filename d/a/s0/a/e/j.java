package d.a.s0.a.e;

import com.baidu.android.common.others.lang.StringUtil;
import d.a.s0.a.c;
import java.util.Map;
/* loaded from: classes5.dex */
public final class j {

    /* loaded from: classes5.dex */
    public static class a extends d.a.s0.a.f.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f68264e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.baidu.ubs.analytics.a.a f68265f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f68266g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f68267h;

        public a(Map map, com.baidu.ubs.analytics.a.a aVar, String str, String str2) {
            this.f68264e = map;
            this.f68265f = aVar;
            this.f68266g = str;
            this.f68267h = str2;
        }

        @Override // d.a.s0.a.f.c
        public final void a() {
            if (this.f68264e != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(StringUtil.ARRAY_START);
                for (Map.Entry entry : this.f68264e.entrySet()) {
                    stringBuffer.append("\"");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("\":\"");
                    stringBuffer.append(entry.getValue().toString().replace("\"", "\\\""));
                    stringBuffer.append("\",");
                }
                StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.subSequence(0, stringBuffer.length() - 1));
                stringBuffer2.append("}");
                this.f68265f.w(stringBuffer2.toString());
            }
            try {
                this.f68265f.x(m.d().I());
                this.f68265f.u(String.valueOf(System.currentTimeMillis()));
                this.f68265f.t(this.f68266g);
                this.f68265f.s(this.f68267h == null ? "" : this.f68267h);
                new c.b().c(this.f68265f);
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    d.a.s0.a.f.a.b(e2.getMessage());
                }
            }
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        com.baidu.ubs.analytics.a.a aVar = new com.baidu.ubs.analytics.a.a();
        aVar.v(str);
        d.a.s0.a.f.b.c(new a(map, aVar, str2, str3));
    }
}
