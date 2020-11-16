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
    private File gty;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d oVg;
    private final e oVh;
    private final com.facebook.imagepipeline.common.b oVi;
    @Nullable
    private final com.facebook.imagepipeline.h.c oWA;
    private final boolean oXj;
    @Nullable
    private final com.facebook.imagepipeline.common.a oYz;
    private final RequestLevel oZI;
    private final boolean pak;
    private final CacheChoice pbL;
    private final Uri pbM;
    private final int pbN;
    private final boolean pbO;
    private final Priority pbP;
    private final boolean pbQ;
    private final Map<String, String> pbR;
    public String pbS;
    @Nullable
    private final b pbd;

    /* loaded from: classes15.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ac(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ae(uri).erW();
    }

    public static ImageRequest Yc(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ac(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.pbL = imageRequestBuilder.erK();
        this.pbM = imageRequestBuilder.erL();
        this.pbN = ad(this.pbM);
        this.oXj = imageRequestBuilder.eoF();
        this.pbO = imageRequestBuilder.erU();
        this.oVi = imageRequestBuilder.erP();
        this.oVg = imageRequestBuilder.erN();
        this.oVh = imageRequestBuilder.erO() == null ? e.enT() : imageRequestBuilder.erO();
        this.oYz = imageRequestBuilder.epX();
        this.pbP = imageRequestBuilder.erV();
        this.oZI = imageRequestBuilder.eqV();
        this.pbQ = imageRequestBuilder.eoo();
        this.pak = imageRequestBuilder.erS();
        this.pbd = imageRequestBuilder.erT();
        this.oWA = imageRequestBuilder.ekW();
        this.pbR = imageRequestBuilder.erk();
        this.mTag = imageRequestBuilder.getTag();
        this.pbS = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> erk() {
        return this.pbR;
    }

    public CacheChoice erK() {
        return this.pbL;
    }

    public Uri erL() {
        return this.pbM;
    }

    public int erM() {
        return this.pbN;
    }

    public int getPreferredWidth() {
        if (this.oVg != null) {
            return this.oVg.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.oVg != null) {
            return this.oVg.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d erN() {
        return this.oVg;
    }

    public e erO() {
        return this.oVh;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a epX() {
        return this.oYz;
    }

    public com.facebook.imagepipeline.common.b erP() {
        return this.oVi;
    }

    public boolean erQ() {
        return this.oXj;
    }

    public boolean erR() {
        return this.pbO;
    }

    public Priority eqX() {
        return this.pbP;
    }

    public RequestLevel eqV() {
        return this.oZI;
    }

    public boolean eoo() {
        return this.pbQ;
    }

    public boolean erS() {
        return this.pak;
    }

    public synchronized File bPP() {
        if (this.gty == null) {
            this.gty = new File(this.pbM.getPath());
        }
        return this.gty;
    }

    @Nullable
    public b erT() {
        return this.pbd;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c ekW() {
        return this.oWA;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.pbM, imageRequest.pbM) && f.equal(this.pbL, imageRequest.pbL) && f.equal(this.gty, imageRequest.gty) && f.equal(this.oYz, imageRequest.oYz) && f.equal(this.oVi, imageRequest.oVi) && f.equal(this.oVg, imageRequest.oVg) && f.equal(this.oVh, imageRequest.oVh)) {
                return f.equal(this.pbd != null ? this.pbd.eqS() : null, imageRequest.pbd != null ? imageRequest.pbd.eqS() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.M(this.pbL, this.pbM, this.gty, this.oYz, this.oVi, this.oVg, this.oVh, this.pbd != null ? this.pbd.eqS() : null);
    }

    public String toString() {
        return f.ba(this).F(DownloadDataConstants.Columns.COLUMN_URI, this.pbM).F("cacheChoice", this.pbL).F("decodeOptions", this.oVi).F("postprocessor", this.pbd).F("priority", this.pbP).F("resizeOptions", this.oVg).F("rotationOptions", this.oVh).F("bytesRange", this.oYz).toString();
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

    private static int ad(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.L(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.isLocalFileUri(uri)) {
            if (com.facebook.common.d.a.XK(com.facebook.common.d.a.XL(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.isLocalContentUri(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.O(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.P(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.R(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.Q(uri) ? 8 : -1;
        }
    }
}
