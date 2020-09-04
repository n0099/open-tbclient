package tv.chushou.zues.widget.fresco;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.facebook.drawee.controller.c;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.g.f;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.flexbox.FlexboxLayout;
import tv.chushou.zues.b;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class FrescoThumbnailView extends SimpleDraweeView {
    private boolean oOB;
    private boolean oOC;
    private boolean oOD;
    private boolean oOE;
    private boolean oOF;
    private c<f> oOG;
    private c<f> oOH;
    private c<f> oOI;
    private a oOJ;

    /* loaded from: classes6.dex */
    public interface a {
        void dT(int i, int i2);
    }

    public FrescoThumbnailView(Context context) {
        super(context);
        this.oOB = false;
        this.oOC = false;
        this.oOD = false;
        this.oOE = false;
        this.oOF = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oOB = false;
        this.oOC = false;
        this.oOD = false;
        this.oOE = false;
        this.oOF = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oOB = false;
        this.oOC = false;
        this.oOD = false;
        this.oOE = false;
        this.oOF = false;
    }

    public void Ck(int i) {
        a((String) null, (String) null, i, 0, 0, 0);
    }

    public void bX(String str, int i) {
        a((String) null, str, i, 0, 0, 0);
    }

    public void h(String str, int i, int i2, int i3) {
        a((String) null, str, i, i2, i3, 0);
    }

    public void i(String str, int i, int i2, int i3) {
        a(str, i, i2, i3, 0);
    }

    public void a(String str, int i, int i2, int i3, int i4) {
        a(str, i, i2, i3, i4, (a) null);
    }

    public void a(String str, int i, int i2, int i3, int i4, a aVar) {
        Object tag = getTag(b.e.zues_fresco_url_tag);
        boolean z = false;
        if (tag != null && tag.equals(str)) {
            z = true;
        }
        this.oOJ = aVar;
        if (!z) {
            a((String) null, str, i, i2, i3, i4);
            setTag(b.e.zues_fresco_url_tag, str);
        }
    }

    public void setGray(boolean z) {
        this.oOB = z;
    }

    public void setBlur(boolean z) {
        this.oOC = z;
    }

    public void setAutoRotated(boolean z) {
        this.oOE = z;
    }

    public void setAnim(boolean z) {
        this.oOD = z;
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        getHierarchy().a(RoundingParams.i(f, f2, f3, f4));
    }

    public void setCircle(int i) {
        getHierarchy().a(RoundingParams.dRc().a(RoundingParams.RoundingMethod.OVERLAY_COLOR).Lq(i));
    }

    public void setBorderColor(@ColorInt int i, int i2) {
        getHierarchy().dQG().o(i, i2);
    }

    public void setRoundAsCircle(boolean z) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.yb(z);
        getHierarchy().a(roundingParams);
    }

    public void setProgressBarDrawable(Drawable drawable) {
        getHierarchy().e(drawable, p.b.npG);
    }

    public void setFailureImage(Drawable drawable) {
        getHierarchy().c(drawable, p.b.npG);
    }

    public void setRetryImage(Drawable drawable) {
        this.oOF = true;
        getHierarchy().d(drawable, p.b.npG);
    }

    private void a(String str, String str2, int i, int i2, int i3, int i4) {
        if (i > 0) {
            try {
                getHierarchy().Lm(i);
            } catch (Throwable th) {
                return;
            }
        }
        Uri parse = !h.isEmpty(str2) ? Uri.parse(str2) : null;
        if (parse == null) {
            if (i > 0) {
                an(i, i2, i3);
                return;
            }
            return;
        }
        a(str != null ? Uri.parse(str) : null, parse, i2, i3, i4);
    }

    private void an(int i, int i2, int i3) {
        tv.chushou.zues.widget.fresco.a.b bVar;
        boolean z = false;
        if (i > 0) {
            if (this.oOB) {
                bVar = tv.chushou.zues.widget.fresco.a.b.emK();
            } else if (!this.oOC) {
                bVar = null;
            } else {
                bVar = tv.chushou.zues.widget.fresco.a.a.emJ();
            }
            if (this.oOD) {
                RoundingParams dQG = getHierarchy().dQG();
                if (dQG != null) {
                    if (!dQG.dQX()) {
                        float[] dQY = dQG.dQY();
                        if (dQY != null && dQY.length > 0) {
                            int length = dQY.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dQY[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.Mt(i).yk(true).a(this.oOE ? e.dSy() : e.dSz());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i2 > 0 && i3 > 0) {
                a2.c(new d(i2, i3));
            }
            setController(com.facebook.drawee.a.a.c.dPw().be(a2.dWA()).xW(z).c(getController()).dQn());
        }
    }

    private void a(Uri uri, Uri uri2, int i, int i2, int i3) {
        boolean z = false;
        if (uri2 != null) {
            com.facebook.imagepipeline.request.b bVar = null;
            if (this.oOB) {
                bVar = tv.chushou.zues.widget.fresco.a.b.emK();
            } else if (this.oOC) {
                bVar = tv.chushou.zues.widget.fresco.a.a.emJ();
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.ab(uri2).yk(true).a(this.oOE ? e.dSy() : e.dSz());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i > 0 && i2 > 0) {
                a2.c(new d(i, i2));
            }
            if (this.oOD) {
                RoundingParams dQG = getHierarchy().dQG();
                if (dQG != null) {
                    if (!dQG.dQX()) {
                        float[] dQY = dQG.dQY();
                        if (dQY != null && dQY.length > 0) {
                            int length = dQY.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dQY[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            com.facebook.drawee.a.a.e b = com.facebook.drawee.a.a.c.dPw().be(a2.dWA()).xV(this.oOF).xW(z).c(getController());
            if (i3 != 0) {
                b.c(ON(i3));
            }
            if (ImageRequest.Z(uri) != null) {
                b.bf(ImageRequest.Z(uri));
            }
            setController(b.dQn());
        }
    }

    private c<f> ON(int i) {
        if (i == 1) {
            if (this.oOG == null) {
                this.oOG = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str, f fVar, Animatable animatable) {
                        super.a(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getHeight() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.width = (layoutParams.height * width) / height;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                            if (FrescoThumbnailView.this.oOJ != null) {
                                FrescoThumbnailView.this.oOJ.dT(width, height);
                            }
                        }
                    }
                };
            }
            return this.oOG;
        } else if (i == 2) {
            if (this.oOH == null) {
                this.oOH = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str, f fVar, Animatable animatable) {
                        super.a(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getWidth() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            if (FrescoThumbnailView.this.oOJ != null) {
                                FrescoThumbnailView.this.oOJ.dT(width, height);
                            }
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.height = (height * layoutParams.width) / width;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                        }
                    }
                };
            }
            return this.oOH;
        } else if (i == 3) {
            if (this.oOI == null) {
                this.oOI = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str, f fVar, Animatable animatable) {
                        super.a(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getHeight() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.width = (layoutParams.height * width) / height;
                            if (layoutParams instanceof FlexboxLayout.LayoutParams) {
                                ((FlexboxLayout.LayoutParams) layoutParams).setMinWidth(layoutParams.width);
                            }
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                            if (FrescoThumbnailView.this.oOJ != null) {
                                FrescoThumbnailView.this.oOJ.dT(width, height);
                            }
                        }
                    }
                };
            }
            return this.oOI;
        } else {
            return null;
        }
    }
}
