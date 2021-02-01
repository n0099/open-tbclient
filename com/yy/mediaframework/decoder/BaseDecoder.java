package com.yy.mediaframework.decoder;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.yy.mediaframework.model.DecodeVideoConfig;
import com.yy.mediaframework.model.DecodeVideoSample;
/* loaded from: classes4.dex */
public abstract class BaseDecoder {
    protected String IllegalStateExceptionTAG = getClass().getSimpleName();
    protected String mCodecName;
    protected String mCodecType;
    protected int mDecodeHeight;
    DecodeVideoConfig mDecodeVideoConfig;
    protected int mDecodeWidth;

    public abstract long drainDecoder(@NonNull DecodeVideoSample decodeVideoSample);

    public abstract long drainDecoder(@NonNull byte[] bArr, int i, boolean z, long j);

    public abstract int initDecoder(DecodeVideoConfig decodeVideoConfig);

    public abstract void release();

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseDecoder(@NonNull int i, @NonNull int i2, @NonNull String str, @NonNull String str2) {
        this.mDecodeWidth = -1;
        this.mDecodeHeight = -1;
        this.mDecodeWidth = i;
        this.mDecodeHeight = i2;
        this.mCodecName = str;
        this.mCodecType = str2;
    }

    protected static boolean isCodecAvailable(String str) {
        return Build.VERSION.SDK_INT >= 16 && !TextUtils.isEmpty(str);
    }
}
