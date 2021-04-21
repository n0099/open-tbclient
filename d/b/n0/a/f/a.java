package d.b.n0.a.f;

import android.util.Log;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f65101a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f65102b;

    /* renamed from: c  reason: collision with root package name */
    public static StringBuffer f65103c = new StringBuffer();

    /* renamed from: d.b.n0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1768a extends c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f65105f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f65106g;

        public C1768a(String str, String str2, String str3) {
            this.f65104e = str;
            this.f65105f = str2;
            this.f65106g = str3;
        }

        @Override // d.b.n0.a.f.c
        public final void a() {
            StringBuffer stringBuffer = new StringBuffer();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            stringBuffer.append(simpleDateFormat.format(new Date()));
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f65104e);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f65105f);
            stringBuffer.append(TrackUI.SEPERATOR);
            stringBuffer.append(this.f65106g);
            f.d(stringBuffer.toString(), com.baidu.ubs.analytics.d.a.f22580c, a.f65103c.toString());
        }
    }

    static {
        if (d.b.n0.a.c.i() != null) {
            f65101a = !com.baidu.ubs.analytics.d.a.a();
            f65102b = true;
            f65103c.append("ABsdkLog-");
            f65103c.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            f65103c.append("_");
            try {
                f65103c.append(c(d.b.n0.a.e.i.g(d.b.n0.a.c.i().g()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                i.d(e2);
            } catch (Exception e3) {
                i.d(e3);
            }
            f65103c.append(".log");
        }
    }

    public static void a(String str) {
        if (f65101a) {
            Log.w("BaiDuUbs", str);
        }
        d("w", "BaiDuUbs", str);
    }

    public static void b(String str) {
        if (f65101a) {
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
        if (f65102b) {
            b.a(new C1768a(str, str2, str3));
        }
    }

    public static String e() {
        return f65103c.toString();
    }
}
