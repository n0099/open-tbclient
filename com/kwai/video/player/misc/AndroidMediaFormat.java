package com.kwai.video.player.misc;

import android.annotation.TargetApi;
import android.media.MediaFormat;
/* loaded from: classes4.dex */
public class AndroidMediaFormat implements IMediaFormat {
    private final MediaFormat mMediaFormat;

    public AndroidMediaFormat(MediaFormat mediaFormat) {
        this.mMediaFormat = mediaFormat;
    }

    @Override // com.kwai.video.player.misc.IMediaFormat
    @TargetApi(16)
    public int getInteger(String str) {
        if (this.mMediaFormat == null) {
            return 0;
        }
        return this.mMediaFormat.getInteger(str);
    }

    @Override // com.kwai.video.player.misc.IMediaFormat
    @TargetApi(16)
    public String getString(String str) {
        if (this.mMediaFormat == null) {
            return null;
        }
        return this.mMediaFormat.getString(str);
    }

    @TargetApi(16)
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getName());
        sb.append('{');
        if (this.mMediaFormat != null) {
            sb.append(this.mMediaFormat.toString());
        } else {
            sb.append("null");
        }
        sb.append('}');
        return sb.toString();
    }
}
