package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.push.ek;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes9.dex */
public class fn {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fq f354a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f355a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f358a;
    private int b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f356a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f359b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f357a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(OutputStream outputStream, fq fqVar) {
        this.f355a = new BufferedOutputStream(outputStream);
        this.f354a = fqVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fl flVar) {
        int c = flVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m49a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + flVar.a() + " id=" + flVar.e());
            return 0;
        }
        this.f356a.clear();
        if (c + 8 + 4 > this.f356a.capacity() || this.f356a.capacity() > 4096) {
            this.f356a = ByteBuffer.allocate(c + 8 + 4);
        }
        this.f356a.putShort((short) -15618);
        this.f356a.putShort((short) 5);
        this.f356a.putInt(c);
        int position = this.f356a.position();
        this.f356a = flVar.mo276a(this.f356a);
        if (!"CONN".equals(flVar.m275a())) {
            if (this.f358a == null) {
                this.f358a = this.f354a.a();
            }
            com.xiaomi.push.service.ay.a(this.f358a, this.f356a.array(), true, position, c);
        }
        this.f357a.reset();
        this.f357a.update(this.f356a.array(), 0, this.f356a.position());
        this.f359b.putInt(0, (int) this.f357a.getValue());
        this.f355a.write(this.f356a.array(), 0, this.f356a.position());
        this.f355a.write(this.f359b.array(), 0, 4);
        this.f355a.flush();
        int position2 = this.f356a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + flVar.m275a() + ";chid=" + flVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        ek.e eVar = new ek.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m579a());
        eVar.c(com.xiaomi.push.service.be.m554a());
        eVar.b(39);
        eVar.d(this.f354a.b());
        eVar.e(this.f354a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m298a = this.f354a.a().m298a();
        if (m298a != null) {
            eVar.a(ek.b.a(m298a));
        }
        fl flVar = new fl();
        flVar.a(0);
        flVar.a("CONN", (String) null);
        flVar.a(0L, "xiaomi.com", null);
        flVar.a(eVar.a(), (String) null);
        a(flVar);
        com.xiaomi.channel.commonutils.logger.b.m49a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=39 hash=" + com.xiaomi.push.service.be.m554a() + " tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fl flVar = new fl();
        flVar.a("CLOSE", (String) null);
        a(flVar);
        this.f355a.close();
    }
}
