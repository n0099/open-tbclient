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
    private ek.a f418a;

    /* renamed from: a  reason: collision with other field name */
    String f419a;

    /* renamed from: a  reason: collision with other field name */
    private short f420a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f421b;

    /* renamed from: b  reason: collision with root package name */
    private static String f14318b = gu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a  reason: collision with root package name */
    private static long f14317a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f417a = new byte[0];

    public fl() {
        this.f420a = (short) 2;
        this.f421b = f417a;
        this.f419a = null;
        this.f418a = new ek.a();
    }

    fl(ek.a aVar, short s, byte[] bArr) {
        this.f420a = (short) 2;
        this.f421b = f417a;
        this.f419a = null;
        this.f418a = aVar;
        this.f420a = s;
        this.f421b = bArr;
    }

    @Deprecated
    public static fl a(gj gjVar, String str) {
        fl flVar = new fl();
        int i = 1;
        try {
            i = Integer.parseInt(gjVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Blob parse chid err " + e.getMessage());
        }
        flVar.a(i);
        flVar.a(gjVar.j());
        flVar.c(gjVar.m());
        flVar.b(gjVar.n());
        flVar.a("XMLMSG", (String) null);
        try {
            flVar.a(gjVar.m335a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                flVar.a((short) 3);
            } else {
                flVar.a((short) 2);
                flVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Blob setPayload err： " + e2.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m73a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (fl.class) {
            StringBuilder append = new StringBuilder().append(f14318b);
            long j = f14317a;
            f14317a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public int a() {
        return this.f418a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m299a() {
        return this.f418a.m260c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo300a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f420a);
        byteBuffer.putShort((short) this.f418a.a());
        byteBuffer.putInt(this.f421b.length);
        int position = byteBuffer.position();
        this.f418a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f418a.a());
        byteBuffer.position(position + this.f418a.a());
        byteBuffer.put(this.f421b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m301a() {
        return this.f420a;
    }

    public void a(int i) {
        this.f418a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f418a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f418a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f418a.b(str2);
    }

    public void a(String str) {
        this.f418a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f418a.c(str);
        this.f418a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f418a.d(str2);
    }

    public void a(short s) {
        this.f420a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f418a.c(0);
            this.f421b = bArr;
            return;
        }
        this.f418a.c(1);
        this.f421b = com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m302a() {
        return this.f418a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m303a() {
        return this.f421b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m304a(String str) {
        if (this.f418a.e() == 1) {
            return com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), this.f421b);
        }
        if (this.f418a.e() == 0) {
            return this.f421b;
        }
        com.xiaomi.channel.commonutils.logger.b.m73a("unknow cipher = " + this.f418a.e());
        return this.f421b;
    }

    public int b() {
        return this.f418a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m305b() {
        return this.f418a.m262d();
    }

    public void b(String str) {
        this.f419a = str;
    }

    public int c() {
        return this.f418a.b() + 8 + this.f421b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m306c() {
        return this.f418a.m266f();
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
            this.f418a.a(parseLong);
            this.f418a.a(substring);
            this.f418a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m264e = this.f418a.m264e();
        if ("ID_NOT_AVAILABLE".equals(m264e)) {
            return null;
        }
        if (this.f418a.g()) {
            return m264e;
        }
        String d = d();
        this.f418a.e(d);
        return d;
    }

    public String f() {
        return this.f419a;
    }

    public String g() {
        if (this.f418a.b()) {
            return Long.toString(this.f418a.a()) + "@" + this.f418a.a() + "/" + this.f418a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m299a() + "; type=" + ((int) m301a()) + "; from=" + g() + " ]";
    }
}
