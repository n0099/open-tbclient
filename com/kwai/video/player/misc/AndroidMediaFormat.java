package com.kwai.video.player.misc;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes7.dex */
public class AndroidMediaFormat implements IMediaFormat {
    public final MediaFormat mMediaFormat;

    public AndroidMediaFormat(MediaFormat mediaFormat) {
        this.mMediaFormat = mediaFormat;
    }

    @Override // com.kwai.video.player.misc.IMediaFormat
    @TargetApi(16)
    public int getInteger(String str) {
        MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        return mediaFormat.getInteger(str);
    }

    @Override // com.kwai.video.player.misc.IMediaFormat
    @TargetApi(16)
    public String getString(String str) {
        MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat == null) {
            return null;
        }
        return mediaFormat.getString(str);
    }

    @TargetApi(16)
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(AndroidMediaFormat.class.getName());
        sb.append('{');
        MediaFormat mediaFormat = this.mMediaFormat;
        sb.append(mediaFormat != null ? mediaFormat.toString() : StringUtil.NULL_STRING);
        sb.append('}');
        return sb.toString();
    }
}
