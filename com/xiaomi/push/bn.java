package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes12.dex */
public class bn implements ge {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4816a = false;

    /* renamed from: a  reason: collision with other field name */
    private fs f130a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f133a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f129a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fv f131a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f132a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements fx, gf {

        /* renamed from: a  reason: collision with other field name */
        String f134a;

        a(boolean z) {
            this.f134a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fx
        public void a(fl flVar) {
            if (bn.f4816a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f133a.format(new Date()) + this.f134a + flVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f133a.format(new Date()) + this.f134a + " Blob [" + flVar.m281a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public void a(gj gjVar) {
            if (bn.f4816a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f133a.format(new Date()) + this.f134a + " PKT " + gjVar.m317a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f133a.format(new Date()) + this.f134a + " PKT [" + gjVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + gjVar.j() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public boolean a(gj gjVar) {
            return true;
        }
    }

    public bn(fs fsVar) {
        this.f130a = null;
        this.f130a = fsVar;
        a();
    }

    private void a() {
        this.f129a = new a(true);
        this.b = new a(false);
        this.f130a.a(this.f129a, this.f129a);
        this.f130a.b(this.b, this.b);
        this.f131a = new bo(this);
    }
}
