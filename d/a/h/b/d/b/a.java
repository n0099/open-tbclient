package d.a.h.b.d.b;

import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes.dex */
public class a implements WebKitFactory.WebkitInstallListener {

    /* renamed from: c  reason: collision with root package name */
    public static final String f43740c = "a";

    /* renamed from: a  reason: collision with root package name */
    public byte f43741a;

    /* renamed from: b  reason: collision with root package name */
    public long f43742b;

    public static void c(LoadErrorCode loadErrorCode) {
        BdSailorPlatform.getStatic().b("init-webkit", "Err = " + loadErrorCode.getInt() + loadErrorCode.getString());
    }

    public final void a(LoadErrorCode loadErrorCode) {
        WebKitFactory.setEngine(0);
        BdSailorPlatform.getWebkitManager().onInstallZeusPluginFailed(this.f43741a, loadErrorCode);
    }

    public final void b(String str) {
        if (str == null) {
            return;
        }
        this.f43741a = (byte) 0;
        if (!str.startsWith("file://")) {
            str = "file://".concat(String.valueOf(str));
        }
        BdZeusUtil.printKernellog("install plugin from download");
        WebKitFactory.installAsync(str, this);
        this.f43742b = System.currentTimeMillis();
        Log.i(f43740c, "full update started!");
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallFinish(int i2, String str) {
        System.currentTimeMillis();
        Log.i("soar", "the return value of installing kernal is: ".concat(String.valueOf(i2)));
        BdZeusUtil.printKernellog("oninstalled: " + i2 + " targetpath: " + str);
        if (i2 == 0) {
            Log.d(f43740c, "install success!");
            BdSailorPlatform.getWebkitManager().onInstallZeusPluginSuccess(BdSailorPlatform.getInstance().getAppContext(), str, this.f43741a);
        } else {
            Log.d(f43740c, "install failed!");
            BdSailorPlatform.getWebkitManager().onInstallZeusPluginFailed(this.f43741a, WebKitFactory.getLoadErrorCode());
        }
        BdSailorPlatform.getWebkitManager().enableBdWebkit();
        long currentTimeMillis = System.currentTimeMillis() - this.f43742b;
        String str2 = f43740c;
        Log.i(str2, "total timecost: " + String.valueOf(currentTimeMillis));
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallStart() {
    }
}
