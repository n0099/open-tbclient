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
/* loaded from: classes3.dex */
public class ImageRequest {
    private File gNV;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d pBk;
    private final e pBl;
    private final com.facebook.imagepipeline.common.b pBm;
    @Nullable
    private final com.facebook.imagepipeline.g.c pCB;
    private final boolean pDk;
    @Nullable
    private final com.facebook.imagepipeline.common.a pEA;
    private final RequestLevel pFJ;
    private final boolean pGk;
    private final CacheChoice pHL;
    private final Uri pHM;
    private final int pHN;
    private final boolean pHO;
    private final Priority pHP;
    private final boolean pHQ;
    private final Map<String, String> pHR;
    public String pHS;
    @Nullable
    private final b pHd;

    /* loaded from: classes3.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ah(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.aj(uri).eBI();
    }

    public static ImageRequest ZF(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ah(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.pHL = imageRequestBuilder.eBw();
        this.pHM = imageRequestBuilder.eBx();
        this.pHN = ai(this.pHM);
        this.pDk = imageRequestBuilder.eyw();
        this.pHO = imageRequestBuilder.eBG();
        this.pBm = imageRequestBuilder.eBB();
        this.pBk = imageRequestBuilder.eBz();
        this.pBl = imageRequestBuilder.eBA() == null ? e.exM() : imageRequestBuilder.eBA();
        this.pEA = imageRequestBuilder.ezO();
        this.pHP = imageRequestBuilder.eBH();
        this.pFJ = imageRequestBuilder.eAJ();
        this.pHQ = imageRequestBuilder.eyf();
        this.pGk = imageRequestBuilder.eBE();
        this.pHd = imageRequestBuilder.eBF();
        this.pCB = imageRequestBuilder.euV();
        this.pHR = imageRequestBuilder.eBv();
        this.mTag = imageRequestBuilder.getTag();
        this.pHS = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> eBv() {
        return this.pHR;
    }

    public CacheChoice eBw() {
        return this.pHL;
    }

    public Uri eBx() {
        return this.pHM;
    }

    public int eBy() {
        return this.pHN;
    }

    public int getPreferredWidth() {
        if (this.pBk != null) {
            return this.pBk.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.pBk != null) {
            return this.pBk.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d eBz() {
        return this.pBk;
    }

    public e eBA() {
        return this.pBl;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a ezO() {
        return this.pEA;
    }

    public com.facebook.imagepipeline.common.b eBB() {
        return this.pBm;
    }

    public boolean eBC() {
        return this.pDk;
    }

    public boolean eBD() {
        return this.pHO;
    }

    public Priority eAL() {
        return this.pHP;
    }

    public RequestLevel eAJ() {
        return this.pFJ;
    }

    public boolean eyf() {
        return this.pHQ;
    }

    public boolean eBE() {
        return this.pGk;
    }

    public synchronized File aeh() {
        if (this.gNV == null) {
            this.gNV = new File(this.pHM.getPath());
        }
        return this.gNV;
    }

    @Nullable
    public b eBF() {
        return this.pHd;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c euV() {
        return this.pCB;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.pHM, imageRequest.pHM) && f.equal(this.pHL, imageRequest.pHL) && f.equal(this.gNV, imageRequest.gNV) && f.equal(this.pEA, imageRequest.pEA) && f.equal(this.pBm, imageRequest.pBm) && f.equal(this.pBk, imageRequest.pBk) && f.equal(this.pBl, imageRequest.pBl)) {
                return f.equal(this.pHd != null ? this.pHd.eAG() : null, imageRequest.pHd != null ? imageRequest.pHd.eAG() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.Q(this.pHL, this.pHM, this.gNV, this.pEA, this.pBm, this.pBk, this.pBl, this.pHd != null ? this.pHd.eAG() : null);
    }

    public String toString() {
        return f.bb(this).I(DownloadDataConstants.Columns.COLUMN_URI, this.pHM).I("cacheChoice", this.pHL).I("decodeOptions", this.pBm).I("postprocessor", this.pHd).I("priority", this.pHP).I("resizeOptions", this.pBk).I("rotationOptions", this.pBl).I("bytesRange", this.pEA).toString();
    }

    /* loaded from: classes3.dex */
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

    private static int ai(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.N(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.O(uri)) {
            if (com.facebook.common.d.a.Zp(com.facebook.common.d.a.Zq(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.P(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.S(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.T(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.V(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.U(uri) ? 8 : -1;
        }
    }
}
