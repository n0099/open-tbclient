package com.tb.airbnb.lottie.model;

import android.content.res.Resources;
import com.tb.airbnb.lottie.e;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class h extends b<JSONObject> {
    private final Resources gk;
    private final com.tb.airbnb.lottie.h loadedListener;

    public h(Resources resources, com.tb.airbnb.lottie.h hVar) {
        this.gk = resources;
        this.loadedListener = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public com.tb.airbnb.lottie.e doInBackground(JSONObject... jSONObjectArr) {
        return e.a.b(this.gk, jSONObjectArr[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: i */
    public void onPostExecute(com.tb.airbnb.lottie.e eVar) {
        this.loadedListener.onCompositionLoaded(eVar);
    }
}
