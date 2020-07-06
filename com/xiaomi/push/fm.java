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
    private fq f349a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f350a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f353a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f354a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f351a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f352a = new Adler32();
    private fo a = new fo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(InputStream inputStream, fq fqVar) {
        this.f350a = new BufferedInputStream(inputStream);
        this.f349a = fqVar;
    }

    private ByteBuffer a() {
        this.f351a.clear();
        a(this.f351a, 8);
        short s = this.f351a.getShort(0);
        short s2 = this.f351a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f351a.getInt(4);
            int position = this.f351a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f351a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f351a.array(), 0, this.f351a.arrayOffset() + this.f351a.position());
                this.f351a = allocate;
            } else if (this.f351a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f351a.array(), 0, this.f351a.arrayOffset() + this.f351a.position());
                this.f351a = allocate2;
            }
            a(this.f351a, i);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            int i2 = this.b.getInt();
            this.f352a.reset();
            this.f352a.update(this.f351a.array(), 0, this.f351a.position());
            if (i2 != ((int) this.f352a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m48a("CRC = " + ((int) this.f352a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f354a != null) {
                com.xiaomi.push.service.ay.a(this.f354a, this.f351a.array(), true, position, i);
            }
            return this.f351a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f350a.read(byteBuffer.array(), position, i);
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
        this.f353a = false;
        fl m282a = m282a();
        if ("CONN".equals(m282a.m274a())) {
            ek.f a = ek.f.a(m282a.m278a());
            if (a.a()) {
                this.f349a.a(a.a());
                z = true;
            }
            if (a.c()) {
                ek.b a2 = a.a();
                fl flVar = new fl();
                flVar.a("SYNC", "CONF");
                flVar.a(a2.a(), (String) null);
                this.f349a.a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("[Slim] CONN: host = " + a.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m48a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f354a = this.f349a.a();
        while (!this.f353a) {
            fl m282a2 = m282a();
            this.f349a.c();
            switch (m282a2.m276a()) {
                case 1:
                    this.f349a.a(m282a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m282a2.m274a()) || ((m282a2.a() != 2 && m282a2.a() != 3) || !TextUtils.isEmpty(m282a2.m280b()))) {
                        this.f349a.a(m282a2);
                        break;
                    } else {
                        try {
                            this.f349a.b(this.a.a(m282a2.m279a(com.xiaomi.push.service.ap.a().a(Integer.valueOf(m282a2.a()).toString(), m282a2.g()).h), this.f349a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m48a("[Slim] Parse packet from Blob chid=" + m282a2.a() + "; Id=" + m282a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f349a.b(this.a.a(m282a2.m278a(), this.f349a));
                        break;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m48a("[Slim] Parse packet from Blob chid=" + m282a2.a() + "; Id=" + m282a2.e() + " failure:" + e2.getMessage());
                        break;
                    }
                default:
                    com.xiaomi.channel.commonutils.logger.b.m48a("[Slim] unknow blob type " + ((int) m282a2.m276a()));
                    break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    fl m282a() {
        IOException iOException;
        int i;
        try {
            ByteBuffer a = a();
            int position = a.position();
            try {
                a.flip();
                a.position(8);
                fl fpVar = position == 8 ? new fp() : fl.a(a.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fpVar.m274a() + ";chid=" + fpVar.a() + ";len=" + position + "}");
                return fpVar;
            } catch (IOException e) {
                i = position;
                iOException = e;
                if (i == 0) {
                    i = this.f351a.position();
                }
                StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
                byte[] array = this.f351a.array();
                if (i > 128) {
                    i = 128;
                }
                com.xiaomi.channel.commonutils.logger.b.m48a(append.append(af.a(array, 0, i)).append("] Err:").append(iOException.getMessage()).toString());
                throw iOException;
            }
        } catch (IOException e2) {
            iOException = e2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m283a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f353a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f353a = true;
    }
}
