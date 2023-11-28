package com.kwad.components.core.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.s.l;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;
/* loaded from: classes10.dex */
public abstract class f extends IFragmentActivityProxy {
    public Context mContext;
    public View mRootView;
    public final com.kwad.components.core.proxy.a.a mPageMonitor = new com.kwad.components.core.proxy.a.a(null);
    public final com.kwad.sdk.l.a.a mBackPressDelete = new com.kwad.sdk.l.a.a();

    public abstract String getPageName();

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public Intent getIntent() {
        Intent intent = super.getIntent();
        l.c(intent);
        return intent;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onBackPressed() {
        if (!this.mBackPressDelete.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.s.g.destroyActivity(getActivity(), getWindow());
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        com.kwad.components.core.proxy.a.a aVar = this.mPageMonitor;
        getActivity();
        aVar.pW();
    }

    public void addBackPressable(com.kwad.sdk.l.a.b bVar) {
        this.mBackPressDelete.addBackPressable(bVar);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public <T extends View> T findViewById(int i) {
        T t = (T) this.mRootView.findViewById(i);
        if (t != null) {
            return t;
        }
        return (T) super.findViewById(i);
    }

    public void removeBackPressable(com.kwad.sdk.l.a.b bVar) {
        this.mBackPressDelete.removeBackPressable(bVar);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void setContentView(int i) {
        View inflate = com.kwad.sdk.m.l.inflate(this.mContext, i, null);
        this.mRootView = inflate;
        super.setContentView(inflate);
    }

    public void addBackPressable(com.kwad.sdk.l.a.b bVar, int i) {
        this.mBackPressDelete.addBackPressable(bVar, i);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            if (!KsAdSDKImpl.get().hasInitFinish()) {
                finish();
                return;
            }
            super.onCreate(bundle);
            getActivity().setTheme(R.style.obfuscated_res_0x7f100243);
            this.mContext = com.kwad.sdk.m.l.wrapContextIfNeed(getActivity());
            Intent intent = getIntent();
            long j = 0;
            if (intent != null) {
                j = intent.getLongExtra("key_start_time", 0L);
            }
            this.mPageMonitor.ao(getClass().getSimpleName());
            this.mPageMonitor.B(j);
        } catch (Throwable th) {
            if (KsAdSDKImpl.get().getIsExternal()) {
                com.kwad.components.core.d.a.b(th);
                finish();
                return;
            }
            throw th;
        }
    }
}
