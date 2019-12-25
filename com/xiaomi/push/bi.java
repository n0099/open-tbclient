package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes5.dex */
public class bi implements fy {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private fm f148a;

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f151a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private a f147a = null;
    private a b = null;

    /* renamed from: a  reason: collision with other field name */
    private fp f149a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f150a = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements fr, fz {

        /* renamed from: a  reason: collision with other field name */
        String f152a;

        a(boolean z) {
            this.f152a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fr
        public void a(ff ffVar) {
            if (bi.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f151a.format(new Date()) + this.f152a + ffVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f151a.format(new Date()) + this.f152a + " Blob [" + ffVar.m255a() + Constants.ACCEPT_TIME_SEPARATOR_SP + ffVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + ffVar.e() + "]");
            }
        }

        @Override // com.xiaomi.push.fr, com.xiaomi.push.fz
        public void a(gd gdVar) {
            if (bi.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f151a.format(new Date()) + this.f152a + " PKT " + gdVar.m291a());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + bi.this.f151a.format(new Date()) + this.f152a + " PKT [" + gdVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + gdVar.j() + "]");
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
        this.f148a = null;
        this.f148a = fmVar;
        a();
    }

    private void a() {
        this.f147a = new a(true);
        this.b = new a(false);
        this.f148a.a(this.f147a, this.f147a);
        this.f148a.b(this.b, this.b);
        this.f149a = new bj(this);
    }
}
