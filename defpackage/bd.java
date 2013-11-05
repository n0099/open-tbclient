package defpackage;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
/* renamed from: bd  reason: default package */
/* loaded from: classes.dex */
class bd extends Handler {
    private bd() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bd(bg bgVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case LocationClientOption.MIN_SCAN_SPAN /* 1000 */:
                if (message.obj != null) {
                    ((Runnable) message.obj).run();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
