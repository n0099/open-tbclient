package com.xiaomi.push;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes6.dex */
public class bn implements ge {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f13886a = false;

    /* renamed from: a  reason: collision with other field name */
    private fs f208a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f211a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f207a = null;

    /* renamed from: b  reason: collision with root package name */
    private a f13887b = null;

    /* renamed from: a  reason: collision with other field name */
    private fv f209a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f210a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements fx, gf {

        /* renamed from: a  reason: collision with other field name */
        String f212a;

        a(boolean z) {
            this.f212a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fx
        public void a(fl flVar) {
            if (bn.f13886a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f211a.format(new Date()) + this.f212a + flVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f211a.format(new Date()) + this.f212a + " Blob [" + flVar.m306a() + "," + flVar.a() + "," + flVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public void a(gj gjVar) {
            if (bn.f13886a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f211a.format(new Date()) + this.f212a + " PKT " + gjVar.m342a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bn.this.f211a.format(new Date()) + this.f212a + " PKT [" + gjVar.k() + "," + gjVar.j() + "]");
            }
        }

        @Override // com.xiaomi.push.fx, com.xiaomi.push.gf
        public boolean a(gj gjVar) {
            return true;
        }
    }

    public bn(fs fsVar) {
        this.f208a = null;
        this.f208a = fsVar;
        a();
    }

    private void a() {
        this.f207a = new a(true);
        this.f13887b = new a(false);
        this.f208a.a(this.f207a, this.f207a);
        this.f208a.b(this.f13887b, this.f13887b);
        this.f209a = new bo(this);
    }
}
