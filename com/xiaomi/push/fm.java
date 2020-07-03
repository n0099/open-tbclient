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
    private fq f348a;

    /* renamed from: a  reason: collision with other field name */
    private InputStream f349a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f352a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f353a;

    /* renamed from: a  reason: collision with other field name */
    private ByteBuffer f350a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f351a = new Adler32();
    private fo a = new fo();

    /* JADX INFO: Access modifiers changed from: package-private */
    public fm(InputStream inputStream, fq fqVar) {
        this.f349a = new BufferedInputStream(inputStream);
        this.f348a = fqVar;
    }

    private ByteBuffer a() {
        this.f350a.clear();
        a(this.f350a, 8);
        short s = this.f350a.getShort(0);
        short s2 = this.f350a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f350a.getInt(4);
            int position = this.f350a.position();
            if (i > 32768) {
                throw new IOException("Blob size too large");
            }
            if (i + 4 > this.f350a.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                allocate.put(this.f350a.array(), 0, this.f350a.arrayOffset() + this.f350a.position());
                this.f350a = allocate;
            } else if (this.f350a.capacity() > 4096 && i < 2048) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                allocate2.put(this.f350a.array(), 0, this.f350a.arrayOffset() + this.f350a.position());
                this.f350a = allocate2;
            }
            a(this.f350a, i);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            int i2 = this.b.getInt();
            this.f351a.reset();
            this.f351a.update(this.f350a.array(), 0, this.f350a.position());
            if (i2 != ((int) this.f351a.getValue())) {
                com.xiaomi.channel.commonutils.logger.b.m48a("CRC = " + ((int) this.f351a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            if (this.f353a != null) {
                com.xiaomi.push.service.ay.a(this.f353a, this.f350a.array(), true, position, i);
            }
            return this.f350a;
        }
        throw new IOException("Malformed Input");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f349a.read(byteBuffer.array(), position, i);
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
        this.f352a = false;
        fl m282a = m282a();
        if ("CONN".equals(m282a.m274a())) {
            ek.f a = ek.f.a(m282a.m278a());
            if (a.a()) {
                this.f348a.a(a.a());
                z = true;
            }
            if (a.c()) {
                ek.b a2 = a.a();
                fl flVar = new fl();
                flVar.a("SYNC", "CONF");
                flVar.a(a2.a(), (String) null);
                this.f348a.a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("[Slim] CONN: host = " + a.b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m48a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f353a = this.f348a.a();
        while (!this.f352a) {
            fl m282a2 = m282a();
            this.f348a.c();
            switch (m282a2.m276a()) {
                case 1:
                    this.f348a.a(m282a2);
                    break;
                case 2:
                    if (!"SECMSG".equals(m282a2.m274a()) || ((m282a2.a() != 2 && m282a2.a() != 3) || !TextUtils.isEmpty(m282a2.m280b()))) {
                        this.f348a.a(m282a2);
                        break;
                    } else {
                        try {
                            this.f348a.b(this.a.a(m282a2.m279a(com.xiaomi.push.service.ap.a().a(Integer.valueOf(m282a2.a()).toString(), m282a2.g()).h), this.f348a));
                            break;
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.m48a("[Slim] Parse packet from Blob chid=" + m282a2.a() + "; Id=" + m282a2.e() + " failure:" + e.getMessage());
                            break;
                        }
                    }
                case 3:
                    try {
                        this.f348a.b(this.a.a(m282a2.m278a(), this.f348a));
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
                    i = this.f350a.position();
                }
                StringBuilder append = new StringBuilder().append("[Slim] read Blob [");
                byte[] array = this.f350a.array();
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
            if (!this.f352a) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f352a = true;
    }
}
