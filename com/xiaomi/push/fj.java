package com.xiaomi.push;

import com.xiaomi.push.du;
import com.xiaomi.push.fl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
/* loaded from: classes7.dex */
public class fj implements fx {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41263a = false;

    /* renamed from: a  reason: collision with other field name */
    public fl f382a;

    /* renamed from: a  reason: collision with other field name */
    public SimpleDateFormat f385a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    public a f381a = null;

    /* renamed from: b  reason: collision with root package name */
    public a f41264b = null;

    /* renamed from: a  reason: collision with other field name */
    public fo f383a = null;

    /* renamed from: a  reason: collision with other field name */
    public final String f384a = "[Slim] ";

    /* loaded from: classes7.dex */
    public class a implements fq, fy {

        /* renamed from: a  reason: collision with other field name */
        public String f386a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f387a;

        public a(boolean z) {
            this.f387a = true;
            this.f387a = z;
            this.f386a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fq
        public void a(fa faVar) {
            StringBuilder sb;
            String str;
            if (fj.f41263a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(fj.this.f385a.format(new Date()));
                sb.append(this.f386a);
                str = faVar.toString();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(fj.this.f385a.format(new Date()));
                sb.append(this.f386a);
                sb.append(" Blob [");
                sb.append(faVar.m288a());
                sb.append(",");
                sb.append(faVar.a());
                sb.append(",");
                sb.append(faVar.e());
                str = "]";
            }
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
            if (faVar == null || faVar.a() != 99999) {
                return;
            }
            String m288a = faVar.m288a();
            fa faVar2 = null;
            if (!this.f387a) {
                if ("BIND".equals(m288a)) {
                    com.xiaomi.channel.commonutils.logger.b.m56a("build binded result for loopback.");
                    du.d dVar = new du.d();
                    dVar.a(true);
                    dVar.c("login success.");
                    dVar.b("success");
                    dVar.a("success");
                    fa faVar3 = new fa();
                    faVar3.a(dVar.m267a(), (String) null);
                    faVar3.a((short) 2);
                    faVar3.a(99999);
                    faVar3.a("BIND", (String) null);
                    faVar3.a(faVar.e());
                    faVar3.b(null);
                    faVar3.c(faVar.g());
                    faVar2 = faVar3;
                } else if (!"UBND".equals(m288a) && "SECMSG".equals(m288a)) {
                    fa faVar4 = new fa();
                    faVar4.a(99999);
                    faVar4.a("SECMSG", (String) null);
                    faVar4.c(faVar.g());
                    faVar4.a(faVar.e());
                    faVar4.a(faVar.m290a());
                    faVar4.b(faVar.f());
                    faVar4.a(faVar.m293a(com.xiaomi.push.service.av.a().a(String.valueOf(99999), faVar.g()).f41749h), (String) null);
                    faVar2 = faVar4;
                }
            }
            if (faVar2 != null) {
                for (Map.Entry<fq, fl.a> entry : fj.this.f382a.m308a().entrySet()) {
                    if (fj.this.f381a != entry.getKey()) {
                        entry.getValue().a(faVar2);
                    }
                }
            }
        }

        @Override // com.xiaomi.push.fq, com.xiaomi.push.fy
        public void a(gc gcVar) {
            StringBuilder sb;
            String str;
            if (fj.f41263a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(fj.this.f385a.format(new Date()));
                sb.append(this.f386a);
                sb.append(" PKT ");
                str = gcVar.m331a();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(fj.this.f385a.format(new Date()));
                sb.append(this.f386a);
                sb.append(" PKT [");
                sb.append(gcVar.k());
                sb.append(",");
                sb.append(gcVar.j());
                str = "]";
            }
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
        }

        @Override // com.xiaomi.push.fq, com.xiaomi.push.fy
        public boolean a(gc gcVar) {
            return true;
        }
    }

    public fj(fl flVar) {
        this.f382a = null;
        this.f382a = flVar;
        a();
    }

    private void a() {
        this.f381a = new a(true);
        this.f41264b = new a(false);
        fl flVar = this.f382a;
        a aVar = this.f381a;
        flVar.a(aVar, aVar);
        fl flVar2 = this.f382a;
        a aVar2 = this.f41264b;
        flVar2.b(aVar2, aVar2);
        this.f383a = new fk(this);
    }
}
