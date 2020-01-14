package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.List;
/* loaded from: classes5.dex */
final class t {
    private final List<Format> mmf;
    private final com.google.android.exoplayer2.extractor.m[] mmi;

    public t(List<Format> list) {
        this.mmf = list;
        this.mmi = new com.google.android.exoplayer2.extractor.m[list.size()];
    }

    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        for (int i = 0; i < this.mmi.length; i++) {
            dVar.dur();
            com.google.android.exoplayer2.extractor.m dH = gVar.dH(dVar.dus(), 3);
            Format format = this.mmf.get(i);
            String str = format.sampleMimeType;
            com.google.android.exoplayer2.util.a.checkArgument("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            dH.h(Format.a(format.id != null ? format.id : dVar.dut(), str, (String) null, -1, format.selectionFlags, format.language, format.accessibilityChannel, (DrmInitData) null));
            this.mmi[i] = dH;
        }
    }

    public void a(long j, com.google.android.exoplayer2.util.l lVar) {
        com.google.android.exoplayer2.text.a.g.a(j, lVar, this.mmi);
    }
}
