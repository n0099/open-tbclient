package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, RemoteCallbackList<IFullScreenVideoAdInteractionListener>> f29774a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f29775b;

    public static e a() {
        if (f29775b == null) {
            synchronized (e.class) {
                if (f29775b == null) {
                    f29775b = new e();
                }
            }
        }
        return f29775b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeFullVideoCallback(String str, String str2) throws RemoteException {
        a(str, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IFullScreenVideoAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iFullScreenVideoAdInteractionListener);
        f29774a.put(str, remoteCallbackList);
    }

    private synchronized void a(String str, String str2) {
        RemoteCallbackList<IFullScreenVideoAdInteractionListener> remoteCallbackList;
        try {
            if (f29774a != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = f29774a.remove(str);
                } else {
                    remoteCallbackList = f29774a.get(str);
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i2 = 0; i2 < beginBroadcast; i2++) {
                        IFullScreenVideoAdInteractionListener broadcastItem = remoteCallbackList.getBroadcastItem(i2);
                        if (broadcastItem != null) {
                            if ("onAdShow".equals(str2)) {
                                broadcastItem.onAdShow();
                            } else if ("onAdClose".equals(str2)) {
                                broadcastItem.onAdClose();
                            } else if ("onVideoComplete".equals(str2)) {
                                broadcastItem.onVideoComplete();
                            } else if ("onSkippedVideo".equals(str2)) {
                                broadcastItem.onSkippedVideo();
                            } else if ("onAdVideoBarClick".equals(str2)) {
                                broadcastItem.onAdVideoBarClick();
                            } else if ("recycleRes".equals(str2)) {
                                broadcastItem.onDestroy();
                            }
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList.kill();
                    }
                }
            }
        } catch (Throwable th) {
            u.c("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th);
        }
    }
}
