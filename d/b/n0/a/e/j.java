package d.b.n0.a.e;

import com.baidu.android.common.others.lang.StringUtil;
import d.b.n0.a.c;
import java.util.Map;
/* loaded from: classes5.dex */
public final class j {

    /* loaded from: classes5.dex */
    public static class a extends d.b.n0.a.f.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f65084e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.baidu.ubs.analytics.a.a f65085f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f65086g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f65087h;

        public a(Map map, com.baidu.ubs.analytics.a.a aVar, String str, String str2) {
            this.f65084e = map;
            this.f65085f = aVar;
            this.f65086g = str;
            this.f65087h = str2;
        }

        @Override // d.b.n0.a.f.c
        public final void a() {
            if (this.f65084e != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(StringUtil.ARRAY_START);
                for (Map.Entry entry : this.f65084e.entrySet()) {
                    stringBuffer.append("\"");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("\":\"");
                    stringBuffer.append(entry.getValue().toString().replace("\"", "\\\""));
                    stringBuffer.append("\",");
                }
                StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.subSequence(0, stringBuffer.length() - 1));
                stringBuffer2.append("}");
                this.f65085f.w(stringBuffer2.toString());
            }
            try {
                this.f65085f.x(m.d().I());
                this.f65085f.u(String.valueOf(System.currentTimeMillis()));
                this.f65085f.t(this.f65086g);
                this.f65085f.s(this.f65087h == null ? "" : this.f65087h);
                new c.b().c(this.f65085f);
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    d.b.n0.a.f.a.b(e2.getMessage());
                }
            }
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        com.baidu.ubs.analytics.a.a aVar = new com.baidu.ubs.analytics.a.a();
        aVar.v(str);
        d.b.n0.a.f.b.c(new a(map, aVar, str2, str3));
    }
}
