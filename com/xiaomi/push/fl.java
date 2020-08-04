package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ek;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class fl {

    /* renamed from: a  reason: collision with other field name */
    private ek.a f344a;

    /* renamed from: a  reason: collision with other field name */
    String f345a;

    /* renamed from: a  reason: collision with other field name */
    private short f346a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f347b;
    private static String b = gu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f343a = new byte[0];

    public fl() {
        this.f346a = (short) 2;
        this.f347b = f343a;
        this.f345a = null;
        this.f344a = new ek.a();
    }

    fl(ek.a aVar, short s, byte[] bArr) {
        this.f346a = (short) 2;
        this.f347b = f343a;
        this.f345a = null;
        this.f344a = aVar;
        this.f346a = s;
        this.f347b = bArr;
    }

    @Deprecated
    public static fl a(gj gjVar, String str) {
        fl flVar = new fl();
        int i = 1;
        try {
            i = Integer.parseInt(gjVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m49a("Blob parse chid err " + e.getMessage());
        }
        flVar.a(i);
        flVar.a(gjVar.j());
        flVar.c(gjVar.m());
        flVar.b(gjVar.n());
        flVar.a("XMLMSG", (String) null);
        try {
            flVar.a(gjVar.m311a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                flVar.a((short) 3);
            } else {
                flVar.a((short) 2);
                flVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m49a("Blob setPayload err： " + e2.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m49a("read Blob err :" + e.getMessage());
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
        return this.f344a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m275a() {
        return this.f344a.m236c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo276a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f346a);
        byteBuffer.putShort((short) this.f344a.a());
        byteBuffer.putInt(this.f347b.length);
        int position = byteBuffer.position();
        this.f344a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f344a.a());
        byteBuffer.position(position + this.f344a.a());
        byteBuffer.put(this.f347b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m277a() {
        return this.f346a;
    }

    public void a(int i) {
        this.f344a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f344a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f344a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f344a.b(str2);
    }

    public void a(String str) {
        this.f344a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f344a.c(str);
        this.f344a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f344a.d(str2);
    }

    public void a(short s) {
        this.f346a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f344a.c(0);
            this.f347b = bArr;
            return;
        }
        this.f344a.c(1);
        this.f347b = com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m278a() {
        return this.f344a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m279a() {
        return this.f347b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m280a(String str) {
        if (this.f344a.e() == 1) {
            return com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), this.f347b);
        }
        if (this.f344a.e() == 0) {
            return this.f347b;
        }
        com.xiaomi.channel.commonutils.logger.b.m49a("unknow cipher = " + this.f344a.e());
        return this.f347b;
    }

    public int b() {
        return this.f344a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m281b() {
        return this.f344a.m238d();
    }

    public void b(String str) {
        this.f345a = str;
    }

    public int c() {
        return this.f344a.b() + 8 + this.f347b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m282c() {
        return this.f344a.m242f();
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
            this.f344a.a(parseLong);
            this.f344a.a(substring);
            this.f344a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m49a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m240e = this.f344a.m240e();
        if ("ID_NOT_AVAILABLE".equals(m240e)) {
            return null;
        }
        if (this.f344a.g()) {
            return m240e;
        }
        String d = d();
        this.f344a.e(d);
        return d;
    }

    public String f() {
        return this.f345a;
    }

    public String g() {
        if (this.f344a.b()) {
            return Long.toString(this.f344a.a()) + UgcConstant.AT_RULE_TAG + this.f344a.a() + "/" + this.f344a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m275a() + "; type=" + ((int) m277a()) + "; from=" + g() + " ]";
    }
}
