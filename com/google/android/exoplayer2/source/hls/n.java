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
/* loaded from: classes4.dex */
final class n implements com.google.android.exoplayer2.extractor.e {
    private static final Pattern msb = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern msc = Pattern.compile("MPEGTS:(\\d+)");
    private final String language;
    private final s meN;
    private com.google.android.exoplayer2.extractor.g mgL;
    private final com.google.android.exoplayer2.util.l msd = new com.google.android.exoplayer2.util.l();
    private byte[] mse = new byte[1024];
    private int sampleSize;

    public n(String str, s sVar) {
        this.language = str;
        this.meN = sVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mgL = gVar;
        gVar.a(new l.a(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void O(long j, long j2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public int a(com.google.android.exoplayer2.extractor.f fVar, com.google.android.exoplayer2.extractor.k kVar) throws IOException, InterruptedException {
        int length = (int) fVar.getLength();
        if (this.sampleSize == this.mse.length) {
            this.mse = Arrays.copyOf(this.mse, ((length != -1 ? length : this.mse.length) * 3) / 2);
        }
        int read = fVar.read(this.mse, this.sampleSize, this.mse.length - this.sampleSize);
        if (read != -1) {
            this.sampleSize = read + this.sampleSize;
            if (length == -1 || this.sampleSize != length) {
                return 0;
            }
        }
        duU();
        return -1;
    }

    private void duU() throws ParserException {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(this.mse);
        try {
            com.google.android.exoplayer2.text.g.h.ae(lVar);
            long j = 0;
            long j2 = 0;
            while (true) {
                String readLine = lVar.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                        Matcher matcher = msb.matcher(readLine);
                        if (!matcher.find()) {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + readLine);
                        }
                        Matcher matcher2 = msc.matcher(readLine);
                        if (!matcher2.find()) {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + readLine);
                        }
                        j2 = com.google.android.exoplayer2.text.g.h.PL(matcher.group(1));
                        j = s.gH(Long.parseLong(matcher2.group(1)));
                    }
                } else {
                    Matcher af = com.google.android.exoplayer2.text.g.h.af(lVar);
                    if (af == null) {
                        gr(0L);
                        return;
                    }
                    long PL = com.google.android.exoplayer2.text.g.h.PL(af.group(1));
                    long gF = this.meN.gF(s.gI((j + PL) - j2));
                    com.google.android.exoplayer2.extractor.m gr = gr(gF - PL);
                    this.msd.G(this.mse, this.sampleSize);
                    gr.a(this.msd, this.sampleSize);
                    gr.a(gF, 1, this.sampleSize, 0, null);
                    return;
                }
            }
        } catch (SubtitleDecoderException e) {
            throw new ParserException(e);
        }
    }

    private com.google.android.exoplayer2.extractor.m gr(long j) {
        com.google.android.exoplayer2.extractor.m dJ = this.mgL.dJ(0, 3);
        dJ.h(Format.a((String) null, "text/vtt", (String) null, -1, 0, this.language, (DrmInitData) null, j));
        this.mgL.dst();
        return dJ;
    }
}
