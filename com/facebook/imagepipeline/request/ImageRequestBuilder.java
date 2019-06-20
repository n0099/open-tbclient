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
    private com.facebook.imagepipeline.g.b jZp;
    private Uri kef = null;
    private ImageRequest.RequestLevel kcg = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c jXJ = null;
    @Nullable
    private com.facebook.imagepipeline.common.d jXK = null;
    private com.facebook.imagepipeline.common.a jXL = com.facebook.imagepipeline.common.a.cEF();
    private ImageRequest.CacheChoice kee = ImageRequest.CacheChoice.DEFAULT;
    private boolean jZU = h.cFe().cFy();
    private boolean kej = false;
    private Priority kek = Priority.HIGH;
    @Nullable
    private b kdy = null;
    private boolean kem = true;
    @Nullable
    private a keh = null;

    public static ImageRequestBuilder U(Uri uri) {
        return new ImageRequestBuilder().V(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder V(Uri uri) {
        g.checkNotNull(uri);
        this.kef = uri;
        return this;
    }

    public Uri cIk() {
        return this.kef;
    }

    @Nullable
    public a cIm() {
        return this.keh;
    }

    public ImageRequest.RequestLevel cHz() {
        return this.kcg;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.c cVar) {
        this.jXJ = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cIn() {
        return this.jXJ;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.jXK = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cIo() {
        return this.jXK;
    }

    public com.facebook.imagepipeline.common.a cIp() {
        return this.jXL;
    }

    public ImageRequest.CacheChoice cIj() {
        return this.kee;
    }

    public boolean cFy() {
        return this.jZU;
    }

    public boolean cIw() {
        return this.kej;
    }

    public boolean cIs() {
        return this.kem && com.facebook.common.util.d.y(this.kef);
    }

    public Priority cIx() {
        return this.kek;
    }

    @Nullable
    public b cIu() {
        return this.kdy;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cIv() {
        return this.jZp;
    }

    public ImageRequest cIy() {
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
        if (this.kef == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.E(this.kef)) {
            if (!this.kef.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.kef.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.kef.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.D(this.kef) && !this.kef.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
