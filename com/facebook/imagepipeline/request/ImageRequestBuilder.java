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
    private com.facebook.imagepipeline.g.b kht;
    private Uri kmk = null;
    private ImageRequest.RequestLevel kkl = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c kfL = null;
    @Nullable
    private com.facebook.imagepipeline.common.d kfM = null;
    private com.facebook.imagepipeline.common.a kfN = com.facebook.imagepipeline.common.a.cFM();
    private ImageRequest.CacheChoice kmj = ImageRequest.CacheChoice.DEFAULT;
    private boolean khY = h.cGl().cGF();
    private boolean kmo = false;
    private Priority kmp = Priority.HIGH;
    @Nullable
    private b klD = null;
    private boolean kmr = true;
    @Nullable
    private a kmm = null;

    public static ImageRequestBuilder R(Uri uri) {
        return new ImageRequestBuilder().S(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder S(Uri uri) {
        g.checkNotNull(uri);
        this.kmk = uri;
        return this;
    }

    public Uri cJs() {
        return this.kmk;
    }

    @Nullable
    public a cJu() {
        return this.kmm;
    }

    public ImageRequest.RequestLevel cIH() {
        return this.kkl;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.c cVar) {
        this.kfL = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c cJv() {
        return this.kfL;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.kfM = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d cJw() {
        return this.kfM;
    }

    public com.facebook.imagepipeline.common.a cJx() {
        return this.kfN;
    }

    public ImageRequest.CacheChoice cJr() {
        return this.kmj;
    }

    public boolean cGF() {
        return this.khY;
    }

    public boolean cJE() {
        return this.kmo;
    }

    public boolean cJA() {
        return this.kmr && com.facebook.common.util.d.v(this.kmk);
    }

    public Priority cJF() {
        return this.kmp;
    }

    @Nullable
    public b cJC() {
        return this.klD;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b cJD() {
        return this.kht;
    }

    public ImageRequest cJG() {
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
        if (this.kmk == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.B(this.kmk)) {
            if (!this.kmk.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.kmk.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.kmk.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.A(this.kmk) && !this.kmk.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
