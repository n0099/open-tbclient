package d.a.l.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public String f63145a;

    /* renamed from: b  reason: collision with root package name */
    public String f63146b;

    public h() {
        d();
    }

    public String a() {
        return this.f63146b;
    }

    public final String b(Context context) {
        int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
        int displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(context);
        int densityDpi = DeviceUtil.ScreenInfo.getDensityDpi(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append("_");
        stringBuffer.append(displayHeight);
        stringBuffer.append("_");
        stringBuffer.append("android");
        stringBuffer.append("_");
        stringBuffer.append(this.f63145a);
        stringBuffer.append("_");
        stringBuffer.append(densityDpi);
        return stringBuffer.toString();
    }

    public String c(Context context) {
        String appVersion = a.c().getAppVersion();
        if (TextUtils.isEmpty(appVersion)) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "0.8";
            }
        }
        return appVersion;
    }

    public final void d() {
        Context appContext = AppRuntime.getAppContext();
        this.f63145a = c(appContext);
        this.f63146b = b(appContext);
    }
}
