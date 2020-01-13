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
    private final com.facebook.imagepipeline.common.d lPM;
    private final e lPN;
    private final com.facebook.imagepipeline.common.b lPO;
    private final boolean lRP;
    @Nullable
    private final com.facebook.imagepipeline.h.c lRg;
    @Nullable
    private final com.facebook.imagepipeline.common.a lTh;
    private final boolean lUR;
    private final RequestLevel lUq;
    @Nullable
    private final b lVJ;
    private final CacheChoice lWr;
    private final Uri lWs;
    private final int lWt;
    private File lWu;
    private final boolean lWv;
    private final Priority lWw;
    private final boolean lWx;
    private final Map<String, String> lWy;
    public String lWz;
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
        return ImageRequestBuilder.X(uri).drm();
    }

    public static ImageRequest OU(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return V(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.lWr = imageRequestBuilder.dqZ();
        this.lWs = imageRequestBuilder.dra();
        this.lWt = W(this.lWs);
        this.lRP = imageRequestBuilder.dnS();
        this.lWv = imageRequestBuilder.drk();
        this.lPO = imageRequestBuilder.dre();
        this.lPM = imageRequestBuilder.drc();
        this.lPN = imageRequestBuilder.drd() == null ? e.dnf() : imageRequestBuilder.drd();
        this.lTh = imageRequestBuilder.dpk();
        this.lWw = imageRequestBuilder.drl();
        this.lUq = imageRequestBuilder.dqj();
        this.lWx = imageRequestBuilder.dnB();
        this.lUR = imageRequestBuilder.drh();
        this.lVJ = imageRequestBuilder.drj();
        this.lRg = imageRequestBuilder.dkn();
        this.lWy = imageRequestBuilder.dqy();
        this.mTag = imageRequestBuilder.getTag();
        this.lWz = imageRequestBuilder.alk();
    }

    public Map<String, String> dqy() {
        return this.lWy;
    }

    public CacheChoice dqZ() {
        return this.lWr;
    }

    public Uri dra() {
        return this.lWs;
    }

    public int drb() {
        return this.lWt;
    }

    public int getPreferredWidth() {
        if (this.lPM != null) {
            return this.lPM.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.lPM != null) {
            return this.lPM.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d drc() {
        return this.lPM;
    }

    public e drd() {
        return this.lPN;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dpk() {
        return this.lTh;
    }

    public com.facebook.imagepipeline.common.b dre() {
        return this.lPO;
    }

    public boolean drf() {
        return this.lRP;
    }

    public boolean drg() {
        return this.lWv;
    }

    public Priority dql() {
        return this.lWw;
    }

    public RequestLevel dqj() {
        return this.lUq;
    }

    public boolean dnB() {
        return this.lWx;
    }

    public boolean drh() {
        return this.lUR;
    }

    public synchronized File dri() {
        if (this.lWu == null) {
            this.lWu = new File(this.lWs.getPath());
        }
        return this.lWu;
    }

    @Nullable
    public b drj() {
        return this.lVJ;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dkn() {
        return this.lRg;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.lWs, imageRequest.lWs) && f.equal(this.lWr, imageRequest.lWr) && f.equal(this.lWu, imageRequest.lWu) && f.equal(this.lTh, imageRequest.lTh) && f.equal(this.lPO, imageRequest.lPO) && f.equal(this.lPM, imageRequest.lPM) && f.equal(this.lPN, imageRequest.lPN)) {
                return f.equal(this.lVJ != null ? this.lVJ.dqg() : null, imageRequest.lVJ != null ? imageRequest.lVJ.dqg() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.J(this.lWr, this.lWs, this.lWu, this.lTh, this.lPO, this.lPM, this.lPN, this.lVJ != null ? this.lVJ.dqg() : null);
    }

    public String toString() {
        return f.aQ(this).x(DownloadDataConstants.Columns.COLUMN_URI, this.lWs).x("cacheChoice", this.lWr).x("decodeOptions", this.lPO).x("postprocessor", this.lVJ).x("priority", this.lWw).x("resizeOptions", this.lPM).x("rotationOptions", this.lPN).x("bytesRange", this.lTh).toString();
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
