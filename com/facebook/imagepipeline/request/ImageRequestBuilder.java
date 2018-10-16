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
    private com.facebook.imagepipeline.g.b idX;
    private Uri iiJ = null;
    private ImageRequest.RequestLevel igM = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c ico = null;
    @Nullable
    private com.facebook.imagepipeline.common.d icp = null;
    private com.facebook.imagepipeline.common.a icq = com.facebook.imagepipeline.common.a.bUC();
    private ImageRequest.CacheChoice iiI = ImageRequest.CacheChoice.DEFAULT;
    private boolean ieC = h.bVb().bVv();
    private boolean iiN = false;
    private Priority iiO = Priority.HIGH;
    @Nullable
    private b iid = null;
    private boolean iiQ = true;
    @Nullable
    private a iiL = null;

    public static ImageRequestBuilder F(Uri uri) {
        return new ImageRequestBuilder().G(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder G(Uri uri) {
        g.checkNotNull(uri);
        this.iiJ = uri;
        return this;
    }

    public Uri bYd() {
        return this.iiJ;
    }

    @Nullable
    public a bYf() {
        return this.iiL;
    }

    public ImageRequest.RequestLevel bXs() {
        return this.igM;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c bYg() {
        return this.ico;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.icp = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d bYh() {
        return this.icp;
    }

    public com.facebook.imagepipeline.common.a bYi() {
        return this.icq;
    }

    public ImageRequest.CacheChoice bYc() {
        return this.iiI;
    }

    public boolean bVv() {
        return this.ieC;
    }

    public boolean bYp() {
        return this.iiN;
    }

    public boolean bYl() {
        return this.iiQ && com.facebook.common.util.d.j(this.iiJ);
    }

    public Priority bYq() {
        return this.iiO;
    }

    @Nullable
    public b bYn() {
        return this.iid;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b bYo() {
        return this.idX;
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
        if (this.iiJ == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.p(this.iiJ)) {
            if (!this.iiJ.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.iiJ.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.iiJ.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.o(this.iiJ) && !this.iiJ.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
