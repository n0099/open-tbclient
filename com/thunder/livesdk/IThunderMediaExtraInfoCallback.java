package com.thunder.livesdk;

import com.thunder.livesdk.ThunderEventHandler;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public interface IThunderMediaExtraInfoCallback {
    void onRecvMediaExtraInfo(String str, ByteBuffer byteBuffer, int i);

    void onRecvMixAudioInfo(String str, ArrayList<ThunderEventHandler.MixAudioInfo> arrayList);

    void onRecvMixVideoInfo(String str, ArrayList<ThunderEventHandler.MixVideoInfo> arrayList);

    void onSendMediaExtraInfoFailedStatus(int i);
}
