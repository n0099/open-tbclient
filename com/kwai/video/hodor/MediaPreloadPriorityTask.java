package com.kwai.video.hodor;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.IHodorTask;
import com.kwai.video.hodor.anotations.AccessedByNative;
import com.kwai.video.hodor.util.HeaderUtil;
import com.kwai.video.hodor.util.Timber;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes7.dex */
public class MediaPreloadPriorityTask extends AbstractHodorPreloadTask {
    @AccessedByNative
    public AwesomeCacheCallback mAwesomeCacheCallback;
    @AccessedByNative
    public final String mCacheKey;
    @AccessedByNative
    public final String mHttpHeaders;
    @AccessedByNative
    public final String mUrl;
    @AccessedByNative
    public long mPreloadBytes = 1048576;
    @AccessedByNative
    public String mMd5HashCode = "";
    @IHodorTask.MediaDirEvictStrategy
    @AccessedByNative
    public int mEvictStrategy = 1;

    public MediaPreloadPriorityTask(@NonNull String str, @Nullable Map<String, String> map, @Nullable String str2) {
        this.mUrl = str;
        this.mHttpHeaders = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mCacheKey = str2;
    }

    public static MediaPreloadPriorityTask newTaskWithHttpDns(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("Host", str2);
        }
        return new MediaPreloadPriorityTask(str, hashMap, str3);
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public native void cancel();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void pause();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void resume();

    @Override // com.kwai.video.hodor.IHodorTask
    public void setAwesomeCacheCallback(AwesomeCacheCallback awesomeCacheCallback) {
        this.mAwesomeCacheCallback = awesomeCacheCallback;
    }

    public void setEvictStrategy(@IHodorTask.MediaDirEvictStrategy int i2) {
        this.mEvictStrategy = i2;
    }

    public void setPreloadBytes(long j) {
        this.mPreloadBytes = j;
    }

    public void setmMd5HashCode(@NonNull String str) {
        if (str == null) {
            Timber.e("setmMd5HashCode,input md5 is null invalid", new Object[0]);
        } else {
            this.mMd5HashCode = str;
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public native void submit();
}
