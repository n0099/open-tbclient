package com.sina.weibo.sdk.net;

import com.sina.weibo.sdk.exception.WeiboException;
/* loaded from: classes2.dex */
public interface RequestListener {
    void onComplete(String str);

    void onWeiboException(WeiboException weiboException);
}
