package com.yy.mediaframework.inteligence.coderate;

import android.os.Handler;
/* loaded from: classes6.dex */
public interface ICodeRateByFrame {
    int getSuggestCodeRate();

    void init(int i, int i2, int i3, Handler handler) throws RuntimeException;

    void publishCurrentFrameRate(int i, int i2);

    void publishNetworkCodeRate(int i);

    void release();
}
