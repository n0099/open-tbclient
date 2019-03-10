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
    private final com.facebook.imagepipeline.common.c jFF;
    private final com.facebook.imagepipeline.common.d jFG;
    private final com.facebook.imagepipeline.common.a jFH;
    private final boolean jHQ;
    @Nullable
    private final com.facebook.imagepipeline.g.b jHl;
    private final RequestLevel jKc;
    private final b jLu;
    private final CacheChoice jMa;
    private final Uri jMb;
    private final int jMc;
    @Nullable
    private final a jMd;
    private File jMe;
    private final boolean jMf;
    private final Priority jMg;
    private final boolean jMh;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest M(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.O(uri).cAF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.jMa = imageRequestBuilder.cAq();
        this.jMb = imageRequestBuilder.cAr();
        this.jMc = N(this.jMb);
        this.jMd = imageRequestBuilder.cAt();
        this.jHQ = imageRequestBuilder.cxF();
        this.jMf = imageRequestBuilder.cAD();
        this.jFH = imageRequestBuilder.cAw();
        this.jFF = imageRequestBuilder.cAu();
        this.jFG = imageRequestBuilder.cAv() == null ? com.facebook.imagepipeline.common.d.cwW() : imageRequestBuilder.cAv();
        this.jMg = imageRequestBuilder.cAE();
        this.jKc = imageRequestBuilder.czG();
        this.jMh = imageRequestBuilder.cAz();
        this.jLu = imageRequestBuilder.cAB();
        this.jHl = imageRequestBuilder.cAC();
    }

    public CacheChoice cAq() {
        return this.jMa;
    }

    public Uri cAr() {
        return this.jMb;
    }

    public int cAs() {
        return this.jMc;
    }

    @Nullable
    public a cAt() {
        return this.jMd;
    }

    public int getPreferredWidth() {
        if (this.jFF != null) {
            return this.jFF.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.jFF != null) {
            return this.jFF.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cAu() {
        return this.jFF;
    }

    public com.facebook.imagepipeline.common.d cAv() {
        return this.jFG;
    }

    public com.facebook.imagepipeline.common.a cAw() {
        return this.jFH;
    }

    public boolean cAx() {
        return this.jHQ;
    }

    public boolean cAy() {
        return this.jMf;
    }

    public Priority czI() {
        return this.jMg;
    }

    public RequestLevel czG() {
        return this.jKc;
    }

    public boolean cAz() {
        return this.jMh;
    }

    public synchronized File cAA() {
        if (this.jMe == null) {
            this.jMe = new File(this.jMb.getPath());
        }
        return this.jMe;
    }

    @Nullable
    public b cAB() {
        return this.jLu;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cAC() {
        return this.jHl;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.jMb, imageRequest.jMb) && f.equal(this.jMa, imageRequest.jMa) && f.equal(this.jMd, imageRequest.jMd) && f.equal(this.jMe, imageRequest.jMe);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.jMa, this.jMb, this.jMd, this.jMe);
    }

    public String toString() {
        return f.aE(this).q("uri", this.jMb).q("cacheChoice", this.jMa).q("decodeOptions", this.jFH).q("postprocessor", this.jLu).q(LogFactory.PRIORITY_KEY, this.jMg).q("resizeOptions", this.jFF).q("rotationOptions", this.jFG).q("mediaVariations", this.jMd).toString();
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
            if (com.facebook.common.d.a.FB(com.facebook.common.d.a.FC(uri.getPath()))) {
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
