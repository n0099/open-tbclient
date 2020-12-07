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
/* loaded from: classes15.dex */
public class ImageRequest {
    private File gCh;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d pjW;
    private final e pjX;
    private final com.facebook.imagepipeline.common.b pjY;
    private final boolean plY;
    @Nullable
    private final com.facebook.imagepipeline.g.c plp;
    @Nullable
    private final com.facebook.imagepipeline.common.a pno;
    private final RequestLevel poA;
    @Nullable
    private final b ppV;
    private final boolean ppb;
    private final CacheChoice pqD;
    private final Uri pqE;
    private final int pqF;
    private final boolean pqG;
    private final Priority pqH;
    private final boolean pqI;
    private final Map<String, String> pqJ;
    public String pqK;

    /* loaded from: classes15.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ad(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.af(uri).exw();
    }

    public static ImageRequest Zv(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ad(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.pqD = imageRequestBuilder.exk();
        this.pqE = imageRequestBuilder.exl();
        this.pqF = ae(this.pqE);
        this.plY = imageRequestBuilder.euk();
        this.pqG = imageRequestBuilder.exu();
        this.pjY = imageRequestBuilder.exp();
        this.pjW = imageRequestBuilder.exn();
        this.pjX = imageRequestBuilder.exo() == null ? e.etA() : imageRequestBuilder.exo();
        this.pno = imageRequestBuilder.evC();
        this.pqH = imageRequestBuilder.exv();
        this.poA = imageRequestBuilder.ewx();
        this.pqI = imageRequestBuilder.etT();
        this.ppb = imageRequestBuilder.exs();
        this.ppV = imageRequestBuilder.ext();
        this.plp = imageRequestBuilder.eqL();
        this.pqJ = imageRequestBuilder.exj();
        this.mTag = imageRequestBuilder.getTag();
        this.pqK = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> exj() {
        return this.pqJ;
    }

    public CacheChoice exk() {
        return this.pqD;
    }

    public Uri exl() {
        return this.pqE;
    }

    public int exm() {
        return this.pqF;
    }

    public int getPreferredWidth() {
        if (this.pjW != null) {
            return this.pjW.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.pjW != null) {
            return this.pjW.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d exn() {
        return this.pjW;
    }

    public e exo() {
        return this.pjX;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a evC() {
        return this.pno;
    }

    public com.facebook.imagepipeline.common.b exp() {
        return this.pjY;
    }

    public boolean exq() {
        return this.plY;
    }

    public boolean exr() {
        return this.pqG;
    }

    public Priority ewz() {
        return this.pqH;
    }

    public RequestLevel ewx() {
        return this.poA;
    }

    public boolean etT() {
        return this.pqI;
    }

    public boolean exs() {
        return this.ppb;
    }

    public synchronized File acr() {
        if (this.gCh == null) {
            this.gCh = new File(this.pqE.getPath());
        }
        return this.gCh;
    }

    @Nullable
    public b ext() {
        return this.ppV;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c eqL() {
        return this.plp;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.pqE, imageRequest.pqE) && f.equal(this.pqD, imageRequest.pqD) && f.equal(this.gCh, imageRequest.gCh) && f.equal(this.pno, imageRequest.pno) && f.equal(this.pjY, imageRequest.pjY) && f.equal(this.pjW, imageRequest.pjW) && f.equal(this.pjX, imageRequest.pjX)) {
                return f.equal(this.ppV != null ? this.ppV.ewu() : null, imageRequest.ppV != null ? imageRequest.ppV.ewu() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.M(this.pqD, this.pqE, this.gCh, this.pno, this.pjY, this.pjW, this.pjX, this.ppV != null ? this.ppV.ewu() : null);
    }

    public String toString() {
        return f.ba(this).E(DownloadDataConstants.Columns.COLUMN_URI, this.pqE).E("cacheChoice", this.pqD).E("decodeOptions", this.pjY).E("postprocessor", this.ppV).E("priority", this.pqH).E("resizeOptions", this.pjW).E("rotationOptions", this.pjX).E("bytesRange", this.pno).toString();
    }

    /* loaded from: classes15.dex */
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

    private static int ae(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.M(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.isLocalFileUri(uri)) {
            if (com.facebook.common.d.a.Zf(com.facebook.common.d.a.Zg(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.isLocalContentUri(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.P(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.Q(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.S(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.R(uri) ? 8 : -1;
        }
    }
}
