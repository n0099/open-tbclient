package d.a.l0.a.d0;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f44981a;

    /* renamed from: b  reason: collision with root package name */
    public final long f44982b;

    /* renamed from: c  reason: collision with root package name */
    public final String f44983c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f44984d = new HashMap();

    public b(long j) {
        this.f44982b = TimeUnit.MILLISECONDS.toSeconds(j);
        this.f44981a = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.f44983c = Long.toHexString(a(this.f44981a + "#" + this.f44982b));
        this.f44984d.put("timestamp", Long.toString(this.f44981a));
        this.f44984d.put("delta", Long.toString(this.f44982b));
        this.f44984d.put("rasign", this.f44983c);
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
        return super.toString() + " serverTime:" + this.f44981a + " delta:" + this.f44982b + " rasign:" + this.f44983c;
    }
}
