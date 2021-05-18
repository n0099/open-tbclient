package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.push.du;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes7.dex */
public class fd {

    /* renamed from: a  reason: collision with root package name */
    public int f37647a;

    /* renamed from: a  reason: collision with other field name */
    public fh f368a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f369a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f372a;

    /* renamed from: b  reason: collision with root package name */
    public int f37648b;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f370a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    public ByteBuffer f373b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f371a = new Adler32();

    public fd(OutputStream outputStream, fh fhVar) {
        this.f369a = new BufferedOutputStream(outputStream);
        this.f368a = fhVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f37647a = timeZone.getRawOffset() / 3600000;
        this.f37648b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fa faVar) {
        int c2 = faVar.c();
        if (c2 > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Blob size=" + c2 + " should be less than 32768 Drop blob chid=" + faVar.a() + " id=" + faVar.e());
            return 0;
        }
        this.f370a.clear();
        int i2 = c2 + 8 + 4;
        if (i2 > this.f370a.capacity() || this.f370a.capacity() > 4096) {
            this.f370a = ByteBuffer.allocate(i2);
        }
        this.f370a.putShort((short) -15618);
        this.f370a.putShort((short) 5);
        this.f370a.putInt(c2);
        int position = this.f370a.position();
        this.f370a = faVar.mo290a(this.f370a);
        if (!"CONN".equals(faVar.m289a())) {
            if (this.f372a == null) {
                this.f372a = this.f368a.a();
            }
            com.xiaomi.push.service.be.a(this.f372a, this.f370a.array(), true, position, c2);
        }
        this.f371a.reset();
        this.f371a.update(this.f370a.array(), 0, this.f370a.position());
        this.f373b.putInt(0, (int) this.f371a.getValue());
        this.f369a.write(this.f370a.array(), 0, this.f370a.position());
        this.f369a.write(this.f373b.array(), 0, 4);
        this.f369a.flush();
        int position2 = this.f370a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + faVar.m289a() + ";chid=" + faVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        du.e eVar = new du.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m624a());
        eVar.c(com.xiaomi.push.service.bi.m599a());
        eVar.b(43);
        eVar.d(this.f368a.m311b());
        eVar.e(this.f368a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m317a = this.f368a.m307a().m317a();
        if (m317a != null) {
            eVar.a(du.b.a(m317a));
        }
        fa faVar = new fa();
        faVar.a(0);
        faVar.a("CONN", (String) null);
        faVar.a(0L, "xiaomi.com", null);
        faVar.a(eVar.m268a(), (String) null);
        a(faVar);
        com.xiaomi.channel.commonutils.logger.b.m57a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=43 hash=" + com.xiaomi.push.service.bi.m599a() + " tz=" + this.f37647a + ":" + this.f37648b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fa faVar = new fa();
        faVar.a("CLOSE", (String) null);
        a(faVar);
        this.f369a.close();
    }
}
