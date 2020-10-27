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
    private fq f341a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f342a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f345a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f346a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f343a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f344a = new Adler32();

    /* renamed from: a  reason: collision with root package name */
    private fo f4904a = new fo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(InputStream inputStream, fq fqVar) {
        this.f342a = new BufferedInputStream(inputStream);
        this.f341a = fqVar;
    }

    private ByteBuffer a() {
        this.f343a.clear();
        a(this.f343a, 8);
        short s = this.f343a.getShort(0);
        short s2 = this.f343a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f343a.getInt(4);
            int position = this.f343a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f343a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f343a.array(), 0, this.f343a.arrayOffset() + this.f343a.position());
                this.f343a = allocate;
            } else if (this.f343a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f343a.array(), 0, this.f343a.arrayOffset() + this.f343a.position());
                this.f343a = allocate2;
            }
            a(this.f343a, i);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            int i2 = this.b.getInt();
            this.f344a.reset();
            this.f344a.update(this.f343a.array(), 0, this.f343a.position());
            if (i2 != ((int) this.f344a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m54a("CRC = " + ((int) this.f344a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f346a != null) {
                com.xiaomi.push.service.ay.a(this.f346a, this.f343a.array(), true, position, i);
            }
            return this.f343a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f342a.read(byteBuffer.array(), position, i);
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
        this.f345a = false;
        fl m288a = m288a();
        if ("CONN".equals(m288a.m280a())) {
            ek.f a2 = ek.f.a(m288a.m284a());
            if (a2.a()) {
                this.f341a.a(a2.a());
                z = true;
            }
            if (a2.c()) {
                ek.b a3 = a2.a();
                fl flVar = new fl();
                flVar.a("SYNC", "CONF");
                flVar.a(a3.a(), (String) null);
                this.f341a.a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] CONN: host = " + a2.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f346a = this.f341a.a();
        while (!this.f345a) {
            fl m288a2 = m288a();
            this.f341a.c();
            switch (m288a2.m282a()) {
                case 1:
                    this.f341a.a(m288a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m288a2.m280a()) || ((m288a2.a() != 2 && m288a2.a() != 3) || !TextUtils.isEmpty(m288a2.m286b()))) {
                        this.f341a.a(m288a2);
                        break;
                    } else {
                        try {
                            this.f341a.b(this.f4904a.a(m288a2.m285a(com.xiaomi.push.service.ap.a().a(Integer.valueOf(m288a2.a()).toString(), m288a2.g()).h), this.f341a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] Parse packet from Blob chid=" + m288a2.a() + "; Id=" + m288a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f341a.b(this.f4904a.a(m288a2.m284a(), this.f341a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] Parse packet from Blob chid=" + m288a2.a() + "; Id=" + m288a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] unknow blob type " + ((int) m288a2.m282a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    fl m288a() {
        IOException iOException;
        int i;
        try {
            ByteBuffer a2 = a();
            int position = a2.position();
            try {
                a2.flip();
                a2.position(8);
                fl fpVar = position == 8 ? new fp() : fl.a(a2.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fpVar.m280a() + ";chid=" + fpVar.a() + ";len=" + position + "}");
                return fpVar;
            } catch (IOException e) {
                i = position;
                iOException = e;
                if (i == 0) {
                    i = this.f343a.position();
                }
                StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
                byte[] array = this.f343a.array();
                if (i > 128) {
                    i = 128;
                }
                com.xiaomi.channel.commonutils.logger.b.m54a(append.append(af.a(array, 0, i)).append("] Err:").append(iOException.getMessage()).toString());
                throw iOException;
            }
        } catch (IOException e2) {
            iOException = e2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m289a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f345a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f345a = true;
    }
}
