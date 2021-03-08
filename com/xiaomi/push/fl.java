package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ek;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class fl {

    /* renamed from: a  reason: collision with other field name */
    private ek.a f339a;

    /* renamed from: a  reason: collision with other field name */
    String f340a;

    /* renamed from: a  reason: collision with other field name */
    private short f341a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f342b;
    private static String b = gu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a  reason: collision with root package name */
    private static long f8368a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f338a = new byte[0];

    public fl() {
        this.f341a = (short) 2;
        this.f342b = f338a;
        this.f340a = null;
        this.f339a = new ek.a();
    }

    fl(ek.a aVar, short s, byte[] bArr) {
        this.f341a = (short) 2;
        this.f342b = f338a;
        this.f340a = null;
        this.f339a = aVar;
        this.f341a = s;
        this.f342b = bArr;
    }

    @Deprecated
    public static fl a(gj gjVar, String str) {
        fl flVar = new fl();
        int i = 1;
        try {
            i = Integer.parseInt(gjVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m58a("Blob parse chid err " + e.getMessage());
        }
        flVar.a(i);
        flVar.a(gjVar.j());
        flVar.c(gjVar.m());
        flVar.b(gjVar.n());
        flVar.a("XMLMSG", (String) null);
        try {
            flVar.a(gjVar.m320a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                flVar.a((short) 3);
            } else {
                flVar.a((short) 2);
                flVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m58a("Blob setPayload err： " + e2.getMessage());
        }
        return flVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static fl a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            ek.a aVar = new ek.a();
            aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new fl(aVar, s, bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m58a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (fl.class) {
            StringBuilder append = new StringBuilder().append(b);
            long j = f8368a;
            f8368a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public int a() {
        return this.f339a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m284a() {
        return this.f339a.m245c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo285a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f341a);
        byteBuffer.putShort((short) this.f339a.a());
        byteBuffer.putInt(this.f342b.length);
        int position = byteBuffer.position();
        this.f339a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f339a.a());
        byteBuffer.position(position + this.f339a.a());
        byteBuffer.put(this.f342b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m286a() {
        return this.f341a;
    }

    public void a(int i) {
        this.f339a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f339a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f339a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f339a.b(str2);
    }

    public void a(String str) {
        this.f339a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f339a.c(str);
        this.f339a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f339a.d(str2);
    }

    public void a(short s) {
        this.f341a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f339a.c(0);
            this.f342b = bArr;
            return;
        }
        this.f339a.c(1);
        this.f342b = com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m287a() {
        return this.f339a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m288a() {
        return this.f342b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m289a(String str) {
        if (this.f339a.e() == 1) {
            return com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), this.f342b);
        }
        if (this.f339a.e() == 0) {
            return this.f342b;
        }
        com.xiaomi.channel.commonutils.logger.b.m58a("unknow cipher = " + this.f339a.e());
        return this.f342b;
    }

    public int b() {
        return this.f339a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m290b() {
        return this.f339a.m247d();
    }

    public void b(String str) {
        this.f340a = str;
    }

    public int c() {
        return this.f339a.b() + 8 + this.f342b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m291c() {
        return this.f339a.m251f();
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
            this.f339a.a(parseLong);
            this.f339a.a(substring);
            this.f339a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m58a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m249e = this.f339a.m249e();
        if ("ID_NOT_AVAILABLE".equals(m249e)) {
            return null;
        }
        if (this.f339a.g()) {
            return m249e;
        }
        String d = d();
        this.f339a.e(d);
        return d;
    }

    public String f() {
        return this.f340a;
    }

    public String g() {
        if (this.f339a.b()) {
            return Long.toString(this.f339a.a()) + "@" + this.f339a.a() + "/" + this.f339a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m284a() + "; type=" + ((int) m286a()) + "; from=" + g() + " ]";
    }
}
