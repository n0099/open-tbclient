package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.common.Priority;
import java.io.File;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class ImageRequest {
    @Nullable
    private final com.facebook.imagepipeline.common.c kfU;
    private final com.facebook.imagepipeline.common.d kfV;
    private final com.facebook.imagepipeline.common.a kfW;
    @Nullable
    private final com.facebook.imagepipeline.g.b khB;
    private final boolean kih;
    private final RequestLevel kkt;
    private final b klL;
    private final CacheChoice kmr;
    private final Uri kms;
    private final int kmt;
    @Nullable
    private final a kmu;
    private File kmv;
    private final boolean kmw;
    private final Priority kmx;
    private final boolean kmy;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest S(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.U(uri).cLX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.kmr = imageRequestBuilder.cLI();
        this.kms = imageRequestBuilder.cLJ();
        this.kmt = T(this.kms);
        this.kmu = imageRequestBuilder.cLL();
        this.kih = imageRequestBuilder.cIW();
        this.kmw = imageRequestBuilder.cLV();
        this.kfW = imageRequestBuilder.cLO();
        this.kfU = imageRequestBuilder.cLM();
        this.kfV = imageRequestBuilder.cLN() == null ? com.facebook.imagepipeline.common.d.cIn() : imageRequestBuilder.cLN();
        this.kmx = imageRequestBuilder.cLW();
        this.kkt = imageRequestBuilder.cKY();
        this.kmy = imageRequestBuilder.cLR();
        this.klL = imageRequestBuilder.cLT();
        this.khB = imageRequestBuilder.cLU();
    }

    public CacheChoice cLI() {
        return this.kmr;
    }

    public Uri cLJ() {
        return this.kms;
    }

    public int cLK() {
        return this.kmt;
    }

    @Nullable
    public a cLL() {
        return this.kmu;
    }

    public int getPreferredWidth() {
        if (this.kfU != null) {
            return this.kfU.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.kfU != null) {
            return this.kfU.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cLM() {
        return this.kfU;
    }

    public com.facebook.imagepipeline.common.d cLN() {
        return this.kfV;
    }

    public com.facebook.imagepipeline.common.a cLO() {
        return this.kfW;
    }

    public boolean cLP() {
        return this.kih;
    }

    public boolean cLQ() {
        return this.kmw;
    }

    public Priority cLa() {
        return this.kmx;
    }

    public RequestLevel cKY() {
        return this.kkt;
    }

    public boolean cLR() {
        return this.kmy;
    }

    public synchronized File cLS() {
        if (this.kmv == null) {
            this.kmv = new File(this.kms.getPath());
        }
        return this.kmv;
    }

    @Nullable
    public b cLT() {
        return this.klL;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cLU() {
        return this.khB;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.kms, imageRequest.kms) && f.equal(this.kmr, imageRequest.kmr) && f.equal(this.kmu, imageRequest.kmu) && f.equal(this.kmv, imageRequest.kmv);
        }
        return false;
    }

    public int hashCode() {
        return f.L(this.kmr, this.kms, this.kmu, this.kmv);
    }

    public String toString() {
        return f.aC(this).t("uri", this.kms).t("cacheChoice", this.kmr).t("decodeOptions", this.kfW).t("postprocessor", this.klL).t("priority", this.kmx).t("resizeOptions", this.kfU).t("rotationOptions", this.kfV).t("mediaVariations", this.kmu).toString();
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

    private static int T(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.y(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.z(uri)) {
            if (com.facebook.common.d.a.HH(com.facebook.common.d.a.HI(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.A(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.D(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.E(uri)) {
                return 6;
            }
            return com.facebook.common.util.d.F(uri) ? 7 : -1;
        }
    }
}
