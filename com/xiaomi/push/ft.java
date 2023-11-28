package com.xiaomi.push;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.video.VideoItemModel;
import com.xiaomi.push.dw;
import com.xiaomi.push.fv;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
/* loaded from: classes10.dex */
public class ft implements gh {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    public fv f396a;

    /* renamed from: a  reason: collision with other field name */
    public SimpleDateFormat f399a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    public a f395a = null;
    public a b = null;

    /* renamed from: a  reason: collision with other field name */
    public fy f397a = null;

    /* renamed from: a  reason: collision with other field name */
    public final String f398a = "[Slim] ";

    /* loaded from: classes10.dex */
    public class a implements ga, gi {

        /* renamed from: a  reason: collision with other field name */
        public String f400a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f401a;

        public a(boolean z) {
            this.f401a = true;
            this.f401a = z;
            this.f400a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.ga
        public void a(fk fkVar) {
            StringBuilder sb;
            String str;
            if (ft.a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(ft.this.f399a.format(new Date()));
                sb.append(this.f400a);
                str = fkVar.toString();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(ft.this.f399a.format(new Date()));
                sb.append(this.f400a);
                sb.append(" Blob [");
                sb.append(fkVar.m492a());
                sb.append(",");
                sb.append(fkVar.a());
                sb.append(",");
                sb.append(com.xiaomi.push.service.bd.a(fkVar.e()));
                str = PreferencesUtil.RIGHT_MOUNT;
            }
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
            if (fkVar == null || fkVar.a() != 99999) {
                return;
            }
            String m492a = fkVar.m492a();
            fk fkVar2 = null;
            if (!this.f401a) {
                if ("BIND".equals(m492a)) {
                    com.xiaomi.channel.commonutils.logger.b.m190a("build binded result for loopback.");
                    dw.d dVar = new dw.d();
                    dVar.a(true);
                    dVar.c("login success.");
                    dVar.b("success");
                    dVar.a("success");
                    fk fkVar3 = new fk();
                    fkVar3.a(dVar.m456a(), (String) null);
                    fkVar3.a((short) 2);
                    fkVar3.a(VideoItemModel.TYPE_LOADING);
                    fkVar3.a("BIND", (String) null);
                    fkVar3.a(fkVar.e());
                    fkVar3.b((String) null);
                    fkVar3.c(fkVar.g());
                    fkVar2 = fkVar3;
                } else if (!"UBND".equals(m492a) && "SECMSG".equals(m492a)) {
                    fk fkVar4 = new fk();
                    fkVar4.a(VideoItemModel.TYPE_LOADING);
                    fkVar4.a("SECMSG", (String) null);
                    fkVar4.c(fkVar.g());
                    fkVar4.a(fkVar.e());
                    fkVar4.a(fkVar.m494a());
                    fkVar4.b(fkVar.f());
                    fkVar4.a(fkVar.m497a(com.xiaomi.push.service.bg.a().a(String.valueOf((int) VideoItemModel.TYPE_LOADING), fkVar.g()).h), (String) null);
                    fkVar2 = fkVar4;
                }
            }
            if (fkVar2 != null) {
                for (Map.Entry<ga, fv.a> entry : ft.this.f396a.m515a().entrySet()) {
                    if (ft.this.f395a != entry.getKey()) {
                        entry.getValue().a(fkVar2);
                    }
                }
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.gi.a(Lcom/xiaomi/push/gm;)Z */
        @Override // com.xiaomi.push.ga
        public void a(gm gmVar) {
            StringBuilder sb;
            String str;
            if (ft.a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(ft.this.f399a.format(new Date()));
                sb.append(this.f400a);
                sb.append(" PKT ");
                str = gmVar.mo539a();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(ft.this.f399a.format(new Date()));
                sb.append(this.f400a);
                sb.append(" PKT [");
                sb.append(gmVar.k());
                sb.append(",");
                sb.append(gmVar.j());
                str = PreferencesUtil.RIGHT_MOUNT;
            }
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.ga.a(Lcom/xiaomi/push/gm;)V */
        @Override // com.xiaomi.push.gi
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo510a(gm gmVar) {
            return true;
        }
    }

    public ft(fv fvVar) {
        this.f396a = null;
        this.f396a = fvVar;
        a();
    }

    private void a() {
        this.f395a = new a(true);
        this.b = new a(false);
        fv fvVar = this.f396a;
        a aVar = this.f395a;
        fvVar.a(aVar, aVar);
        fv fvVar2 = this.f396a;
        a aVar2 = this.b;
        fvVar2.b(aVar2, aVar2);
        this.f397a = new fu(this);
    }
}
