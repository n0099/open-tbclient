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
/* loaded from: classes9.dex */
public class fm {

    /* renamed from: a  reason: collision with other field name */
    private fq f345a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f346a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f349a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f350a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f347a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f348a = new Adler32();
    private fo a = new fo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(InputStream inputStream, fq fqVar) {
        this.f346a = new BufferedInputStream(inputStream);
        this.f345a = fqVar;
    }

    private ByteBuffer a() {
        this.f347a.clear();
        a(this.f347a, 8);
        short s = this.f347a.getShort(0);
        short s2 = this.f347a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f347a.getInt(4);
            int position = this.f347a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f347a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f347a.array(), 0, this.f347a.arrayOffset() + this.f347a.position());
                this.f347a = allocate;
            } else if (this.f347a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f347a.array(), 0, this.f347a.arrayOffset() + this.f347a.position());
                this.f347a = allocate2;
            }
            a(this.f347a, i);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            int i2 = this.b.getInt();
            this.f348a.reset();
            this.f348a.update(this.f347a.array(), 0, this.f347a.position());
            if (i2 != ((int) this.f348a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m49a("CRC = " + ((int) this.f348a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f350a != null) {
                com.xiaomi.push.service.ay.a(this.f350a, this.f347a.array(), true, position, i);
            }
            return this.f347a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f346a.read(byteBuffer.array(), position, i);
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
        this.f349a = false;
        fl m283a = m283a();
        if ("CONN".equals(m283a.m275a())) {
            ek.f a = ek.f.a(m283a.m279a());
            if (a.a()) {
                this.f345a.a(a.a());
                z = true;
            }
            if (a.c()) {
                ek.b a2 = a.a();
                fl flVar = new fl();
                flVar.a("SYNC", "CONF");
                flVar.a(a2.a(), (String) null);
                this.f345a.a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m49a("[Slim] CONN: host = " + a.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m49a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f350a = this.f345a.a();
        while (!this.f349a) {
            fl m283a2 = m283a();
            this.f345a.c();
            switch (m283a2.m277a()) {
                case 1:
                    this.f345a.a(m283a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m283a2.m275a()) || ((m283a2.a() != 2 && m283a2.a() != 3) || !TextUtils.isEmpty(m283a2.m281b()))) {
                        this.f345a.a(m283a2);
                        break;
                    } else {
                        try {
                            this.f345a.b(this.a.a(m283a2.m280a(com.xiaomi.push.service.ap.a().a(Integer.valueOf(m283a2.a()).toString(), m283a2.g()).h), this.f345a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m49a("[Slim] Parse packet from Blob chid=" + m283a2.a() + "; Id=" + m283a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f345a.b(this.a.a(m283a2.m279a(), this.f345a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m49a("[Slim] Parse packet from Blob chid=" + m283a2.a() + "; Id=" + m283a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m49a("[Slim] unknow blob type " + ((int) m283a2.m277a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    fl m283a() {
        IOException iOException;
        int i;
        try {
            ByteBuffer a = a();
            int position = a.position();
            try {
                a.flip();
                a.position(8);
                fl fpVar = position == 8 ? new fp() : fl.a(a.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fpVar.m275a() + ";chid=" + fpVar.a() + ";len=" + position + "}");
                return fpVar;
            } catch (IOException e) {
                i = position;
                iOException = e;
                if (i == 0) {
                    i = this.f347a.position();
                }
                StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
                byte[] array = this.f347a.array();
                if (i > 128) {
                    i = 128;
                }
                com.xiaomi.channel.commonutils.logger.b.m49a(append.append(af.a(array, 0, i)).append("] Err:").append(iOException.getMessage()).toString());
                throw iOException;
            }
        } catch (IOException e2) {
            iOException = e2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m284a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f349a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f349a = true;
    }
}
