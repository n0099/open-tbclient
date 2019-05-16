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
    private com.facebook.imagepipeline.g.b jZl;
    private Uri keb = null;
    private ImageRequest.RequestLevel kcc = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c jXF = null;
    @Nullable
    private com.facebook.imagepipeline.common.d jXG = null;
    private com.facebook.imagepipeline.common.a jXH = com.facebook.imagepipeline.common.a.cEE();
    private ImageRequest.CacheChoice kea = ImageRequest.CacheChoice.DEFAULT;
    private boolean jZQ = h.cFd().cFx();
    private boolean kef = false;
    private Priority keg = Priority.HIGH;
    @Nullable
    private b kdu = null;
    private boolean kei = true;
    @Nullable
    private a ked = null;

    public static ImageRequestBuilder U(Uri uri) {
        return new ImageRequestBuilder().V(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder V(Uri uri) {
        g.checkNotNull(uri);
        this.keb = uri;
        return this;
    }

    public Uri cIj() {
        return this.keb;
    }

    @Nullable
    public a cIl() {
        return this.ked;
    }

    public ImageRequest.RequestLevel cHy() {
        return this.kcc;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.c cVar) {
        this.jXF = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cIm() {
        return this.jXF;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.jXG = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cIn() {
        return this.jXG;
    }

    public com.facebook.imagepipeline.common.a cIo() {
        return this.jXH;
    }

    public ImageRequest.CacheChoice cIi() {
        return this.kea;
    }

    public boolean cFx() {
        return this.jZQ;
    }

    public boolean cIv() {
        return this.kef;
    }

    public boolean cIr() {
        return this.kei && com.facebook.common.util.d.y(this.keb);
    }

    public Priority cIw() {
        return this.keg;
    }

    @Nullable
    public b cIt() {
        return this.kdu;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cIu() {
        return this.jZl;
    }

    public ImageRequest cIx() {
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
        if (this.keb == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.E(this.keb)) {
            if (!this.keb.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.keb.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.keb.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.D(this.keb) && !this.keb.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
