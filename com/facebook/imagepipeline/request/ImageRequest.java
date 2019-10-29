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
    private final com.facebook.imagepipeline.common.c kgC;
    private final com.facebook.imagepipeline.common.d kgD;
    private final com.facebook.imagepipeline.common.a kgE;
    private final boolean kiQ;
    @Nullable
    private final com.facebook.imagepipeline.g.b kil;
    private final RequestLevel klc;
    private final b kmu;
    private final CacheChoice kna;
    private final Uri knb;
    private final int knc;
    @Nullable
    private final a knd;
    private File kne;
    private final boolean knf;
    private final Priority kng;
    private final boolean knh;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest P(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.R(uri).cJI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.kna = imageRequestBuilder.cJt();
        this.knb = imageRequestBuilder.cJu();
        this.knc = Q(this.knb);
        this.knd = imageRequestBuilder.cJw();
        this.kiQ = imageRequestBuilder.cGH();
        this.knf = imageRequestBuilder.cJG();
        this.kgE = imageRequestBuilder.cJz();
        this.kgC = imageRequestBuilder.cJx();
        this.kgD = imageRequestBuilder.cJy() == null ? com.facebook.imagepipeline.common.d.cFY() : imageRequestBuilder.cJy();
        this.kng = imageRequestBuilder.cJH();
        this.klc = imageRequestBuilder.cIJ();
        this.knh = imageRequestBuilder.cJC();
        this.kmu = imageRequestBuilder.cJE();
        this.kil = imageRequestBuilder.cJF();
    }

    public CacheChoice cJt() {
        return this.kna;
    }

    public Uri cJu() {
        return this.knb;
    }

    public int cJv() {
        return this.knc;
    }

    @Nullable
    public a cJw() {
        return this.knd;
    }

    public int getPreferredWidth() {
        if (this.kgC != null) {
            return this.kgC.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.kgC != null) {
            return this.kgC.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cJx() {
        return this.kgC;
    }

    public com.facebook.imagepipeline.common.d cJy() {
        return this.kgD;
    }

    public com.facebook.imagepipeline.common.a cJz() {
        return this.kgE;
    }

    public boolean cJA() {
        return this.kiQ;
    }

    public boolean cJB() {
        return this.knf;
    }

    public Priority cIL() {
        return this.kng;
    }

    public RequestLevel cIJ() {
        return this.klc;
    }

    public boolean cJC() {
        return this.knh;
    }

    public synchronized File cJD() {
        if (this.kne == null) {
            this.kne = new File(this.knb.getPath());
        }
        return this.kne;
    }

    @Nullable
    public b cJE() {
        return this.kmu;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cJF() {
        return this.kil;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.knb, imageRequest.knb) && f.equal(this.kna, imageRequest.kna) && f.equal(this.knd, imageRequest.knd) && f.equal(this.kne, imageRequest.kne);
        }
        return false;
    }

    public int hashCode() {
        return f.I(this.kna, this.knb, this.knd, this.kne);
    }

    public String toString() {
        return f.ax(this).q("uri", this.knb).q("cacheChoice", this.kna).q("decodeOptions", this.kgE).q("postprocessor", this.kmu).q("priority", this.kng).q("resizeOptions", this.kgC).q("rotationOptions", this.kgD).q("mediaVariations", this.knd).toString();
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

    private static int Q(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.v(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.w(uri)) {
            if (com.facebook.common.d.a.Gy(com.facebook.common.d.a.Gz(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.x(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.A(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.B(uri)) {
                return 6;
            }
            return com.facebook.common.util.d.C(uri) ? 7 : -1;
        }
    }
}
