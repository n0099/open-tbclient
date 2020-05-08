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
    private boolean ntM;
    private boolean ntN;
    private boolean ntO;
    private boolean ntP;
    private boolean ntQ;
    private c<f> ntR;
    private c<f> ntS;
    private c<f> ntT;
    private a ntU;

    /* loaded from: classes5.dex */
    public interface a {
        void dv(int i, int i2);
    }

    public FrescoThumbnailView(Context context) {
        super(context);
        this.ntM = false;
        this.ntN = false;
        this.ntO = false;
        this.ntP = false;
        this.ntQ = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ntM = false;
        this.ntN = false;
        this.ntO = false;
        this.ntP = false;
        this.ntQ = false;
    }

    public FrescoThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ntM = false;
        this.ntN = false;
        this.ntO = false;
        this.ntP = false;
        this.ntQ = false;
    }

    public void xW(int i) {
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
        this.ntU = aVar;
        if (!z) {
            a((String) null, str, i, i2, i3, i4);
            setTag(b.e.zues_fresco_url_tag, str);
        }
    }

    public void setGray(boolean z) {
        this.ntM = z;
    }

    public void setBlur(boolean z) {
        this.ntN = z;
    }

    public void setAutoRotated(boolean z) {
        this.ntP = z;
    }

    public void setAnim(boolean z) {
        this.ntO = z;
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        getHierarchy().a(RoundingParams.i(f, f2, f3, f4));
    }

    public void setCircle(int i) {
        getHierarchy().a(RoundingParams.dpt().a(RoundingParams.RoundingMethod.OVERLAY_COLOR).Gw(i));
    }

    public void setBorderColor(@ColorInt int i, int i2) {
        getHierarchy().doW().o(i, i2);
    }

    public void setRoundAsCircle(boolean z) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.vH(z);
        getHierarchy().a(roundingParams);
    }

    public void setProgressBarDrawable(Drawable drawable) {
        getHierarchy().e(drawable, p.b.lWi);
    }

    public void setFailureImage(Drawable drawable) {
        getHierarchy().c(drawable, p.b.lWi);
    }

    public void setRetryImage(Drawable drawable) {
        this.ntQ = true;
        getHierarchy().d(drawable, p.b.lWi);
    }

    private void a(String str, String str2, int i, int i2, int i3, int i4) {
        if (i > 0) {
            try {
                getHierarchy().Gs(i);
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
            if (this.ntM) {
                bVar = tv.chushou.zues.widget.fresco.a.b.dKi();
            } else if (!this.ntN) {
                bVar = null;
            } else {
                bVar = tv.chushou.zues.widget.fresco.a.a.dKh();
            }
            if (this.ntO) {
                RoundingParams doW = getHierarchy().doW();
                if (doW != null) {
                    if (!doW.dpo()) {
                        float[] dpp = doW.dpp();
                        if (dpp != null && dpp.length > 0) {
                            int length = dpp.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dpp[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.Hz(i).vQ(true).a(this.ntP ? e.dqQ() : e.dqR());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i2 > 0 && i3 > 0) {
                a2.c(new d(i2, i3));
            }
            setController(com.facebook.drawee.a.a.c.dnM().aX(a2.duT()).vC(z).c(getController()).doD());
        }
    }

    private void a(Uri uri, Uri uri2, int i, int i2, int i3) {
        boolean z = false;
        if (uri2 != null) {
            com.facebook.imagepipeline.request.b bVar = null;
            if (this.ntM) {
                bVar = tv.chushou.zues.widget.fresco.a.b.dKi();
            } else if (this.ntN) {
                bVar = tv.chushou.zues.widget.fresco.a.a.dKh();
            }
            ImageRequestBuilder a2 = ImageRequestBuilder.Z(uri2).vQ(true).a(this.ntP ? e.dqQ() : e.dqR());
            if (bVar != null) {
                a2.a(bVar);
            }
            if (i > 0 && i2 > 0) {
                a2.c(new d(i, i2));
            }
            if (this.ntO) {
                RoundingParams doW = getHierarchy().doW();
                if (doW != null) {
                    if (!doW.dpo()) {
                        float[] dpp = doW.dpp();
                        if (dpp != null && dpp.length > 0) {
                            int length = dpp.length;
                            boolean z2 = true;
                            for (int i4 = 0; i4 < length; i4++) {
                                if (dpp[i4] > 0.0f) {
                                    z2 = false;
                                }
                            }
                            z = z2;
                        }
                    }
                }
                z = true;
            }
            com.facebook.drawee.a.a.e b = com.facebook.drawee.a.a.c.dnM().aX(a2.duT()).vB(this.ntQ).vC(z).c(getController());
            if (i3 != 0) {
                b.c(JX(i3));
            }
            if (ImageRequest.X(uri) != null) {
                b.aY(ImageRequest.X(uri));
            }
            setController(b.doD());
        }
    }

    private c<f> JX(int i) {
        if (i == 1) {
            if (this.ntR == null) {
                this.ntR = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.1
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
                            if (FrescoThumbnailView.this.ntU != null) {
                                FrescoThumbnailView.this.ntU.dv(width, height);
                            }
                        }
                    }
                };
            }
            return this.ntR;
        } else if (i == 2) {
            if (this.ntS == null) {
                this.ntS = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void a(String str, f fVar, Animatable animatable) {
                        super.a(str, (String) fVar, animatable);
                        if (fVar != null && fVar.getWidth() > 0) {
                            int height = fVar.getHeight();
                            int width = fVar.getWidth();
                            if (FrescoThumbnailView.this.ntU != null) {
                                FrescoThumbnailView.this.ntU.dv(width, height);
                            }
                            ViewGroup.LayoutParams layoutParams = FrescoThumbnailView.this.getLayoutParams();
                            layoutParams.height = (height * layoutParams.width) / width;
                            FrescoThumbnailView.this.setLayoutParams(layoutParams);
                        }
                    }
                };
            }
            return this.ntS;
        } else if (i == 3) {
            if (this.ntT == null) {
                this.ntT = new com.facebook.drawee.controller.b<f>() { // from class: tv.chushou.zues.widget.fresco.FrescoThumbnailView.3
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
                            if (FrescoThumbnailView.this.ntU != null) {
                                FrescoThumbnailView.this.ntU.dv(width, height);
                            }
                        }
                    }
                };
            }
            return this.ntT;
        } else {
            return null;
        }
    }
}
