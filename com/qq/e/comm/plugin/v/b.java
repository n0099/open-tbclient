package com.qq.e.comm.plugin.v;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.p;
import com.qq.e.comm.util.GDTLogger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f12608a;

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f12609a = new b();
    }

    private b() {
        this.f12608a = new HashSet();
        this.f12608a.add("V1818A");
        String string = GDTADManager.getInstance().getSM().getString("express_reward_video_adapt_height_devices");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.f12608a.addAll(Arrays.asList(string.split(",")));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a() {
        return a.f12609a;
    }

    private boolean b() {
        String str = Build.MODEL;
        for (String str2 : this.f12608a) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Context context, int i) {
        int b2 = b() ? i - ak.b(context, p.c(context)) : i;
        GDTLogger.d("CompatUtil.adaptWebViewHeight: origin = " + i + ", result = " + b2);
        return b2;
    }
}
