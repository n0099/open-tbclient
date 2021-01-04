package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.push.ek;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes6.dex */
public class fn {

    /* renamed from: a  reason: collision with root package name */
    private int f14321a;

    /* renamed from: a  reason: collision with other field name */
    private fq f428a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f429a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f432a;

    /* renamed from: b  reason: collision with root package name */
    private int f14322b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f430a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f433b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f431a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(OutputStream outputStream, fq fqVar) {
        this.f429a = new BufferedOutputStream(outputStream);
        this.f428a = fqVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f14321a = timeZone.getRawOffset() / 3600000;
        this.f14322b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fl flVar) {
        int c = flVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + flVar.a() + " id=" + flVar.e());
            return 0;
        }
        this.f430a.clear();
        if (c + 8 + 4 > this.f430a.capacity() || this.f430a.capacity() > 4096) {
            this.f430a = ByteBuffer.allocate(c + 8 + 4);
        }
        this.f430a.putShort((short) -15618);
        this.f430a.putShort((short) 5);
        this.f430a.putInt(c);
        int position = this.f430a.position();
        this.f430a = flVar.mo300a(this.f430a);
        if (!"CONN".equals(flVar.m299a())) {
            if (this.f432a == null) {
                this.f432a = this.f428a.a();
            }
            com.xiaomi.push.service.ay.a(this.f432a, this.f430a.array(), true, position, c);
        }
        this.f431a.reset();
        this.f431a.update(this.f430a.array(), 0, this.f430a.position());
        this.f433b.putInt(0, (int) this.f431a.getValue());
        this.f429a.write(this.f430a.array(), 0, this.f430a.position());
        this.f429a.write(this.f433b.array(), 0, 4);
        this.f429a.flush();
        int position2 = this.f430a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + flVar.m299a() + ";chid=" + flVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        ek.e eVar = new ek.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m603a());
        eVar.c(com.xiaomi.push.service.be.m578a());
        eVar.b(39);
        eVar.d(this.f428a.b());
        eVar.e(this.f428a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m322a = this.f428a.a().m322a();
        if (m322a != null) {
            eVar.a(ek.b.a(m322a));
        }
        fl flVar = new fl();
        flVar.a(0);
        flVar.a("CONN", (String) null);
        flVar.a(0L, "xiaomi.com", null);
        flVar.a(eVar.a(), (String) null);
        a(flVar);
        com.xiaomi.channel.commonutils.logger.b.m73a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=39 hash=" + com.xiaomi.push.service.be.m578a() + " tz=" + this.f14321a + ":" + this.f14322b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fl flVar = new fl();
        flVar.a("CLOSE", (String) null);
        a(flVar);
        this.f429a.close();
    }
}
