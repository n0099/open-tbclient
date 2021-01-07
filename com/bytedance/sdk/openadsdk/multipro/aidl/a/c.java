package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, RemoteCallbackList<ICommonDialogListener>> f7650a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static volatile c f7651b;

    public static c a() {
        if (f7651b == null) {
            synchronized (c.class) {
                if (f7651b == null) {
                    f7651b = new c();
                }
            }
        }
        return f7651b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException {
        if (iCommonDialogListener != null) {
            RemoteCallbackList<ICommonDialogListener> remoteCallbackList = new RemoteCallbackList<>();
            remoteCallbackList.register(iCommonDialogListener);
            f7650a.put(str, remoteCallbackList);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void broadcastDialogListener(String str, int i) throws RemoteException {
        RemoteCallbackList<ICommonDialogListener> remove = f7650a.remove(str);
        if (remove != null) {
            int beginBroadcast = remove.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                ICommonDialogListener broadcastItem = remove.getBroadcastItem(i2);
                if (broadcastItem != null) {
                    switch (i) {
                        case 1:
                            broadcastItem.onDialogBtnYes();
                            continue;
                        case 2:
                            broadcastItem.onDialogBtnNo();
                            continue;
                        case 3:
                            broadcastItem.onDialogCancel();
                            continue;
                        default:
                            broadcastItem.onDialogCancel();
                            continue;
                    }
                }
            }
            remove.finishBroadcast();
            remove.kill();
        }
    }
}
