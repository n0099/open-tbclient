package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.push.dw;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes10.dex */
public class fn {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public fr f387a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f388a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f391a;
    public int b;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f389a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    public ByteBuffer f392b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f390a = new Adler32();

    public fn(OutputStream outputStream, fr frVar) {
        this.f388a = new BufferedOutputStream(outputStream);
        this.f387a = frVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fk fkVar) {
        int c = fkVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m180a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + fkVar.a() + " id=" + fkVar.e());
            return 0;
        }
        this.f389a.clear();
        int i = c + 8 + 4;
        if (i > this.f389a.capacity() || this.f389a.capacity() > 4096) {
            this.f389a = ByteBuffer.allocate(i);
        }
        this.f389a.putShort((short) -15618);
        this.f389a.putShort((short) 5);
        this.f389a.putInt(c);
        int position = this.f389a.position();
        this.f389a = fkVar.mo483a(this.f389a);
        if (!"CONN".equals(fkVar.m482a())) {
            if (this.f391a == null) {
                this.f391a = this.f387a.m497a();
            }
            com.xiaomi.push.service.bp.a(this.f391a, this.f389a.array(), true, position, c);
        }
        this.f390a.reset();
        this.f390a.update(this.f389a.array(), 0, this.f389a.position());
        this.f392b.putInt(0, (int) this.f390a.getValue());
        this.f388a.write(this.f389a.array(), 0, this.f389a.position());
        this.f388a.write(this.f392b.array(), 0, 4);
        this.f388a.flush();
        int position2 = this.f389a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + fkVar.m482a() + ";chid=" + fkVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        dw.e eVar = new dw.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(s.m723a());
        eVar.c(com.xiaomi.push.service.bv.m804a());
        eVar.b(48);
        eVar.d(this.f387a.m506b());
        eVar.e(this.f387a.mo504a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] mo512a = this.f387a.m503a().mo512a();
        if (mo512a != null) {
            eVar.a(dw.b.a(mo512a));
        }
        fk fkVar = new fk();
        fkVar.a(0);
        fkVar.a("CONN", (String) null);
        fkVar.a(0L, "xiaomi.com", null);
        fkVar.a(eVar.m446a(), (String) null);
        a(fkVar);
        com.xiaomi.channel.commonutils.logger.b.m180a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=48 tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fk fkVar = new fk();
        fkVar.a("CLOSE", (String) null);
        a(fkVar);
        this.f388a.close();
    }
}
