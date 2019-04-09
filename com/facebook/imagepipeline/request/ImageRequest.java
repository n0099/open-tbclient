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
    private final com.facebook.imagepipeline.common.c jES;
    private final com.facebook.imagepipeline.common.d jET;
    private final com.facebook.imagepipeline.common.a jEU;
    @Nullable
    private final com.facebook.imagepipeline.g.b jGy;
    private final boolean jHd;
    private final RequestLevel jJp;
    private final b jKH;
    private final CacheChoice jLn;
    private final Uri jLo;
    private final int jLp;
    @Nullable
    private final a jLq;
    private File jLr;
    private final boolean jLs;
    private final Priority jLt;
    private final boolean jLu;

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
        this.jLn = imageRequestBuilder.cAm();
        this.jLo = imageRequestBuilder.cAn();
        this.jLp = N(this.jLo);
        this.jLq = imageRequestBuilder.cAp();
        this.jHd = imageRequestBuilder.cxB();
        this.jLs = imageRequestBuilder.cAz();
        this.jEU = imageRequestBuilder.cAs();
        this.jES = imageRequestBuilder.cAq();
        this.jET = imageRequestBuilder.cAr() == null ? com.facebook.imagepipeline.common.d.cwS() : imageRequestBuilder.cAr();
        this.jLt = imageRequestBuilder.cAA();
        this.jJp = imageRequestBuilder.czC();
        this.jLu = imageRequestBuilder.cAv();
        this.jKH = imageRequestBuilder.cAx();
        this.jGy = imageRequestBuilder.cAy();
    }

    public CacheChoice cAm() {
        return this.jLn;
    }

    public Uri cAn() {
        return this.jLo;
    }

    public int cAo() {
        return this.jLp;
    }

    @Nullable
    public a cAp() {
        return this.jLq;
    }

    public int getPreferredWidth() {
        if (this.jES != null) {
            return this.jES.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.jES != null) {
            return this.jES.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cAq() {
        return this.jES;
    }

    public com.facebook.imagepipeline.common.d cAr() {
        return this.jET;
    }

    public com.facebook.imagepipeline.common.a cAs() {
        return this.jEU;
    }

    public boolean cAt() {
        return this.jHd;
    }

    public boolean cAu() {
        return this.jLs;
    }

    public Priority czE() {
        return this.jLt;
    }

    public RequestLevel czC() {
        return this.jJp;
    }

    public boolean cAv() {
        return this.jLu;
    }

    public synchronized File cAw() {
        if (this.jLr == null) {
            this.jLr = new File(this.jLo.getPath());
        }
        return this.jLr;
    }

    @Nullable
    public b cAx() {
        return this.jKH;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cAy() {
        return this.jGy;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.jLo, imageRequest.jLo) && f.equal(this.jLn, imageRequest.jLn) && f.equal(this.jLq, imageRequest.jLq) && f.equal(this.jLr, imageRequest.jLr);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.jLn, this.jLo, this.jLq, this.jLr);
    }

    public String toString() {
        return f.aA(this).q("uri", this.jLo).q("cacheChoice", this.jLn).q("decodeOptions", this.jEU).q("postprocessor", this.jKH).q("priority", this.jLt).q("resizeOptions", this.jES).q("rotationOptions", this.jET).q("mediaVariations", this.jLq).toString();
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
