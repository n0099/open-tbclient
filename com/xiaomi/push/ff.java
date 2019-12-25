package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ee;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class ff {

    /* renamed from: a  reason: collision with other field name */
    private ee.a f357a;

    /* renamed from: a  reason: collision with other field name */
    String f358a;

    /* renamed from: a  reason: collision with other field name */
    private short f359a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f360b;
    private static String b = go.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f356a = new byte[0];

    public ff() {
        this.f359a = (short) 2;
        this.f360b = f356a;
        this.f358a = null;
        this.f357a = new ee.a();
    }

    ff(ee.a aVar, short s, byte[] bArr) {
        this.f359a = (short) 2;
        this.f360b = f356a;
        this.f358a = null;
        this.f357a = aVar;
        this.f359a = s;
        this.f360b = bArr;
    }

    @Deprecated
    public static ff a(gd gdVar, String str) {
        ff ffVar = new ff();
        int i = 1;
        try {
            i = Integer.parseInt(gdVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m33a("Blob parse chid err " + e.getMessage());
        }
        ffVar.a(i);
        ffVar.a(gdVar.j());
        ffVar.c(gdVar.m());
        ffVar.b(gdVar.n());
        ffVar.a("XMLMSG", (String) null);
        try {
            ffVar.a(gdVar.m291a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                ffVar.a((short) 3);
            } else {
                ffVar.a((short) 2);
                ffVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m33a("Blob setPayload err： " + e2.getMessage());
        }
        return ffVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ff a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            ee.a aVar = new ee.a();
            aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new ff(aVar, s, bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m33a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (ff.class) {
            StringBuilder append = new StringBuilder().append(b);
            long j = a;
            a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public int a() {
        return this.f357a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m255a() {
        return this.f357a.m218c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo256a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f359a);
        byteBuffer.putShort((short) this.f357a.a());
        byteBuffer.putInt(this.f360b.length);
        int position = byteBuffer.position();
        this.f357a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f357a.a());
        byteBuffer.position(position + this.f357a.a());
        byteBuffer.put(this.f360b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m257a() {
        return this.f359a;
    }

    public void a(int i) {
        this.f357a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f357a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f357a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f357a.b(str2);
    }

    public void a(String str) {
        this.f357a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f357a.c(str);
        this.f357a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f357a.d(str2);
    }

    public void a(short s) {
        this.f359a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f357a.c(0);
            this.f360b = bArr;
            return;
        }
        this.f357a.c(1);
        this.f360b = com.xiaomi.push.service.au.a(com.xiaomi.push.service.au.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m258a() {
        return this.f357a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m259a() {
        return this.f360b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m260a(String str) {
        if (this.f357a.e() == 1) {
            return com.xiaomi.push.service.au.a(com.xiaomi.push.service.au.a(str, e()), this.f360b);
        }
        if (this.f357a.e() == 0) {
            return this.f360b;
        }
        com.xiaomi.channel.commonutils.logger.b.m33a("unknow cipher = " + this.f357a.e());
        return this.f360b;
    }

    public int b() {
        return this.f357a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m261b() {
        return this.f357a.m220d();
    }

    public void b(String str) {
        this.f358a = str;
    }

    public int c() {
        return this.f357a.b() + 8 + this.f360b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m262c() {
        return this.f357a.m224f();
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
            this.f357a.a(parseLong);
            this.f357a.a(substring);
            this.f357a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m33a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m222e = this.f357a.m222e();
        if ("ID_NOT_AVAILABLE".equals(m222e)) {
            return null;
        }
        if (this.f357a.g()) {
            return m222e;
        }
        String d = d();
        this.f357a.e(d);
        return d;
    }

    public String f() {
        return this.f358a;
    }

    public String g() {
        if (this.f357a.b()) {
            return Long.toString(this.f357a.a()) + "@" + this.f357a.a() + "/" + this.f357a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m255a() + "; type=" + ((int) m257a()) + "; from=" + g() + " ]";
    }
}
