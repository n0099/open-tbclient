package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import com.facebook.common.internal.g;
import com.facebook.common.internal.j;
import com.facebook.common.util.d;
import com.facebook.drawee.a;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class SimpleDraweeView extends GenericDraweeView {
    private static j<? extends AbstractDraweeControllerBuilder> nqE;
    private static j<j<? extends AbstractDraweeControllerBuilder>> nqF;
    private AbstractDraweeControllerBuilder nqG;

    public static void b(j<j<? extends AbstractDraweeControllerBuilder>> jVar) {
        nqF = jVar;
    }

    public SimpleDraweeView(Context context) {
        super(context);
        init(context, null);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, @Nullable AttributeSet attributeSet) {
        int resourceId;
        if (!isInEditMode()) {
            if (nqE == null) {
                nqE = nqF.get();
            }
            g.checkNotNull(nqE, "SimpleDraweeView was not initialized!");
            this.nqG = nqE.get();
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0864a.SimpleDraweeView);
                try {
                    if (obtainStyledAttributes.hasValue(a.C0864a.SimpleDraweeView_actualImageUri)) {
                        setImageURI(Uri.parse(obtainStyledAttributes.getString(a.C0864a.SimpleDraweeView_actualImageUri)), (Object) null);
                    } else if (obtainStyledAttributes.hasValue(a.C0864a.SimpleDraweeView_actualImageResource)) {
                        int resourceId2 = obtainStyledAttributes.getResourceId(a.C0864a.SimpleDraweeView_actualImageResource, -1);
                        if (resourceId2 != -1) {
                            setActualImageResource(resourceId2);
                        }
                    } else if (obtainStyledAttributes.hasValue(a.C0864a.SimpleDraweeView_svgImage) && (resourceId = obtainStyledAttributes.getResourceId(a.C0864a.SimpleDraweeView_svgImage, -1)) != -1) {
                        setImageURI(d.KW(resourceId), (Object) null);
                    }
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
    }

    protected AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.nqG;
    }

    public void setImageRequest(ImageRequest imageRequest) {
        setController(this.nqG.be(imageRequest).c(getController()).dQe());
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        setImageURI(uri, (Object) null);
    }

    public void setImageURI(@Nullable String str) {
        setImageURI(str, (Object) null);
    }

    public void setImageURI(Uri uri, @Nullable Object obj) {
        setController(this.nqG.bg(obj).Q(uri).c(getController()).dQe());
    }

    public void setImageURI(@Nullable String str, @Nullable Object obj) {
        setImageURI(str != null ? Uri.parse(str) : null, obj);
    }

    public void setActualImageResource(@DrawableRes int i) {
        setActualImageResource(i, null);
    }

    public void setActualImageResource(@DrawableRes int i, @Nullable Object obj) {
        setImageURI(d.KW(i), obj);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
    }

    public void setImageURIWithHeader(Uri uri, Map<String, String> map, @Nullable Object obj) {
        setController(getControllerBuilder().c(uri, map).bg(obj).c(getController()).dQe());
    }

    public void setImageURIWithHeader(Uri uri, Map<String, String> map) {
        setImageURIWithHeader(uri, map, null);
    }
}
