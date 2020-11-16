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
/* loaded from: classes18.dex */
public class fm {

    /* renamed from: a  reason: collision with other field name */
    private fq f346a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f347a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f350a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f351a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f348a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f349a = new Adler32();

    /* renamed from: a  reason: collision with root package name */
    private fo f4906a = new fo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(InputStream inputStream, fq fqVar) {
        this.f347a = new BufferedInputStream(inputStream);
        this.f346a = fqVar;
    }

    private ByteBuffer a() {
        this.f348a.clear();
        a(this.f348a, 8);
        short s = this.f348a.getShort(0);
        short s2 = this.f348a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f348a.getInt(4);
            int position = this.f348a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f348a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f348a.array(), 0, this.f348a.arrayOffset() + this.f348a.position());
                this.f348a = allocate;
            } else if (this.f348a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f348a.array(), 0, this.f348a.arrayOffset() + this.f348a.position());
                this.f348a = allocate2;
            }
            a(this.f348a, i);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            int i2 = this.b.getInt();
            this.f349a.reset();
            this.f349a.update(this.f348a.array(), 0, this.f348a.position());
            if (i2 != ((int) this.f349a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m57a("CRC = " + ((int) this.f349a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f351a != null) {
                com.xiaomi.push.service.ay.a(this.f351a, this.f348a.array(), true, position, i);
            }
            return this.f348a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f347a.read(byteBuffer.array(), position, i);
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
        this.f350a = false;
        fl m291a = m291a();
        if ("CONN".equals(m291a.m283a())) {
            ek.f a2 = ek.f.a(m291a.m287a());
            if (a2.a()) {
                this.f346a.a(a2.a());
                z = true;
            }
            if (a2.c()) {
                ek.b a3 = a2.a();
                fl flVar = new fl();
                flVar.a("SYNC", "CONF");
                flVar.a(a3.a(), (String) null);
                this.f346a.a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m57a("[Slim] CONN: host = " + a2.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m57a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f351a = this.f346a.a();
        while (!this.f350a) {
            fl m291a2 = m291a();
            this.f346a.c();
            switch (m291a2.m285a()) {
                case 1:
                    this.f346a.a(m291a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m291a2.m283a()) || ((m291a2.a() != 2 && m291a2.a() != 3) || !TextUtils.isEmpty(m291a2.m289b()))) {
                        this.f346a.a(m291a2);
                        break;
                    } else {
                        try {
                            this.f346a.b(this.f4906a.a(m291a2.m288a(com.xiaomi.push.service.ap.a().a(Integer.valueOf(m291a2.a()).toString(), m291a2.g()).h), this.f346a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m57a("[Slim] Parse packet from Blob chid=" + m291a2.a() + "; Id=" + m291a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f346a.b(this.f4906a.a(m291a2.m287a(), this.f346a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m57a("[Slim] Parse packet from Blob chid=" + m291a2.a() + "; Id=" + m291a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m57a("[Slim] unknow blob type " + ((int) m291a2.m285a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    fl m291a() {
        IOException iOException;
        int i;
        try {
            ByteBuffer a2 = a();
            int position = a2.position();
            try {
                a2.flip();
                a2.position(8);
                fl fpVar = position == 8 ? new fp() : fl.a(a2.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fpVar.m283a() + ";chid=" + fpVar.a() + ";len=" + position + "}");
                return fpVar;
            } catch (IOException e) {
                i = position;
                iOException = e;
                if (i == 0) {
                    i = this.f348a.position();
                }
                StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
                byte[] array = this.f348a.array();
                if (i > 128) {
                    i = 128;
                }
                com.xiaomi.channel.commonutils.logger.b.m57a(append.append(af.a(array, 0, i)).append("] Err:").append(iOException.getMessage()).toString());
                throw iOException;
            }
        } catch (IOException e2) {
            iOException = e2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m292a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f350a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f350a = true;
    }
}
