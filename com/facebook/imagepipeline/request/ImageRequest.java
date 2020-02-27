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
/* loaded from: classes12.dex */
public class ImageRequest {
    private final com.facebook.imagepipeline.common.b lQA;
    @Nullable
    private final com.facebook.imagepipeline.common.d lQy;
    private final e lQz;
    @Nullable
    private final com.facebook.imagepipeline.h.c lRS;
    private final boolean lSB;
    @Nullable
    private final com.facebook.imagepipeline.common.a lTT;
    private final boolean lVD;
    private final RequestLevel lVc;
    @Nullable
    private final b lWv;
    private final CacheChoice lXd;
    private final Uri lXe;
    private final int lXf;
    private File lXg;
    private final boolean lXh;
    private final Priority lXi;
    private final boolean lXj;
    private final Map<String, String> lXk;
    public String lXl;
    public String mTag;

    /* loaded from: classes12.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest W(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.Y(uri).dsA();
    }

    public static ImageRequest Ph(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return W(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.lXd = imageRequestBuilder.dsn();
        this.lXe = imageRequestBuilder.dso();
        this.lXf = X(this.lXe);
        this.lSB = imageRequestBuilder.dpg();
        this.lXh = imageRequestBuilder.dsy();
        this.lQA = imageRequestBuilder.dss();
        this.lQy = imageRequestBuilder.dsq();
        this.lQz = imageRequestBuilder.dsr() == null ? e.dou() : imageRequestBuilder.dsr();
        this.lTT = imageRequestBuilder.dqy();
        this.lXi = imageRequestBuilder.dsz();
        this.lVc = imageRequestBuilder.drx();
        this.lXj = imageRequestBuilder.doP();
        this.lVD = imageRequestBuilder.dsv();
        this.lWv = imageRequestBuilder.dsx();
        this.lRS = imageRequestBuilder.dlC();
        this.lXk = imageRequestBuilder.drM();
        this.mTag = imageRequestBuilder.getTag();
        this.lXl = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> drM() {
        return this.lXk;
    }

    public CacheChoice dsn() {
        return this.lXd;
    }

    public Uri dso() {
        return this.lXe;
    }

    public int dsp() {
        return this.lXf;
    }

    public int getPreferredWidth() {
        if (this.lQy != null) {
            return this.lQy.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.lQy != null) {
            return this.lQy.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dsq() {
        return this.lQy;
    }

    public e dsr() {
        return this.lQz;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqy() {
        return this.lTT;
    }

    public com.facebook.imagepipeline.common.b dss() {
        return this.lQA;
    }

    public boolean dst() {
        return this.lSB;
    }

    public boolean dsu() {
        return this.lXh;
    }

    public Priority drz() {
        return this.lXi;
    }

    public RequestLevel drx() {
        return this.lVc;
    }

    public boolean doP() {
        return this.lXj;
    }

    public boolean dsv() {
        return this.lVD;
    }

    public synchronized File dsw() {
        if (this.lXg == null) {
            this.lXg = new File(this.lXe.getPath());
        }
        return this.lXg;
    }

    @Nullable
    public b dsx() {
        return this.lWv;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dlC() {
        return this.lRS;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.lXe, imageRequest.lXe) && f.equal(this.lXd, imageRequest.lXd) && f.equal(this.lXg, imageRequest.lXg) && f.equal(this.lTT, imageRequest.lTT) && f.equal(this.lQA, imageRequest.lQA) && f.equal(this.lQy, imageRequest.lQy) && f.equal(this.lQz, imageRequest.lQz)) {
                return f.equal(this.lWv != null ? this.lWv.dru() : null, imageRequest.lWv != null ? imageRequest.lWv.dru() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.J(this.lXd, this.lXe, this.lXg, this.lTT, this.lQA, this.lQy, this.lQz, this.lWv != null ? this.lWv.dru() : null);
    }

    public String toString() {
        return f.aS(this).x(DownloadDataConstants.Columns.COLUMN_URI, this.lXe).x("cacheChoice", this.lXd).x("decodeOptions", this.lQA).x("postprocessor", this.lWv).x("priority", this.lXi).x("resizeOptions", this.lQy).x("rotationOptions", this.lQz).x("bytesRange", this.lTT).toString();
    }

    /* loaded from: classes12.dex */
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

    private static int X(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.C(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.isLocalFileUri(uri)) {
            if (com.facebook.common.d.a.OQ(com.facebook.common.d.a.OR(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.isLocalContentUri(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.F(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.G(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.I(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.H(uri) ? 8 : -1;
        }
    }
}
