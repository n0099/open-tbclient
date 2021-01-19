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
    private File gJp;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.a pAa;
    private final boolean pBK;
    private final RequestLevel pBj;
    @Nullable
    private final b pCD;
    private final CacheChoice pDl;
    private final Uri pDm;
    private final int pDn;
    private final boolean pDo;
    private final Priority pDp;
    private final boolean pDq;
    private final Map<String, String> pDr;
    public String pDs;
    @Nullable
    private final com.facebook.imagepipeline.common.d pwK;
    private final e pwL;
    private final com.facebook.imagepipeline.common.b pwM;
    private final boolean pyK;
    @Nullable
    private final com.facebook.imagepipeline.g.c pyb;

    /* loaded from: classes3.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ae(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ag(uri).exQ();
    }

    public static ImageRequest Yy(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ae(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.pDl = imageRequestBuilder.exE();
        this.pDm = imageRequestBuilder.exF();
        this.pDn = af(this.pDm);
        this.pyK = imageRequestBuilder.euE();
        this.pDo = imageRequestBuilder.exO();
        this.pwM = imageRequestBuilder.exJ();
        this.pwK = imageRequestBuilder.exH();
        this.pwL = imageRequestBuilder.exI() == null ? e.etU() : imageRequestBuilder.exI();
        this.pAa = imageRequestBuilder.evW();
        this.pDp = imageRequestBuilder.exP();
        this.pBj = imageRequestBuilder.ewR();
        this.pDq = imageRequestBuilder.eun();
        this.pBK = imageRequestBuilder.exM();
        this.pCD = imageRequestBuilder.exN();
        this.pyb = imageRequestBuilder.erb();
        this.pDr = imageRequestBuilder.exD();
        this.mTag = imageRequestBuilder.getTag();
        this.pDs = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> exD() {
        return this.pDr;
    }

    public CacheChoice exE() {
        return this.pDl;
    }

    public Uri exF() {
        return this.pDm;
    }

    public int exG() {
        return this.pDn;
    }

    public int getPreferredWidth() {
        if (this.pwK != null) {
            return this.pwK.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.pwK != null) {
            return this.pwK.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d exH() {
        return this.pwK;
    }

    public e exI() {
        return this.pwL;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a evW() {
        return this.pAa;
    }

    public com.facebook.imagepipeline.common.b exJ() {
        return this.pwM;
    }

    public boolean exK() {
        return this.pyK;
    }

    public boolean exL() {
        return this.pDo;
    }

    public Priority ewT() {
        return this.pDp;
    }

    public RequestLevel ewR() {
        return this.pBj;
    }

    public boolean eun() {
        return this.pDq;
    }

    public boolean exM() {
        return this.pBK;
    }

    public synchronized File aao() {
        if (this.gJp == null) {
            this.gJp = new File(this.pDm.getPath());
        }
        return this.gJp;
    }

    @Nullable
    public b exN() {
        return this.pCD;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c erb() {
        return this.pyb;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.pDm, imageRequest.pDm) && f.equal(this.pDl, imageRequest.pDl) && f.equal(this.gJp, imageRequest.gJp) && f.equal(this.pAa, imageRequest.pAa) && f.equal(this.pwM, imageRequest.pwM) && f.equal(this.pwK, imageRequest.pwK) && f.equal(this.pwL, imageRequest.pwL)) {
                return f.equal(this.pCD != null ? this.pCD.ewO() : null, imageRequest.pCD != null ? imageRequest.pCD.ewO() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.Q(this.pDl, this.pDm, this.gJp, this.pAa, this.pwM, this.pwK, this.pwL, this.pCD != null ? this.pCD.ewO() : null);
    }

    public String toString() {
        return f.bb(this).I(DownloadDataConstants.Columns.COLUMN_URI, this.pDm).I("cacheChoice", this.pDl).I("decodeOptions", this.pwM).I("postprocessor", this.pCD).I("priority", this.pDp).I("resizeOptions", this.pwK).I("rotationOptions", this.pwL).I("bytesRange", this.pAa).toString();
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

    private static int af(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.K(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.L(uri)) {
            if (com.facebook.common.d.a.Yi(com.facebook.common.d.a.Yj(uri.getPath()))) {
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
