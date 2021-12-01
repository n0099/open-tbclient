package com.kuaishou.tachikoma.api.app;
/* loaded from: classes2.dex */
public interface IBundleCallback {
    void onFailure(Exception exc);

    void onSuccess(TkBundleInfo tkBundleInfo);
}
