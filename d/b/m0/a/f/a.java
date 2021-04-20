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
    public static boolean f64833a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f64834b;

    /* renamed from: c  reason: collision with root package name */
    public static StringBuffer f64835c = new StringBuffer();

    /* renamed from: d.b.m0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1749a extends c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f64836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64837f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f64838g;

        public C1749a(String str, String str2, String str3) {
            this.f64836e = str;
            this.f64837f = str2;
            this.f64838g = str3;
        }

        @Override // d.b.m0.a.f.c
        public final void a() {
            StringBuffer stringBuffer = new StringBuffer();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            stringBuffer.append(simpleDateFormat.format(new Date()));
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f64836e);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f64837f);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f64838g);
            f.d(stringBuffer.toString(), com.baidu.ubs.analytics.d.a.f22572c, a.f64835c.toString());
        }
    }

    static {
        if (d.b.m0.a.c.i() != null) {
            f64833a = !com.baidu.ubs.analytics.d.a.a();
            f64834b = true;
            f64835c.append("ABsdkLog-");
            f64835c.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            f64835c.append("_");
            try {
                f64835c.append(c(d.b.m0.a.e.i.g(d.b.m0.a.c.i().g()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                i.d(e2);
            } catch (Exception e3) {
                i.d(e3);
            }
            f64835c.append(".log");
        }
    }

    public static void a(String str) {
        if (f64833a) {
            Log.w("BaiDuUbs", str);
        }
        d("w", "BaiDuUbs", str);
    }

    public static void b(String str) {
        if (f64833a) {
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
        if (f64834b) {
            b.a(new C1749a(str, str2, str3));
        }
    }

    public static String e() {
        return f64835c.toString();
    }
}
