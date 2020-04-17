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
    private File eZH;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d maa;
    private final e mab;
    private final com.facebook.imagepipeline.common.b mad;
    @Nullable
    private final com.facebook.imagepipeline.h.c mby;
    private final boolean mch;
    @Nullable
    private final com.facebook.imagepipeline.common.a mdx;
    private final RequestLevel meG;
    @Nullable
    private final b mfZ;
    private final boolean mfh;
    private final CacheChoice mgH;
    private final Uri mgI;
    private final int mgJ;
    private final boolean mgK;
    private final Priority mgL;
    private final boolean mgM;
    private final Map<String, String> mgN;
    public String mgO;

    /* loaded from: classes12.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest X(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.Z(uri).duW();
    }

    public static ImageRequest Oq(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return X(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.mgH = imageRequestBuilder.duK();
        this.mgI = imageRequestBuilder.duL();
        this.mgJ = Y(this.mgI);
        this.mch = imageRequestBuilder.drE();
        this.mgK = imageRequestBuilder.duU();
        this.mad = imageRequestBuilder.duP();
        this.maa = imageRequestBuilder.duN();
        this.mab = imageRequestBuilder.duO() == null ? e.dqT() : imageRequestBuilder.duO();
        this.mdx = imageRequestBuilder.dsW();
        this.mgL = imageRequestBuilder.duV();
        this.meG = imageRequestBuilder.dtV();
        this.mgM = imageRequestBuilder.drn();
        this.mfh = imageRequestBuilder.duS();
        this.mfZ = imageRequestBuilder.duT();
        this.mby = imageRequestBuilder.dnV();
        this.mgN = imageRequestBuilder.duk();
        this.mTag = imageRequestBuilder.getTag();
        this.mgO = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> duk() {
        return this.mgN;
    }

    public CacheChoice duK() {
        return this.mgH;
    }

    public Uri duL() {
        return this.mgI;
    }

    public int duM() {
        return this.mgJ;
    }

    public int getPreferredWidth() {
        if (this.maa != null) {
            return this.maa.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.maa != null) {
            return this.maa.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d duN() {
        return this.maa;
    }

    public e duO() {
        return this.mab;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dsW() {
        return this.mdx;
    }

    public com.facebook.imagepipeline.common.b duP() {
        return this.mad;
    }

    public boolean duQ() {
        return this.mch;
    }

    public boolean duR() {
        return this.mgK;
    }

    public Priority dtX() {
        return this.mgL;
    }

    public RequestLevel dtV() {
        return this.meG;
    }

    public boolean drn() {
        return this.mgM;
    }

    public boolean duS() {
        return this.mfh;
    }

    public synchronized File bmW() {
        if (this.eZH == null) {
            this.eZH = new File(this.mgI.getPath());
        }
        return this.eZH;
    }

    @Nullable
    public b duT() {
        return this.mfZ;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dnV() {
        return this.mby;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.mgI, imageRequest.mgI) && f.equal(this.mgH, imageRequest.mgH) && f.equal(this.eZH, imageRequest.eZH) && f.equal(this.mdx, imageRequest.mdx) && f.equal(this.mad, imageRequest.mad) && f.equal(this.maa, imageRequest.maa) && f.equal(this.mab, imageRequest.mab)) {
                return f.equal(this.mfZ != null ? this.mfZ.dtS() : null, imageRequest.mfZ != null ? imageRequest.mfZ.dtS() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.M(this.mgH, this.mgI, this.eZH, this.mdx, this.mad, this.maa, this.mab, this.mfZ != null ? this.mfZ.dtS() : null);
    }

    public String toString() {
        return f.aI(this).C(DownloadDataConstants.Columns.COLUMN_URI, this.mgI).C("cacheChoice", this.mgH).C("decodeOptions", this.mad).C("postprocessor", this.mfZ).C("priority", this.mgL).C("resizeOptions", this.maa).C("rotationOptions", this.mab).C("bytesRange", this.mdx).toString();
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
            if (com.facebook.common.d.a.NY(com.facebook.common.d.a.NZ(uri.getPath()))) {
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
