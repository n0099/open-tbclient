package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, RemoteCallbackList<ITTAppDownloadListener>> f29496a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f29497b;

    public static b a() {
        if (f29497b == null) {
            synchronized (b.class) {
                if (f29497b == null) {
                    f29497b = new b();
                }
            }
        }
        return f29497b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeAppDownloadCallback(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
        a(str, str2, j, j2, str3, str4);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void registerTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
        RemoteCallbackList<ITTAppDownloadListener> remoteCallbackList = f29496a.get(str);
        if (remoteCallbackList == null) {
            remoteCallbackList = new RemoteCallbackList<>();
        }
        remoteCallbackList.register(iTTAppDownloadListener);
        f29496a.put(str, remoteCallbackList);
        u.f("DMLibManager", "aidl registerTTAppDownloadListener, materialMd5:" + str);
        u.f("DMLibManager", "aidl registerTTAppDownloadListener, mListenerMap size:" + f29496a.size());
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void unregisterTTAppDownloadListener(String str, ITTAppDownloadListener iTTAppDownloadListener) throws RemoteException {
        Map<String, RemoteCallbackList<ITTAppDownloadListener>> map = f29496a;
        if (map == null) {
            u.f("DMLibManager", "aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:" + str);
            return;
        }
        RemoteCallbackList<ITTAppDownloadListener> remove = map.remove(str);
        if (remove == null) {
            u.f("DMLibManager", "aidl unregisterTTAppDownloadListener cbs = null, materialMd5:" + str);
            return;
        }
        a(remove);
        u.f("DMLibManager", "aidl unregisterTTAppDownloadListener, materialMd5:" + str);
        u.f("DMLibManager", "aidl unregisterTTAppDownloadListener, mListenerMap size:" + f29496a.size());
    }

    private synchronized void a(String str, String str2, long j, long j2, String str3, String str4) {
        ITTAppDownloadListener broadcastItem;
        try {
        } catch (Throwable th) {
            u.c("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess2: " + str2 + " throws Exception :", th);
        }
        if (f29496a == null) {
            return;
        }
        if ("recycleRes".equals(str2)) {
            a(f29496a.remove(str));
            u.f("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:" + str);
            u.f("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:" + f29496a.size());
            return;
        }
        RemoteCallbackList<ITTAppDownloadListener> remoteCallbackList = f29496a.get(str);
        if (remoteCallbackList != null) {
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    broadcastItem = remoteCallbackList.getBroadcastItem(i);
                } catch (Throwable th2) {
                    th = th2;
                }
                if (broadcastItem != null) {
                    if ("onIdle".equals(str2)) {
                        broadcastItem.onIdle();
                    } else if ("onDownloadActive".equals(str2)) {
                        broadcastItem.onDownloadActive(j, j2, str3, str4);
                    } else if ("onDownloadPaused".equals(str2)) {
                        broadcastItem.onDownloadPaused(j, j2, str3, str4);
                    } else if ("onDownloadFailed".equals(str2)) {
                        broadcastItem.onDownloadFailed(j, j2, str3, str4);
                    } else {
                        if ("onDownloadFinished".equals(str2)) {
                            try {
                                broadcastItem.onDownloadFinished(j, str3, str4);
                            } catch (Throwable th3) {
                                th = th3;
                                u.c("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                            }
                        } else if ("onInstalled".equals(str2)) {
                            broadcastItem.onInstalled(str3, str4);
                        }
                    }
                }
            }
            remoteCallbackList.finishBroadcast();
        }
    }

    private void a(RemoteCallbackList<ITTAppDownloadListener> remoteCallbackList) {
        if (remoteCallbackList != null) {
            try {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    ITTAppDownloadListener broadcastItem = remoteCallbackList.getBroadcastItem(i);
                    if (broadcastItem != null) {
                        ((com.bytedance.sdk.openadsdk.multipro.aidl.b.e) broadcastItem).a();
                    }
                }
                remoteCallbackList.finishBroadcast();
                remoteCallbackList.kill();
            } catch (Throwable th) {
                u.c("MultiProcess", "recycleRes2 throw Exception : ", th);
            }
        }
    }
}
