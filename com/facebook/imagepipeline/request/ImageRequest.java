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
    private File gLV;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d pGS;
    private final e pGT;
    private final com.facebook.imagepipeline.common.b pGU;
    private final boolean pIS;
    @Nullable
    private final com.facebook.imagepipeline.g.c pIj;
    @Nullable
    private final com.facebook.imagepipeline.common.a pKi;
    private final boolean pLS;
    private final RequestLevel pLr;
    @Nullable
    private final b pML;
    public String pNA;
    private final CacheChoice pNt;
    private final Uri pNu;
    private final int pNv;
    private final boolean pNw;
    private final Priority pNx;
    private final boolean pNy;
    private final Map<String, String> pNz;

    /* loaded from: classes5.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ae(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ag(uri).eAi();
    }

    public static ImageRequest Zz(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ae(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.pNt = imageRequestBuilder.ezW();
        this.pNu = imageRequestBuilder.ezX();
        this.pNv = af(this.pNu);
        this.pIS = imageRequestBuilder.ewX();
        this.pNw = imageRequestBuilder.eAg();
        this.pGU = imageRequestBuilder.eAb();
        this.pGS = imageRequestBuilder.ezZ();
        this.pGT = imageRequestBuilder.eAa() == null ? e.ewm() : imageRequestBuilder.eAa();
        this.pKi = imageRequestBuilder.eyp();
        this.pNx = imageRequestBuilder.eAh();
        this.pLr = imageRequestBuilder.ezj();
        this.pNy = imageRequestBuilder.ewG();
        this.pLS = imageRequestBuilder.eAe();
        this.pML = imageRequestBuilder.eAf();
        this.pIj = imageRequestBuilder.etu();
        this.pNz = imageRequestBuilder.ezV();
        this.mTag = imageRequestBuilder.getTag();
        this.pNA = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> ezV() {
        return this.pNz;
    }

    public CacheChoice ezW() {
        return this.pNt;
    }

    public Uri ezX() {
        return this.pNu;
    }

    public int ezY() {
        return this.pNv;
    }

    public int getPreferredWidth() {
        if (this.pGS != null) {
            return this.pGS.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.pGS != null) {
            return this.pGS.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d ezZ() {
        return this.pGS;
    }

    public e eAa() {
        return this.pGT;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eyp() {
        return this.pKi;
    }

    public com.facebook.imagepipeline.common.b eAb() {
        return this.pGU;
    }

    public boolean eAc() {
        return this.pIS;
    }

    public boolean eAd() {
        return this.pNw;
    }

    public Priority ezl() {
        return this.pNx;
    }

    public RequestLevel ezj() {
        return this.pLr;
    }

    public boolean ewG() {
        return this.pNy;
    }

    public boolean eAe() {
        return this.pLS;
    }

    public synchronized File acc() {
        if (this.gLV == null) {
            this.gLV = new File(this.pNu.getPath());
        }
        return this.gLV;
    }

    @Nullable
    public b eAf() {
        return this.pML;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c etu() {
        return this.pIj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.pNu, imageRequest.pNu) && f.equal(this.pNt, imageRequest.pNt) && f.equal(this.gLV, imageRequest.gLV) && f.equal(this.pKi, imageRequest.pKi) && f.equal(this.pGU, imageRequest.pGU) && f.equal(this.pGS, imageRequest.pGS) && f.equal(this.pGT, imageRequest.pGT)) {
                return f.equal(this.pML != null ? this.pML.ezg() : null, imageRequest.pML != null ? imageRequest.pML.ezg() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.Q(this.pNt, this.pNu, this.gLV, this.pKi, this.pGU, this.pGS, this.pGT, this.pML != null ? this.pML.ezg() : null);
    }

    public String toString() {
        return f.bb(this).H(DownloadDataConstants.Columns.COLUMN_URI, this.pNu).H("cacheChoice", this.pNt).H("decodeOptions", this.pGU).H("postprocessor", this.pML).H("priority", this.pNx).H("resizeOptions", this.pGS).H("rotationOptions", this.pGT).H("bytesRange", this.pKi).toString();
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
            if (com.facebook.common.d.a.Zj(com.facebook.common.d.a.Zk(uri.getPath()))) {
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
