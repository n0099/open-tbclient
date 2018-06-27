package com.sina.weibo.sdk.utils;

import android.os.Bundle;
import com.sina.weibo.sdk.exception.WeiboException;
/* loaded from: classes2.dex */
public interface WeiboUtilListener {
    void onCancel();

    void onComplete(Bundle bundle);

    void onWeiboException(WeiboException weiboException);
}
