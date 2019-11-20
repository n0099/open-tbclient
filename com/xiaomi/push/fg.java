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
/* loaded from: classes3.dex */
public class fg {

    /* renamed from: a  reason: collision with other field name */
    private fk f356a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f357a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f360a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f361a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f358a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f359a = new Adler32();
    private fi a = new fi();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(InputStream inputStream, fk fkVar) {
        this.f357a = new BufferedInputStream(inputStream);
        this.f356a = fkVar;
    }

    private ByteBuffer a() {
        this.f358a.clear();
        a(this.f358a, 8);
        short s = this.f358a.getShort(0);
        short s2 = this.f358a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f358a.getInt(4);
            int position = this.f358a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f358a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f358a.array(), 0, this.f358a.arrayOffset() + this.f358a.position());
                this.f358a = allocate;
            } else if (this.f358a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f358a.array(), 0, this.f358a.arrayOffset() + this.f358a.position());
                this.f358a = allocate2;
            }
            a(this.f358a, i);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            int i2 = this.b.getInt();
            this.f359a.reset();
            this.f359a.update(this.f358a.array(), 0, this.f358a.position());
            if (i2 != ((int) this.f359a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m30a("CRC = " + ((int) this.f359a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f361a != null) {
                com.xiaomi.push.service.au.a(this.f361a, this.f358a.array(), true, position, i);
            }
            return this.f358a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f357a.read(byteBuffer.array(), position, i);
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
        this.f360a = false;
        ff m260a = m260a();
        if ("CONN".equals(m260a.m252a())) {
            ee.f a = ee.f.a(m260a.m256a());
            if (a.a()) {
                this.f356a.a(a.a());
                z = true;
            }
            if (a.c()) {
                ee.b a2 = a.a();
                ff ffVar = new ff();
                ffVar.a("SYNC", "CONF");
                ffVar.a(a2.a(), (String) null);
                this.f356a.a(ffVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m30a("[Slim] CONN: host = " + a.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m30a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f361a = this.f356a.a();
        while (!this.f360a) {
            ff m260a2 = m260a();
            this.f356a.c();
            switch (m260a2.m254a()) {
                case 1:
                    this.f356a.a(m260a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m260a2.m252a()) || ((m260a2.a() != 2 && m260a2.a() != 3) || !TextUtils.isEmpty(m260a2.m258b()))) {
                        this.f356a.a(m260a2);
                        break;
                    } else {
                        try {
                            this.f356a.b(this.a.a(m260a2.m257a(com.xiaomi.push.service.al.a().a(Integer.valueOf(m260a2.a()).toString(), m260a2.g()).h), this.f356a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m30a("[Slim] Parse packet from Blob chid=" + m260a2.a() + "; Id=" + m260a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f356a.b(this.a.a(m260a2.m256a(), this.f356a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m30a("[Slim] Parse packet from Blob chid=" + m260a2.a() + "; Id=" + m260a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m30a("[Slim] unknow blob type " + ((int) m260a2.m254a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    ff m260a() {
        IOException iOException;
        int i;
        try {
            ByteBuffer a = a();
            int position = a.position();
            try {
                a.flip();
                a.position(8);
                ff fjVar = position == 8 ? new fj() : ff.a(a.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fjVar.m252a() + ";chid=" + fjVar.a() + ";len=" + position + "}");
                return fjVar;
            } catch (IOException e) {
                i = position;
                iOException = e;
                if (i == 0) {
                    i = this.f358a.position();
                }
                StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
                byte[] array = this.f358a.array();
                if (i > 128) {
                    i = 128;
                }
                com.xiaomi.channel.commonutils.logger.b.m30a(append.append(af.a(array, 0, i)).append("] Err:").append(iOException.getMessage()).toString());
                throw iOException;
            }
        } catch (IOException e2) {
            iOException = e2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m261a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f360a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f360a = true;
    }
}
