package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ek;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class fl {

    /* renamed from: a  reason: collision with other field name */
    private ek.a f419a;

    /* renamed from: a  reason: collision with other field name */
    String f420a;

    /* renamed from: a  reason: collision with other field name */
    private short f421a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f422b;

    /* renamed from: b  reason: collision with root package name */
    private static String f14319b = gu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a  reason: collision with root package name */
    private static long f14318a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f418a = new byte[0];

    public fl() {
        this.f421a = (short) 2;
        this.f422b = f418a;
        this.f420a = null;
        this.f419a = new ek.a();
    }

    fl(ek.a aVar, short s, byte[] bArr) {
        this.f421a = (short) 2;
        this.f422b = f418a;
        this.f420a = null;
        this.f419a = aVar;
        this.f421a = s;
        this.f422b = bArr;
    }

    @Deprecated
    public static fl a(gj gjVar, String str) {
        fl flVar = new fl();
        int i = 1;
        try {
            i = Integer.parseInt(gjVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m84a("Blob parse chid err " + e.getMessage());
        }
        flVar.a(i);
        flVar.a(gjVar.j());
        flVar.c(gjVar.m());
        flVar.b(gjVar.n());
        flVar.a("XMLMSG", (String) null);
        try {
            flVar.a(gjVar.m346a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                flVar.a((short) 3);
            } else {
                flVar.a((short) 2);
                flVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m84a("Blob setPayload err： " + e2.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m84a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (fl.class) {
            StringBuilder append = new StringBuilder().append(f14319b);
            long j = f14318a;
            f14318a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public int a() {
        return this.f419a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m310a() {
        return this.f419a.m271c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo311a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f421a);
        byteBuffer.putShort((short) this.f419a.a());
        byteBuffer.putInt(this.f422b.length);
        int position = byteBuffer.position();
        this.f419a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f419a.a());
        byteBuffer.position(position + this.f419a.a());
        byteBuffer.put(this.f422b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m312a() {
        return this.f421a;
    }

    public void a(int i) {
        this.f419a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f419a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f419a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f419a.b(str2);
    }

    public void a(String str) {
        this.f419a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f419a.c(str);
        this.f419a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f419a.d(str2);
    }

    public void a(short s) {
        this.f421a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f419a.c(0);
            this.f422b = bArr;
            return;
        }
        this.f419a.c(1);
        this.f422b = com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m313a() {
        return this.f419a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m314a() {
        return this.f422b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m315a(String str) {
        if (this.f419a.e() == 1) {
            return com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), this.f422b);
        }
        if (this.f419a.e() == 0) {
            return this.f422b;
        }
        com.xiaomi.channel.commonutils.logger.b.m84a("unknow cipher = " + this.f419a.e());
        return this.f422b;
    }

    public int b() {
        return this.f419a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m316b() {
        return this.f419a.m273d();
    }

    public void b(String str) {
        this.f420a = str;
    }

    public int c() {
        return this.f419a.b() + 8 + this.f422b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m317c() {
        return this.f419a.m277f();
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
            this.f419a.a(parseLong);
            this.f419a.a(substring);
            this.f419a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m84a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m275e = this.f419a.m275e();
        if ("ID_NOT_AVAILABLE".equals(m275e)) {
            return null;
        }
        if (this.f419a.g()) {
            return m275e;
        }
        String d = d();
        this.f419a.e(d);
        return d;
    }

    public String f() {
        return this.f420a;
    }

    public String g() {
        if (this.f419a.b()) {
            return Long.toString(this.f419a.a()) + "@" + this.f419a.a() + "/" + this.f419a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m310a() + "; type=" + ((int) m312a()) + "; from=" + g() + " ]";
    }
}
