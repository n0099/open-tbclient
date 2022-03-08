package com.dxmpay.apollon.beans;

import android.content.Context;
import com.dxmpay.apollon.NoProguard;
/* loaded from: classes7.dex */
public interface IBeanResponse extends NoProguard {
    boolean checkResponseValidity();

    void storeResponse(Context context);
}
