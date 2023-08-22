package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dw;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class fk {

    /* renamed from: a  reason: collision with other field name */
    public int f374a;

    /* renamed from: a  reason: collision with other field name */
    public dw.a f375a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.an f376a;

    /* renamed from: a  reason: collision with other field name */
    public String f377a;

    /* renamed from: a  reason: collision with other field name */
    public short f378a;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f379b;
    public static String b = gx.a(5) + "-";
    public static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f373a = new byte[0];

    public fk() {
        this.f378a = (short) 2;
        this.f379b = f373a;
        this.f377a = null;
        this.f376a = null;
        this.f375a = new dw.a();
        this.f374a = 1;
    }

    public fk(dw.a aVar, short s, byte[] bArr) {
        this.f378a = (short) 2;
        this.f379b = f373a;
        this.f377a = null;
        this.f376a = null;
        this.f375a = aVar;
        this.f378a = s;
        this.f379b = bArr;
        this.f374a = 2;
    }

    @Deprecated
    public static fk a(gm gmVar, String str) {
        int i;
        fk fkVar = new fk();
        try {
            i = Integer.parseInt(gmVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m180a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        fkVar.a(i);
        fkVar.a(gmVar.j());
        fkVar.c(gmVar.m());
        fkVar.b(gmVar.n());
        fkVar.a("XMLMSG", (String) null);
        try {
            fkVar.a(gmVar.mo529a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                fkVar.a((short) 3);
            } else {
                fkVar.a((short) 2);
                fkVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m180a("Blob setPayload err： " + e2.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m180a("read Blob err :" + e.getMessage());
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
        return this.f375a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m482a() {
        return this.f375a.m381c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo483a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f378a);
        byteBuffer.putShort((short) this.f375a.a());
        byteBuffer.putInt(this.f379b.length);
        int position = byteBuffer.position();
        this.f375a.m445a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f375a.a());
        byteBuffer.position(position + this.f375a.a());
        byteBuffer.put(this.f379b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m484a() {
        return this.f378a;
    }

    public void a(int i) {
        this.f375a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f375a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f375a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f375a.b(str2);
    }

    public void a(String str) {
        this.f375a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f375a.c(str);
        this.f375a.m376a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f375a.d(str2);
    }

    public void a(short s) {
        this.f378a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f375a.c(0);
            this.f379b = bArr;
            return;
        }
        this.f375a.c(1);
        this.f379b = com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m485a() {
        return this.f375a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m486a() {
        return fl.a(this, this.f379b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m487a(String str) {
        if (this.f375a.e() == 1) {
            return fl.a(this, com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), this.f379b));
        }
        if (this.f375a.e() == 0) {
            return fl.a(this, this.f379b);
        }
        com.xiaomi.channel.commonutils.logger.b.m180a("unknow cipher = " + this.f375a.e());
        return fl.a(this, this.f379b);
    }

    public int b() {
        return this.f375a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m488b() {
        return this.f375a.m383d();
    }

    public void b(int i) {
        com.xiaomi.push.service.an anVar = new com.xiaomi.push.service.an();
        this.f376a = anVar;
        anVar.a = i;
    }

    public void b(String str) {
        this.f377a = str;
    }

    public int c() {
        return this.f375a.b() + 8 + this.f379b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m489c() {
        return this.f375a.m387f();
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
            this.f375a.a(parseLong);
            this.f375a.a(substring);
            this.f375a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m180a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m385e = this.f375a.m385e();
        if ("ID_NOT_AVAILABLE".equals(m385e)) {
            return null;
        }
        if (this.f375a.g()) {
            return m385e;
        }
        String d = d();
        this.f375a.e(d);
        return d;
    }

    public String f() {
        return this.f377a;
    }

    public String g() {
        if (this.f375a.m380b()) {
            return Long.toString(this.f375a.m375a()) + "@" + this.f375a.m377a() + "/" + this.f375a.m379b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.bd.a(e()) + "; cmd=" + m482a() + "; type=" + ((int) m484a()) + "; from=" + g() + " ]";
    }
}
