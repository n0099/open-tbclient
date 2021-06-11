package com.kwai.video.hodor;

import androidx.annotation.NonNull;
import com.baidu.rtc.PeerConnectionClient;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.anotations.AccessedByNative;
import com.kwai.video.hodor.util.HeaderUtil;
import java.util.Map;
/* loaded from: classes7.dex */
public class VodAdaptivePreloadPriorityTask extends AbstractHodorPreloadTask {
    public AwesomeCacheCallback mAwesomeCacheCallback;
    @AccessedByNative
    public String mCacheKey;
    public VodAdaptiveDataSpec mDataSpec;
    public VodAdaptiveInit mVodAdaptiveInitValue;

    /* loaded from: classes7.dex */
    public static class VodAdaptiveDataSpec {
        public String headers;
        public String manifestJson;
        public long preloadBytes = 1048576;
        public long durMs = -1;
    }

    /* loaded from: classes7.dex */
    public static class VodAdaptiveInit {
        public String rateConfig = "";
        public int devResWidth = PeerConnectionClient.HD_VIDEO_HEIGHT;
        public int devResHeigh = 1280;
        public int netType = 1;
        public int lowDevice = 0;
        public int signalStrength = 1;
        public int switchCode = 0;
        public int manifestType = 0;
    }

    public VodAdaptivePreloadPriorityTask(String str, VodAdaptiveInit vodAdaptiveInit) {
        VodAdaptiveDataSpec vodAdaptiveDataSpec = new VodAdaptiveDataSpec();
        this.mDataSpec = vodAdaptiveDataSpec;
        vodAdaptiveDataSpec.manifestJson = str;
        vodAdaptiveDataSpec.headers = "";
        this.mVodAdaptiveInitValue = vodAdaptiveInit;
        this.mAwesomeCacheCallback = null;
    }

    public VodAdaptivePreloadPriorityTask(String str, VodAdaptiveInit vodAdaptiveInit, Map<String, String> map) {
        VodAdaptiveDataSpec vodAdaptiveDataSpec = new VodAdaptiveDataSpec();
        this.mDataSpec = vodAdaptiveDataSpec;
        vodAdaptiveDataSpec.manifestJson = str;
        vodAdaptiveDataSpec.headers = HeaderUtil.parseHeaderMapToFlatString(map);
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
