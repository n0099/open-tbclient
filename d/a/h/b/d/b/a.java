package d.a.h.b.d.b;

import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes.dex */
public class a implements WebKitFactory.WebkitInstallListener {

    /* renamed from: c  reason: collision with root package name */
    public static final String f39994c = "a";

    /* renamed from: a  reason: collision with root package name */
    public byte f39995a;

    /* renamed from: b  reason: collision with root package name */
    public long f39996b;

    public static void c(LoadErrorCode loadErrorCode) {
        BdSailorPlatform.getStatic().b("init-webkit", "Err = " + loadErrorCode.getInt() + loadErrorCode.getString());
    }

    public final void a(LoadErrorCode loadErrorCode) {
        WebKitFactory.setEngine(0);
        BdSailorPlatform.getWebkitManager().onInstallZeusPluginFailed(this.f39995a, loadErrorCode);
    }

    public final void b(String str) {
        if (str == null) {
            return;
        }
        this.f39995a = (byte) 0;
        if (!str.startsWith("file://")) {
            str = "file://".concat(String.valueOf(str));
        }
        BdZeusUtil.printKernellog("install plugin from download");
        WebKitFactory.installAsync(str, this);
        this.f39996b = System.currentTimeMillis();
        Log.i(f39994c, "full update started!");
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallFinish(int i2, String str) {
        System.currentTimeMillis();
        Log.i("soar", "the return value of installing kernal is: ".concat(String.valueOf(i2)));
        BdZeusUtil.printKernellog("oninstalled: " + i2 + " targetpath: " + str);
        if (i2 == 0) {
            Log.d(f39994c, "install success!");
            BdSailorPlatform.getWebkitManager().onInstallZeusPluginSuccess(BdSailorPlatform.getInstance().getAppContext(), str, this.f39995a);
        } else {
            Log.d(f39994c, "install failed!");
            BdSailorPlatform.getWebkitManager().onInstallZeusPluginFailed(this.f39995a, WebKitFactory.getLoadErrorCode());
        }
        BdSailorPlatform.getWebkitManager().enableBdWebkit();
        long currentTimeMillis = System.currentTimeMillis() - this.f39996b;
        String str2 = f39994c;
        Log.i(str2, "total timecost: " + String.valueOf(currentTimeMillis));
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallStart() {
    }
}
