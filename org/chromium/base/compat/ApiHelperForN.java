package org.chromium.base.compat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.os.Process;
import android.security.NetworkSecurityPolicy;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.chromium.base.annotations.VerifiesOnN;
@VerifiesOnN
@TargetApi(24)
/* loaded from: classes2.dex */
public final class ApiHelperForN {
    public static long getStartUptimeMillis() {
        return Process.getStartUptimeMillis();
    }

    public static PointerIcon createPointerIcon(Bitmap bitmap, float f, float f2) {
        return PointerIcon.create(bitmap, f, f2);
    }

    public static PointerIcon onResolvePointerIcon(View view2, MotionEvent motionEvent, int i) {
        return view2.onResolvePointerIcon(motionEvent, i);
    }

    public static void setCryptoInfoPattern(MediaCodec.CryptoInfo cryptoInfo, int i, int i2) {
        cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(i, i2));
    }

    public static void setVrModeEnabled(Activity activity, boolean z, ComponentName componentName) throws PackageManager.NameNotFoundException {
        activity.setVrModeEnabled(z, componentName);
    }

    public static boolean shouldOverrideUrlLoading(WebViewClient webViewClient, WebView webView, WebResourceRequest webResourceRequest) {
        return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public static JobInfo getPendingJob(JobScheduler jobScheduler, int i) {
        return jobScheduler.getPendingJob(i);
    }

    public static void setPointerIcon(View view2, PointerIcon pointerIcon) {
        view2.setPointerIcon(pointerIcon);
    }

    public static boolean isCleartextTrafficPermitted(String str) {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    public static boolean startDragAndDrop(View view2, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        return view2.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
    }
}
