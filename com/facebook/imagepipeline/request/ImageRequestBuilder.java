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
    private com.facebook.imagepipeline.g.b kil;
    private Uri knb = null;
    private ImageRequest.RequestLevel klc = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c kgC = null;
    @Nullable
    private com.facebook.imagepipeline.common.d kgD = null;
    private com.facebook.imagepipeline.common.a kgE = com.facebook.imagepipeline.common.a.cFO();
    private ImageRequest.CacheChoice kna = ImageRequest.CacheChoice.DEFAULT;
    private boolean kiQ = h.cGn().cGH();
    private boolean knf = false;
    private Priority kng = Priority.HIGH;
    @Nullable
    private b kmu = null;
    private boolean kni = true;
    @Nullable
    private a knd = null;

    public static ImageRequestBuilder R(Uri uri) {
        return new ImageRequestBuilder().S(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder S(Uri uri) {
        g.checkNotNull(uri);
        this.knb = uri;
        return this;
    }

    public Uri cJu() {
        return this.knb;
    }

    @Nullable
    public a cJw() {
        return this.knd;
    }

    public ImageRequest.RequestLevel cIJ() {
        return this.klc;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.c cVar) {
        this.kgC = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cJx() {
        return this.kgC;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.kgD = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cJy() {
        return this.kgD;
    }

    public com.facebook.imagepipeline.common.a cJz() {
        return this.kgE;
    }

    public ImageRequest.CacheChoice cJt() {
        return this.kna;
    }

    public boolean cGH() {
        return this.kiQ;
    }

    public boolean cJG() {
        return this.knf;
    }

    public boolean cJC() {
        return this.kni && com.facebook.common.util.d.v(this.knb);
    }

    public Priority cJH() {
        return this.kng;
    }

    @Nullable
    public b cJE() {
        return this.kmu;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cJF() {
        return this.kil;
    }

    public ImageRequest cJI() {
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
        if (this.knb == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.B(this.knb)) {
            if (!this.knb.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.knb.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.knb.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.A(this.knb) && !this.knb.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
