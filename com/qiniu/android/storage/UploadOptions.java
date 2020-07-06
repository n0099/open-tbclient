package com.qiniu.android.storage;

import android.os.Looper;
import android.util.Log;
import com.qiniu.android.utils.AndroidNetwork;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class UploadOptions {
    final String mimeType;
    final boolean nEo;
    final UpProgressHandler nEp;
    final UpCancellationSignal nEq;
    final NetReadyHandler nEr;
    final Map<String, String> params;

    public UploadOptions(Map<String, String> map, String str, boolean z, UpProgressHandler upProgressHandler, UpCancellationSignal upCancellationSignal) {
        this(map, str, z, upProgressHandler, upCancellationSignal, null);
    }

    public UploadOptions(Map<String, String> map, String str, boolean z, UpProgressHandler upProgressHandler, UpCancellationSignal upCancellationSignal, NetReadyHandler netReadyHandler) {
        this.params = z(map);
        this.mimeType = RK(str);
        this.nEo = z;
        this.nEp = upProgressHandler == null ? new UpProgressHandler() { // from class: com.qiniu.android.storage.UploadOptions.1
            @Override // com.qiniu.android.storage.UpProgressHandler
            public void b(String str2, double d) {
                Log.d("Qiniu.UploadProgress", "" + d);
            }
        } : upProgressHandler;
        this.nEq = upCancellationSignal == null ? new UpCancellationSignal() { // from class: com.qiniu.android.storage.UploadOptions.2
            @Override // com.qiniu.android.http.CancellationHandler
            public boolean isCancelled() {
                return false;
            }
        } : upCancellationSignal;
        this.nEr = netReadyHandler == null ? new NetReadyHandler() { // from class: com.qiniu.android.storage.UploadOptions.3
            @Override // com.qiniu.android.storage.NetReadyHandler
            public void dMR() {
                if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    for (int i = 0; i < 6; i++) {
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (AndroidNetwork.dMX()) {
                            return;
                        }
                    }
                }
            }
        } : netReadyHandler;
    }

    private static Map<String, String> z(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().startsWith("x:") && entry.getValue() != null && !entry.getValue().equals("")) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UploadOptions dMW() {
        return new UploadOptions(null, null, false, null, null);
    }

    private static String RK(String str) {
        if (str == null || str.equals("")) {
            return "application/octet-stream";
        }
        return str;
    }
}
