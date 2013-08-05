package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
/* loaded from: classes.dex */
public abstract class BaseReq {
    public String transaction;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle) {
        this.transaction = bundle.getString("_wxapi_basereq_transaction");
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putString("_wxapi_basereq_transaction", this.transaction);
    }
}
