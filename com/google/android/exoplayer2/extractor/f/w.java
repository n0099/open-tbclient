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

        SparseArray<w> dvw();
    }

    void a(com.google.android.exoplayer2.util.l lVar, boolean z) throws ParserException;

    void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, d dVar);

    void czd();

    /* loaded from: classes6.dex */
    public static final class b {
        public final String language;
        public final List<a> mpb;
        public final byte[] mpc;
        public final int streamType;

        public b(int i, String str, List<a> list, byte[] bArr) {
            this.streamType = i;
            this.language = str;
            this.mpb = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.mpc = bArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public final String language;
        public final byte[] mpa;
        public final int type;

        public a(String str, int i, byte[] bArr) {
            this.language = str;
            this.type = i;
            this.mpa = bArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        private String mmI;
        private final String mpd;
        private final int mpe;
        private final int mpf;
        private int mpg;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            this.mpd = i != Integer.MIN_VALUE ? i + "/" : "";
            this.mpe = i2;
            this.mpf = i3;
            this.mpg = Integer.MIN_VALUE;
        }

        public void dvE() {
            this.mpg = this.mpg == Integer.MIN_VALUE ? this.mpe : this.mpg + this.mpf;
            this.mmI = this.mpd + this.mpg;
        }

        public int dvF() {
            dvH();
            return this.mpg;
        }

        public String dvG() {
            dvH();
            return this.mmI;
        }

        private void dvH() {
            if (this.mpg == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }
}
