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
    private File gNV;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.g.c pAU;
    private final boolean pBD;
    @Nullable
    private final com.facebook.imagepipeline.common.a pCT;
    private final boolean pED;
    private final RequestLevel pEc;
    @Nullable
    private final b pFx;
    private final CacheChoice pGf;
    private final Uri pGg;
    private final int pGh;
    private final boolean pGi;
    private final Priority pGj;
    private final boolean pGk;
    private final Map<String, String> pGl;
    public String pGm;
    @Nullable
    private final com.facebook.imagepipeline.common.d pzD;
    private final e pzE;
    private final com.facebook.imagepipeline.common.b pzF;

    /* loaded from: classes5.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ah(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.aj(uri).eBe();
    }

    public static ImageRequest ZF(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ah(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.pGf = imageRequestBuilder.eAS();
        this.pGg = imageRequestBuilder.eAT();
        this.pGh = ai(this.pGg);
        this.pBD = imageRequestBuilder.exU();
        this.pGi = imageRequestBuilder.eBc();
        this.pzF = imageRequestBuilder.eAX();
        this.pzD = imageRequestBuilder.eAV();
        this.pzE = imageRequestBuilder.eAW() == null ? e.exk() : imageRequestBuilder.eAW();
        this.pCT = imageRequestBuilder.ezk();
        this.pGj = imageRequestBuilder.eBd();
        this.pEc = imageRequestBuilder.eAf();
        this.pGk = imageRequestBuilder.exD();
        this.pED = imageRequestBuilder.eBa();
        this.pFx = imageRequestBuilder.eBb();
        this.pAU = imageRequestBuilder.euO();
        this.pGl = imageRequestBuilder.eAR();
        this.mTag = imageRequestBuilder.getTag();
        this.pGm = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> eAR() {
        return this.pGl;
    }

    public CacheChoice eAS() {
        return this.pGf;
    }

    public Uri eAT() {
        return this.pGg;
    }

    public int eAU() {
        return this.pGh;
    }

    public int getPreferredWidth() {
        if (this.pzD != null) {
            return this.pzD.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.pzD != null) {
            return this.pzD.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d eAV() {
        return this.pzD;
    }

    public e eAW() {
        return this.pzE;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a ezk() {
        return this.pCT;
    }

    public com.facebook.imagepipeline.common.b eAX() {
        return this.pzF;
    }

    public boolean eAY() {
        return this.pBD;
    }

    public boolean eAZ() {
        return this.pGi;
    }

    public Priority eAh() {
        return this.pGj;
    }

    public RequestLevel eAf() {
        return this.pEc;
    }

    public boolean exD() {
        return this.pGk;
    }

    public boolean eBa() {
        return this.pED;
    }

    public synchronized File aeg() {
        if (this.gNV == null) {
            this.gNV = new File(this.pGg.getPath());
        }
        return this.gNV;
    }

    @Nullable
    public b eBb() {
        return this.pFx;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c euO() {
        return this.pAU;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.pGg, imageRequest.pGg) && f.equal(this.pGf, imageRequest.pGf) && f.equal(this.gNV, imageRequest.gNV) && f.equal(this.pCT, imageRequest.pCT) && f.equal(this.pzF, imageRequest.pzF) && f.equal(this.pzD, imageRequest.pzD) && f.equal(this.pzE, imageRequest.pzE)) {
                return f.equal(this.pFx != null ? this.pFx.eAc() : null, imageRequest.pFx != null ? imageRequest.pFx.eAc() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.Q(this.pGf, this.pGg, this.gNV, this.pCT, this.pzF, this.pzD, this.pzE, this.pFx != null ? this.pFx.eAc() : null);
    }

    public String toString() {
        return f.bb(this).I(DownloadDataConstants.Columns.COLUMN_URI, this.pGg).I("cacheChoice", this.pGf).I("decodeOptions", this.pzF).I("postprocessor", this.pFx).I("priority", this.pGj).I("resizeOptions", this.pzD).I("rotationOptions", this.pzE).I("bytesRange", this.pCT).toString();
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

    private static int ai(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.N(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.O(uri)) {
            if (com.facebook.common.d.a.Zq(com.facebook.common.d.a.Zr(uri.getPath()))) {
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
