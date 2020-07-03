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
    private com.facebook.imagepipeline.h.c mSE;
    private Uri mXV = null;
    private ImageRequest.RequestLevel mVS = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d mRi = null;
    @Nullable
    private e mRj = null;
    private com.facebook.imagepipeline.common.b mRk = com.facebook.imagepipeline.common.b.dCP();
    private ImageRequest.CacheChoice mXU = ImageRequest.CacheChoice.DEFAULT;
    private boolean mTq = h.dDq().dDK();
    private boolean mXX = false;
    private Priority mXY = Priority.HIGH;
    @Nullable
    private b mXm = null;
    private boolean mTk = true;
    private boolean mYc = true;
    @Nullable
    private com.facebook.imagepipeline.common.a mUJ = null;
    private Map<String, String> mYa = null;
    private String mTag = null;
    private String mYb = null;

    public static ImageRequestBuilder ac(Uri uri) {
        return new ImageRequestBuilder().ad(uri);
    }

    public static ImageRequestBuilder Ju(int i) {
        return ac(com.facebook.common.util.d.HX(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ac(imageRequest.dGQ()).a(imageRequest.dGU()).d(imageRequest.dFc()).a(imageRequest.dGP()).wM(imageRequest.dGW()).a(imageRequest.dGa()).a(imageRequest.dGY()).wL(imageRequest.dGV()).b(imageRequest.dGc()).c(imageRequest.dGS()).c(imageRequest.dAc()).a(imageRequest.dGT()).c(imageRequest.dAc()).y(imageRequest.dGp()).QV(imageRequest.mTag).QW(imageRequest.mYb);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dGp() {
        return this.mYa;
    }

    public ImageRequestBuilder y(Map<String, String> map) {
        this.mYa = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder QV(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.mYb;
    }

    public ImageRequestBuilder QW(String str) {
        this.mYb = str;
        return this;
    }

    public ImageRequestBuilder ad(Uri uri) {
        g.checkNotNull(uri);
        this.mXV = uri;
        return this;
    }

    public Uri dGQ() {
        return this.mXV;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.mVS = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dGa() {
        return this.mVS;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.mRi = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dGS() {
        return this.mRi;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.mRj = eVar;
        return this;
    }

    @Nullable
    public e dGT() {
        return this.mRj;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.mUJ = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dFc() {
        return this.mUJ;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.mRk = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dGU() {
        return this.mRk;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.mXU = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dGP() {
        return this.mXU;
    }

    public ImageRequestBuilder wL(boolean z) {
        this.mTq = z;
        return this;
    }

    public boolean dDK() {
        return this.mTq;
    }

    public ImageRequestBuilder wM(boolean z) {
        this.mXX = z;
        return this;
    }

    public boolean dGZ() {
        return this.mXX;
    }

    public boolean dDt() {
        return this.mTk && com.facebook.common.util.d.J(this.mXV);
    }

    public boolean dGX() {
        return this.mYc;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.mXY = priority;
        return this;
    }

    public Priority dHa() {
        return this.mXY;
    }

    public ImageRequestBuilder a(b bVar) {
        this.mXm = bVar;
        return this;
    }

    @Nullable
    public b dGY() {
        return this.mXm;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.mSE = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dAc() {
        return this.mSE;
    }

    public ImageRequest dHb() {
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
        if (this.mXV == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.N(this.mXV)) {
            if (!this.mXV.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.mXV.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.mXV.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.M(this.mXV) && !this.mXV.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
