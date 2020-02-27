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
    private fk f363a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f364a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f367a;
    private int b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f365a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f368b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f366a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(OutputStream outputStream, fk fkVar) {
        this.f364a = new BufferedOutputStream(outputStream);
        this.f363a = fkVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(ff ffVar) {
        int c = ffVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m47a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + ffVar.a() + " id=" + ffVar.e());
            return 0;
        }
        this.f365a.clear();
        if (c + 8 + 4 > this.f365a.capacity() || this.f365a.capacity() > 4096) {
            this.f365a = ByteBuffer.allocate(c + 8 + 4);
        }
        this.f365a.putShort((short) -15618);
        this.f365a.putShort((short) 5);
        this.f365a.putInt(c);
        int position = this.f365a.position();
        this.f365a = ffVar.mo270a(this.f365a);
        if (!"CONN".equals(ffVar.m269a())) {
            if (this.f367a == null) {
                this.f367a = this.f363a.a();
            }
            com.xiaomi.push.service.au.a(this.f367a, this.f365a.array(), true, position, c);
        }
        this.f366a.reset();
        this.f366a.update(this.f365a.array(), 0, this.f365a.position());
        this.f368b.putInt(0, (int) this.f366a.getValue());
        this.f364a.write(this.f365a.array(), 0, this.f365a.position());
        this.f364a.write(this.f368b.array(), 0, 4);
        this.f364a.flush();
        int position2 = this.f365a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + ffVar.m269a() + ";chid=" + ffVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        ee.e eVar = new ee.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m562a());
        eVar.c(com.xiaomi.push.service.ba.m526a());
        eVar.b(38);
        eVar.d(this.f363a.b());
        eVar.e(this.f363a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m292a = this.f363a.a().m292a();
        if (m292a != null) {
            eVar.a(ee.b.a(m292a));
        }
        ff ffVar = new ff();
        ffVar.a(0);
        ffVar.a("CONN", (String) null);
        ffVar.a(0L, "xiaomi.com", null);
        ffVar.a(eVar.a(), (String) null);
        a(ffVar);
        com.xiaomi.channel.commonutils.logger.b.m47a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=38 hash=" + com.xiaomi.push.service.ba.m526a() + " tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        ff ffVar = new ff();
        ffVar.a("CLOSE", (String) null);
        a(ffVar);
        this.f364a.close();
    }
}
