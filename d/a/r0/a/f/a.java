package d.a.r0.a.f;

import android.util.Log;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f68165a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f68166b;

    /* renamed from: c  reason: collision with root package name */
    public static StringBuffer f68167c = new StringBuffer();

    /* renamed from: d.a.r0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1861a extends c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f68168e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68169f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f68170g;

        public C1861a(String str, String str2, String str3) {
            this.f68168e = str;
            this.f68169f = str2;
            this.f68170g = str3;
        }

        @Override // d.a.r0.a.f.c
        public final void a() {
            StringBuffer stringBuffer = new StringBuffer();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            stringBuffer.append(simpleDateFormat.format(new Date()));
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f68168e);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f68169f);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f68170g);
            f.d(stringBuffer.toString(), com.baidu.ubs.analytics.d.a.f22559c, a.f68167c.toString());
        }
    }

    static {
        if (d.a.r0.a.c.i() != null) {
            f68165a = !com.baidu.ubs.analytics.d.a.a();
            f68166b = true;
            f68167c.append("ABsdkLog-");
            f68167c.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            f68167c.append("_");
            try {
                f68167c.append(c(d.a.r0.a.e.i.g(d.a.r0.a.c.i().g()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                i.d(e2);
            } catch (Exception e3) {
                i.d(e3);
            }
            f68167c.append(".log");
        }
    }

    public static void a(String str) {
        if (f68165a) {
            Log.w("BaiDuUbs", str);
        }
        d("w", "BaiDuUbs", str);
    }

    public static void b(String str) {
        if (f68165a) {
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
        if (f68166b) {
            b.a(new C1861a(str, str2, str3));
        }
    }

    public static String e() {
        return f68167c.toString();
    }
}
