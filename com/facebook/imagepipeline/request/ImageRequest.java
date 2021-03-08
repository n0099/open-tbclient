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
    private File gNS;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d pJx;
    private final e pJy;
    private final com.facebook.imagepipeline.common.b pJz;
    @Nullable
    private final com.facebook.imagepipeline.g.c pKO;
    private final boolean pLx;
    @Nullable
    private final com.facebook.imagepipeline.common.a pMN;
    private final RequestLevel pNW;
    private final boolean pOx;
    private final CacheChoice pPY;
    private final Uri pPZ;
    @Nullable
    private final b pPq;
    private final int pQa;
    private final boolean pQb;
    private final Priority pQc;
    private final boolean pQd;
    private final Map<String, String> pQe;
    public String pQf;

    /* loaded from: classes5.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ae(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ag(uri).eAz();
    }

    public static ImageRequest ZR(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ae(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.pPY = imageRequestBuilder.eAn();
        this.pPZ = imageRequestBuilder.eAo();
        this.pQa = af(this.pPZ);
        this.pLx = imageRequestBuilder.exo();
        this.pQb = imageRequestBuilder.eAx();
        this.pJz = imageRequestBuilder.eAs();
        this.pJx = imageRequestBuilder.eAq();
        this.pJy = imageRequestBuilder.eAr() == null ? e.ewD() : imageRequestBuilder.eAr();
        this.pMN = imageRequestBuilder.eyG();
        this.pQc = imageRequestBuilder.eAy();
        this.pNW = imageRequestBuilder.ezA();
        this.pQd = imageRequestBuilder.ewX();
        this.pOx = imageRequestBuilder.eAv();
        this.pPq = imageRequestBuilder.eAw();
        this.pKO = imageRequestBuilder.etL();
        this.pQe = imageRequestBuilder.eAm();
        this.mTag = imageRequestBuilder.getTag();
        this.pQf = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> eAm() {
        return this.pQe;
    }

    public CacheChoice eAn() {
        return this.pPY;
    }

    public Uri eAo() {
        return this.pPZ;
    }

    public int eAp() {
        return this.pQa;
    }

    public int getPreferredWidth() {
        if (this.pJx != null) {
            return this.pJx.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.pJx != null) {
            return this.pJx.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d eAq() {
        return this.pJx;
    }

    public e eAr() {
        return this.pJy;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eyG() {
        return this.pMN;
    }

    public com.facebook.imagepipeline.common.b eAs() {
        return this.pJz;
    }

    public boolean eAt() {
        return this.pLx;
    }

    public boolean eAu() {
        return this.pQb;
    }

    public Priority ezC() {
        return this.pQc;
    }

    public RequestLevel ezA() {
        return this.pNW;
    }

    public boolean ewX() {
        return this.pQd;
    }

    public boolean eAv() {
        return this.pOx;
    }

    public synchronized File acf() {
        if (this.gNS == null) {
            this.gNS = new File(this.pPZ.getPath());
        }
        return this.gNS;
    }

    @Nullable
    public b eAw() {
        return this.pPq;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c etL() {
        return this.pKO;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.pPZ, imageRequest.pPZ) && f.equal(this.pPY, imageRequest.pPY) && f.equal(this.gNS, imageRequest.gNS) && f.equal(this.pMN, imageRequest.pMN) && f.equal(this.pJz, imageRequest.pJz) && f.equal(this.pJx, imageRequest.pJx) && f.equal(this.pJy, imageRequest.pJy)) {
                return f.equal(this.pPq != null ? this.pPq.ezx() : null, imageRequest.pPq != null ? imageRequest.pPq.ezx() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.P(this.pPY, this.pPZ, this.gNS, this.pMN, this.pJz, this.pJx, this.pJy, this.pPq != null ? this.pPq.ezx() : null);
    }

    public String toString() {
        return f.bd(this).G(DownloadDataConstants.Columns.COLUMN_URI, this.pPZ).G("cacheChoice", this.pPY).G("decodeOptions", this.pJz).G("postprocessor", this.pPq).G("priority", this.pQc).G("resizeOptions", this.pJx).G("rotationOptions", this.pJy).G("bytesRange", this.pMN).toString();
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
            if (com.facebook.common.d.a.ZB(com.facebook.common.d.a.ZC(uri.getPath()))) {
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
