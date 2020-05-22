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
/* loaded from: classes13.dex */
public class SimpleDraweeView extends GenericDraweeView {
    private static j<? extends AbstractDraweeControllerBuilder> mrs;
    private static j<j<? extends AbstractDraweeControllerBuilder>> mrt;
    private AbstractDraweeControllerBuilder mru;

    public static void b(j<j<? extends AbstractDraweeControllerBuilder>> jVar) {
        mrt = jVar;
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
            if (mrs == null) {
                mrs = mrt.get();
            }
            g.checkNotNull(mrs, "SimpleDraweeView was not initialized!");
            this.mru = mrs.get();
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0776a.SimpleDraweeView);
                try {
                    if (obtainStyledAttributes.hasValue(a.C0776a.SimpleDraweeView_actualImageUri)) {
                        setImageURI(Uri.parse(obtainStyledAttributes.getString(a.C0776a.SimpleDraweeView_actualImageUri)), (Object) null);
                    } else if (obtainStyledAttributes.hasValue(a.C0776a.SimpleDraweeView_actualImageResource)) {
                        int resourceId2 = obtainStyledAttributes.getResourceId(a.C0776a.SimpleDraweeView_actualImageResource, -1);
                        if (resourceId2 != -1) {
                            setActualImageResource(resourceId2);
                        }
                    } else if (obtainStyledAttributes.hasValue(a.C0776a.SimpleDraweeView_svgImage) && (resourceId = obtainStyledAttributes.getResourceId(a.C0776a.SimpleDraweeView_svgImage, -1)) != -1) {
                        setImageURI(d.GO(resourceId), (Object) null);
                    }
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
    }

    protected AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.mru;
    }

    public void setImageRequest(ImageRequest imageRequest) {
        setController(this.mru.bb(imageRequest).c(getController()).dvW());
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        setImageURI(uri, (Object) null);
    }

    public void setImageURI(@Nullable String str) {
        setImageURI(str, (Object) null);
    }

    public void setImageURI(Uri uri, @Nullable Object obj) {
        setController(this.mru.bd(obj).Q(uri).c(getController()).dvW());
    }

    public void setImageURI(@Nullable String str, @Nullable Object obj) {
        setImageURI(str != null ? Uri.parse(str) : null, obj);
    }

    public void setActualImageResource(@DrawableRes int i) {
        setActualImageResource(i, null);
    }

    public void setActualImageResource(@DrawableRes int i, @Nullable Object obj) {
        setImageURI(d.GO(i), obj);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
    }

    public void setImageURIWithHeader(Uri uri, Map<String, String> map, @Nullable Object obj) {
        setController(getControllerBuilder().c(uri, map).bd(obj).c(getController()).dvW());
    }

    public void setImageURIWithHeader(Uri uri, Map<String, String> map) {
        setImageURIWithHeader(uri, map, null);
    }
}
