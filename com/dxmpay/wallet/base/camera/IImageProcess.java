package com.dxmpay.wallet.base.camera;

import android.graphics.Rect;
import com.dxmpay.wallet.core.NoProguard;
/* loaded from: classes7.dex */
public interface IImageProcess extends NoProguard {
    void destroyProcessor();

    int getRecycledBufSize(int i2, int i3);

    boolean initProcessor();

    Object[] processImage(byte[] bArr, int i2, int i3, Rect rect, byte[] bArr2);

    Object[] processImageJpegData(byte[] bArr, int i2, int i3);
}
