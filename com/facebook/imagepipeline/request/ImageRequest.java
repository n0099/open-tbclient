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
    private final com.facebook.imagepipeline.common.c kis;
    private final com.facebook.imagepipeline.common.d kit;
    private final com.facebook.imagepipeline.common.a kiu;
    @Nullable
    private final com.facebook.imagepipeline.g.b kjZ;
    private final boolean kkE;
    private final RequestLevel kmQ;
    private final CacheChoice koO;
    private final Uri koP;
    private final int koQ;
    @Nullable
    private final a koR;
    private File koS;
    private final boolean koT;
    private final Priority koU;
    private final boolean koV;
    private final b koi;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest S(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.U(uri).cML();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.koO = imageRequestBuilder.cMw();
        this.koP = imageRequestBuilder.cMx();
        this.koQ = T(this.koP);
        this.koR = imageRequestBuilder.cMz();
        this.kkE = imageRequestBuilder.cJK();
        this.koT = imageRequestBuilder.cMJ();
        this.kiu = imageRequestBuilder.cMC();
        this.kis = imageRequestBuilder.cMA();
        this.kit = imageRequestBuilder.cMB() == null ? com.facebook.imagepipeline.common.d.cJb() : imageRequestBuilder.cMB();
        this.koU = imageRequestBuilder.cMK();
        this.kmQ = imageRequestBuilder.cLM();
        this.koV = imageRequestBuilder.cMF();
        this.koi = imageRequestBuilder.cMH();
        this.kjZ = imageRequestBuilder.cMI();
    }

    public CacheChoice cMw() {
        return this.koO;
    }

    public Uri cMx() {
        return this.koP;
    }

    public int cMy() {
        return this.koQ;
    }

    @Nullable
    public a cMz() {
        return this.koR;
    }

    public int getPreferredWidth() {
        if (this.kis != null) {
            return this.kis.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.kis != null) {
            return this.kis.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cMA() {
        return this.kis;
    }

    public com.facebook.imagepipeline.common.d cMB() {
        return this.kit;
    }

    public com.facebook.imagepipeline.common.a cMC() {
        return this.kiu;
    }

    public boolean cMD() {
        return this.kkE;
    }

    public boolean cME() {
        return this.koT;
    }

    public Priority cLO() {
        return this.koU;
    }

    public RequestLevel cLM() {
        return this.kmQ;
    }

    public boolean cMF() {
        return this.koV;
    }

    public synchronized File cMG() {
        if (this.koS == null) {
            this.koS = new File(this.koP.getPath());
        }
        return this.koS;
    }

    @Nullable
    public b cMH() {
        return this.koi;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cMI() {
        return this.kjZ;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.koP, imageRequest.koP) && f.equal(this.koO, imageRequest.koO) && f.equal(this.koR, imageRequest.koR) && f.equal(this.koS, imageRequest.koS);
        }
        return false;
    }

    public int hashCode() {
        return f.L(this.koO, this.koP, this.koR, this.koS);
    }

    public String toString() {
        return f.aC(this).t("uri", this.koP).t("cacheChoice", this.koO).t("decodeOptions", this.kiu).t("postprocessor", this.koi).t("priority", this.koU).t("resizeOptions", this.kis).t("rotationOptions", this.kit).t("mediaVariations", this.koR).toString();
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
            if (com.facebook.common.d.a.Ih(com.facebook.common.d.a.Ii(uri.getPath()))) {
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
