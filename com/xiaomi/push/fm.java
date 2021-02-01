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
    private fq f422a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f423a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f426a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f427a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f424a = ByteBuffer.allocate(2048);

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f14023b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f425a = new Adler32();

    /* renamed from: a  reason: collision with root package name */
    private fo f14022a = new fo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(InputStream inputStream, fq fqVar) {
        this.f423a = new BufferedInputStream(inputStream);
        this.f422a = fqVar;
    }

    private ByteBuffer a() {
        this.f424a.clear();
        a(this.f424a, 8);
        short s = this.f424a.getShort(0);
        short s2 = this.f424a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f424a.getInt(4);
            int position = this.f424a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f424a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f424a.array(), 0, this.f424a.arrayOffset() + this.f424a.position());
                this.f424a = allocate;
            } else if (this.f424a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f424a.array(), 0, this.f424a.arrayOffset() + this.f424a.position());
                this.f424a = allocate2;
            }
            a(this.f424a, i);
            this.f14023b.clear();
            a(this.f14023b, 4);
            this.f14023b.position(0);
            int i2 = this.f14023b.getInt();
            this.f425a.reset();
            this.f425a.update(this.f424a.array(), 0, this.f424a.position());
            if (i2 != ((int) this.f425a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m80a("CRC = " + ((int) this.f425a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f427a != null) {
                com.xiaomi.push.service.ay.a(this.f427a, this.f424a.array(), true, position, i);
            }
            return this.f424a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f423a.read(byteBuffer.array(), position, i);
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
        this.f426a = false;
        fl m314a = m314a();
        if ("CONN".equals(m314a.m306a())) {
            ek.f a2 = ek.f.a(m314a.m310a());
            if (a2.a()) {
                this.f422a.a(a2.a());
                z = true;
            }
            if (a2.c()) {
                ek.b a3 = a2.a();
                fl flVar = new fl();
                flVar.a("SYNC", "CONF");
                flVar.a(a3.a(), (String) null);
                this.f422a.a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m80a("[Slim] CONN: host = " + a2.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m80a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f427a = this.f422a.a();
        while (!this.f426a) {
            fl m314a2 = m314a();
            this.f422a.c();
            switch (m314a2.m308a()) {
                case 1:
                    this.f422a.a(m314a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m314a2.m306a()) || ((m314a2.a() != 2 && m314a2.a() != 3) || !TextUtils.isEmpty(m314a2.m312b()))) {
                        this.f422a.a(m314a2);
                        break;
                    } else {
                        try {
                            this.f422a.b(this.f14022a.a(m314a2.m311a(com.xiaomi.push.service.ap.a().a(Integer.valueOf(m314a2.a()).toString(), m314a2.g()).h), this.f422a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m80a("[Slim] Parse packet from Blob chid=" + m314a2.a() + "; Id=" + m314a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f422a.b(this.f14022a.a(m314a2.m310a(), this.f422a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m80a("[Slim] Parse packet from Blob chid=" + m314a2.a() + "; Id=" + m314a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m80a("[Slim] unknow blob type " + ((int) m314a2.m308a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    fl m314a() {
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
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fpVar.m306a() + ";chid=" + fpVar.a() + ";len=" + i + "}");
            return fpVar;
        } catch (IOException e2) {
            e = e2;
            if (i == 0) {
                i = this.f424a.position();
            }
            StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
            byte[] array = this.f424a.array();
            if (i > 128) {
                i = 128;
            }
            com.xiaomi.channel.commonutils.logger.b.m80a(append.append(af.a(array, 0, i)).append("] Err:").append(e.getMessage()).toString());
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m315a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f426a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f426a = true;
    }
}
