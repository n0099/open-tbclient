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
    public fr f386a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f387a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f390a;
    public int b;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f388a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    public ByteBuffer f391b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f389a = new Adler32();

    public fn(OutputStream outputStream, fr frVar) {
        this.f387a = new BufferedOutputStream(outputStream);
        this.f386a = frVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fk fkVar) {
        int c = fkVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m178a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + fkVar.a() + " id=" + fkVar.e());
            return 0;
        }
        this.f388a.clear();
        int i = c + 8 + 4;
        if (i > this.f388a.capacity() || this.f388a.capacity() > 4096) {
            this.f388a = ByteBuffer.allocate(i);
        }
        this.f388a.putShort((short) -15618);
        this.f388a.putShort((short) 5);
        this.f388a.putInt(c);
        int position = this.f388a.position();
        this.f388a = fkVar.mo481a(this.f388a);
        if (!"CONN".equals(fkVar.m480a())) {
            if (this.f390a == null) {
                this.f390a = this.f386a.m495a();
            }
            com.xiaomi.push.service.bp.a(this.f390a, this.f388a.array(), true, position, c);
        }
        this.f389a.reset();
        this.f389a.update(this.f388a.array(), 0, this.f388a.position());
        this.f391b.putInt(0, (int) this.f389a.getValue());
        this.f387a.write(this.f388a.array(), 0, this.f388a.position());
        this.f387a.write(this.f391b.array(), 0, 4);
        this.f387a.flush();
        int position2 = this.f388a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + fkVar.m480a() + ";chid=" + fkVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        dw.e eVar = new dw.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(s.m721a());
        eVar.c(com.xiaomi.push.service.bv.m802a());
        eVar.b(48);
        eVar.d(this.f386a.m504b());
        eVar.e(this.f386a.mo502a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] mo510a = this.f386a.m501a().mo510a();
        if (mo510a != null) {
            eVar.a(dw.b.a(mo510a));
        }
        fk fkVar = new fk();
        fkVar.a(0);
        fkVar.a("CONN", (String) null);
        fkVar.a(0L, "xiaomi.com", null);
        fkVar.a(eVar.m444a(), (String) null);
        a(fkVar);
        com.xiaomi.channel.commonutils.logger.b.m178a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=48 tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fk fkVar = new fk();
        fkVar.a("CLOSE", (String) null);
        a(fkVar);
        this.f387a.close();
    }
}
