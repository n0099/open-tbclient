package com.tencent.tauth;
/* loaded from: classes8.dex */
public interface IUiListener {
    void onCancel();

    void onComplete(Object obj);

    void onError(UiError uiError);

    void onWarning(int i);
}
