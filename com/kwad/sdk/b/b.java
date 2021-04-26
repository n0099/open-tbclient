package com.kwad.sdk.b;

import android.view.View;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
import com.kwad.sdk.utils.i;
/* loaded from: classes6.dex */
public abstract class b extends IFragmentActivityProxy {
    public boolean enableDestroyer = true;

    public boolean isEnableDestroyer() {
        return this.enableDestroyer;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        if (this.enableDestroyer) {
            i.a(this);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i2) {
        super.setContentView(View.inflate(Wrapper.wrapContextIfNeed(getActivity()), i2, null));
    }

    public void setEnableDestroyer(boolean z) {
        this.enableDestroyer = z;
    }
}
