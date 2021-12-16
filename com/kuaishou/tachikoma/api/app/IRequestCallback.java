package com.kuaishou.tachikoma.api.app;
/* loaded from: classes3.dex */
public interface IRequestCallback {
    void onComplete(TKBaseResponse tKBaseResponse);

    void onError(TKError tKError);
}
