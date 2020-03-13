package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.manifest.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class g {
    public final String baseUrl;
    public final Format lZJ;
    public final String mvg;
    public final long mvp;
    public final long mvq;
    public final List<d> mvr;
    private final f mvs;

    public abstract f dxc();

    public abstract com.google.android.exoplayer2.source.dash.d dxd();

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
        this.mvg = str;
        this.mvp = j;
        this.lZJ = format;
        this.baseUrl = str2;
        this.mvr = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.mvs = hVar.a(this);
        this.mvq = hVar.dxe();
    }

    public f dxb() {
        return this.mvs;
    }

    /* loaded from: classes6.dex */
    public static class b extends g {
        private final String cacheKey;
        public final long contentLength;
        private final f mvu;
        private final i mvv;
        public final Uri uri;

        public b(String str, long j, Format format, String str2, h.e eVar, List<d> list, String str3, long j2) {
            super(str, j, format, str2, eVar, list);
            this.uri = Uri.parse(str2);
            this.mvu = eVar.dxf();
            this.cacheKey = str3 == null ? str != null ? str + "." + format.id + "." + j : null : str3;
            this.contentLength = j2;
            this.mvv = this.mvu != null ? null : new i(new f(null, 0L, j2));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f dxc() {
            return this.mvu;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d dxd() {
            return this.mvv;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return this.cacheKey;
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends g implements com.google.android.exoplayer2.source.dash.d {
        private final h.a mvt;

        public a(String str, long j, Format format, String str2, h.a aVar, List<d> list) {
            super(str, j, format, str2, aVar, list);
            this.mvt = aVar;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f dxc() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d dxd() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public f KW(int i) {
            return this.mvt.a(this, i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int T(long j, long j2) {
            return this.mvt.T(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long KV(int i) {
            return this.mvt.Le(i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long F(int i, long j) {
            return this.mvt.G(i, j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int dwY() {
            return this.mvt.dwY();
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int gq(long j) {
            return this.mvt.gq(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public boolean dwZ() {
            return this.mvt.dwZ();
        }
    }
}
