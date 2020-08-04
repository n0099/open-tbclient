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
    private final com.facebook.imagepipeline.common.d mZu;
    private final e mZv;
    private final com.facebook.imagepipeline.common.b mZw;
    @Nullable
    private final com.facebook.imagepipeline.h.c naO;
    private final boolean nbx;
    @Nullable
    private final com.facebook.imagepipeline.common.a ncP;
    private final RequestLevel ndY;
    private final boolean neA;
    @Nullable
    private final b nfs;
    private final CacheChoice nga;
    private final Uri ngb;
    private final int ngc;
    private final boolean ngd;
    private final Priority nge;
    private final boolean ngf;
    private final Map<String, String> ngg;
    public String ngh;

    /* loaded from: classes4.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest Z(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ab(uri).dKs();
    }

    public static ImageRequest RG(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return Z(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.nga = imageRequestBuilder.dKg();
        this.ngb = imageRequestBuilder.dKh();
        this.ngc = aa(this.ngb);
        this.nbx = imageRequestBuilder.dHb();
        this.ngd = imageRequestBuilder.dKq();
        this.mZw = imageRequestBuilder.dKl();
        this.mZu = imageRequestBuilder.dKj();
        this.mZv = imageRequestBuilder.dKk() == null ? e.dGq() : imageRequestBuilder.dKk();
        this.ncP = imageRequestBuilder.dIt();
        this.nge = imageRequestBuilder.dKr();
        this.ndY = imageRequestBuilder.dJr();
        this.ngf = imageRequestBuilder.dGK();
        this.neA = imageRequestBuilder.dKo();
        this.nfs = imageRequestBuilder.dKp();
        this.naO = imageRequestBuilder.dDt();
        this.ngg = imageRequestBuilder.dJG();
        this.mTag = imageRequestBuilder.getTag();
        this.ngh = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> dJG() {
        return this.ngg;
    }

    public CacheChoice dKg() {
        return this.nga;
    }

    public Uri dKh() {
        return this.ngb;
    }

    public int dKi() {
        return this.ngc;
    }

    public int getPreferredWidth() {
        if (this.mZu != null) {
            return this.mZu.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.mZu != null) {
            return this.mZu.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dKj() {
        return this.mZu;
    }

    public e dKk() {
        return this.mZv;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dIt() {
        return this.ncP;
    }

    public com.facebook.imagepipeline.common.b dKl() {
        return this.mZw;
    }

    public boolean dKm() {
        return this.nbx;
    }

    public boolean dKn() {
        return this.ngd;
    }

    public Priority dJt() {
        return this.nge;
    }

    public RequestLevel dJr() {
        return this.ndY;
    }

    public boolean dGK() {
        return this.ngf;
    }

    public boolean dKo() {
        return this.neA;
    }

    public synchronized File byz() {
        if (this.fDc == null) {
            this.fDc = new File(this.ngb.getPath());
        }
        return this.fDc;
    }

    @Nullable
    public b dKp() {
        return this.nfs;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dDt() {
        return this.naO;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.ngb, imageRequest.ngb) && f.equal(this.nga, imageRequest.nga) && f.equal(this.fDc, imageRequest.fDc) && f.equal(this.ncP, imageRequest.ncP) && f.equal(this.mZw, imageRequest.mZw) && f.equal(this.mZu, imageRequest.mZu) && f.equal(this.mZv, imageRequest.mZv)) {
                return f.equal(this.nfs != null ? this.nfs.dJo() : null, imageRequest.nfs != null ? imageRequest.nfs.dJo() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.N(this.nga, this.ngb, this.fDc, this.ncP, this.mZw, this.mZu, this.mZv, this.nfs != null ? this.nfs.dJo() : null);
    }

    public String toString() {
        return f.aO(this).F(DownloadDataConstants.Columns.COLUMN_URI, this.ngb).F("cacheChoice", this.nga).F("decodeOptions", this.mZw).F("postprocessor", this.nfs).F("priority", this.nge).F("resizeOptions", this.mZu).F("rotationOptions", this.mZv).F("bytesRange", this.ncP).toString();
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
