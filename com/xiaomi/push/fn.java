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
    private fq f348a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f349a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f352a;
    private int b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f350a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f353b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f351a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(OutputStream outputStream, fq fqVar) {
        this.f349a = new BufferedOutputStream(outputStream);
        this.f348a = fqVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fl flVar) {
        int c = flVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m51a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + flVar.a() + " id=" + flVar.e());
            return 0;
        }
        this.f350a.clear();
        if (c + 8 + 4 > this.f350a.capacity() || this.f350a.capacity() > 4096) {
            this.f350a = ByteBuffer.allocate(c + 8 + 4);
        }
        this.f350a.putShort((short) -15618);
        this.f350a.putShort((short) 5);
        this.f350a.putInt(c);
        int position = this.f350a.position();
        this.f350a = flVar.mo278a(this.f350a);
        if (!"CONN".equals(flVar.m277a())) {
            if (this.f352a == null) {
                this.f352a = this.f348a.a();
            }
            com.xiaomi.push.service.ay.a(this.f352a, this.f350a.array(), true, position, c);
        }
        this.f351a.reset();
        this.f351a.update(this.f350a.array(), 0, this.f350a.position());
        this.f353b.putInt(0, (int) this.f351a.getValue());
        this.f349a.write(this.f350a.array(), 0, this.f350a.position());
        this.f349a.write(this.f353b.array(), 0, 4);
        this.f349a.flush();
        int position2 = this.f350a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + flVar.m277a() + ";chid=" + flVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        ek.e eVar = new ek.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m581a());
        eVar.c(com.xiaomi.push.service.be.m556a());
        eVar.b(39);
        eVar.d(this.f348a.b());
        eVar.e(this.f348a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m300a = this.f348a.a().m300a();
        if (m300a != null) {
            eVar.a(ek.b.a(m300a));
        }
        fl flVar = new fl();
        flVar.a(0);
        flVar.a("CONN", (String) null);
        flVar.a(0L, "xiaomi.com", null);
        flVar.a(eVar.a(), (String) null);
        a(flVar);
        com.xiaomi.channel.commonutils.logger.b.m51a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=39 hash=" + com.xiaomi.push.service.be.m556a() + " tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fl flVar = new fl();
        flVar.a("CLOSE", (String) null);
        a(flVar);
        this.f349a.close();
    }
}
