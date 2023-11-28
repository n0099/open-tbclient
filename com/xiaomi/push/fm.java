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
    public fr f376a;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f377a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f380a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f381a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f378a = ByteBuffer.allocate(2048);
    public ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f379a = new Adler32();

    /* renamed from: a  reason: collision with other field name */
    public fp f375a = new fp();

    public fm(InputStream inputStream, fr frVar, Context context) {
        this.f377a = new BufferedInputStream(inputStream);
        this.f376a = frVar;
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
        this.f378a.clear();
        a(this.f378a, 8);
        short s = this.f378a.getShort(0);
        short s2 = this.f378a.getShort(2);
        if (s != -15618 || s2 != 5) {
            throw new IOException("Malformed Input");
        }
        int i2 = this.f378a.getInt(4);
        int position = this.f378a.position();
        if (i2 > 32768) {
            throw new IOException("Blob size too large");
        }
        if (i2 + 4 <= this.f378a.remaining()) {
            if (this.f378a.capacity() > 4096 && i2 < 2048) {
                allocate = ByteBuffer.allocate(2048);
                allocate.put(this.f378a.array(), 0, this.f378a.arrayOffset() + this.f378a.position());
            }
            a(this.f378a, i2);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            i = this.b.getInt();
            this.f379a.reset();
            this.f379a.update(this.f378a.array(), 0, this.f378a.position());
            if (i != ((int) this.f379a.getValue())) {
                byte[] bArr = this.f381a;
                if (bArr != null) {
                    com.xiaomi.push.service.bp.a(bArr, this.f378a.array(), true, position, i2);
                }
                return this.f378a;
            }
            com.xiaomi.channel.commonutils.logger.b.m190a("CRC = " + ((int) this.f379a.getValue()) + " and " + i);
            throw new IOException("Corrupted Blob bad CRC");
        }
        allocate = ByteBuffer.allocate(i2 + 2048);
        allocate.put(this.f378a.array(), 0, this.f378a.arrayOffset() + this.f378a.position());
        this.f378a = allocate;
        a(this.f378a, i2);
        this.b.clear();
        a(this.b, 4);
        this.b.position(0);
        i = this.b.getInt();
        this.f379a.reset();
        this.f379a.update(this.f378a.array(), 0, this.f378a.position());
        if (i != ((int) this.f379a.getValue())) {
        }
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f377a.read(byteBuffer.array(), position, i);
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
        this.f380a = false;
        fk m500a = m500a();
        if ("CONN".equals(m500a.m492a())) {
            dw.f a = dw.f.a(m500a.m496a());
            if (a.m431a()) {
                this.f376a.a(a.m430a());
                z = true;
            }
            if (a.c()) {
                dw.b m429a = a.m429a();
                fk fkVar = new fk();
                fkVar.a("SYNC", "CONF");
                fkVar.a(m429a.m456a(), (String) null);
                this.f376a.a(fkVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m190a("[Slim] CONN: host = " + a.m432b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m190a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f381a = this.f376a.m507a();
        while (!this.f380a) {
            fk m500a2 = m500a();
            this.f376a.c();
            short m494a = m500a2.m494a();
            if (m494a != 1) {
                if (m494a != 2) {
                    if (m494a != 3) {
                        str = "[Slim] unknow blob type " + ((int) m500a2.m494a());
                        com.xiaomi.channel.commonutils.logger.b.m190a(str);
                    } else {
                        try {
                            this.f376a.b(this.f375a.a(m500a2.m496a(), this.f376a));
                        } catch (Exception e) {
                            e = e;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(m500a2.a());
                            sb.append("; Id=");
                            sb.append(m500a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m190a(str);
                        }
                    }
                } else if ("SECMSG".equals(m500a2.m492a()) && ((m500a2.a() == 2 || m500a2.a() == 3) && TextUtils.isEmpty(m500a2.m498b()))) {
                    try {
                        this.f376a.b(this.f375a.a(m500a2.m497a(com.xiaomi.push.service.bg.a().a(Integer.valueOf(m500a2.a()).toString(), m500a2.g()).h), this.f376a));
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder();
                        sb.append("[Slim] Parse packet from Blob chid=");
                        sb.append(m500a2.a());
                        sb.append("; Id=");
                        sb.append(m500a2.e());
                        sb.append(" failure:");
                        sb.append(e.getMessage());
                        str = sb.toString();
                        com.xiaomi.channel.commonutils.logger.b.m190a(str);
                    }
                } else if (m500a2.a() == 10) {
                    m500a2.b(10);
                    m500a2.f371a.f897a = t.a(this.a);
                    m500a2.f371a.f899b = bi.e(this.a);
                    m500a2.f371a.f896a = System.currentTimeMillis();
                    com.xiaomi.channel.commonutils.logger.b.c("rcv blob from chid 10");
                }
            }
            this.f376a.a(m500a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fk m500a() {
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
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fqVar.m492a() + ";chid=" + fqVar.a() + ";len=" + i + "}");
            return fqVar;
        } catch (IOException e2) {
            e = e2;
            if (i == 0) {
                i = this.f378a.position();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[Slim] read Blob [");
            byte[] array = this.f378a.array();
            if (i > 128) {
                i = 128;
            }
            sb.append(ag.a(array, 0, i));
            sb.append("] Err:");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.m190a(sb.toString());
            throw e;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m501a() {
        try {
            c();
        } catch (IOException e) {
            if (!this.f380a) {
                throw e;
            }
        }
    }

    public void b() {
        this.f380a = true;
    }
}
