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
/* loaded from: classes12.dex */
public class ImageRequest {
    private File fmH;
    private final boolean mAm;
    private final CacheChoice mBN;
    private final Uri mBO;
    private final int mBP;
    private final boolean mBQ;
    private final Priority mBR;
    private final boolean mBS;
    private final Map<String, String> mBT;
    public String mBU;
    @Nullable
    private final b mBe;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d mvj;
    private final e mvk;
    private final com.facebook.imagepipeline.common.b mvl;
    @Nullable
    private final com.facebook.imagepipeline.h.c mwD;
    private final boolean mxm;
    @Nullable
    private final com.facebook.imagepipeline.common.a myC;
    private final RequestLevel mzL;

    /* loaded from: classes12.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest Z(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ab(uri).dCz();
    }

    public static ImageRequest Qi(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return Z(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.mBN = imageRequestBuilder.dCn();
        this.mBO = imageRequestBuilder.dCo();
        this.mBP = aa(this.mBO);
        this.mxm = imageRequestBuilder.dzi();
        this.mBQ = imageRequestBuilder.dCx();
        this.mvl = imageRequestBuilder.dCs();
        this.mvj = imageRequestBuilder.dCq();
        this.mvk = imageRequestBuilder.dCr() == null ? e.dyx() : imageRequestBuilder.dCr();
        this.myC = imageRequestBuilder.dAA();
        this.mBR = imageRequestBuilder.dCy();
        this.mzL = imageRequestBuilder.dBy();
        this.mBS = imageRequestBuilder.dyR();
        this.mAm = imageRequestBuilder.dCv();
        this.mBe = imageRequestBuilder.dCw();
        this.mwD = imageRequestBuilder.dvz();
        this.mBT = imageRequestBuilder.dBN();
        this.mTag = imageRequestBuilder.getTag();
        this.mBU = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> dBN() {
        return this.mBT;
    }

    public CacheChoice dCn() {
        return this.mBN;
    }

    public Uri dCo() {
        return this.mBO;
    }

    public int dCp() {
        return this.mBP;
    }

    public int getPreferredWidth() {
        if (this.mvj != null) {
            return this.mvj.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.mvj != null) {
            return this.mvj.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dCq() {
        return this.mvj;
    }

    public e dCr() {
        return this.mvk;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dAA() {
        return this.myC;
    }

    public com.facebook.imagepipeline.common.b dCs() {
        return this.mvl;
    }

    public boolean dCt() {
        return this.mxm;
    }

    public boolean dCu() {
        return this.mBQ;
    }

    public Priority dBA() {
        return this.mBR;
    }

    public RequestLevel dBy() {
        return this.mzL;
    }

    public boolean dyR() {
        return this.mBS;
    }

    public boolean dCv() {
        return this.mAm;
    }

    public synchronized File bsu() {
        if (this.fmH == null) {
            this.fmH = new File(this.mBO.getPath());
        }
        return this.fmH;
    }

    @Nullable
    public b dCw() {
        return this.mBe;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dvz() {
        return this.mwD;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.mBO, imageRequest.mBO) && f.equal(this.mBN, imageRequest.mBN) && f.equal(this.fmH, imageRequest.fmH) && f.equal(this.myC, imageRequest.myC) && f.equal(this.mvl, imageRequest.mvl) && f.equal(this.mvj, imageRequest.mvj) && f.equal(this.mvk, imageRequest.mvk)) {
                return f.equal(this.mBe != null ? this.mBe.dBv() : null, imageRequest.mBe != null ? imageRequest.mBe.dBv() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.N(this.mBN, this.mBO, this.fmH, this.myC, this.mvl, this.mvj, this.mvk, this.mBe != null ? this.mBe.dBv() : null);
    }

    public String toString() {
        return f.aN(this).F(DownloadDataConstants.Columns.COLUMN_URI, this.mBO).F("cacheChoice", this.mBN).F("decodeOptions", this.mvl).F("postprocessor", this.mBe).F("priority", this.mBR).F("resizeOptions", this.mvj).F("rotationOptions", this.mvk).F("bytesRange", this.myC).toString();
    }

    /* loaded from: classes12.dex */
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

    private static int aa(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.I(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.isLocalFileUri(uri)) {
            if (com.facebook.common.d.a.PQ(com.facebook.common.d.a.PR(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.isLocalContentUri(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.L(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.M(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.O(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.N(uri) ? 8 : -1;
        }
    }
}
