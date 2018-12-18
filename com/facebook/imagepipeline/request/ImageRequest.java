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
    private final com.facebook.imagepipeline.common.c ilm;
    private final com.facebook.imagepipeline.common.d iln;
    private final com.facebook.imagepipeline.common.a ilo;
    @Nullable
    private final com.facebook.imagepipeline.g.b imT;
    private final boolean inz;
    private final RequestLevel ipJ;
    private final CacheChoice irF;
    private final Uri irG;
    private final int irH;
    @Nullable
    private final a irI;
    private File irJ;
    private final boolean irK;
    private final Priority irL;
    private final boolean irM;
    private final b ira;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest E(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.G(uri).bZR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.irF = imageRequestBuilder.bZC();
        this.irG = imageRequestBuilder.bZD();
        this.irH = F(this.irG);
        this.irI = imageRequestBuilder.bZF();
        this.inz = imageRequestBuilder.bWV();
        this.irK = imageRequestBuilder.bZP();
        this.ilo = imageRequestBuilder.bZI();
        this.ilm = imageRequestBuilder.bZG();
        this.iln = imageRequestBuilder.bZH() == null ? com.facebook.imagepipeline.common.d.bWm() : imageRequestBuilder.bZH();
        this.irL = imageRequestBuilder.bZQ();
        this.ipJ = imageRequestBuilder.bYS();
        this.irM = imageRequestBuilder.bZL();
        this.ira = imageRequestBuilder.bZN();
        this.imT = imageRequestBuilder.bZO();
    }

    public CacheChoice bZC() {
        return this.irF;
    }

    public Uri bZD() {
        return this.irG;
    }

    public int bZE() {
        return this.irH;
    }

    @Nullable
    public a bZF() {
        return this.irI;
    }

    public int getPreferredWidth() {
        if (this.ilm != null) {
            return this.ilm.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.ilm != null) {
            return this.ilm.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c bZG() {
        return this.ilm;
    }

    public com.facebook.imagepipeline.common.d bZH() {
        return this.iln;
    }

    public com.facebook.imagepipeline.common.a bZI() {
        return this.ilo;
    }

    public boolean bZJ() {
        return this.inz;
    }

    public boolean bZK() {
        return this.irK;
    }

    public Priority bYU() {
        return this.irL;
    }

    public RequestLevel bYS() {
        return this.ipJ;
    }

    public boolean bZL() {
        return this.irM;
    }

    public synchronized File bZM() {
        if (this.irJ == null) {
            this.irJ = new File(this.irG.getPath());
        }
        return this.irJ;
    }

    @Nullable
    public b bZN() {
        return this.ira;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b bZO() {
        return this.imT;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.irG, imageRequest.irG) && f.equal(this.irF, imageRequest.irF) && f.equal(this.irI, imageRequest.irI) && f.equal(this.irJ, imageRequest.irJ);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.irF, this.irG, this.irI, this.irJ);
    }

    public String toString() {
        return f.ao(this).n("uri", this.irG).n("cacheChoice", this.irF).n("decodeOptions", this.ilo).n("postprocessor", this.ira).n(LogFactory.PRIORITY_KEY, this.irL).n("resizeOptions", this.ilm).n("rotationOptions", this.iln).n("mediaVariations", this.irI).toString();
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
            if (com.facebook.common.d.a.zd(com.facebook.common.d.a.ze(uri.getPath()))) {
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
