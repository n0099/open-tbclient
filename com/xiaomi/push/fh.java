package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.push.ee;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes6.dex */
public class fh {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fk f365a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f366a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f369a;
    private int b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f367a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f370b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f368a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(OutputStream outputStream, fk fkVar) {
        this.f366a = new BufferedOutputStream(outputStream);
        this.f365a = fkVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(ff ffVar) {
        int c = ffVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m42a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + ffVar.a() + " id=" + ffVar.e());
            return 0;
        }
        this.f367a.clear();
        if (c + 8 + 4 > this.f367a.capacity() || this.f367a.capacity() > 4096) {
            this.f367a = ByteBuffer.allocate(c + 8 + 4);
        }
        this.f367a.putShort((short) -15618);
        this.f367a.putShort((short) 5);
        this.f367a.putInt(c);
        int position = this.f367a.position();
        this.f367a = ffVar.mo265a(this.f367a);
        if (!"CONN".equals(ffVar.m264a())) {
            if (this.f369a == null) {
                this.f369a = this.f365a.a();
            }
            com.xiaomi.push.service.au.a(this.f369a, this.f367a.array(), true, position, c);
        }
        this.f368a.reset();
        this.f368a.update(this.f367a.array(), 0, this.f367a.position());
        this.f370b.putInt(0, (int) this.f368a.getValue());
        this.f366a.write(this.f367a.array(), 0, this.f367a.position());
        this.f366a.write(this.f370b.array(), 0, 4);
        this.f366a.flush();
        int position2 = this.f367a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + ffVar.m264a() + ";chid=" + ffVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        ee.e eVar = new ee.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m557a());
        eVar.c(com.xiaomi.push.service.ba.m521a());
        eVar.b(38);
        eVar.d(this.f365a.b());
        eVar.e(this.f365a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m287a = this.f365a.a().m287a();
        if (m287a != null) {
            eVar.a(ee.b.a(m287a));
        }
        ff ffVar = new ff();
        ffVar.a(0);
        ffVar.a("CONN", (String) null);
        ffVar.a(0L, "xiaomi.com", null);
        ffVar.a(eVar.a(), (String) null);
        a(ffVar);
        com.xiaomi.channel.commonutils.logger.b.m42a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=38 hash=" + com.xiaomi.push.service.ba.m521a() + " tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        ff ffVar = new ff();
        ffVar.a("CLOSE", (String) null);
        a(ffVar);
        this.f366a.close();
    }
}
