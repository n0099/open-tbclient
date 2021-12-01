package com.kuaishou.tachikoma.api.app;
/* loaded from: classes2.dex */
public interface IRequestCallback {
    void onComplete(TKBaseResponse tKBaseResponse);

    void onError(TKError tKError);
}
