package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes8.dex */
public class bi implements fy {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private fm f144a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f147a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f143a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fp f145a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f146a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a implements fr, fz {

        /* renamed from: a  reason: collision with other field name */
        String f148a;

        a(boolean z) {
            this.f148a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fr
        public void a(ff ffVar) {
            if (bi.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f147a.format(new Date()) + this.f148a + ffVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f147a.format(new Date()) + this.f148a + " Blob [" + ffVar.m272a() + Constants.ACCEPT_TIME_SEPARATOR_SP + ffVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + ffVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fr, com.xiaomi.push.fz
        public void a(gd gdVar) {
            if (bi.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f147a.format(new Date()) + this.f148a + " PKT " + gdVar.m308a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f147a.format(new Date()) + this.f148a + " PKT [" + gdVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + gdVar.j() + "]");
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
        this.f144a = null;
        this.f144a = fmVar;
        a();
    }

    private void a() {
        this.f143a = new a(true);
        this.b = new a(false);
        this.f144a.a(this.f143a, this.f143a);
        this.f144a.b(this.b, this.b);
        this.f145a = new bj(this);
    }
}
