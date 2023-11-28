package com.kwad.components.ad.widget.tailframe.appbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public class TailFrameBarAppPortraitHorizontal extends a {
    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0528;
    }

    public TailFrameBarAppPortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public final void b(@NonNull AdTemplate adTemplate) {
        if (e.F(adTemplate)) {
            this.Hg.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f0607b3));
            this.kT.setTextColor(Color.parseColor("#FFFFFF"));
            this.Iq.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.Hg.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        super.b(adTemplate);
    }
}
