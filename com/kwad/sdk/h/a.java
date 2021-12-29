package com.kwad.sdk.h;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.IActivityProxy;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.n;
/* loaded from: classes3.dex */
public abstract class a extends IActivityProxy {
    public static final String FRAGMENTS_TAG = "android:fragments";
    public static final String KEY_START_TIME = "key_start_time";
    public final com.kwad.sdk.h.a.a mPageMonitor = new com.kwad.sdk.h.a.a();
    public boolean enableDestroyer = true;

    public boolean enableSaveFragmentState() {
        return false;
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
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        long longExtra = intent != null ? intent.getLongExtra("key_start_time", 0L) : 0L;
        this.mPageMonitor.a(getPageName());
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

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!KsAdSDKImpl.get().getIsExternal() || enableSaveFragmentState() || bundle == null || !bundle.containsKey(FRAGMENTS_TAG)) {
            return;
        }
        bundle.remove(FRAGMENTS_TAG);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i2) {
        super.setContentView(View.inflate(Wrapper.wrapContextIfNeed(getActivity()), i2, null));
    }

    public void setEnableDestroyer(boolean z) {
        this.enableDestroyer = z;
    }
}
