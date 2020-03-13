package com.qiniu.android.storage;

import android.os.Looper;
import android.util.Log;
import com.qiniu.android.utils.AndroidNetwork;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class UploadOptions {
    final String mimeType;
    final boolean noI;
    final UpProgressHandler noJ;
    final UpCancellationSignal noK;
    final NetReadyHandler noL;
    final Map<String, String> params;

    public UploadOptions(Map<String, String> map, String str, boolean z, UpProgressHandler upProgressHandler, UpCancellationSignal upCancellationSignal) {
        this(map, str, z, upProgressHandler, upCancellationSignal, null);
    }

    public UploadOptions(Map<String, String> map, String str, boolean z, UpProgressHandler upProgressHandler, UpCancellationSignal upCancellationSignal, NetReadyHandler netReadyHandler) {
        this.params = A(map);
        this.mimeType = Rt(str);
        this.noI = z;
        this.noJ = upProgressHandler == null ? new UpProgressHandler() { // from class: com.qiniu.android.storage.UploadOptions.1
            @Override // com.qiniu.android.storage.UpProgressHandler
            public void b(String str2, double d) {
                Log.d("Qiniu.UploadProgress", "" + d);
            }
        } : upProgressHandler;
        this.noK = upCancellationSignal == null ? new UpCancellationSignal() { // from class: com.qiniu.android.storage.UploadOptions.2
            @Override // com.qiniu.android.http.CancellationHandler
            public boolean isCancelled() {
                return false;
            }
        } : upCancellationSignal;
        this.noL = netReadyHandler == null ? new NetReadyHandler() { // from class: com.qiniu.android.storage.UploadOptions.3
            @Override // com.qiniu.android.storage.NetReadyHandler
            public void dGb() {
                if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    for (int i = 0; i < 6; i++) {
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (AndroidNetwork.dGh()) {
                            return;
                        }
                    }
                }
            }
        } : netReadyHandler;
    }

    private static Map<String, String> A(Map<String, String> map) {
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
    public static UploadOptions dGg() {
        return new UploadOptions(null, null, false, null, null);
    }

    private static String Rt(String str) {
        if (str == null || str.equals("")) {
            return "application/octet-stream";
        }
        return str;
    }
}
