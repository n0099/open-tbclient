package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.du;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
/* loaded from: classes7.dex */
public class fc {

    /* renamed from: a  reason: collision with other field name */
    public fh f362a;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f363a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f366a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f367a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f364a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f41357b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f365a = new Adler32();

    /* renamed from: a  reason: collision with root package name */
    public ff f41356a = new ff();

    public fc(InputStream inputStream, fh fhVar) {
        this.f363a = new BufferedInputStream(inputStream);
        this.f362a = fhVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ByteBuffer a() {
        ByteBuffer allocate;
        int i2;
        this.f364a.clear();
        a(this.f364a, 8);
        short s = this.f364a.getShort(0);
        short s2 = this.f364a.getShort(2);
        if (s != -15618 || s2 != 5) {
            throw new IOException("Malformed Input");
        }
        int i3 = this.f364a.getInt(4);
        int position = this.f364a.position();
        if (i3 > 32768) {
            throw new IOException("Blob size too large");
        }
        if (i3 + 4 <= this.f364a.remaining()) {
            if (this.f364a.capacity() > 4096 && i3 < 2048) {
                allocate = ByteBuffer.allocate(2048);
                allocate.put(this.f364a.array(), 0, this.f364a.arrayOffset() + this.f364a.position());
            }
            a(this.f364a, i3);
            this.f41357b.clear();
            a(this.f41357b, 4);
            this.f41357b.position(0);
            i2 = this.f41357b.getInt();
            this.f365a.reset();
            this.f365a.update(this.f364a.array(), 0, this.f364a.position());
            if (i2 != ((int) this.f365a.getValue())) {
                byte[] bArr = this.f367a;
                if (bArr != null) {
                    com.xiaomi.push.service.be.a(bArr, this.f364a.array(), true, position, i3);
                }
                return this.f364a;
            }
            com.xiaomi.channel.commonutils.logger.b.m56a("CRC = " + ((int) this.f365a.getValue()) + " and " + i2);
            throw new IOException("Corrupted Blob bad CRC");
        }
        allocate = ByteBuffer.allocate(i3 + 2048);
        allocate.put(this.f364a.array(), 0, this.f364a.arrayOffset() + this.f364a.position());
        this.f364a = allocate;
        a(this.f364a, i3);
        this.f41357b.clear();
        a(this.f41357b, 4);
        this.f41357b.position(0);
        i2 = this.f41357b.getInt();
        this.f365a.reset();
        this.f365a.update(this.f364a.array(), 0, this.f364a.position());
        if (i2 != ((int) this.f365a.getValue())) {
        }
    }

    private void a(ByteBuffer byteBuffer, int i2) {
        int position = byteBuffer.position();
        do {
            int read = this.f363a.read(byteBuffer.array(), position, i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 -= read;
            position += read;
        } while (i2 > 0);
        byteBuffer.position(position);
    }

    private void c() {
        String str;
        StringBuilder sb;
        boolean z = false;
        this.f366a = false;
        fa m296a = m296a();
        if ("CONN".equals(m296a.m288a())) {
            du.f a2 = du.f.a(m296a.m292a());
            if (a2.a()) {
                this.f362a.a(a2.a());
                z = true;
            }
            if (a2.c()) {
                du.b a3 = a2.a();
                fa faVar = new fa();
                faVar.a("SYNC", "CONF");
                faVar.a(a3.m267a(), (String) null);
                this.f362a.a(faVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m56a("[Slim] CONN: host = " + a2.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m56a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f367a = this.f362a.a();
        while (!this.f366a) {
            fa m296a2 = m296a();
            this.f362a.c();
            short m290a = m296a2.m290a();
            if (m290a != 1) {
                if (m290a != 2) {
                    if (m290a != 3) {
                        str = "[Slim] unknow blob type " + ((int) m296a2.m290a());
                        com.xiaomi.channel.commonutils.logger.b.m56a(str);
                    } else {
                        try {
                            this.f362a.b(this.f41356a.a(m296a2.m292a(), this.f362a));
                        } catch (Exception e2) {
                            e = e2;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(m296a2.a());
                            sb.append("; Id=");
                            sb.append(m296a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m56a(str);
                        }
                    }
                } else if ("SECMSG".equals(m296a2.m288a()) && ((m296a2.a() == 2 || m296a2.a() == 3) && TextUtils.isEmpty(m296a2.m294b()))) {
                    try {
                        this.f362a.b(this.f41356a.a(m296a2.m293a(com.xiaomi.push.service.av.a().a(Integer.valueOf(m296a2.a()).toString(), m296a2.g()).f41852h), this.f362a));
                    } catch (Exception e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append("[Slim] Parse packet from Blob chid=");
                        sb.append(m296a2.a());
                        sb.append("; Id=");
                        sb.append(m296a2.e());
                        sb.append(" failure:");
                        sb.append(e.getMessage());
                        str = sb.toString();
                        com.xiaomi.channel.commonutils.logger.b.m56a(str);
                    }
                }
            }
            this.f362a.a(m296a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fa m296a() {
        int i2;
        ByteBuffer a2;
        try {
            a2 = a();
            i2 = a2.position();
        } catch (IOException e2) {
            e = e2;
            i2 = 0;
        }
        try {
            a2.flip();
            a2.position(8);
            fa fgVar = i2 == 8 ? new fg() : fa.a(a2.slice());
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fgVar.m288a() + ";chid=" + fgVar.a() + ";len=" + i2 + "}");
            return fgVar;
        } catch (IOException e3) {
            e = e3;
            if (i2 == 0) {
                i2 = this.f364a.position();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[Slim] read Blob [");
            byte[] array = this.f364a.array();
            if (i2 > 128) {
                i2 = 128;
            }
            sb.append(af.a(array, 0, i2));
            sb.append("] Err:");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.m56a(sb.toString());
            throw e;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m297a() {
        try {
            c();
        } catch (IOException e2) {
            if (!this.f366a) {
                throw e2;
            }
        }
    }

    public void b() {
        this.f366a = true;
    }
}
