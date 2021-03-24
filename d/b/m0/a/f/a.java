package d.b.m0.a.f;

import android.util.Log;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64104a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f64105b;

    /* renamed from: c  reason: collision with root package name */
    public static StringBuffer f64106c = new StringBuffer();

    /* renamed from: d.b.m0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1736a extends c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f64107e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64108f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f64109g;

        public C1736a(String str, String str2, String str3) {
            this.f64107e = str;
            this.f64108f = str2;
            this.f64109g = str3;
        }

        @Override // d.b.m0.a.f.c
        public final void a() {
            StringBuffer stringBuffer = new StringBuffer();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            stringBuffer.append(simpleDateFormat.format(new Date()));
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f64107e);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f64108f);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f64109g);
            f.d(stringBuffer.toString(), com.baidu.ubs.analytics.d.a.f22886c, a.f64106c.toString());
        }
    }

    static {
        if (d.b.m0.a.c.i() != null) {
            f64104a = !com.baidu.ubs.analytics.d.a.a();
            f64105b = true;
            f64106c.append("ABsdkLog-");
            f64106c.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            f64106c.append("_");
            try {
                f64106c.append(c(d.b.m0.a.e.i.g(d.b.m0.a.c.i().g()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                i.d(e2);
            } catch (Exception e3) {
                i.d(e3);
            }
            f64106c.append(".log");
        }
    }

    public static void a(String str) {
        if (f64104a) {
            Log.w("BaiDuUbs", str);
        }
        d("w", "BaiDuUbs", str);
    }

    public static void b(String str) {
        if (f64104a) {
            Log.e("BaiDuUbs", str);
        }
        d("e", "BaiDuUbs", str);
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void d(String str, String str2, String str3) {
        if (f64105b) {
            b.a(new C1736a(str, str2, str3));
        }
    }

    public static String e() {
        return f64106c.toString();
    }
}
