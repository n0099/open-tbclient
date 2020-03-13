package com.google.android.exoplayer2.extractor.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public interface w {

    /* loaded from: classes6.dex */
    public interface c {
        w a(int i, b bVar);

        SparseArray<w> dvx();
    }

    void a(com.google.android.exoplayer2.util.l lVar, boolean z) throws ParserException;

    void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, d dVar);

    void cze();

    /* loaded from: classes6.dex */
    public static final class b {
        public final String language;
        public final List<a> mpm;
        public final byte[] mpn;
        public final int streamType;

        public b(int i, String str, List<a> list, byte[] bArr) {
            this.streamType = i;
            this.language = str;
            this.mpm = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.mpn = bArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public final String language;
        public final byte[] mpl;
        public final int type;

        public a(String str, int i, byte[] bArr) {
            this.language = str;
            this.type = i;
            this.mpl = bArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        private String mmT;
        private final String mpo;
        private final int mpp;
        private final int mpq;
        private int mpr;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            this.mpo = i != Integer.MIN_VALUE ? i + "/" : "";
            this.mpp = i2;
            this.mpq = i3;
            this.mpr = Integer.MIN_VALUE;
        }

        public void dvF() {
            this.mpr = this.mpr == Integer.MIN_VALUE ? this.mpp : this.mpr + this.mpq;
            this.mmT = this.mpo + this.mpr;
        }

        public int dvG() {
            dvI();
            return this.mpr;
        }

        public String dvH() {
            dvI();
            return this.mmT;
        }

        private void dvI() {
            if (this.mpr == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }
}
