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
    private File gCj;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d pjY;
    private final e pjZ;
    private final com.facebook.imagepipeline.common.b pka;
    @Nullable
    private final com.facebook.imagepipeline.g.c plr;
    private final boolean pma;
    @Nullable
    private final com.facebook.imagepipeline.common.a pnq;
    private final RequestLevel poC;
    @Nullable
    private final b ppX;
    private final boolean ppd;
    private final CacheChoice pqF;
    private final Uri pqG;
    private final int pqH;
    private final boolean pqI;
    private final Priority pqJ;
    private final boolean pqK;
    private final Map<String, String> pqL;
    public String pqM;

    /* loaded from: classes15.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ad(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.af(uri).exx();
    }

    public static ImageRequest Zv(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ad(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.pqF = imageRequestBuilder.exl();
        this.pqG = imageRequestBuilder.exm();
        this.pqH = ae(this.pqG);
        this.pma = imageRequestBuilder.eul();
        this.pqI = imageRequestBuilder.exv();
        this.pka = imageRequestBuilder.exq();
        this.pjY = imageRequestBuilder.exo();
        this.pjZ = imageRequestBuilder.exp() == null ? e.etB() : imageRequestBuilder.exp();
        this.pnq = imageRequestBuilder.evD();
        this.pqJ = imageRequestBuilder.exw();
        this.poC = imageRequestBuilder.ewy();
        this.pqK = imageRequestBuilder.etU();
        this.ppd = imageRequestBuilder.ext();
        this.ppX = imageRequestBuilder.exu();
        this.plr = imageRequestBuilder.eqM();
        this.pqL = imageRequestBuilder.exk();
        this.mTag = imageRequestBuilder.getTag();
        this.pqM = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> exk() {
        return this.pqL;
    }

    public CacheChoice exl() {
        return this.pqF;
    }

    public Uri exm() {
        return this.pqG;
    }

    public int exn() {
        return this.pqH;
    }

    public int getPreferredWidth() {
        if (this.pjY != null) {
            return this.pjY.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.pjY != null) {
            return this.pjY.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d exo() {
        return this.pjY;
    }

    public e exp() {
        return this.pjZ;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a evD() {
        return this.pnq;
    }

    public com.facebook.imagepipeline.common.b exq() {
        return this.pka;
    }

    public boolean exr() {
        return this.pma;
    }

    public boolean exs() {
        return this.pqI;
    }

    public Priority ewA() {
        return this.pqJ;
    }

    public RequestLevel ewy() {
        return this.poC;
    }

    public boolean etU() {
        return this.pqK;
    }

    public boolean ext() {
        return this.ppd;
    }

    public synchronized File acr() {
        if (this.gCj == null) {
            this.gCj = new File(this.pqG.getPath());
        }
        return this.gCj;
    }

    @Nullable
    public b exu() {
        return this.ppX;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c eqM() {
        return this.plr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.pqG, imageRequest.pqG) && f.equal(this.pqF, imageRequest.pqF) && f.equal(this.gCj, imageRequest.gCj) && f.equal(this.pnq, imageRequest.pnq) && f.equal(this.pka, imageRequest.pka) && f.equal(this.pjY, imageRequest.pjY) && f.equal(this.pjZ, imageRequest.pjZ)) {
                return f.equal(this.ppX != null ? this.ppX.ewv() : null, imageRequest.ppX != null ? imageRequest.ppX.ewv() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.M(this.pqF, this.pqG, this.gCj, this.pnq, this.pka, this.pjY, this.pjZ, this.ppX != null ? this.ppX.ewv() : null);
    }

    public String toString() {
        return f.ba(this).E(DownloadDataConstants.Columns.COLUMN_URI, this.pqG).E("cacheChoice", this.pqF).E("decodeOptions", this.pka).E("postprocessor", this.ppX).E("priority", this.pqJ).E("resizeOptions", this.pjY).E("rotationOptions", this.pjZ).E("bytesRange", this.pnq).toString();
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
