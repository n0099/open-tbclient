package d.a.s0.a.f;

import android.util.Log;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f68281a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f68282b;

    /* renamed from: c  reason: collision with root package name */
    public static StringBuffer f68283c = new StringBuffer();

    /* renamed from: d.a.s0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1865a extends c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f68284e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68285f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f68286g;

        public C1865a(String str, String str2, String str3) {
            this.f68284e = str;
            this.f68285f = str2;
            this.f68286g = str3;
        }

        @Override // d.a.s0.a.f.c
        public final void a() {
            StringBuffer stringBuffer = new StringBuffer();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            stringBuffer.append(simpleDateFormat.format(new Date()));
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f68284e);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f68285f);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f68286g);
            f.d(stringBuffer.toString(), com.baidu.ubs.analytics.d.a.f22641c, a.f68283c.toString());
        }
    }

    static {
        if (d.a.s0.a.c.i() != null) {
            f68281a = !com.baidu.ubs.analytics.d.a.a();
            f68282b = true;
            f68283c.append("ABsdkLog-");
            f68283c.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            f68283c.append("_");
            try {
                f68283c.append(c(d.a.s0.a.e.i.g(d.a.s0.a.c.i().g()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                i.d(e2);
            } catch (Exception e3) {
                i.d(e3);
            }
            f68283c.append(".log");
        }
    }

    public static void a(String str) {
        if (f68281a) {
            Log.w("BaiDuUbs", str);
        }
        d("w", "BaiDuUbs", str);
    }

    public static void b(String str) {
        if (f68281a) {
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
        if (f68282b) {
            b.a(new C1865a(str, str2, str3));
        }
    }

    public static String e() {
        return f68283c.toString();
    }
}
