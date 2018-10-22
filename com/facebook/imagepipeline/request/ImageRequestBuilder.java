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
    private com.facebook.imagepipeline.g.b idY;
    private Uri iiK = null;
    private ImageRequest.RequestLevel igN = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c icp = null;
    @Nullable
    private com.facebook.imagepipeline.common.d icq = null;
    private com.facebook.imagepipeline.common.a icr = com.facebook.imagepipeline.common.a.bUC();
    private ImageRequest.CacheChoice iiJ = ImageRequest.CacheChoice.DEFAULT;
    private boolean ieD = h.bVb().bVv();
    private boolean iiO = false;
    private Priority iiP = Priority.HIGH;
    @Nullable
    private b iie = null;
    private boolean iiR = true;
    @Nullable
    private a iiM = null;

    public static ImageRequestBuilder F(Uri uri) {
        return new ImageRequestBuilder().G(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder G(Uri uri) {
        g.checkNotNull(uri);
        this.iiK = uri;
        return this;
    }

    public Uri bYd() {
        return this.iiK;
    }

    @Nullable
    public a bYf() {
        return this.iiM;
    }

    public ImageRequest.RequestLevel bXs() {
        return this.igN;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c bYg() {
        return this.icp;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.icq = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d bYh() {
        return this.icq;
    }

    public com.facebook.imagepipeline.common.a bYi() {
        return this.icr;
    }

    public ImageRequest.CacheChoice bYc() {
        return this.iiJ;
    }

    public boolean bVv() {
        return this.ieD;
    }

    public boolean bYp() {
        return this.iiO;
    }

    public boolean bYl() {
        return this.iiR && com.facebook.common.util.d.j(this.iiK);
    }

    public Priority bYq() {
        return this.iiP;
    }

    @Nullable
    public b bYn() {
        return this.iie;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b bYo() {
        return this.idY;
    }

    public ImageRequest bYr() {
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
        if (this.iiK == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.p(this.iiK)) {
            if (!this.iiK.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.iiK.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.iiK.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.o(this.iiK) && !this.iiK.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
