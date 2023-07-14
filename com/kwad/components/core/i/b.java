package com.kwad.components.core.i;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.m.i;
import com.kwad.components.core.m.l;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
/* loaded from: classes10.dex */
public abstract class b extends IFragmentActivityProxy {
    public final com.kwad.components.core.i.kwai.a mPageMonitor = new com.kwad.components.core.i.kwai.a();
    public final com.kwad.sdk.g.kwai.a mBackPressDelete = new com.kwad.sdk.g.kwai.a();
    public boolean enableDestroyer = true;

    public void addBackPressable(com.kwad.sdk.g.kwai.b bVar) {
        this.mBackPressDelete.addBackPressable(bVar);
    }

    public void addBackPressable(com.kwad.sdk.g.kwai.b bVar, int i) {
        this.mBackPressDelete.addBackPressable(bVar, i);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public Intent getIntent() {
        Intent intent = super.getIntent();
        l.e(intent);
        return intent;
    }

    public abstract String getPageName();

    public boolean isEnableDestroyer() {
        return this.enableDestroyer;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        if (this.mBackPressDelete.bG()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
        this.mPageMonitor.at(getClass().getSimpleName());
        this.mPageMonitor.n(longExtra);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        if (this.enableDestroyer) {
            i.destroyActivity(getActivity(), getWindow());
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        com.kwad.components.core.i.kwai.a aVar = this.mPageMonitor;
        getActivity();
        aVar.oe();
    }

    public void removeBackPressable(com.kwad.sdk.g.kwai.b bVar) {
        this.mBackPressDelete.removeBackPressable(bVar);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i) {
        super.setContentView(View.inflate(Wrapper.wrapContextIfNeed(getActivity()), i, null));
    }

    public void setEnableDestroyer(boolean z) {
        this.enableDestroyer = z;
    }
}
