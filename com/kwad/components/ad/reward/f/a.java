package com.kwad.components.ad.reward.f;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.d.j;
import com.kwad.sdk.utils.t;
/* loaded from: classes8.dex */
public final class a implements j {
    @Nullable
    public Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.kwad.components.ad.reward.d.j
    public final boolean gv() {
        Context context = this.mContext;
        if (context != null) {
            t.b(this.mContext, context.getResources().getString(R.string.obfuscated_res_0x7f0f0a93), 0L);
            return true;
        }
        return true;
    }
}
