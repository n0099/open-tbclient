package com.google.android.exoplayer2.extractor.g;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes5.dex */
final class c {
    public static b D(f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkNotNull(fVar);
        l lVar = new l(16);
        if (a.a(fVar, lVar).id != v.Qr("RIFF")) {
            return null;
        }
        fVar.o(lVar.data, 0, 4);
        lVar.setPosition(0);
        int readInt = lVar.readInt();
        if (readInt != v.Qr("WAVE")) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + readInt);
            return null;
        }
        a a2 = a.a(fVar, lVar);
        while (a2.id != v.Qr("fmt ")) {
            fVar.Jr((int) a2.size);
            a2 = a.a(fVar, lVar);
        }
        com.google.android.exoplayer2.util.a.checkState(a2.size >= 16);
        fVar.o(lVar.data, 0, 16);
        lVar.setPosition(0);
        int dyk = lVar.dyk();
        int dyk2 = lVar.dyk();
        int dyt = lVar.dyt();
        int dyt2 = lVar.dyt();
        int dyk3 = lVar.dyk();
        int dyk4 = lVar.dyk();
        int i = (dyk2 * dyk4) / 8;
        if (dyk3 != i) {
            throw new ParserException("Expected block alignment: " + i + "; got: " + dyk3);
        }
        int LU = v.LU(dyk4);
        if (LU == 0) {
            Log.e("WavHeaderReader", "Unsupported WAV bit depth: " + dyk4);
            return null;
        } else if (dyk != 1 && dyk != 65534) {
            Log.e("WavHeaderReader", "Unsupported WAV format type: " + dyk);
            return null;
        } else {
            fVar.Jr(((int) a2.size) - 16);
            return new b(dyk2, dyt, dyt2, dyk3, dyk4, LU);
        }
    }

    public static void a(f fVar, b bVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkNotNull(fVar);
        com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        fVar.dtE();
        l lVar = new l(8);
        a a2 = a.a(fVar, lVar);
        while (a2.id != v.Qr("data")) {
            Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + a2.id);
            long j = 8 + a2.size;
            if (a2.id == v.Qr("RIFF")) {
                j = 12;
            }
            if (j > 2147483647L) {
                throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + a2.id);
            }
            fVar.Jq((int) j);
            a2 = a.a(fVar, lVar);
        }
        fVar.Jq(8);
        bVar.Q(fVar.getPosition(), a2.size);
    }

    /* loaded from: classes5.dex */
    private static final class a {
        public final int id;
        public final long size;

        private a(int i, long j) {
            this.id = i;
            this.size = j;
        }

        public static a a(f fVar, l lVar) throws IOException, InterruptedException {
            fVar.o(lVar.data, 0, 8);
            lVar.setPosition(0);
            return new a(lVar.readInt(), lVar.dyn());
        }
    }
}
