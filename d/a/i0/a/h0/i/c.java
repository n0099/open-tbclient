package d.a.i0.a.h0.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.i0.a.v2.k;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f41988a = String.format("框架加载后%s秒无内容绘制；", 3);

    /* renamed from: b  reason: collision with root package name */
    public static final String f41989b = "检测到白屏区域超过" + a(0.7d) + "；";

    /* renamed from: c  reason: collision with root package name */
    public static final String f41990c = "检测到白屏区域超过" + a(0.5d) + "且正在loading；";

    public static String a(double d2) {
        return ((int) (d2 * 100.0d)) + "%";
    }

    public static String b(String str, g gVar) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(gVar.b());
        int f2 = gVar.f();
        if (f2 == 0) {
            sb.append("业务请求：无异常；");
        } else if (f2 == 4) {
            sb.append("业务请求：失败率超");
            sb.append(a(0.5d));
            sb.append("；");
        } else if (f2 != 8) {
            sb.append("业务请求：未知；");
        } else {
            sb.append("业务请求：响应缓慢；");
        }
        int i2 = gVar.f41998b;
        if (i2 > 0) {
            sb.append(String.format("共发起请求%s个，失败%s个，缓慢%s个；", Integer.valueOf(i2), Integer.valueOf(gVar.f41999c.size()), Integer.valueOf(gVar.f42000d.size())));
        }
        int d2 = gVar.d();
        if (d2 == 0) {
            sb.append("网络：正常；");
        } else if (d2 == 1) {
            sb.append("网络：弱网；");
        } else if (d2 != 2) {
            sb.append("网络：未知；");
        } else {
            sb.append("网络：离线；");
        }
        String g2 = k.g(System.currentTimeMillis(), "【HH:mm:ss】");
        for (Map.Entry<String, Integer> entry : gVar.f42000d.entrySet()) {
            try {
                sb.append(String.format("\n%s请求%s耗时较长：%s ms", g2, new URL(entry.getKey()).getPath(), entry.getValue()));
            } catch (MalformedURLException e2) {
                if (d.a.i0.a.k.f43025a) {
                    e2.printStackTrace();
                }
            }
        }
        for (String str2 : gVar.f41999c) {
            try {
                sb.append(String.format("\n%s请求%s请求失败；", g2, new URL(str2).getPath()));
            } catch (MalformedURLException e3) {
                if (d.a.i0.a.k.f43025a) {
                    e3.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static String c(String str, @NonNull g gVar, long j, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append(String.format(Locale.getDefault(), "%d秒截屏; ", Long.valueOf(j / 1000)));
        sb.append(z ? "框架预加载：已完成; " : "框架预加载：未完成; ");
        return b(sb.toString(), gVar);
    }
}
