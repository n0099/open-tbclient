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
    @Nullable
    private final com.facebook.imagepipeline.common.d lQA;
    private final e lQB;
    private final com.facebook.imagepipeline.common.b lQC;
    @Nullable
    private final com.facebook.imagepipeline.h.c lRU;
    private final boolean lSD;
    @Nullable
    private final com.facebook.imagepipeline.common.a lTV;
    private final boolean lVF;
    private final RequestLevel lVe;
    @Nullable
    private final b lWx;
    private final CacheChoice lXf;
    private final Uri lXg;
    private final int lXh;
    private File lXi;
    private final boolean lXj;
    private final Priority lXk;
    private final boolean lXl;
    private final Map<String, String> lXm;
    public String lXn;
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
        return ImageRequestBuilder.Y(uri).dsC();
    }

    public static ImageRequest Ph(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return W(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.lXf = imageRequestBuilder.dsp();
        this.lXg = imageRequestBuilder.dsq();
        this.lXh = X(this.lXg);
        this.lSD = imageRequestBuilder.dpi();
        this.lXj = imageRequestBuilder.dsA();
        this.lQC = imageRequestBuilder.dsu();
        this.lQA = imageRequestBuilder.dss();
        this.lQB = imageRequestBuilder.dst() == null ? e.dow() : imageRequestBuilder.dst();
        this.lTV = imageRequestBuilder.dqA();
        this.lXk = imageRequestBuilder.dsB();
        this.lVe = imageRequestBuilder.drz();
        this.lXl = imageRequestBuilder.doR();
        this.lVF = imageRequestBuilder.dsx();
        this.lWx = imageRequestBuilder.dsz();
        this.lRU = imageRequestBuilder.dlE();
        this.lXm = imageRequestBuilder.drO();
        this.mTag = imageRequestBuilder.getTag();
        this.lXn = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> drO() {
        return this.lXm;
    }

    public CacheChoice dsp() {
        return this.lXf;
    }

    public Uri dsq() {
        return this.lXg;
    }

    public int dsr() {
        return this.lXh;
    }

    public int getPreferredWidth() {
        if (this.lQA != null) {
            return this.lQA.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.lQA != null) {
            return this.lQA.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dss() {
        return this.lQA;
    }

    public e dst() {
        return this.lQB;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqA() {
        return this.lTV;
    }

    public com.facebook.imagepipeline.common.b dsu() {
        return this.lQC;
    }

    public boolean dsv() {
        return this.lSD;
    }

    public boolean dsw() {
        return this.lXj;
    }

    public Priority drB() {
        return this.lXk;
    }

    public RequestLevel drz() {
        return this.lVe;
    }

    public boolean doR() {
        return this.lXl;
    }

    public boolean dsx() {
        return this.lVF;
    }

    public synchronized File dsy() {
        if (this.lXi == null) {
            this.lXi = new File(this.lXg.getPath());
        }
        return this.lXi;
    }

    @Nullable
    public b dsz() {
        return this.lWx;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dlE() {
        return this.lRU;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.lXg, imageRequest.lXg) && f.equal(this.lXf, imageRequest.lXf) && f.equal(this.lXi, imageRequest.lXi) && f.equal(this.lTV, imageRequest.lTV) && f.equal(this.lQC, imageRequest.lQC) && f.equal(this.lQA, imageRequest.lQA) && f.equal(this.lQB, imageRequest.lQB)) {
                return f.equal(this.lWx != null ? this.lWx.drw() : null, imageRequest.lWx != null ? imageRequest.lWx.drw() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.J(this.lXf, this.lXg, this.lXi, this.lTV, this.lQC, this.lQA, this.lQB, this.lWx != null ? this.lWx.drw() : null);
    }

    public String toString() {
        return f.aS(this).x(DownloadDataConstants.Columns.COLUMN_URI, this.lXg).x("cacheChoice", this.lXf).x("decodeOptions", this.lQC).x("postprocessor", this.lWx).x("priority", this.lXk).x("resizeOptions", this.lQA).x("rotationOptions", this.lQB).x("bytesRange", this.lTV).toString();
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
