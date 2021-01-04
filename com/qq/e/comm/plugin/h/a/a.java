package com.qq.e.comm.plugin.h.a;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: com.qq.e.comm.plugin.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class AsyncTaskC1169a extends AsyncTask<Void, Integer, String> {

        /* renamed from: b  reason: collision with root package name */
        private Context f12375b;

        public AsyncTaskC1169a(Context context) {
            this.f12375b = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            try {
                Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f12375b);
                if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                    return null;
                }
                return advertisingIdInfo.getId();
            } catch (Throwable th) {
                GDTLogger.d("ExceptionAAID Exception:" + th.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            a.this.f12376a = str;
        }
    }

    @Override // com.qq.e.comm.plugin.h.a
    public String a(Context context) {
        return b(context);
    }

    @Override // com.qq.e.comm.plugin.h.a.b
    protected String c(Context context) {
        new AsyncTaskC1169a(context).execute(new Void[0]);
        return null;
    }
}
