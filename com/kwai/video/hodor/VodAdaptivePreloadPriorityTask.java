package com.kwai.video.hodor;

import androidx.annotation.NonNull;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.anotations.AccessedByNative;
import com.kwai.video.hodor.util.HeaderUtil;
import java.util.Map;
/* loaded from: classes3.dex */
public class VodAdaptivePreloadPriorityTask extends AbstractHodorPreloadTask {
    private AwesomeCacheCallback mAwesomeCacheCallback;
    @AccessedByNative
    private String mCacheKey;
    private VodAdaptiveDataSpec mDataSpec = new VodAdaptiveDataSpec();
    private VodAdaptiveInit mVodAdaptiveInitValue;

    /* loaded from: classes3.dex */
    public static class VodAdaptiveDataSpec {
        String headers;
        String manifestJson;
        long preloadBytes = 1048576;
        long durMs = -1;
    }

    /* loaded from: classes3.dex */
    public static class VodAdaptiveInit {
        public String rateConfig = "";
        public int devResWidth = 720;
        public int devResHeigh = 1280;
        public int netType = 1;
        public int lowDevice = 0;
        public int signalStrength = 1;
        public int switchCode = 0;
        public int manifestType = 0;
    }

    public VodAdaptivePreloadPriorityTask(String str, VodAdaptiveInit vodAdaptiveInit) {
        this.mDataSpec.manifestJson = str;
        this.mDataSpec.headers = "";
        this.mVodAdaptiveInitValue = vodAdaptiveInit;
        this.mAwesomeCacheCallback = null;
    }

    public VodAdaptivePreloadPriorityTask(String str, VodAdaptiveInit vodAdaptiveInit, Map<String, String> map) {
        this.mDataSpec.manifestJson = str;
        this.mDataSpec.headers = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mVodAdaptiveInitValue = vodAdaptiveInit;
        this.mAwesomeCacheCallback = null;
    }

    private native void _cancel();

    private native void _submit(Object obj, Object obj2, Object obj3);

    public native void _pause();

    public native void _resume();

    @Override // com.kwai.video.hodor.IHodorTask
    public void cancel() {
        _cancel();
    }

    public String getCacheKey() {
        return this.mCacheKey;
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
        this.mDataSpec.preloadBytes = j;
    }

    public void setPreloadDurationMs(long j) {
        this.mDataSpec.durMs = j;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void submit() {
        _submit(this.mDataSpec, this.mVodAdaptiveInitValue, this.mAwesomeCacheCallback);
    }
}
