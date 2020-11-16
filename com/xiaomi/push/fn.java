package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.push.ek;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes18.dex */
public class fn {

    /* renamed from: a  reason: collision with root package name */
    private int f4907a;

    /* renamed from: a  reason: collision with other field name */
    private fq f352a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f353a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f356a;
    private int b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f354a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f357b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f355a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(OutputStream outputStream, fq fqVar) {
        this.f353a = new BufferedOutputStream(outputStream);
        this.f352a = fqVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f4907a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fl flVar) {
        int c = flVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + flVar.a() + " id=" + flVar.e());
            return 0;
        }
        this.f354a.clear();
        if (c + 8 + 4 > this.f354a.capacity() || this.f354a.capacity() > 4096) {
            this.f354a = ByteBuffer.allocate(c + 8 + 4);
        }
        this.f354a.putShort((short) -15618);
        this.f354a.putShort((short) 5);
        this.f354a.putInt(c);
        int position = this.f354a.position();
        this.f354a = flVar.mo284a(this.f354a);
        if (!"CONN".equals(flVar.m283a())) {
            if (this.f356a == null) {
                this.f356a = this.f352a.a();
            }
            com.xiaomi.push.service.ay.a(this.f356a, this.f354a.array(), true, position, c);
        }
        this.f355a.reset();
        this.f355a.update(this.f354a.array(), 0, this.f354a.position());
        this.f357b.putInt(0, (int) this.f355a.getValue());
        this.f353a.write(this.f354a.array(), 0, this.f354a.position());
        this.f353a.write(this.f357b.array(), 0, 4);
        this.f353a.flush();
        int position2 = this.f354a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + flVar.m283a() + ";chid=" + flVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        ek.e eVar = new ek.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m587a());
        eVar.c(com.xiaomi.push.service.be.m562a());
        eVar.b(39);
        eVar.d(this.f352a.b());
        eVar.e(this.f352a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m306a = this.f352a.a().m306a();
        if (m306a != null) {
            eVar.a(ek.b.a(m306a));
        }
        fl flVar = new fl();
        flVar.a(0);
        flVar.a("CONN", (String) null);
        flVar.a(0L, "xiaomi.com", null);
        flVar.a(eVar.a(), (String) null);
        a(flVar);
        com.xiaomi.channel.commonutils.logger.b.m57a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=39 hash=" + com.xiaomi.push.service.be.m562a() + " tz=" + this.f4907a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fl flVar = new fl();
        flVar.a("CLOSE", (String) null);
        a(flVar);
        this.f353a.close();
    }
}
