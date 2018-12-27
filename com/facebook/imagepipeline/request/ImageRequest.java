package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.common.Priority;
import java.io.File;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.apache.commons.logging.LogFactory;
@Immutable
/* loaded from: classes2.dex */
public class ImageRequest {
    private final com.facebook.imagepipeline.common.a ioA;
    @Nullable
    private final com.facebook.imagepipeline.common.c ioy;
    private final com.facebook.imagepipeline.common.d ioz;
    private final boolean iqJ;
    @Nullable
    private final com.facebook.imagepipeline.g.b iqe;
    private final RequestLevel isT;
    private final CacheChoice iuP;
    private final Uri iuQ;
    private final int iuR;
    @Nullable
    private final a iuS;
    private File iuT;
    private final boolean iuU;
    private final Priority iuV;
    private final boolean iuW;
    private final b iuk;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest E(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.G(uri).caI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.iuP = imageRequestBuilder.cat();
        this.iuQ = imageRequestBuilder.cau();
        this.iuR = F(this.iuQ);
        this.iuS = imageRequestBuilder.caw();
        this.iqJ = imageRequestBuilder.bXM();
        this.iuU = imageRequestBuilder.caG();
        this.ioA = imageRequestBuilder.caz();
        this.ioy = imageRequestBuilder.cax();
        this.ioz = imageRequestBuilder.cay() == null ? com.facebook.imagepipeline.common.d.bXd() : imageRequestBuilder.cay();
        this.iuV = imageRequestBuilder.caH();
        this.isT = imageRequestBuilder.bZJ();
        this.iuW = imageRequestBuilder.caC();
        this.iuk = imageRequestBuilder.caE();
        this.iqe = imageRequestBuilder.caF();
    }

    public CacheChoice cat() {
        return this.iuP;
    }

    public Uri cau() {
        return this.iuQ;
    }

    public int cav() {
        return this.iuR;
    }

    @Nullable
    public a caw() {
        return this.iuS;
    }

    public int getPreferredWidth() {
        if (this.ioy != null) {
            return this.ioy.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.ioy != null) {
            return this.ioy.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cax() {
        return this.ioy;
    }

    public com.facebook.imagepipeline.common.d cay() {
        return this.ioz;
    }

    public com.facebook.imagepipeline.common.a caz() {
        return this.ioA;
    }

    public boolean caA() {
        return this.iqJ;
    }

    public boolean caB() {
        return this.iuU;
    }

    public Priority bZL() {
        return this.iuV;
    }

    public RequestLevel bZJ() {
        return this.isT;
    }

    public boolean caC() {
        return this.iuW;
    }

    public synchronized File caD() {
        if (this.iuT == null) {
            this.iuT = new File(this.iuQ.getPath());
        }
        return this.iuT;
    }

    @Nullable
    public b caE() {
        return this.iuk;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b caF() {
        return this.iqe;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.iuQ, imageRequest.iuQ) && f.equal(this.iuP, imageRequest.iuP) && f.equal(this.iuS, imageRequest.iuS) && f.equal(this.iuT, imageRequest.iuT);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.iuP, this.iuQ, this.iuS, this.iuT);
    }

    public String toString() {
        return f.ao(this).n("uri", this.iuQ).n("cacheChoice", this.iuP).n("decodeOptions", this.ioA).n("postprocessor", this.iuk).n(LogFactory.PRIORITY_KEY, this.iuV).n("resizeOptions", this.ioy).n("rotationOptions", this.ioz).n("mediaVariations", this.iuS).toString();
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

    private static int F(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.k(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.l(uri)) {
            if (com.facebook.common.d.a.zg(com.facebook.common.d.a.zh(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.m(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.p(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.q(uri)) {
                return 6;
            }
            return com.facebook.common.util.d.r(uri) ? 7 : -1;
        }
    }
}
