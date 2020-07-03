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
    private File fxV;
    @Nullable
    private final com.facebook.imagepipeline.common.d mRi;
    private final e mRj;
    private final com.facebook.imagepipeline.common.b mRk;
    @Nullable
    private final com.facebook.imagepipeline.h.c mSE;
    public String mTag;
    private final boolean mTq;
    @Nullable
    private final com.facebook.imagepipeline.common.a mUJ;
    private final RequestLevel mVS;
    private final boolean mWt;
    private final CacheChoice mXU;
    private final Uri mXV;
    private final int mXW;
    private final boolean mXX;
    private final Priority mXY;
    private final boolean mXZ;
    @Nullable
    private final b mXm;
    private final Map<String, String> mYa;
    public String mYb;

    /* loaded from: classes12.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest aa(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ac(uri).dHb();
    }

    public static ImageRequest QU(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return aa(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.mXU = imageRequestBuilder.dGP();
        this.mXV = imageRequestBuilder.dGQ();
        this.mXW = ab(this.mXV);
        this.mTq = imageRequestBuilder.dDK();
        this.mXX = imageRequestBuilder.dGZ();
        this.mRk = imageRequestBuilder.dGU();
        this.mRi = imageRequestBuilder.dGS();
        this.mRj = imageRequestBuilder.dGT() == null ? e.dCZ() : imageRequestBuilder.dGT();
        this.mUJ = imageRequestBuilder.dFc();
        this.mXY = imageRequestBuilder.dHa();
        this.mVS = imageRequestBuilder.dGa();
        this.mXZ = imageRequestBuilder.dDt();
        this.mWt = imageRequestBuilder.dGX();
        this.mXm = imageRequestBuilder.dGY();
        this.mSE = imageRequestBuilder.dAc();
        this.mYa = imageRequestBuilder.dGp();
        this.mTag = imageRequestBuilder.getTag();
        this.mYb = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> dGp() {
        return this.mYa;
    }

    public CacheChoice dGP() {
        return this.mXU;
    }

    public Uri dGQ() {
        return this.mXV;
    }

    public int dGR() {
        return this.mXW;
    }

    public int getPreferredWidth() {
        if (this.mRi != null) {
            return this.mRi.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.mRi != null) {
            return this.mRi.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dGS() {
        return this.mRi;
    }

    public e dGT() {
        return this.mRj;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dFc() {
        return this.mUJ;
    }

    public com.facebook.imagepipeline.common.b dGU() {
        return this.mRk;
    }

    public boolean dGV() {
        return this.mTq;
    }

    public boolean dGW() {
        return this.mXX;
    }

    public Priority dGc() {
        return this.mXY;
    }

    public RequestLevel dGa() {
        return this.mVS;
    }

    public boolean dDt() {
        return this.mXZ;
    }

    public boolean dGX() {
        return this.mWt;
    }

    public synchronized File bvp() {
        if (this.fxV == null) {
            this.fxV = new File(this.mXV.getPath());
        }
        return this.fxV;
    }

    @Nullable
    public b dGY() {
        return this.mXm;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dAc() {
        return this.mSE;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.mXV, imageRequest.mXV) && f.equal(this.mXU, imageRequest.mXU) && f.equal(this.fxV, imageRequest.fxV) && f.equal(this.mUJ, imageRequest.mUJ) && f.equal(this.mRk, imageRequest.mRk) && f.equal(this.mRi, imageRequest.mRi) && f.equal(this.mRj, imageRequest.mRj)) {
                return f.equal(this.mXm != null ? this.mXm.dFX() : null, imageRequest.mXm != null ? imageRequest.mXm.dFX() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.N(this.mXU, this.mXV, this.fxV, this.mUJ, this.mRk, this.mRi, this.mRj, this.mXm != null ? this.mXm.dFX() : null);
    }

    public String toString() {
        return f.aO(this).F(DownloadDataConstants.Columns.COLUMN_URI, this.mXV).F("cacheChoice", this.mXU).F("decodeOptions", this.mRk).F("postprocessor", this.mXm).F("priority", this.mXY).F("resizeOptions", this.mRi).F("rotationOptions", this.mRj).F("bytesRange", this.mUJ).toString();
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

    private static int ab(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.J(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.isLocalFileUri(uri)) {
            if (com.facebook.common.d.a.QC(com.facebook.common.d.a.QD(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.isLocalContentUri(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.M(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.N(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.P(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.O(uri) ? 8 : -1;
        }
    }
}
