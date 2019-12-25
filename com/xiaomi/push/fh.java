package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.push.ee;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes5.dex */
public class fh {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fk f367a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f368a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f371a;
    private int b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f369a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f372b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f370a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(OutputStream outputStream, fk fkVar) {
        this.f368a = new BufferedOutputStream(outputStream);
        this.f367a = fkVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(ff ffVar) {
        int c = ffVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m33a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + ffVar.a() + " id=" + ffVar.e());
            return 0;
        }
        this.f369a.clear();
        if (c + 8 + 4 > this.f369a.capacity() || this.f369a.capacity() > 4096) {
            this.f369a = ByteBuffer.allocate(c + 8 + 4);
        }
        this.f369a.putShort((short) -15618);
        this.f369a.putShort((short) 5);
        this.f369a.putInt(c);
        int position = this.f369a.position();
        this.f369a = ffVar.mo256a(this.f369a);
        if (!"CONN".equals(ffVar.m255a())) {
            if (this.f371a == null) {
                this.f371a = this.f367a.a();
            }
            com.xiaomi.push.service.au.a(this.f371a, this.f369a.array(), true, position, c);
        }
        this.f370a.reset();
        this.f370a.update(this.f369a.array(), 0, this.f369a.position());
        this.f372b.putInt(0, (int) this.f370a.getValue());
        this.f368a.write(this.f369a.array(), 0, this.f369a.position());
        this.f368a.write(this.f372b.array(), 0, 4);
        this.f368a.flush();
        int position2 = this.f369a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + ffVar.m255a() + ";chid=" + ffVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        ee.e eVar = new ee.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m548a());
        eVar.c(com.xiaomi.push.service.ba.m512a());
        eVar.b(38);
        eVar.d(this.f367a.b());
        eVar.e(this.f367a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m278a = this.f367a.a().m278a();
        if (m278a != null) {
            eVar.a(ee.b.a(m278a));
        }
        ff ffVar = new ff();
        ffVar.a(0);
        ffVar.a("CONN", (String) null);
        ffVar.a(0L, "xiaomi.com", null);
        ffVar.a(eVar.a(), (String) null);
        a(ffVar);
        com.xiaomi.channel.commonutils.logger.b.m33a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=38 hash=" + com.xiaomi.push.service.ba.m512a() + " tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        ff ffVar = new ff();
        ffVar.a("CLOSE", (String) null);
        a(ffVar);
        this.f368a.close();
    }
}
