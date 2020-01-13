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

        SparseArray<w> duh();
    }

    void a(com.google.android.exoplayer2.util.l lVar, boolean z) throws ParserException;

    void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, d dVar);

    void cxF();

    /* loaded from: classes5.dex */
    public static final class b {
        public final String language;
        public final List<a> moo;
        public final byte[] mop;
        public final int streamType;

        public b(int i, String str, List<a> list, byte[] bArr) {
            this.streamType = i;
            this.language = str;
            this.moo = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.mop = bArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public final String language;
        public final byte[] mom;
        public final int type;

        public a(String str, int i, byte[] bArr) {
            this.language = str;
            this.type = i;
            this.mom = bArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        private String mlV;
        private final String moq;
        private final int mor;
        private final int mos;
        private int mot;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            this.moq = i != Integer.MIN_VALUE ? i + "/" : "";
            this.mor = i2;
            this.mos = i3;
            this.mot = Integer.MIN_VALUE;
        }

        public void dup() {
            this.mot = this.mot == Integer.MIN_VALUE ? this.mor : this.mot + this.mos;
            this.mlV = this.moq + this.mot;
        }

        public int duq() {
            dus();
            return this.mot;
        }

        public String dur() {
            dus();
            return this.mlV;
        }

        private void dus() {
            if (this.mot == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }
}
