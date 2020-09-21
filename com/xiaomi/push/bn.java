package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes9.dex */
public class bn implements ge {
    public static boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    private fs f129a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f132a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f128a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fv f130a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f131a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements fx, gf {

        /* renamed from: a  reason: collision with other field name */
        String f133a;

        a(boolean z) {
            this.f133a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fx
        public void a(fl flVar) {
            if (bn.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f132a.format(new Date()) + this.f133a + flVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f132a.format(new Date()) + this.f133a + " Blob [" + flVar.m280a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public void a(gj gjVar) {
            if (bn.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f132a.format(new Date()) + this.f133a + " PKT " + gjVar.m316a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f132a.format(new Date()) + this.f133a + " PKT [" + gjVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + gjVar.j() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public boolean a(gj gjVar) {
            return true;
        }
    }

    public bn(fs fsVar) {
        this.f129a = null;
        this.f129a = fsVar;
        a();
    }

    private void a() {
        this.f128a = new a(true);
        this.b = new a(false);
        this.f129a.a(this.f128a, this.f128a);
        this.f129a.b(this.b, this.b);
        this.f130a = new bo(this);
    }
}
