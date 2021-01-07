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
    private int f14322a;

    /* renamed from: a  reason: collision with other field name */
    private fq f429a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f430a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f433a;

    /* renamed from: b  reason: collision with root package name */
    private int f14323b;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f431a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f434b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f432a = new Adler32();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(OutputStream outputStream, fq fqVar) {
        this.f430a = new BufferedOutputStream(outputStream);
        this.f429a = fqVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f14322a = timeZone.getRawOffset() / 3600000;
        this.f14323b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fl flVar) {
        int c = flVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m84a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + flVar.a() + " id=" + flVar.e());
            return 0;
        }
        this.f431a.clear();
        if (c + 8 + 4 > this.f431a.capacity() || this.f431a.capacity() > 4096) {
            this.f431a = ByteBuffer.allocate(c + 8 + 4);
        }
        this.f431a.putShort((short) -15618);
        this.f431a.putShort((short) 5);
        this.f431a.putInt(c);
        int position = this.f431a.position();
        this.f431a = flVar.mo311a(this.f431a);
        if (!"CONN".equals(flVar.m310a())) {
            if (this.f433a == null) {
                this.f433a = this.f429a.a();
            }
            com.xiaomi.push.service.ay.a(this.f433a, this.f431a.array(), true, position, c);
        }
        this.f432a.reset();
        this.f432a.update(this.f431a.array(), 0, this.f431a.position());
        this.f434b.putInt(0, (int) this.f432a.getValue());
        this.f430a.write(this.f431a.array(), 0, this.f431a.position());
        this.f430a.write(this.f434b.array(), 0, 4);
        this.f430a.flush();
        int position2 = this.f431a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + flVar.m310a() + ";chid=" + flVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        ek.e eVar = new ek.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(t.m614a());
        eVar.c(com.xiaomi.push.service.be.m589a());
        eVar.b(39);
        eVar.d(this.f429a.b());
        eVar.e(this.f429a.a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] m333a = this.f429a.a().m333a();
        if (m333a != null) {
            eVar.a(ek.b.a(m333a));
        }
        fl flVar = new fl();
        flVar.a(0);
        flVar.a("CONN", (String) null);
        flVar.a(0L, "xiaomi.com", null);
        flVar.a(eVar.a(), (String) null);
        a(flVar);
        com.xiaomi.channel.commonutils.logger.b.m84a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=39 hash=" + com.xiaomi.push.service.be.m589a() + " tz=" + this.f14322a + ":" + this.f14323b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fl flVar = new fl();
        flVar.a("CLOSE", (String) null);
        a(flVar);
        this.f430a.close();
    }
}
