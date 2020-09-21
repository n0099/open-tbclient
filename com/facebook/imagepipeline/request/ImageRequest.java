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
/* loaded from: classes25.dex */
public class ImageRequest {
    private File fRI;
    public String mTag;
    private final e nDA;
    private final com.facebook.imagepipeline.common.b nDB;
    @Nullable
    private final com.facebook.imagepipeline.common.d nDz;
    @Nullable
    private final com.facebook.imagepipeline.h.c nET;
    private final boolean nFC;
    @Nullable
    private final com.facebook.imagepipeline.common.a nGU;
    private final boolean nIE;
    private final RequestLevel nId;
    @Nullable
    private final b nJw;
    private final CacheChoice nKe;
    private final Uri nKf;
    private final int nKg;
    private final boolean nKh;
    private final Priority nKi;
    private final boolean nKj;
    private final Map<String, String> nKk;
    public String nKl;

    /* loaded from: classes25.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ab(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ad(uri).eay();
    }

    public static ImageRequest Vm(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ab(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.nKe = imageRequestBuilder.eam();
        this.nKf = imageRequestBuilder.ean();
        this.nKg = ac(this.nKf);
        this.nFC = imageRequestBuilder.dXh();
        this.nKh = imageRequestBuilder.eaw();
        this.nDB = imageRequestBuilder.ear();
        this.nDz = imageRequestBuilder.eap();
        this.nDA = imageRequestBuilder.eaq() == null ? e.dWw() : imageRequestBuilder.eaq();
        this.nGU = imageRequestBuilder.dYz();
        this.nKi = imageRequestBuilder.eax();
        this.nId = imageRequestBuilder.dZx();
        this.nKj = imageRequestBuilder.dWQ();
        this.nIE = imageRequestBuilder.eau();
        this.nJw = imageRequestBuilder.eav();
        this.nET = imageRequestBuilder.dTA();
        this.nKk = imageRequestBuilder.dZM();
        this.mTag = imageRequestBuilder.getTag();
        this.nKl = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> dZM() {
        return this.nKk;
    }

    public CacheChoice eam() {
        return this.nKe;
    }

    public Uri ean() {
        return this.nKf;
    }

    public int eao() {
        return this.nKg;
    }

    public int getPreferredWidth() {
        if (this.nDz != null) {
            return this.nDz.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.nDz != null) {
            return this.nDz.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d eap() {
        return this.nDz;
    }

    public e eaq() {
        return this.nDA;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dYz() {
        return this.nGU;
    }

    public com.facebook.imagepipeline.common.b ear() {
        return this.nDB;
    }

    public boolean eas() {
        return this.nFC;
    }

    public boolean eat() {
        return this.nKh;
    }

    public Priority dZz() {
        return this.nKi;
    }

    public RequestLevel dZx() {
        return this.nId;
    }

    public boolean dWQ() {
        return this.nKj;
    }

    public boolean eau() {
        return this.nIE;
    }

    public synchronized File bIK() {
        if (this.fRI == null) {
            this.fRI = new File(this.nKf.getPath());
        }
        return this.fRI;
    }

    @Nullable
    public b eav() {
        return this.nJw;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dTA() {
        return this.nET;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.nKf, imageRequest.nKf) && f.equal(this.nKe, imageRequest.nKe) && f.equal(this.fRI, imageRequest.fRI) && f.equal(this.nGU, imageRequest.nGU) && f.equal(this.nDB, imageRequest.nDB) && f.equal(this.nDz, imageRequest.nDz) && f.equal(this.nDA, imageRequest.nDA)) {
                return f.equal(this.nJw != null ? this.nJw.dZu() : null, imageRequest.nJw != null ? imageRequest.nJw.dZu() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.M(this.nKe, this.nKf, this.fRI, this.nGU, this.nDB, this.nDz, this.nDA, this.nJw != null ? this.nJw.dZu() : null);
    }

    public String toString() {
        return f.aS(this).E(DownloadDataConstants.Columns.COLUMN_URI, this.nKf).E("cacheChoice", this.nKe).E("decodeOptions", this.nDB).E("postprocessor", this.nJw).E("priority", this.nKi).E("resizeOptions", this.nDz).E("rotationOptions", this.nDA).E("bytesRange", this.nGU).toString();
    }

    /* loaded from: classes25.dex */
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
            if (com.facebook.common.d.a.UU(com.facebook.common.d.a.UV(uri.getPath()))) {
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
