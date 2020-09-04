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
    private File fOx;
    public String mTag;
    private final CacheChoice nAh;
    private final Uri nAi;
    private final int nAj;
    private final boolean nAk;
    private final Priority nAl;
    private final boolean nAm;
    private final Map<String, String> nAn;
    public String nAo;
    @Nullable
    private final com.facebook.imagepipeline.common.d ntB;
    private final e ntC;
    private final com.facebook.imagepipeline.common.b ntD;
    @Nullable
    private final com.facebook.imagepipeline.h.c nuW;
    private final boolean nvF;
    @Nullable
    private final com.facebook.imagepipeline.common.a nwX;
    private final boolean nyH;
    private final RequestLevel nyg;
    @Nullable
    private final b nzz;

    /* loaded from: classes8.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest Z(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ab(uri).dWA();
    }

    public static ImageRequest UK(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return Z(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.nAh = imageRequestBuilder.dWo();
        this.nAi = imageRequestBuilder.dWp();
        this.nAj = aa(this.nAi);
        this.nvF = imageRequestBuilder.dTj();
        this.nAk = imageRequestBuilder.dWy();
        this.ntD = imageRequestBuilder.dWt();
        this.ntB = imageRequestBuilder.dWr();
        this.ntC = imageRequestBuilder.dWs() == null ? e.dSy() : imageRequestBuilder.dWs();
        this.nwX = imageRequestBuilder.dUB();
        this.nAl = imageRequestBuilder.dWz();
        this.nyg = imageRequestBuilder.dVz();
        this.nAm = imageRequestBuilder.dSS();
        this.nyH = imageRequestBuilder.dWw();
        this.nzz = imageRequestBuilder.dWx();
        this.nuW = imageRequestBuilder.dPC();
        this.nAn = imageRequestBuilder.dVO();
        this.mTag = imageRequestBuilder.getTag();
        this.nAo = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> dVO() {
        return this.nAn;
    }

    public CacheChoice dWo() {
        return this.nAh;
    }

    public Uri dWp() {
        return this.nAi;
    }

    public int dWq() {
        return this.nAj;
    }

    public int getPreferredWidth() {
        if (this.ntB != null) {
            return this.ntB.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.ntB != null) {
            return this.ntB.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dWr() {
        return this.ntB;
    }

    public e dWs() {
        return this.ntC;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dUB() {
        return this.nwX;
    }

    public com.facebook.imagepipeline.common.b dWt() {
        return this.ntD;
    }

    public boolean dWu() {
        return this.nvF;
    }

    public boolean dWv() {
        return this.nAk;
    }

    public Priority dVB() {
        return this.nAl;
    }

    public RequestLevel dVz() {
        return this.nyg;
    }

    public boolean dSS() {
        return this.nAm;
    }

    public boolean dWw() {
        return this.nyH;
    }

    public synchronized File bHC() {
        if (this.fOx == null) {
            this.fOx = new File(this.nAi.getPath());
        }
        return this.fOx;
    }

    @Nullable
    public b dWx() {
        return this.nzz;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dPC() {
        return this.nuW;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.nAi, imageRequest.nAi) && f.equal(this.nAh, imageRequest.nAh) && f.equal(this.fOx, imageRequest.fOx) && f.equal(this.nwX, imageRequest.nwX) && f.equal(this.ntD, imageRequest.ntD) && f.equal(this.ntB, imageRequest.ntB) && f.equal(this.ntC, imageRequest.ntC)) {
                return f.equal(this.nzz != null ? this.nzz.dVw() : null, imageRequest.nzz != null ? imageRequest.nzz.dVw() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.M(this.nAh, this.nAi, this.fOx, this.nwX, this.ntD, this.ntB, this.ntC, this.nzz != null ? this.nzz.dVw() : null);
    }

    public String toString() {
        return f.aQ(this).E(DownloadDataConstants.Columns.COLUMN_URI, this.nAi).E("cacheChoice", this.nAh).E("decodeOptions", this.ntD).E("postprocessor", this.nzz).E("priority", this.nAl).E("resizeOptions", this.ntB).E("rotationOptions", this.ntC).E("bytesRange", this.nwX).toString();
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
