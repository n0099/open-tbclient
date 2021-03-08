package com.bytedance.tea.crash.f;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.h;
/* loaded from: classes6.dex */
public class b extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String e = h.erv().e();
        if (TextUtils.isEmpty(e) || "0".equals(e)) {
            a(c());
            j.a("[DeviceIdTask] did is null, continue check.");
            return;
        }
        h.erx().a(e);
        j.a("[DeviceIdTask] did is " + e);
    }
}
