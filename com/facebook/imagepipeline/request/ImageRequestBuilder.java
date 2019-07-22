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
    private com.facebook.imagepipeline.g.b kgv;
    private Uri klm = null;
    private ImageRequest.RequestLevel kjn = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c keO = null;
    @Nullable
    private com.facebook.imagepipeline.common.d keP = null;
    private com.facebook.imagepipeline.common.a keQ = com.facebook.imagepipeline.common.a.cHI();
    private ImageRequest.CacheChoice kll = ImageRequest.CacheChoice.DEFAULT;
    private boolean kha = h.cIh().cIB();
    private boolean klq = false;
    private Priority klr = Priority.HIGH;
    @Nullable
    private b kkF = null;
    private boolean klt = true;
    @Nullable
    private a klo = null;

    public static ImageRequestBuilder U(Uri uri) {
        return new ImageRequestBuilder().V(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder V(Uri uri) {
        g.checkNotNull(uri);
        this.klm = uri;
        return this;
    }

    public Uri cLo() {
        return this.klm;
    }

    @Nullable
    public a cLq() {
        return this.klo;
    }

    public ImageRequest.RequestLevel cKD() {
        return this.kjn;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.c cVar) {
        this.keO = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cLr() {
        return this.keO;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.keP = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cLs() {
        return this.keP;
    }

    public com.facebook.imagepipeline.common.a cLt() {
        return this.keQ;
    }

    public ImageRequest.CacheChoice cLn() {
        return this.kll;
    }

    public boolean cIB() {
        return this.kha;
    }

    public boolean cLA() {
        return this.klq;
    }

    public boolean cLw() {
        return this.klt && com.facebook.common.util.d.y(this.klm);
    }

    public Priority cLB() {
        return this.klr;
    }

    @Nullable
    public b cLy() {
        return this.kkF;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cLz() {
        return this.kgv;
    }

    public ImageRequest cLC() {
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
        if (this.klm == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.E(this.klm)) {
            if (!this.klm.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.klm.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.klm.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.D(this.klm) && !this.klm.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
