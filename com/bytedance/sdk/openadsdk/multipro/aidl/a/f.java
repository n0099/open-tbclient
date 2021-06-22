package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, RemoteCallbackList<IRewardAdInteractionListener>> f29776a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f29777b;

    public static f a() {
        if (f29777b == null) {
            synchronized (f.class) {
                if (f29777b == null) {
                    f29777b = new f();
                }
            }
        }
        return f29777b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeRewardVideoCallback(String str, String str2, boolean z, int i2, String str3, int i3, String str4) throws RemoteException {
        a(str, str2, z, i2, str3, i3, str4);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iRewardAdInteractionListener);
        f29776a.put(str, remoteCallbackList);
    }

    private synchronized void a(String str, String str2, boolean z, int i2, String str3, int i3, String str4) {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList;
        try {
            if (f29776a != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = f29776a.remove(str);
                } else {
                    remoteCallbackList = f29776a.get(str);
                }
                RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList2 = remoteCallbackList;
                if (remoteCallbackList2 != null) {
                    int beginBroadcast = remoteCallbackList2.beginBroadcast();
                    for (int i4 = 0; i4 < beginBroadcast; i4++) {
                        IRewardAdInteractionListener broadcastItem = remoteCallbackList2.getBroadcastItem(i4);
                        if (broadcastItem != null) {
                            if ("onAdShow".equals(str2)) {
                                broadcastItem.onAdShow();
                            } else if ("onAdClose".equals(str2)) {
                                broadcastItem.onAdClose();
                            } else if ("onVideoComplete".equals(str2)) {
                                broadcastItem.onVideoComplete();
                            } else if ("onVideoError".equals(str2)) {
                                broadcastItem.onVideoError();
                            } else if ("onAdVideoBarClick".equals(str2)) {
                                broadcastItem.onAdVideoBarClick();
                            } else if ("onRewardVerify".equals(str2)) {
                                broadcastItem.onRewardVerify(z, i2, str3, i3, str4);
                            } else if ("onSkippedVideo".equals(str2)) {
                                broadcastItem.onSkippedVideo();
                            } else if ("recycleRes".equals(str2)) {
                                broadcastItem.onDestroy();
                            }
                        }
                    }
                    remoteCallbackList2.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList2.kill();
                    }
                }
            }
        } catch (Throwable th) {
            u.c("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th);
        }
    }
}
