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
    private File gea;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d nSS;
    private final e nST;
    private final com.facebook.imagepipeline.common.b nSU;
    private final boolean nUV;
    @Nullable
    private final com.facebook.imagepipeline.h.c nUm;
    @Nullable
    private final com.facebook.imagepipeline.common.a nWl;
    private final boolean nXV;
    private final RequestLevel nXu;
    @Nullable
    private final b nYN;
    private final boolean nZA;
    private final Map<String, String> nZB;
    public String nZC;
    private final CacheChoice nZv;
    private final Uri nZw;
    private final int nZx;
    private final boolean nZy;
    private final Priority nZz;

    /* loaded from: classes18.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ab(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ad(uri).eej();
    }

    public static ImageRequest Wa(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ab(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.nZv = imageRequestBuilder.edX();
        this.nZw = imageRequestBuilder.edY();
        this.nZx = ac(this.nZw);
        this.nUV = imageRequestBuilder.eaS();
        this.nZy = imageRequestBuilder.eeh();
        this.nSU = imageRequestBuilder.eec();
        this.nSS = imageRequestBuilder.eea();
        this.nST = imageRequestBuilder.eeb() == null ? e.eah() : imageRequestBuilder.eeb();
        this.nWl = imageRequestBuilder.eck();
        this.nZz = imageRequestBuilder.eei();
        this.nXu = imageRequestBuilder.edi();
        this.nZA = imageRequestBuilder.eaB();
        this.nXV = imageRequestBuilder.eef();
        this.nYN = imageRequestBuilder.eeg();
        this.nUm = imageRequestBuilder.dXl();
        this.nZB = imageRequestBuilder.edx();
        this.mTag = imageRequestBuilder.getTag();
        this.nZC = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> edx() {
        return this.nZB;
    }

    public CacheChoice edX() {
        return this.nZv;
    }

    public Uri edY() {
        return this.nZw;
    }

    public int edZ() {
        return this.nZx;
    }

    public int getPreferredWidth() {
        if (this.nSS != null) {
            return this.nSS.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.nSS != null) {
            return this.nSS.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d eea() {
        return this.nSS;
    }

    public e eeb() {
        return this.nST;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eck() {
        return this.nWl;
    }

    public com.facebook.imagepipeline.common.b eec() {
        return this.nSU;
    }

    public boolean eed() {
        return this.nUV;
    }

    public boolean eee() {
        return this.nZy;
    }

    public Priority edk() {
        return this.nZz;
    }

    public RequestLevel edi() {
        return this.nXu;
    }

    public boolean eaB() {
        return this.nZA;
    }

    public boolean eef() {
        return this.nXV;
    }

    public synchronized File bLu() {
        if (this.gea == null) {
            this.gea = new File(this.nZw.getPath());
        }
        return this.gea;
    }

    @Nullable
    public b eeg() {
        return this.nYN;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dXl() {
        return this.nUm;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.nZw, imageRequest.nZw) && f.equal(this.nZv, imageRequest.nZv) && f.equal(this.gea, imageRequest.gea) && f.equal(this.nWl, imageRequest.nWl) && f.equal(this.nSU, imageRequest.nSU) && f.equal(this.nSS, imageRequest.nSS) && f.equal(this.nST, imageRequest.nST)) {
                return f.equal(this.nYN != null ? this.nYN.edf() : null, imageRequest.nYN != null ? imageRequest.nYN.edf() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.M(this.nZv, this.nZw, this.gea, this.nWl, this.nSU, this.nSS, this.nST, this.nYN != null ? this.nYN.edf() : null);
    }

    public String toString() {
        return f.aV(this).F(DownloadDataConstants.Columns.COLUMN_URI, this.nZw).F("cacheChoice", this.nZv).F("decodeOptions", this.nSU).F("postprocessor", this.nYN).F("priority", this.nZz).F("resizeOptions", this.nSS).F("rotationOptions", this.nST).F("bytesRange", this.nWl).toString();
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
            if (com.facebook.common.d.a.VI(com.facebook.common.d.a.VJ(uri.getPath()))) {
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
