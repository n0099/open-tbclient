package com.kwad.components.core.page.recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public abstract class a extends com.kwad.components.core.proxy.e {
    public RecyclerView Pe;
    public d Pf;

    public static int pC() {
        return R.id.obfuscated_res_0x7f091410;
    }

    public abstract d a(RecyclerView recyclerView);

    private RecyclerView.LayoutManager pB() {
        return new LinearLayoutManager(this.mContext);
    }

    private void py() {
        RecyclerView recyclerView = (RecyclerView) findViewById(pC());
        this.Pe = recyclerView;
        recyclerView.setItemAnimator(null);
        this.Pe.setLayoutManager(pB());
        this.Pf = a(this.Pe);
    }

    private void pz() {
        this.Pe.setAdapter(this.Pf);
    }

    @Override // com.kwad.components.core.proxy.e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        this.Pe.clearOnChildAttachStateChangeListeners();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
    }

    public final RecyclerView pA() {
        return this.Pe;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        super.onViewCreated(view2, bundle);
        py();
        pz();
    }
}
