package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ee;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class ff {

    /* renamed from: a  reason: collision with other field name */
    private ee.a f353a;

    /* renamed from: a  reason: collision with other field name */
    String f354a;

    /* renamed from: a  reason: collision with other field name */
    private short f355a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f356b;
    private static String b = go.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f352a = new byte[0];

    public ff() {
        this.f355a = (short) 2;
        this.f356b = f352a;
        this.f354a = null;
        this.f353a = new ee.a();
    }

    ff(ee.a aVar, short s, byte[] bArr) {
        this.f355a = (short) 2;
        this.f356b = f352a;
        this.f354a = null;
        this.f353a = aVar;
        this.f355a = s;
        this.f356b = bArr;
    }

    @Deprecated
    public static ff a(gd gdVar, String str) {
        ff ffVar = new ff();
        int i = 1;
        try {
            i = Integer.parseInt(gdVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m47a("Blob parse chid err " + e.getMessage());
        }
        ffVar.a(i);
        ffVar.a(gdVar.j());
        ffVar.c(gdVar.m());
        ffVar.b(gdVar.n());
        ffVar.a("XMLMSG", (String) null);
        try {
            ffVar.a(gdVar.m305a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                ffVar.a((short) 3);
            } else {
                ffVar.a((short) 2);
                ffVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m47a("Blob setPayload err： " + e2.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m47a("read Blob err :" + e.getMessage());
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
        return this.f353a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m269a() {
        return this.f353a.m232c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo270a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f355a);
        byteBuffer.putShort((short) this.f353a.a());
        byteBuffer.putInt(this.f356b.length);
        int position = byteBuffer.position();
        this.f353a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f353a.a());
        byteBuffer.position(position + this.f353a.a());
        byteBuffer.put(this.f356b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m271a() {
        return this.f355a;
    }

    public void a(int i) {
        this.f353a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f353a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f353a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f353a.b(str2);
    }

    public void a(String str) {
        this.f353a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f353a.c(str);
        this.f353a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f353a.d(str2);
    }

    public void a(short s) {
        this.f355a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f353a.c(0);
            this.f356b = bArr;
            return;
        }
        this.f353a.c(1);
        this.f356b = com.xiaomi.push.service.au.a(com.xiaomi.push.service.au.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m272a() {
        return this.f353a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m273a() {
        return this.f356b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m274a(String str) {
        if (this.f353a.e() == 1) {
            return com.xiaomi.push.service.au.a(com.xiaomi.push.service.au.a(str, e()), this.f356b);
        }
        if (this.f353a.e() == 0) {
            return this.f356b;
        }
        com.xiaomi.channel.commonutils.logger.b.m47a("unknow cipher = " + this.f353a.e());
        return this.f356b;
    }

    public int b() {
        return this.f353a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m275b() {
        return this.f353a.m234d();
    }

    public void b(String str) {
        this.f354a = str;
    }

    public int c() {
        return this.f353a.b() + 8 + this.f356b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m276c() {
        return this.f353a.m238f();
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
            this.f353a.a(parseLong);
            this.f353a.a(substring);
            this.f353a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m47a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m236e = this.f353a.m236e();
        if ("ID_NOT_AVAILABLE".equals(m236e)) {
            return null;
        }
        if (this.f353a.g()) {
            return m236e;
        }
        String d = d();
        this.f353a.e(d);
        return d;
    }

    public String f() {
        return this.f354a;
    }

    public String g() {
        if (this.f353a.b()) {
            return Long.toString(this.f353a.a()) + "@" + this.f353a.a() + "/" + this.f353a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m269a() + "; type=" + ((int) m271a()) + "; from=" + g() + " ]";
    }
}
