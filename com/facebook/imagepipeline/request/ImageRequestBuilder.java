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
    private com.facebook.imagepipeline.g.b ifI;
    private Uri iku = null;
    private ImageRequest.RequestLevel iix = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.c iec = null;
    @Nullable
    private com.facebook.imagepipeline.common.d ied = null;
    private com.facebook.imagepipeline.common.a iee = com.facebook.imagepipeline.common.a.bTX();
    private ImageRequest.CacheChoice ikt = ImageRequest.CacheChoice.DEFAULT;
    private boolean ign = h.bUw().bUQ();
    private boolean iky = false;
    private Priority ikz = Priority.HIGH;
    @Nullable
    private b ijO = null;
    private boolean ikB = true;
    @Nullable
    private a ikw = null;

    public static ImageRequestBuilder F(Uri uri) {
        return new ImageRequestBuilder().G(uri);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder G(Uri uri) {
        g.checkNotNull(uri);
        this.iku = uri;
        return this;
    }

    public Uri bXy() {
        return this.iku;
    }

    @Nullable
    public a bXA() {
        return this.ikw;
    }

    public ImageRequest.RequestLevel bWN() {
        return this.iix;
    }

    @Nullable
    public com.facebook.imagepipeline.common.c bXB() {
        return this.iec;
    }

    public ImageRequestBuilder a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.ied = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d bXC() {
        return this.ied;
    }

    public com.facebook.imagepipeline.common.a bXD() {
        return this.iee;
    }

    public ImageRequest.CacheChoice bXx() {
        return this.ikt;
    }

    public boolean bUQ() {
        return this.ign;
    }

    public boolean bXK() {
        return this.iky;
    }

    public boolean bXG() {
        return this.ikB && com.facebook.common.util.d.j(this.iku);
    }

    public Priority bXL() {
        return this.ikz;
    }

    @Nullable
    public b bXI() {
        return this.ijO;
    }

    @Nullable
    public com.facebook.imagepipeline.g.b bXJ() {
        return this.ifI;
    }

    public ImageRequest bXM() {
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
        if (this.iku == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.p(this.iku)) {
            if (!this.iku.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.iku.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.iku.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.o(this.iku) && !this.iku.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
