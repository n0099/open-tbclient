package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.common.Priority;
import java.io.File;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.apache.commons.logging.LogFactory;
@Immutable
/* loaded from: classes2.dex */
public class ImageRequest {
    @Nullable
    private final com.facebook.imagepipeline.common.c jFx;
    private final com.facebook.imagepipeline.common.d jFy;
    private final com.facebook.imagepipeline.common.a jFz;
    private final boolean jHI;
    @Nullable
    private final com.facebook.imagepipeline.g.b jHd;
    private final RequestLevel jJU;
    private final CacheChoice jLS;
    private final Uri jLT;
    private final int jLU;
    @Nullable
    private final a jLV;
    private File jLW;
    private final boolean jLX;
    private final Priority jLY;
    private final boolean jLZ;
    private final b jLm;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest M(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.O(uri).cAI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.jLS = imageRequestBuilder.cAt();
        this.jLT = imageRequestBuilder.cAu();
        this.jLU = N(this.jLT);
        this.jLV = imageRequestBuilder.cAw();
        this.jHI = imageRequestBuilder.cxI();
        this.jLX = imageRequestBuilder.cAG();
        this.jFz = imageRequestBuilder.cAz();
        this.jFx = imageRequestBuilder.cAx();
        this.jFy = imageRequestBuilder.cAy() == null ? com.facebook.imagepipeline.common.d.cwZ() : imageRequestBuilder.cAy();
        this.jLY = imageRequestBuilder.cAH();
        this.jJU = imageRequestBuilder.czJ();
        this.jLZ = imageRequestBuilder.cAC();
        this.jLm = imageRequestBuilder.cAE();
        this.jHd = imageRequestBuilder.cAF();
    }

    public CacheChoice cAt() {
        return this.jLS;
    }

    public Uri cAu() {
        return this.jLT;
    }

    public int cAv() {
        return this.jLU;
    }

    @Nullable
    public a cAw() {
        return this.jLV;
    }

    public int getPreferredWidth() {
        if (this.jFx != null) {
            return this.jFx.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.jFx != null) {
            return this.jFx.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cAx() {
        return this.jFx;
    }

    public com.facebook.imagepipeline.common.d cAy() {
        return this.jFy;
    }

    public com.facebook.imagepipeline.common.a cAz() {
        return this.jFz;
    }

    public boolean cAA() {
        return this.jHI;
    }

    public boolean cAB() {
        return this.jLX;
    }

    public Priority czL() {
        return this.jLY;
    }

    public RequestLevel czJ() {
        return this.jJU;
    }

    public boolean cAC() {
        return this.jLZ;
    }

    public synchronized File cAD() {
        if (this.jLW == null) {
            this.jLW = new File(this.jLT.getPath());
        }
        return this.jLW;
    }

    @Nullable
    public b cAE() {
        return this.jLm;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cAF() {
        return this.jHd;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.jLT, imageRequest.jLT) && f.equal(this.jLS, imageRequest.jLS) && f.equal(this.jLV, imageRequest.jLV) && f.equal(this.jLW, imageRequest.jLW);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.jLS, this.jLT, this.jLV, this.jLW);
    }

    public String toString() {
        return f.aE(this).q("uri", this.jLT).q("cacheChoice", this.jLS).q("decodeOptions", this.jFz).q("postprocessor", this.jLm).q(LogFactory.PRIORITY_KEY, this.jLY).q("resizeOptions", this.jFx).q("rotationOptions", this.jFy).q("mediaVariations", this.jLV).toString();
    }

    /* loaded from: classes2.dex */
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

    private static int N(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.s(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.t(uri)) {
            if (com.facebook.common.d.a.Fz(com.facebook.common.d.a.FA(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.u(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.x(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.y(uri)) {
                return 6;
            }
            return com.facebook.common.util.d.z(uri) ? 7 : -1;
        }
    }
}
