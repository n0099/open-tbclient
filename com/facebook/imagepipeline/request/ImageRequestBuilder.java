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
    private com.facebook.imagepipeline.g.b kjZ;
    private Uri koP = null;
    private ImageRequest.RequestLevel kmQ = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c kis = null;
    @Nullable
    private com.facebook.imagepipeline.common.d kit = null;
    private com.facebook.imagepipeline.common.a kiu = com.facebook.imagepipeline.common.a.cIR();
    private ImageRequest.CacheChoice koO = ImageRequest.CacheChoice.DEFAULT;
    private boolean kkE = h.cJq().cJK();
    private boolean koT = false;
    private Priority koU = Priority.HIGH;
    @Nullable
    private b koi = null;
    private boolean koW = true;
    @Nullable
    private a koR = null;

    public static ImageRequestBuilder U(Uri uri) {
        return new ImageRequestBuilder().V(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder V(Uri uri) {
        g.checkNotNull(uri);
        this.koP = uri;
        return this;
    }

    public Uri cMx() {
        return this.koP;
    }

    @Nullable
    public a cMz() {
        return this.koR;
    }

    public ImageRequest.RequestLevel cLM() {
        return this.kmQ;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.c cVar) {
        this.kis = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cMA() {
        return this.kis;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.kit = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cMB() {
        return this.kit;
    }

    public com.facebook.imagepipeline.common.a cMC() {
        return this.kiu;
    }

    public ImageRequest.CacheChoice cMw() {
        return this.koO;
    }

    public boolean cJK() {
        return this.kkE;
    }

    public boolean cMJ() {
        return this.koT;
    }

    public boolean cMF() {
        return this.koW && com.facebook.common.util.d.y(this.koP);
    }

    public Priority cMK() {
        return this.koU;
    }

    @Nullable
    public b cMH() {
        return this.koi;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cMI() {
        return this.kjZ;
    }

    public ImageRequest cML() {
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
        if (this.koP == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.E(this.koP)) {
            if (!this.koP.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.koP.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.koP.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.D(this.koP) && !this.koP.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
