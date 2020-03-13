package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.List;
/* loaded from: classes6.dex */
final class t {
    private final List<Format> mmY;
    private final com.google.android.exoplayer2.extractor.m[] mnb;

    public t(List<Format> list) {
        this.mmY = list;
        this.mnb = new com.google.android.exoplayer2.extractor.m[list.size()];
    }

    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        for (int i = 0; i < this.mnb.length; i++) {
            dVar.dvF();
            com.google.android.exoplayer2.extractor.m dK = gVar.dK(dVar.dvG(), 3);
            Format format = this.mmY.get(i);
            String str = format.sampleMimeType;
            com.google.android.exoplayer2.util.a.checkArgument("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            dK.h(Format.a(format.id != null ? format.id : dVar.dvH(), str, (String) null, -1, format.selectionFlags, format.language, format.accessibilityChannel, (DrmInitData) null));
            this.mnb[i] = dK;
        }
    }

    public void a(long j, com.google.android.exoplayer2.util.l lVar) {
        com.google.android.exoplayer2.text.a.g.a(j, lVar, this.mnb);
    }
}
