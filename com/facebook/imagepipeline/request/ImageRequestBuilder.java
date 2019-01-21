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
    private com.facebook.imagepipeline.g.b irm;
    private Uri ivY = null;
    private ImageRequest.RequestLevel iub = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c ipG = null;
    @Nullable
    private com.facebook.imagepipeline.common.d ipH = null;
    private com.facebook.imagepipeline.common.a ipI = com.facebook.imagepipeline.common.a.bXB();
    private ImageRequest.CacheChoice ivX = ImageRequest.CacheChoice.DEFAULT;
    private boolean irR = h.bYa().bYu();
    private boolean iwc = false;
    private Priority iwd = Priority.HIGH;
    @Nullable
    private b ivs = null;
    private boolean iwf = true;
    @Nullable
    private a iwa = null;

    public static ImageRequestBuilder G(Uri uri) {
        return new ImageRequestBuilder().H(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder H(Uri uri) {
        g.checkNotNull(uri);
        this.ivY = uri;
        return this;
    }

    public Uri cbc() {
        return this.ivY;
    }

    @Nullable
    public a cbe() {
        return this.iwa;
    }

    public ImageRequest.RequestLevel car() {
        return this.iub;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cbf() {
        return this.ipG;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.ipH = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cbg() {
        return this.ipH;
    }

    public com.facebook.imagepipeline.common.a cbh() {
        return this.ipI;
    }

    public ImageRequest.CacheChoice cbb() {
        return this.ivX;
    }

    public boolean bYu() {
        return this.irR;
    }

    public boolean cbo() {
        return this.iwc;
    }

    public boolean cbk() {
        return this.iwf && com.facebook.common.util.d.k(this.ivY);
    }

    public Priority cbp() {
        return this.iwd;
    }

    @Nullable
    public b cbm() {
        return this.ivs;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cbn() {
        return this.irm;
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
        if (this.ivY == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.q(this.ivY)) {
            if (!this.ivY.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.ivY.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.ivY.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.p(this.ivY) && !this.ivY.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
