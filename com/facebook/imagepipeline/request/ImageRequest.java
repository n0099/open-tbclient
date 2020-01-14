package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.baidu.down.request.db.DownloadDataConstants;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import java.io.File;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes10.dex */
public class ImageRequest {
    @Nullable
    private final com.facebook.imagepipeline.common.d lPR;
    private final e lPS;
    private final com.facebook.imagepipeline.common.b lPT;
    private final boolean lRU;
    @Nullable
    private final com.facebook.imagepipeline.h.c lRl;
    @Nullable
    private final com.facebook.imagepipeline.common.a lTm;
    private final boolean lUW;
    private final RequestLevel lUv;
    @Nullable
    private final b lVO;
    private final boolean lWA;
    private final Priority lWB;
    private final boolean lWC;
    private final Map<String, String> lWD;
    public String lWE;
    private final CacheChoice lWw;
    private final Uri lWx;
    private final int lWy;
    private File lWz;
    public String mTag;

    /* loaded from: classes10.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest V(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.X(uri).dro();
    }

    public static ImageRequest OU(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return V(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.lWw = imageRequestBuilder.drb();
        this.lWx = imageRequestBuilder.drc();
        this.lWy = W(this.lWx);
        this.lRU = imageRequestBuilder.dnU();
        this.lWA = imageRequestBuilder.drm();
        this.lPT = imageRequestBuilder.drg();
        this.lPR = imageRequestBuilder.dre();
        this.lPS = imageRequestBuilder.drf() == null ? e.dnh() : imageRequestBuilder.drf();
        this.lTm = imageRequestBuilder.dpm();
        this.lWB = imageRequestBuilder.drn();
        this.lUv = imageRequestBuilder.dql();
        this.lWC = imageRequestBuilder.dnD();
        this.lUW = imageRequestBuilder.drj();
        this.lVO = imageRequestBuilder.drl();
        this.lRl = imageRequestBuilder.dkp();
        this.lWD = imageRequestBuilder.dqA();
        this.mTag = imageRequestBuilder.getTag();
        this.lWE = imageRequestBuilder.alk();
    }

    public Map<String, String> dqA() {
        return this.lWD;
    }

    public CacheChoice drb() {
        return this.lWw;
    }

    public Uri drc() {
        return this.lWx;
    }

    public int drd() {
        return this.lWy;
    }

    public int getPreferredWidth() {
        if (this.lPR != null) {
            return this.lPR.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.lPR != null) {
            return this.lPR.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dre() {
        return this.lPR;
    }

    public e drf() {
        return this.lPS;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dpm() {
        return this.lTm;
    }

    public com.facebook.imagepipeline.common.b drg() {
        return this.lPT;
    }

    public boolean drh() {
        return this.lRU;
    }

    public boolean dri() {
        return this.lWA;
    }

    public Priority dqn() {
        return this.lWB;
    }

    public RequestLevel dql() {
        return this.lUv;
    }

    public boolean dnD() {
        return this.lWC;
    }

    public boolean drj() {
        return this.lUW;
    }

    public synchronized File drk() {
        if (this.lWz == null) {
            this.lWz = new File(this.lWx.getPath());
        }
        return this.lWz;
    }

    @Nullable
    public b drl() {
        return this.lVO;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dkp() {
        return this.lRl;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.lWx, imageRequest.lWx) && f.equal(this.lWw, imageRequest.lWw) && f.equal(this.lWz, imageRequest.lWz) && f.equal(this.lTm, imageRequest.lTm) && f.equal(this.lPT, imageRequest.lPT) && f.equal(this.lPR, imageRequest.lPR) && f.equal(this.lPS, imageRequest.lPS)) {
                return f.equal(this.lVO != null ? this.lVO.dqi() : null, imageRequest.lVO != null ? imageRequest.lVO.dqi() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.J(this.lWw, this.lWx, this.lWz, this.lTm, this.lPT, this.lPR, this.lPS, this.lVO != null ? this.lVO.dqi() : null);
    }

    public String toString() {
        return f.aQ(this).x(DownloadDataConstants.Columns.COLUMN_URI, this.lWx).x("cacheChoice", this.lWw).x("decodeOptions", this.lPT).x("postprocessor", this.lVO).x("priority", this.lWB).x("resizeOptions", this.lPR).x("rotationOptions", this.lPS).x("bytesRange", this.lTm).toString();
    }

    /* loaded from: classes10.dex */
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
            if (com.facebook.common.d.a.OD(com.facebook.common.d.a.OE(uri.getPath()))) {
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
