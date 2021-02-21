package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.baidu.down.request.db.DownloadDataConstants;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import java.io.File;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes5.dex */
public class ImageRequest {
    private File gMj;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d pHs;
    private final e pHt;
    private final com.facebook.imagepipeline.common.b pHu;
    @Nullable
    private final com.facebook.imagepipeline.g.c pIJ;
    private final boolean pJs;
    @Nullable
    private final com.facebook.imagepipeline.common.a pKI;
    private final RequestLevel pLR;
    private final boolean pMs;
    private final CacheChoice pNT;
    private final Uri pNU;
    private final int pNV;
    private final boolean pNW;
    private final Priority pNX;
    private final boolean pNY;
    private final Map<String, String> pNZ;
    @Nullable
    private final b pNl;
    public String pOa;

    /* loaded from: classes5.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ae(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ag(uri).eAq();
    }

    public static ImageRequest ZL(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ae(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.pNT = imageRequestBuilder.eAe();
        this.pNU = imageRequestBuilder.eAf();
        this.pNV = af(this.pNU);
        this.pJs = imageRequestBuilder.exf();
        this.pNW = imageRequestBuilder.eAo();
        this.pHu = imageRequestBuilder.eAj();
        this.pHs = imageRequestBuilder.eAh();
        this.pHt = imageRequestBuilder.eAi() == null ? e.ewu() : imageRequestBuilder.eAi();
        this.pKI = imageRequestBuilder.eyx();
        this.pNX = imageRequestBuilder.eAp();
        this.pLR = imageRequestBuilder.ezr();
        this.pNY = imageRequestBuilder.ewO();
        this.pMs = imageRequestBuilder.eAm();
        this.pNl = imageRequestBuilder.eAn();
        this.pIJ = imageRequestBuilder.etC();
        this.pNZ = imageRequestBuilder.eAd();
        this.mTag = imageRequestBuilder.getTag();
        this.pOa = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> eAd() {
        return this.pNZ;
    }

    public CacheChoice eAe() {
        return this.pNT;
    }

    public Uri eAf() {
        return this.pNU;
    }

    public int eAg() {
        return this.pNV;
    }

    public int getPreferredWidth() {
        if (this.pHs != null) {
            return this.pHs.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.pHs != null) {
            return this.pHs.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d eAh() {
        return this.pHs;
    }

    public e eAi() {
        return this.pHt;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eyx() {
        return this.pKI;
    }

    public com.facebook.imagepipeline.common.b eAj() {
        return this.pHu;
    }

    public boolean eAk() {
        return this.pJs;
    }

    public boolean eAl() {
        return this.pNW;
    }

    public Priority ezt() {
        return this.pNX;
    }

    public RequestLevel ezr() {
        return this.pLR;
    }

    public boolean ewO() {
        return this.pNY;
    }

    public boolean eAm() {
        return this.pMs;
    }

    public synchronized File acc() {
        if (this.gMj == null) {
            this.gMj = new File(this.pNU.getPath());
        }
        return this.gMj;
    }

    @Nullable
    public b eAn() {
        return this.pNl;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c etC() {
        return this.pIJ;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.pNU, imageRequest.pNU) && f.equal(this.pNT, imageRequest.pNT) && f.equal(this.gMj, imageRequest.gMj) && f.equal(this.pKI, imageRequest.pKI) && f.equal(this.pHu, imageRequest.pHu) && f.equal(this.pHs, imageRequest.pHs) && f.equal(this.pHt, imageRequest.pHt)) {
                return f.equal(this.pNl != null ? this.pNl.ezo() : null, imageRequest.pNl != null ? imageRequest.pNl.ezo() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.Q(this.pNT, this.pNU, this.gMj, this.pKI, this.pHu, this.pHs, this.pHt, this.pNl != null ? this.pNl.ezo() : null);
    }

    public String toString() {
        return f.bb(this).H(DownloadDataConstants.Columns.COLUMN_URI, this.pNU).H("cacheChoice", this.pNT).H("decodeOptions", this.pHu).H("postprocessor", this.pNl).H("priority", this.pNX).H("resizeOptions", this.pHs).H("rotationOptions", this.pHt).H("bytesRange", this.pKI).toString();
    }

    /* loaded from: classes5.dex */
    public enum RequestLevel {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);
        
        private int mValue;

        RequestLevel(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }

        public static RequestLevel getMax(RequestLevel requestLevel, RequestLevel requestLevel2) {
            return requestLevel.getValue() > requestLevel2.getValue() ? requestLevel : requestLevel2;
        }
    }

    private static int af(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.K(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.L(uri)) {
            if (com.facebook.common.d.a.Zv(com.facebook.common.d.a.Zw(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.M(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.P(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.Q(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.S(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.R(uri) ? 8 : -1;
        }
    }
}
