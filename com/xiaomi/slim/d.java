package com.xiaomi.slim;

import android.os.Build;
import com.xiaomi.push.protobuf.b;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.bh;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes3.dex */
public class d {
    ByteBuffer a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);
    private Adler32 c = new Adler32();
    private g d;
    private OutputStream e;
    private int f;
    private int g;
    private byte[] h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(OutputStream outputStream, g gVar) {
        this.e = new BufferedOutputStream(outputStream);
        this.d = gVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f = timeZone.getRawOffset() / 3600000;
        this.g = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(b bVar) {
        int l = bVar.l();
        if (l > 32768) {
            com.xiaomi.channel.commonutils.logger.b.a("Blob size=" + l + " should be less than 32768 Drop blob chid=" + bVar.c() + " id=" + bVar.h());
            return 0;
        }
        this.a.clear();
        if (l + 8 + 4 > this.a.capacity() || this.a.capacity() > 4096) {
            this.a = ByteBuffer.allocate(l + 8 + 4);
        }
        this.a.putShort((short) -15618);
        this.a.putShort((short) 5);
        this.a.putInt(l);
        int position = this.a.position();
        this.a = bVar.a(this.a);
        if (!"CONN".equals(bVar.a())) {
            if (this.h == null) {
                this.h = this.d.a();
            }
            bb.a(this.h, this.a.array(), true, position, l);
        }
        this.c.reset();
        this.c.update(this.a.array(), 0, this.a.position());
        this.b.putInt(0, (int) this.c.getValue());
        this.e.write(this.a.array(), 0, this.a.position());
        this.e.write(this.b.array(), 0, 4);
        this.e.flush();
        int position2 = this.a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + bVar.a() + ";chid=" + bVar.c() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        b.e eVar = new b.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(Build.VERSION.INCREMENTAL);
        eVar.c(bh.e());
        eVar.b(37);
        eVar.d(this.d.f());
        eVar.e(this.d.e());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] a = this.d.d().a();
        if (a != null) {
            eVar.a(b.C0492b.b(a));
        }
        b bVar = new b();
        bVar.a(0);
        bVar.a("CONN", (String) null);
        bVar.a(0L, "xiaomi.com", null);
        bVar.a(eVar.c(), (String) null);
        a(bVar);
        com.xiaomi.channel.commonutils.logger.b.a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=37 hash=" + bh.e() + " tz=" + this.f + ":" + this.g + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        b bVar = new b();
        bVar.a("CLOSE", (String) null);
        a(bVar);
        this.e.close();
    }
}
