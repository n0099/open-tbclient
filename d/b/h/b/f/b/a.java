package d.b.h.b.f.b;

import android.content.Context;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.browser.sailor.webkit.loader.BdWebkitManager;
import com.baidu.browser.sailor.webkit.update.BdZeusDownloadHelper;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes2.dex */
public class a implements WebKitFactory.WebkitInstallListener {

    /* renamed from: c  reason: collision with root package name */
    public static final String f49492c = "a";

    /* renamed from: a  reason: collision with root package name */
    public byte f49493a;

    /* renamed from: b  reason: collision with root package name */
    public long f49494b;

    public static void a(Context context, boolean z, int i) {
        String str;
        StringBuilder sb;
        WebKitFactory.init(context, context.getPackageName(), BdSailorPlatform.getInstance().getCuid());
        WebKitFactory.setApkLibLoadType(z);
        if (BdWebkitManager.a.f4328c == i || BdWebkitManager.a.f4327b == i) {
            WebKitFactory.setEngine(1);
            str = f49492c;
            sb = new StringBuilder("zeus version =");
        } else {
            WebKitFactory.setEngine(0);
            str = f49492c;
            sb = new StringBuilder("zeus version =");
        }
        sb.append(WebKitFactory.getZeusVersionName());
        Log.d(str, sb.toString());
        Log.i(EngineManager.LOG_TAG, "so in=" + WebKitFactory.getZeusVersionName());
        Log.i(EngineManager.LOG_TAG, "so out=" + WebKitFactory.getSdkVersionName());
    }

    public static void c(LoadErrorCode loadErrorCode) {
        BdSailorPlatform.getStatic().b("init-webkit", "Err = " + loadErrorCode.getInt() + loadErrorCode.getString());
    }

    public final void b(LoadErrorCode loadErrorCode) {
        WebKitFactory.setEngine(0);
        BdSailorPlatform.getWebkitManager().onInstallZeusPluginFailed(this.f49493a, loadErrorCode);
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallFinish(int i, String str) {
        System.currentTimeMillis();
        Log.i("soar", "the return value of installing kernal is: " + i);
        BdZeusUtil.printKernellog("oninstalled: " + i + " targetpath: " + str);
        if (i == 0) {
            if (this.f49493a == 0) {
                a(BdSailorPlatform.getInstance().getAppContext(), BdSailorPlatform.getWebkitManager().isWebkitBuiltin(), BdSailorPlatform.getWebkitManager().getWebkitType$630ca8f2());
                if (BdZeusUtil.isWebkitLoaded()) {
                    BdSailorPlatform.getWebkitManager().onLoadZeusSDKSuccess();
                }
            }
            Log.d(f49492c, "install success!");
            BdSailorPlatform.getWebkitManager().onInstallZeusPluginSuccess(BdSailorPlatform.getInstance().getAppContext(), str, this.f49493a);
        } else {
            Log.d(f49492c, "install failed!");
            BdSailorPlatform.getWebkitManager().onInstallZeusPluginFailed(this.f49493a, WebKitFactory.getLoadErrorCode());
        }
        BdZeusDownloadHelper.d();
        BdSailorPlatform.getWebkitManager().enableBdWebkit();
        long currentTimeMillis = System.currentTimeMillis() - this.f49494b;
        String str2 = f49492c;
        Log.i(str2, "total timecost: " + String.valueOf(currentTimeMillis));
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallStart() {
    }
}
