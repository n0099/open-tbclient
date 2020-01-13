package com.kascend.chushou.player.ui.h5.redpacket;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.kascend.chushou.constants.JSInterface;
import com.kascend.chushou.player.ui.h5.c.e;
import com.kascend.chushou.player.ui.h5.d;
import com.kascend.chushou.view.h5.H5Options;
/* loaded from: classes4.dex */
public class RedpacketItem extends FrameLayout {
    private d naW;
    private com.kascend.chushou.widget.cswebview.d naX;

    public RedpacketItem(@NonNull Context context) {
        super(context);
    }

    public RedpacketItem(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RedpacketItem(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(e eVar, a aVar) {
        if (this.naW != null && this.naW.getParent() == this) {
            removeView(this.naW);
            this.naW = null;
        }
        H5Options h5Options = new H5Options();
        h5Options.e = true;
        h5Options.h = 0;
        h5Options.c = false;
        h5Options.b = true;
        h5Options.a = eVar.b();
        h5Options.d = true;
        h5Options.f = false;
        this.naW = new d(getContext(), h5Options, new com.kascend.chushou.widget.cswebview.a().a(new JSInterface(getContext(), aVar)).a(this.naX));
        addView(this.naW);
    }

    public void a(com.kascend.chushou.player.ui.h5.c.c cVar) {
        if (this.naW != null && this.naW.getParent() == this) {
            removeView(this.naW);
            this.naW = null;
        }
        H5Options h5Options = new H5Options();
        h5Options.e = true;
        h5Options.h = 0;
        h5Options.c = false;
        h5Options.b = true;
        h5Options.a = cVar.o;
        h5Options.d = true;
        h5Options.f = false;
        this.naW = new d(getContext(), h5Options, new com.kascend.chushou.widget.cswebview.a().a(new JSInterface(getContext())).a(this.naX));
        addView(this.naW);
    }

    public void a() {
        if (this.naW != null && this.naW.getParent() == this) {
            removeView(this.naW);
            this.naW = null;
        }
    }

    public void setListener(com.kascend.chushou.widget.cswebview.d dVar) {
        this.naX = dVar;
    }
}
