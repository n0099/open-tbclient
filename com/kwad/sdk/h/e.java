package com.kwad.sdk.h;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.BaseSystemDialogFragment;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes4.dex */
public abstract class e extends BaseSystemDialogFragment {
    public abstract View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle);

    @Override // android.app.Fragment
    @Nullable
    public final View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return a(Wrapper.wrapInflaterIfNeed(layoutInflater), viewGroup, bundle);
    }
}
