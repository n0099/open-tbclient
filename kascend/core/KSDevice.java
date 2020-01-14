package kascend.core;

import android.content.Context;
import java.util.HashMap;
import kascend.core.a.b;
import kascend.core.a.c;
/* loaded from: classes4.dex */
public class KSDevice {
    private kascend.core.a.a mCache;
    private long uid = -1;
    private boolean mInited = false;

    private native String getDeviceId(long j);

    private native void init(Context context, HashMap<String, String> hashMap);

    public String getDeviceId() {
        return this.mInited ? getDeviceId(this.uid) : "";
    }

    public String getDS() {
        if (this.mCache != null) {
            String dIL = this.mCache.dIL();
            this.mCache.RQ(dIL);
            return dIL;
        }
        return getDeviceId();
    }

    public void setDevice(Context context, HashMap<String, String> hashMap) {
        if (!this.mInited) {
            init(context, hashMap);
            this.mCache = new b(context);
            c cVar = new c(context);
            cVar.a(this);
            this.mCache.a(cVar);
            this.mInited = true;
        }
    }
}
