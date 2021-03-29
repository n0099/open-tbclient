package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.du;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class fa {

    /* renamed from: a  reason: collision with other field name */
    public int f357a;

    /* renamed from: a  reason: collision with other field name */
    public du.a f358a;

    /* renamed from: a  reason: collision with other field name */
    public String f359a;

    /* renamed from: a  reason: collision with other field name */
    public short f360a;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f361b;

    /* renamed from: b  reason: collision with root package name */
    public static String f40492b = gn.a(5) + "-";

    /* renamed from: a  reason: collision with root package name */
    public static long f40491a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f356a = new byte[0];

    public fa() {
        this.f360a = (short) 2;
        this.f361b = f356a;
        this.f359a = null;
        this.f358a = new du.a();
        this.f357a = 1;
    }

    public fa(du.a aVar, short s, byte[] bArr) {
        this.f360a = (short) 2;
        this.f361b = f356a;
        this.f359a = null;
        this.f358a = aVar;
        this.f360a = s;
        this.f361b = bArr;
        this.f357a = 2;
    }

    @Deprecated
    public static fa a(gc gcVar, String str) {
        int i;
        fa faVar = new fa();
        try {
            i = Integer.parseInt(gcVar.k());
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a("Blob parse chid err " + e2.getMessage());
            i = 1;
        }
        faVar.a(i);
        faVar.a(gcVar.j());
        faVar.c(gcVar.m());
        faVar.b(gcVar.n());
        faVar.a("XMLMSG", (String) null);
        try {
            faVar.a(gcVar.m326a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                faVar.a((short) 3);
            } else {
                faVar.a((short) 2);
                faVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e3) {
            com.xiaomi.channel.commonutils.logger.b.m51a("Blob setPayload err： " + e3.getMessage());
        }
        return faVar;
    }

    public static fa a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            du.a aVar = new du.a();
            aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new fa(aVar, s, bArr);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a("read Blob err :" + e2.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (fa.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f40492b);
            long j = f40491a;
            f40491a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public int a() {
        return this.f358a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m283a() {
        return this.f358a.m235c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo284a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f360a);
        byteBuffer.putShort((short) this.f358a.a());
        byteBuffer.putInt(this.f361b.length);
        int position = byteBuffer.position();
        this.f358a.m261a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f358a.a());
        byteBuffer.position(position + this.f358a.a());
        byteBuffer.put(this.f361b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m285a() {
        return this.f360a;
    }

    public void a(int i) {
        this.f358a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f358a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f358a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f358a.b(str2);
    }

    public void a(String str) {
        this.f358a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f358a.c(str);
        this.f358a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f358a.d(str2);
    }

    public void a(short s) {
        this.f360a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f358a.c(0);
            this.f361b = bArr;
            return;
        }
        this.f358a.c(1);
        this.f361b = com.xiaomi.push.service.be.a(com.xiaomi.push.service.be.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m286a() {
        return this.f358a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m287a() {
        return fb.a(this, this.f361b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m288a(String str) {
        if (this.f358a.e() == 1) {
            return fb.a(this, com.xiaomi.push.service.be.a(com.xiaomi.push.service.be.a(str, e()), this.f361b));
        }
        if (this.f358a.e() == 0) {
            return fb.a(this, this.f361b);
        }
        com.xiaomi.channel.commonutils.logger.b.m51a("unknow cipher = " + this.f358a.e());
        return fb.a(this, this.f361b);
    }

    public int b() {
        return this.f358a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m289b() {
        return this.f358a.m237d();
    }

    public void b(String str) {
        this.f359a = str;
    }

    public int c() {
        return this.f358a.b() + 8 + this.f361b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m290c() {
        return this.f358a.m241f();
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
            this.f358a.a(parseLong);
            this.f358a.a(substring);
            this.f358a.b(substring2);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a("Blob parse user err " + e2.getMessage());
        }
    }

    public String e() {
        String m239e = this.f358a.m239e();
        if ("ID_NOT_AVAILABLE".equals(m239e)) {
            return null;
        }
        if (this.f358a.g()) {
            return m239e;
        }
        String d2 = d();
        this.f358a.e(d2);
        return d2;
    }

    public String f() {
        return this.f359a;
    }

    public String g() {
        if (this.f358a.b()) {
            return Long.toString(this.f358a.a()) + "@" + this.f358a.a() + "/" + this.f358a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m283a() + "; type=" + ((int) m285a()) + "; from=" + g() + " ]";
    }
}
