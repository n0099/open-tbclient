package com.kascend.chushou.player.ui.h5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.kascend.chushou.constants.JSInterface;
import com.kascend.chushou.view.h5.H5Options;
/* loaded from: classes5.dex */
public class CommonH5Item extends FrameLayout {
    private d mAi;
    private com.kascend.chushou.widget.cswebview.d mAj;

    public CommonH5Item(@NonNull Context context) {
        super(context);
    }

    public CommonH5Item(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CommonH5Item(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mAi != null && this.mAi.getParent() == this) {
            removeView(this.mAi);
            this.mAi = null;
        }
        H5Options h5Options = new H5Options();
        h5Options.e = false;
        h5Options.h = 0;
        h5Options.c = false;
        h5Options.b = true;
        h5Options.a = aVar.o;
        h5Options.d = true;
        h5Options.f = false;
        this.mAi = new d(getContext(), h5Options, new com.kascend.chushou.widget.cswebview.a().a(new JSInterface(getContext())).a(this.mAj));
        addView(this.mAi);
    }

    public void a(com.kascend.chushou.player.ui.h5.c.c cVar) {
        if (this.mAi != null && this.mAi.getParent() == this) {
            removeView(this.mAi);
            this.mAi = null;
        }
        H5Options h5Options = new H5Options();
        h5Options.e = false;
        h5Options.h = 0;
        h5Options.c = false;
        h5Options.b = true;
        h5Options.a = cVar.o;
        h5Options.d = true;
        h5Options.f = false;
        this.mAi = new d(getContext(), h5Options, new com.kascend.chushou.widget.cswebview.a().a(new JSInterface(getContext())).a(this.mAj));
        addView(this.mAi);
    }

    public void a(com.kascend.chushou.player.ui.h5.c.b bVar) {
        if (this.mAi != null && this.mAi.getParent() == this) {
            removeView(this.mAi);
            this.mAi = null;
        }
        H5Options h5Options = new H5Options();
        h5Options.e = false;
        h5Options.h = 0;
        h5Options.c = false;
        h5Options.b = true;
        h5Options.a = bVar.o;
        h5Options.d = true;
        h5Options.f = false;
        this.mAi = new d(getContext(), h5Options, new com.kascend.chushou.widget.cswebview.a().a(new JSInterface(getContext())).a(this.mAj));
        addView(this.mAi);
    }

    public void setListener(com.kascend.chushou.widget.cswebview.d dVar) {
        this.mAj = dVar;
    }
}
