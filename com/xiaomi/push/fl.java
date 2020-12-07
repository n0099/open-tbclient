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
    private ek.a f340a;

    /* renamed from: a  reason: collision with other field name */
    String f341a;

    /* renamed from: a  reason: collision with other field name */
    private short f342a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f343b;
    private static String b = gu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a  reason: collision with root package name */
    private static long f4675a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f339a = new byte[0];

    public fl() {
        this.f342a = (short) 2;
        this.f343b = f339a;
        this.f341a = null;
        this.f340a = new ek.a();
    }

    fl(ek.a aVar, short s, byte[] bArr) {
        this.f342a = (short) 2;
        this.f343b = f339a;
        this.f341a = null;
        this.f340a = aVar;
        this.f342a = s;
        this.f343b = bArr;
    }

    @Deprecated
    public static fl a(gj gjVar, String str) {
        fl flVar = new fl();
        int i = 1;
        try {
            i = Integer.parseInt(gjVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m47a("Blob parse chid err " + e.getMessage());
        }
        flVar.a(i);
        flVar.a(gjVar.j());
        flVar.c(gjVar.m());
        flVar.b(gjVar.n());
        flVar.a("XMLMSG", (String) null);
        try {
            flVar.a(gjVar.m309a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                flVar.a((short) 3);
            } else {
                flVar.a((short) 2);
                flVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m47a("Blob setPayload err： " + e2.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m47a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String d() {
        String sb;
        synchronized (fl.class) {
            StringBuilder append = new StringBuilder().append(b);
            long j = f4675a;
            f4675a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public int a() {
        return this.f340a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m273a() {
        return this.f340a.m234c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo274a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f342a);
        byteBuffer.putShort((short) this.f340a.a());
        byteBuffer.putInt(this.f343b.length);
        int position = byteBuffer.position();
        this.f340a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f340a.a());
        byteBuffer.position(position + this.f340a.a());
        byteBuffer.put(this.f343b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m275a() {
        return this.f342a;
    }

    public void a(int i) {
        this.f340a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f340a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f340a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f340a.b(str2);
    }

    public void a(String str) {
        this.f340a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f340a.c(str);
        this.f340a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f340a.d(str2);
    }

    public void a(short s) {
        this.f342a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f340a.c(0);
            this.f343b = bArr;
            return;
        }
        this.f340a.c(1);
        this.f343b = com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m276a() {
        return this.f340a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m277a() {
        return this.f343b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m278a(String str) {
        if (this.f340a.e() == 1) {
            return com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), this.f343b);
        }
        if (this.f340a.e() == 0) {
            return this.f343b;
        }
        com.xiaomi.channel.commonutils.logger.b.m47a("unknow cipher = " + this.f340a.e());
        return this.f343b;
    }

    public int b() {
        return this.f340a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m279b() {
        return this.f340a.m236d();
    }

    public void b(String str) {
        this.f341a = str;
    }

    public int c() {
        return this.f340a.b() + 8 + this.f343b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m280c() {
        return this.f340a.m240f();
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
            this.f340a.a(parseLong);
            this.f340a.a(substring);
            this.f340a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m47a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m238e = this.f340a.m238e();
        if ("ID_NOT_AVAILABLE".equals(m238e)) {
            return null;
        }
        if (this.f340a.g()) {
            return m238e;
        }
        String d = d();
        this.f340a.e(d);
        return d;
    }

    public String f() {
        return this.f341a;
    }

    public String g() {
        if (this.f340a.b()) {
            return Long.toString(this.f340a.a()) + UgcConstant.AT_RULE_TAG + this.f340a.a() + "/" + this.f340a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m273a() + "; type=" + ((int) m275a()) + "; from=" + g() + " ]";
    }
}
