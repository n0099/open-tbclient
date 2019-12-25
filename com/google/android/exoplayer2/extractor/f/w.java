package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public interface w {

    /* loaded from: classes4.dex */
    public interface c {
        w a(int i, b bVar);

        SparseArray<w> dsV();
    }

    void a(com.google.android.exoplayer2.util.l lVar, boolean z) throws ParserException;

    void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, d dVar);

    void cwy();

    /* loaded from: classes4.dex */
    public static final class b {
        public final String language;
        public final byte[] mkA;
        public final List<a> mkz;
        public final int streamType;

        public b(int i, String str, List<a> list, byte[] bArr) {
            this.streamType = i;
            this.language = str;
            this.mkz = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.mkA = bArr;
        }
    }

    /* loaded from: classes4.dex */
    public static final class a {
        public final String language;
        public final byte[] mky;
        public final int type;

        public a(String str, int i, byte[] bArr) {
            this.language = str;
            this.type = i;
            this.mky = bArr;
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {
        private String mig;
        private final String mkB;
        private final int mkC;
        private final int mkD;
        private int mkE;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            this.mkB = i != Integer.MIN_VALUE ? i + "/" : "";
            this.mkC = i2;
            this.mkD = i3;
            this.mkE = Integer.MIN_VALUE;
        }

        public void dte() {
            this.mkE = this.mkE == Integer.MIN_VALUE ? this.mkC : this.mkE + this.mkD;
            this.mig = this.mkB + this.mkE;
        }

        public int dtf() {
            dth();
            return this.mkE;
        }

        public String dtg() {
            dth();
            return this.mig;
        }

        private void dth() {
            if (this.mkE == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }
}
