package com.bytedance.sdk.openadsdk.video.d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f30276a;

    public static Activity a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }
}
