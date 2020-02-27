package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.manifest.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class g {
    public final String baseUrl;
    public final Format lZw;
    public final String muT;
    public final long mvc;
    public final long mvd;
    public final List<d> mve;
    private final f mvf;

    public abstract f dwZ();

    public abstract com.google.android.exoplayer2.source.dash.d dxa();

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
        this.muT = str;
        this.mvc = j;
        this.lZw = format;
        this.baseUrl = str2;
        this.mve = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.mvf = hVar.a(this);
        this.mvd = hVar.dxb();
    }

    public f dwY() {
        return this.mvf;
    }

    /* loaded from: classes6.dex */
    public static class b extends g {
        private final String cacheKey;
        public final long contentLength;
        private final f mvh;
        private final i mvi;
        public final Uri uri;

        public b(String str, long j, Format format, String str2, h.e eVar, List<d> list, String str3, long j2) {
            super(str, j, format, str2, eVar, list);
            this.uri = Uri.parse(str2);
            this.mvh = eVar.dxc();
            this.cacheKey = str3 == null ? str != null ? str + "." + format.id + "." + j : null : str3;
            this.contentLength = j2;
            this.mvi = this.mvh != null ? null : new i(new f(null, 0L, j2));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f dwZ() {
            return this.mvh;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d dxa() {
            return this.mvi;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return this.cacheKey;
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends g implements com.google.android.exoplayer2.source.dash.d {
        private final h.a mvg;

        public a(String str, long j, Format format, String str2, h.a aVar, List<d> list) {
            super(str, j, format, str2, aVar, list);
            this.mvg = aVar;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f dwZ() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d dxa() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public f KW(int i) {
            return this.mvg.a(this, i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int T(long j, long j2) {
            return this.mvg.T(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long KV(int i) {
            return this.mvg.Le(i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long F(int i, long j) {
            return this.mvg.G(i, j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int dwV() {
            return this.mvg.dwV();
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int gq(long j) {
            return this.mvg.gq(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public boolean dwW() {
            return this.mvg.dwW();
        }
    }
}
