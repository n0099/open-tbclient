package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.ee;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class fg {

    /* renamed from: a  reason: collision with other field name */
    private fk f361a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f362a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f365a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f366a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f363a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f364a = new Adler32();
    private fi a = new fi();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(InputStream inputStream, fk fkVar) {
        this.f362a = new BufferedInputStream(inputStream);
        this.f361a = fkVar;
    }

    private ByteBuffer a() {
        this.f363a.clear();
        a(this.f363a, 8);
        short s = this.f363a.getShort(0);
        short s2 = this.f363a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f363a.getInt(4);
            int position = this.f363a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f363a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f363a.array(), 0, this.f363a.arrayOffset() + this.f363a.position());
                this.f363a = allocate;
            } else if (this.f363a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f363a.array(), 0, this.f363a.arrayOffset() + this.f363a.position());
                this.f363a = allocate2;
            }
            a(this.f363a, i);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            int i2 = this.b.getInt();
            this.f364a.reset();
            this.f364a.update(this.f363a.array(), 0, this.f363a.position());
            if (i2 != ((int) this.f364a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m33a("CRC = " + ((int) this.f364a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f366a != null) {
                com.xiaomi.push.service.au.a(this.f366a, this.f363a.array(), true, position, i);
            }
            return this.f363a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f362a.read(byteBuffer.array(), position, i);
            if (read == -1) {
                throw new EOFException();
            }
            i -= read;
            position += read;
        } while (i > 0);
        byteBuffer.position(position);
    }

    private void c() {
        boolean z = false;
        this.f365a = false;
        ff m263a = m263a();
        if ("CONN".equals(m263a.m255a())) {
            ee.f a = ee.f.a(m263a.m259a());
            if (a.a()) {
                this.f361a.a(a.a());
                z = true;
            }
            if (a.c()) {
                ee.b a2 = a.a();
                ff ffVar = new ff();
                ffVar.a("SYNC", "CONF");
                ffVar.a(a2.a(), (String) null);
                this.f361a.a(ffVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m33a("[Slim] CONN: host = " + a.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m33a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f366a = this.f361a.a();
        while (!this.f365a) {
            ff m263a2 = m263a();
            this.f361a.c();
            switch (m263a2.m257a()) {
                case 1:
                    this.f361a.a(m263a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m263a2.m255a()) || ((m263a2.a() != 2 && m263a2.a() != 3) || !TextUtils.isEmpty(m263a2.m261b()))) {
                        this.f361a.a(m263a2);
                        break;
                    } else {
                        try {
                            this.f361a.b(this.a.a(m263a2.m260a(com.xiaomi.push.service.al.a().a(Integer.valueOf(m263a2.a()).toString(), m263a2.g()).h), this.f361a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m33a("[Slim] Parse packet from Blob chid=" + m263a2.a() + "; Id=" + m263a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f361a.b(this.a.a(m263a2.m259a(), this.f361a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m33a("[Slim] Parse packet from Blob chid=" + m263a2.a() + "; Id=" + m263a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m33a("[Slim] unknow blob type " + ((int) m263a2.m257a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    ff m263a() {
        IOException iOException;
        int i;
        try {
            ByteBuffer a = a();
            int position = a.position();
            try {
                a.flip();
                a.position(8);
                ff fjVar = position == 8 ? new fj() : ff.a(a.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fjVar.m255a() + ";chid=" + fjVar.a() + ";len=" + position + "}");
                return fjVar;
            } catch (IOException e) {
                i = position;
                iOException = e;
                if (i == 0) {
                    i = this.f363a.position();
                }
                StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
                byte[] array = this.f363a.array();
                if (i > 128) {
                    i = 128;
                }
                com.xiaomi.channel.commonutils.logger.b.m33a(append.append(af.a(array, 0, i)).append("] Err:").append(iOException.getMessage()).toString());
                throw iOException;
            }
        } catch (IOException e2) {
            iOException = e2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m264a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f365a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f365a = true;
    }
}
