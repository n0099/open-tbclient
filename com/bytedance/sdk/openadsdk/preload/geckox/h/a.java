package com.bytedance.sdk.openadsdk.preload.geckox.h;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class a implements c {
    @Override // com.bytedance.sdk.openadsdk.preload.geckox.h.c
    public void a(String str, Object... objArr) {
        if (objArr == null) {
            Log.d(str, StringUtil.NULL_STRING);
        } else {
            Log.d(str, com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(objArr));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.h.c
    public void b(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.h.c
    public void a(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }
}
