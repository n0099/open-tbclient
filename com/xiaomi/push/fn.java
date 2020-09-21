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
    private fq f349a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f350a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f353a;
    private int b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f351a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f354b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f352a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(OutputStream outputStream, fq fqVar) {
        this.f350a = new BufferedOutputStream(outputStream);
        this.f349a = fqVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fl flVar) {
        int c = flVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + flVar.a() + " id=" + flVar.e());
            return 0;
        }
        this.f351a.clear();
        if (c + 8 + 4 > this.f351a.capacity() || this.f351a.capacity() > 4096) {
            this.f351a = ByteBuffer.allocate(c + 8 + 4);
        }
        this.f351a.putShort((short) -15618);
        this.f351a.putShort((short) 5);
        this.f351a.putInt(c);
        int position = this.f351a.position();
        this.f351a = flVar.mo281a(this.f351a);
        if (!"CONN".equals(flVar.m280a())) {
            if (this.f353a == null) {
                this.f353a = this.f349a.a();
            }
            com.xiaomi.push.service.ay.a(this.f353a, this.f351a.array(), true, position, c);
        }
        this.f352a.reset();
        this.f352a.update(this.f351a.array(), 0, this.f351a.position());
        this.f354b.putInt(0, (int) this.f352a.getValue());
        this.f350a.write(this.f351a.array(), 0, this.f351a.position());
        this.f350a.write(this.f354b.array(), 0, 4);
        this.f350a.flush();
        int position2 = this.f351a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + flVar.m280a() + ";chid=" + flVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        ek.e eVar = new ek.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m584a());
        eVar.c(com.xiaomi.push.service.be.m559a());
        eVar.b(39);
        eVar.d(this.f349a.b());
        eVar.e(this.f349a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m303a = this.f349a.a().m303a();
        if (m303a != null) {
            eVar.a(ek.b.a(m303a));
        }
        fl flVar = new fl();
        flVar.a(0);
        flVar.a("CONN", (String) null);
        flVar.a(0L, "xiaomi.com", null);
        flVar.a(eVar.a(), (String) null);
        a(flVar);
        com.xiaomi.channel.commonutils.logger.b.m54a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=39 hash=" + com.xiaomi.push.service.be.m559a() + " tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fl flVar = new fl();
        flVar.a("CLOSE", (String) null);
        a(flVar);
        this.f350a.close();
    }
}
