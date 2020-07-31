package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes9.dex */
public class bn implements ge {
    public static boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    private fs f131a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f134a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f130a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fv f132a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f133a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements fx, gf {

        /* renamed from: a  reason: collision with other field name */
        String f135a;

        a(boolean z) {
            this.f135a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fx
        public void a(fl flVar) {
            if (bn.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f134a.format(new Date()) + this.f135a + flVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f134a.format(new Date()) + this.f135a + " Blob [" + flVar.m275a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public void a(gj gjVar) {
            if (bn.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f134a.format(new Date()) + this.f135a + " PKT " + gjVar.m311a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f134a.format(new Date()) + this.f135a + " PKT [" + gjVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + gjVar.j() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public boolean a(gj gjVar) {
            return true;
        }
    }

    public bn(fs fsVar) {
        this.f131a = null;
        this.f131a = fsVar;
        a();
    }

    private void a() {
        this.f130a = new a(true);
        this.b = new a(false);
        this.f131a.a(this.f130a, this.f130a);
        this.f131a.b(this.b, this.b);
        this.f132a = new bo(this);
    }
}
