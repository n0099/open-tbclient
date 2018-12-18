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
    private com.facebook.imagepipeline.g.b imT;
    private Uri irG = null;
    private ImageRequest.RequestLevel ipJ = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c ilm = null;
    @Nullable
    private com.facebook.imagepipeline.common.d iln = null;
    private com.facebook.imagepipeline.common.a ilo = com.facebook.imagepipeline.common.a.bWc();
    private ImageRequest.CacheChoice irF = ImageRequest.CacheChoice.DEFAULT;
    private boolean inz = h.bWB().bWV();
    private boolean irK = false;
    private Priority irL = Priority.HIGH;
    @Nullable
    private b ira = null;
    private boolean irN = true;
    @Nullable
    private a irI = null;

    public static ImageRequestBuilder G(Uri uri) {
        return new ImageRequestBuilder().H(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder H(Uri uri) {
        g.checkNotNull(uri);
        this.irG = uri;
        return this;
    }

    public Uri bZD() {
        return this.irG;
    }

    @Nullable
    public a bZF() {
        return this.irI;
    }

    public ImageRequest.RequestLevel bYS() {
        return this.ipJ;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c bZG() {
        return this.ilm;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.iln = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d bZH() {
        return this.iln;
    }

    public com.facebook.imagepipeline.common.a bZI() {
        return this.ilo;
    }

    public ImageRequest.CacheChoice bZC() {
        return this.irF;
    }

    public boolean bWV() {
        return this.inz;
    }

    public boolean bZP() {
        return this.irK;
    }

    public boolean bZL() {
        return this.irN && com.facebook.common.util.d.k(this.irG);
    }

    public Priority bZQ() {
        return this.irL;
    }

    @Nullable
    public b bZN() {
        return this.ira;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b bZO() {
        return this.imT;
    }

    public ImageRequest bZR() {
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
        if (this.irG == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.q(this.irG)) {
            if (!this.irG.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.irG.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.irG.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.p(this.irG) && !this.irG.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
