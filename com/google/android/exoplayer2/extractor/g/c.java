package com.google.android.exoplayer2.extractor.g;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes4.dex */
final class c {
    public static b D(f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkNotNull(fVar);
        l lVar = new l(16);
        if (a.a(fVar, lVar).id != v.Qg("RIFF")) {
            return null;
        }
        fVar.p(lVar.data, 0, 4);
        lVar.setPosition(0);
        int readInt = lVar.readInt();
        if (readInt != v.Qg("WAVE")) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + readInt);
            return null;
        }
        a a2 = a.a(fVar, lVar);
        while (a2.id != v.Qg("fmt ")) {
            fVar.Ji((int) a2.size);
            a2 = a.a(fVar, lVar);
        }
        com.google.android.exoplayer2.util.a.checkState(a2.size >= 16);
        fVar.p(lVar.data, 0, 16);
        lVar.setPosition(0);
        int dwY = lVar.dwY();
        int dwY2 = lVar.dwY();
        int dxh = lVar.dxh();
        int dxh2 = lVar.dxh();
        int dwY3 = lVar.dwY();
        int dwY4 = lVar.dwY();
        int i = (dwY2 * dwY4) / 8;
        if (dwY3 != i) {
            throw new ParserException("Expected block alignment: " + i + "; got: " + dwY3);
        }
        int LL = v.LL(dwY4);
        if (LL == 0) {
            Log.e("WavHeaderReader", "Unsupported WAV bit depth: " + dwY4);
            return null;
        } else if (dwY != 1 && dwY != 65534) {
            Log.e("WavHeaderReader", "Unsupported WAV format type: " + dwY);
            return null;
        } else {
            fVar.Ji(((int) a2.size) - 16);
            return new b(dwY2, dxh, dxh2, dwY3, dwY4, LL);
        }
    }

    public static void a(f fVar, b bVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkNotNull(fVar);
        com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        fVar.dsq();
        l lVar = new l(8);
        a a2 = a.a(fVar, lVar);
        while (a2.id != v.Qg("data")) {
            Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + a2.id);
            long j = 8 + a2.size;
            if (a2.id == v.Qg("RIFF")) {
                j = 12;
            }
            if (j > 2147483647L) {
                throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + a2.id);
            }
            fVar.Jh((int) j);
            a2 = a.a(fVar, lVar);
        }
        fVar.Jh(8);
        bVar.Q(fVar.getPosition(), a2.size);
    }

    /* loaded from: classes4.dex */
    private static final class a {
        public final int id;
        public final long size;

        private a(int i, long j) {
            this.id = i;
            this.size = j;
        }

        public static a a(f fVar, l lVar) throws IOException, InterruptedException {
            fVar.p(lVar.data, 0, 8);
            lVar.setPosition(0);
            return new a(lVar.readInt(), lVar.dxb());
        }
    }
}
