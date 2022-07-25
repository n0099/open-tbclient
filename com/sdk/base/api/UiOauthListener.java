package com.sdk.base.api;

import com.sdk.base.framework.bean.OauthResultMode;
import com.sdk.w.e;
/* loaded from: classes7.dex */
public interface UiOauthListener {
    void onFailed(OauthResultMode oauthResultMode, e eVar);

    void onSuccess(OauthResultMode oauthResultMode, e eVar);
}
