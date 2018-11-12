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
    private final com.facebook.imagepipeline.common.c iec;
    private final com.facebook.imagepipeline.common.d ied;
    private final com.facebook.imagepipeline.common.a iee;
    @Nullable
    private final com.facebook.imagepipeline.g.b ifI;
    private final boolean ign;
    private final RequestLevel iix;
    private final b ijO;
    private final boolean ikA;
    private final CacheChoice ikt;
    private final Uri iku;
    private final int ikv;
    @Nullable
    private final a ikw;
    private File ikx;
    private final boolean iky;
    private final Priority ikz;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest D(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.F(uri).bXM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.ikt = imageRequestBuilder.bXx();
        this.iku = imageRequestBuilder.bXy();
        this.ikv = E(this.iku);
        this.ikw = imageRequestBuilder.bXA();
        this.ign = imageRequestBuilder.bUQ();
        this.iky = imageRequestBuilder.bXK();
        this.iee = imageRequestBuilder.bXD();
        this.iec = imageRequestBuilder.bXB();
        this.ied = imageRequestBuilder.bXC() == null ? com.facebook.imagepipeline.common.d.bUh() : imageRequestBuilder.bXC();
        this.ikz = imageRequestBuilder.bXL();
        this.iix = imageRequestBuilder.bWN();
        this.ikA = imageRequestBuilder.bXG();
        this.ijO = imageRequestBuilder.bXI();
        this.ifI = imageRequestBuilder.bXJ();
    }

    public CacheChoice bXx() {
        return this.ikt;
    }

    public Uri bXy() {
        return this.iku;
    }

    public int bXz() {
        return this.ikv;
    }

    @Nullable
    public a bXA() {
        return this.ikw;
    }

    public int getPreferredWidth() {
        if (this.iec != null) {
            return this.iec.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.iec != null) {
            return this.iec.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c bXB() {
        return this.iec;
    }

    public com.facebook.imagepipeline.common.d bXC() {
        return this.ied;
    }

    public com.facebook.imagepipeline.common.a bXD() {
        return this.iee;
    }

    public boolean bXE() {
        return this.ign;
    }

    public boolean bXF() {
        return this.iky;
    }

    public Priority bWP() {
        return this.ikz;
    }

    public RequestLevel bWN() {
        return this.iix;
    }

    public boolean bXG() {
        return this.ikA;
    }

    public synchronized File bXH() {
        if (this.ikx == null) {
            this.ikx = new File(this.iku.getPath());
        }
        return this.ikx;
    }

    @Nullable
    public b bXI() {
        return this.ijO;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b bXJ() {
        return this.ifI;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.iku, imageRequest.iku) && f.equal(this.ikt, imageRequest.ikt) && f.equal(this.ikw, imageRequest.ikw) && f.equal(this.ikx, imageRequest.ikx);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.ikt, this.iku, this.ikw, this.ikx);
    }

    public String toString() {
        return f.an(this).n("uri", this.iku).n("cacheChoice", this.ikt).n("decodeOptions", this.iee).n("postprocessor", this.ijO).n(LogFactory.PRIORITY_KEY, this.ikz).n("resizeOptions", this.iec).n("rotationOptions", this.ied).n("mediaVariations", this.ikw).toString();
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
            if (com.facebook.common.d.a.yA(com.facebook.common.d.a.yB(uri.getPath()))) {
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
