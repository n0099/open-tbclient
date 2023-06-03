package org.chromium.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.UserManager;
import android.provider.MediaStore;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodSubtype;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ImageViewCompat;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.annotations.VerifiesOnLollipopMR1;
import org.chromium.base.annotations.VerifiesOnM;
import org.chromium.base.annotations.VerifiesOnN;
import org.chromium.base.annotations.VerifiesOnO;
import org.chromium.base.annotations.VerifiesOnP;
import org.chromium.base.annotations.VerifiesOnQ;
/* loaded from: classes2.dex */
public class ApiCompatibilityUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    public static int compareBoolean(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static int compareLong(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    public static boolean isPasswordInputType(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    @VerifiesOnN
    @TargetApi(24)
    /* loaded from: classes2.dex */
    public static class ApisN {
        @TargetApi(25)
        public static boolean isDemoUser() {
            return ((UserManager) ContextUtils.getApplicationContext().getSystemService("user")).isDemoUser();
        }

        public static String getLocale(InputMethodSubtype inputMethodSubtype) {
            return inputMethodSubtype.getLanguageTag();
        }

        public static boolean isInMultiWindowMode(Activity activity) {
            return activity.isInMultiWindowMode();
        }

        public static String toHtml(Spanned spanned, int i) {
            return Html.toHtml(spanned, i);
        }
    }

    @TargetApi(28)
    @VerifiesOnP
    /* loaded from: classes2.dex */
    public static class ApisP {
        public static String getProcessName() {
            return Application.getProcessName();
        }

        public static Bitmap getBitmapByUri(ContentResolver contentResolver, Uri uri) throws IOException {
            return ImageDecoder.decodeBitmap(ImageDecoder.createSource(contentResolver, uri));
        }
    }

    @VerifiesOnQ
    @TargetApi(29)
    /* loaded from: classes2.dex */
    public static class ApisQ {
        public static boolean isRunningInUserTestHarness() {
            return ActivityManager.isRunningInUserTestHarness();
        }

        public static List<Integer> getTargetableDisplayIds(@Nullable Activity activity) {
            ArrayList arrayList = new ArrayList();
            if (activity == null) {
                return arrayList;
            }
            DisplayManager displayManager = (DisplayManager) activity.getSystemService(CriusAttrConstants.DISPLAY);
            if (displayManager == null) {
                return arrayList;
            }
            Display[] displays = displayManager.getDisplays();
            ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
            for (Display display : displays) {
                if (display.getState() == 2 && activityManager.isActivityStartAllowedOnDisplay(activity, display.getDisplayId(), new Intent(activity, activity.getClass()))) {
                    arrayList.add(Integer.valueOf(display.getDisplayId()));
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes2.dex */
    public static class FinishAndRemoveTaskWithRetry implements Runnable {
        public static final long MAX_TRY_COUNT = 3;
        public static final long RETRY_DELAY_MS = 500;
        public final Activity mActivity;
        public int mTryCount;

        public FinishAndRemoveTaskWithRetry(Activity activity) {
            this.mActivity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mActivity.finishAndRemoveTask();
            this.mTryCount++;
            if (!this.mActivity.isFinishing()) {
                if (this.mTryCount < 3) {
                    ThreadUtils.postOnUiThreadDelayed(this, 500L);
                } else {
                    this.mActivity.finish();
                }
            }
        }
    }

    public static Intent getNotificationSettingsIntent() {
        Intent intent = new Intent();
        String packageName = ContextUtils.getApplicationContext().getPackageName();
        if (Build.VERSION.SDK_INT >= 26) {
            ApisO.initNotificationSettingsIntent(intent, packageName);
        } else {
            intent.setAction("android.settings.ACTION_APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", packageName);
            intent.putExtra("app_uid", ContextUtils.getApplicationContext().getApplicationInfo().uid);
        }
        return intent;
    }

    public static String getProcessName() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ApisP.getProcessName();
        }
        try {
            return (String) Class.forName("android.app.ActivityThread").getMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isDemoUser() {
        if (Build.VERSION.SDK_INT >= 25 && ApisN.isDemoUser()) {
            return true;
        }
        return false;
    }

    public static boolean isRunningInUserTestHarness() {
        if (Build.VERSION.SDK_INT >= 29) {
            return ApisQ.isRunningInUserTestHarness();
        }
        return false;
    }

    @VerifiesOnLollipopMR1
    @TargetApi(22)
    /* loaded from: classes2.dex */
    public static class ApisLmr1 {
        public static void setAccessibilityTraversalBefore(View view2, int i) {
            view2.setAccessibilityTraversalBefore(i);
        }
    }

    @VerifiesOnM
    @TargetApi(23)
    /* loaded from: classes2.dex */
    public static class ApisM {
        public static void setStatusBarIconColor(View view2, boolean z) {
            int i;
            int systemUiVisibility = view2.getSystemUiVisibility();
            if (z) {
                i = systemUiVisibility | 8192;
            } else {
                i = systemUiVisibility & (-8193);
            }
            view2.setSystemUiVisibility(i);
        }
    }

    @VerifiesOnO
    @TargetApi(26)
    /* loaded from: classes2.dex */
    public static class ApisO {
        public static Bundle createLaunchDisplayIdActivityOptions(int i) {
            ActivityOptions makeBasic = ActivityOptions.makeBasic();
            makeBasic.setLaunchDisplayId(i);
            return makeBasic.toBundle();
        }

        public static void disableSmartSelectionTextClassifier(TextView textView) {
            textView.setTextClassifier(TextClassifier.NO_OP);
        }

        public static void initNotificationSettingsIntent(Intent intent, String str) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", str);
        }
    }

    public static int checkPermission(Context context, String str, int i, int i2) {
        try {
            return context.checkPermission(str, i, i2);
        } catch (RuntimeException unused) {
            return -1;
        }
    }

    public static Bundle createLaunchDisplayIdActivityOptions(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ApisO.createLaunchDisplayIdActivityOptions(i);
        }
        return null;
    }

    public static void disableSmartSelectionTextClassifier(TextView textView) {
        if (Build.VERSION.SDK_INT >= 26) {
            ApisO.disableSmartSelectionTextClassifier(textView);
        }
    }

    public static void finishAndRemoveTask(Activity activity) {
        if (Build.VERSION.SDK_INT > 21) {
            activity.finishAndRemoveTask();
        } else {
            new FinishAndRemoveTaskWithRetry(activity).run();
        }
    }

    public static byte[] getBytesUtf8(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String getLocale(InputMethodSubtype inputMethodSubtype) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ApisN.getLocale(inputMethodSubtype);
        }
        return inputMethodSubtype.getLocale();
    }

    @NonNull
    public static List<Integer> getTargetableDisplayIds(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ApisQ.getTargetableDisplayIds(activity);
        }
        return new ArrayList();
    }

    public static boolean isInMultiWindowMode(Activity activity) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ApisN.isInMultiWindowMode(activity);
        }
        return false;
    }

    @NonNull
    public static <T> T requireNonNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static void setPasswordEditTextContentDescription(EditText editText) {
        if (Build.VERSION.SDK_INT < 24 && isPasswordInputType(editText.getInputType()) && !TextUtils.isEmpty(editText.getHint())) {
            editText.setContentDescription(editText.getHint());
        }
    }

    public static Bitmap getBitmapByUri(ContentResolver contentResolver, Uri uri) throws IOException {
        if (Build.VERSION.SDK_INT >= 28) {
            return ApisP.getBitmapByUri(contentResolver, uri);
        }
        return MediaStore.Images.Media.getBitmap(contentResolver, uri);
    }

    public static int getColor(Resources resources, int i) throws Resources.NotFoundException {
        return resources.getColor(i);
    }

    public static Drawable getDrawable(Resources resources, int i) throws Resources.NotFoundException {
        return getDrawableForDensity(resources, i, 0);
    }

    @NonNull
    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void setAccessibilityTraversalBefore(View view2, int i) {
        if (Build.VERSION.SDK_INT >= 22) {
            ApisLmr1.setAccessibilityTraversalBefore(view2, i);
        }
    }

    public static void setImageTintList(ImageView imageView, @Nullable ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT == 21 && colorStateList != null && imageView.getImageTintMode() == null) {
            imageView.setImageTintMode(PorterDuff.Mode.SRC_IN);
        }
        ImageViewCompat.setImageTintList(imageView, colorStateList);
        if (Build.VERSION.SDK_INT == 21 && colorStateList == null) {
            imageView.refreshDrawableState();
        }
    }

    public static void setStatusBarColor(Window window, int i) {
        if (Build.VERSION.SDK_INT < 26 && i == -16777216 && window.getNavigationBarColor() == -16777216) {
            window.clearFlags(Integer.MIN_VALUE);
        } else {
            window.addFlags(Integer.MIN_VALUE);
        }
        window.setStatusBarColor(i);
    }

    public static void setStatusBarIconColor(View view2, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            ApisM.setStatusBarIconColor(view2, z);
        }
    }

    public static void setTextAppearance(TextView textView, int i) {
        textView.setTextAppearance(textView.getContext(), i);
    }

    public static String toHtml(Spanned spanned, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ApisN.toHtml(spanned, i);
        }
        return Html.toHtml(spanned);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i, int i2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (i2 == 0) {
                return resources.getDrawable(i, null);
            }
            return resources.getDrawableForDensity(i, i2, null);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
