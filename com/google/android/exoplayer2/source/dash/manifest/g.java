package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.manifest.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class g {
    public final Format lUU;
    public final long mqC;
    public final long mqD;
    public final List<d> mqE;
    private final f mqF;
    public final String mqs;
    public final String mqu;

    public abstract f duC();

    public abstract com.google.android.exoplayer2.source.dash.d duD();

    public abstract String getCacheKey();

    public static g a(String str, long j, Format format, String str2, h hVar, List<d> list) {
        return a(str, j, format, str2, hVar, list, null);
    }

    public static g a(String str, long j, Format format, String str2, h hVar, List<d> list, String str3) {
        if (hVar instanceof h.e) {
            return new b(str, j, format, str2, (h.e) hVar, list, str3, -1L);
        }
        if (hVar instanceof h.a) {
            return new a(str, j, format, str2, (h.a) hVar, list);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    private g(String str, long j, Format format, String str2, h hVar, List<d> list) {
        this.mqs = str;
        this.mqC = j;
        this.lUU = format;
        this.mqu = str2;
        this.mqE = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.mqF = hVar.a(this);
        this.mqD = hVar.duE();
    }

    public f duB() {
        return this.mqF;
    }

    /* loaded from: classes4.dex */
    public static class b extends g {
        private final String cacheKey;
        public final long contentLength;
        private final f mqH;
        private final i mqI;
        public final Uri uri;

        public b(String str, long j, Format format, String str2, h.e eVar, List<d> list, String str3, long j2) {
            super(str, j, format, str2, eVar, list);
            this.uri = Uri.parse(str2);
            this.mqH = eVar.duF();
            this.cacheKey = str3 == null ? str != null ? str + "." + format.id + "." + j : null : str3;
            this.contentLength = j2;
            this.mqI = this.mqH != null ? null : new i(new f(null, 0L, j2));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f duC() {
            return this.mqH;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d duD() {
            return this.mqI;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return this.cacheKey;
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends g implements com.google.android.exoplayer2.source.dash.d {
        private final h.a mqG;

        public a(String str, long j, Format format, String str2, h.a aVar, List<d> list) {
            super(str, j, format, str2, aVar, list);
            this.mqG = aVar;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f duC() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d duD() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public f KI(int i) {
            return this.mqG.a(this, i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int U(long j, long j2) {
            return this.mqG.U(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long KH(int i) {
            return this.mqG.KQ(i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long G(int i, long j) {
            return this.mqG.H(i, j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int duy() {
            return this.mqG.duy();
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int gn(long j) {
            return this.mqG.gn(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public boolean duz() {
            return this.mqG.duz();
        }
    }
}
