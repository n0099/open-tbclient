package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public interface w {

    /* loaded from: classes5.dex */
    public interface c {
        w a(int i, b bVar);

        SparseArray<w> duj();
    }

    void a(com.google.android.exoplayer2.util.l lVar, boolean z) throws ParserException;

    void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, d dVar);

    void cxH();

    /* loaded from: classes5.dex */
    public static final class b {
        public final String language;
        public final List<a> mot;
        public final byte[] mou;
        public final int streamType;

        public b(int i, String str, List<a> list, byte[] bArr) {
            this.streamType = i;
            this.language = str;
            this.mot = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.mou = bArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public final String language;
        public final byte[] mos;
        public final int type;

        public a(String str, int i, byte[] bArr) {
            this.language = str;
            this.type = i;
            this.mos = bArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        private String mma;
        private final String mov;
        private final int mow;
        private final int mox;
        private int moy;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            this.mov = i != Integer.MIN_VALUE ? i + "/" : "";
            this.mow = i2;
            this.mox = i3;
            this.moy = Integer.MIN_VALUE;
        }

        public void dur() {
            this.moy = this.moy == Integer.MIN_VALUE ? this.mow : this.moy + this.mox;
            this.mma = this.mov + this.moy;
        }

        public int dus() {
            duu();
            return this.moy;
        }

        public String dut() {
            duu();
            return this.mma;
        }

        private void duu() {
            if (this.moy == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }
}
