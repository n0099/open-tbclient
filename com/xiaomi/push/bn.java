package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes18.dex */
public class bn implements ge {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4816a = false;

    /* renamed from: a  reason: collision with other field name */
    private fs f132a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f135a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f131a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fv f133a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f134a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a implements fx, gf {

        /* renamed from: a  reason: collision with other field name */
        String f136a;

        a(boolean z) {
            this.f136a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fx
        public void a(fl flVar) {
            if (bn.f4816a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f135a.format(new Date()) + this.f136a + flVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f135a.format(new Date()) + this.f136a + " Blob [" + flVar.m283a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public void a(gj gjVar) {
            if (bn.f4816a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f135a.format(new Date()) + this.f136a + " PKT " + gjVar.m319a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f135a.format(new Date()) + this.f136a + " PKT [" + gjVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + gjVar.j() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public boolean a(gj gjVar) {
            return true;
        }
    }

    public bn(fs fsVar) {
        this.f132a = null;
        this.f132a = fsVar;
        a();
    }

    private void a() {
        this.f131a = new a(true);
        this.b = new a(false);
        this.f132a.a(this.f131a, this.f131a);
        this.f132a.b(this.b, this.b);
        this.f133a = new bo(this);
    }
}
