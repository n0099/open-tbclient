package com.kwad.components.core.offline.init.kwai;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
/* loaded from: classes10.dex */
public final class i extends IOfflineCompoWrapper {
    public i(String str) {
        super(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Context unwrapContextIfNeed(Context context) {
        return com.kwai.sodler.lib.kwai.b.a.unwrapContextIfNeed(context);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final Context wrapContextIfNeed(@Nullable Context context) {
        return com.kwai.sodler.lib.kwai.b.a.ae(context, this.mOfflinePackageName);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoWrapper
    public final LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        return com.kwai.sodler.lib.kwai.b.a.a(layoutInflater, this.mOfflinePackageName);
    }
}
