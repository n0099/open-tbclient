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
    private com.facebook.imagepipeline.g.b jHl;
    private Uri jMb = null;
    private ImageRequest.RequestLevel jKc = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c jFF = null;
    @Nullable
    private com.facebook.imagepipeline.common.d jFG = null;
    private com.facebook.imagepipeline.common.a jFH = com.facebook.imagepipeline.common.a.cwM();
    private ImageRequest.CacheChoice jMa = ImageRequest.CacheChoice.DEFAULT;
    private boolean jHQ = h.cxl().cxF();
    private boolean jMf = false;
    private Priority jMg = Priority.HIGH;
    @Nullable
    private b jLu = null;
    private boolean jMi = true;
    @Nullable
    private a jMd = null;

    public static ImageRequestBuilder O(Uri uri) {
        return new ImageRequestBuilder().P(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder P(Uri uri) {
        g.checkNotNull(uri);
        this.jMb = uri;
        return this;
    }

    public Uri cAr() {
        return this.jMb;
    }

    @Nullable
    public a cAt() {
        return this.jMd;
    }

    public ImageRequest.RequestLevel czG() {
        return this.jKc;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cAu() {
        return this.jFF;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.jFG = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cAv() {
        return this.jFG;
    }

    public com.facebook.imagepipeline.common.a cAw() {
        return this.jFH;
    }

    public ImageRequest.CacheChoice cAq() {
        return this.jMa;
    }

    public boolean cxF() {
        return this.jHQ;
    }

    public boolean cAD() {
        return this.jMf;
    }

    public boolean cAz() {
        return this.jMi && com.facebook.common.util.d.s(this.jMb);
    }

    public Priority cAE() {
        return this.jMg;
    }

    @Nullable
    public b cAB() {
        return this.jLu;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cAC() {
        return this.jHl;
    }

    public ImageRequest cAF() {
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
        if (this.jMb == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.y(this.jMb)) {
            if (!this.jMb.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.jMb.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.jMb.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.x(this.jMb) && !this.jMb.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
