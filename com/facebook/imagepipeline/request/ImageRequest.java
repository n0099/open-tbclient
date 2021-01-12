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
    private final boolean pBJ;
    private final RequestLevel pBi;
    @Nullable
    private final b pCC;
    private final CacheChoice pDk;
    private final Uri pDl;
    private final int pDm;
    private final boolean pDn;
    private final Priority pDo;
    private final boolean pDp;
    private final Map<String, String> pDq;
    public String pDr;
    @Nullable
    private final com.facebook.imagepipeline.common.d pwJ;
    private final e pwK;
    private final com.facebook.imagepipeline.common.b pwL;
    private final boolean pyJ;
    @Nullable
    private final com.facebook.imagepipeline.g.c pya;
    @Nullable
    private final com.facebook.imagepipeline.common.a pzZ;

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

    public static ImageRequest Yx(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ae(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.pDk = imageRequestBuilder.exE();
        this.pDl = imageRequestBuilder.exF();
        this.pDm = af(this.pDl);
        this.pyJ = imageRequestBuilder.euE();
        this.pDn = imageRequestBuilder.exO();
        this.pwL = imageRequestBuilder.exJ();
        this.pwJ = imageRequestBuilder.exH();
        this.pwK = imageRequestBuilder.exI() == null ? e.etU() : imageRequestBuilder.exI();
        this.pzZ = imageRequestBuilder.evW();
        this.pDo = imageRequestBuilder.exP();
        this.pBi = imageRequestBuilder.ewR();
        this.pDp = imageRequestBuilder.eun();
        this.pBJ = imageRequestBuilder.exM();
        this.pCC = imageRequestBuilder.exN();
        this.pya = imageRequestBuilder.erb();
        this.pDq = imageRequestBuilder.exD();
        this.mTag = imageRequestBuilder.getTag();
        this.pDr = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> exD() {
        return this.pDq;
    }

    public CacheChoice exE() {
        return this.pDk;
    }

    public Uri exF() {
        return this.pDl;
    }

    public int exG() {
        return this.pDm;
    }

    public int getPreferredWidth() {
        if (this.pwJ != null) {
            return this.pwJ.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.pwJ != null) {
            return this.pwJ.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d exH() {
        return this.pwJ;
    }

    public e exI() {
        return this.pwK;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a evW() {
        return this.pzZ;
    }

    public com.facebook.imagepipeline.common.b exJ() {
        return this.pwL;
    }

    public boolean exK() {
        return this.pyJ;
    }

    public boolean exL() {
        return this.pDn;
    }

    public Priority ewT() {
        return this.pDo;
    }

    public RequestLevel ewR() {
        return this.pBi;
    }

    public boolean eun() {
        return this.pDp;
    }

    public boolean exM() {
        return this.pBJ;
    }

    public synchronized File aao() {
        if (this.gJp == null) {
            this.gJp = new File(this.pDl.getPath());
        }
        return this.gJp;
    }

    @Nullable
    public b exN() {
        return this.pCC;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c erb() {
        return this.pya;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.pDl, imageRequest.pDl) && f.equal(this.pDk, imageRequest.pDk) && f.equal(this.gJp, imageRequest.gJp) && f.equal(this.pzZ, imageRequest.pzZ) && f.equal(this.pwL, imageRequest.pwL) && f.equal(this.pwJ, imageRequest.pwJ) && f.equal(this.pwK, imageRequest.pwK)) {
                return f.equal(this.pCC != null ? this.pCC.ewO() : null, imageRequest.pCC != null ? imageRequest.pCC.ewO() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.Q(this.pDk, this.pDl, this.gJp, this.pzZ, this.pwL, this.pwJ, this.pwK, this.pCC != null ? this.pCC.ewO() : null);
    }

    public String toString() {
        return f.bb(this).I(DownloadDataConstants.Columns.COLUMN_URI, this.pDl).I("cacheChoice", this.pDk).I("decodeOptions", this.pwL).I("postprocessor", this.pCC).I("priority", this.pDo).I("resizeOptions", this.pwJ).I("rotationOptions", this.pwK).I("bytesRange", this.pzZ).toString();
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
            if (com.facebook.common.d.a.Yh(com.facebook.common.d.a.Yi(uri.getPath()))) {
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
