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
/* loaded from: classes4.dex */
public class ImageRequest {
    private File fDc;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d mZs;
    private final e mZt;
    private final com.facebook.imagepipeline.common.b mZu;
    @Nullable
    private final com.facebook.imagepipeline.h.c naM;
    private final boolean nbv;
    @Nullable
    private final com.facebook.imagepipeline.common.a ncN;
    private final RequestLevel ndW;
    private final boolean ney;
    private final CacheChoice nfY;
    private final Uri nfZ;
    @Nullable
    private final b nfq;
    private final int nga;
    private final boolean ngb;
    private final Priority ngc;
    private final boolean ngd;
    private final Map<String, String> nge;
    public String ngf;

    /* loaded from: classes4.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest Z(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ab(uri).dKr();
    }

    public static ImageRequest RG(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return Z(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.nfY = imageRequestBuilder.dKf();
        this.nfZ = imageRequestBuilder.dKg();
        this.nga = aa(this.nfZ);
        this.nbv = imageRequestBuilder.dHa();
        this.ngb = imageRequestBuilder.dKp();
        this.mZu = imageRequestBuilder.dKk();
        this.mZs = imageRequestBuilder.dKi();
        this.mZt = imageRequestBuilder.dKj() == null ? e.dGp() : imageRequestBuilder.dKj();
        this.ncN = imageRequestBuilder.dIs();
        this.ngc = imageRequestBuilder.dKq();
        this.ndW = imageRequestBuilder.dJq();
        this.ngd = imageRequestBuilder.dGJ();
        this.ney = imageRequestBuilder.dKn();
        this.nfq = imageRequestBuilder.dKo();
        this.naM = imageRequestBuilder.dDs();
        this.nge = imageRequestBuilder.dJF();
        this.mTag = imageRequestBuilder.getTag();
        this.ngf = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> dJF() {
        return this.nge;
    }

    public CacheChoice dKf() {
        return this.nfY;
    }

    public Uri dKg() {
        return this.nfZ;
    }

    public int dKh() {
        return this.nga;
    }

    public int getPreferredWidth() {
        if (this.mZs != null) {
            return this.mZs.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.mZs != null) {
            return this.mZs.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dKi() {
        return this.mZs;
    }

    public e dKj() {
        return this.mZt;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dIs() {
        return this.ncN;
    }

    public com.facebook.imagepipeline.common.b dKk() {
        return this.mZu;
    }

    public boolean dKl() {
        return this.nbv;
    }

    public boolean dKm() {
        return this.ngb;
    }

    public Priority dJs() {
        return this.ngc;
    }

    public RequestLevel dJq() {
        return this.ndW;
    }

    public boolean dGJ() {
        return this.ngd;
    }

    public boolean dKn() {
        return this.ney;
    }

    public synchronized File byz() {
        if (this.fDc == null) {
            this.fDc = new File(this.nfZ.getPath());
        }
        return this.fDc;
    }

    @Nullable
    public b dKo() {
        return this.nfq;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dDs() {
        return this.naM;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.nfZ, imageRequest.nfZ) && f.equal(this.nfY, imageRequest.nfY) && f.equal(this.fDc, imageRequest.fDc) && f.equal(this.ncN, imageRequest.ncN) && f.equal(this.mZu, imageRequest.mZu) && f.equal(this.mZs, imageRequest.mZs) && f.equal(this.mZt, imageRequest.mZt)) {
                return f.equal(this.nfq != null ? this.nfq.dJn() : null, imageRequest.nfq != null ? imageRequest.nfq.dJn() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.N(this.nfY, this.nfZ, this.fDc, this.ncN, this.mZu, this.mZs, this.mZt, this.nfq != null ? this.nfq.dJn() : null);
    }

    public String toString() {
        return f.aO(this).F(DownloadDataConstants.Columns.COLUMN_URI, this.nfZ).F("cacheChoice", this.nfY).F("decodeOptions", this.mZu).F("postprocessor", this.nfq).F("priority", this.ngc).F("resizeOptions", this.mZs).F("rotationOptions", this.mZt).F("bytesRange", this.ncN).toString();
    }

    /* loaded from: classes4.dex */
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
            if (com.facebook.common.d.a.Ro(com.facebook.common.d.a.Rp(uri.getPath()))) {
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
