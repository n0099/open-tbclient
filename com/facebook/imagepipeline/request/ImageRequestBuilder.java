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
    private com.facebook.imagepipeline.g.b jHd;
    private Uri jLT = null;
    private ImageRequest.RequestLevel jJU = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c jFx = null;
    @Nullable
    private com.facebook.imagepipeline.common.d jFy = null;
    private com.facebook.imagepipeline.common.a jFz = com.facebook.imagepipeline.common.a.cwP();
    private ImageRequest.CacheChoice jLS = ImageRequest.CacheChoice.DEFAULT;
    private boolean jHI = h.cxo().cxI();
    private boolean jLX = false;
    private Priority jLY = Priority.HIGH;
    @Nullable
    private b jLm = null;
    private boolean jMa = true;
    @Nullable
    private a jLV = null;

    public static ImageRequestBuilder O(Uri uri) {
        return new ImageRequestBuilder().P(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder P(Uri uri) {
        g.checkNotNull(uri);
        this.jLT = uri;
        return this;
    }

    public Uri cAu() {
        return this.jLT;
    }

    @Nullable
    public a cAw() {
        return this.jLV;
    }

    public ImageRequest.RequestLevel czJ() {
        return this.jJU;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cAx() {
        return this.jFx;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.jFy = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cAy() {
        return this.jFy;
    }

    public com.facebook.imagepipeline.common.a cAz() {
        return this.jFz;
    }

    public ImageRequest.CacheChoice cAt() {
        return this.jLS;
    }

    public boolean cxI() {
        return this.jHI;
    }

    public boolean cAG() {
        return this.jLX;
    }

    public boolean cAC() {
        return this.jMa && com.facebook.common.util.d.s(this.jLT);
    }

    public Priority cAH() {
        return this.jLY;
    }

    @Nullable
    public b cAE() {
        return this.jLm;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cAF() {
        return this.jHd;
    }

    public ImageRequest cAI() {
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
        if (this.jLT == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.y(this.jLT)) {
            if (!this.jLT.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.jLT.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.jLT.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.x(this.jLT) && !this.jLT.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
