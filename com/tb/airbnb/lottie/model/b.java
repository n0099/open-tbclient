package com.tb.airbnb.lottie.model;

import android.os.AsyncTask;
/* loaded from: classes2.dex */
public abstract class b<Params> extends AsyncTask<Params, Void, com.tb.airbnb.lottie.e> implements com.tb.airbnb.lottie.a {
    @Override // com.tb.airbnb.lottie.a
    public void cancel() {
        cancel(true);
    }
}
