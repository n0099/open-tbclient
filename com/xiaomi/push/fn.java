package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.push.ek;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes12.dex */
public class fn {

    /* renamed from: a  reason: collision with root package name */
    private int f4905a;

    /* renamed from: a  reason: collision with other field name */
    private fq f347a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f348a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f351a;
    private int b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f349a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f352b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f350a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(OutputStream outputStream, fq fqVar) {
        this.f348a = new BufferedOutputStream(outputStream);
        this.f347a = fqVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f4905a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fl flVar) {
        int c = flVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + flVar.a() + " id=" + flVar.e());
            return 0;
        }
        this.f349a.clear();
        if (c + 8 + 4 > this.f349a.capacity() || this.f349a.capacity() > 4096) {
            this.f349a = ByteBuffer.allocate(c + 8 + 4);
        }
        this.f349a.putShort((short) -15618);
        this.f349a.putShort((short) 5);
        this.f349a.putInt(c);
        int position = this.f349a.position();
        this.f349a = flVar.mo281a(this.f349a);
        if (!"CONN".equals(flVar.m280a())) {
            if (this.f351a == null) {
                this.f351a = this.f347a.a();
            }
            com.xiaomi.push.service.ay.a(this.f351a, this.f349a.array(), true, position, c);
        }
        this.f350a.reset();
        this.f350a.update(this.f349a.array(), 0, this.f349a.position());
        this.f352b.putInt(0, (int) this.f350a.getValue());
        this.f348a.write(this.f349a.array(), 0, this.f349a.position());
        this.f348a.write(this.f352b.array(), 0, 4);
        this.f348a.flush();
        int position2 = this.f349a.position() + 4;
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
        eVar.d(this.f347a.b());
        eVar.e(this.f347a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m303a = this.f347a.a().m303a();
        if (m303a != null) {
            eVar.a(ek.b.a(m303a));
        }
        fl flVar = new fl();
        flVar.a(0);
        flVar.a("CONN", (String) null);
        flVar.a(0L, "xiaomi.com", null);
        flVar.a(eVar.a(), (String) null);
        a(flVar);
        com.xiaomi.channel.commonutils.logger.b.m54a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=39 hash=" + com.xiaomi.push.service.be.m559a() + " tz=" + this.f4905a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fl flVar = new fl();
        flVar.a("CLOSE", (String) null);
        a(flVar);
        this.f348a.close();
    }
}
