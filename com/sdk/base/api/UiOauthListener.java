package com.sdk.base.api;

import com.sdk.base.framework.bean.OauthResultMode;
import com.sdk.y.g;
/* loaded from: classes9.dex */
public interface UiOauthListener {
    void onFailed(OauthResultMode oauthResultMode, g gVar);

    void onSuccess(OauthResultMode oauthResultMode, g gVar);
}
