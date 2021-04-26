package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, RemoteCallbackList<ICommonDialogListener>> f30411a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f30412b;

    public static c a() {
        if (f30412b == null) {
            synchronized (c.class) {
                if (f30412b == null) {
                    f30412b = new c();
                }
            }
        }
        return f30412b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void broadcastDialogListener(String str, int i2) throws RemoteException {
        RemoteCallbackList<ICommonDialogListener> remove = f30411a.remove(str);
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
        f30411a.put(str, remoteCallbackList);
    }
}
