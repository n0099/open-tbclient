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
    private boolean olH;
    private boolean olI;
    private boolean olJ;
    private boolean olK;
    private boolean olL;
    private c<f> olM;
    private c<f> olN;
    private c<f> olO;
    private a olP;

    /* loaded from: classes5.dex */
    public interface a {
        void dJ(int i, int i2);
    }

    public FrescoThumbnailView(Context context) {
        super(context);
        this.olH = false;
        this.olI = false;
        this.olJ = false;
        this.olK = false;
        this.olL = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.olH = false;
        this.olI = false;
        this.olJ = false;
        this.olK = false;
        this.olL = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.olH = false;
        this.olI = false;
        this.olJ = false;
        this.olK = false;
        this.olL = false;
    }

    public void zs(int i) {
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
        this.olP = aVar;
        if (!z) {
            a((String) null, str, i, i2, i3, i4);
            setTag(b.e.zues_fresco_url_tag, str);
        }
    }

    public void setGray(boolean z) {
        this.olH = z;
    }

    public void setBlur(boolean z) {
        this.olI = z;
    }

    public void setAutoRotated(boolean z) {
        this.olK = z;
    }

    public void setAnim(boolean z) {
        this.olJ = z;
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        getHierarchy().a(RoundingParams.i(f, f2, f3, f4));
    }

    public void setCircle(int i) {
        getHierarchy().a(RoundingParams.dBD().a(RoundingParams.RoundingMethod.OVERLAY_COLOR).Ir(i));
    }

    public void setBorderColor(@ColorInt int i, int i2) {
        getHierarchy().dBg().o(i, i2);
    }

    public void setRoundAsCircle(boolean z) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.wD(z);
        getHierarchy().a(roundingParams);
    }

    public void setProgressBarDrawable(Drawable drawable) {
        getHierarchy().e(drawable, p.b.mNk);
    }

    public void setFailureImage(Drawable drawable) {
        getHierarchy().c(drawable, p.b.mNk);
    }

    public void setRetryImage(Drawable drawable) {
        this.olL = true;
        getHierarchy().d(drawable, p.b.mNk);
    }

    private void a(String str, String str2, int i, int i2, int i3, int i4) {
        if (i > 0) {
            try {
                getHierarchy().In(i);
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
            if (this.olH) {
                bVar = tv.chushou.zues.widget.fresco.a.b.dWX();
            } else if (!this.olI) {
                bVar = null;
            } else {
                bVar = tv.chushou.zues.widget.fresco.a.a.dWW();
            }
            if (this.olJ) {
                RoundingParams dBg = getHierarchy().dBg();
                if (dBg != null) {
                    if (!dBg.dBy()) {
                        float[] dBz = dBg.dBz();
                        if (dBz != null && dBz.length > 0) {
                            int length = dBz.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dBz[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.Ju(i).wM(true).a(this.olK ? e.dCZ() : e.dDa());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i2 > 0 && i3 > 0) {
                a2.c(new d(i2, i3));
            }
            setController(com.facebook.drawee.a.a.c.dzW().bc(a2.dHb()).wy(z).c(getController()).dAN());
        }
    }

    private void a(Uri uri, Uri uri2, int i, int i2, int i3) {
        boolean z = false;
        if (uri2 != null) {
            com.facebook.imagepipeline.request.b bVar = null;
            if (this.olH) {
                bVar = tv.chushou.zues.widget.fresco.a.b.dWX();
            } else if (this.olI) {
                bVar = tv.chushou.zues.widget.fresco.a.a.dWW();
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.ac(uri2).wM(true).a(this.olK ? e.dCZ() : e.dDa());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i > 0 && i2 > 0) {
                a2.c(new d(i, i2));
            }
            if (this.olJ) {
                RoundingParams dBg = getHierarchy().dBg();
                if (dBg != null) {
                    if (!dBg.dBy()) {
                        float[] dBz = dBg.dBz();
                        if (dBz != null && dBz.length > 0) {
                            int length = dBz.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dBz[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            com.facebook.drawee.a.a.e b = com.facebook.drawee.a.a.c.dzW().bc(a2.dHb()).wx(this.olL).wy(z).c(getController());
            if (i3 != 0) {
                b.c(LQ(i3));
            }
            if (ImageRequest.aa(uri) != null) {
                b.bd(ImageRequest.aa(uri));
            }
            setController(b.dAN());
        }
    }

    private c<f> LQ(int i) {
        if (i == 1) {
            if (this.olM == null) {
                this.olM = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.1
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
                            if (FrescoThumbnailView.this.olP != null) {
                                FrescoThumbnailView.this.olP.dJ(width, height);
                            }
                        }
                    }
                };
            }
            return this.olM;
        } else if (i == 2) {
            if (this.olN == null) {
                this.olN = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str, f fVar, Animatable animatable) {
                        super.a(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getWidth() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            if (FrescoThumbnailView.this.olP != null) {
                                FrescoThumbnailView.this.olP.dJ(width, height);
                            }
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.height = (height * layoutParams.width) / width;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                        }
                    }
                };
            }
            return this.olN;
        } else if (i == 3) {
            if (this.olO == null) {
                this.olO = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.3
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
                            if (FrescoThumbnailView.this.olP != null) {
                                FrescoThumbnailView.this.olP.dJ(width, height);
                            }
                        }
                    }
                };
            }
            return this.olO;
        } else {
            return null;
        }
    }
}
