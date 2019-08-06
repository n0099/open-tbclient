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
    private com.facebook.imagepipeline.g.b khB;
    private Uri kms = null;
    private ImageRequest.RequestLevel kkt = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c kfU = null;
    @Nullable
    private com.facebook.imagepipeline.common.d kfV = null;
    private com.facebook.imagepipeline.common.a kfW = com.facebook.imagepipeline.common.a.cId();
    private ImageRequest.CacheChoice kmr = ImageRequest.CacheChoice.DEFAULT;
    private boolean kih = h.cIC().cIW();
    private boolean kmw = false;
    private Priority kmx = Priority.HIGH;
    @Nullable
    private b klL = null;
    private boolean kmz = true;
    @Nullable
    private a kmu = null;

    public static ImageRequestBuilder U(Uri uri) {
        return new ImageRequestBuilder().V(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder V(Uri uri) {
        g.checkNotNull(uri);
        this.kms = uri;
        return this;
    }

    public Uri cLJ() {
        return this.kms;
    }

    @Nullable
    public a cLL() {
        return this.kmu;
    }

    public ImageRequest.RequestLevel cKY() {
        return this.kkt;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.c cVar) {
        this.kfU = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cLM() {
        return this.kfU;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.kfV = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cLN() {
        return this.kfV;
    }

    public com.facebook.imagepipeline.common.a cLO() {
        return this.kfW;
    }

    public ImageRequest.CacheChoice cLI() {
        return this.kmr;
    }

    public boolean cIW() {
        return this.kih;
    }

    public boolean cLV() {
        return this.kmw;
    }

    public boolean cLR() {
        return this.kmz && com.facebook.common.util.d.y(this.kms);
    }

    public Priority cLW() {
        return this.kmx;
    }

    @Nullable
    public b cLT() {
        return this.klL;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cLU() {
        return this.khB;
    }

    public ImageRequest cLX() {
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
        if (this.kms == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.E(this.kms)) {
            if (!this.kms.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.kms.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.kms.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.D(this.kms) && !this.kms.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
