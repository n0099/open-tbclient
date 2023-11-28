package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dw;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class fk {

    /* renamed from: a  reason: collision with other field name */
    public int f369a;

    /* renamed from: a  reason: collision with other field name */
    public dw.a f370a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.an f371a;

    /* renamed from: a  reason: collision with other field name */
    public String f372a;

    /* renamed from: a  reason: collision with other field name */
    public short f373a;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f374b;
    public static String b = gx.a(5) + "-";
    public static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f368a = new byte[0];

    public fk() {
        this.f373a = (short) 2;
        this.f374b = f368a;
        this.f372a = null;
        this.f371a = null;
        this.f370a = new dw.a();
        this.f369a = 1;
    }

    public fk(dw.a aVar, short s, byte[] bArr) {
        this.f373a = (short) 2;
        this.f374b = f368a;
        this.f372a = null;
        this.f371a = null;
        this.f370a = aVar;
        this.f373a = s;
        this.f374b = bArr;
        this.f369a = 2;
    }

    @Deprecated
    public static fk a(gm gmVar, String str) {
        int i;
        fk fkVar = new fk();
        try {
            i = Integer.parseInt(gmVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m190a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        fkVar.a(i);
        fkVar.a(gmVar.j());
        fkVar.c(gmVar.m());
        fkVar.b(gmVar.n());
        fkVar.a("XMLMSG", (String) null);
        try {
            fkVar.a(gmVar.mo539a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                fkVar.a((short) 3);
            } else {
                fkVar.a((short) 2);
                fkVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m190a("Blob setPayload err： " + e2.getMessage());
        }
        return fkVar;
    }

    public static fk a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            dw.a aVar = new dw.a();
            aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new fk(aVar, s, bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m190a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (fk.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b);
            long j = a;
            a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public int a() {
        return this.f370a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m492a() {
        return this.f370a.m391c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo493a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f373a);
        byteBuffer.putShort((short) this.f370a.a());
        byteBuffer.putInt(this.f374b.length);
        int position = byteBuffer.position();
        this.f370a.m455a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f370a.a());
        byteBuffer.position(position + this.f370a.a());
        byteBuffer.put(this.f374b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m494a() {
        return this.f373a;
    }

    public void a(int i) {
        this.f370a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f370a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f370a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f370a.b(str2);
    }

    public void a(String str) {
        this.f370a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f370a.c(str);
        this.f370a.m386a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f370a.d(str2);
    }

    public void a(short s) {
        this.f373a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f370a.c(0);
            this.f374b = bArr;
            return;
        }
        this.f370a.c(1);
        this.f374b = com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m495a() {
        return this.f370a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m496a() {
        return fl.a(this, this.f374b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m497a(String str) {
        if (this.f370a.e() == 1) {
            return fl.a(this, com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), this.f374b));
        }
        if (this.f370a.e() == 0) {
            return fl.a(this, this.f374b);
        }
        com.xiaomi.channel.commonutils.logger.b.m190a("unknow cipher = " + this.f370a.e());
        return fl.a(this, this.f374b);
    }

    public int b() {
        return this.f370a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m498b() {
        return this.f370a.m393d();
    }

    public void b(int i) {
        com.xiaomi.push.service.an anVar = new com.xiaomi.push.service.an();
        this.f371a = anVar;
        anVar.a = i;
    }

    public void b(String str) {
        this.f372a = str;
    }

    public int c() {
        return this.f370a.b() + 8 + this.f374b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m499c() {
        return this.f370a.m397f();
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f370a.a(parseLong);
            this.f370a.a(substring);
            this.f370a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m190a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m395e = this.f370a.m395e();
        if ("ID_NOT_AVAILABLE".equals(m395e)) {
            return null;
        }
        if (this.f370a.g()) {
            return m395e;
        }
        String d = d();
        this.f370a.e(d);
        return d;
    }

    public String f() {
        return this.f372a;
    }

    public String g() {
        if (this.f370a.m390b()) {
            return Long.toString(this.f370a.m385a()) + "@" + this.f370a.m387a() + "/" + this.f370a.m389b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.bd.a(e()) + "; cmd=" + m492a() + "; type=" + ((int) m494a()) + "; from=" + g() + " ]";
    }
}
