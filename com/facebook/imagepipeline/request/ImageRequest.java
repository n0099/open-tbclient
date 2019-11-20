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
    private final com.facebook.imagepipeline.common.c kfL;
    private final com.facebook.imagepipeline.common.d kfM;
    private final com.facebook.imagepipeline.common.a kfN;
    private final boolean khY;
    @Nullable
    private final com.facebook.imagepipeline.g.b kht;
    private final RequestLevel kkl;
    private final b klD;
    private final CacheChoice kmj;
    private final Uri kmk;
    private final int kml;
    @Nullable
    private final a kmm;
    private File kmn;
    private final boolean kmo;
    private final Priority kmp;
    private final boolean kmq;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest P(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.R(uri).cJG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.kmj = imageRequestBuilder.cJr();
        this.kmk = imageRequestBuilder.cJs();
        this.kml = Q(this.kmk);
        this.kmm = imageRequestBuilder.cJu();
        this.khY = imageRequestBuilder.cGF();
        this.kmo = imageRequestBuilder.cJE();
        this.kfN = imageRequestBuilder.cJx();
        this.kfL = imageRequestBuilder.cJv();
        this.kfM = imageRequestBuilder.cJw() == null ? com.facebook.imagepipeline.common.d.cFW() : imageRequestBuilder.cJw();
        this.kmp = imageRequestBuilder.cJF();
        this.kkl = imageRequestBuilder.cIH();
        this.kmq = imageRequestBuilder.cJA();
        this.klD = imageRequestBuilder.cJC();
        this.kht = imageRequestBuilder.cJD();
    }

    public CacheChoice cJr() {
        return this.kmj;
    }

    public Uri cJs() {
        return this.kmk;
    }

    public int cJt() {
        return this.kml;
    }

    @Nullable
    public a cJu() {
        return this.kmm;
    }

    public int getPreferredWidth() {
        if (this.kfL != null) {
            return this.kfL.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.kfL != null) {
            return this.kfL.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cJv() {
        return this.kfL;
    }

    public com.facebook.imagepipeline.common.d cJw() {
        return this.kfM;
    }

    public com.facebook.imagepipeline.common.a cJx() {
        return this.kfN;
    }

    public boolean cJy() {
        return this.khY;
    }

    public boolean cJz() {
        return this.kmo;
    }

    public Priority cIJ() {
        return this.kmp;
    }

    public RequestLevel cIH() {
        return this.kkl;
    }

    public boolean cJA() {
        return this.kmq;
    }

    public synchronized File cJB() {
        if (this.kmn == null) {
            this.kmn = new File(this.kmk.getPath());
        }
        return this.kmn;
    }

    @Nullable
    public b cJC() {
        return this.klD;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cJD() {
        return this.kht;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.kmk, imageRequest.kmk) && f.equal(this.kmj, imageRequest.kmj) && f.equal(this.kmm, imageRequest.kmm) && f.equal(this.kmn, imageRequest.kmn);
        }
        return false;
    }

    public int hashCode() {
        return f.I(this.kmj, this.kmk, this.kmm, this.kmn);
    }

    public String toString() {
        return f.ax(this).q("uri", this.kmk).q("cacheChoice", this.kmj).q("decodeOptions", this.kfN).q("postprocessor", this.klD).q("priority", this.kmp).q("resizeOptions", this.kfL).q("rotationOptions", this.kfM).q("mediaVariations", this.kmm).toString();
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
