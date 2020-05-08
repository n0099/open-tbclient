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
/* loaded from: classes8.dex */
public class fm {

    /* renamed from: a  reason: collision with other field name */
    private fq f342a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f343a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f346a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f347a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f344a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f345a = new Adler32();
    private fo a = new fo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(InputStream inputStream, fq fqVar) {
        this.f343a = new BufferedInputStream(inputStream);
        this.f342a = fqVar;
    }

    private ByteBuffer a() {
        this.f344a.clear();
        a(this.f344a, 8);
        short s = this.f344a.getShort(0);
        short s2 = this.f344a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f344a.getInt(4);
            int position = this.f344a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f344a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f344a.array(), 0, this.f344a.arrayOffset() + this.f344a.position());
                this.f344a = allocate;
            } else if (this.f344a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f344a.array(), 0, this.f344a.arrayOffset() + this.f344a.position());
                this.f344a = allocate2;
            }
            a(this.f344a, i);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            int i2 = this.b.getInt();
            this.f345a.reset();
            this.f345a.update(this.f344a.array(), 0, this.f344a.position());
            if (i2 != ((int) this.f345a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m50a("CRC = " + ((int) this.f345a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f347a != null) {
                com.xiaomi.push.service.ay.a(this.f347a, this.f344a.array(), true, position, i);
            }
            return this.f344a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f343a.read(byteBuffer.array(), position, i);
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
        this.f346a = false;
        fl m284a = m284a();
        if ("CONN".equals(m284a.m276a())) {
            ek.f a = ek.f.a(m284a.m280a());
            if (a.a()) {
                this.f342a.a(a.a());
                z = true;
            }
            if (a.c()) {
                ek.b a2 = a.a();
                fl flVar = new fl();
                flVar.a("SYNC", "CONF");
                flVar.a(a2.a(), (String) null);
                this.f342a.a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] CONN: host = " + a.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f347a = this.f342a.a();
        while (!this.f346a) {
            fl m284a2 = m284a();
            this.f342a.c();
            switch (m284a2.m278a()) {
                case 1:
                    this.f342a.a(m284a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m284a2.m276a()) || ((m284a2.a() != 2 && m284a2.a() != 3) || !TextUtils.isEmpty(m284a2.m282b()))) {
                        this.f342a.a(m284a2);
                        break;
                    } else {
                        try {
                            this.f342a.b(this.a.a(m284a2.m281a(com.xiaomi.push.service.ap.a().a(Integer.valueOf(m284a2.a()).toString(), m284a2.g()).h), this.f342a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] Parse packet from Blob chid=" + m284a2.a() + "; Id=" + m284a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f342a.b(this.a.a(m284a2.m280a(), this.f342a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] Parse packet from Blob chid=" + m284a2.a() + "; Id=" + m284a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] unknow blob type " + ((int) m284a2.m278a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    fl m284a() {
        IOException iOException;
        int i;
        try {
            ByteBuffer a = a();
            int position = a.position();
            try {
                a.flip();
                a.position(8);
                fl fpVar = position == 8 ? new fp() : fl.a(a.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fpVar.m276a() + ";chid=" + fpVar.a() + ";len=" + position + "}");
                return fpVar;
            } catch (IOException e) {
                i = position;
                iOException = e;
                if (i == 0) {
                    i = this.f344a.position();
                }
                StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
                byte[] array = this.f344a.array();
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
    public void m285a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f346a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f346a = true;
    }
}
