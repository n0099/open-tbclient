package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dw;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class fk {

    /* renamed from: a  reason: collision with other field name */
    public int f373a;

    /* renamed from: a  reason: collision with other field name */
    public dw.a f374a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.an f375a;

    /* renamed from: a  reason: collision with other field name */
    public String f376a;

    /* renamed from: a  reason: collision with other field name */
    public short f377a;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f378b;
    public static String b = gx.a(5) + "-";
    public static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f372a = new byte[0];

    public fk() {
        this.f377a = (short) 2;
        this.f378b = f372a;
        this.f376a = null;
        this.f375a = null;
        this.f374a = new dw.a();
        this.f373a = 1;
    }

    public fk(dw.a aVar, short s, byte[] bArr) {
        this.f377a = (short) 2;
        this.f378b = f372a;
        this.f376a = null;
        this.f375a = null;
        this.f374a = aVar;
        this.f377a = s;
        this.f378b = bArr;
        this.f373a = 2;
    }

    @Deprecated
    public static fk a(gm gmVar, String str) {
        int i;
        fk fkVar = new fk();
        try {
            i = Integer.parseInt(gmVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m175a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        fkVar.a(i);
        fkVar.a(gmVar.j());
        fkVar.c(gmVar.m());
        fkVar.b(gmVar.n());
        fkVar.a("XMLMSG", (String) null);
        try {
            fkVar.a(gmVar.mo524a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                fkVar.a((short) 3);
            } else {
                fkVar.a((short) 2);
                fkVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m175a("Blob setPayload err： " + e2.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m175a("read Blob err :" + e.getMessage());
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
        return this.f374a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m477a() {
        return this.f374a.m376c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo478a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f377a);
        byteBuffer.putShort((short) this.f374a.a());
        byteBuffer.putInt(this.f378b.length);
        int position = byteBuffer.position();
        this.f374a.m440a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f374a.a());
        byteBuffer.position(position + this.f374a.a());
        byteBuffer.put(this.f378b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m479a() {
        return this.f377a;
    }

    public void a(int i) {
        this.f374a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f374a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f374a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f374a.b(str2);
    }

    public void a(String str) {
        this.f374a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f374a.c(str);
        this.f374a.m371a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f374a.d(str2);
    }

    public void a(short s) {
        this.f377a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f374a.c(0);
            this.f378b = bArr;
            return;
        }
        this.f374a.c(1);
        this.f378b = com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m480a() {
        return this.f374a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m481a() {
        return fl.a(this, this.f378b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m482a(String str) {
        if (this.f374a.e() == 1) {
            return fl.a(this, com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), this.f378b));
        }
        if (this.f374a.e() == 0) {
            return fl.a(this, this.f378b);
        }
        com.xiaomi.channel.commonutils.logger.b.m175a("unknow cipher = " + this.f374a.e());
        return fl.a(this, this.f378b);
    }

    public int b() {
        return this.f374a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m483b() {
        return this.f374a.m378d();
    }

    public void b(int i) {
        com.xiaomi.push.service.an anVar = new com.xiaomi.push.service.an();
        this.f375a = anVar;
        anVar.a = i;
    }

    public void b(String str) {
        this.f376a = str;
    }

    public int c() {
        return this.f374a.b() + 8 + this.f378b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m484c() {
        return this.f374a.m382f();
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
            this.f374a.a(parseLong);
            this.f374a.a(substring);
            this.f374a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m175a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m380e = this.f374a.m380e();
        if ("ID_NOT_AVAILABLE".equals(m380e)) {
            return null;
        }
        if (this.f374a.g()) {
            return m380e;
        }
        String d = d();
        this.f374a.e(d);
        return d;
    }

    public String f() {
        return this.f376a;
    }

    public String g() {
        if (this.f374a.m375b()) {
            return Long.toString(this.f374a.m370a()) + "@" + this.f374a.m372a() + "/" + this.f374a.m374b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.bd.a(e()) + "; cmd=" + m477a() + "; type=" + ((int) m479a()) + "; from=" + g() + " ]";
    }
}
