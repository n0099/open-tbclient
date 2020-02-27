package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.v;
import com.google.android.exoplayer2.util.s;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class c implements f {
    @Override // com.google.android.exoplayer2.source.hls.f
    public Pair<com.google.android.exoplayer2.extractor.e, Boolean> a(com.google.android.exoplayer2.extractor.e eVar, Uri uri, Format format, List<Format> list, DrmInitData drmInitData, s sVar) {
        boolean z = true;
        String lastPathSegment = uri.getLastPathSegment();
        if ("text/vtt".equals(format.sampleMimeType) || lastPathSegment.endsWith(".webvtt") || lastPathSegment.endsWith(".vtt")) {
            eVar = new n(format.language, sVar);
            z = false;
        } else if (lastPathSegment.endsWith(".aac")) {
            eVar = new com.google.android.exoplayer2.extractor.f.c();
        } else if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            eVar = new com.google.android.exoplayer2.extractor.f.a();
        } else if (lastPathSegment.endsWith(".mp3")) {
            eVar = new com.google.android.exoplayer2.extractor.b.b(0, 0L);
        } else if (eVar != null) {
            z = false;
        } else if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4)) {
            eVar = new com.google.android.exoplayer2.extractor.c.e(0, sVar, null, drmInitData);
            z = false;
        } else {
            int i = 16;
            if (list != null) {
                i = 48;
            } else {
                list = Collections.emptyList();
            }
            String str = format.codecs;
            if (!TextUtils.isEmpty(str)) {
                if (!"audio/mp4a-latm".equals(com.google.android.exoplayer2.util.i.Qr(str))) {
                    i |= 2;
                }
                if (!"video/avc".equals(com.google.android.exoplayer2.util.i.Qq(str))) {
                    i |= 4;
                }
            }
            eVar = new v(2, sVar, new com.google.android.exoplayer2.extractor.f.e(i, list));
            z = false;
        }
        return Pair.create(eVar, Boolean.valueOf(z));
    }
}
