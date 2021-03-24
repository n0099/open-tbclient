package d.b.g0.a.b0;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f43271a;

    /* renamed from: b  reason: collision with root package name */
    public final long f43272b;

    /* renamed from: c  reason: collision with root package name */
    public final String f43273c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f43274d = new HashMap();

    public b(long j) {
        this.f43272b = TimeUnit.MILLISECONDS.toSeconds(j);
        this.f43271a = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.f43273c = Long.toHexString(a(this.f43271a + "#" + this.f43272b));
        this.f43274d.put("timestamp", Long.toString(this.f43271a));
        this.f43274d.put("delta", Long.toString(this.f43272b));
        this.f43274d.put("rasign", this.f43273c);
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
        return super.toString() + " serverTime:" + this.f43271a + " delta:" + this.f43272b + " rasign:" + this.f43273c;
    }
}
