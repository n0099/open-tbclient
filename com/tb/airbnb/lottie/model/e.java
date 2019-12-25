package com.tb.airbnb.lottie.model;

import android.content.res.Resources;
import com.tb.airbnb.lottie.e;
import java.io.InputStream;
/* loaded from: classes2.dex */
public final class e extends b<InputStream> {
    private final com.tb.airbnb.lottie.h loadedListener;
    private final Resources mNO;

    public e(Resources resources, com.tb.airbnb.lottie.h hVar) {
        this.mNO = resources;
        this.loadedListener = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public com.tb.airbnb.lottie.e doInBackground(InputStream... inputStreamArr) {
        return e.a.a(this.mNO, inputStreamArr[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: i */
    public void onPostExecute(com.tb.airbnb.lottie.e eVar) {
        this.loadedListener.onCompositionLoaded(eVar);
    }
}
