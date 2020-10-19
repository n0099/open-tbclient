package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.ek;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class fm {

    /* renamed from: a  reason: collision with other field name */
    private fq f344a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f345a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f348a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f349a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f346a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f347a = new Adler32();

    /* renamed from: a  reason: collision with root package name */
    private fo f4906a = new fo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(InputStream inputStream, fq fqVar) {
        this.f345a = new BufferedInputStream(inputStream);
        this.f344a = fqVar;
    }

    private ByteBuffer a() {
        this.f346a.clear();
        a(this.f346a, 8);
        short s = this.f346a.getShort(0);
        short s2 = this.f346a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f346a.getInt(4);
            int position = this.f346a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f346a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f346a.array(), 0, this.f346a.arrayOffset() + this.f346a.position());
                this.f346a = allocate;
            } else if (this.f346a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f346a.array(), 0, this.f346a.arrayOffset() + this.f346a.position());
                this.f346a = allocate2;
            }
            a(this.f346a, i);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            int i2 = this.b.getInt();
            this.f347a.reset();
            this.f347a.update(this.f346a.array(), 0, this.f346a.position());
            if (i2 != ((int) this.f347a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m55a("CRC = " + ((int) this.f347a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f349a != null) {
                com.xiaomi.push.service.ay.a(this.f349a, this.f346a.array(), true, position, i);
            }
            return this.f346a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f345a.read(byteBuffer.array(), position, i);
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
        this.f348a = false;
        fl m289a = m289a();
        if ("CONN".equals(m289a.m281a())) {
            ek.f a2 = ek.f.a(m289a.m285a());
            if (a2.a()) {
                this.f344a.a(a2.a());
                z = true;
            }
            if (a2.c()) {
                ek.b a3 = a2.a();
                fl flVar = new fl();
                flVar.a("SYNC", "CONF");
                flVar.a(a3.a(), (String) null);
                this.f344a.a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m55a("[Slim] CONN: host = " + a2.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m55a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f349a = this.f344a.a();
        while (!this.f348a) {
            fl m289a2 = m289a();
            this.f344a.c();
            switch (m289a2.m283a()) {
                case 1:
                    this.f344a.a(m289a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m289a2.m281a()) || ((m289a2.a() != 2 && m289a2.a() != 3) || !TextUtils.isEmpty(m289a2.m287b()))) {
                        this.f344a.a(m289a2);
                        break;
                    } else {
                        try {
                            this.f344a.b(this.f4906a.a(m289a2.m286a(com.xiaomi.push.service.ap.a().a(Integer.valueOf(m289a2.a()).toString(), m289a2.g()).h), this.f344a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m55a("[Slim] Parse packet from Blob chid=" + m289a2.a() + "; Id=" + m289a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f344a.b(this.f4906a.a(m289a2.m285a(), this.f344a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m55a("[Slim] Parse packet from Blob chid=" + m289a2.a() + "; Id=" + m289a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m55a("[Slim] unknow blob type " + ((int) m289a2.m283a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    fl m289a() {
        IOException iOException;
        int i;
        try {
            ByteBuffer a2 = a();
            int position = a2.position();
            try {
                a2.flip();
                a2.position(8);
                fl fpVar = position == 8 ? new fp() : fl.a(a2.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fpVar.m281a() + ";chid=" + fpVar.a() + ";len=" + position + "}");
                return fpVar;
            } catch (IOException e) {
                i = position;
                iOException = e;
                if (i == 0) {
                    i = this.f346a.position();
                }
                StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
                byte[] array = this.f346a.array();
                if (i > 128) {
                    i = 128;
                }
                com.xiaomi.channel.commonutils.logger.b.m55a(append.append(af.a(array, 0, i)).append("] Err:").append(iOException.getMessage()).toString());
                throw iOException;
            }
        } catch (IOException e2) {
            iOException = e2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m290a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f348a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f348a = true;
    }
}
