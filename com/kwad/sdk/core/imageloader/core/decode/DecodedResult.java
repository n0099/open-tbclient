package com.kwad.sdk.core.imageloader.core.decode;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.framesequence.FrameSequence;
/* loaded from: classes5.dex */
public class DecodedResult {
    public Bitmap mBitmap;
    public FrameSequence mFrameSequence;

    public int getByteSize() {
        if (this.mBitmap != null) {
            return this.mBitmap.getRowBytes() * this.mBitmap.getHeight();
        }
        return 0;
    }

    public boolean isDecoded() {
        return (this.mBitmap != null && !this.mBitmap.isRecycled()) || (this.mFrameSequence != null);
    }
}
