package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.List;
/* loaded from: classes5.dex */
final class t {
    private final List<Format> mma;
    private final com.google.android.exoplayer2.extractor.m[] mmd;

    public t(List<Format> list) {
        this.mma = list;
        this.mmd = new com.google.android.exoplayer2.extractor.m[list.size()];
    }

    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        for (int i = 0; i < this.mmd.length; i++) {
            dVar.dup();
            com.google.android.exoplayer2.extractor.m dH = gVar.dH(dVar.duq(), 3);
            Format format = this.mma.get(i);
            String str = format.sampleMimeType;
            com.google.android.exoplayer2.util.a.checkArgument("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            dH.h(Format.a(format.id != null ? format.id : dVar.dur(), str, (String) null, -1, format.selectionFlags, format.language, format.accessibilityChannel, (DrmInitData) null));
            this.mmd[i] = dH;
        }
    }

    public void a(long j, com.google.android.exoplayer2.util.l lVar) {
        com.google.android.exoplayer2.text.a.g.a(j, lVar, this.mmd);
    }
}
