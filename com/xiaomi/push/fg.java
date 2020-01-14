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
/* loaded from: classes6.dex */
public class fg {

    /* renamed from: a  reason: collision with other field name */
    private fk f360a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f361a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f364a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f365a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f362a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f363a = new Adler32();
    private fi a = new fi();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(InputStream inputStream, fk fkVar) {
        this.f361a = new BufferedInputStream(inputStream);
        this.f360a = fkVar;
    }

    private ByteBuffer a() {
        this.f362a.clear();
        a(this.f362a, 8);
        short s = this.f362a.getShort(0);
        short s2 = this.f362a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f362a.getInt(4);
            int position = this.f362a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f362a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f362a.array(), 0, this.f362a.arrayOffset() + this.f362a.position());
                this.f362a = allocate;
            } else if (this.f362a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f362a.array(), 0, this.f362a.arrayOffset() + this.f362a.position());
                this.f362a = allocate2;
            }
            a(this.f362a, i);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            int i2 = this.b.getInt();
            this.f363a.reset();
            this.f363a.update(this.f362a.array(), 0, this.f362a.position());
            if (i2 != ((int) this.f363a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m42a("CRC = " + ((int) this.f363a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f365a != null) {
                com.xiaomi.push.service.au.a(this.f365a, this.f362a.array(), true, position, i);
            }
            return this.f362a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f361a.read(byteBuffer.array(), position, i);
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
        this.f364a = false;
        ff m272a = m272a();
        if ("CONN".equals(m272a.m264a())) {
            ee.f a = ee.f.a(m272a.m268a());
            if (a.a()) {
                this.f360a.a(a.a());
                z = true;
            }
            if (a.c()) {
                ee.b a2 = a.a();
                ff ffVar = new ff();
                ffVar.a("SYNC", "CONF");
                ffVar.a(a2.a(), (String) null);
                this.f360a.a(ffVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m42a("[Slim] CONN: host = " + a.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m42a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f365a = this.f360a.a();
        while (!this.f364a) {
            ff m272a2 = m272a();
            this.f360a.c();
            switch (m272a2.m266a()) {
                case 1:
                    this.f360a.a(m272a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m272a2.m264a()) || ((m272a2.a() != 2 && m272a2.a() != 3) || !TextUtils.isEmpty(m272a2.m270b()))) {
                        this.f360a.a(m272a2);
                        break;
                    } else {
                        try {
                            this.f360a.b(this.a.a(m272a2.m269a(com.xiaomi.push.service.al.a().a(Integer.valueOf(m272a2.a()).toString(), m272a2.g()).h), this.f360a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m42a("[Slim] Parse packet from Blob chid=" + m272a2.a() + "; Id=" + m272a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f360a.b(this.a.a(m272a2.m268a(), this.f360a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m42a("[Slim] Parse packet from Blob chid=" + m272a2.a() + "; Id=" + m272a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m42a("[Slim] unknow blob type " + ((int) m272a2.m266a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    ff m272a() {
        IOException iOException;
        int i;
        try {
            ByteBuffer a = a();
            int position = a.position();
            try {
                a.flip();
                a.position(8);
                ff fjVar = position == 8 ? new fj() : ff.a(a.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fjVar.m264a() + ";chid=" + fjVar.a() + ";len=" + position + "}");
                return fjVar;
            } catch (IOException e) {
                i = position;
                iOException = e;
                if (i == 0) {
                    i = this.f362a.position();
                }
                StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
                byte[] array = this.f362a.array();
                if (i > 128) {
                    i = 128;
                }
                com.xiaomi.channel.commonutils.logger.b.m42a(append.append(af.a(array, 0, i)).append("] Err:").append(iOException.getMessage()).toString());
                throw iOException;
            }
        } catch (IOException e2) {
            iOException = e2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m273a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f364a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f364a = true;
    }
}
