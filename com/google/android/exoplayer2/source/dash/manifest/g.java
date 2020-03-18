package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.manifest.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class g {
    public final String baseUrl;
    public final Format mbs;
    public final String mwM;
    public final long mwV;
    public final long mwW;
    public final List<d> mwX;
    private final f mwY;

    public abstract com.google.android.exoplayer2.source.dash.d dxA();

    public abstract f dxz();

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
        this.mwM = str;
        this.mwV = j;
        this.mbs = format;
        this.baseUrl = str2;
        this.mwX = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.mwY = hVar.a(this);
        this.mwW = hVar.dxB();
    }

    public f dxy() {
        return this.mwY;
    }

    /* loaded from: classes6.dex */
    public static class b extends g {
        private final String cacheKey;
        public final long contentLength;
        private final f mxa;
        private final i mxb;
        public final Uri uri;

        public b(String str, long j, Format format, String str2, h.e eVar, List<d> list, String str3, long j2) {
            super(str, j, format, str2, eVar, list);
            this.uri = Uri.parse(str2);
            this.mxa = eVar.dxC();
            this.cacheKey = str3 == null ? str != null ? str + "." + format.id + "." + j : null : str3;
            this.contentLength = j2;
            this.mxb = this.mxa != null ? null : new i(new f(null, 0L, j2));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f dxz() {
            return this.mxa;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d dxA() {
            return this.mxb;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return this.cacheKey;
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends g implements com.google.android.exoplayer2.source.dash.d {
        private final h.a mwZ;

        public a(String str, long j, Format format, String str2, h.a aVar, List<d> list) {
            super(str, j, format, str2, aVar, list);
            this.mwZ = aVar;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f dxz() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d dxA() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public f Lc(int i) {
            return this.mwZ.a(this, i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int T(long j, long j2) {
            return this.mwZ.T(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long Lb(int i) {
            return this.mwZ.Lk(i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long F(int i, long j) {
            return this.mwZ.G(i, j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int dxv() {
            return this.mwZ.dxv();
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int gr(long j) {
            return this.mwZ.gr(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public boolean dxw() {
            return this.mwZ.dxw();
        }
    }
}
