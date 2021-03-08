package com.thunder.livesdk.video;

import android.content.Context;
import com.yy.videoplayer.IVideoInfoCallback;
import com.yy.videoplayer.IVideoLibInfoExt;
import com.yy.videoplayer.VideoDecodeEventNotify;
import com.yy.videoplayer.VideoRenderNotify;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes6.dex */
public class ThunderVideoPlayListener implements IVideoInfoCallback, IVideoLibInfoExt {
    private Context mAppContext;
    private IThunderVideoPlay mVideoPlayEngine;

    public ThunderVideoPlayListener(Context context, IThunderVideoPlay iThunderVideoPlay) {
        this.mAppContext = null;
        this.mVideoPlayEngine = null;
        this.mAppContext = context;
        this.mVideoPlayEngine = iThunderVideoPlay;
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void onViewStateNotify(long j, int i) {
        this.mVideoPlayEngine.onViewStateNotify(j, i);
    }

    @Override // com.yy.videoplayer.IVideoLibInfo
    public long getUid() {
        return 0L;
    }

    @Override // com.yy.videoplayer.IVideoLibInfo
    public long getTopSid() {
        return 0L;
    }

    @Override // com.yy.videoplayer.IVideoLibInfo
    public long getSubSid() {
        return 0L;
    }

    @Override // com.yy.videoplayer.IVideoLibInfo
    public String getPackageName() {
        return this.mAppContext.getPackageName();
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public boolean isLibraryLoaded() {
        return true;
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public int getConfig(int i) {
        return 0;
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void setConfigs(int i, Map<Integer, Integer> map) {
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void notifyHardwareCodecConfigured(boolean z, boolean z2, boolean z3, boolean z4) {
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void onCoefficientOfVariationOfRenderInterval(long j, long j2, long j3, double d) {
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void onViewPlayEventNotify(long j, long j2, int i, long j3) {
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void onVideoRenderNotify(ArrayList<VideoRenderNotify> arrayList) {
        this.mVideoPlayEngine.onVideoRenderNotify(arrayList);
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void onFirstFrameDecodeNotify(long j, long j2, long j3) {
        this.mVideoPlayEngine.onFirstFrameDecodeNotify(j, j2, j3);
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void onFirstFrameRenderNotify(long j, long j2, long j3, long j4, int i) {
    }

    @Override // com.yy.videoplayer.IVideoInfoCallback
    public void onUpdatePts(long j, long j2) {
    }

    @Override // com.yy.videoplayer.IVideoInfoCallback
    public void onUpdateVideoSizeChanged(long j, int i, int i2) {
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public Context HWCodecConfigGetmCtx() {
        return this.mAppContext;
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void HWCodecConfigSetRunTimeStamp(String str, long j) {
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public boolean HWCodecConfigGetIsRooted() {
        return ThunderVideoConfig.isRooted();
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void onFirstFrameSeeNotify(long j, long j2, int i, int i2) {
        this.mVideoPlayEngine.onFirstFrameRenderNotify(j, i, i2, j2);
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void onHardwareDecodeErrorNotify(long j, long j2, int i) {
        this.mVideoPlayEngine.onHardwareDecodeErrorNotify(j, j2, i);
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void onHardwareDecodeWrongFrameNotify(long j, String str, byte[] bArr, byte[] bArr2) {
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void onDecodedFrameData(long j, int i, int i2, byte[] bArr, int i3, long j2) {
        this.mVideoPlayEngine.onDecodedFrameData(j, i, i2, bArr, i3, j2);
    }

    @Override // com.yy.videoplayer.IVideoLibInfoExt
    public void onDecodeEventNotify(VideoDecodeEventNotify videoDecodeEventNotify) {
        this.mVideoPlayEngine.onVideoDecodeNotify(videoDecodeEventNotify);
    }
}
