package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ek;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes12.dex */
public class fl {

    /* renamed from: a  reason: collision with other field name */
    private ek.a f337a;

    /* renamed from: a  reason: collision with other field name */
    String f338a;

    /* renamed from: a  reason: collision with other field name */
    private short f339a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f340b;
    private static String b = gu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a  reason: collision with root package name */
    private static long f4903a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f336a = new byte[0];

    public fl() {
        this.f339a = (short) 2;
        this.f340b = f336a;
        this.f338a = null;
        this.f337a = new ek.a();
    }

    fl(ek.a aVar, short s, byte[] bArr) {
        this.f339a = (short) 2;
        this.f340b = f336a;
        this.f338a = null;
        this.f337a = aVar;
        this.f339a = s;
        this.f340b = bArr;
    }

    @Deprecated
    public static fl a(gj gjVar, String str) {
        fl flVar = new fl();
        int i = 1;
        try {
            i = Integer.parseInt(gjVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Blob parse chid err " + e.getMessage());
        }
        flVar.a(i);
        flVar.a(gjVar.j());
        flVar.c(gjVar.m());
        flVar.b(gjVar.n());
        flVar.a("XMLMSG", (String) null);
        try {
            flVar.a(gjVar.m316a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                flVar.a((short) 3);
            } else {
                flVar.a((short) 2);
                flVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Blob setPayload err： " + e2.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m54a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (fl.class) {
            StringBuilder append = new StringBuilder().append(b);
            long j = f4903a;
            f4903a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public int a() {
        return this.f337a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m280a() {
        return this.f337a.m241c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo281a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f339a);
        byteBuffer.putShort((short) this.f337a.a());
        byteBuffer.putInt(this.f340b.length);
        int position = byteBuffer.position();
        this.f337a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f337a.a());
        byteBuffer.position(position + this.f337a.a());
        byteBuffer.put(this.f340b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m282a() {
        return this.f339a;
    }

    public void a(int i) {
        this.f337a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f337a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f337a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f337a.b(str2);
    }

    public void a(String str) {
        this.f337a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f337a.c(str);
        this.f337a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f337a.d(str2);
    }

    public void a(short s) {
        this.f339a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f337a.c(0);
            this.f340b = bArr;
            return;
        }
        this.f337a.c(1);
        this.f340b = com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m283a() {
        return this.f337a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m284a() {
        return this.f340b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m285a(String str) {
        if (this.f337a.e() == 1) {
            return com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), this.f340b);
        }
        if (this.f337a.e() == 0) {
            return this.f340b;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("unknow cipher = " + this.f337a.e());
        return this.f340b;
    }

    public int b() {
        return this.f337a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m286b() {
        return this.f337a.m243d();
    }

    public void b(String str) {
        this.f338a = str;
    }

    public int c() {
        return this.f337a.b() + 8 + this.f340b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m287c() {
        return this.f337a.m247f();
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf(UgcConstant.AT_RULE_TAG);
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f337a.a(parseLong);
            this.f337a.a(substring);
            this.f337a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m245e = this.f337a.m245e();
        if ("ID_NOT_AVAILABLE".equals(m245e)) {
            return null;
        }
        if (this.f337a.g()) {
            return m245e;
        }
        String d = d();
        this.f337a.e(d);
        return d;
    }

    public String f() {
        return this.f338a;
    }

    public String g() {
        if (this.f337a.b()) {
            return Long.toString(this.f337a.a()) + UgcConstant.AT_RULE_TAG + this.f337a.a() + "/" + this.f337a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m280a() + "; type=" + ((int) m282a()) + "; from=" + g() + " ]";
    }
}
