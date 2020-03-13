package com.google.android.exoplayer2.extractor.g;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
final class c {
    public static b D(f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkNotNull(fVar);
        l lVar = new l(16);
        if (a.a(fVar, lVar).id != v.QF("RIFF")) {
            return null;
        }
        fVar.s(lVar.data, 0, 4);
        lVar.setPosition(0);
        int readInt = lVar.readInt();
        if (readInt != v.QF("WAVE")) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + readInt);
            return null;
        }
        a a2 = a.a(fVar, lVar);
        while (a2.id != v.QF("fmt ")) {
            fVar.Jw((int) a2.size);
            a2 = a.a(fVar, lVar);
        }
        com.google.android.exoplayer2.util.a.checkState(a2.size >= 16);
        fVar.s(lVar.data, 0, 16);
        lVar.setPosition(0);
        int dzx = lVar.dzx();
        int dzx2 = lVar.dzx();
        int dzG = lVar.dzG();
        int dzG2 = lVar.dzG();
        int dzx3 = lVar.dzx();
        int dzx4 = lVar.dzx();
        int i = (dzx2 * dzx4) / 8;
        if (dzx3 != i) {
            throw new ParserException("Expected block alignment: " + i + "; got: " + dzx3);
        }
        int LZ = v.LZ(dzx4);
        if (LZ == 0) {
            Log.e("WavHeaderReader", "Unsupported WAV bit depth: " + dzx4);
            return null;
        } else if (dzx != 1 && dzx != 65534) {
            Log.e("WavHeaderReader", "Unsupported WAV format type: " + dzx);
            return null;
        } else {
            fVar.Jw(((int) a2.size) - 16);
            return new b(dzx2, dzG, dzG2, dzx3, dzx4, LZ);
        }
    }

    public static void a(f fVar, b bVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.util.a.checkNotNull(fVar);
        com.google.android.exoplayer2.util.a.checkNotNull(bVar);
        fVar.duS();
        l lVar = new l(8);
        a a2 = a.a(fVar, lVar);
        while (a2.id != v.QF("data")) {
            Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + a2.id);
            long j = 8 + a2.size;
            if (a2.id == v.QF("RIFF")) {
                j = 12;
            }
            if (j > 2147483647L) {
                throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + a2.id);
            }
            fVar.Jv((int) j);
            a2 = a.a(fVar, lVar);
        }
        fVar.Jv(8);
        bVar.P(fVar.getPosition(), a2.size);
    }

    /* loaded from: classes6.dex */
    private static final class a {
        public final int id;
        public final long size;

        private a(int i, long j) {
            this.id = i;
            this.size = j;
        }

        public static a a(f fVar, l lVar) throws IOException, InterruptedException {
            fVar.s(lVar.data, 0, 8);
            lVar.setPosition(0);
            return new a(lVar.readInt(), lVar.dzA());
        }
    }
}
