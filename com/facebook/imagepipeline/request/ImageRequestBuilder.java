package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.g.b jGy;
    private Uri jLo = null;
    private ImageRequest.RequestLevel jJp = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c jES = null;
    @Nullable
    private com.facebook.imagepipeline.common.d jET = null;
    private com.facebook.imagepipeline.common.a jEU = com.facebook.imagepipeline.common.a.cwI();
    private ImageRequest.CacheChoice jLn = ImageRequest.CacheChoice.DEFAULT;
    private boolean jHd = h.cxh().cxB();
    private boolean jLs = false;
    private Priority jLt = Priority.HIGH;
    @Nullable
    private b jKH = null;
    private boolean jLv = true;
    @Nullable
    private a jLq = null;

    public static ImageRequestBuilder O(Uri uri) {
        return new ImageRequestBuilder().P(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder P(Uri uri) {
        g.checkNotNull(uri);
        this.jLo = uri;
        return this;
    }

    public Uri cAn() {
        return this.jLo;
    }

    @Nullable
    public a cAp() {
        return this.jLq;
    }

    public ImageRequest.RequestLevel czC() {
        return this.jJp;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cAq() {
        return this.jES;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.jET = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cAr() {
        return this.jET;
    }

    public com.facebook.imagepipeline.common.a cAs() {
        return this.jEU;
    }

    public ImageRequest.CacheChoice cAm() {
        return this.jLn;
    }

    public boolean cxB() {
        return this.jHd;
    }

    public boolean cAz() {
        return this.jLs;
    }

    public boolean cAv() {
        return this.jLv && com.facebook.common.util.d.s(this.jLo);
    }

    public Priority cAA() {
        return this.jLt;
    }

    @Nullable
    public b cAx() {
        return this.jKH;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cAy() {
        return this.jGy;
    }

    public ImageRequest cAB() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes2.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.jLo == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.y(this.jLo)) {
            if (!this.jLo.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.jLo.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.jLo.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.x(this.jLo) && !this.jLo.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
