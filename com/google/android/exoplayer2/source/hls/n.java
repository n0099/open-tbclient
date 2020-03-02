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
    private static final Pattern mwD = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern mwE = Pattern.compile("MPEGTS:(\\d+)");
    private final String language;
    private final s mjr;
    private com.google.android.exoplayer2.extractor.g mlp;
    private final com.google.android.exoplayer2.util.l mwF = new com.google.android.exoplayer2.util.l();
    private byte[] mwG = new byte[1024];
    private int sampleSize;

    public n(String str, s sVar) {
        this.language = str;
        this.mjr = sVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mlp = gVar;
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
        if (this.sampleSize == this.mwG.length) {
            this.mwG = Arrays.copyOf(this.mwG, ((length != -1 ? length : this.mwG.length) * 3) / 2);
        }
        int read = fVar.read(this.mwG, this.sampleSize, this.mwG.length - this.sampleSize);
        if (read != -1) {
            this.sampleSize = read + this.sampleSize;
            if (length == -1 || this.sampleSize != length) {
                return 0;
            }
        }
        dxt();
        return -1;
    }

    private void dxt() throws ParserException {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(this.mwG);
        try {
            com.google.android.exoplayer2.text.g.h.ae(lVar);
            long j = 0;
            long j2 = 0;
            while (true) {
                String readLine = lVar.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                        Matcher matcher = mwD.matcher(readLine);
                        if (!matcher.find()) {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + readLine);
                        }
                        Matcher matcher2 = mwE.matcher(readLine);
                        if (!matcher2.find()) {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + readLine);
                        }
                        j2 = com.google.android.exoplayer2.text.g.h.Qj(matcher.group(1));
                        j = s.gK(Long.parseLong(matcher2.group(1)));
                    }
                } else {
                    Matcher af = com.google.android.exoplayer2.text.g.h.af(lVar);
                    if (af == null) {
                        gu(0L);
                        return;
                    }
                    long Qj = com.google.android.exoplayer2.text.g.h.Qj(af.group(1));
                    long gI = this.mjr.gI(s.gL((j + Qj) - j2));
                    com.google.android.exoplayer2.extractor.m gu = gu(gI - Qj);
                    this.mwF.I(this.mwG, this.sampleSize);
                    gu.a(this.mwF, this.sampleSize);
                    gu.a(gI, 1, this.sampleSize, 0, null);
                    return;
                }
            }
        } catch (SubtitleDecoderException e) {
            throw new ParserException(e);
        }
    }

    private com.google.android.exoplayer2.extractor.m gu(long j) {
        com.google.android.exoplayer2.extractor.m dK = this.mlp.dK(0, 3);
        dK.h(Format.a((String) null, "text/vtt", (String) null, -1, 0, this.language, (DrmInitData) null, j));
        this.mlp.duU();
        return dK;
    }
}
