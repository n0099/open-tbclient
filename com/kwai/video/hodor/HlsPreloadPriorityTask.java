package com.kwai.video.hodor;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.anotations.AccessedByNative;
import com.kwai.video.hodor.util.HeaderUtil;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class HlsPreloadPriorityTask extends AbstractHodorPreloadTask {
    private AwesomeCacheCallback mAwesomeCacheCallback;
    @AccessedByNative
    private String mCacheKey;
    private String mHeaders;
    private String mManifestJson;
    private int mPreferBandwidth;
    private long mPreloadBytes;

    public HlsPreloadPriorityTask(String str, int i) {
        this.mPreloadBytes = 1048576L;
        this.mManifestJson = str;
        this.mPreferBandwidth = i;
        this.mHeaders = "";
        this.mAwesomeCacheCallback = null;
    }

    public HlsPreloadPriorityTask(String str, int i, Map<String, String> map) {
        this.mPreloadBytes = 1048576L;
        this.mManifestJson = str;
        this.mPreferBandwidth = i;
        this.mHeaders = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mAwesomeCacheCallback = null;
    }

    private native void _cancel();

    private native void _submit(String str, int i, long j, String str2, AwesomeCacheCallback awesomeCacheCallback);

    public native void _pause();

    public native void _resume();

    @Override // com.kwai.video.hodor.IHodorTask
    public void cancel() {
        _cancel();
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void pause() {
        _pause();
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void resume() {
        _resume();
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setAwesomeCacheCallback(@NonNull AwesomeCacheCallback awesomeCacheCallback) {
        this.mAwesomeCacheCallback = awesomeCacheCallback;
    }

    public void setPreloadBytes(long j) {
        this.mPreloadBytes = j;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void submit() {
        _submit(this.mManifestJson, this.mPreferBandwidth, this.mPreloadBytes, this.mHeaders, this.mAwesomeCacheCallback);
    }
}
