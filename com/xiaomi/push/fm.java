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
/* loaded from: classes6.dex */
public class fm {

    /* renamed from: a  reason: collision with other field name */
    private fq f423a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f424a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f427a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f428a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f425a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f14321b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f426a = new Adler32();

    /* renamed from: a  reason: collision with root package name */
    private fo f14320a = new fo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(InputStream inputStream, fq fqVar) {
        this.f424a = new BufferedInputStream(inputStream);
        this.f423a = fqVar;
    }

    private ByteBuffer a() {
        this.f425a.clear();
        a(this.f425a, 8);
        short s = this.f425a.getShort(0);
        short s2 = this.f425a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f425a.getInt(4);
            int position = this.f425a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f425a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f425a.array(), 0, this.f425a.arrayOffset() + this.f425a.position());
                this.f425a = allocate;
            } else if (this.f425a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f425a.array(), 0, this.f425a.arrayOffset() + this.f425a.position());
                this.f425a = allocate2;
            }
            a(this.f425a, i);
            this.f14321b.clear();
            a(this.f14321b, 4);
            this.f14321b.position(0);
            int i2 = this.f14321b.getInt();
            this.f426a.reset();
            this.f426a.update(this.f425a.array(), 0, this.f425a.position());
            if (i2 != ((int) this.f426a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m84a("CRC = " + ((int) this.f426a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f428a != null) {
                com.xiaomi.push.service.ay.a(this.f428a, this.f425a.array(), true, position, i);
            }
            return this.f425a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f424a.read(byteBuffer.array(), position, i);
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
        this.f427a = false;
        fl m318a = m318a();
        if ("CONN".equals(m318a.m310a())) {
            ek.f a2 = ek.f.a(m318a.m314a());
            if (a2.a()) {
                this.f423a.a(a2.a());
                z = true;
            }
            if (a2.c()) {
                ek.b a3 = a2.a();
                fl flVar = new fl();
                flVar.a("SYNC", "CONF");
                flVar.a(a3.a(), (String) null);
                this.f423a.a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m84a("[Slim] CONN: host = " + a2.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m84a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f428a = this.f423a.a();
        while (!this.f427a) {
            fl m318a2 = m318a();
            this.f423a.c();
            switch (m318a2.m312a()) {
                case 1:
                    this.f423a.a(m318a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m318a2.m310a()) || ((m318a2.a() != 2 && m318a2.a() != 3) || !TextUtils.isEmpty(m318a2.m316b()))) {
                        this.f423a.a(m318a2);
                        break;
                    } else {
                        try {
                            this.f423a.b(this.f14320a.a(m318a2.m315a(com.xiaomi.push.service.ap.a().a(Integer.valueOf(m318a2.a()).toString(), m318a2.g()).h), this.f423a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m84a("[Slim] Parse packet from Blob chid=" + m318a2.a() + "; Id=" + m318a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f423a.b(this.f14320a.a(m318a2.m314a(), this.f423a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m84a("[Slim] Parse packet from Blob chid=" + m318a2.a() + "; Id=" + m318a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m84a("[Slim] unknow blob type " + ((int) m318a2.m312a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    fl m318a() {
        int i;
        ByteBuffer a2;
        try {
            a2 = a();
            i = a2.position();
        } catch (IOException e) {
            e = e;
            i = 0;
        }
        try {
            a2.flip();
            a2.position(8);
            fl fpVar = i == 8 ? new fp() : fl.a(a2.slice());
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fpVar.m310a() + ";chid=" + fpVar.a() + ";len=" + i + "}");
            return fpVar;
        } catch (IOException e2) {
            e = e2;
            if (i == 0) {
                i = this.f425a.position();
            }
            StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
            byte[] array = this.f425a.array();
            if (i > 128) {
                i = 128;
            }
            com.xiaomi.channel.commonutils.logger.b.m84a(append.append(af.a(array, 0, i)).append("] Err:").append(e.getMessage()).toString());
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m319a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f427a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f427a = true;
    }
}
