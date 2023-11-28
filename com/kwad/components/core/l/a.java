package com.kwad.components.core.l;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.l.a.a> Mm = new ArrayList();
    @NonNull
    public final b<?> Mn;
    @NonNull
    public final Context mContext;
    @NonNull
    public final View mRootView;

    public a(b<?> bVar) {
        this.Mn = bVar;
        this.mContext = bVar.mContext;
        this.mRootView = bVar.mRootView;
    }

    @Deprecated
    public final Activity getActivity() {
        return this.Mn.getActivity();
    }

    public final void hn() {
        this.Mn.finish();
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.Mm.clear();
    }
}
