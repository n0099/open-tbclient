package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.manifest.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class g {
    public final String baseUrl;
    public final Format lYQ;
    public final String mun;
    public final long muw;
    public final long mux;
    public final List<d> muy;
    private final f muz;

    public abstract f dvP();

    public abstract com.google.android.exoplayer2.source.dash.d dvQ();

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
        this.mun = str;
        this.muw = j;
        this.lYQ = format;
        this.baseUrl = str2;
        this.muy = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.muz = hVar.a(this);
        this.mux = hVar.dvR();
    }

    public f dvO() {
        return this.muz;
    }

    /* loaded from: classes5.dex */
    public static class b extends g {
        private final String cacheKey;
        public final long contentLength;
        private final f muB;
        private final i muC;
        public final Uri uri;

        public b(String str, long j, Format format, String str2, h.e eVar, List<d> list, String str3, long j2) {
            super(str, j, format, str2, eVar, list);
            this.uri = Uri.parse(str2);
            this.muB = eVar.dvS();
            this.cacheKey = str3 == null ? str != null ? str + "." + format.id + "." + j : null : str3;
            this.contentLength = j2;
            this.muC = this.muB != null ? null : new i(new f(null, 0L, j2));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f dvP() {
            return this.muB;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d dvQ() {
            return this.muC;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return this.cacheKey;
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends g implements com.google.android.exoplayer2.source.dash.d {
        private final h.a muA;

        public a(String str, long j, Format format, String str2, h.a aVar, List<d> list) {
            super(str, j, format, str2, aVar, list);
            this.muA = aVar;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f dvP() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d dvQ() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public f KR(int i) {
            return this.muA.a(this, i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int U(long j, long j2) {
            return this.muA.U(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long KQ(int i) {
            return this.muA.KZ(i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long G(int i, long j) {
            return this.muA.H(i, j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int dvL() {
            return this.muA.dvL();
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int gs(long j) {
            return this.muA.gs(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public boolean dvM() {
            return this.muA.dvM();
        }
    }
}
