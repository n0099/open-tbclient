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
/* loaded from: classes10.dex */
public class fm {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public fr f381a;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f382a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f385a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f386a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f383a = ByteBuffer.allocate(2048);
    public ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f384a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    public fp f380a = new fp();

    public fm(InputStream inputStream, fr frVar, Context context) {
        this.f382a = new BufferedInputStream(inputStream);
        this.f381a = frVar;
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
        this.f383a.clear();
        a(this.f383a, 8);
        short s = this.f383a.getShort(0);
        short s2 = this.f383a.getShort(2);
        if (s != -15618 || s2 != 5) {
            throw new IOException("Malformed Input");
        }
        int i2 = this.f383a.getInt(4);
        int position = this.f383a.position();
        if (i2 > 32768) {
            throw new IOException("Blob size too large");
        }
        if (i2 + 4 <= this.f383a.remaining()) {
            if (this.f383a.capacity() > 4096 && i2 < 2048) {
                allocate = ByteBuffer.allocate(2048);
                allocate.put(this.f383a.array(), 0, this.f383a.arrayOffset() + this.f383a.position());
            }
            a(this.f383a, i2);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            i = this.b.getInt();
            this.f384a.reset();
            this.f384a.update(this.f383a.array(), 0, this.f383a.position());
            if (i != ((int) this.f384a.getValue())) {
                byte[] bArr = this.f386a;
                if (bArr != null) {
                    com.xiaomi.push.service.bp.a(bArr, this.f383a.array(), true, position, i2);
                }
                return this.f383a;
            }
            com.xiaomi.channel.commonutils.logger.b.m180a("CRC = " + ((int) this.f384a.getValue()) + " and " + i);
            throw new IOException("Corrupted Blob bad CRC");
        }
        allocate = ByteBuffer.allocate(i2 + 2048);
        allocate.put(this.f383a.array(), 0, this.f383a.arrayOffset() + this.f383a.position());
        this.f383a = allocate;
        a(this.f383a, i2);
        this.b.clear();
        a(this.b, 4);
        this.b.position(0);
        i = this.b.getInt();
        this.f384a.reset();
        this.f384a.update(this.f383a.array(), 0, this.f383a.position());
        if (i != ((int) this.f384a.getValue())) {
        }
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f382a.read(byteBuffer.array(), position, i);
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
        this.f385a = false;
        fk m490a = m490a();
        if ("CONN".equals(m490a.m482a())) {
            dw.f a = dw.f.a(m490a.m486a());
            if (a.m421a()) {
                this.f381a.a(a.m420a());
                z = true;
            }
            if (a.c()) {
                dw.b m419a = a.m419a();
                fk fkVar = new fk();
                fkVar.a("SYNC", "CONF");
                fkVar.a(m419a.m446a(), (String) null);
                this.f381a.a(fkVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m180a("[Slim] CONN: host = " + a.m422b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m180a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f386a = this.f381a.m497a();
        while (!this.f385a) {
            fk m490a2 = m490a();
            this.f381a.c();
            short m484a = m490a2.m484a();
            if (m484a != 1) {
                if (m484a != 2) {
                    if (m484a != 3) {
                        str = "[Slim] unknow blob type " + ((int) m490a2.m484a());
                        com.xiaomi.channel.commonutils.logger.b.m180a(str);
                    } else {
                        try {
                            this.f381a.b(this.f380a.a(m490a2.m486a(), this.f381a));
                        } catch (Exception e) {
                            e = e;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(m490a2.a());
                            sb.append("; Id=");
                            sb.append(m490a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m180a(str);
                        }
                    }
                } else if ("SECMSG".equals(m490a2.m482a()) && ((m490a2.a() == 2 || m490a2.a() == 3) && TextUtils.isEmpty(m490a2.m488b()))) {
                    try {
                        this.f381a.b(this.f380a.a(m490a2.m487a(com.xiaomi.push.service.bg.a().a(Integer.valueOf(m490a2.a()).toString(), m490a2.g()).h), this.f381a));
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder();
                        sb.append("[Slim] Parse packet from Blob chid=");
                        sb.append(m490a2.a());
                        sb.append("; Id=");
                        sb.append(m490a2.e());
                        sb.append(" failure:");
                        sb.append(e.getMessage());
                        str = sb.toString();
                        com.xiaomi.channel.commonutils.logger.b.m180a(str);
                    }
                } else if (m490a2.a() == 10) {
                    m490a2.b(10);
                    m490a2.f376a.f902a = t.a(this.a);
                    m490a2.f376a.f904b = bi.e(this.a);
                    m490a2.f376a.f901a = System.currentTimeMillis();
                    com.xiaomi.channel.commonutils.logger.b.c("rcv blob from chid 10");
                }
            }
            this.f381a.a(m490a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fk m490a() {
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
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fqVar.m482a() + ";chid=" + fqVar.a() + ";len=" + i + "}");
            return fqVar;
        } catch (IOException e2) {
            e = e2;
            if (i == 0) {
                i = this.f383a.position();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[Slim] read Blob [");
            byte[] array = this.f383a.array();
            if (i > 128) {
                i = 128;
            }
            sb.append(ag.a(array, 0, i));
            sb.append("] Err:");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.m180a(sb.toString());
            throw e;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m491a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f385a) {
                throw e;
            }
        }
    }

    public void b() {
        this.f385a = true;
    }
}
