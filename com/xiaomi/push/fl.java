package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ek;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes18.dex */
public class fl {

    /* renamed from: a  reason: collision with other field name */
    private ek.a f342a;

    /* renamed from: a  reason: collision with other field name */
    String f343a;

    /* renamed from: a  reason: collision with other field name */
    private short f344a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f345b;
    private static String b = gu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a  reason: collision with root package name */
    private static long f4905a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f341a = new byte[0];

    public fl() {
        this.f344a = (short) 2;
        this.f345b = f341a;
        this.f343a = null;
        this.f342a = new ek.a();
    }

    fl(ek.a aVar, short s, byte[] bArr) {
        this.f344a = (short) 2;
        this.f345b = f341a;
        this.f343a = null;
        this.f342a = aVar;
        this.f344a = s;
        this.f345b = bArr;
    }

    @Deprecated
    public static fl a(gj gjVar, String str) {
        fl flVar = new fl();
        int i = 1;
        try {
            i = Integer.parseInt(gjVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Blob parse chid err " + e.getMessage());
        }
        flVar.a(i);
        flVar.a(gjVar.j());
        flVar.c(gjVar.m());
        flVar.b(gjVar.n());
        flVar.a("XMLMSG", (String) null);
        try {
            flVar.a(gjVar.m319a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                flVar.a((short) 3);
            } else {
                flVar.a((short) 2);
                flVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Blob setPayload err： " + e2.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m57a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (fl.class) {
            StringBuilder append = new StringBuilder().append(b);
            long j = f4905a;
            f4905a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public int a() {
        return this.f342a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m283a() {
        return this.f342a.m244c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo284a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f344a);
        byteBuffer.putShort((short) this.f342a.a());
        byteBuffer.putInt(this.f345b.length);
        int position = byteBuffer.position();
        this.f342a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f342a.a());
        byteBuffer.position(position + this.f342a.a());
        byteBuffer.put(this.f345b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m285a() {
        return this.f344a;
    }

    public void a(int i) {
        this.f342a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f342a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f342a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f342a.b(str2);
    }

    public void a(String str) {
        this.f342a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f342a.c(str);
        this.f342a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f342a.d(str2);
    }

    public void a(short s) {
        this.f344a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f342a.c(0);
            this.f345b = bArr;
            return;
        }
        this.f342a.c(1);
        this.f345b = com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m286a() {
        return this.f342a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m287a() {
        return this.f345b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m288a(String str) {
        if (this.f342a.e() == 1) {
            return com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), this.f345b);
        }
        if (this.f342a.e() == 0) {
            return this.f345b;
        }
        com.xiaomi.channel.commonutils.logger.b.m57a("unknow cipher = " + this.f342a.e());
        return this.f345b;
    }

    public int b() {
        return this.f342a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m289b() {
        return this.f342a.m246d();
    }

    public void b(String str) {
        this.f343a = str;
    }

    public int c() {
        return this.f342a.b() + 8 + this.f345b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m290c() {
        return this.f342a.m250f();
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
            this.f342a.a(parseLong);
            this.f342a.a(substring);
            this.f342a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m248e = this.f342a.m248e();
        if ("ID_NOT_AVAILABLE".equals(m248e)) {
            return null;
        }
        if (this.f342a.g()) {
            return m248e;
        }
        String d = d();
        this.f342a.e(d);
        return d;
    }

    public String f() {
        return this.f343a;
    }

    public String g() {
        if (this.f342a.b()) {
            return Long.toString(this.f342a.a()) + UgcConstant.AT_RULE_TAG + this.f342a.a() + "/" + this.f342a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m283a() + "; type=" + ((int) m285a()) + "; from=" + g() + " ]";
    }
}
