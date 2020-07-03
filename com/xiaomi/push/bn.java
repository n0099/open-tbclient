package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes8.dex */
public class bn implements ge {
    public static boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    private fs f134a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f137a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f133a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fv f135a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f136a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a implements fx, gf {

        /* renamed from: a  reason: collision with other field name */
        String f138a;

        a(boolean z) {
            this.f138a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fx
        public void a(fl flVar) {
            if (bn.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f137a.format(new Date()) + this.f138a + flVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f137a.format(new Date()) + this.f138a + " Blob [" + flVar.m274a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + flVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public void a(gj gjVar) {
            if (bn.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f137a.format(new Date()) + this.f138a + " PKT " + gjVar.m310a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f137a.format(new Date()) + this.f138a + " PKT [" + gjVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + gjVar.j() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public boolean a(gj gjVar) {
            return true;
        }
    }

    public bn(fs fsVar) {
        this.f134a = null;
        this.f134a = fsVar;
        a();
    }

    private void a() {
        this.f133a = new a(true);
        this.b = new a(false);
        this.f134a.a(this.f133a, this.f133a);
        this.f134a.b(this.b, this.b);
        this.f135a = new bo(this);
    }
}
