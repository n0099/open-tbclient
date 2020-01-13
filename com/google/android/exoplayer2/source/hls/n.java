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
/* loaded from: classes5.dex */
final class n implements com.google.android.exoplayer2.extractor.e {
    private static final Pattern mvQ = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern mvR = Pattern.compile("MPEGTS:(\\d+)");
    private final String language;
    private final s miE;
    private com.google.android.exoplayer2.extractor.g mkC;
    private final com.google.android.exoplayer2.util.l mvS = new com.google.android.exoplayer2.util.l();
    private byte[] mvT = new byte[1024];
    private int sampleSize;

    public n(String str, s sVar) {
        this.language = str;
        this.miE = sVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mkC = gVar;
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
        if (this.sampleSize == this.mvT.length) {
            this.mvT = Arrays.copyOf(this.mvT, ((length != -1 ? length : this.mvT.length) * 3) / 2);
        }
        int read = fVar.read(this.mvT, this.sampleSize, this.mvT.length - this.sampleSize);
        if (read != -1) {
            this.sampleSize = read + this.sampleSize;
            if (length == -1 || this.sampleSize != length) {
                return 0;
            }
        }
        dwf();
        return -1;
    }

    private void dwf() throws ParserException {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(this.mvT);
        try {
            com.google.android.exoplayer2.text.g.h.ae(lVar);
            long j = 0;
            long j2 = 0;
            while (true) {
                String readLine = lVar.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                        Matcher matcher = mvQ.matcher(readLine);
                        if (!matcher.find()) {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + readLine);
                        }
                        Matcher matcher2 = mvR.matcher(readLine);
                        if (!matcher2.find()) {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + readLine);
                        }
                        j2 = com.google.android.exoplayer2.text.g.h.PW(matcher.group(1));
                        j = s.gM(Long.parseLong(matcher2.group(1)));
                    }
                } else {
                    Matcher af = com.google.android.exoplayer2.text.g.h.af(lVar);
                    if (af == null) {
                        gw(0L);
                        return;
                    }
                    long PW = com.google.android.exoplayer2.text.g.h.PW(af.group(1));
                    long gK = this.miE.gK(s.gN((j + PW) - j2));
                    com.google.android.exoplayer2.extractor.m gw = gw(gK - PW);
                    this.mvS.G(this.mvT, this.sampleSize);
                    gw.a(this.mvS, this.sampleSize);
                    gw.a(gK, 1, this.sampleSize, 0, null);
                    return;
                }
            }
        } catch (SubtitleDecoderException e) {
            throw new ParserException(e);
        }
    }

    private com.google.android.exoplayer2.extractor.m gw(long j) {
        com.google.android.exoplayer2.extractor.m dH = this.mkC.dH(0, 3);
        dH.h(Format.a((String) null, "text/vtt", (String) null, -1, 0, this.language, (DrmInitData) null, j));
        this.mkC.dtF();
        return dH;
    }
}
