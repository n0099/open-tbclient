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
/* loaded from: classes8.dex */
public class ImageRequest {
    private File fOt;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d ntj;
    private final e ntk;
    private final com.facebook.imagepipeline.common.b ntl;
    @Nullable
    private final com.facebook.imagepipeline.h.c nuE;
    private final boolean nvn;
    @Nullable
    private final com.facebook.imagepipeline.common.a nwF;
    private final RequestLevel nxO;
    private final boolean nyp;
    private final CacheChoice nzP;
    private final Uri nzQ;
    private final int nzR;
    private final boolean nzS;
    private final Priority nzT;
    private final boolean nzU;
    private final Map<String, String> nzV;
    public String nzW;
    @Nullable
    private final b nzh;

    /* loaded from: classes8.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest Z(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ab(uri).dWr();
    }

    public static ImageRequest UK(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return Z(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.nzP = imageRequestBuilder.dWf();
        this.nzQ = imageRequestBuilder.dWg();
        this.nzR = aa(this.nzQ);
        this.nvn = imageRequestBuilder.dTa();
        this.nzS = imageRequestBuilder.dWp();
        this.ntl = imageRequestBuilder.dWk();
        this.ntj = imageRequestBuilder.dWi();
        this.ntk = imageRequestBuilder.dWj() == null ? e.dSp() : imageRequestBuilder.dWj();
        this.nwF = imageRequestBuilder.dUs();
        this.nzT = imageRequestBuilder.dWq();
        this.nxO = imageRequestBuilder.dVq();
        this.nzU = imageRequestBuilder.dSJ();
        this.nyp = imageRequestBuilder.dWn();
        this.nzh = imageRequestBuilder.dWo();
        this.nuE = imageRequestBuilder.dPt();
        this.nzV = imageRequestBuilder.dVF();
        this.mTag = imageRequestBuilder.getTag();
        this.nzW = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> dVF() {
        return this.nzV;
    }

    public CacheChoice dWf() {
        return this.nzP;
    }

    public Uri dWg() {
        return this.nzQ;
    }

    public int dWh() {
        return this.nzR;
    }

    public int getPreferredWidth() {
        if (this.ntj != null) {
            return this.ntj.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.ntj != null) {
            return this.ntj.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dWi() {
        return this.ntj;
    }

    public e dWj() {
        return this.ntk;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dUs() {
        return this.nwF;
    }

    public com.facebook.imagepipeline.common.b dWk() {
        return this.ntl;
    }

    public boolean dWl() {
        return this.nvn;
    }

    public boolean dWm() {
        return this.nzS;
    }

    public Priority dVs() {
        return this.nzT;
    }

    public RequestLevel dVq() {
        return this.nxO;
    }

    public boolean dSJ() {
        return this.nzU;
    }

    public boolean dWn() {
        return this.nyp;
    }

    public synchronized File bHB() {
        if (this.fOt == null) {
            this.fOt = new File(this.nzQ.getPath());
        }
        return this.fOt;
    }

    @Nullable
    public b dWo() {
        return this.nzh;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dPt() {
        return this.nuE;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.nzQ, imageRequest.nzQ) && f.equal(this.nzP, imageRequest.nzP) && f.equal(this.fOt, imageRequest.fOt) && f.equal(this.nwF, imageRequest.nwF) && f.equal(this.ntl, imageRequest.ntl) && f.equal(this.ntj, imageRequest.ntj) && f.equal(this.ntk, imageRequest.ntk)) {
                return f.equal(this.nzh != null ? this.nzh.dVn() : null, imageRequest.nzh != null ? imageRequest.nzh.dVn() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.M(this.nzP, this.nzQ, this.fOt, this.nwF, this.ntl, this.ntj, this.ntk, this.nzh != null ? this.nzh.dVn() : null);
    }

    public String toString() {
        return f.aQ(this).E(DownloadDataConstants.Columns.COLUMN_URI, this.nzQ).E("cacheChoice", this.nzP).E("decodeOptions", this.ntl).E("postprocessor", this.nzh).E("priority", this.nzT).E("resizeOptions", this.ntj).E("rotationOptions", this.ntk).E("bytesRange", this.nwF).toString();
    }

    /* loaded from: classes8.dex */
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
            if (com.facebook.common.d.a.Us(com.facebook.common.d.a.Ut(uri.getPath()))) {
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
