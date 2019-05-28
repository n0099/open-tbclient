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
    private final com.facebook.imagepipeline.common.c jXG;
    private final com.facebook.imagepipeline.common.d jXH;
    private final com.facebook.imagepipeline.common.a jXI;
    private final boolean jZR;
    @Nullable
    private final com.facebook.imagepipeline.g.b jZm;
    private final RequestLevel kcd;
    private final b kdv;
    private final CacheChoice keb;
    private final Uri kec;
    private final int ked;
    @Nullable
    private final a kee;
    private File kef;
    private final boolean keg;
    private final Priority keh;
    private final boolean kei;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest S(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.U(uri).cIz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.keb = imageRequestBuilder.cIk();
        this.kec = imageRequestBuilder.cIl();
        this.ked = T(this.kec);
        this.kee = imageRequestBuilder.cIn();
        this.jZR = imageRequestBuilder.cFz();
        this.keg = imageRequestBuilder.cIx();
        this.jXI = imageRequestBuilder.cIq();
        this.jXG = imageRequestBuilder.cIo();
        this.jXH = imageRequestBuilder.cIp() == null ? com.facebook.imagepipeline.common.d.cEQ() : imageRequestBuilder.cIp();
        this.keh = imageRequestBuilder.cIy();
        this.kcd = imageRequestBuilder.cHA();
        this.kei = imageRequestBuilder.cIt();
        this.kdv = imageRequestBuilder.cIv();
        this.jZm = imageRequestBuilder.cIw();
    }

    public CacheChoice cIk() {
        return this.keb;
    }

    public Uri cIl() {
        return this.kec;
    }

    public int cIm() {
        return this.ked;
    }

    @Nullable
    public a cIn() {
        return this.kee;
    }

    public int getPreferredWidth() {
        if (this.jXG != null) {
            return this.jXG.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.jXG != null) {
            return this.jXG.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cIo() {
        return this.jXG;
    }

    public com.facebook.imagepipeline.common.d cIp() {
        return this.jXH;
    }

    public com.facebook.imagepipeline.common.a cIq() {
        return this.jXI;
    }

    public boolean cIr() {
        return this.jZR;
    }

    public boolean cIs() {
        return this.keg;
    }

    public Priority cHC() {
        return this.keh;
    }

    public RequestLevel cHA() {
        return this.kcd;
    }

    public boolean cIt() {
        return this.kei;
    }

    public synchronized File cIu() {
        if (this.kef == null) {
            this.kef = new File(this.kec.getPath());
        }
        return this.kef;
    }

    @Nullable
    public b cIv() {
        return this.kdv;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cIw() {
        return this.jZm;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.kec, imageRequest.kec) && f.equal(this.keb, imageRequest.keb) && f.equal(this.kee, imageRequest.kee) && f.equal(this.kef, imageRequest.kef);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.keb, this.kec, this.kee, this.kef);
    }

    public String toString() {
        return f.aC(this).t("uri", this.kec).t("cacheChoice", this.keb).t("decodeOptions", this.jXI).t("postprocessor", this.kdv).t("priority", this.keh).t("resizeOptions", this.jXG).t("rotationOptions", this.jXH).t("mediaVariations", this.kee).toString();
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
