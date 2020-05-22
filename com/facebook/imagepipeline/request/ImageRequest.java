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
    private File fmw;
    private final CacheChoice mAC;
    private final Uri mAD;
    private final int mAE;
    private final boolean mAF;
    private final Priority mAG;
    private final boolean mAH;
    private final Map<String, String> mAI;
    public String mAJ;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d mtZ;
    private final e mua;
    private final com.facebook.imagepipeline.common.b mub;
    @Nullable
    private final com.facebook.imagepipeline.h.c mvt;
    private final boolean mwc;
    @Nullable
    private final com.facebook.imagepipeline.common.a mxs;
    private final RequestLevel myB;
    @Nullable
    private final b mzU;
    private final boolean mzc;

    /* loaded from: classes12.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest Z(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ab(uri).dCl();
    }

    public static ImageRequest Qh(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return Z(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.mAC = imageRequestBuilder.dBZ();
        this.mAD = imageRequestBuilder.dCa();
        this.mAE = aa(this.mAD);
        this.mwc = imageRequestBuilder.dyU();
        this.mAF = imageRequestBuilder.dCj();
        this.mub = imageRequestBuilder.dCe();
        this.mtZ = imageRequestBuilder.dCc();
        this.mua = imageRequestBuilder.dCd() == null ? e.dyj() : imageRequestBuilder.dCd();
        this.mxs = imageRequestBuilder.dAm();
        this.mAG = imageRequestBuilder.dCk();
        this.myB = imageRequestBuilder.dBk();
        this.mAH = imageRequestBuilder.dyD();
        this.mzc = imageRequestBuilder.dCh();
        this.mzU = imageRequestBuilder.dCi();
        this.mvt = imageRequestBuilder.dvl();
        this.mAI = imageRequestBuilder.dBz();
        this.mTag = imageRequestBuilder.getTag();
        this.mAJ = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> dBz() {
        return this.mAI;
    }

    public CacheChoice dBZ() {
        return this.mAC;
    }

    public Uri dCa() {
        return this.mAD;
    }

    public int dCb() {
        return this.mAE;
    }

    public int getPreferredWidth() {
        if (this.mtZ != null) {
            return this.mtZ.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.mtZ != null) {
            return this.mtZ.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dCc() {
        return this.mtZ;
    }

    public e dCd() {
        return this.mua;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dAm() {
        return this.mxs;
    }

    public com.facebook.imagepipeline.common.b dCe() {
        return this.mub;
    }

    public boolean dCf() {
        return this.mwc;
    }

    public boolean dCg() {
        return this.mAF;
    }

    public Priority dBm() {
        return this.mAG;
    }

    public RequestLevel dBk() {
        return this.myB;
    }

    public boolean dyD() {
        return this.mAH;
    }

    public boolean dCh() {
        return this.mzc;
    }

    public synchronized File bss() {
        if (this.fmw == null) {
            this.fmw = new File(this.mAD.getPath());
        }
        return this.fmw;
    }

    @Nullable
    public b dCi() {
        return this.mzU;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dvl() {
        return this.mvt;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.mAD, imageRequest.mAD) && f.equal(this.mAC, imageRequest.mAC) && f.equal(this.fmw, imageRequest.fmw) && f.equal(this.mxs, imageRequest.mxs) && f.equal(this.mub, imageRequest.mub) && f.equal(this.mtZ, imageRequest.mtZ) && f.equal(this.mua, imageRequest.mua)) {
                return f.equal(this.mzU != null ? this.mzU.dBh() : null, imageRequest.mzU != null ? imageRequest.mzU.dBh() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.N(this.mAC, this.mAD, this.fmw, this.mxs, this.mub, this.mtZ, this.mua, this.mzU != null ? this.mzU.dBh() : null);
    }

    public String toString() {
        return f.aN(this).F(DownloadDataConstants.Columns.COLUMN_URI, this.mAD).F("cacheChoice", this.mAC).F("decodeOptions", this.mub).F("postprocessor", this.mzU).F("priority", this.mAG).F("resizeOptions", this.mtZ).F("rotationOptions", this.mua).F("bytesRange", this.mxs).toString();
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

    private static int aa(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.I(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.isLocalFileUri(uri)) {
            if (com.facebook.common.d.a.PP(com.facebook.common.d.a.PQ(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.isLocalContentUri(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.L(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.M(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.O(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.N(uri) ? 8 : -1;
        }
    }
}
