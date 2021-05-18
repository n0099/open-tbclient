package d.a.o0.a.f;

import android.util.Log;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64120a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f64121b;

    /* renamed from: c  reason: collision with root package name */
    public static StringBuffer f64122c = new StringBuffer();

    /* renamed from: d.a.o0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1771a extends c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f64123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64124f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f64125g;

        public C1771a(String str, String str2, String str3) {
            this.f64123e = str;
            this.f64124f = str2;
            this.f64125g = str3;
        }

        @Override // d.a.o0.a.f.c
        public final void a() {
            StringBuffer stringBuffer = new StringBuffer();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            stringBuffer.append(simpleDateFormat.format(new Date()));
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f64123e);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f64124f);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f64125g);
            f.d(stringBuffer.toString(), com.baidu.ubs.analytics.d.a.f22527c, a.f64122c.toString());
        }
    }

    static {
        if (d.a.o0.a.c.i() != null) {
            f64120a = !com.baidu.ubs.analytics.d.a.a();
            f64121b = true;
            f64122c.append("ABsdkLog-");
            f64122c.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            f64122c.append("_");
            try {
                f64122c.append(c(d.a.o0.a.e.i.g(d.a.o0.a.c.i().g()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                i.d(e2);
            } catch (Exception e3) {
                i.d(e3);
            }
            f64122c.append(".log");
        }
    }

    public static void a(String str) {
        if (f64120a) {
            Log.w("BaiDuUbs", str);
        }
        d("w", "BaiDuUbs", str);
    }

    public static void b(String str) {
        if (f64120a) {
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
        if (f64121b) {
            b.a(new C1771a(str, str2, str3));
        }
    }

    public static String e() {
        return f64122c.toString();
    }
}
