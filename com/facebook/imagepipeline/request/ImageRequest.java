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
    private final com.facebook.imagepipeline.common.c jER;
    private final com.facebook.imagepipeline.common.d jES;
    private final com.facebook.imagepipeline.common.a jET;
    @Nullable
    private final com.facebook.imagepipeline.g.b jGx;
    private final boolean jHc;
    private final RequestLevel jJo;
    private final b jKG;
    private final CacheChoice jLm;
    private final Uri jLn;
    private final int jLo;
    @Nullable
    private final a jLp;
    private File jLq;
    private final boolean jLr;
    private final Priority jLs;
    private final boolean jLt;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest M(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.O(uri).cAB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.jLm = imageRequestBuilder.cAm();
        this.jLn = imageRequestBuilder.cAn();
        this.jLo = N(this.jLn);
        this.jLp = imageRequestBuilder.cAp();
        this.jHc = imageRequestBuilder.cxB();
        this.jLr = imageRequestBuilder.cAz();
        this.jET = imageRequestBuilder.cAs();
        this.jER = imageRequestBuilder.cAq();
        this.jES = imageRequestBuilder.cAr() == null ? com.facebook.imagepipeline.common.d.cwS() : imageRequestBuilder.cAr();
        this.jLs = imageRequestBuilder.cAA();
        this.jJo = imageRequestBuilder.czC();
        this.jLt = imageRequestBuilder.cAv();
        this.jKG = imageRequestBuilder.cAx();
        this.jGx = imageRequestBuilder.cAy();
    }

    public CacheChoice cAm() {
        return this.jLm;
    }

    public Uri cAn() {
        return this.jLn;
    }

    public int cAo() {
        return this.jLo;
    }

    @Nullable
    public a cAp() {
        return this.jLp;
    }

    public int getPreferredWidth() {
        if (this.jER != null) {
            return this.jER.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.jER != null) {
            return this.jER.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cAq() {
        return this.jER;
    }

    public com.facebook.imagepipeline.common.d cAr() {
        return this.jES;
    }

    public com.facebook.imagepipeline.common.a cAs() {
        return this.jET;
    }

    public boolean cAt() {
        return this.jHc;
    }

    public boolean cAu() {
        return this.jLr;
    }

    public Priority czE() {
        return this.jLs;
    }

    public RequestLevel czC() {
        return this.jJo;
    }

    public boolean cAv() {
        return this.jLt;
    }

    public synchronized File cAw() {
        if (this.jLq == null) {
            this.jLq = new File(this.jLn.getPath());
        }
        return this.jLq;
    }

    @Nullable
    public b cAx() {
        return this.jKG;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cAy() {
        return this.jGx;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.jLn, imageRequest.jLn) && f.equal(this.jLm, imageRequest.jLm) && f.equal(this.jLp, imageRequest.jLp) && f.equal(this.jLq, imageRequest.jLq);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.jLm, this.jLn, this.jLp, this.jLq);
    }

    public String toString() {
        return f.aA(this).q("uri", this.jLn).q("cacheChoice", this.jLm).q("decodeOptions", this.jET).q("postprocessor", this.jKG).q("priority", this.jLs).q("resizeOptions", this.jER).q("rotationOptions", this.jES).q("mediaVariations", this.jLp).toString();
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
            if (com.facebook.common.d.a.Fp(com.facebook.common.d.a.Fq(uri.getPath()))) {
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
