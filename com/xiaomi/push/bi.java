package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes8.dex */
public class bi implements fy {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private fm f143a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f146a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f142a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fp f144a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f145a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a implements fr, fz {

        /* renamed from: a  reason: collision with other field name */
        String f147a;

        a(boolean z) {
            this.f147a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fr
        public void a(ff ffVar) {
            if (bi.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f146a.format(new Date()) + this.f147a + ffVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f146a.format(new Date()) + this.f147a + " Blob [" + ffVar.m269a() + Constants.ACCEPT_TIME_SEPARATOR_SP + ffVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + ffVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fr, com.xiaomi.push.fz
        public void a(gd gdVar) {
            if (bi.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f146a.format(new Date()) + this.f147a + " PKT " + gdVar.m305a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f146a.format(new Date()) + this.f147a + " PKT [" + gdVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + gdVar.j() + "]");
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
        this.f143a = null;
        this.f143a = fmVar;
        a();
    }

    private void a() {
        this.f142a = new a(true);
        this.b = new a(false);
        this.f143a.a(this.f142a, this.f142a);
        this.f143a.b(this.b, this.b);
        this.f144a = new bj(this);
    }
}
