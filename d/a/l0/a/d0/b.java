package d.a.l0.a.d0;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f41305a;

    /* renamed from: b  reason: collision with root package name */
    public final long f41306b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41307c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f41308d = new HashMap();

    public b(long j) {
        this.f41306b = TimeUnit.MILLISECONDS.toSeconds(j);
        this.f41305a = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.f41307c = Long.toHexString(a(this.f41305a + "#" + this.f41306b));
        this.f41308d.put("timestamp", Long.toString(this.f41305a));
        this.f41308d.put("delta", Long.toString(this.f41306b));
        this.f41308d.put("rasign", this.f41307c);
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
        return super.toString() + " serverTime:" + this.f41305a + " delta:" + this.f41306b + " rasign:" + this.f41307c;
    }
}
