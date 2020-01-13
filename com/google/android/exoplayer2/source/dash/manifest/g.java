package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.manifest.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class g {
    public final String baseUrl;
    public final Format lYL;
    public final String mui;
    public final long mur;
    public final long mus;
    public final List<d> mut;
    private final f muu;

    public abstract f dvN();

    public abstract com.google.android.exoplayer2.source.dash.d dvO();

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
        this.mui = str;
        this.mur = j;
        this.lYL = format;
        this.baseUrl = str2;
        this.mut = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.muu = hVar.a(this);
        this.mus = hVar.dvP();
    }

    public f dvM() {
        return this.muu;
    }

    /* loaded from: classes5.dex */
    public static class b extends g {
        private final String cacheKey;
        public final long contentLength;
        private final f muw;
        private final i mux;
        public final Uri uri;

        public b(String str, long j, Format format, String str2, h.e eVar, List<d> list, String str3, long j2) {
            super(str, j, format, str2, eVar, list);
            this.uri = Uri.parse(str2);
            this.muw = eVar.dvQ();
            this.cacheKey = str3 == null ? str != null ? str + "." + format.id + "." + j : null : str3;
            this.contentLength = j2;
            this.mux = this.muw != null ? null : new i(new f(null, 0L, j2));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f dvN() {
            return this.muw;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d dvO() {
            return this.mux;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return this.cacheKey;
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends g implements com.google.android.exoplayer2.source.dash.d {
        private final h.a muv;

        public a(String str, long j, Format format, String str2, h.a aVar, List<d> list) {
            super(str, j, format, str2, aVar, list);
            this.muv = aVar;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f dvN() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d dvO() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public f KR(int i) {
            return this.muv.a(this, i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int U(long j, long j2) {
            return this.muv.U(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long KQ(int i) {
            return this.muv.KZ(i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long G(int i, long j) {
            return this.muv.H(i, j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int dvJ() {
            return this.muv.dvJ();
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int gs(long j) {
            return this.muv.gs(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public boolean dvK() {
            return this.muv.dvK();
        }
    }
}
