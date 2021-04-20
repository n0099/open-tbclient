package d.b.m0.a.e;

import com.baidu.android.common.others.lang.StringUtil;
import d.b.m0.a.c;
import java.util.Map;
/* loaded from: classes5.dex */
public final class j {

    /* loaded from: classes5.dex */
    public static class a extends d.b.m0.a.f.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f64816e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.baidu.ubs.analytics.a.a f64817f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f64818g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f64819h;

        public a(Map map, com.baidu.ubs.analytics.a.a aVar, String str, String str2) {
            this.f64816e = map;
            this.f64817f = aVar;
            this.f64818g = str;
            this.f64819h = str2;
        }

        @Override // d.b.m0.a.f.c
        public final void a() {
            if (this.f64816e != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(StringUtil.ARRAY_START);
                for (Map.Entry entry : this.f64816e.entrySet()) {
                    stringBuffer.append("\"");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("\":\"");
                    stringBuffer.append(entry.getValue().toString().replace("\"", "\\\""));
                    stringBuffer.append("\",");
                }
                StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.subSequence(0, stringBuffer.length() - 1));
                stringBuffer2.append("}");
                this.f64817f.w(stringBuffer2.toString());
            }
            try {
                this.f64817f.x(m.d().I());
                this.f64817f.u(String.valueOf(System.currentTimeMillis()));
                this.f64817f.t(this.f64818g);
                this.f64817f.s(this.f64819h == null ? "" : this.f64819h);
                new c.b().c(this.f64817f);
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
