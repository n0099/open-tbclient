package com.dxmpay.wallet.router;

import com.dxmpay.wallet.core.NoProguard;
import java.util.HashMap;
/* loaded from: classes7.dex */
public interface RouterCallback extends NoProguard {
    public static final int CODE_ERROR = 1;
    public static final int CODE_INVALID = 3;
    public static final int CODE_NOT_FOUND = 2;
    public static final int CODE_PROVIDER_NOT_FOUND = 5;
    public static final int CODE_ROUTER_NOT_REGISTER = 4;
    public static final int CODE_SUCCESS = 0;
    public static final String KEY_ERROR_CODE = "errCode";
    public static final String KEY_ERROR_MSG = "errorMsg";
    public static final String KEY_VALUE = "value";

    void onResult(int i2, HashMap hashMap);
}
