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
    @Nullable
    private final com.facebook.imagepipeline.common.c jFm;
    private final com.facebook.imagepipeline.common.d jFn;
    private final com.facebook.imagepipeline.common.a jFo;
    @Nullable
    private final com.facebook.imagepipeline.g.b jGS;
    private final boolean jHx;
    private final RequestLevel jJJ;
    private final CacheChoice jLH;
    private final Uri jLI;
    private final int jLJ;
    @Nullable
    private final a jLK;
    private File jLL;
    private final boolean jLM;
    private final Priority jLN;
    private final boolean jLO;
    private final b jLb;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest M(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.O(uri).cAv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.jLH = imageRequestBuilder.cAg();
        this.jLI = imageRequestBuilder.cAh();
        this.jLJ = N(this.jLI);
        this.jLK = imageRequestBuilder.cAj();
        this.jHx = imageRequestBuilder.cxv();
        this.jLM = imageRequestBuilder.cAt();
        this.jFo = imageRequestBuilder.cAm();
        this.jFm = imageRequestBuilder.cAk();
        this.jFn = imageRequestBuilder.cAl() == null ? com.facebook.imagepipeline.common.d.cwM() : imageRequestBuilder.cAl();
        this.jLN = imageRequestBuilder.cAu();
        this.jJJ = imageRequestBuilder.czw();
        this.jLO = imageRequestBuilder.cAp();
        this.jLb = imageRequestBuilder.cAr();
        this.jGS = imageRequestBuilder.cAs();
    }

    public CacheChoice cAg() {
        return this.jLH;
    }

    public Uri cAh() {
        return this.jLI;
    }

    public int cAi() {
        return this.jLJ;
    }

    @Nullable
    public a cAj() {
        return this.jLK;
    }

    public int getPreferredWidth() {
        if (this.jFm != null) {
            return this.jFm.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.jFm != null) {
            return this.jFm.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cAk() {
        return this.jFm;
    }

    public com.facebook.imagepipeline.common.d cAl() {
        return this.jFn;
    }

    public com.facebook.imagepipeline.common.a cAm() {
        return this.jFo;
    }

    public boolean cAn() {
        return this.jHx;
    }

    public boolean cAo() {
        return this.jLM;
    }

    public Priority czy() {
        return this.jLN;
    }

    public RequestLevel czw() {
        return this.jJJ;
    }

    public boolean cAp() {
        return this.jLO;
    }

    public synchronized File cAq() {
        if (this.jLL == null) {
            this.jLL = new File(this.jLI.getPath());
        }
        return this.jLL;
    }

    @Nullable
    public b cAr() {
        return this.jLb;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cAs() {
        return this.jGS;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.jLI, imageRequest.jLI) && f.equal(this.jLH, imageRequest.jLH) && f.equal(this.jLK, imageRequest.jLK) && f.equal(this.jLL, imageRequest.jLL);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.jLH, this.jLI, this.jLK, this.jLL);
    }

    public String toString() {
        return f.aD(this).q("uri", this.jLI).q("cacheChoice", this.jLH).q("decodeOptions", this.jFo).q("postprocessor", this.jLb).q(LogFactory.PRIORITY_KEY, this.jLN).q("resizeOptions", this.jFm).q("rotationOptions", this.jFn).q("mediaVariations", this.jLK).toString();
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
            if (com.facebook.common.d.a.Fy(com.facebook.common.d.a.Fz(uri.getPath()))) {
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
