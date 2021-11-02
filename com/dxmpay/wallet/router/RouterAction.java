package com.dxmpay.wallet.router;

import android.content.Context;
import com.dxmpay.wallet.core.NoProguard;
import java.util.HashMap;
/* loaded from: classes11.dex */
public interface RouterAction extends NoProguard {
    void invoke(Context context, HashMap hashMap, RouterCallback routerCallback);
}
