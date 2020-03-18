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

        SparseArray<w> dvU();
    }

    void a(com.google.android.exoplayer2.util.l lVar, boolean z) throws ParserException;

    void a(com.google.android.exoplayer2.util.s sVar, com.google.android.exoplayer2.extractor.g gVar, d dVar);

    void czx();

    /* loaded from: classes6.dex */
    public static final class b {
        public final String language;
        public final List<a> mqS;
        public final byte[] mqT;
        public final int streamType;

        public b(int i, String str, List<a> list, byte[] bArr) {
            this.streamType = i;
            this.language = str;
            this.mqS = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.mqT = bArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public final String language;
        public final byte[] mqR;
        public final int type;

        public a(String str, int i, byte[] bArr) {
            this.language = str;
            this.type = i;
            this.mqR = bArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        private String moA;
        private final String mqU;
        private final int mqV;
        private final int mqW;
        private int mqX;

        public d(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            this.mqU = i != Integer.MIN_VALUE ? i + "/" : "";
            this.mqV = i2;
            this.mqW = i3;
            this.mqX = Integer.MIN_VALUE;
        }

        public void dwc() {
            this.mqX = this.mqX == Integer.MIN_VALUE ? this.mqV : this.mqX + this.mqW;
            this.moA = this.mqU + this.mqX;
        }

        public int dwd() {
            dwf();
            return this.mqX;
        }

        public String dwe() {
            dwf();
            return this.moA;
        }

        private void dwf() {
            if (this.mqX == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }
}
