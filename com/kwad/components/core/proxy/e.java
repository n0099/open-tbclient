package com.kwad.components.core.proxy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public class e extends KsFragment implements com.kwad.sdk.l.a.b {
    public ViewGroup QK;
    public ViewGroup lC;
    public final com.kwad.sdk.l.a.a mBackPressDelete = new com.kwad.sdk.l.a.a();
    public Context mContext;

    public ViewGroup lG() {
        return null;
    }

    public int oR() {
        return 0;
    }

    public boolean onBackPressed() {
        return this.mBackPressDelete.onBackPressed();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (getHost() != null) {
            com.kwad.components.core.s.g.destroyFragment(this.mContext, getView());
        }
    }

    public final <T extends View> T findViewById(int i) {
        ViewGroup viewGroup = this.lC;
        if (viewGroup != null) {
            return (T) viewGroup.findViewById(i);
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = l.wrapContextIfNeed(getActivity());
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        this.QK = viewGroup;
        if (this.lC == null) {
            ViewGroup lG = lG();
            this.lC = lG;
            if (lG == null && oR() != 0) {
                this.lC = (ViewGroup) from.inflate(oR(), viewGroup, false);
            }
        }
        return this.lC;
    }
}
