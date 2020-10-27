package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes12.dex */
public class bn implements ge {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4814a = false;

    /* renamed from: a  reason: collision with other field name */
    private fs f127a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f130a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f126a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fv f128a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f129a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements fx, gf {

        /* renamed from: a  reason: collision with other field name */
        String f131a;

        a(boolean z) {
            this.f131a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fx
        public void a(fl flVar) {
            if (bn.f4814a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f130a.format(new Date()) + this.f131a + flVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f130a.format(new Date()) + this.f131a + " Blob [" + flVar.m280a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public void a(gj gjVar) {
            if (bn.f4814a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f130a.format(new Date()) + this.f131a + " PKT " + gjVar.m316a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f130a.format(new Date()) + this.f131a + " PKT [" + gjVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + gjVar.j() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public boolean a(gj gjVar) {
            return true;
        }
    }

    public bn(fs fsVar) {
        this.f127a = null;
        this.f127a = fsVar;
        a();
    }

    private void a() {
        this.f126a = new a(true);
        this.b = new a(false);
        this.f127a.a(this.f126a, this.f126a);
        this.f127a.b(this.b, this.b);
        this.f128a = new bo(this);
    }
}
