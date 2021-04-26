package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.f;
import java.util.zip.Adler32;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f36983a;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f36984d = new Object();

    public static long a(a aVar) {
        if (aVar != null) {
            String format = String.format("%s%s%s%s%s", aVar.getUtdid(), aVar.getDeviceId(), Long.valueOf(aVar.a()), aVar.getImsi(), aVar.getImei());
            if (f.isEmpty(format)) {
                return 0L;
            }
            Adler32 adler32 = new Adler32();
            adler32.reset();
            adler32.update(format.getBytes());
            return adler32.getValue();
        }
        return 0L;
    }

    public static synchronized a b(Context context) {
        synchronized (b.class) {
            if (f36983a != null) {
                return f36983a;
            } else if (context != null) {
                a a2 = a(context);
                f36983a = a2;
                return a2;
            } else {
                return null;
            }
        }
    }

    public static a a(Context context) {
        if (context != null) {
            synchronized (f36984d) {
                String value = c.a(context).getValue();
                if (f.isEmpty(value)) {
                    return null;
                }
                if (value.endsWith("\n")) {
                    value = value.substring(0, value.length() - 1);
                }
                a aVar = new a();
                long currentTimeMillis = System.currentTimeMillis();
                String imei = com.ta.utdid2.a.a.d.getImei(context);
                String imsi = com.ta.utdid2.a.a.d.getImsi(context);
                aVar.b(imei);
                aVar.setImei(imei);
                aVar.b(currentTimeMillis);
                aVar.setImsi(imsi);
                aVar.c(value);
                aVar.a(a(aVar));
                return aVar;
            }
        }
        return null;
    }
}
