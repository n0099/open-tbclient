package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.t;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class c<FETCH_STATE extends t> implements af<FETCH_STATE> {
    @Override // com.facebook.imagepipeline.producers.af
    public boolean a(FETCH_STATE fetch_state) {
        return true;
    }

    @Override // com.facebook.imagepipeline.producers.af
    public void a(FETCH_STATE fetch_state, int i) {
    }

    @Override // com.facebook.imagepipeline.producers.af
    @Nullable
    public Map<String, String> b(FETCH_STATE fetch_state, int i) {
        return null;
    }
}
