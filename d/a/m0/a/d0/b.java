package d.a.m0.a.d0;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f45089a;

    /* renamed from: b  reason: collision with root package name */
    public final long f45090b;

    /* renamed from: c  reason: collision with root package name */
    public final String f45091c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f45092d = new HashMap();

    public b(long j) {
        this.f45090b = TimeUnit.MILLISECONDS.toSeconds(j);
        this.f45089a = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.f45091c = Long.toHexString(a(this.f45089a + "#" + this.f45090b));
        this.f45092d.put("timestamp", Long.toString(this.f45089a));
        this.f45092d.put("delta", Long.toString(this.f45090b));
        this.f45092d.put("rasign", this.f45091c);
    }

    public static b b() {
        return new b(0L);
    }

    public final long a(String str) {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public String c(long j) {
        return Long.toHexString(a(j + "#smartapp_formid"));
    }

    public String d(long j) {
        return Long.toHexString(a(j + "#payid"));
    }

    public String toString() {
        return super.toString() + " serverTime:" + this.f45089a + " delta:" + this.f45090b + " rasign:" + this.f45091c;
    }
}
