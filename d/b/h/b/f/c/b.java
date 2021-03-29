package d.b.h.b.f.c;

import android.content.Context;
import com.baidu.browser.sailor.webkit.update.BdZeusUpdate;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f49496e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BdZeusUpdate f49497f;

    public b(BdZeusUpdate bdZeusUpdate, Context context) {
        this.f49497f = bdZeusUpdate;
        this.f49496e = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f49496e != null) {
            Log.i(EngineManager.LOG_TAG, "start check zeus update async");
            BdZeusUpdate bdZeusUpdate = this.f49497f;
            Context context = this.f49496e;
            if (WebKitFactory.isUserPrivacyEnabled() && !bdZeusUpdate.f4351d && d.b.h.b.e.b.d(context)) {
                BdZeusUpdate.BdZesuUpdateTask bdZesuUpdateTask = new BdZeusUpdate.BdZesuUpdateTask(context, "https://mbrowser.baidu.com/api/update/kernel?version=");
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(bdZesuUpdateTask);
                bdNet.start(bdZesuUpdateTask, false);
                bdZeusUpdate.f4351d = true;
            }
        }
    }
}
