package com.kwad.components.ad.widget.tailframe.appbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public class TailFrameBarAppPortraitVertical extends a {
    public TailFrameBarAppPortraitVertical(Context context) {
        this(context, null);
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public final void c(@NonNull AdTemplate adTemplate) {
        if (d.p(adTemplate)) {
            this.BA.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f0607ac));
            this.hG.setTextColor(Color.parseColor("#FFFFFF"));
            this.CI.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.BA.setBackgroundColor(Color.parseColor("#E6FFFFFF"));
        }
        super.c(adTemplate);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04ff;
    }
}
