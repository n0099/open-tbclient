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
    private final com.facebook.imagepipeline.common.c keO;
    private final com.facebook.imagepipeline.common.d keP;
    private final com.facebook.imagepipeline.common.a keQ;
    @Nullable
    private final com.facebook.imagepipeline.g.b kgv;
    private final boolean kha;
    private final RequestLevel kjn;
    private final b kkF;
    private final CacheChoice kll;
    private final Uri klm;
    private final int kln;
    @Nullable
    private final a klo;
    private File klp;
    private final boolean klq;
    private final Priority klr;
    private final boolean kls;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest S(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.U(uri).cLC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.kll = imageRequestBuilder.cLn();
        this.klm = imageRequestBuilder.cLo();
        this.kln = T(this.klm);
        this.klo = imageRequestBuilder.cLq();
        this.kha = imageRequestBuilder.cIB();
        this.klq = imageRequestBuilder.cLA();
        this.keQ = imageRequestBuilder.cLt();
        this.keO = imageRequestBuilder.cLr();
        this.keP = imageRequestBuilder.cLs() == null ? com.facebook.imagepipeline.common.d.cHS() : imageRequestBuilder.cLs();
        this.klr = imageRequestBuilder.cLB();
        this.kjn = imageRequestBuilder.cKD();
        this.kls = imageRequestBuilder.cLw();
        this.kkF = imageRequestBuilder.cLy();
        this.kgv = imageRequestBuilder.cLz();
    }

    public CacheChoice cLn() {
        return this.kll;
    }

    public Uri cLo() {
        return this.klm;
    }

    public int cLp() {
        return this.kln;
    }

    @Nullable
    public a cLq() {
        return this.klo;
    }

    public int getPreferredWidth() {
        if (this.keO != null) {
            return this.keO.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.keO != null) {
            return this.keO.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cLr() {
        return this.keO;
    }

    public com.facebook.imagepipeline.common.d cLs() {
        return this.keP;
    }

    public com.facebook.imagepipeline.common.a cLt() {
        return this.keQ;
    }

    public boolean cLu() {
        return this.kha;
    }

    public boolean cLv() {
        return this.klq;
    }

    public Priority cKF() {
        return this.klr;
    }

    public RequestLevel cKD() {
        return this.kjn;
    }

    public boolean cLw() {
        return this.kls;
    }

    public synchronized File cLx() {
        if (this.klp == null) {
            this.klp = new File(this.klm.getPath());
        }
        return this.klp;
    }

    @Nullable
    public b cLy() {
        return this.kkF;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cLz() {
        return this.kgv;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.klm, imageRequest.klm) && f.equal(this.kll, imageRequest.kll) && f.equal(this.klo, imageRequest.klo) && f.equal(this.klp, imageRequest.klp);
        }
        return false;
    }

    public int hashCode() {
        return f.L(this.kll, this.klm, this.klo, this.klp);
    }

    public String toString() {
        return f.aC(this).t("uri", this.klm).t("cacheChoice", this.kll).t("decodeOptions", this.keQ).t("postprocessor", this.kkF).t("priority", this.klr).t("resizeOptions", this.keO).t("rotationOptions", this.keP).t("mediaVariations", this.klo).toString();
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
            if (com.facebook.common.d.a.HG(com.facebook.common.d.a.HH(uri.getPath()))) {
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
