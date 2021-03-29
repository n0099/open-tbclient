package d.b.i0.o.e;

import com.baidu.tieba.ad.statis.CustomALSHttpMessage;
/* loaded from: classes4.dex */
public class a implements d.b.i0.a3.a {

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f57207a = new a();
    }

    public static a g() {
        return b.f57207a;
    }

    @Override // d.b.i0.a3.a
    public void a(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
        init.addParam("f1", "cardclick");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    @Override // d.b.i0.a3.a
    public void b(long j, String str, String str2, long j2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
        init.addParam("f1", "pagetime");
        init.addParam("f2", str2);
        init.addParam("f3", j + "");
        init.addParam("f4", str);
        init.addParam("f5", j2);
        init.send();
    }

    @Override // d.b.i0.a3.a
    public void c(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
        init.addParam("f1", "cardshow");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    @Override // d.b.i0.a3.a
    public void d(String str, String str2, String str3) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
        init.addParam("f1", "alert_click");
        init.addParam("f2", str);
        init.addParam("f5", str2);
        init.addParam("extf", str3);
        init.send();
    }

    @Override // d.b.i0.a3.a
    public void e(long j, String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
        init.addParam("f1", "pageshow");
        init.addParam("f2", str2);
        init.addParam("f3", j + "");
        init.addParam("f4", str);
        init.send();
    }

    @Override // d.b.i0.a3.a
    public void f(String str, String str2) {
        CustomALSHttpMessage init = new CustomALSHttpMessage().init("1001", "every_log");
        init.addParam("f1", "fullvideoshow");
        init.addParam("f2", str2);
        init.addParam("extf", str);
        init.send();
    }

    public a() {
    }
}
