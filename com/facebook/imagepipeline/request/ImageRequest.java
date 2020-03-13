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
    private final com.facebook.imagepipeline.common.d lQL;
    private final e lQM;
    private final com.facebook.imagepipeline.common.b lQN;
    private final boolean lSO;
    @Nullable
    private final com.facebook.imagepipeline.h.c lSf;
    @Nullable
    private final com.facebook.imagepipeline.common.a lUg;
    private final boolean lVQ;
    private final RequestLevel lVp;
    @Nullable
    private final b lWI;
    private final CacheChoice lXq;
    private final Uri lXr;
    private final int lXs;
    private File lXt;
    private final boolean lXu;
    private final Priority lXv;
    private final boolean lXw;
    private final Map<String, String> lXx;
    public String lXy;
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
        return ImageRequestBuilder.Y(uri).dsD();
    }

    public static ImageRequest Pi(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return W(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.lXq = imageRequestBuilder.dsq();
        this.lXr = imageRequestBuilder.dsr();
        this.lXs = X(this.lXr);
        this.lSO = imageRequestBuilder.dpj();
        this.lXu = imageRequestBuilder.dsB();
        this.lQN = imageRequestBuilder.dsv();
        this.lQL = imageRequestBuilder.dst();
        this.lQM = imageRequestBuilder.dsu() == null ? e.dox() : imageRequestBuilder.dsu();
        this.lUg = imageRequestBuilder.dqB();
        this.lXv = imageRequestBuilder.dsC();
        this.lVp = imageRequestBuilder.drA();
        this.lXw = imageRequestBuilder.doS();
        this.lVQ = imageRequestBuilder.dsy();
        this.lWI = imageRequestBuilder.dsA();
        this.lSf = imageRequestBuilder.dlF();
        this.lXx = imageRequestBuilder.drP();
        this.mTag = imageRequestBuilder.getTag();
        this.lXy = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> drP() {
        return this.lXx;
    }

    public CacheChoice dsq() {
        return this.lXq;
    }

    public Uri dsr() {
        return this.lXr;
    }

    public int dss() {
        return this.lXs;
    }

    public int getPreferredWidth() {
        if (this.lQL != null) {
            return this.lQL.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.lQL != null) {
            return this.lQL.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dst() {
        return this.lQL;
    }

    public e dsu() {
        return this.lQM;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqB() {
        return this.lUg;
    }

    public com.facebook.imagepipeline.common.b dsv() {
        return this.lQN;
    }

    public boolean dsw() {
        return this.lSO;
    }

    public boolean dsx() {
        return this.lXu;
    }

    public Priority drC() {
        return this.lXv;
    }

    public RequestLevel drA() {
        return this.lVp;
    }

    public boolean doS() {
        return this.lXw;
    }

    public boolean dsy() {
        return this.lVQ;
    }

    public synchronized File dsz() {
        if (this.lXt == null) {
            this.lXt = new File(this.lXr.getPath());
        }
        return this.lXt;
    }

    @Nullable
    public b dsA() {
        return this.lWI;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dlF() {
        return this.lSf;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.lXr, imageRequest.lXr) && f.equal(this.lXq, imageRequest.lXq) && f.equal(this.lXt, imageRequest.lXt) && f.equal(this.lUg, imageRequest.lUg) && f.equal(this.lQN, imageRequest.lQN) && f.equal(this.lQL, imageRequest.lQL) && f.equal(this.lQM, imageRequest.lQM)) {
                return f.equal(this.lWI != null ? this.lWI.drx() : null, imageRequest.lWI != null ? imageRequest.lWI.drx() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.J(this.lXq, this.lXr, this.lXt, this.lUg, this.lQN, this.lQL, this.lQM, this.lWI != null ? this.lWI.drx() : null);
    }

    public String toString() {
        return f.aS(this).x(DownloadDataConstants.Columns.COLUMN_URI, this.lXr).x("cacheChoice", this.lXq).x("decodeOptions", this.lQN).x("postprocessor", this.lWI).x("priority", this.lXv).x("resizeOptions", this.lQL).x("rotationOptions", this.lQM).x("bytesRange", this.lUg).toString();
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
            if (com.facebook.common.d.a.OR(com.facebook.common.d.a.OS(uri.getPath()))) {
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
