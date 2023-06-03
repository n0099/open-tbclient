package org.chromium.base.compat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.base.Callback;
import org.chromium.base.annotations.VerifiesOnQ;
import org.chromium.base.task.AsyncTask;
@VerifiesOnQ
@TargetApi(29)
/* loaded from: classes2.dex */
public final class ApiHelperForQ {
    public static boolean bindIsolatedService(Context context, Intent intent, int i, String str, Executor executor, ServiceConnection serviceConnection) {
        return context.bindIsolatedService(intent, i, str, executor, serviceConnection);
    }

    public static void requestCellInfoUpdate(TelephonyManager telephonyManager, final Callback<List<CellInfo>> callback) {
        telephonyManager.requestCellInfoUpdate(AsyncTask.THREAD_POOL_EXECUTOR, new TelephonyManager.CellInfoCallback() { // from class: org.chromium.base.compat.ApiHelperForQ.1
            @Override // android.telephony.TelephonyManager.CellInfoCallback
            @SuppressLint({"Override"})
            public void onCellInfo(List<CellInfo> list) {
                Callback.this.onResult(list);
            }
        });
    }

    public static void updateServiceGroup(Context context, ServiceConnection serviceConnection, int i, int i2) {
        context.updateServiceGroup(serviceConnection, i, i2);
    }
}
