package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes8.dex */
public class bn implements ge {
    public static boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    private fs f135a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f138a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f134a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fv f136a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f137a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a implements fx, gf {

        /* renamed from: a  reason: collision with other field name */
        String f139a;

        a(boolean z) {
            this.f139a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fx
        public void a(fl flVar) {
            if (bn.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f138a.format(new Date()) + this.f139a + flVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f138a.format(new Date()) + this.f139a + " Blob [" + flVar.m274a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public void a(gj gjVar) {
            if (bn.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f138a.format(new Date()) + this.f139a + " PKT " + gjVar.m310a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f138a.format(new Date()) + this.f139a + " PKT [" + gjVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + gjVar.j() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public boolean a(gj gjVar) {
            return true;
        }
    }

    public bn(fs fsVar) {
        this.f135a = null;
        this.f135a = fsVar;
        a();
    }

    private void a() {
        this.f134a = new a(true);
        this.b = new a(false);
        this.f135a.a(this.f134a, this.f134a);
        this.f135a.b(this.b, this.b);
        this.f136a = new bo(this);
    }
}
