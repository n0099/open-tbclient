package com.kwad.components.core.i;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.m.i;
import com.kwad.components.core.m.l;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.IActivityProxy;
/* loaded from: classes9.dex */
public abstract class a extends IActivityProxy {
    public static final String FRAGMENTS_TAG = "android:fragments";
    public static final String KEY_START_TIME = "key_start_time";
    public final com.kwad.components.core.i.kwai.a mPageMonitor = new com.kwad.components.core.i.kwai.a();
    public boolean enableDestroyer = true;

    public boolean enableSaveFragmentState() {
        return false;
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
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        Intent intent = getIntent();
        long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
        this.mPageMonitor.at(getPageName());
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

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!KsAdSDKImpl.get().getIsExternal() || enableSaveFragmentState() || bundle == null || !bundle.containsKey(FRAGMENTS_TAG)) {
            return;
        }
        bundle.remove(FRAGMENTS_TAG);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i) {
        super.setContentView(View.inflate(Wrapper.wrapContextIfNeed(getActivity()), i, null));
    }

    public void setEnableDestroyer(boolean z) {
        this.enableDestroyer = z;
    }
}
