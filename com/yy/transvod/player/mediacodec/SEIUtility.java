package com.yy.transvod.player.mediacodec;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SEIUtility {
    public static native int decodeDSEPayLoadV0(byte[] bArr, ArrayList<Long> arrayList);

    public static native int decodeDSEPayLoadV1(byte[] bArr, ArrayList<MixAudioExtraInfo> arrayList, ArrayList<Long> arrayList2);

    public static native int decodeSEIPayload(int i, byte[] bArr, ArrayList<VideoExtraInfo> arrayList, ArrayList<MixVideoExtraInfo> arrayList2, ArrayList<AlphaChannelData> arrayList3);

    public static native void nativeClassInit();
}
