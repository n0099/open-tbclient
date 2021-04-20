package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.baidu.android.common.others.lang.StringUtil;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, RemoteCallbackList<ICommonPermissionListener>> f29500a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f29501b;

    public static d a() {
        if (f29501b == null) {
            synchronized (d.class) {
                if (f29501b == null) {
                    f29501b = new d();
                }
            }
        }
        return f29501b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void broadcastPermissionListener(String str, String str2) throws RemoteException {
        u.b("MultiProcess", "00000 CommonPermissionListenerManagerImpl broadcastDialogListener: 00000" + String.valueOf(str) + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
        RemoteCallbackList<ICommonPermissionListener> remove = f29500a.remove(str);
        if (remove == null) {
            return;
        }
        int beginBroadcast = remove.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            ICommonPermissionListener broadcastItem = remove.getBroadcastItem(i);
            if (broadcastItem != null) {
                u.b("MultiProcess", "CommonPermissionListenerManagerImpl broadcastDialogListener: " + String.valueOf(str) + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
                if (str2 == null) {
                    broadcastItem.onGranted();
                } else {
                    broadcastItem.onDenied(str2);
                }
            }
        }
        remove.finishBroadcast();
        remove.kill();
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
        if (iCommonPermissionListener == null) {
            return;
        }
        u.b("MultiProcess", "CommonPermissionListenerManagerImpl registerPermissionListener");
        RemoteCallbackList<ICommonPermissionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iCommonPermissionListener);
        f29500a.put(str, remoteCallbackList);
    }
}
