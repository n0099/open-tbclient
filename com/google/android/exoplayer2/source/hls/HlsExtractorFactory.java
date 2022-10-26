package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.List;
/* loaded from: classes7.dex */
public interface HlsExtractorFactory {
    public static final HlsExtractorFactory DEFAULT = new DefaultHlsExtractorFactory();

    Pair createExtractor(Extractor extractor, Uri uri, Format format, List list, DrmInitData drmInitData, TimestampAdjuster timestampAdjuster);
}
