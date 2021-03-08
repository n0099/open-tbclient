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
/* loaded from: classes5.dex */
public class fm {

    /* renamed from: a  reason: collision with other field name */
    private fq f343a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f344a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f347a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f348a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f345a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f346a = new Adler32();

    /* renamed from: a  reason: collision with root package name */
    private fo f8369a = new fo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(InputStream inputStream, fq fqVar) {
        this.f344a = new BufferedInputStream(inputStream);
        this.f343a = fqVar;
    }

    private ByteBuffer a() {
        this.f345a.clear();
        a(this.f345a, 8);
        short s = this.f345a.getShort(0);
        short s2 = this.f345a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f345a.getInt(4);
            int position = this.f345a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f345a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f345a.array(), 0, this.f345a.arrayOffset() + this.f345a.position());
                this.f345a = allocate;
            } else if (this.f345a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f345a.array(), 0, this.f345a.arrayOffset() + this.f345a.position());
                this.f345a = allocate2;
            }
            a(this.f345a, i);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            int i2 = this.b.getInt();
            this.f346a.reset();
            this.f346a.update(this.f345a.array(), 0, this.f345a.position());
            if (i2 != ((int) this.f346a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m58a("CRC = " + ((int) this.f346a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f348a != null) {
                com.xiaomi.push.service.ay.a(this.f348a, this.f345a.array(), true, position, i);
            }
            return this.f345a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f344a.read(byteBuffer.array(), position, i);
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
        this.f347a = false;
        fl m292a = m292a();
        if ("CONN".equals(m292a.m284a())) {
            ek.f a2 = ek.f.a(m292a.m288a());
            if (a2.a()) {
                this.f343a.a(a2.a());
                z = true;
            }
            if (a2.c()) {
                ek.b a3 = a2.a();
                fl flVar = new fl();
                flVar.a("SYNC", "CONF");
                flVar.a(a3.a(), (String) null);
                this.f343a.a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m58a("[Slim] CONN: host = " + a2.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m58a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f348a = this.f343a.a();
        while (!this.f347a) {
            fl m292a2 = m292a();
            this.f343a.c();
            switch (m292a2.m286a()) {
                case 1:
                    this.f343a.a(m292a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m292a2.m284a()) || ((m292a2.a() != 2 && m292a2.a() != 3) || !TextUtils.isEmpty(m292a2.m290b()))) {
                        this.f343a.a(m292a2);
                        break;
                    } else {
                        try {
                            this.f343a.b(this.f8369a.a(m292a2.m289a(com.xiaomi.push.service.ap.a().a(Integer.valueOf(m292a2.a()).toString(), m292a2.g()).h), this.f343a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m58a("[Slim] Parse packet from Blob chid=" + m292a2.a() + "; Id=" + m292a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f343a.b(this.f8369a.a(m292a2.m288a(), this.f343a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m58a("[Slim] Parse packet from Blob chid=" + m292a2.a() + "; Id=" + m292a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m58a("[Slim] unknow blob type " + ((int) m292a2.m286a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    fl m292a() {
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
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fpVar.m284a() + ";chid=" + fpVar.a() + ";len=" + i + "}");
            return fpVar;
        } catch (IOException e2) {
            e = e2;
            if (i == 0) {
                i = this.f345a.position();
            }
            StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
            byte[] array = this.f345a.array();
            if (i > 128) {
                i = 128;
            }
            com.xiaomi.channel.commonutils.logger.b.m58a(append.append(af.a(array, 0, i)).append("] Err:").append(e.getMessage()).toString());
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m293a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f347a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f347a = true;
    }
}
