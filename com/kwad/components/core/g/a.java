package com.kwad.components.core.g;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.proxy.IActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.g.kwai.a> EF = new ArrayList();
    public IActivityProxy EG;
    @NonNull
    public AdTemplate mAdTemplate;
    public Context mContext;

    public final Activity getActivity() {
        return this.EG.getActivity();
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.EF.clear();
    }
}
