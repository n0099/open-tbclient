package d.a.n0.a.e;

import com.baidu.android.common.others.lang.StringUtil;
import d.a.n0.a.c;
import java.util.Map;
/* loaded from: classes5.dex */
public final class j {

    /* loaded from: classes5.dex */
    public static class a extends d.a.n0.a.f.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f63395e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.baidu.ubs.analytics.a.a f63396f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f63397g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f63398h;

        public a(Map map, com.baidu.ubs.analytics.a.a aVar, String str, String str2) {
            this.f63395e = map;
            this.f63396f = aVar;
            this.f63397g = str;
            this.f63398h = str2;
        }

        @Override // d.a.n0.a.f.c
        public final void a() {
            if (this.f63395e != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(StringUtil.ARRAY_START);
                for (Map.Entry entry : this.f63395e.entrySet()) {
                    stringBuffer.append("\"");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("\":\"");
                    stringBuffer.append(entry.getValue().toString().replace("\"", "\\\""));
                    stringBuffer.append("\",");
                }
                StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.subSequence(0, stringBuffer.length() - 1));
                stringBuffer2.append("}");
                this.f63396f.w(stringBuffer2.toString());
            }
            try {
                this.f63396f.x(m.d().I());
                this.f63396f.u(String.valueOf(System.currentTimeMillis()));
                this.f63396f.t(this.f63397g);
                this.f63396f.s(this.f63398h == null ? "" : this.f63398h);
                new c.b().c(this.f63396f);
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    d.a.n0.a.f.a.b(e2.getMessage());
                }
            }
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        com.baidu.ubs.analytics.a.a aVar = new com.baidu.ubs.analytics.a.a();
        aVar.v(str);
        d.a.n0.a.f.b.c(new a(map, aVar, str2, str3));
    }
}
