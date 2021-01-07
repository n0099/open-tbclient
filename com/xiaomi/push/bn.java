package com.xiaomi.push;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes6.dex */
public class bn implements ge {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14184a = false;

    /* renamed from: a  reason: collision with other field name */
    private fs f209a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f212a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f208a = null;

    /* renamed from: b  reason: collision with root package name */
    private a f14185b = null;

    /* renamed from: a  reason: collision with other field name */
    private fv f210a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f211a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements fx, gf {

        /* renamed from: a  reason: collision with other field name */
        String f213a;

        a(boolean z) {
            this.f213a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fx
        public void a(fl flVar) {
            if (bn.f14184a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f212a.format(new Date()) + this.f213a + flVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f212a.format(new Date()) + this.f213a + " Blob [" + flVar.m310a() + "," + flVar.a() + "," + flVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public void a(gj gjVar) {
            if (bn.f14184a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f212a.format(new Date()) + this.f213a + " PKT " + gjVar.m346a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f212a.format(new Date()) + this.f213a + " PKT [" + gjVar.k() + "," + gjVar.j() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public boolean a(gj gjVar) {
            return true;
        }
    }

    public bn(fs fsVar) {
        this.f209a = null;
        this.f209a = fsVar;
        a();
    }

    private void a() {
        this.f208a = new a(true);
        this.f14185b = new a(false);
        this.f209a.a(this.f208a, this.f208a);
        this.f209a.b(this.f14185b, this.f14185b);
        this.f210a = new bo(this);
    }
}
