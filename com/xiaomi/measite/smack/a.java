package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.smack.d;
import com.xiaomi.smack.f;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class a implements com.xiaomi.smack.debugger.a {
    public static boolean a;
    private com.xiaomi.smack.a c;
    private SimpleDateFormat b = new SimpleDateFormat("hh:mm:ss aaa");
    private C0347a d = null;
    private C0347a e = null;
    private d f = null;
    private final String g = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.measite.smack.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0347a implements f, com.xiaomi.smack.filter.a {
        String a;

        C0347a(boolean z) {
            this.a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.smack.f
        public void a(com.xiaomi.slim.b bVar) {
            if (a.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + a.this.b.format(new Date()) + this.a + bVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + a.this.b.format(new Date()) + this.a + " Blob [" + bVar.a() + "," + bVar.c() + "," + bVar.h() + "]");
            }
        }

        @Override // com.xiaomi.smack.filter.a
        public boolean a(com.xiaomi.smack.packet.d dVar) {
            return true;
        }

        @Override // com.xiaomi.smack.f
        public void b(com.xiaomi.smack.packet.d dVar) {
            if (a.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + a.this.b.format(new Date()) + this.a + " PKT " + dVar.c());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + a.this.b.format(new Date()) + this.a + " PKT [" + dVar.l() + "," + dVar.k() + "]");
            }
        }
    }

    static {
        a = j.c() == 1;
    }

    public a(com.xiaomi.smack.a aVar) {
        this.c = null;
        this.c = aVar;
        a();
    }

    private void a() {
        this.d = new C0347a(true);
        this.e = new C0347a(false);
        this.c.a(this.d, this.d);
        this.c.b(this.e, this.e);
        this.f = new b(this);
    }
}
