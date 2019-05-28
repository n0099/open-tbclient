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
    private com.facebook.imagepipeline.g.b jZm;
    private Uri kec = null;
    private ImageRequest.RequestLevel kcd = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c jXG = null;
    @Nullable
    private com.facebook.imagepipeline.common.d jXH = null;
    private com.facebook.imagepipeline.common.a jXI = com.facebook.imagepipeline.common.a.cEG();
    private ImageRequest.CacheChoice keb = ImageRequest.CacheChoice.DEFAULT;
    private boolean jZR = h.cFf().cFz();
    private boolean keg = false;
    private Priority keh = Priority.HIGH;
    @Nullable
    private b kdv = null;
    private boolean kej = true;
    @Nullable
    private a kee = null;

    public static ImageRequestBuilder U(Uri uri) {
        return new ImageRequestBuilder().V(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder V(Uri uri) {
        g.checkNotNull(uri);
        this.kec = uri;
        return this;
    }

    public Uri cIl() {
        return this.kec;
    }

    @Nullable
    public a cIn() {
        return this.kee;
    }

    public ImageRequest.RequestLevel cHA() {
        return this.kcd;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.c cVar) {
        this.jXG = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cIo() {
        return this.jXG;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.jXH = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cIp() {
        return this.jXH;
    }

    public com.facebook.imagepipeline.common.a cIq() {
        return this.jXI;
    }

    public ImageRequest.CacheChoice cIk() {
        return this.keb;
    }

    public boolean cFz() {
        return this.jZR;
    }

    public boolean cIx() {
        return this.keg;
    }

    public boolean cIt() {
        return this.kej && com.facebook.common.util.d.y(this.kec);
    }

    public Priority cIy() {
        return this.keh;
    }

    @Nullable
    public b cIv() {
        return this.kdv;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cIw() {
        return this.jZm;
    }

    public ImageRequest cIz() {
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
        if (this.kec == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.E(this.kec)) {
            if (!this.kec.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.kec.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.kec.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.D(this.kec) && !this.kec.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
