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
/* loaded from: classes18.dex */
public class ImageRequest {
    private File gtR;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d oTD;
    private final e oTE;
    private final com.facebook.imagepipeline.common.b oTF;
    @Nullable
    private final com.facebook.imagepipeline.h.c oUX;
    private final boolean oVG;
    @Nullable
    private final com.facebook.imagepipeline.common.a oWW;
    private final boolean oYG;
    private final RequestLevel oYf;
    @Nullable
    private final b oZy;
    private final CacheChoice pah;
    private final Uri pai;
    private final int paj;
    private final boolean pak;
    private final Priority pal;
    private final boolean pam;
    private final Map<String, String> pan;
    public String pao;

    /* loaded from: classes18.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ab(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ad(uri).erY();
    }

    public static ImageRequest Yr(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ab(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.pah = imageRequestBuilder.erM();
        this.pai = imageRequestBuilder.erN();
        this.paj = ac(this.pai);
        this.oVG = imageRequestBuilder.eoH();
        this.pak = imageRequestBuilder.erW();
        this.oTF = imageRequestBuilder.erR();
        this.oTD = imageRequestBuilder.erP();
        this.oTE = imageRequestBuilder.erQ() == null ? e.enV() : imageRequestBuilder.erQ();
        this.oWW = imageRequestBuilder.epZ();
        this.pal = imageRequestBuilder.erX();
        this.oYf = imageRequestBuilder.eqX();
        this.pam = imageRequestBuilder.eoq();
        this.oYG = imageRequestBuilder.erU();
        this.oZy = imageRequestBuilder.erV();
        this.oUX = imageRequestBuilder.ekY();
        this.pan = imageRequestBuilder.erm();
        this.mTag = imageRequestBuilder.getTag();
        this.pao = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> erm() {
        return this.pan;
    }

    public CacheChoice erM() {
        return this.pah;
    }

    public Uri erN() {
        return this.pai;
    }

    public int erO() {
        return this.paj;
    }

    public int getPreferredWidth() {
        if (this.oTD != null) {
            return this.oTD.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.oTD != null) {
            return this.oTD.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d erP() {
        return this.oTD;
    }

    public e erQ() {
        return this.oTE;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a epZ() {
        return this.oWW;
    }

    public com.facebook.imagepipeline.common.b erR() {
        return this.oTF;
    }

    public boolean erS() {
        return this.oVG;
    }

    public boolean erT() {
        return this.pak;
    }

    public Priority eqZ() {
        return this.pal;
    }

    public RequestLevel eqX() {
        return this.oYf;
    }

    public boolean eoq() {
        return this.pam;
    }

    public boolean erU() {
        return this.oYG;
    }

    public synchronized File bQw() {
        if (this.gtR == null) {
            this.gtR = new File(this.pai.getPath());
        }
        return this.gtR;
    }

    @Nullable
    public b erV() {
        return this.oZy;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c ekY() {
        return this.oUX;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.pai, imageRequest.pai) && f.equal(this.pah, imageRequest.pah) && f.equal(this.gtR, imageRequest.gtR) && f.equal(this.oWW, imageRequest.oWW) && f.equal(this.oTF, imageRequest.oTF) && f.equal(this.oTD, imageRequest.oTD) && f.equal(this.oTE, imageRequest.oTE)) {
                return f.equal(this.oZy != null ? this.oZy.eqU() : null, imageRequest.oZy != null ? imageRequest.oZy.eqU() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.M(this.pah, this.pai, this.gtR, this.oWW, this.oTF, this.oTD, this.oTE, this.oZy != null ? this.oZy.eqU() : null);
    }

    public String toString() {
        return f.aZ(this).F(DownloadDataConstants.Columns.COLUMN_URI, this.pai).F("cacheChoice", this.pah).F("decodeOptions", this.oTF).F("postprocessor", this.oZy).F("priority", this.pal).F("resizeOptions", this.oTD).F("rotationOptions", this.oTE).F("bytesRange", this.oWW).toString();
    }

    /* loaded from: classes18.dex */
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

    private static int ac(Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.d.K(uri)) {
            return 0;
        }
        if (com.facebook.common.util.d.isLocalFileUri(uri)) {
            if (com.facebook.common.d.a.XZ(com.facebook.common.d.a.Ya(uri.getPath()))) {
                return 2;
            }
            return 3;
        } else if (com.facebook.common.util.d.isLocalContentUri(uri)) {
            return 4;
        } else {
            if (com.facebook.common.util.d.N(uri)) {
                return 5;
            }
            if (com.facebook.common.util.d.O(uri)) {
                return 6;
            }
            if (com.facebook.common.util.d.Q(uri)) {
                return 7;
            }
            return com.facebook.common.util.d.P(uri) ? 8 : -1;
        }
    }
}
