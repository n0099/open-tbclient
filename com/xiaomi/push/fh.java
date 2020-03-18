package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.push.ee;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes8.dex */
public class fh {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fk f362a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f363a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f366a;
    private int b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f364a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f367b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f365a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(OutputStream outputStream, fk fkVar) {
        this.f363a = new BufferedOutputStream(outputStream);
        this.f362a = fkVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(ff ffVar) {
        int c = ffVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m45a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + ffVar.a() + " id=" + ffVar.e());
            return 0;
        }
        this.f364a.clear();
        if (c + 8 + 4 > this.f364a.capacity() || this.f364a.capacity() > 4096) {
            this.f364a = ByteBuffer.allocate(c + 8 + 4);
        }
        this.f364a.putShort((short) -15618);
        this.f364a.putShort((short) 5);
        this.f364a.putInt(c);
        int position = this.f364a.position();
        this.f364a = ffVar.mo268a(this.f364a);
        if (!"CONN".equals(ffVar.m267a())) {
            if (this.f366a == null) {
                this.f366a = this.f362a.a();
            }
            com.xiaomi.push.service.au.a(this.f366a, this.f364a.array(), true, position, c);
        }
        this.f365a.reset();
        this.f365a.update(this.f364a.array(), 0, this.f364a.position());
        this.f367b.putInt(0, (int) this.f365a.getValue());
        this.f363a.write(this.f364a.array(), 0, this.f364a.position());
        this.f363a.write(this.f367b.array(), 0, 4);
        this.f363a.flush();
        int position2 = this.f364a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + ffVar.m267a() + ";chid=" + ffVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        ee.e eVar = new ee.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m560a());
        eVar.c(com.xiaomi.push.service.ba.m524a());
        eVar.b(38);
        eVar.d(this.f362a.b());
        eVar.e(this.f362a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m290a = this.f362a.a().m290a();
        if (m290a != null) {
            eVar.a(ee.b.a(m290a));
        }
        ff ffVar = new ff();
        ffVar.a(0);
        ffVar.a("CONN", (String) null);
        ffVar.a(0L, "xiaomi.com", null);
        ffVar.a(eVar.a(), (String) null);
        a(ffVar);
        com.xiaomi.channel.commonutils.logger.b.m45a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=38 hash=" + com.xiaomi.push.service.ba.m524a() + " tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        ff ffVar = new ff();
        ffVar.a("CLOSE", (String) null);
        a(ffVar);
        this.f363a.close();
    }
}
