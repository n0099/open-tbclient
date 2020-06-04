package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes8.dex */
public class bn implements ge {
    public static boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    private fs f128a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f131a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f127a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fv f129a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f130a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a implements fx, gf {

        /* renamed from: a  reason: collision with other field name */
        String f132a;

        a(boolean z) {
            this.f132a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fx
        public void a(fl flVar) {
            if (bn.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f131a.format(new Date()) + this.f132a + flVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f131a.format(new Date()) + this.f132a + " Blob [" + flVar.m277a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public void a(gj gjVar) {
            if (bn.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f131a.format(new Date()) + this.f132a + " PKT " + gjVar.m313a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f131a.format(new Date()) + this.f132a + " PKT [" + gjVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + gjVar.j() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public boolean a(gj gjVar) {
            return true;
        }
    }

    public bn(fs fsVar) {
        this.f128a = null;
        this.f128a = fsVar;
        a();
    }

    private void a() {
        this.f127a = new a(true);
        this.b = new a(false);
        this.f128a.a(this.f127a, this.f127a);
        this.f128a.b(this.b, this.b);
        this.f129a = new bo(this);
    }
}
