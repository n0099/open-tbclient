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
    public static boolean f64105a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f64106b;

    /* renamed from: c  reason: collision with root package name */
    public static StringBuffer f64107c = new StringBuffer();

    /* renamed from: d.b.m0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1737a extends c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f64108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64109f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f64110g;

        public C1737a(String str, String str2, String str3) {
            this.f64108e = str;
            this.f64109f = str2;
            this.f64110g = str3;
        }

        @Override // d.b.m0.a.f.c
        public final void a() {
            StringBuffer stringBuffer = new StringBuffer();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            stringBuffer.append(simpleDateFormat.format(new Date()));
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f64108e);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f64109f);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f64110g);
            f.d(stringBuffer.toString(), com.baidu.ubs.analytics.d.a.f22887c, a.f64107c.toString());
        }
    }

    static {
        if (d.b.m0.a.c.i() != null) {
            f64105a = !com.baidu.ubs.analytics.d.a.a();
            f64106b = true;
            f64107c.append("ABsdkLog-");
            f64107c.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            f64107c.append("_");
            try {
                f64107c.append(c(d.b.m0.a.e.i.g(d.b.m0.a.c.i().g()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                i.d(e2);
            } catch (Exception e3) {
                i.d(e3);
            }
            f64107c.append(".log");
        }
    }

    public static void a(String str) {
        if (f64105a) {
            Log.w("BaiDuUbs", str);
        }
        d("w", "BaiDuUbs", str);
    }

    public static void b(String str) {
        if (f64105a) {
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
        if (f64106b) {
            b.a(new C1737a(str, str2, str3));
        }
    }

    public static String e() {
        return f64107c.toString();
    }
}
