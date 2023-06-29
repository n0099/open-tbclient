package com.kwad.components.offline.api.core.api;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public abstract class IOfflineCompoWrapper {
    public String mOfflinePackageName;

    public IOfflineCompoWrapper(String str) {
        this.mOfflinePackageName = str;
    }

    public abstract Context unwrapContextIfNeed(Context context);

    public abstract Context wrapContextIfNeed(@Nullable Context context);

    public abstract LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater);
}
