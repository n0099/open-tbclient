package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ee;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class ff {

    /* renamed from: a  reason: collision with other field name */
    private ee.a f356a;

    /* renamed from: a  reason: collision with other field name */
    String f357a;

    /* renamed from: a  reason: collision with other field name */
    private short f358a;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f359b;
    private static String b = go.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f355a = new byte[0];

    public ff() {
        this.f358a = (short) 2;
        this.f359b = f355a;
        this.f357a = null;
        this.f356a = new ee.a();
    }

    ff(ee.a aVar, short s, byte[] bArr) {
        this.f358a = (short) 2;
        this.f359b = f355a;
        this.f357a = null;
        this.f356a = aVar;
        this.f358a = s;
        this.f359b = bArr;
    }

    @Deprecated
    public static ff a(gd gdVar, String str) {
        ff ffVar = new ff();
        int i = 1;
        try {
            i = Integer.parseInt(gdVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m42a("Blob parse chid err " + e.getMessage());
        }
        ffVar.a(i);
        ffVar.a(gdVar.j());
        ffVar.c(gdVar.m());
        ffVar.b(gdVar.n());
        ffVar.a("XMLMSG", (String) null);
        try {
            ffVar.a(gdVar.m300a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                ffVar.a((short) 3);
            } else {
                ffVar.a((short) 2);
                ffVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m42a("Blob setPayload err： " + e2.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m42a("read Blob err :" + e.getMessage());
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
        return this.f356a.c();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m264a() {
        return this.f356a.m227c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo265a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f358a);
        byteBuffer.putShort((short) this.f356a.a());
        byteBuffer.putInt(this.f359b.length);
        int position = byteBuffer.position();
        this.f356a.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f356a.a());
        byteBuffer.position(position + this.f356a.a());
        byteBuffer.put(this.f359b);
        return byteBuffer;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m266a() {
        return this.f358a;
    }

    public void a(int i) {
        this.f356a.a(i);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f356a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f356a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f356a.b(str2);
    }

    public void a(String str) {
        this.f356a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f356a.c(str);
        this.f356a.a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f356a.d(str2);
    }

    public void a(short s) {
        this.f358a = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f356a.c(0);
            this.f359b = bArr;
            return;
        }
        this.f356a.c(1);
        this.f359b = com.xiaomi.push.service.au.a(com.xiaomi.push.service.au.a(str, e()), bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m267a() {
        return this.f356a.j();
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m268a() {
        return this.f359b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m269a(String str) {
        if (this.f356a.e() == 1) {
            return com.xiaomi.push.service.au.a(com.xiaomi.push.service.au.a(str, e()), this.f359b);
        }
        if (this.f356a.e() == 0) {
            return this.f359b;
        }
        com.xiaomi.channel.commonutils.logger.b.m42a("unknow cipher = " + this.f356a.e());
        return this.f359b;
    }

    public int b() {
        return this.f356a.f();
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m270b() {
        return this.f356a.m229d();
    }

    public void b(String str) {
        this.f357a = str;
    }

    public int c() {
        return this.f356a.b() + 8 + this.f359b.length;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m271c() {
        return this.f356a.m233f();
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
            this.f356a.a(parseLong);
            this.f356a.a(substring);
            this.f356a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m42a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        String m231e = this.f356a.m231e();
        if ("ID_NOT_AVAILABLE".equals(m231e)) {
            return null;
        }
        if (this.f356a.g()) {
            return m231e;
        }
        String d = d();
        this.f356a.e(d);
        return d;
    }

    public String f() {
        return this.f357a;
    }

    public String g() {
        if (this.f356a.b()) {
            return Long.toString(this.f356a.a()) + "@" + this.f356a.a() + "/" + this.f356a.b();
        }
        return null;
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m264a() + "; type=" + ((int) m266a()) + "; from=" + g() + " ]";
    }
}
