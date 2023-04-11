package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.dw;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
/* loaded from: classes8.dex */
public class fm {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public fr f380a;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f381a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f384a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f385a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f382a = ByteBuffer.allocate(2048);
    public ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f383a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    public fp f379a = new fp();

    public fm(InputStream inputStream, fr frVar, Context context) {
        this.f381a = new BufferedInputStream(inputStream);
        this.f380a = frVar;
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ByteBuffer a() {
        ByteBuffer allocate;
        int i;
        this.f382a.clear();
        a(this.f382a, 8);
        short s = this.f382a.getShort(0);
        short s2 = this.f382a.getShort(2);
        if (s != -15618 || s2 != 5) {
            throw new IOException("Malformed Input");
        }
        int i2 = this.f382a.getInt(4);
        int position = this.f382a.position();
        if (i2 > 32768) {
            throw new IOException("Blob size too large");
        }
        if (i2 + 4 <= this.f382a.remaining()) {
            if (this.f382a.capacity() > 4096 && i2 < 2048) {
                allocate = ByteBuffer.allocate(2048);
                allocate.put(this.f382a.array(), 0, this.f382a.arrayOffset() + this.f382a.position());
            }
            a(this.f382a, i2);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            i = this.b.getInt();
            this.f383a.reset();
            this.f383a.update(this.f382a.array(), 0, this.f382a.position());
            if (i != ((int) this.f383a.getValue())) {
                byte[] bArr = this.f385a;
                if (bArr != null) {
                    com.xiaomi.push.service.bp.a(bArr, this.f382a.array(), true, position, i2);
                }
                return this.f382a;
            }
            com.xiaomi.channel.commonutils.logger.b.m101a("CRC = " + ((int) this.f383a.getValue()) + " and " + i);
            throw new IOException("Corrupted Blob bad CRC");
        }
        allocate = ByteBuffer.allocate(i2 + 2048);
        allocate.put(this.f382a.array(), 0, this.f382a.arrayOffset() + this.f382a.position());
        this.f382a = allocate;
        a(this.f382a, i2);
        this.b.clear();
        a(this.b, 4);
        this.b.position(0);
        i = this.b.getInt();
        this.f383a.reset();
        this.f383a.update(this.f382a.array(), 0, this.f382a.position());
        if (i != ((int) this.f383a.getValue())) {
        }
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f381a.read(byteBuffer.array(), position, i);
            if (read == -1) {
                throw new EOFException();
            }
            i -= read;
            position += read;
        } while (i > 0);
        byteBuffer.position(position);
    }

    private void c() {
        String str;
        StringBuilder sb;
        boolean z = false;
        this.f384a = false;
        fk m411a = m411a();
        if ("CONN".equals(m411a.m403a())) {
            dw.f a = dw.f.a(m411a.m407a());
            if (a.m342a()) {
                this.f380a.a(a.m341a());
                z = true;
            }
            if (a.c()) {
                dw.b m340a = a.m340a();
                fk fkVar = new fk();
                fkVar.a("SYNC", "CONF");
                fkVar.a(m340a.m367a(), (String) null);
                this.f380a.a(fkVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m101a("[Slim] CONN: host = " + a.m343b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m101a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f385a = this.f380a.m418a();
        while (!this.f384a) {
            fk m411a2 = m411a();
            this.f380a.c();
            short m405a = m411a2.m405a();
            if (m405a != 1) {
                if (m405a != 2) {
                    if (m405a != 3) {
                        str = "[Slim] unknow blob type " + ((int) m411a2.m405a());
                        com.xiaomi.channel.commonutils.logger.b.m101a(str);
                    } else {
                        try {
                            this.f380a.b(this.f379a.a(m411a2.m407a(), this.f380a));
                        } catch (Exception e) {
                            e = e;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(m411a2.a());
                            sb.append("; Id=");
                            sb.append(m411a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m101a(str);
                        }
                    }
                } else if ("SECMSG".equals(m411a2.m403a()) && ((m411a2.a() == 2 || m411a2.a() == 3) && TextUtils.isEmpty(m411a2.m409b()))) {
                    try {
                        this.f380a.b(this.f379a.a(m411a2.m408a(com.xiaomi.push.service.bg.a().a(Integer.valueOf(m411a2.a()).toString(), m411a2.g()).h), this.f380a));
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder();
                        sb.append("[Slim] Parse packet from Blob chid=");
                        sb.append(m411a2.a());
                        sb.append("; Id=");
                        sb.append(m411a2.e());
                        sb.append(" failure:");
                        sb.append(e.getMessage());
                        str = sb.toString();
                        com.xiaomi.channel.commonutils.logger.b.m101a(str);
                    }
                } else if (m411a2.a() == 10) {
                    m411a2.b(10);
                    m411a2.f375a.f901a = t.a(this.a);
                    m411a2.f375a.f903b = bi.e(this.a);
                    m411a2.f375a.f900a = System.currentTimeMillis();
                    com.xiaomi.channel.commonutils.logger.b.c("rcv blob from chid 10");
                }
            }
            this.f380a.a(m411a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fk m411a() {
        int i;
        ByteBuffer a;
        try {
            a = a();
            i = a.position();
        } catch (IOException e) {
            e = e;
            i = 0;
        }
        try {
            a.flip();
            a.position(8);
            fk fqVar = i == 8 ? new fq() : fk.a(a.slice());
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fqVar.m403a() + ";chid=" + fqVar.a() + ";len=" + i + "}");
            return fqVar;
        } catch (IOException e2) {
            e = e2;
            if (i == 0) {
                i = this.f382a.position();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[Slim] read Blob [");
            byte[] array = this.f382a.array();
            if (i > 128) {
                i = 128;
            }
            sb.append(ag.a(array, 0, i));
            sb.append("] Err:");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.m101a(sb.toString());
            throw e;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m412a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f384a) {
                throw e;
            }
        }
    }

    public void b() {
        this.f384a = true;
    }
}
