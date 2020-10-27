package com.kascend.chushou.player.ui.h5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.kascend.chushou.constants.JSInterface;
import com.kascend.chushou.view.h5.H5Options;
/* loaded from: classes6.dex */
public class CommonH5Item extends FrameLayout {
    private d pkN;
    private com.kascend.chushou.widget.cswebview.d pkO;

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
        if (this.pkN != null && this.pkN.getParent() == this) {
            removeView(this.pkN);
            this.pkN = null;
        }
        H5Options h5Options = new H5Options();
        h5Options.e = false;
        h5Options.h = 0;
        h5Options.c = false;
        h5Options.b = true;
        h5Options.f4231a = aVar.o;
        h5Options.d = true;
        h5Options.f = false;
        this.pkN = new d(getContext(), h5Options, new com.kascend.chushou.widget.cswebview.a().a(new JSInterface(getContext())).a(this.pkO));
        addView(this.pkN);
    }

    public void a(com.kascend.chushou.player.ui.h5.c.c cVar) {
        if (this.pkN != null && this.pkN.getParent() == this) {
            removeView(this.pkN);
            this.pkN = null;
        }
        H5Options h5Options = new H5Options();
        h5Options.e = false;
        h5Options.h = 0;
        h5Options.c = false;
        h5Options.b = true;
        h5Options.f4231a = cVar.o;
        h5Options.d = true;
        h5Options.f = false;
        this.pkN = new d(getContext(), h5Options, new com.kascend.chushou.widget.cswebview.a().a(new JSInterface(getContext())).a(this.pkO));
        addView(this.pkN);
    }

    public void a(com.kascend.chushou.player.ui.h5.c.b bVar) {
        if (this.pkN != null && this.pkN.getParent() == this) {
            removeView(this.pkN);
            this.pkN = null;
        }
        H5Options h5Options = new H5Options();
        h5Options.e = false;
        h5Options.h = 0;
        h5Options.c = false;
        h5Options.b = true;
        h5Options.f4231a = bVar.o;
        h5Options.d = true;
        h5Options.f = false;
        this.pkN = new d(getContext(), h5Options, new com.kascend.chushou.widget.cswebview.a().a(new JSInterface(getContext())).a(this.pkO));
        addView(this.pkN);
    }

    public void setListener(com.kascend.chushou.widget.cswebview.d dVar) {
        this.pkO = dVar;
    }
}
