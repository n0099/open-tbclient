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
    private final com.facebook.imagepipeline.common.c ipG;
    private final com.facebook.imagepipeline.common.d ipH;
    private final com.facebook.imagepipeline.common.a ipI;
    private final boolean irR;
    @Nullable
    private final com.facebook.imagepipeline.g.b irm;
    private final RequestLevel iub;
    private final CacheChoice ivX;
    private final Uri ivY;
    private final int ivZ;
    private final b ivs;
    @Nullable
    private final a iwa;
    private File iwb;
    private final boolean iwc;
    private final Priority iwd;
    private final boolean iwe;

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
        this.ivX = imageRequestBuilder.cbb();
        this.ivY = imageRequestBuilder.cbc();
        this.ivZ = F(this.ivY);
        this.iwa = imageRequestBuilder.cbe();
        this.irR = imageRequestBuilder.bYu();
        this.iwc = imageRequestBuilder.cbo();
        this.ipI = imageRequestBuilder.cbh();
        this.ipG = imageRequestBuilder.cbf();
        this.ipH = imageRequestBuilder.cbg() == null ? com.facebook.imagepipeline.common.d.bXL() : imageRequestBuilder.cbg();
        this.iwd = imageRequestBuilder.cbp();
        this.iub = imageRequestBuilder.car();
        this.iwe = imageRequestBuilder.cbk();
        this.ivs = imageRequestBuilder.cbm();
        this.irm = imageRequestBuilder.cbn();
    }

    public CacheChoice cbb() {
        return this.ivX;
    }

    public Uri cbc() {
        return this.ivY;
    }

    public int cbd() {
        return this.ivZ;
    }

    @Nullable
    public a cbe() {
        return this.iwa;
    }

    public int getPreferredWidth() {
        if (this.ipG != null) {
            return this.ipG.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.ipG != null) {
            return this.ipG.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cbf() {
        return this.ipG;
    }

    public com.facebook.imagepipeline.common.d cbg() {
        return this.ipH;
    }

    public com.facebook.imagepipeline.common.a cbh() {
        return this.ipI;
    }

    public boolean cbi() {
        return this.irR;
    }

    public boolean cbj() {
        return this.iwc;
    }

    public Priority cat() {
        return this.iwd;
    }

    public RequestLevel car() {
        return this.iub;
    }

    public boolean cbk() {
        return this.iwe;
    }

    public synchronized File cbl() {
        if (this.iwb == null) {
            this.iwb = new File(this.ivY.getPath());
        }
        return this.iwb;
    }

    @Nullable
    public b cbm() {
        return this.ivs;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cbn() {
        return this.irm;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            return f.equal(this.ivY, imageRequest.ivY) && f.equal(this.ivX, imageRequest.ivX) && f.equal(this.iwa, imageRequest.iwa) && f.equal(this.iwb, imageRequest.iwb);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.ivX, this.ivY, this.iwa, this.iwb);
    }

    public String toString() {
        return f.ao(this).n("uri", this.ivY).n("cacheChoice", this.ivX).n("decodeOptions", this.ipI).n("postprocessor", this.ivs).n(LogFactory.PRIORITY_KEY, this.iwd).n("resizeOptions", this.ipG).n("rotationOptions", this.ipH).n("mediaVariations", this.iwa).toString();
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
