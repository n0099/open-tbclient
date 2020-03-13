package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.l;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.s;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
final class n implements com.google.android.exoplayer2.extractor.e {
    private static final Pattern mwO = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern mwP = Pattern.compile("MPEGTS:(\\d+)");
    private final String language;
    private final s mjC;
    private com.google.android.exoplayer2.extractor.g mlA;
    private final com.google.android.exoplayer2.util.l mwQ = new com.google.android.exoplayer2.util.l();
    private byte[] mwR = new byte[1024];
    private int sampleSize;

    public n(String str, s sVar) {
        this.language = str;
        this.mjC = sVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mlA = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void N(long j, long j2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int length = (int) fVar.getLength();
        if (this.sampleSize == this.mwR.length) {
            this.mwR = Arrays.copyOf(this.mwR, ((length != -1 ? length : this.mwR.length) * 3) / 2);
        }
        int read = fVar.read(this.mwR, this.sampleSize, this.mwR.length - this.sampleSize);
        if (read != -1) {
            this.sampleSize = read + this.sampleSize;
            if (length == -1 || this.sampleSize != length) {
                return 0;
            }
        }
        dxu();
        return -1;
    }

    private void dxu() throws ParserException {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(this.mwR);
        try {
            com.google.android.exoplayer2.text.g.h.ae(lVar);
            long j = 0;
            long j2 = 0;
            while (true) {
                String readLine = lVar.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                        Matcher matcher = mwO.matcher(readLine);
                        if (!matcher.find()) {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + readLine);
                        }
                        Matcher matcher2 = mwP.matcher(readLine);
                        if (!matcher2.find()) {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + readLine);
                        }
                        j2 = com.google.android.exoplayer2.text.g.h.Qk(matcher.group(1));
                        j = s.gK(Long.parseLong(matcher2.group(1)));
                    }
                } else {
                    Matcher af = com.google.android.exoplayer2.text.g.h.af(lVar);
                    if (af == null) {
                        gu(0L);
                        return;
                    }
                    long Qk = com.google.android.exoplayer2.text.g.h.Qk(af.group(1));
                    long gI = this.mjC.gI(s.gL((j + Qk) - j2));
                    com.google.android.exoplayer2.extractor.m gu = gu(gI - Qk);
                    this.mwQ.I(this.mwR, this.sampleSize);
                    gu.a(this.mwQ, this.sampleSize);
                    gu.a(gI, 1, this.sampleSize, 0, null);
                    return;
                }
            }
        } catch (SubtitleDecoderException e) {
            throw new ParserException(e);
        }
    }

    private com.google.android.exoplayer2.extractor.m gu(long j) {
        com.google.android.exoplayer2.extractor.m dK = this.mlA.dK(0, 3);
        dK.h(Format.a((String) null, "text/vtt", (String) null, -1, 0, this.language, (DrmInitData) null, j));
        this.mlA.duV();
        return dK;
    }
}
