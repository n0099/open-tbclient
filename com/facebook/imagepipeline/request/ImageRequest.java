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
    @Nullable
    private final com.facebook.imagepipeline.common.d lSr;
    private final e lSs;
    private final com.facebook.imagepipeline.common.b lSt;
    @Nullable
    private final com.facebook.imagepipeline.h.c lTL;
    private final boolean lUu;
    @Nullable
    private final com.facebook.imagepipeline.common.a lVM;
    private final RequestLevel lWV;
    private final boolean lXw;
    private final CacheChoice lYW;
    private final Uri lYX;
    private final int lYY;
    private File lYZ;
    @Nullable
    private final b lYo;
    private final boolean lZa;
    private final Priority lZb;
    private final boolean lZc;
    private final Map<String, String> lZd;
    public String lZe;
    public String mTag;

    /* loaded from: classes12.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest W(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.Y(uri).dta();
    }

    public static ImageRequest Ph(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return W(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.lYW = imageRequestBuilder.dsN();
        this.lYX = imageRequestBuilder.dsO();
        this.lYY = X(this.lYX);
        this.lUu = imageRequestBuilder.dpG();
        this.lZa = imageRequestBuilder.dsY();
        this.lSt = imageRequestBuilder.dsS();
        this.lSr = imageRequestBuilder.dsQ();
        this.lSs = imageRequestBuilder.dsR() == null ? e.doU() : imageRequestBuilder.dsR();
        this.lVM = imageRequestBuilder.dqY();
        this.lZb = imageRequestBuilder.dsZ();
        this.lWV = imageRequestBuilder.drX();
        this.lZc = imageRequestBuilder.dpp();
        this.lXw = imageRequestBuilder.dsV();
        this.lYo = imageRequestBuilder.dsX();
        this.lTL = imageRequestBuilder.dmc();
        this.lZd = imageRequestBuilder.dsm();
        this.mTag = imageRequestBuilder.getTag();
        this.lZe = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> dsm() {
        return this.lZd;
    }

    public CacheChoice dsN() {
        return this.lYW;
    }

    public Uri dsO() {
        return this.lYX;
    }

    public int dsP() {
        return this.lYY;
    }

    public int getPreferredWidth() {
        if (this.lSr != null) {
            return this.lSr.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.lSr != null) {
            return this.lSr.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dsQ() {
        return this.lSr;
    }

    public e dsR() {
        return this.lSs;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqY() {
        return this.lVM;
    }

    public com.facebook.imagepipeline.common.b dsS() {
        return this.lSt;
    }

    public boolean dsT() {
        return this.lUu;
    }

    public boolean dsU() {
        return this.lZa;
    }

    public Priority drZ() {
        return this.lZb;
    }

    public RequestLevel drX() {
        return this.lWV;
    }

    public boolean dpp() {
        return this.lZc;
    }

    public boolean dsV() {
        return this.lXw;
    }

    public synchronized File dsW() {
        if (this.lYZ == null) {
            this.lYZ = new File(this.lYX.getPath());
        }
        return this.lYZ;
    }

    @Nullable
    public b dsX() {
        return this.lYo;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dmc() {
        return this.lTL;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.lYX, imageRequest.lYX) && f.equal(this.lYW, imageRequest.lYW) && f.equal(this.lYZ, imageRequest.lYZ) && f.equal(this.lVM, imageRequest.lVM) && f.equal(this.lSt, imageRequest.lSt) && f.equal(this.lSr, imageRequest.lSr) && f.equal(this.lSs, imageRequest.lSs)) {
                return f.equal(this.lYo != null ? this.lYo.drU() : null, imageRequest.lYo != null ? imageRequest.lYo.drU() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.K(this.lYW, this.lYX, this.lYZ, this.lVM, this.lSt, this.lSr, this.lSs, this.lYo != null ? this.lYo.drU() : null);
    }

    public String toString() {
        return f.aS(this).x(DownloadDataConstants.Columns.COLUMN_URI, this.lYX).x("cacheChoice", this.lYW).x("decodeOptions", this.lSt).x("postprocessor", this.lYo).x("priority", this.lZb).x("resizeOptions", this.lSr).x("rotationOptions", this.lSs).x("bytesRange", this.lVM).toString();
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

    private static int X(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.C(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.isLocalFileUri(uri)) {
            if (com.facebook.common.d.a.OQ(com.facebook.common.d.a.OR(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.isLocalContentUri(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.F(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.G(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.I(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.H(uri) ? 8 : -1;
        }
    }
}
