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
    private final com.facebook.imagepipeline.common.c jXJ;
    private final com.facebook.imagepipeline.common.d jXK;
    private final com.facebook.imagepipeline.common.a jXL;
    private final boolean jZU;
    @Nullable
    private final com.facebook.imagepipeline.g.b jZp;
    private final RequestLevel kcg;
    private final b kdy;
    private final CacheChoice kee;
    private final Uri kef;
    private final int keg;
    @Nullable
    private final a keh;
    private File kei;
    private final boolean kej;
    private final Priority kek;
    private final boolean kel;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest S(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.U(uri).cIy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.kee = imageRequestBuilder.cIj();
        this.kef = imageRequestBuilder.cIk();
        this.keg = T(this.kef);
        this.keh = imageRequestBuilder.cIm();
        this.jZU = imageRequestBuilder.cFy();
        this.kej = imageRequestBuilder.cIw();
        this.jXL = imageRequestBuilder.cIp();
        this.jXJ = imageRequestBuilder.cIn();
        this.jXK = imageRequestBuilder.cIo() == null ? com.facebook.imagepipeline.common.d.cEP() : imageRequestBuilder.cIo();
        this.kek = imageRequestBuilder.cIx();
        this.kcg = imageRequestBuilder.cHz();
        this.kel = imageRequestBuilder.cIs();
        this.kdy = imageRequestBuilder.cIu();
        this.jZp = imageRequestBuilder.cIv();
    }

    public CacheChoice cIj() {
        return this.kee;
    }

    public Uri cIk() {
        return this.kef;
    }

    public int cIl() {
        return this.keg;
    }

    @Nullable
    public a cIm() {
        return this.keh;
    }

    public int getPreferredWidth() {
        if (this.jXJ != null) {
            return this.jXJ.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.jXJ != null) {
            return this.jXJ.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cIn() {
        return this.jXJ;
    }

    public com.facebook.imagepipeline.common.d cIo() {
        return this.jXK;
    }

    public com.facebook.imagepipeline.common.a cIp() {
        return this.jXL;
    }

    public boolean cIq() {
        return this.jZU;
    }

    public boolean cIr() {
        return this.kej;
    }

    public Priority cHB() {
        return this.kek;
    }

    public RequestLevel cHz() {
        return this.kcg;
    }

    public boolean cIs() {
        return this.kel;
    }

    public synchronized File cIt() {
        if (this.kei == null) {
            this.kei = new File(this.kef.getPath());
        }
        return this.kei;
    }

    @Nullable
    public b cIu() {
        return this.kdy;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cIv() {
        return this.jZp;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.kef, imageRequest.kef) && f.equal(this.kee, imageRequest.kee) && f.equal(this.keh, imageRequest.keh) && f.equal(this.kei, imageRequest.kei);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.kee, this.kef, this.keh, this.kei);
    }

    public String toString() {
        return f.aC(this).t("uri", this.kef).t("cacheChoice", this.kee).t("decodeOptions", this.jXL).t("postprocessor", this.kdy).t("priority", this.kek).t("resizeOptions", this.jXJ).t("rotationOptions", this.jXK).t("mediaVariations", this.keh).toString();
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
            if (com.facebook.common.d.a.GM(com.facebook.common.d.a.GN(uri.getPath()))) {
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
