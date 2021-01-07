package com.qq.e.comm.plugin.util;

import android.app.Activity;
import android.os.Build;
import com.qq.e.comm.util.GDTLogger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<Integer> f12850a;

    /* renamed from: b  reason: collision with root package name */
    private Map<Activity, Integer> f12851b = new WeakHashMap(1);

    static {
        f12850a = Build.VERSION.SDK_INT >= 18 ? Collections.unmodifiableSet(new HashSet(Arrays.asList(-1, 2, 10, 4, 13))) : Collections.unmodifiableSet(new HashSet(Arrays.asList(-1, 2, 10, 4)));
    }

    private boolean c() {
        return Build.VERSION.SDK_INT > 8;
    }

    public void a() {
        try {
            b();
        } catch (IllegalStateException e) {
            GDTLogger.e("unLockOrientation exception", e);
        }
    }

    public void a(Activity activity) {
        try {
            b(activity);
        } catch (IllegalStateException e) {
            GDTLogger.e("lockOrientation exception", e);
        }
    }

    public void b() {
        if (this.f12851b == null) {
            GDTLogger.report("HoldingActivityOrientationMap null");
            return;
        }
        if (this.f12851b.size() > 1) {
            GDTLogger.report("HoldingActivityOrientationMap is holding More than one entry");
        }
        for (Activity activity : this.f12851b.keySet()) {
            if (activity != null) {
                activity.setRequestedOrientation(this.f12851b.get(activity).intValue());
            }
        }
        this.f12851b.clear();
    }

    public void b(Activity activity) {
        int requestedOrientation = activity.getRequestedOrientation();
        if (f12850a.contains(Integer.valueOf(requestedOrientation))) {
            int i = activity.getResources().getConfiguration().orientation;
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            GDTLogger.d("config ORIENTATION=" + (i == 2 ? "landscape" : "patr") + " \t rotation:" + rotation);
            if (i == 2) {
                if (c() && (rotation == 2 || rotation == 3)) {
                    activity.setRequestedOrientation(8);
                } else {
                    activity.setRequestedOrientation(0);
                }
            } else if (c() && (rotation == 2 || rotation == 1)) {
                activity.setRequestedOrientation(9);
            } else {
                activity.setRequestedOrientation(1);
            }
            this.f12851b.put(activity, Integer.valueOf(requestedOrientation));
        }
    }
}
