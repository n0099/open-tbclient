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
    private com.facebook.imagepipeline.g.b iqe;
    private Uri iuQ = null;
    private ImageRequest.RequestLevel isT = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c ioy = null;
    @Nullable
    private com.facebook.imagepipeline.common.d ioz = null;
    private com.facebook.imagepipeline.common.a ioA = com.facebook.imagepipeline.common.a.bWT();
    private ImageRequest.CacheChoice iuP = ImageRequest.CacheChoice.DEFAULT;
    private boolean iqJ = h.bXs().bXM();
    private boolean iuU = false;
    private Priority iuV = Priority.HIGH;
    @Nullable
    private b iuk = null;
    private boolean iuX = true;
    @Nullable
    private a iuS = null;

    public static ImageRequestBuilder G(Uri uri) {
        return new ImageRequestBuilder().H(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder H(Uri uri) {
        g.checkNotNull(uri);
        this.iuQ = uri;
        return this;
    }

    public Uri cau() {
        return this.iuQ;
    }

    @Nullable
    public a caw() {
        return this.iuS;
    }

    public ImageRequest.RequestLevel bZJ() {
        return this.isT;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cax() {
        return this.ioy;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.ioz = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cay() {
        return this.ioz;
    }

    public com.facebook.imagepipeline.common.a caz() {
        return this.ioA;
    }

    public ImageRequest.CacheChoice cat() {
        return this.iuP;
    }

    public boolean bXM() {
        return this.iqJ;
    }

    public boolean caG() {
        return this.iuU;
    }

    public boolean caC() {
        return this.iuX && com.facebook.common.util.d.k(this.iuQ);
    }

    public Priority caH() {
        return this.iuV;
    }

    @Nullable
    public b caE() {
        return this.iuk;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b caF() {
        return this.iqe;
    }

    public ImageRequest caI() {
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
        if (this.iuQ == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.q(this.iuQ)) {
            if (!this.iuQ.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.iuQ.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.iuQ.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.p(this.iuQ) && !this.iuQ.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
