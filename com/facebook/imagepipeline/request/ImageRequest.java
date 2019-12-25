package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.baidu.down.request.db.DownloadDataConstants;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.common.e;
import java.io.File;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes9.dex */
public class ImageRequest {
    @Nullable
    private final d lMb;
    private final e lMc;
    private final com.facebook.imagepipeline.common.b lMd;
    @Nullable
    private final com.facebook.imagepipeline.h.c lNu;
    private final boolean lOd;
    @Nullable
    private final com.facebook.imagepipeline.common.a lPv;
    private final RequestLevel lQC;
    @Nullable
    private final a lRV;
    private final boolean lRd;
    private final CacheChoice lSC;
    private final Uri lSD;
    private final int lSE;
    private File lSF;
    private final boolean lSG;
    private final Priority lSH;
    private final boolean lSI;
    private final Map<String, String> lSJ;
    public String lSK;
    public String mTag;

    /* loaded from: classes9.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest V(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.X(uri).dpZ();
    }

    public static ImageRequest OJ(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return V(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.lSC = imageRequestBuilder.dpM();
        this.lSD = imageRequestBuilder.dpN();
        this.lSE = W(this.lSD);
        this.lOd = imageRequestBuilder.dmL();
        this.lSG = imageRequestBuilder.dpX();
        this.lMd = imageRequestBuilder.dpR();
        this.lMb = imageRequestBuilder.dpP();
        this.lMc = imageRequestBuilder.dpQ() == null ? e.dma() : imageRequestBuilder.dpQ();
        this.lPv = imageRequestBuilder.doe();
        this.lSH = imageRequestBuilder.dpY();
        this.lQC = imageRequestBuilder.doZ();
        this.lSI = imageRequestBuilder.dmu();
        this.lRd = imageRequestBuilder.dpU();
        this.lRV = imageRequestBuilder.dpW();
        this.lNu = imageRequestBuilder.djm();
        this.lSJ = imageRequestBuilder.dpo();
        this.mTag = imageRequestBuilder.getTag();
        this.lSK = imageRequestBuilder.akR();
    }

    public Map<String, String> dpo() {
        return this.lSJ;
    }

    public CacheChoice dpM() {
        return this.lSC;
    }

    public Uri dpN() {
        return this.lSD;
    }

    public int dpO() {
        return this.lSE;
    }

    public int getPreferredWidth() {
        if (this.lMb != null) {
            return this.lMb.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.lMb != null) {
            return this.lMb.height;
        }
        return 2048;
    }

    @Nullable
    public d dpP() {
        return this.lMb;
    }

    public e dpQ() {
        return this.lMc;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a doe() {
        return this.lPv;
    }

    public com.facebook.imagepipeline.common.b dpR() {
        return this.lMd;
    }

    public boolean dpS() {
        return this.lOd;
    }

    public boolean dpT() {
        return this.lSG;
    }

    public Priority dpb() {
        return this.lSH;
    }

    public RequestLevel doZ() {
        return this.lQC;
    }

    public boolean dmu() {
        return this.lSI;
    }

    public boolean dpU() {
        return this.lRd;
    }

    public synchronized File dpV() {
        if (this.lSF == null) {
            this.lSF = new File(this.lSD.getPath());
        }
        return this.lSF;
    }

    @Nullable
    public a dpW() {
        return this.lRV;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c djm() {
        return this.lNu;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.lSD, imageRequest.lSD) && f.equal(this.lSC, imageRequest.lSC) && f.equal(this.lSF, imageRequest.lSF) && f.equal(this.lPv, imageRequest.lPv) && f.equal(this.lMd, imageRequest.lMd) && f.equal(this.lMb, imageRequest.lMb) && f.equal(this.lMc, imageRequest.lMc)) {
                return f.equal(this.lRV != null ? this.lRV.dqa() : null, imageRequest.lRV != null ? imageRequest.lRV.dqa() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.J(this.lSC, this.lSD, this.lSF, this.lPv, this.lMd, this.lMb, this.lMc, this.lRV != null ? this.lRV.dqa() : null);
    }

    public String toString() {
        return f.aQ(this).x(DownloadDataConstants.Columns.COLUMN_URI, this.lSD).x("cacheChoice", this.lSC).x("decodeOptions", this.lMd).x("postprocessor", this.lRV).x("priority", this.lSH).x("resizeOptions", this.lMb).x("rotationOptions", this.lMc).x("bytesRange", this.lPv).toString();
    }

    /* loaded from: classes9.dex */
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

    private static int W(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.B(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.isLocalFileUri(uri)) {
            if (com.facebook.common.d.a.Ot(com.facebook.common.d.a.Ou(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.isLocalContentUri(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.E(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.F(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.H(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.G(uri) ? 8 : -1;
        }
    }
}
