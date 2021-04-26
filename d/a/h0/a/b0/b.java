package d.a.h0.a.b0;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f41263a;

    /* renamed from: b  reason: collision with root package name */
    public final long f41264b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41265c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f41266d = new HashMap();

    public b(long j) {
        this.f41264b = TimeUnit.MILLISECONDS.toSeconds(j);
        this.f41263a = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - j);
        this.f41265c = Long.toHexString(a(this.f41263a + "#" + this.f41264b));
        this.f41266d.put("timestamp", Long.toString(this.f41263a));
        this.f41266d.put("delta", Long.toString(this.f41264b));
        this.f41266d.put("rasign", this.f41265c);
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
        return super.toString() + " serverTime:" + this.f41263a + " delta:" + this.f41264b + " rasign:" + this.f41265c;
    }
}
