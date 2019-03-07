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
    private com.facebook.imagepipeline.g.b jGS;
    private Uri jLI = null;
    private ImageRequest.RequestLevel jJJ = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c jFm = null;
    @Nullable
    private com.facebook.imagepipeline.common.d jFn = null;
    private com.facebook.imagepipeline.common.a jFo = com.facebook.imagepipeline.common.a.cwC();
    private ImageRequest.CacheChoice jLH = ImageRequest.CacheChoice.DEFAULT;
    private boolean jHx = h.cxb().cxv();
    private boolean jLM = false;
    private Priority jLN = Priority.HIGH;
    @Nullable
    private b jLb = null;
    private boolean jLP = true;
    @Nullable
    private a jLK = null;

    public static ImageRequestBuilder O(Uri uri) {
        return new ImageRequestBuilder().P(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder P(Uri uri) {
        g.checkNotNull(uri);
        this.jLI = uri;
        return this;
    }

    public Uri cAh() {
        return this.jLI;
    }

    @Nullable
    public a cAj() {
        return this.jLK;
    }

    public ImageRequest.RequestLevel czw() {
        return this.jJJ;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cAk() {
        return this.jFm;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.jFn = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cAl() {
        return this.jFn;
    }

    public com.facebook.imagepipeline.common.a cAm() {
        return this.jFo;
    }

    public ImageRequest.CacheChoice cAg() {
        return this.jLH;
    }

    public boolean cxv() {
        return this.jHx;
    }

    public boolean cAt() {
        return this.jLM;
    }

    public boolean cAp() {
        return this.jLP && com.facebook.common.util.d.s(this.jLI);
    }

    public Priority cAu() {
        return this.jLN;
    }

    @Nullable
    public b cAr() {
        return this.jLb;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cAs() {
        return this.jGS;
    }

    public ImageRequest cAv() {
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
        if (this.jLI == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.y(this.jLI)) {
            if (!this.jLI.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.jLI.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.jLI.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.x(this.jLI) && !this.jLI.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
