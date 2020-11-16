package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.h.c oWA;
    private Uri pbM = null;
    private ImageRequest.RequestLevel oZI = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d oVg = null;
    @Nullable
    private e oVh = null;
    private com.facebook.imagepipeline.common.b oVi = com.facebook.imagepipeline.common.b.enJ();
    private ImageRequest.CacheChoice pbL = ImageRequest.CacheChoice.DEFAULT;
    private boolean oXj = h.eol().eoF();
    private boolean pbO = false;
    private Priority pbP = Priority.HIGH;
    @Nullable
    private b pbd = null;
    private boolean oXe = true;
    private boolean pbT = true;
    @Nullable
    private com.facebook.imagepipeline.common.a oYz = null;
    private Map<String, String> pbR = null;
    private String mTag = null;
    private String pbS = null;

    public static ImageRequestBuilder ae(Uri uri) {
        return new ImageRequestBuilder().af(uri);
    }

    public static ImageRequestBuilder Qt(int i) {
        return ae(com.facebook.common.util.d.OW(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ae(imageRequest.erL()).a(imageRequest.erP()).d(imageRequest.epX()).a(imageRequest.erK()).AA(imageRequest.erR()).a(imageRequest.eqV()).a(imageRequest.erT()).Az(imageRequest.erQ()).b(imageRequest.eqX()).c(imageRequest.erN()).c(imageRequest.ekW()).a(imageRequest.erO()).c(imageRequest.ekW()).I(imageRequest.erk()).Yd(imageRequest.mTag).Ye(imageRequest.pbS);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> erk() {
        return this.pbR;
    }

    public ImageRequestBuilder I(Map<String, String> map) {
        this.pbR = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Yd(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.pbS;
    }

    public ImageRequestBuilder Ye(String str) {
        this.pbS = str;
        return this;
    }

    public ImageRequestBuilder af(Uri uri) {
        g.checkNotNull(uri);
        this.pbM = uri;
        return this;
    }

    public Uri erL() {
        return this.pbM;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.oZI = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel eqV() {
        return this.oZI;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.oVg = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d erN() {
        return this.oVg;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.oVh = eVar;
        return this;
    }

    @Nullable
    public e erO() {
        return this.oVh;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.oYz = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a epX() {
        return this.oYz;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.oVi = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b erP() {
        return this.oVi;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.pbL = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice erK() {
        return this.pbL;
    }

    public ImageRequestBuilder Az(boolean z) {
        this.oXj = z;
        return this;
    }

    public boolean eoF() {
        return this.oXj;
    }

    public ImageRequestBuilder AA(boolean z) {
        this.pbO = z;
        return this;
    }

    public boolean erU() {
        return this.pbO;
    }

    public boolean eoo() {
        return this.oXe && com.facebook.common.util.d.L(this.pbM);
    }

    public boolean erS() {
        return this.pbT;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.pbP = priority;
        return this;
    }

    public Priority erV() {
        return this.pbP;
    }

    public ImageRequestBuilder a(b bVar) {
        this.pbd = bVar;
        return this;
    }

    @Nullable
    public b erT() {
        return this.pbd;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.oWA = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c ekW() {
        return this.oWA;
    }

    public ImageRequest erW() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes15.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.pbM == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.P(this.pbM)) {
            if (!this.pbM.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.pbM.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.pbM.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.O(this.pbM) && !this.pbM.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}
