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
    private com.facebook.imagepipeline.h.c naO;
    private Uri ngb = null;
    private ImageRequest.RequestLevel ndY = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d mZu = null;
    @Nullable
    private e mZv = null;
    private com.facebook.imagepipeline.common.b mZw = com.facebook.imagepipeline.common.b.dGg();
    private ImageRequest.CacheChoice nga = ImageRequest.CacheChoice.DEFAULT;
    private boolean nbx = h.dGH().dHb();
    private boolean ngd = false;
    private Priority nge = Priority.HIGH;
    @Nullable
    private b nfs = null;
    private boolean nbs = true;
    private boolean ngi = true;
    @Nullable
    private com.facebook.imagepipeline.common.a ncP = null;
    private Map<String, String> ngg = null;
    private String mTag = null;
    private String ngh = null;

    public static ImageRequestBuilder ab(Uri uri) {
        return new ImageRequestBuilder().ac(uri);
    }

    public static ImageRequestBuilder JP(int i) {
        return ab(com.facebook.common.util.d.Is(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ab(imageRequest.dKh()).a(imageRequest.dKl()).d(imageRequest.dIt()).a(imageRequest.dKg()).xr(imageRequest.dKn()).a(imageRequest.dJr()).a(imageRequest.dKp()).xq(imageRequest.dKm()).b(imageRequest.dJt()).c(imageRequest.dKj()).c(imageRequest.dDt()).a(imageRequest.dKk()).c(imageRequest.dDt()).y(imageRequest.dJG()).RH(imageRequest.mTag).RI(imageRequest.ngh);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dJG() {
        return this.ngg;
    }

    public ImageRequestBuilder y(Map<String, String> map) {
        this.ngg = map;
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
        return this.ngh;
    }

    public ImageRequestBuilder RI(String str) {
        this.ngh = str;
        return this;
    }

    public ImageRequestBuilder ac(Uri uri) {
        g.checkNotNull(uri);
        this.ngb = uri;
        return this;
    }

    public Uri dKh() {
        return this.ngb;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.ndY = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dJr() {
        return this.ndY;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.mZu = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dKj() {
        return this.mZu;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.mZv = eVar;
        return this;
    }

    @Nullable
    public e dKk() {
        return this.mZv;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.ncP = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dIt() {
        return this.ncP;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.mZw = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dKl() {
        return this.mZw;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.nga = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dKg() {
        return this.nga;
    }

    public ImageRequestBuilder xq(boolean z) {
        this.nbx = z;
        return this;
    }

    public boolean dHb() {
        return this.nbx;
    }

    public ImageRequestBuilder xr(boolean z) {
        this.ngd = z;
        return this;
    }

    public boolean dKq() {
        return this.ngd;
    }

    public boolean dGK() {
        return this.nbs && com.facebook.common.util.d.I(this.ngb);
    }

    public boolean dKo() {
        return this.ngi;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.nge = priority;
        return this;
    }

    public Priority dKr() {
        return this.nge;
    }

    public ImageRequestBuilder a(b bVar) {
        this.nfs = bVar;
        return this;
    }

    @Nullable
    public b dKp() {
        return this.nfs;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.naO = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dDt() {
        return this.naO;
    }

    public ImageRequest dKs() {
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
        if (this.ngb == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.M(this.ngb)) {
            if (!this.ngb.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.ngb.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.ngb.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.L(this.ngb) && !this.ngb.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
