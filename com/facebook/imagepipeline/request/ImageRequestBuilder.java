package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.h.c lNu;
    private Uri lSD = null;
    private ImageRequest.RequestLevel lQC = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private d lMb = null;
    @Nullable
    private e lMc = null;
    private com.facebook.imagepipeline.common.b lMd = com.facebook.imagepipeline.common.b.dlQ();
    private ImageRequest.CacheChoice lSC = ImageRequest.CacheChoice.DEFAULT;
    private boolean lOd = h.dmr().dmL();
    private boolean lSG = false;
    private Priority lSH = Priority.HIGH;
    @Nullable
    private a lRV = null;
    private boolean lNY = true;
    private boolean lSL = true;
    @Nullable
    private com.facebook.imagepipeline.common.a lPv = null;
    private Map<String, String> lSJ = null;
    private String mTag = null;
    private String lSK = null;

    public static ImageRequestBuilder X(Uri uri) {
        return new ImageRequestBuilder().Y(uri);
    }

    public static ImageRequestBuilder IC(int i) {
        return X(com.facebook.common.util.d.Hl(i));
    }

    public static ImageRequestBuilder p(ImageRequest imageRequest) {
        return X(imageRequest.dpN()).a(imageRequest.dpR()).d(imageRequest.doe()).a(imageRequest.dpM()).vg(imageRequest.dpT()).a(imageRequest.doZ()).a(imageRequest.dpW()).vf(imageRequest.dpS()).b(imageRequest.dpb()).c(imageRequest.dpP()).c(imageRequest.djm()).a(imageRequest.dpQ()).c(imageRequest.djm()).z(imageRequest.dpo()).OK(imageRequest.mTag).OL(imageRequest.lSK);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dpo() {
        return this.lSJ;
    }

    public ImageRequestBuilder z(Map<String, String> map) {
        this.lSJ = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder OK(String str) {
        this.mTag = str;
        return this;
    }

    public String akR() {
        return this.lSK;
    }

    public ImageRequestBuilder OL(String str) {
        this.lSK = str;
        return this;
    }

    public ImageRequestBuilder Y(Uri uri) {
        g.checkNotNull(uri);
        this.lSD = uri;
        return this;
    }

    public Uri dpN() {
        return this.lSD;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.lQC = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel doZ() {
        return this.lQC;
    }

    public ImageRequestBuilder c(@Nullable d dVar) {
        this.lMb = dVar;
        return this;
    }

    @Nullable
    public d dpP() {
        return this.lMb;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.lMc = eVar;
        return this;
    }

    @Nullable
    public e dpQ() {
        return this.lMc;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lPv = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a doe() {
        return this.lPv;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.lMd = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dpR() {
        return this.lMd;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.lSC = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dpM() {
        return this.lSC;
    }

    public ImageRequestBuilder vf(boolean z) {
        this.lOd = z;
        return this;
    }

    public boolean dmL() {
        return this.lOd;
    }

    public ImageRequestBuilder vg(boolean z) {
        this.lSG = z;
        return this;
    }

    public boolean dpX() {
        return this.lSG;
    }

    public boolean dmu() {
        return this.lNY && com.facebook.common.util.d.B(this.lSD);
    }

    public boolean dpU() {
        return this.lSL;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.lSH = priority;
        return this;
    }

    public Priority dpY() {
        return this.lSH;
    }

    public ImageRequestBuilder a(a aVar) {
        this.lRV = aVar;
        return this;
    }

    @Nullable
    public a dpW() {
        return this.lRV;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.lNu = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c djm() {
        return this.lNu;
    }

    public ImageRequest dpZ() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes9.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.lSD == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.F(this.lSD)) {
            if (!this.lSD.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.lSD.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.lSD.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.E(this.lSD) && !this.lSD.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
