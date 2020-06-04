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
    private com.facebook.imagepipeline.h.c mwD;
    private Uri mBO = null;
    private ImageRequest.RequestLevel mzL = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d mvj = null;
    @Nullable
    private e mvk = null;
    private com.facebook.imagepipeline.common.b mvl = com.facebook.imagepipeline.common.b.dyn();
    private ImageRequest.CacheChoice mBN = ImageRequest.CacheChoice.DEFAULT;
    private boolean mxm = h.dyO().dzi();
    private boolean mBQ = false;
    private Priority mBR = Priority.HIGH;
    @Nullable
    private b mBe = null;
    private boolean mxh = true;
    private boolean mBV = true;
    @Nullable
    private com.facebook.imagepipeline.common.a myC = null;
    private Map<String, String> mBT = null;
    private String mTag = null;
    private String mBU = null;

    public static ImageRequestBuilder ab(Uri uri) {
        return new ImageRequestBuilder().ac(uri);
    }

    public static ImageRequestBuilder In(int i) {
        return ab(com.facebook.common.util.d.GQ(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ab(imageRequest.dCo()).a(imageRequest.dCs()).d(imageRequest.dAA()).a(imageRequest.dCn()).wq(imageRequest.dCu()).a(imageRequest.dBy()).a(imageRequest.dCw()).wp(imageRequest.dCt()).b(imageRequest.dBA()).c(imageRequest.dCq()).c(imageRequest.dvz()).a(imageRequest.dCr()).c(imageRequest.dvz()).x(imageRequest.dBN()).Qj(imageRequest.mTag).Qk(imageRequest.mBU);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dBN() {
        return this.mBT;
    }

    public ImageRequestBuilder x(Map<String, String> map) {
        this.mBT = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Qj(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.mBU;
    }

    public ImageRequestBuilder Qk(String str) {
        this.mBU = str;
        return this;
    }

    public ImageRequestBuilder ac(Uri uri) {
        g.checkNotNull(uri);
        this.mBO = uri;
        return this;
    }

    public Uri dCo() {
        return this.mBO;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.mzL = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dBy() {
        return this.mzL;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.mvj = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dCq() {
        return this.mvj;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.mvk = eVar;
        return this;
    }

    @Nullable
    public e dCr() {
        return this.mvk;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.myC = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dAA() {
        return this.myC;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.mvl = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dCs() {
        return this.mvl;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.mBN = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dCn() {
        return this.mBN;
    }

    public ImageRequestBuilder wp(boolean z) {
        this.mxm = z;
        return this;
    }

    public boolean dzi() {
        return this.mxm;
    }

    public ImageRequestBuilder wq(boolean z) {
        this.mBQ = z;
        return this;
    }

    public boolean dCx() {
        return this.mBQ;
    }

    public boolean dyR() {
        return this.mxh && com.facebook.common.util.d.I(this.mBO);
    }

    public boolean dCv() {
        return this.mBV;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.mBR = priority;
        return this;
    }

    public Priority dCy() {
        return this.mBR;
    }

    public ImageRequestBuilder a(b bVar) {
        this.mBe = bVar;
        return this;
    }

    @Nullable
    public b dCw() {
        return this.mBe;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.mwD = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dvz() {
        return this.mwD;
    }

    public ImageRequest dCz() {
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
        if (this.mBO == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.M(this.mBO)) {
            if (!this.mBO.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.mBO.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.mBO.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.L(this.mBO) && !this.mBO.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
