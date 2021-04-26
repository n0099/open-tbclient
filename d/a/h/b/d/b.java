package d.a.h.b.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.Log;
import d.a.h.b.f.a;
/* loaded from: classes.dex */
public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BdSailorPlatform f41048a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BdSailorPlatform bdSailorPlatform, Looper looper) {
        super(looper);
        this.f41048a = bdSailorPlatform;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Context context;
        Context context2;
        boolean isAppOnForeground;
        Context context3;
        if (message.what != 1) {
            return;
        }
        context = this.f41048a.mContext;
        if (context != null) {
            BdSailorPlatform bdSailorPlatform = this.f41048a;
            context2 = bdSailorPlatform.mContext;
            isAppOnForeground = bdSailorPlatform.isAppOnForeground(context2);
            if (isAppOnForeground) {
                return;
            }
            try {
                Log.d(BdSailorPlatform.TAG, "do pause");
                this.f41048a.mWebkitTimerPaused = a.a().c();
                context3 = this.f41048a.mContext;
                CookieSyncManager createInstance = CookieSyncManager.createInstance(context3);
                if (createInstance != null) {
                    createInstance.stopSync();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
