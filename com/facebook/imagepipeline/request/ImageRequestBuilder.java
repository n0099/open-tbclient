package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.h.c lTL;
    private Uri lYX = null;
    private ImageRequest.RequestLevel lWV = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d lSr = null;
    @Nullable
    private e lSs = null;
    private com.facebook.imagepipeline.common.b lSt = com.facebook.imagepipeline.common.b.doK();
    private ImageRequest.CacheChoice lYW = ImageRequest.CacheChoice.DEFAULT;
    private boolean lUu = h.dpm().dpG();
    private boolean lZa = false;
    private Priority lZb = Priority.HIGH;
    @Nullable
    private b lYo = null;
    private boolean lUp = true;
    private boolean lZf = true;
    @Nullable
    private com.facebook.imagepipeline.common.a lVM = null;
    private Map<String, String> lZd = null;
    private String mTag = null;
    private String lZe = null;

    public static ImageRequestBuilder Y(Uri uri) {
        return new ImageRequestBuilder().Z(uri);
    }

    public static ImageRequestBuilder IW(int i) {
        return Y(com.facebook.common.util.d.HB(i));
    }

    public static ImageRequestBuilder p(ImageRequest imageRequest) {
        return Y(imageRequest.dsO()).a(imageRequest.dsS()).d(imageRequest.dqY()).a(imageRequest.dsN()).vD(imageRequest.dsU()).a(imageRequest.drX()).a(imageRequest.dsX()).vC(imageRequest.dsT()).b(imageRequest.drZ()).c(imageRequest.dsQ()).c(imageRequest.dmc()).a(imageRequest.dsR()).c(imageRequest.dmc()).z(imageRequest.dsm()).Pi(imageRequest.mTag).Pj(imageRequest.lZe);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dsm() {
        return this.lZd;
    }

    public ImageRequestBuilder z(Map<String, String> map) {
        this.lZd = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Pi(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.lZe;
    }

    public ImageRequestBuilder Pj(String str) {
        this.lZe = str;
        return this;
    }

    public ImageRequestBuilder Z(Uri uri) {
        g.checkNotNull(uri);
        this.lYX = uri;
        return this;
    }

    public Uri dsO() {
        return this.lYX;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.lWV = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel drX() {
        return this.lWV;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.lSr = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dsQ() {
        return this.lSr;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.lSs = eVar;
        return this;
    }

    @Nullable
    public e dsR() {
        return this.lSs;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lVM = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqY() {
        return this.lVM;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.lSt = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dsS() {
        return this.lSt;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.lYW = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dsN() {
        return this.lYW;
    }

    public ImageRequestBuilder vC(boolean z) {
        this.lUu = z;
        return this;
    }

    public boolean dpG() {
        return this.lUu;
    }

    public ImageRequestBuilder vD(boolean z) {
        this.lZa = z;
        return this;
    }

    public boolean dsY() {
        return this.lZa;
    }

    public boolean dpp() {
        return this.lUp && com.facebook.common.util.d.C(this.lYX);
    }

    public boolean dsV() {
        return this.lZf;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.lZb = priority;
        return this;
    }

    public Priority dsZ() {
        return this.lZb;
    }

    public ImageRequestBuilder a(b bVar) {
        this.lYo = bVar;
        return this;
    }

    @Nullable
    public b dsX() {
        return this.lYo;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.lTL = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dmc() {
        return this.lTL;
    }

    public ImageRequest dta() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes12.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.lYX == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.G(this.lYX)) {
            if (!this.lYX.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.lYX.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.lYX.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.F(this.lYX) && !this.lYX.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
