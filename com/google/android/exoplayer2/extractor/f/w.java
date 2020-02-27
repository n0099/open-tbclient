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

        SparseArray<w> dvu();
    }

    void a(com.google.android.exoplayer2.util.l lVar, boolean z) throws ParserException;

    void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, d dVar);

    void czb();

    /* loaded from: classes6.dex */
    public static final class b {
        public final String language;
        public final List<a> moZ;
        public final byte[] mpa;
        public final int streamType;

        public b(int i, String str, List<a> list, byte[] bArr) {
            this.streamType = i;
            this.language = str;
            this.moZ = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.mpa = bArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public final String language;
        public final byte[] moY;
        public final int type;

        public a(String str, int i, byte[] bArr) {
            this.language = str;
            this.type = i;
            this.moY = bArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        private String mmG;
        private final String mpb;
        private final int mpc;
        private final int mpd;
        private int mpe;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            this.mpb = i != Integer.MIN_VALUE ? i + "/" : "";
            this.mpc = i2;
            this.mpd = i3;
            this.mpe = Integer.MIN_VALUE;
        }

        public void dvC() {
            this.mpe = this.mpe == Integer.MIN_VALUE ? this.mpc : this.mpe + this.mpd;
            this.mmG = this.mpb + this.mpe;
        }

        public int dvD() {
            dvF();
            return this.mpe;
        }

        public String dvE() {
            dvF();
            return this.mmG;
        }

        private void dvF() {
            if (this.mpe == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }
}
