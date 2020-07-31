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
    private boolean oup;
    private boolean ouq;
    private boolean our;
    private boolean ous;
    private boolean ouu;
    private c<f> ouv;
    private c<f> ouw;
    private c<f> oux;
    private a ouy;

    /* loaded from: classes6.dex */
    public interface a {
        void dL(int i, int i2);
    }

    public FrescoThumbnailView(Context context) {
        super(context);
        this.oup = false;
        this.ouq = false;
        this.our = false;
        this.ous = false;
        this.ouu = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oup = false;
        this.ouq = false;
        this.our = false;
        this.ous = false;
        this.ouu = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oup = false;
        this.ouq = false;
        this.our = false;
        this.ous = false;
        this.ouu = false;
    }

    public void zR(int i) {
        a((String) null, (String) null, i, 0, 0, 0);
    }

    public void bS(String str, int i) {
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
        this.ouy = aVar;
        if (!z) {
            a((String) null, str, i, i2, i3, i4);
            setTag(b.e.zues_fresco_url_tag, str);
        }
    }

    public void setGray(boolean z) {
        this.oup = z;
    }

    public void setBlur(boolean z) {
        this.ouq = z;
    }

    public void setAutoRotated(boolean z) {
        this.ous = z;
    }

    public void setAnim(boolean z) {
        this.our = z;
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        getHierarchy().a(RoundingParams.i(f, f2, f3, f4));
    }

    public void setCircle(int i) {
        getHierarchy().a(RoundingParams.dET().a(RoundingParams.RoundingMethod.OVERLAY_COLOR).IM(i));
    }

    public void setBorderColor(@ColorInt int i, int i2) {
        getHierarchy().dEw().o(i, i2);
    }

    public void setRoundAsCircle(boolean z) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.xi(z);
        getHierarchy().a(roundingParams);
    }

    public void setProgressBarDrawable(Drawable drawable) {
        getHierarchy().e(drawable, p.b.mVw);
    }

    public void setFailureImage(Drawable drawable) {
        getHierarchy().c(drawable, p.b.mVw);
    }

    public void setRetryImage(Drawable drawable) {
        this.ouu = true;
        getHierarchy().d(drawable, p.b.mVw);
    }

    private void a(String str, String str2, int i, int i2, int i3, int i4) {
        if (i > 0) {
            try {
                getHierarchy().II(i);
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
            if (this.oup) {
                bVar = tv.chushou.zues.widget.fresco.a.b.eax();
            } else if (!this.ouq) {
                bVar = null;
            } else {
                bVar = tv.chushou.zues.widget.fresco.a.a.eaw();
            }
            if (this.our) {
                RoundingParams dEw = getHierarchy().dEw();
                if (dEw != null) {
                    if (!dEw.dEO()) {
                        float[] dEP = dEw.dEP();
                        if (dEP != null && dEP.length > 0) {
                            int length = dEP.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dEP[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.JP(i).xr(true).a(this.ous ? e.dGp() : e.dGq());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i2 > 0 && i3 > 0) {
                a2.c(new d(i2, i3));
            }
            setController(com.facebook.drawee.a.a.c.dDm().bc(a2.dKr()).xd(z).c(getController()).dEd());
        }
    }

    private void a(Uri uri, Uri uri2, int i, int i2, int i3) {
        boolean z = false;
        if (uri2 != null) {
            com.facebook.imagepipeline.request.b bVar = null;
            if (this.oup) {
                bVar = tv.chushou.zues.widget.fresco.a.b.eax();
            } else if (this.ouq) {
                bVar = tv.chushou.zues.widget.fresco.a.a.eaw();
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.ab(uri2).xr(true).a(this.ous ? e.dGp() : e.dGq());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i > 0 && i2 > 0) {
                a2.c(new d(i, i2));
            }
            if (this.our) {
                RoundingParams dEw = getHierarchy().dEw();
                if (dEw != null) {
                    if (!dEw.dEO()) {
                        float[] dEP = dEw.dEP();
                        if (dEP != null && dEP.length > 0) {
                            int length = dEP.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dEP[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            com.facebook.drawee.a.a.e b = com.facebook.drawee.a.a.c.dDm().bc(a2.dKr()).xc(this.ouu).xd(z).c(getController());
            if (i3 != 0) {
                b.c(Mk(i3));
            }
            if (ImageRequest.Z(uri) != null) {
                b.bd(ImageRequest.Z(uri));
            }
            setController(b.dEd());
        }
    }

    private c<f> Mk(int i) {
        if (i == 1) {
            if (this.ouv == null) {
                this.ouv = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.1
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
                            if (FrescoThumbnailView.this.ouy != null) {
                                FrescoThumbnailView.this.ouy.dL(width, height);
                            }
                        }
                    }
                };
            }
            return this.ouv;
        } else if (i == 2) {
            if (this.ouw == null) {
                this.ouw = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str, f fVar, Animatable animatable) {
                        super.a(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getWidth() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            if (FrescoThumbnailView.this.ouy != null) {
                                FrescoThumbnailView.this.ouy.dL(width, height);
                            }
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.height = (height * layoutParams.width) / width;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                        }
                    }
                };
            }
            return this.ouw;
        } else if (i == 3) {
            if (this.oux == null) {
                this.oux = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.3
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
                            if (FrescoThumbnailView.this.ouy != null) {
                                FrescoThumbnailView.this.ouy.dL(width, height);
                            }
                        }
                    }
                };
            }
            return this.oux;
        } else {
            return null;
        }
    }
}
