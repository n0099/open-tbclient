package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes6.dex */
public class bi implements fy {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private fm f146a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f149a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f145a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fp f147a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f148a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements fr, fz {

        /* renamed from: a  reason: collision with other field name */
        String f150a;

        a(boolean z) {
            this.f150a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fr
        public void a(ff ffVar) {
            if (bi.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f149a.format(new Date()) + this.f150a + ffVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f149a.format(new Date()) + this.f150a + " Blob [" + ffVar.m264a() + Constants.ACCEPT_TIME_SEPARATOR_SP + ffVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + ffVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fr, com.xiaomi.push.fz
        public void a(gd gdVar) {
            if (bi.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f149a.format(new Date()) + this.f150a + " PKT " + gdVar.m300a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f149a.format(new Date()) + this.f150a + " PKT [" + gdVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + gdVar.j() + "]");
            }
        }

        @Override // com.xiaomi.push.fr, com.xiaomi.push.fz
        public boolean a(gd gdVar) {
            return true;
        }
    }

    static {
        a = t.a() == 1;
    }

    public bi(fm fmVar) {
        this.f146a = null;
        this.f146a = fmVar;
        a();
    }

    private void a() {
        this.f145a = new a(true);
        this.b = new a(false);
        this.f146a.a(this.f145a, this.f145a);
        this.f146a.b(this.b, this.b);
        this.f147a = new bj(this);
    }
}
