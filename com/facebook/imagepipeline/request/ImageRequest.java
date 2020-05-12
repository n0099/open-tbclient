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
    private File eZM;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d maf;
    private final e mag;
    private final com.facebook.imagepipeline.common.b mah;
    @Nullable
    private final com.facebook.imagepipeline.h.c mbC;
    private final boolean mcl;
    @Nullable
    private final com.facebook.imagepipeline.common.a mdB;
    private final RequestLevel meK;
    private final boolean mfl;
    private final CacheChoice mgL;
    private final Uri mgM;
    private final int mgN;
    private final boolean mgO;
    private final Priority mgP;
    private final boolean mgQ;
    private final Map<String, String> mgR;
    public String mgS;
    @Nullable
    private final b mgd;

    /* loaded from: classes12.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest X(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.Z(uri).duU();
    }

    public static ImageRequest Ot(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return X(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.mgL = imageRequestBuilder.duI();
        this.mgM = imageRequestBuilder.duJ();
        this.mgN = Y(this.mgM);
        this.mcl = imageRequestBuilder.drC();
        this.mgO = imageRequestBuilder.duS();
        this.mah = imageRequestBuilder.duN();
        this.maf = imageRequestBuilder.duL();
        this.mag = imageRequestBuilder.duM() == null ? e.dqR() : imageRequestBuilder.duM();
        this.mdB = imageRequestBuilder.dsU();
        this.mgP = imageRequestBuilder.duT();
        this.meK = imageRequestBuilder.dtT();
        this.mgQ = imageRequestBuilder.drl();
        this.mfl = imageRequestBuilder.duQ();
        this.mgd = imageRequestBuilder.duR();
        this.mbC = imageRequestBuilder.dnT();
        this.mgR = imageRequestBuilder.dui();
        this.mTag = imageRequestBuilder.getTag();
        this.mgS = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> dui() {
        return this.mgR;
    }

    public CacheChoice duI() {
        return this.mgL;
    }

    public Uri duJ() {
        return this.mgM;
    }

    public int duK() {
        return this.mgN;
    }

    public int getPreferredWidth() {
        if (this.maf != null) {
            return this.maf.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.maf != null) {
            return this.maf.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d duL() {
        return this.maf;
    }

    public e duM() {
        return this.mag;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dsU() {
        return this.mdB;
    }

    public com.facebook.imagepipeline.common.b duN() {
        return this.mah;
    }

    public boolean duO() {
        return this.mcl;
    }

    public boolean duP() {
        return this.mgO;
    }

    public Priority dtV() {
        return this.mgP;
    }

    public RequestLevel dtT() {
        return this.meK;
    }

    public boolean drl() {
        return this.mgQ;
    }

    public boolean duQ() {
        return this.mfl;
    }

    public synchronized File bmU() {
        if (this.eZM == null) {
            this.eZM = new File(this.mgM.getPath());
        }
        return this.eZM;
    }

    @Nullable
    public b duR() {
        return this.mgd;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dnT() {
        return this.mbC;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.mgM, imageRequest.mgM) && f.equal(this.mgL, imageRequest.mgL) && f.equal(this.eZM, imageRequest.eZM) && f.equal(this.mdB, imageRequest.mdB) && f.equal(this.mah, imageRequest.mah) && f.equal(this.maf, imageRequest.maf) && f.equal(this.mag, imageRequest.mag)) {
                return f.equal(this.mgd != null ? this.mgd.dtQ() : null, imageRequest.mgd != null ? imageRequest.mgd.dtQ() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.M(this.mgL, this.mgM, this.eZM, this.mdB, this.mah, this.maf, this.mag, this.mgd != null ? this.mgd.dtQ() : null);
    }

    public String toString() {
        return f.aJ(this).C(DownloadDataConstants.Columns.COLUMN_URI, this.mgM).C("cacheChoice", this.mgL).C("decodeOptions", this.mah).C("postprocessor", this.mgd).C("priority", this.mgP).C("resizeOptions", this.maf).C("rotationOptions", this.mag).C("bytesRange", this.mdB).toString();
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

    private static int Y(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.G(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.isLocalFileUri(uri)) {
            if (com.facebook.common.d.a.Ob(com.facebook.common.d.a.Oc(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.isLocalContentUri(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.J(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.K(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.M(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.L(uri) ? 8 : -1;
        }
    }
}
