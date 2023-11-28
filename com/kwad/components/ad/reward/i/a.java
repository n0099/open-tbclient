package com.kwad.components.ad.reward.i;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.e.n;
import com.kwad.sdk.utils.v;
/* loaded from: classes10.dex */
public final class a implements n {
    @Nullable
    public Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.kwad.components.ad.reward.e.n
    public final boolean gR() {
        Context context = this.mContext;
        if (context != null) {
            v.c(this.mContext, context.getResources().getString(R.string.obfuscated_res_0x7f0f0ba3), 0L);
            return true;
        }
        return true;
    }
}
