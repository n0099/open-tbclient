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
    private final com.facebook.imagepipeline.common.c ico;
    private final com.facebook.imagepipeline.common.d icp;
    private final com.facebook.imagepipeline.common.a icq;
    @Nullable
    private final com.facebook.imagepipeline.g.b idX;
    private final boolean ieC;
    private final RequestLevel igM;
    private final CacheChoice iiI;
    private final Uri iiJ;
    private final int iiK;
    @Nullable
    private final a iiL;
    private File iiM;
    private final boolean iiN;
    private final Priority iiO;
    private final boolean iiP;
    private final b iid;

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
        this.iiI = imageRequestBuilder.bYc();
        this.iiJ = imageRequestBuilder.bYd();
        this.iiK = E(this.iiJ);
        this.iiL = imageRequestBuilder.bYf();
        this.ieC = imageRequestBuilder.bVv();
        this.iiN = imageRequestBuilder.bYp();
        this.icq = imageRequestBuilder.bYi();
        this.ico = imageRequestBuilder.bYg();
        this.icp = imageRequestBuilder.bYh() == null ? com.facebook.imagepipeline.common.d.bUM() : imageRequestBuilder.bYh();
        this.iiO = imageRequestBuilder.bYq();
        this.igM = imageRequestBuilder.bXs();
        this.iiP = imageRequestBuilder.bYl();
        this.iid = imageRequestBuilder.bYn();
        this.idX = imageRequestBuilder.bYo();
    }

    public CacheChoice bYc() {
        return this.iiI;
    }

    public Uri bYd() {
        return this.iiJ;
    }

    public int bYe() {
        return this.iiK;
    }

    @Nullable
    public a bYf() {
        return this.iiL;
    }

    public int getPreferredWidth() {
        if (this.ico != null) {
            return this.ico.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.ico != null) {
            return this.ico.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c bYg() {
        return this.ico;
    }

    public com.facebook.imagepipeline.common.d bYh() {
        return this.icp;
    }

    public com.facebook.imagepipeline.common.a bYi() {
        return this.icq;
    }

    public boolean bYj() {
        return this.ieC;
    }

    public boolean bYk() {
        return this.iiN;
    }

    public Priority bXu() {
        return this.iiO;
    }

    public RequestLevel bXs() {
        return this.igM;
    }

    public boolean bYl() {
        return this.iiP;
    }

    public synchronized File bYm() {
        if (this.iiM == null) {
            this.iiM = new File(this.iiJ.getPath());
        }
        return this.iiM;
    }

    @Nullable
    public b bYn() {
        return this.iid;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b bYo() {
        return this.idX;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.iiJ, imageRequest.iiJ) && f.equal(this.iiI, imageRequest.iiI) && f.equal(this.iiL, imageRequest.iiL) && f.equal(this.iiM, imageRequest.iiM);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.iiI, this.iiJ, this.iiL, this.iiM);
    }

    public String toString() {
        return f.ao(this).n("uri", this.iiJ).n("cacheChoice", this.iiI).n("decodeOptions", this.icq).n("postprocessor", this.iid).n(LogFactory.PRIORITY_KEY, this.iiO).n("resizeOptions", this.ico).n("rotationOptions", this.icp).n("mediaVariations", this.iiL).toString();
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
