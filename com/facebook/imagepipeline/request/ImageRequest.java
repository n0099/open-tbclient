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
    private final com.facebook.imagepipeline.common.c jXF;
    private final com.facebook.imagepipeline.common.d jXG;
    private final com.facebook.imagepipeline.common.a jXH;
    private final boolean jZQ;
    @Nullable
    private final com.facebook.imagepipeline.g.b jZl;
    private final RequestLevel kcc;
    private final b kdu;
    private final CacheChoice kea;
    private final Uri keb;
    private final int kec;
    @Nullable
    private final a ked;
    private File kee;
    private final boolean kef;
    private final Priority keg;
    private final boolean keh;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest S(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.U(uri).cIx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.kea = imageRequestBuilder.cIi();
        this.keb = imageRequestBuilder.cIj();
        this.kec = T(this.keb);
        this.ked = imageRequestBuilder.cIl();
        this.jZQ = imageRequestBuilder.cFx();
        this.kef = imageRequestBuilder.cIv();
        this.jXH = imageRequestBuilder.cIo();
        this.jXF = imageRequestBuilder.cIm();
        this.jXG = imageRequestBuilder.cIn() == null ? com.facebook.imagepipeline.common.d.cEO() : imageRequestBuilder.cIn();
        this.keg = imageRequestBuilder.cIw();
        this.kcc = imageRequestBuilder.cHy();
        this.keh = imageRequestBuilder.cIr();
        this.kdu = imageRequestBuilder.cIt();
        this.jZl = imageRequestBuilder.cIu();
    }

    public CacheChoice cIi() {
        return this.kea;
    }

    public Uri cIj() {
        return this.keb;
    }

    public int cIk() {
        return this.kec;
    }

    @Nullable
    public a cIl() {
        return this.ked;
    }

    public int getPreferredWidth() {
        if (this.jXF != null) {
            return this.jXF.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.jXF != null) {
            return this.jXF.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cIm() {
        return this.jXF;
    }

    public com.facebook.imagepipeline.common.d cIn() {
        return this.jXG;
    }

    public com.facebook.imagepipeline.common.a cIo() {
        return this.jXH;
    }

    public boolean cIp() {
        return this.jZQ;
    }

    public boolean cIq() {
        return this.kef;
    }

    public Priority cHA() {
        return this.keg;
    }

    public RequestLevel cHy() {
        return this.kcc;
    }

    public boolean cIr() {
        return this.keh;
    }

    public synchronized File cIs() {
        if (this.kee == null) {
            this.kee = new File(this.keb.getPath());
        }
        return this.kee;
    }

    @Nullable
    public b cIt() {
        return this.kdu;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cIu() {
        return this.jZl;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.keb, imageRequest.keb) && f.equal(this.kea, imageRequest.kea) && f.equal(this.ked, imageRequest.ked) && f.equal(this.kee, imageRequest.kee);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.kea, this.keb, this.ked, this.kee);
    }

    public String toString() {
        return f.aC(this).t("uri", this.keb).t("cacheChoice", this.kea).t("decodeOptions", this.jXH).t("postprocessor", this.kdu).t("priority", this.keg).t("resizeOptions", this.jXF).t("rotationOptions", this.jXG).t("mediaVariations", this.ked).toString();
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
            if (com.facebook.common.d.a.GK(com.facebook.common.d.a.GL(uri.getPath()))) {
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
