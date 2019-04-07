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
    private com.facebook.imagepipeline.g.b jGx;
    private Uri jLn = null;
    private ImageRequest.RequestLevel jJo = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c jER = null;
    @Nullable
    private com.facebook.imagepipeline.common.d jES = null;
    private com.facebook.imagepipeline.common.a jET = com.facebook.imagepipeline.common.a.cwI();
    private ImageRequest.CacheChoice jLm = ImageRequest.CacheChoice.DEFAULT;
    private boolean jHc = h.cxh().cxB();
    private boolean jLr = false;
    private Priority jLs = Priority.HIGH;
    @Nullable
    private b jKG = null;
    private boolean jLu = true;
    @Nullable
    private a jLp = null;

    public static ImageRequestBuilder O(Uri uri) {
        return new ImageRequestBuilder().P(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder P(Uri uri) {
        g.checkNotNull(uri);
        this.jLn = uri;
        return this;
    }

    public Uri cAn() {
        return this.jLn;
    }

    @Nullable
    public a cAp() {
        return this.jLp;
    }

    public ImageRequest.RequestLevel czC() {
        return this.jJo;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cAq() {
        return this.jER;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.jES = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cAr() {
        return this.jES;
    }

    public com.facebook.imagepipeline.common.a cAs() {
        return this.jET;
    }

    public ImageRequest.CacheChoice cAm() {
        return this.jLm;
    }

    public boolean cxB() {
        return this.jHc;
    }

    public boolean cAz() {
        return this.jLr;
    }

    public boolean cAv() {
        return this.jLu && com.facebook.common.util.d.s(this.jLn);
    }

    public Priority cAA() {
        return this.jLs;
    }

    @Nullable
    public b cAx() {
        return this.jKG;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cAy() {
        return this.jGx;
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
        if (this.jLn == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.y(this.jLn)) {
            if (!this.jLn.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.jLn.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.jLn.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.x(this.jLn) && !this.jLn.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
