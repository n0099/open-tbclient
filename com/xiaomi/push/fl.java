package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ek;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class fl {

    /* renamed from: a  reason: collision with other field name */
    private ek.a f338a;

    /* renamed from: a  reason: collision with other field name */
    String f339a;

    /* renamed from: a  reason: collision with other field name */
    private short f340a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f341b;
    private static String b = gu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f337a = new byte[0];

    public fl() {
        this.f340a = (short) 2;
        this.f341b = f337a;
        this.f339a = null;
        this.f338a = new ek.a();
    }

    fl(ek.a aVar, short s, byte[] bArr) {
        this.f340a = (short) 2;
        this.f341b = f337a;
        this.f339a = null;
        this.f338a = aVar;
        this.f340a = s;
        this.f341b = bArr;
    }

    @Deprecated
    public static fl a(gj gjVar, String str) {
        fl flVar = new fl();
        int i = 1;
        try {
            i = Integer.parseInt(gjVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m52a("Blob parse chid err " + e.getMessage());
        }
        flVar.a(i);
        flVar.a(gjVar.j());
        flVar.c(gjVar.m());
        flVar.b(gjVar.n());
        flVar.a("XMLMSG", (String) null);
        try {
            flVar.a(gjVar.m314a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                flVar.a((short) 3);
            } else {
                flVar.a((short) 2);
                flVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m52a("Blob setPayload err： " + e2.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m52a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (fl.class) {
            StringBuilder append = new StringBuilder().append(b);
            long j = a;
            a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public int a() {
        return this.f338a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m278a() {
        return this.f338a.m239c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo279a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f340a);
        byteBuffer.putShort((short) this.f338a.a());
        byteBuffer.putInt(this.f341b.length);
        int position = byteBuffer.position();
        this.f338a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f338a.a());
        byteBuffer.position(position + this.f338a.a());
        byteBuffer.put(this.f341b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m280a() {
        return this.f340a;
    }

    public void a(int i) {
        this.f338a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f338a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f338a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f338a.b(str2);
    }

    public void a(String str) {
        this.f338a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f338a.c(str);
        this.f338a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f338a.d(str2);
    }

    public void a(short s) {
        this.f340a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f338a.c(0);
            this.f341b = bArr;
            return;
        }
        this.f338a.c(1);
        this.f341b = com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m281a() {
        return this.f338a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m282a() {
        return this.f341b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m283a(String str) {
        if (this.f338a.e() == 1) {
            return com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), this.f341b);
        }
        if (this.f338a.e() == 0) {
            return this.f341b;
        }
        com.xiaomi.channel.commonutils.logger.b.m52a("unknow cipher = " + this.f338a.e());
        return this.f341b;
    }

    public int b() {
        return this.f338a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m284b() {
        return this.f338a.m241d();
    }

    public void b(String str) {
        this.f339a = str;
    }

    public int c() {
        return this.f338a.b() + 8 + this.f341b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m285c() {
        return this.f338a.m245f();
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
            this.f338a.a(parseLong);
            this.f338a.a(substring);
            this.f338a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m52a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m243e = this.f338a.m243e();
        if ("ID_NOT_AVAILABLE".equals(m243e)) {
            return null;
        }
        if (this.f338a.g()) {
            return m243e;
        }
        String d = d();
        this.f338a.e(d);
        return d;
    }

    public String f() {
        return this.f339a;
    }

    public String g() {
        if (this.f338a.b()) {
            return Long.toString(this.f338a.a()) + UgcConstant.AT_RULE_TAG + this.f338a.a() + "/" + this.f338a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m278a() + "; type=" + ((int) m280a()) + "; from=" + g() + " ]";
    }
}
