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
    private final com.facebook.imagepipeline.common.c icp;
    private final com.facebook.imagepipeline.common.d icq;
    private final com.facebook.imagepipeline.common.a icr;
    @Nullable
    private final com.facebook.imagepipeline.g.b idY;
    private final boolean ieD;
    private final RequestLevel igN;
    private final CacheChoice iiJ;
    private final Uri iiK;
    private final int iiL;
    @Nullable
    private final a iiM;
    private File iiN;
    private final boolean iiO;
    private final Priority iiP;
    private final boolean iiQ;
    private final b iie;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest D(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.F(uri).bYr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.iiJ = imageRequestBuilder.bYc();
        this.iiK = imageRequestBuilder.bYd();
        this.iiL = E(this.iiK);
        this.iiM = imageRequestBuilder.bYf();
        this.ieD = imageRequestBuilder.bVv();
        this.iiO = imageRequestBuilder.bYp();
        this.icr = imageRequestBuilder.bYi();
        this.icp = imageRequestBuilder.bYg();
        this.icq = imageRequestBuilder.bYh() == null ? com.facebook.imagepipeline.common.d.bUM() : imageRequestBuilder.bYh();
        this.iiP = imageRequestBuilder.bYq();
        this.igN = imageRequestBuilder.bXs();
        this.iiQ = imageRequestBuilder.bYl();
        this.iie = imageRequestBuilder.bYn();
        this.idY = imageRequestBuilder.bYo();
    }

    public CacheChoice bYc() {
        return this.iiJ;
    }

    public Uri bYd() {
        return this.iiK;
    }

    public int bYe() {
        return this.iiL;
    }

    @Nullable
    public a bYf() {
        return this.iiM;
    }

    public int getPreferredWidth() {
        if (this.icp != null) {
            return this.icp.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.icp != null) {
            return this.icp.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c bYg() {
        return this.icp;
    }

    public com.facebook.imagepipeline.common.d bYh() {
        return this.icq;
    }

    public com.facebook.imagepipeline.common.a bYi() {
        return this.icr;
    }

    public boolean bYj() {
        return this.ieD;
    }

    public boolean bYk() {
        return this.iiO;
    }

    public Priority bXu() {
        return this.iiP;
    }

    public RequestLevel bXs() {
        return this.igN;
    }

    public boolean bYl() {
        return this.iiQ;
    }

    public synchronized File bYm() {
        if (this.iiN == null) {
            this.iiN = new File(this.iiK.getPath());
        }
        return this.iiN;
    }

    @Nullable
    public b bYn() {
        return this.iie;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b bYo() {
        return this.idY;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.iiK, imageRequest.iiK) && f.equal(this.iiJ, imageRequest.iiJ) && f.equal(this.iiM, imageRequest.iiM) && f.equal(this.iiN, imageRequest.iiN);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.iiJ, this.iiK, this.iiM, this.iiN);
    }

    public String toString() {
        return f.ao(this).n("uri", this.iiK).n("cacheChoice", this.iiJ).n("decodeOptions", this.icr).n("postprocessor", this.iie).n(LogFactory.PRIORITY_KEY, this.iiP).n("resizeOptions", this.icp).n("rotationOptions", this.icq).n("mediaVariations", this.iiM).toString();
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

    private static int E(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.j(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.k(uri)) {
            if (com.facebook.common.d.a.yv(com.facebook.common.d.a.yw(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.l(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.o(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.p(uri)) {
                return 6;
            }
            return com.facebook.common.util.d.q(uri) ? 7 : -1;
        }
    }
}
