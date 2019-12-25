package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.List;
/* loaded from: classes4.dex */
final class t {
    private final List<Format> mil;
    private final com.google.android.exoplayer2.extractor.m[] mip;

    public t(List<Format> list) {
        this.mil = list;
        this.mip = new com.google.android.exoplayer2.extractor.m[list.size()];
    }

    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        for (int i = 0; i < this.mip.length; i++) {
            dVar.dte();
            com.google.android.exoplayer2.extractor.m dJ = gVar.dJ(dVar.dtf(), 3);
            Format format = this.mil.get(i);
            String str = format.sampleMimeType;
            com.google.android.exoplayer2.util.a.checkArgument("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            dJ.h(Format.a(format.id != null ? format.id : dVar.dtg(), str, (String) null, -1, format.selectionFlags, format.language, format.accessibilityChannel, (DrmInitData) null));
            this.mip[i] = dJ;
        }
    }

    public void a(long j, com.google.android.exoplayer2.util.l lVar) {
        com.google.android.exoplayer2.text.a.g.a(j, lVar, this.mip);
    }
}
