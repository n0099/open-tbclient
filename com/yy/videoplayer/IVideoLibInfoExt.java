package com.yy.videoplayer;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes6.dex */
public interface IVideoLibInfoExt extends IVideoLibInfo {
    boolean HWCodecConfigGetIsRooted();

    Context HWCodecConfigGetmCtx();

    void HWCodecConfigSetRunTimeStamp(String str, long j);

    int getConfig(int i);

    boolean isLibraryLoaded();

    void notifyHardwareCodecConfigured(boolean z, boolean z2, boolean z3, boolean z4);

    void onCoefficientOfVariationOfRenderInterval(long j, long j2, long j3, double d);

    void onDecodeEventNotify(VideoDecodeEventNotify videoDecodeEventNotify);

    void onDecodedFrameData(long j, int i, int i2, byte[] bArr, int i3, long j2);

    void onFirstFrameDecodeNotify(long j, long j2, long j3);

    void onFirstFrameRenderNotify(long j, long j2, long j3, long j4, int i);

    void onFirstFrameSeeNotify(long j, long j2, int i, int i2);

    void onHardwareDecodeErrorNotify(long j, long j2, int i);

    void onHardwareDecodeWrongFrameNotify(long j, String str, byte[] bArr, byte[] bArr2);

    void onVideoRenderNotify(ArrayList<VideoRenderNotify> arrayList);

    void onViewPlayEventNotify(long j, long j2, int i, long j3);

    void onViewStateNotify(long j, int i);

    void setConfigs(int i, Map<Integer, Integer> map);
}
