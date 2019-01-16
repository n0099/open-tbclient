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
    private com.facebook.imagepipeline.g.b irl;
    private Uri ivX = null;
    private ImageRequest.RequestLevel iua = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c ipF = null;
    @Nullable
    private com.facebook.imagepipeline.common.d ipG = null;
    private com.facebook.imagepipeline.common.a ipH = com.facebook.imagepipeline.common.a.bXB();
    private ImageRequest.CacheChoice ivW = ImageRequest.CacheChoice.DEFAULT;
    private boolean irQ = h.bYa().bYu();
    private boolean iwb = false;
    private Priority iwc = Priority.HIGH;
    @Nullable
    private b ivr = null;
    private boolean iwe = true;
    @Nullable
    private a ivZ = null;

    public static ImageRequestBuilder G(Uri uri) {
        return new ImageRequestBuilder().H(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder H(Uri uri) {
        g.checkNotNull(uri);
        this.ivX = uri;
        return this;
    }

    public Uri cbc() {
        return this.ivX;
    }

    @Nullable
    public a cbe() {
        return this.ivZ;
    }

    public ImageRequest.RequestLevel car() {
        return this.iua;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cbf() {
        return this.ipF;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.ipG = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cbg() {
        return this.ipG;
    }

    public com.facebook.imagepipeline.common.a cbh() {
        return this.ipH;
    }

    public ImageRequest.CacheChoice cbb() {
        return this.ivW;
    }

    public boolean bYu() {
        return this.irQ;
    }

    public boolean cbo() {
        return this.iwb;
    }

    public boolean cbk() {
        return this.iwe && com.facebook.common.util.d.k(this.ivX);
    }

    public Priority cbp() {
        return this.iwc;
    }

    @Nullable
    public b cbm() {
        return this.ivr;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cbn() {
        return this.irl;
    }

    public ImageRequest cbq() {
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
        if (this.ivX == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.q(this.ivX)) {
            if (!this.ivX.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.ivX.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.ivX.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.p(this.ivX) && !this.ivX.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
