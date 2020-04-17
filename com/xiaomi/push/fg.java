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
/* loaded from: classes8.dex */
public class fg {

    /* renamed from: a  reason: collision with other field name */
    private fk f357a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f358a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f361a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f362a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f359a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f360a = new Adler32();
    private fi a = new fi();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(InputStream inputStream, fk fkVar) {
        this.f358a = new BufferedInputStream(inputStream);
        this.f357a = fkVar;
    }

    private ByteBuffer a() {
        this.f359a.clear();
        a(this.f359a, 8);
        short s = this.f359a.getShort(0);
        short s2 = this.f359a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f359a.getInt(4);
            int position = this.f359a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f359a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f359a.array(), 0, this.f359a.arrayOffset() + this.f359a.position());
                this.f359a = allocate;
            } else if (this.f359a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f359a.array(), 0, this.f359a.arrayOffset() + this.f359a.position());
                this.f359a = allocate2;
            }
            a(this.f359a, i);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            int i2 = this.b.getInt();
            this.f360a.reset();
            this.f360a.update(this.f359a.array(), 0, this.f359a.position());
            if (i2 != ((int) this.f360a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m50a("CRC = " + ((int) this.f360a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f362a != null) {
                com.xiaomi.push.service.au.a(this.f362a, this.f359a.array(), true, position, i);
            }
            return this.f359a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f358a.read(byteBuffer.array(), position, i);
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
        this.f361a = false;
        ff m280a = m280a();
        if ("CONN".equals(m280a.m272a())) {
            ee.f a = ee.f.a(m280a.m276a());
            if (a.a()) {
                this.f357a.a(a.a());
                z = true;
            }
            if (a.c()) {
                ee.b a2 = a.a();
                ff ffVar = new ff();
                ffVar.a("SYNC", "CONF");
                ffVar.a(a2.a(), (String) null);
                this.f357a.a(ffVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] CONN: host = " + a.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f362a = this.f357a.a();
        while (!this.f361a) {
            ff m280a2 = m280a();
            this.f357a.c();
            switch (m280a2.m274a()) {
                case 1:
                    this.f357a.a(m280a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m280a2.m272a()) || ((m280a2.a() != 2 && m280a2.a() != 3) || !TextUtils.isEmpty(m280a2.m278b()))) {
                        this.f357a.a(m280a2);
                        break;
                    } else {
                        try {
                            this.f357a.b(this.a.a(m280a2.m277a(com.xiaomi.push.service.al.a().a(Integer.valueOf(m280a2.a()).toString(), m280a2.g()).h), this.f357a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] Parse packet from Blob chid=" + m280a2.a() + "; Id=" + m280a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f357a.b(this.a.a(m280a2.m276a(), this.f357a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] Parse packet from Blob chid=" + m280a2.a() + "; Id=" + m280a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] unknow blob type " + ((int) m280a2.m274a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    ff m280a() {
        IOException iOException;
        int i;
        try {
            ByteBuffer a = a();
            int position = a.position();
            try {
                a.flip();
                a.position(8);
                ff fjVar = position == 8 ? new fj() : ff.a(a.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fjVar.m272a() + ";chid=" + fjVar.a() + ";len=" + position + "}");
                return fjVar;
            } catch (IOException e) {
                i = position;
                iOException = e;
                if (i == 0) {
                    i = this.f359a.position();
                }
                StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
                byte[] array = this.f359a.array();
                if (i > 128) {
                    i = 128;
                }
                com.xiaomi.channel.commonutils.logger.b.m50a(append.append(af.a(array, 0, i)).append("] Err:").append(iOException.getMessage()).toString());
                throw iOException;
            }
        } catch (IOException e2) {
            iOException = e2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m281a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f361a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f361a = true;
    }
}
