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
/* loaded from: classes5.dex */
public class FrescoThumbnailView extends SimpleDraweeView {
    private boolean nXP;
    private boolean nXQ;
    private boolean nXR;
    private boolean nXS;
    private boolean nXT;
    private c<f> nXU;
    private c<f> nXV;
    private c<f> nXW;
    private a nXX;

    /* loaded from: classes5.dex */
    public interface a {
        void ei(int i, int i2);
    }

    public FrescoThumbnailView(Context context) {
        super(context);
        this.nXP = false;
        this.nXQ = false;
        this.nXR = false;
        this.nXS = false;
        this.nXT = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nXP = false;
        this.nXQ = false;
        this.nXR = false;
        this.nXS = false;
        this.nXT = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nXP = false;
        this.nXQ = false;
        this.nXR = false;
        this.nXS = false;
        this.nXT = false;
    }

    public void xo(int i) {
        a((String) null, (String) null, i, 0, 0, 0);
    }

    public void bU(String str, int i) {
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
        this.nXX = aVar;
        if (!z) {
            a((String) null, str, i, i2, i3, i4);
            setTag(b.e.zues_fresco_url_tag, str);
        }
    }

    public void setGray(boolean z) {
        this.nXP = z;
    }

    public void setBlur(boolean z) {
        this.nXQ = z;
    }

    public void setAutoRotated(boolean z) {
        this.nXS = z;
    }

    public void setAnim(boolean z) {
        this.nXR = z;
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        getHierarchy().a(RoundingParams.o(f, f2, f3, f4));
    }

    public void setCircle(int i) {
        getHierarchy().a(RoundingParams.dnc().a(RoundingParams.RoundingMethod.OVERLAY_COLOR).HP(i));
    }

    public void setBorderColor(@ColorInt int i, int i2) {
        getHierarchy().dmF().q(i, i2);
    }

    public void setRoundAsCircle(boolean z) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.vm(z);
        getHierarchy().a(roundingParams);
    }

    public void setProgressBarDrawable(Drawable drawable) {
        getHierarchy().e(drawable, p.b.lMP);
    }

    public void setFailureImage(Drawable drawable) {
        getHierarchy().c(drawable, p.b.lMP);
    }

    public void setRetryImage(Drawable drawable) {
        this.nXT = true;
        getHierarchy().d(drawable, p.b.lMP);
    }

    private void a(String str, String str2, int i, int i2, int i3, int i4) {
        if (i > 0) {
            try {
                getHierarchy().HL(i);
            } catch (Throwable th) {
                return;
            }
        }
        Uri parse = !h.isEmpty(str2) ? Uri.parse(str2) : null;
        if (parse == null) {
            if (i > 0) {
                ax(i, i2, i3);
                return;
            }
            return;
        }
        a(str != null ? Uri.parse(str) : null, parse, i2, i3, i4);
    }

    private void ax(int i, int i2, int i3) {
        tv.chushou.zues.widget.fresco.a.b bVar;
        boolean z = false;
        if (i > 0) {
            if (this.nXP) {
                bVar = tv.chushou.zues.widget.fresco.a.b.dQH();
            } else if (!this.nXQ) {
                bVar = null;
            } else {
                bVar = tv.chushou.zues.widget.fresco.a.a.dQG();
            }
            if (this.nXR) {
                RoundingParams dmF = getHierarchy().dmF();
                if (dmF != null) {
                    if (!dmF.dmX()) {
                        float[] dmY = dmF.dmY();
                        if (dmY != null && dmY.length > 0) {
                            int length = dmY.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dmY[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.IQ(i).vw(true).a(this.nXS ? e.dou() : e.dov());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i2 > 0 && i3 > 0) {
                a2.c(new d(i2, i3));
            }
            setController(com.facebook.drawee.a.a.c.dlw().bg(a2.dsA()).vh(z).c(getController()).dmn());
        }
    }

    private void a(Uri uri, Uri uri2, int i, int i2, int i3) {
        boolean z = false;
        if (uri2 != null) {
            com.facebook.imagepipeline.request.b bVar = null;
            if (this.nXP) {
                bVar = tv.chushou.zues.widget.fresco.a.b.dQH();
            } else if (this.nXQ) {
                bVar = tv.chushou.zues.widget.fresco.a.a.dQG();
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.Y(uri2).vw(true).a(this.nXS ? e.dou() : e.dov());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i > 0 && i2 > 0) {
                a2.c(new d(i, i2));
            }
            if (this.nXR) {
                RoundingParams dmF = getHierarchy().dmF();
                if (dmF != null) {
                    if (!dmF.dmX()) {
                        float[] dmY = dmF.dmY();
                        if (dmY != null && dmY.length > 0) {
                            int length = dmY.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dmY[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            com.facebook.drawee.a.a.e b = com.facebook.drawee.a.a.c.dlw().bg(a2.dsA()).vg(this.nXT).vh(z).c(getController());
            if (i3 != 0) {
                b.c(Ov(i3));
            }
            if (ImageRequest.W(uri) != null) {
                b.bh(ImageRequest.W(uri));
            }
            setController(b.dmn());
        }
    }

    private c<f> Ov(int i) {
        if (i == 1) {
            if (this.nXU == null) {
                this.nXU = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void onFinalImageSet(String str, f fVar, Animatable animatable) {
                        super.onFinalImageSet(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getHeight() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.width = (layoutParams.height * width) / height;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                            if (FrescoThumbnailView.this.nXX != null) {
                                FrescoThumbnailView.this.nXX.ei(width, height);
                            }
                        }
                    }
                };
            }
            return this.nXU;
        } else if (i == 2) {
            if (this.nXV == null) {
                this.nXV = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void onFinalImageSet(String str, f fVar, Animatable animatable) {
                        super.onFinalImageSet(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getWidth() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            if (FrescoThumbnailView.this.nXX != null) {
                                FrescoThumbnailView.this.nXX.ei(width, height);
                            }
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.height = (height * layoutParams.width) / width;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                        }
                    }
                };
            }
            return this.nXV;
        } else if (i == 3) {
            if (this.nXW == null) {
                this.nXW = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void onFinalImageSet(String str, f fVar, Animatable animatable) {
                        super.onFinalImageSet(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getHeight() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.width = (layoutParams.height * width) / height;
                            if (layoutParams instanceof FlexboxLayout.LayoutParams) {
                                ((FlexboxLayout.LayoutParams) layoutParams).setMinWidth(layoutParams.width);
                            }
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                            if (FrescoThumbnailView.this.nXX != null) {
                                FrescoThumbnailView.this.nXX.ei(width, height);
                            }
                        }
                    }
                };
            }
            return this.nXW;
        } else {
            return null;
        }
    }
}
