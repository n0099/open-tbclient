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
    private final com.facebook.imagepipeline.common.c ipF;
    private final com.facebook.imagepipeline.common.d ipG;
    private final com.facebook.imagepipeline.common.a ipH;
    private final boolean irQ;
    @Nullable
    private final com.facebook.imagepipeline.g.b irl;
    private final RequestLevel iua;
    private final CacheChoice ivW;
    private final Uri ivX;
    private final int ivY;
    @Nullable
    private final a ivZ;
    private final b ivr;
    private File iwa;
    private final boolean iwb;
    private final Priority iwc;
    private final boolean iwd;

    /* loaded from: classes2.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest E(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.G(uri).cbq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.ivW = imageRequestBuilder.cbb();
        this.ivX = imageRequestBuilder.cbc();
        this.ivY = F(this.ivX);
        this.ivZ = imageRequestBuilder.cbe();
        this.irQ = imageRequestBuilder.bYu();
        this.iwb = imageRequestBuilder.cbo();
        this.ipH = imageRequestBuilder.cbh();
        this.ipF = imageRequestBuilder.cbf();
        this.ipG = imageRequestBuilder.cbg() == null ? com.facebook.imagepipeline.common.d.bXL() : imageRequestBuilder.cbg();
        this.iwc = imageRequestBuilder.cbp();
        this.iua = imageRequestBuilder.car();
        this.iwd = imageRequestBuilder.cbk();
        this.ivr = imageRequestBuilder.cbm();
        this.irl = imageRequestBuilder.cbn();
    }

    public CacheChoice cbb() {
        return this.ivW;
    }

    public Uri cbc() {
        return this.ivX;
    }

    public int cbd() {
        return this.ivY;
    }

    @Nullable
    public a cbe() {
        return this.ivZ;
    }

    public int getPreferredWidth() {
        if (this.ipF != null) {
            return this.ipF.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.ipF != null) {
            return this.ipF.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cbf() {
        return this.ipF;
    }

    public com.facebook.imagepipeline.common.d cbg() {
        return this.ipG;
    }

    public com.facebook.imagepipeline.common.a cbh() {
        return this.ipH;
    }

    public boolean cbi() {
        return this.irQ;
    }

    public boolean cbj() {
        return this.iwb;
    }

    public Priority cat() {
        return this.iwc;
    }

    public RequestLevel car() {
        return this.iua;
    }

    public boolean cbk() {
        return this.iwd;
    }

    public synchronized File cbl() {
        if (this.iwa == null) {
            this.iwa = new File(this.ivX.getPath());
        }
        return this.iwa;
    }

    @Nullable
    public b cbm() {
        return this.ivr;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cbn() {
        return this.irl;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.ivX, imageRequest.ivX) && f.equal(this.ivW, imageRequest.ivW) && f.equal(this.ivZ, imageRequest.ivZ) && f.equal(this.iwa, imageRequest.iwa);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.ivW, this.ivX, this.ivZ, this.iwa);
    }

    public String toString() {
        return f.ao(this).n("uri", this.ivX).n("cacheChoice", this.ivW).n("decodeOptions", this.ipH).n("postprocessor", this.ivr).n(LogFactory.PRIORITY_KEY, this.iwc).n("resizeOptions", this.ipF).n("rotationOptions", this.ipG).n("mediaVariations", this.ivZ).toString();
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
            if (com.facebook.common.d.a.zw(com.facebook.common.d.a.zx(uri.getPath()))) {
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
