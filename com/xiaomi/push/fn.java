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
    public fr f382a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f383a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f386a;
    public int b;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f384a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    public ByteBuffer f387b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f385a = new Adler32();

    public fn(OutputStream outputStream, fr frVar) {
        this.f383a = new BufferedOutputStream(outputStream);
        this.f382a = frVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fk fkVar) {
        int c = fkVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m190a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + fkVar.a() + " id=" + fkVar.e());
            return 0;
        }
        this.f384a.clear();
        int i = c + 8 + 4;
        if (i > this.f384a.capacity() || this.f384a.capacity() > 4096) {
            this.f384a = ByteBuffer.allocate(i);
        }
        this.f384a.putShort((short) -15618);
        this.f384a.putShort((short) 5);
        this.f384a.putInt(c);
        int position = this.f384a.position();
        this.f384a = fkVar.mo493a(this.f384a);
        if (!"CONN".equals(fkVar.m492a())) {
            if (this.f386a == null) {
                this.f386a = this.f382a.m507a();
            }
            com.xiaomi.push.service.bp.a(this.f386a, this.f384a.array(), true, position, c);
        }
        this.f385a.reset();
        this.f385a.update(this.f384a.array(), 0, this.f384a.position());
        this.f387b.putInt(0, (int) this.f385a.getValue());
        this.f383a.write(this.f384a.array(), 0, this.f384a.position());
        this.f383a.write(this.f387b.array(), 0, 4);
        this.f383a.flush();
        int position2 = this.f384a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + fkVar.m492a() + ";chid=" + fkVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        dw.e eVar = new dw.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(s.m733a());
        eVar.c(com.xiaomi.push.service.bv.m814a());
        eVar.b(48);
        eVar.d(this.f382a.m516b());
        eVar.e(this.f382a.mo514a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] mo522a = this.f382a.m513a().mo522a();
        if (mo522a != null) {
            eVar.a(dw.b.a(mo522a));
        }
        fk fkVar = new fk();
        fkVar.a(0);
        fkVar.a("CONN", (String) null);
        fkVar.a(0L, "xiaomi.com", null);
        fkVar.a(eVar.m456a(), (String) null);
        a(fkVar);
        com.xiaomi.channel.commonutils.logger.b.m190a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=48 tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fk fkVar = new fk();
        fkVar.a("CLOSE", (String) null);
        a(fkVar);
        this.f383a.close();
    }
}
