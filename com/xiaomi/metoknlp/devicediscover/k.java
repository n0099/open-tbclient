package com.xiaomi.metoknlp.devicediscover;

import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k extends AsyncTask {
    final /* synthetic */ n a;
    private boolean b;

    private k(n nVar) {
        this.a = nVar;
        this.b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(n nVar, b bVar) {
        this(nVar);
    }

    private String b(String str) {
        String a = com.xiaomi.metoknlp.a.b.a(str, null);
        if (a != null) {
            try {
                return new JSONObject(a).getString("real-ip");
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        if (this.b) {
            try {
                return b(strArr[0]);
            } catch (Exception e) {
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (this.b) {
            n.d(this.a).sendMessage(n.d(this.a).obtainMessage(3, str));
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        this.b = false;
    }
}
