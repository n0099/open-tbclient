package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, RemoteCallbackList<ICommonDialogListener>> f29585a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f29586b;

    public static c a() {
        if (f29586b == null) {
            synchronized (c.class) {
                if (f29586b == null) {
                    f29586b = new c();
                }
            }
        }
        return f29586b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void broadcastDialogListener(String str, int i2) throws RemoteException {
        RemoteCallbackList<ICommonDialogListener> remove = f29585a.remove(str);
        if (remove == null) {
            return;
        }
        int beginBroadcast = remove.beginBroadcast();
        for (int i3 = 0; i3 < beginBroadcast; i3++) {
            ICommonDialogListener broadcastItem = remove.getBroadcastItem(i3);
            if (broadcastItem != null) {
                if (i2 == 1) {
                    broadcastItem.onDialogBtnYes();
                } else if (i2 == 2) {
                    broadcastItem.onDialogBtnNo();
                } else if (i2 != 3) {
                    broadcastItem.onDialogCancel();
                } else {
                    broadcastItem.onDialogCancel();
                }
            }
        }
        remove.finishBroadcast();
        remove.kill();
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException {
        if (iCommonDialogListener == null) {
            return;
        }
        RemoteCallbackList<ICommonDialogListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iCommonDialogListener);
        f29585a.put(str, remoteCallbackList);
    }
}
