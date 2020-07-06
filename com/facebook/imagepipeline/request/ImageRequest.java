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
    private final com.facebook.imagepipeline.common.d mRl;
    private final e mRm;
    private final com.facebook.imagepipeline.common.b mRn;
    @Nullable
    private final com.facebook.imagepipeline.h.c mSH;
    public String mTag;
    private final boolean mTt;
    @Nullable
    private final com.facebook.imagepipeline.common.a mUM;
    private final RequestLevel mVV;
    private final boolean mWw;
    private final CacheChoice mXX;
    private final Uri mXY;
    private final int mXZ;
    @Nullable
    private final b mXp;
    private final boolean mYa;
    private final Priority mYb;
    private final boolean mYc;
    private final Map<String, String> mYd;
    public String mYe;

    /* loaded from: classes12.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest aa(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ac(uri).dHf();
    }

    public static ImageRequest QV(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return aa(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.mXX = imageRequestBuilder.dGT();
        this.mXY = imageRequestBuilder.dGU();
        this.mXZ = ab(this.mXY);
        this.mTt = imageRequestBuilder.dDO();
        this.mYa = imageRequestBuilder.dHd();
        this.mRn = imageRequestBuilder.dGY();
        this.mRl = imageRequestBuilder.dGW();
        this.mRm = imageRequestBuilder.dGX() == null ? e.dDd() : imageRequestBuilder.dGX();
        this.mUM = imageRequestBuilder.dFg();
        this.mYb = imageRequestBuilder.dHe();
        this.mVV = imageRequestBuilder.dGe();
        this.mYc = imageRequestBuilder.dDx();
        this.mWw = imageRequestBuilder.dHb();
        this.mXp = imageRequestBuilder.dHc();
        this.mSH = imageRequestBuilder.dAg();
        this.mYd = imageRequestBuilder.dGt();
        this.mTag = imageRequestBuilder.getTag();
        this.mYe = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> dGt() {
        return this.mYd;
    }

    public CacheChoice dGT() {
        return this.mXX;
    }

    public Uri dGU() {
        return this.mXY;
    }

    public int dGV() {
        return this.mXZ;
    }

    public int getPreferredWidth() {
        if (this.mRl != null) {
            return this.mRl.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.mRl != null) {
            return this.mRl.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dGW() {
        return this.mRl;
    }

    public e dGX() {
        return this.mRm;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dFg() {
        return this.mUM;
    }

    public com.facebook.imagepipeline.common.b dGY() {
        return this.mRn;
    }

    public boolean dGZ() {
        return this.mTt;
    }

    public boolean dHa() {
        return this.mYa;
    }

    public Priority dGg() {
        return this.mYb;
    }

    public RequestLevel dGe() {
        return this.mVV;
    }

    public boolean dDx() {
        return this.mYc;
    }

    public boolean dHb() {
        return this.mWw;
    }

    public synchronized File bvq() {
        if (this.fxV == null) {
            this.fxV = new File(this.mXY.getPath());
        }
        return this.fxV;
    }

    @Nullable
    public b dHc() {
        return this.mXp;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dAg() {
        return this.mSH;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.mXY, imageRequest.mXY) && f.equal(this.mXX, imageRequest.mXX) && f.equal(this.fxV, imageRequest.fxV) && f.equal(this.mUM, imageRequest.mUM) && f.equal(this.mRn, imageRequest.mRn) && f.equal(this.mRl, imageRequest.mRl) && f.equal(this.mRm, imageRequest.mRm)) {
                return f.equal(this.mXp != null ? this.mXp.dGb() : null, imageRequest.mXp != null ? imageRequest.mXp.dGb() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.N(this.mXX, this.mXY, this.fxV, this.mUM, this.mRn, this.mRl, this.mRm, this.mXp != null ? this.mXp.dGb() : null);
    }

    public String toString() {
        return f.aO(this).F(DownloadDataConstants.Columns.COLUMN_URI, this.mXY).F("cacheChoice", this.mXX).F("decodeOptions", this.mRn).F("postprocessor", this.mXp).F("priority", this.mYb).F("resizeOptions", this.mRl).F("rotationOptions", this.mRm).F("bytesRange", this.mUM).toString();
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
            if (com.facebook.common.d.a.QD(com.facebook.common.d.a.QE(uri.getPath()))) {
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
