package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.h.c mvt;
    private Uri mAD = null;
    private ImageRequest.RequestLevel myB = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d mtZ = null;
    @Nullable
    private e mua = null;
    private com.facebook.imagepipeline.common.b mub = com.facebook.imagepipeline.common.b.dxZ();
    private ImageRequest.CacheChoice mAC = ImageRequest.CacheChoice.DEFAULT;
    private boolean mwc = h.dyA().dyU();
    private boolean mAF = false;
    private Priority mAG = Priority.HIGH;
    @Nullable
    private b mzU = null;
    private boolean mvX = true;
    private boolean mAK = true;
    @Nullable
    private com.facebook.imagepipeline.common.a mxs = null;
    private Map<String, String> mAI = null;
    private String mTag = null;
    private String mAJ = null;

    public static ImageRequestBuilder ab(Uri uri) {
        return new ImageRequestBuilder().ac(uri);
    }

    public static ImageRequestBuilder Il(int i) {
        return ab(com.facebook.common.util.d.GO(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ab(imageRequest.dCa()).a(imageRequest.dCe()).d(imageRequest.dAm()).a(imageRequest.dBZ()).wo(imageRequest.dCg()).a(imageRequest.dBk()).a(imageRequest.dCi()).wn(imageRequest.dCf()).b(imageRequest.dBm()).c(imageRequest.dCc()).c(imageRequest.dvl()).a(imageRequest.dCd()).c(imageRequest.dvl()).x(imageRequest.dBz()).Qi(imageRequest.mTag).Qj(imageRequest.mAJ);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dBz() {
        return this.mAI;
    }

    public ImageRequestBuilder x(Map<String, String> map) {
        this.mAI = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Qi(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.mAJ;
    }

    public ImageRequestBuilder Qj(String str) {
        this.mAJ = str;
        return this;
    }

    public ImageRequestBuilder ac(Uri uri) {
        g.checkNotNull(uri);
        this.mAD = uri;
        return this;
    }

    public Uri dCa() {
        return this.mAD;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.myB = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dBk() {
        return this.myB;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.mtZ = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dCc() {
        return this.mtZ;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.mua = eVar;
        return this;
    }

    @Nullable
    public e dCd() {
        return this.mua;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.mxs = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dAm() {
        return this.mxs;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.mub = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dCe() {
        return this.mub;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.mAC = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dBZ() {
        return this.mAC;
    }

    public ImageRequestBuilder wn(boolean z) {
        this.mwc = z;
        return this;
    }

    public boolean dyU() {
        return this.mwc;
    }

    public ImageRequestBuilder wo(boolean z) {
        this.mAF = z;
        return this;
    }

    public boolean dCj() {
        return this.mAF;
    }

    public boolean dyD() {
        return this.mvX && com.facebook.common.util.d.I(this.mAD);
    }

    public boolean dCh() {
        return this.mAK;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.mAG = priority;
        return this;
    }

    public Priority dCk() {
        return this.mAG;
    }

    public ImageRequestBuilder a(b bVar) {
        this.mzU = bVar;
        return this;
    }

    @Nullable
    public b dCi() {
        return this.mzU;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.mvt = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dvl() {
        return this.mvt;
    }

    public ImageRequest dCl() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes12.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.mAD == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.M(this.mAD)) {
            if (!this.mAD.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.mAD.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.mAD.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.L(this.mAD) && !this.mAD.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
