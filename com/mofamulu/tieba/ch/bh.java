package com.mofamulu.tieba.ch;

import android.os.AsyncTask;
import android.util.Log;
import cn.jingling.lib.filters.CMTProcessor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends AsyncTask {
    final /* synthetic */ bg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar) {
        this.a = bgVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(Integer... numArr) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        try {
            new CMTProcessor().hashCode();
        } catch (Throwable th) {
            Log.e("tbhp_settings", "failed to CMTProcessor", th);
        }
    }
}
