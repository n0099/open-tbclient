package com.kwad.sdk.h;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.n;
/* loaded from: classes8.dex */
public abstract class b extends IFragmentActivityProxy {
    public final com.kwad.sdk.h.a.a mPageMonitor = new com.kwad.sdk.h.a.a();
    public final com.kwad.sdk.h.kwai.a mBackPressDelete = new com.kwad.sdk.h.kwai.a();
    public boolean enableDestroyer = true;

    public void addBackPressable(com.kwad.sdk.h.kwai.b bVar) {
        this.mBackPressDelete.a(bVar);
    }

    public void addBackPressable(com.kwad.sdk.h.kwai.b bVar, int i2) {
        this.mBackPressDelete.a(bVar, i2);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public Intent getIntent() {
        Intent intent = super.getIntent();
        aj.a(intent);
        return intent;
    }

    public abstract String getPageName();

    public boolean isEnableDestroyer() {
        return this.enableDestroyer;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        if (this.mBackPressDelete.a()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
        this.mPageMonitor.a(getClass().getSimpleName());
        this.mPageMonitor.a(longExtra);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        if (this.enableDestroyer) {
            n.a(this);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        this.mPageMonitor.a(getActivity());
    }

    public void removeBackPressable(com.kwad.sdk.h.kwai.b bVar) {
        this.mBackPressDelete.b(bVar);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i2) {
        super.setContentView(View.inflate(Wrapper.wrapContextIfNeed(getActivity()), i2, null));
    }

    public void setEnableDestroyer(boolean z) {
        this.enableDestroyer = z;
    }
}
