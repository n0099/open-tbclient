package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.s;
import java.util.List;
/* loaded from: classes6.dex */
public interface f {
    public static final f mvR = new c();

    Pair<com.google.android.exoplayer2.extractor.e, Boolean> a(com.google.android.exoplayer2.extractor.e eVar, Uri uri, Format format, List<Format> list, DrmInitData drmInitData, s sVar);
}
