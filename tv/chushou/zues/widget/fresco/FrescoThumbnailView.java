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
    private boolean oYd;
    private boolean oYe;
    private boolean oYf;
    private boolean oYg;
    private boolean oYh;
    private c<f> oYi;
    private c<f> oYj;
    private c<f> oYk;
    private a oYl;

    /* loaded from: classes6.dex */
    public interface a {
        void dX(int i, int i2);
    }

    public FrescoThumbnailView(Context context) {
        super(context);
        this.oYd = false;
        this.oYe = false;
        this.oYf = false;
        this.oYg = false;
        this.oYh = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oYd = false;
        this.oYe = false;
        this.oYf = false;
        this.oYg = false;
        this.oYh = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oYd = false;
        this.oYe = false;
        this.oYf = false;
        this.oYg = false;
        this.oYh = false;
    }

    public void CL(int i) {
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
        this.oYl = aVar;
        if (!z) {
            a((String) null, str, i, i2, i3, i4);
            setTag(b.e.zues_fresco_url_tag, str);
        }
    }

    public void setGray(boolean z) {
        this.oYd = z;
    }

    public void setBlur(boolean z) {
        this.oYe = z;
    }

    public void setAutoRotated(boolean z) {
        this.oYg = z;
    }

    public void setAnim(boolean z) {
        this.oYf = z;
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        getHierarchy().a(RoundingParams.i(f, f2, f3, f4));
    }

    public void setCircle(int i) {
        getHierarchy().a(RoundingParams.dVa().a(RoundingParams.RoundingMethod.OVERLAY_COLOR).LV(i));
    }

    public void setBorderColor(@ColorInt int i, int i2) {
        getHierarchy().dUE().o(i, i2);
    }

    public void setRoundAsCircle(boolean z) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.yk(z);
        getHierarchy().a(roundingParams);
    }

    public void setProgressBarDrawable(Drawable drawable) {
        getHierarchy().e(drawable, p.b.nzE);
    }

    public void setFailureImage(Drawable drawable) {
        getHierarchy().c(drawable, p.b.nzE);
    }

    public void setRetryImage(Drawable drawable) {
        this.oYh = true;
        getHierarchy().d(drawable, p.b.nzE);
    }

    private void a(String str, String str2, int i, int i2, int i3, int i4) {
        if (i > 0) {
            try {
                getHierarchy().LR(i);
            } catch (Throwable th) {
                return;
            }
        }
        Uri parse = !h.isEmpty(str2) ? Uri.parse(str2) : null;
        if (parse == null) {
            if (i > 0) {
                aq(i, i2, i3);
                return;
            }
            return;
        }
        a(str != null ? Uri.parse(str) : null, parse, i2, i3, i4);
    }

    private void aq(int i, int i2, int i3) {
        tv.chushou.zues.widget.fresco.a.b bVar;
        boolean z = false;
        if (i > 0) {
            if (this.oYd) {
                bVar = tv.chushou.zues.widget.fresco.a.b.eqI();
            } else if (!this.oYe) {
                bVar = null;
            } else {
                bVar = tv.chushou.zues.widget.fresco.a.a.eqH();
            }
            if (this.oYf) {
                RoundingParams dUE = getHierarchy().dUE();
                if (dUE != null) {
                    if (!dUE.dUV()) {
                        float[] dUW = dUE.dUW();
                        if (dUW != null && dUW.length > 0) {
                            int length = dUW.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dUW[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.MY(i).yt(true).a(this.oYg ? e.dWw() : e.dWx());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i2 > 0 && i3 > 0) {
                a2.c(new d(i2, i3));
            }
            setController(com.facebook.drawee.a.a.c.dTu().bg(a2.eay()).yf(z).c(getController()).dUl());
        }
    }

    private void a(Uri uri, Uri uri2, int i, int i2, int i3) {
        boolean z = false;
        if (uri2 != null) {
            com.facebook.imagepipeline.request.b bVar = null;
            if (this.oYd) {
                bVar = tv.chushou.zues.widget.fresco.a.b.eqI();
            } else if (this.oYe) {
                bVar = tv.chushou.zues.widget.fresco.a.a.eqH();
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.ad(uri2).yt(true).a(this.oYg ? e.dWw() : e.dWx());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i > 0 && i2 > 0) {
                a2.c(new d(i, i2));
            }
            if (this.oYf) {
                RoundingParams dUE = getHierarchy().dUE();
                if (dUE != null) {
                    if (!dUE.dUV()) {
                        float[] dUW = dUE.dUW();
                        if (dUW != null && dUW.length > 0) {
                            int length = dUW.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dUW[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            com.facebook.drawee.a.a.e b = com.facebook.drawee.a.a.c.dTu().bg(a2.eay()).ye(this.oYh).yf(z).c(getController());
            if (i3 != 0) {
                b.c(Ps(i3));
            }
            if (ImageRequest.ab(uri) != null) {
                b.bh(ImageRequest.ab(uri));
            }
            setController(b.dUl());
        }
    }

    private c<f> Ps(int i) {
        if (i == 1) {
            if (this.oYi == null) {
                this.oYi = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.1
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
                            if (FrescoThumbnailView.this.oYl != null) {
                                FrescoThumbnailView.this.oYl.dX(width, height);
                            }
                        }
                    }
                };
            }
            return this.oYi;
        } else if (i == 2) {
            if (this.oYj == null) {
                this.oYj = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str, f fVar, Animatable animatable) {
                        super.a(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getWidth() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            if (FrescoThumbnailView.this.oYl != null) {
                                FrescoThumbnailView.this.oYl.dX(width, height);
                            }
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.height = (height * layoutParams.width) / width;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                        }
                    }
                };
            }
            return this.oYj;
        } else if (i == 3) {
            if (this.oYk == null) {
                this.oYk = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.3
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
                            if (FrescoThumbnailView.this.oYl != null) {
                                FrescoThumbnailView.this.oYl.dX(width, height);
                            }
                        }
                    }
                };
            }
            return this.oYk;
        } else {
            return null;
        }
    }
}
