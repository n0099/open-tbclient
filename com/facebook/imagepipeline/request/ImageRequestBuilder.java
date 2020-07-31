package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.h.c naM;
    private Uri nfZ = null;
    private ImageRequest.RequestLevel ndW = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d mZs = null;
    @Nullable
    private e mZt = null;
    private com.facebook.imagepipeline.common.b mZu = com.facebook.imagepipeline.common.b.dGf();
    private ImageRequest.CacheChoice nfY = ImageRequest.CacheChoice.DEFAULT;
    private boolean nbv = h.dGG().dHa();
    private boolean ngb = false;
    private Priority ngc = Priority.HIGH;
    @Nullable
    private b nfq = null;
    private boolean nbq = true;
    private boolean ngg = true;
    @Nullable
    private com.facebook.imagepipeline.common.a ncN = null;
    private Map<String, String> nge = null;
    private String mTag = null;
    private String ngf = null;

    public static ImageRequestBuilder ab(Uri uri) {
        return new ImageRequestBuilder().ac(uri);
    }

    public static ImageRequestBuilder JP(int i) {
        return ab(com.facebook.common.util.d.Is(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ab(imageRequest.dKg()).a(imageRequest.dKk()).d(imageRequest.dIs()).a(imageRequest.dKf()).xr(imageRequest.dKm()).a(imageRequest.dJq()).a(imageRequest.dKo()).xq(imageRequest.dKl()).b(imageRequest.dJs()).c(imageRequest.dKi()).c(imageRequest.dDs()).a(imageRequest.dKj()).c(imageRequest.dDs()).y(imageRequest.dJF()).RH(imageRequest.mTag).RI(imageRequest.ngf);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dJF() {
        return this.nge;
    }

    public ImageRequestBuilder y(Map<String, String> map) {
        this.nge = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder RH(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.ngf;
    }

    public ImageRequestBuilder RI(String str) {
        this.ngf = str;
        return this;
    }

    public ImageRequestBuilder ac(Uri uri) {
        g.checkNotNull(uri);
        this.nfZ = uri;
        return this;
    }

    public Uri dKg() {
        return this.nfZ;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.ndW = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dJq() {
        return this.ndW;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.mZs = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dKi() {
        return this.mZs;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.mZt = eVar;
        return this;
    }

    @Nullable
    public e dKj() {
        return this.mZt;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.ncN = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dIs() {
        return this.ncN;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.mZu = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dKk() {
        return this.mZu;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.nfY = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dKf() {
        return this.nfY;
    }

    public ImageRequestBuilder xq(boolean z) {
        this.nbv = z;
        return this;
    }

    public boolean dHa() {
        return this.nbv;
    }

    public ImageRequestBuilder xr(boolean z) {
        this.ngb = z;
        return this;
    }

    public boolean dKp() {
        return this.ngb;
    }

    public boolean dGJ() {
        return this.nbq && com.facebook.common.util.d.I(this.nfZ);
    }

    public boolean dKn() {
        return this.ngg;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.ngc = priority;
        return this;
    }

    public Priority dKq() {
        return this.ngc;
    }

    public ImageRequestBuilder a(b bVar) {
        this.nfq = bVar;
        return this;
    }

    @Nullable
    public b dKo() {
        return this.nfq;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.naM = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dDs() {
        return this.naM;
    }

    public ImageRequest dKr() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes4.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.nfZ == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.M(this.nfZ)) {
            if (!this.nfZ.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.nfZ.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.nfZ.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.L(this.nfZ) && !this.nfZ.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
