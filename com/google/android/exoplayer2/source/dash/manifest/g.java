package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.manifest.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class g {
    public final String baseUrl;
    public final Format lZy;
    public final String muV;
    public final long mve;
    public final long mvf;
    public final List<d> mvg;
    private final f mvh;

    public abstract f dxb();

    public abstract com.google.android.exoplayer2.source.dash.d dxc();

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
        this.muV = str;
        this.mve = j;
        this.lZy = format;
        this.baseUrl = str2;
        this.mvg = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.mvh = hVar.a(this);
        this.mvf = hVar.dxd();
    }

    public f dxa() {
        return this.mvh;
    }

    /* loaded from: classes6.dex */
    public static class b extends g {
        private final String cacheKey;
        public final long contentLength;
        private final f mvj;
        private final i mvk;
        public final Uri uri;

        public b(String str, long j, Format format, String str2, h.e eVar, List<d> list, String str3, long j2) {
            super(str, j, format, str2, eVar, list);
            this.uri = Uri.parse(str2);
            this.mvj = eVar.dxe();
            this.cacheKey = str3 == null ? str != null ? str + "." + format.id + "." + j : null : str3;
            this.contentLength = j2;
            this.mvk = this.mvj != null ? null : new i(new f(null, 0L, j2));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f dxb() {
            return this.mvj;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d dxc() {
            return this.mvk;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return this.cacheKey;
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends g implements com.google.android.exoplayer2.source.dash.d {
        private final h.a mvi;

        public a(String str, long j, Format format, String str2, h.a aVar, List<d> list) {
            super(str, j, format, str2, aVar, list);
            this.mvi = aVar;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public f dxb() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public com.google.android.exoplayer2.source.dash.d dxc() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.g
        public String getCacheKey() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public f KW(int i) {
            return this.mvi.a(this, i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int T(long j, long j2) {
            return this.mvi.T(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long KV(int i) {
            return this.mvi.Le(i);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public long F(int i, long j) {
            return this.mvi.G(i, j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int dwX() {
            return this.mvi.dwX();
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public int gq(long j) {
            return this.mvi.gq(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d
        public boolean dwY() {
            return this.mvi.dwY();
        }
    }
}
