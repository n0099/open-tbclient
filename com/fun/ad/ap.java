package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
/* loaded from: classes6.dex */
public final class ap {

    /* loaded from: classes6.dex */
    public static class a {
        public static final ap pPQ = new ap();
    }

    public void a(View view, String str, ImageView imageView) {
        if (view == null) {
            m.a("GlideHelper: view is null when load: " + str);
        } else {
            a(view.getContext(), str, imageView);
        }
    }

    public void a(Context context, String str, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity.isDestroyed())) {
                    m.a("GlideHelper: activity is destroyed when load: " + str);
                    return;
                } else {
                    Glide.with(activity).load(str).into(imageView);
                    return;
                }
            }
            Glide.with(context).load(str).into(imageView);
            return;
        }
        m.a("GlideHelper: context is null when load: " + str);
    }
}
