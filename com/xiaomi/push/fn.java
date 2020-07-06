package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.push.ek;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes8.dex */
public class fn {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fq f355a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f356a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f359a;
    private int b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f357a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f360b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f358a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(OutputStream outputStream, fq fqVar) {
        this.f356a = new BufferedOutputStream(outputStream);
        this.f355a = fqVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fl flVar) {
        int c = flVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m48a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + flVar.a() + " id=" + flVar.e());
            return 0;
        }
        this.f357a.clear();
        if (c + 8 + 4 > this.f357a.capacity() || this.f357a.capacity() > 4096) {
            this.f357a = ByteBuffer.allocate(c + 8 + 4);
        }
        this.f357a.putShort((short) -15618);
        this.f357a.putShort((short) 5);
        this.f357a.putInt(c);
        int position = this.f357a.position();
        this.f357a = flVar.mo275a(this.f357a);
        if (!"CONN".equals(flVar.m274a())) {
            if (this.f359a == null) {
                this.f359a = this.f355a.a();
            }
            com.xiaomi.push.service.ay.a(this.f359a, this.f357a.array(), true, position, c);
        }
        this.f358a.reset();
        this.f358a.update(this.f357a.array(), 0, this.f357a.position());
        this.f360b.putInt(0, (int) this.f358a.getValue());
        this.f356a.write(this.f357a.array(), 0, this.f357a.position());
        this.f356a.write(this.f360b.array(), 0, 4);
        this.f356a.flush();
        int position2 = this.f357a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + flVar.m274a() + ";chid=" + flVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        ek.e eVar = new ek.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m578a());
        eVar.c(com.xiaomi.push.service.be.m553a());
        eVar.b(39);
        eVar.d(this.f355a.b());
        eVar.e(this.f355a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m297a = this.f355a.a().m297a();
        if (m297a != null) {
            eVar.a(ek.b.a(m297a));
        }
        fl flVar = new fl();
        flVar.a(0);
        flVar.a("CONN", (String) null);
        flVar.a(0L, "xiaomi.com", null);
        flVar.a(eVar.a(), (String) null);
        a(flVar);
        com.xiaomi.channel.commonutils.logger.b.m48a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=39 hash=" + com.xiaomi.push.service.be.m553a() + " tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fl flVar = new fl();
        flVar.a("CLOSE", (String) null);
        a(flVar);
        this.f356a.close();
    }
}
