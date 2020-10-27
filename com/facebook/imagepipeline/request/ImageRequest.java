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
    private File goe;
    public String mTag;
    @Nullable
    private final com.facebook.imagepipeline.common.d oKk;
    private final e oKl;
    private final com.facebook.imagepipeline.common.b oKm;
    @Nullable
    private final com.facebook.imagepipeline.h.c oLE;
    private final boolean oMn;
    @Nullable
    private final com.facebook.imagepipeline.common.a oND;
    private final RequestLevel oOM;
    private final boolean oPn;
    private final CacheChoice oQN;
    private final Uri oQO;
    private final int oQP;
    private final boolean oQQ;
    private final Priority oQR;
    private final boolean oQS;
    private final Map<String, String> oQT;
    public String oQU;
    @Nullable
    private final b oQf;

    /* loaded from: classes18.dex */
    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public static ImageRequest ab(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.ad(uri).eoj();
    }

    public static ImageRequest XN(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return ab(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.oQN = imageRequestBuilder.enW();
        this.oQO = imageRequestBuilder.enX();
        this.oQP = ac(this.oQO);
        this.oMn = imageRequestBuilder.ekQ();
        this.oQQ = imageRequestBuilder.eoh();
        this.oKm = imageRequestBuilder.eob();
        this.oKk = imageRequestBuilder.enZ();
        this.oKl = imageRequestBuilder.eoa() == null ? e.ekf() : imageRequestBuilder.eoa();
        this.oND = imageRequestBuilder.emi();
        this.oQR = imageRequestBuilder.eoi();
        this.oOM = imageRequestBuilder.enh();
        this.oQS = imageRequestBuilder.ekz();
        this.oPn = imageRequestBuilder.eoe();
        this.oQf = imageRequestBuilder.eog();
        this.oLE = imageRequestBuilder.ehj();
        this.oQT = imageRequestBuilder.enw();
        this.mTag = imageRequestBuilder.getTag();
        this.oQU = imageRequestBuilder.getLogTag();
    }

    public Map<String, String> enw() {
        return this.oQT;
    }

    public CacheChoice enW() {
        return this.oQN;
    }

    public Uri enX() {
        return this.oQO;
    }

    public int enY() {
        return this.oQP;
    }

    public int getPreferredWidth() {
        if (this.oKk != null) {
            return this.oKk.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        if (this.oKk != null) {
            return this.oKk.height;
        }
        return 2048;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d enZ() {
        return this.oKk;
    }

    public e eoa() {
        return this.oKl;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a emi() {
        return this.oND;
    }

    public com.facebook.imagepipeline.common.b eob() {
        return this.oKm;
    }

    public boolean eoc() {
        return this.oMn;
    }

    public boolean eod() {
        return this.oQQ;
    }

    public Priority enj() {
        return this.oQR;
    }

    public RequestLevel enh() {
        return this.oOM;
    }

    public boolean ekz() {
        return this.oQS;
    }

    public boolean eoe() {
        return this.oPn;
    }

    public synchronized File bNW() {
        if (this.goe == null) {
            this.goe = new File(this.oQO.getPath());
        }
        return this.goe;
    }

    @Nullable
    public b eog() {
        return this.oQf;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c ehj() {
        return this.oLE;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (f.equal(this.oQO, imageRequest.oQO) && f.equal(this.oQN, imageRequest.oQN) && f.equal(this.goe, imageRequest.goe) && f.equal(this.oND, imageRequest.oND) && f.equal(this.oKm, imageRequest.oKm) && f.equal(this.oKk, imageRequest.oKk) && f.equal(this.oKl, imageRequest.oKl)) {
                return f.equal(this.oQf != null ? this.oQf.ene() : null, imageRequest.oQf != null ? imageRequest.oQf.ene() : null);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return f.M(this.oQN, this.oQO, this.goe, this.oND, this.oKm, this.oKk, this.oKl, this.oQf != null ? this.oQf.ene() : null);
    }

    public String toString() {
        return f.aZ(this).F(DownloadDataConstants.Columns.COLUMN_URI, this.oQO).F("cacheChoice", this.oQN).F("decodeOptions", this.oKm).F("postprocessor", this.oQf).F("priority", this.oQR).F("resizeOptions", this.oKk).F("rotationOptions", this.oKl).F("bytesRange", this.oND).toString();
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
            if (com.facebook.common.d.a.Xv(com.facebook.common.d.a.Xw(uri.getPath()))) {
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
