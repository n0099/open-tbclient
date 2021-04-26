package com.tencent.mm.opensdk.diffdev;

import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;
/* loaded from: classes6.dex */
public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    public static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    public static IDiffDevOAuth v1Instance;

    public static IDiffDevOAuth getDiffDevOAuth() {
        return getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i2) {
        Log.v(TAG, "getDiffDevOAuth, version = " + i2);
        if (i2 > 1) {
            Log.e(TAG, "getDiffDevOAuth fail, unsupported version = " + i2);
            return null;
        } else if (i2 != 1) {
            return null;
        } else {
            if (v1Instance == null) {
                v1Instance = new a();
            }
            return v1Instance;
        }
    }
}
