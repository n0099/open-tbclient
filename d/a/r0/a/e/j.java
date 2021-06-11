package d.a.r0.a.e;

import com.baidu.android.common.others.lang.StringUtil;
import d.a.r0.a.c;
import java.util.Map;
/* loaded from: classes5.dex */
public final class j {

    /* loaded from: classes5.dex */
    public static class a extends d.a.r0.a.f.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f68148e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.baidu.ubs.analytics.a.a f68149f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f68150g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f68151h;

        public a(Map map, com.baidu.ubs.analytics.a.a aVar, String str, String str2) {
            this.f68148e = map;
            this.f68149f = aVar;
            this.f68150g = str;
            this.f68151h = str2;
        }

        @Override // d.a.r0.a.f.c
        public final void a() {
            if (this.f68148e != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(StringUtil.ARRAY_START);
                for (Map.Entry entry : this.f68148e.entrySet()) {
                    stringBuffer.append("\"");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("\":\"");
                    stringBuffer.append(entry.getValue().toString().replace("\"", "\\\""));
                    stringBuffer.append("\",");
                }
                StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.subSequence(0, stringBuffer.length() - 1));
                stringBuffer2.append("}");
                this.f68149f.w(stringBuffer2.toString());
            }
            try {
                this.f68149f.x(m.d().I());
                this.f68149f.u(String.valueOf(System.currentTimeMillis()));
                this.f68149f.t(this.f68150g);
                this.f68149f.s(this.f68151h == null ? "" : this.f68151h);
                new c.b().c(this.f68149f);
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
