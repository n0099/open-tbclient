package com.tachikoma.core.component.network;

import com.tachikoma.core.component.network.delegate.TKBaseResponseInner;
/* loaded from: classes8.dex */
public interface ResponseCallBackInner {
    void onComplete(TKBaseResponseInner tKBaseResponseInner);

    void onError(TKErrorInner tKErrorInner);
}
