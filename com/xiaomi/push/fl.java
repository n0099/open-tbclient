package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ek;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class fl {

    /* renamed from: a  reason: collision with other field name */
    private ek.a f341a;

    /* renamed from: a  reason: collision with other field name */
    String f342a;

    /* renamed from: a  reason: collision with other field name */
    private short f343a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f344b;
    private static String b = gu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f340a = new byte[0];

    public fl() {
        this.f343a = (short) 2;
        this.f344b = f340a;
        this.f342a = null;
        this.f341a = new ek.a();
    }

    fl(ek.a aVar, short s, byte[] bArr) {
        this.f343a = (short) 2;
        this.f344b = f340a;
        this.f342a = null;
        this.f341a = aVar;
        this.f343a = s;
        this.f344b = bArr;
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
            long j = a;
            a = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    public int a() {
        return this.f341a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m280a() {
        return this.f341a.m241c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo281a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f343a);
        byteBuffer.putShort((short) this.f341a.a());
        byteBuffer.putInt(this.f344b.length);
        int position = byteBuffer.position();
        this.f341a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f341a.a());
        byteBuffer.position(position + this.f341a.a());
        byteBuffer.put(this.f344b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m282a() {
        return this.f343a;
    }

    public void a(int i) {
        this.f341a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f341a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f341a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f341a.b(str2);
    }

    public void a(String str) {
        this.f341a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f341a.c(str);
        this.f341a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f341a.d(str2);
    }

    public void a(short s) {
        this.f343a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f341a.c(0);
            this.f344b = bArr;
            return;
        }
        this.f341a.c(1);
        this.f344b = com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m283a() {
        return this.f341a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m284a() {
        return this.f344b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m285a(String str) {
        if (this.f341a.e() == 1) {
            return com.xiaomi.push.service.ay.a(com.xiaomi.push.service.ay.a(str, e()), this.f344b);
        }
        if (this.f341a.e() == 0) {
            return this.f344b;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("unknow cipher = " + this.f341a.e());
        return this.f344b;
    }

    public int b() {
        return this.f341a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m286b() {
        return this.f341a.m243d();
    }

    public void b(String str) {
        this.f342a = str;
    }

    public int c() {
        return this.f341a.b() + 8 + this.f344b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m287c() {
        return this.f341a.m247f();
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
            this.f341a.a(parseLong);
            this.f341a.a(substring);
            this.f341a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m245e = this.f341a.m245e();
        if ("ID_NOT_AVAILABLE".equals(m245e)) {
            return null;
        }
        if (this.f341a.g()) {
            return m245e;
        }
        String d = d();
        this.f341a.e(d);
        return d;
    }

    public String f() {
        return this.f342a;
    }

    public String g() {
        if (this.f341a.b()) {
            return Long.toString(this.f341a.a()) + UgcConstant.AT_RULE_TAG + this.f341a.a() + "/" + this.f341a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m280a() + "; type=" + ((int) m282a()) + "; from=" + g() + " ]";
    }
}
