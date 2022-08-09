package com.sina.weibo.sdk.share;

import com.sina.weibo.sdk.api.StoryObject;
/* loaded from: classes8.dex */
public interface TransResourceCallback {
    void onTransFinish(StoryObject storyObject);

    void onTransFinish(TransResourceResult transResourceResult);
}
