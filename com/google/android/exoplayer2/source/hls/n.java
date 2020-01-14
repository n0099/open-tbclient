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
    private static final Pattern mvV = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern mvW = Pattern.compile("MPEGTS:(\\d+)");
    private final String language;
    private final s miJ;
    private com.google.android.exoplayer2.extractor.g mkH;
    private final com.google.android.exoplayer2.util.l mvX = new com.google.android.exoplayer2.util.l();
    private byte[] mvY = new byte[1024];
    private int sampleSize;

    public n(String str, s sVar) {
        this.language = str;
        this.miJ = sVar;
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public boolean a(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.e
    public void a(com.google.android.exoplayer2.extractor.g gVar) {
        this.mkH = gVar;
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
        if (this.sampleSize == this.mvY.length) {
            this.mvY = Arrays.copyOf(this.mvY, ((length != -1 ? length : this.mvY.length) * 3) / 2);
        }
        int read = fVar.read(this.mvY, this.sampleSize, this.mvY.length - this.sampleSize);
        if (read != -1) {
            this.sampleSize = read + this.sampleSize;
            if (length == -1 || this.sampleSize != length) {
                return 0;
            }
        }
        dwh();
        return -1;
    }

    private void dwh() throws ParserException {
        com.google.android.exoplayer2.util.l lVar = new com.google.android.exoplayer2.util.l(this.mvY);
        try {
            com.google.android.exoplayer2.text.g.h.ae(lVar);
            long j = 0;
            long j2 = 0;
            while (true) {
                String readLine = lVar.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                        Matcher matcher = mvV.matcher(readLine);
                        if (!matcher.find()) {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + readLine);
                        }
                        Matcher matcher2 = mvW.matcher(readLine);
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
                    long gK = this.miJ.gK(s.gN((j + PW) - j2));
                    com.google.android.exoplayer2.extractor.m gw = gw(gK - PW);
                    this.mvX.G(this.mvY, this.sampleSize);
                    gw.a(this.mvX, this.sampleSize);
                    gw.a(gK, 1, this.sampleSize, 0, null);
                    return;
                }
            }
        } catch (SubtitleDecoderException e) {
            throw new ParserException(e);
        }
    }

    private com.google.android.exoplayer2.extractor.m gw(long j) {
        com.google.android.exoplayer2.extractor.m dH = this.mkH.dH(0, 3);
        dH.h(Format.a((String) null, "text/vtt", (String) null, -1, 0, this.language, (DrmInitData) null, j));
        this.mkH.dtH();
        return dH;
    }
}
