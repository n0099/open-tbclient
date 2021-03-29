package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, RemoteCallbackList<ICommonDialogListener>> f29813a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f29814b;

    public static c a() {
        if (f29814b == null) {
            synchronized (c.class) {
                if (f29814b == null) {
                    f29814b = new c();
                }
            }
        }
        return f29814b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void broadcastDialogListener(String str, int i) throws RemoteException {
        RemoteCallbackList<ICommonDialogListener> remove = f29813a.remove(str);
        if (remove == null) {
            return;
        }
        int beginBroadcast = remove.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            ICommonDialogListener broadcastItem = remove.getBroadcastItem(i2);
            if (broadcastItem != null) {
                if (i == 1) {
                    broadcastItem.onDialogBtnYes();
                } else if (i == 2) {
                    broadcastItem.onDialogBtnNo();
                } else if (i != 3) {
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
        f29813a.put(str, remoteCallbackList);
    }
}
