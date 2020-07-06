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
    private com.facebook.imagepipeline.h.c mSH;
    private Uri mXY = null;
    private ImageRequest.RequestLevel mVV = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d mRl = null;
    @Nullable
    private e mRm = null;
    private com.facebook.imagepipeline.common.b mRn = com.facebook.imagepipeline.common.b.dCT();
    private ImageRequest.CacheChoice mXX = ImageRequest.CacheChoice.DEFAULT;
    private boolean mTt = h.dDu().dDO();
    private boolean mYa = false;
    private Priority mYb = Priority.HIGH;
    @Nullable
    private b mXp = null;
    private boolean mTn = true;
    private boolean mYf = true;
    @Nullable
    private com.facebook.imagepipeline.common.a mUM = null;
    private Map<String, String> mYd = null;
    private String mTag = null;
    private String mYe = null;

    public static ImageRequestBuilder ac(Uri uri) {
        return new ImageRequestBuilder().ad(uri);
    }

    public static ImageRequestBuilder Ju(int i) {
        return ac(com.facebook.common.util.d.HX(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ac(imageRequest.dGU()).a(imageRequest.dGY()).d(imageRequest.dFg()).a(imageRequest.dGT()).wM(imageRequest.dHa()).a(imageRequest.dGe()).a(imageRequest.dHc()).wL(imageRequest.dGZ()).b(imageRequest.dGg()).c(imageRequest.dGW()).c(imageRequest.dAg()).a(imageRequest.dGX()).c(imageRequest.dAg()).y(imageRequest.dGt()).QW(imageRequest.mTag).QX(imageRequest.mYe);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dGt() {
        return this.mYd;
    }

    public ImageRequestBuilder y(Map<String, String> map) {
        this.mYd = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder QW(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.mYe;
    }

    public ImageRequestBuilder QX(String str) {
        this.mYe = str;
        return this;
    }

    public ImageRequestBuilder ad(Uri uri) {
        g.checkNotNull(uri);
        this.mXY = uri;
        return this;
    }

    public Uri dGU() {
        return this.mXY;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.mVV = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dGe() {
        return this.mVV;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.mRl = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dGW() {
        return this.mRl;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.mRm = eVar;
        return this;
    }

    @Nullable
    public e dGX() {
        return this.mRm;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.mUM = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dFg() {
        return this.mUM;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.mRn = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dGY() {
        return this.mRn;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.mXX = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dGT() {
        return this.mXX;
    }

    public ImageRequestBuilder wL(boolean z) {
        this.mTt = z;
        return this;
    }

    public boolean dDO() {
        return this.mTt;
    }

    public ImageRequestBuilder wM(boolean z) {
        this.mYa = z;
        return this;
    }

    public boolean dHd() {
        return this.mYa;
    }

    public boolean dDx() {
        return this.mTn && com.facebook.common.util.d.J(this.mXY);
    }

    public boolean dHb() {
        return this.mYf;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.mYb = priority;
        return this;
    }

    public Priority dHe() {
        return this.mYb;
    }

    public ImageRequestBuilder a(b bVar) {
        this.mXp = bVar;
        return this;
    }

    @Nullable
    public b dHc() {
        return this.mXp;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.mSH = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dAg() {
        return this.mSH;
    }

    public ImageRequest dHf() {
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
        if (this.mXY == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.N(this.mXY)) {
            if (!this.mXY.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.mXY.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.mXY.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.M(this.mXY) && !this.mXY.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
