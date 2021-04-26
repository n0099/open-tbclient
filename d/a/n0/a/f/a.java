package d.a.n0.a.f;

import android.util.Log;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f63412a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f63413b;

    /* renamed from: c  reason: collision with root package name */
    public static StringBuffer f63414c = new StringBuffer();

    /* renamed from: d.a.n0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1706a extends c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f63415e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63416f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f63417g;

        public C1706a(String str, String str2, String str3) {
            this.f63415e = str;
            this.f63416f = str2;
            this.f63417g = str3;
        }

        @Override // d.a.n0.a.f.c
        public final void a() {
            StringBuffer stringBuffer = new StringBuffer();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            stringBuffer.append(simpleDateFormat.format(new Date()));
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f63415e);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f63416f);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f63417g);
            f.d(stringBuffer.toString(), com.baidu.ubs.analytics.d.a.f23282c, a.f63414c.toString());
        }
    }

    static {
        if (d.a.n0.a.c.i() != null) {
            f63412a = !com.baidu.ubs.analytics.d.a.a();
            f63413b = true;
            f63414c.append("ABsdkLog-");
            f63414c.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            f63414c.append("_");
            try {
                f63414c.append(c(d.a.n0.a.e.i.g(d.a.n0.a.c.i().g()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                i.d(e2);
            } catch (Exception e3) {
                i.d(e3);
            }
            f63414c.append(".log");
        }
    }

    public static void a(String str) {
        if (f63412a) {
            Log.w("BaiDuUbs", str);
        }
        d("w", "BaiDuUbs", str);
    }

    public static void b(String str) {
        if (f63412a) {
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
        if (f63413b) {
            b.a(new C1706a(str, str2, str3));
        }
    }

    public static String e() {
        return f63414c.toString();
    }
}
