package com.qq.e.comm.plugin.w;

import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.services.RetCodeService;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes4.dex */
public class d {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f12973a = Pattern.compile("^http\\://v\\.gdt\\.qq\\.com/gdt_stats\\.fcg\\?viewid=([^&]*).*");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f12974b = Pattern.compile(".*[?&]viewid=([^&]*).*");

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f12975a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, Object> f12976b;

        public int a() {
            return this.f12975a;
        }

        public void a(int i) {
            this.f12975a = i;
        }

        public void a(Map<String, Object> map) {
            this.f12976b = map;
        }

        public Map<String, Object> b() {
            return this.f12976b;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void a(int i, Exception exc);
    }

    /* loaded from: classes4.dex */
    private static class c implements com.qq.e.comm.plugin.t.b {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f12977a;

        /* renamed from: b  reason: collision with root package name */
        final String f12978b;
        final com.qq.e.comm.plugin.ad.e c;
        final String d;
        final m e;
        final long f;
        final a g;
        final b h;

        c(List<String> list, String str, com.qq.e.comm.plugin.ad.e eVar, String str2, m mVar, a aVar, long j, b bVar) {
            this.f12977a = list;
            this.f12978b = str;
            this.c = eVar;
            this.d = str2;
            this.e = mVar;
            this.g = aVar;
            this.f = j;
            this.h = bVar;
        }

        @Override // com.qq.e.comm.plugin.t.b
        public void a(com.qq.e.comm.plugin.t.b.e eVar, com.qq.e.comm.plugin.t.b.f fVar) {
            int e = fVar == null ? 0 : fVar.e();
            if (e == 200 || e == 204) {
                d.a(this.f12977a, this.f12978b, "", this.e, (int) (System.currentTimeMillis() - this.f), e, this.g);
                if (this.h != null) {
                    this.h.a();
                }
            } else {
                d.a(this.f12977a, this.f12978b, "HttpStatus error", this.e, (int) (System.currentTimeMillis() - this.f), e, this.g);
                if (this.h != null) {
                    this.h.a(e, null);
                }
            }
            boolean z = e == 204;
            RetCodeService.getInstance().send(new RetCodeService.RetCodeInfo("v.gdt.qq.com", "gdt_stats.fcg?" + this.c, Constants.ACCEPT_TIME_SEPARATOR_SERVER, z ? 0 : e, (int) (System.currentTimeMillis() - this.f), 0, 0, z ? 1 : 2));
        }

        @Override // com.qq.e.comm.plugin.t.b
        public void a(Exception exc) {
            d.a(this.f12977a, this.f12978b, exc.getMessage(), this.e, (int) (System.currentTimeMillis() - this.f), -1, this.g);
            if (this.h != null) {
                this.h.a(0, exc);
            }
            RetCodeService.getInstance().send(new RetCodeService.RetCodeInfo("v.gdt.qq.com", "gdt_stats.fcg?" + this.c, Constants.ACCEPT_TIME_SEPARATOR_SERVER, 1, (int) (System.currentTimeMillis() - this.f), 0, 0, 2));
        }
    }

    private static String a() {
        return (String) gdtadv.getobjresult(108, 1, new Object[0]);
    }

    private static String a(String str) {
        return (String) gdtadv.getobjresult(109, 1, str);
    }

    public static void a(int i, int i2, int i3, int i4, int i5, int i6, String str, com.qq.e.comm.plugin.w.b bVar, b bVar2) {
        gdtadv.getVresult(110, 1, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str, bVar, bVar2);
    }

    public static void a(a aVar, List<String> list, com.qq.e.comm.plugin.w.b bVar, b bVar2) {
        gdtadv.getVresult(111, 1, aVar, list, bVar, bVar2);
    }

    public static void a(String str, int i, String str2, com.qq.e.comm.plugin.w.b bVar, b bVar2) {
        gdtadv.getVresult(112, 1, str, Integer.valueOf(i), str2, bVar, bVar2);
    }

    static /* synthetic */ void a(List list, String str, String str2, m mVar, int i, int i2, a aVar) {
        gdtadv.getVresult(113, 1, list, str, str2, mVar, Integer.valueOf(i), Integer.valueOf(i2), aVar);
    }

    private static void b(List<String> list, String str, String str2, m mVar, int i, int i2, a aVar) {
        gdtadv.getVresult(114, 1, list, str, str2, mVar, Integer.valueOf(i), Integer.valueOf(i2), aVar);
    }
}
