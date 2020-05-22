package tv.chushou.zues.utils.systemBar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import tv.chushou.zues.utils.f;
/* loaded from: classes5.dex */
public class a {
    private static String sNavBarOverride;
    private Activity mActivity;
    private boolean mNavBarAvailable;
    private boolean mNavBarTintEnabled;
    private View mNavBarTintView;
    private boolean mStatusBarAvailable;
    private boolean mStatusBarTintEnabled;
    private View mStatusBarTintView;
    private C0918a nNH;
    private int nNI = -1;
    private ViewGroup nNJ;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            sNavBarOverride = f.get("qemu.hw.mainkeys");
        }
    }

    @TargetApi(19)
    public a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        this.mActivity = activity;
        this.nNJ = viewGroup;
        if (Build.VERSION.SDK_INT >= 19) {
            this.mNavBarAvailable = b.gC(activity);
            this.mStatusBarAvailable = true;
        }
        this.nNH = new C0918a(activity, this.mStatusBarAvailable, this.mNavBarAvailable);
        if (!this.nNH.hasNavigtionBar()) {
            this.mNavBarAvailable = false;
        }
        if (this.mStatusBarAvailable) {
            setupStatusBarView(activity, viewGroup);
        }
        if (this.mNavBarAvailable) {
            setupNavBarView(activity, viewGroup);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.mStatusBarAvailable && this.mStatusBarTintEnabled && this.mStatusBarTintView != null && this.mStatusBarTintView.getParent() != null) {
            int i = configuration.orientation;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mStatusBarTintView.getLayoutParams();
            if (i == 1) {
                marginLayoutParams.rightMargin = 0;
            } else {
                marginLayoutParams.rightMargin = this.nNH.mNavigationBarWidth;
            }
            this.mStatusBarTintView.setLayoutParams(marginLayoutParams);
            this.mStatusBarTintView.setVisibility(0);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        this.mStatusBarTintEnabled = z;
        if (this.mStatusBarAvailable) {
            int i = this.mActivity.getResources().getConfiguration().orientation;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mStatusBarTintView.getLayoutParams();
            if (i == 1) {
                marginLayoutParams.rightMargin = 0;
            } else {
                marginLayoutParams.rightMargin = this.nNH.mNavigationBarWidth;
            }
            this.mStatusBarTintView.setLayoutParams(marginLayoutParams);
            this.mStatusBarTintView.setVisibility(z ? 0 : 8);
        }
    }

    public void setNavigationBarTintEnabled(boolean z) {
        this.mNavBarTintEnabled = z;
        if (this.mNavBarAvailable) {
            this.mNavBarTintView.setVisibility(z ? 0 : 8);
        }
    }

    public void setTintResource(int i) {
        setStatusBarTintResource(i);
        setNavigationBarTintResource(i);
    }

    public void setStatusBarTintResource(int i) {
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundResource(i);
        }
    }

    public void setNavigationBarTintResource(int i) {
        if (this.mNavBarAvailable) {
            this.nNI = i;
            this.mNavBarTintView.setBackgroundResource(i);
        }
    }

    private void setupStatusBarView(Context context, ViewGroup viewGroup) {
        this.mStatusBarTintView = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.nNH.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (!this.nNH.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.nNH.getNavigationBarWidth();
        }
        this.mStatusBarTintView.setLayoutParams(layoutParams);
        this.mStatusBarTintView.setBackgroundColor(-1728053248);
        this.mStatusBarTintView.setVisibility(8);
        viewGroup.addView(this.mStatusBarTintView);
    }

    private void setupNavBarView(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        if (this.mActivity != null && this.mNavBarTintView == null) {
            this.mNavBarTintView = new View(context);
            if (this.nNH.isNavigationAtBottom()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.nNH.getNavigationBarHeight());
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.nNH.getNavigationBarWidth(), -1);
                layoutParams.gravity = 5;
            }
            this.mNavBarTintView.setLayoutParams(layoutParams);
            this.mNavBarTintView.setBackgroundColor(-1728053248);
            this.mNavBarTintView.setVisibility(8);
            viewGroup.addView(this.mNavBarTintView);
        }
    }

    public void dRQ() {
        if (this.mActivity != null && this.nNJ != null) {
            this.nNH = new C0918a(this.mActivity, this.mStatusBarAvailable, this.mNavBarAvailable);
            if (this.mNavBarTintView != null) {
                this.nNJ.removeView(this.mNavBarTintView);
                this.mNavBarTintView = null;
            }
            setupNavBarView(this.mActivity, this.nNJ);
            if (this.mNavBarTintEnabled) {
                setNavigationBarTintEnabled(this.mNavBarTintEnabled);
                setNavigationBarTintResource(this.nNI);
            }
        }
    }

    /* renamed from: tv.chushou.zues.utils.systemBar.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0918a {
        private final int mActionBarHeight;
        private boolean mHasNavigationBar;
        private final boolean mInPortrait;
        private final int mNavigationBarHeight;
        private final int mNavigationBarWidth;
        private final float mSmallestWidthDp;
        private final int mStatusBarHeight;
        private final boolean mTranslucentNavBar;
        private final boolean mTranslucentStatusBar;

        private C0918a(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.mInPortrait = resources.getConfiguration().orientation == 1;
            this.mSmallestWidthDp = getSmallestWidthDp(activity);
            this.mStatusBarHeight = getInternalDimensionSize(resources, "status_bar_height");
            this.mActionBarHeight = getActionBarHeight(activity);
            this.mNavigationBarHeight = getNavigationBarHeight(activity);
            this.mNavigationBarWidth = getNavigationBarWidth(activity);
            this.mHasNavigationBar = b.gC(activity);
            this.mTranslucentStatusBar = z;
            this.mTranslucentNavBar = z2;
        }

        @TargetApi(14)
        private int getActionBarHeight(Context context) {
            if (Build.VERSION.SDK_INT < 14) {
                return 0;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843499, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        @TargetApi(14)
        private int getNavigationBarHeight(Context context) {
            String str;
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !hasNavBar(context)) {
                return 0;
            }
            if (this.mInPortrait) {
                str = "navigation_bar_height";
            } else {
                str = "navigation_bar_height_landscape";
            }
            return getInternalDimensionSize(resources, str);
        }

        @TargetApi(14)
        private int getNavigationBarWidth(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !hasNavBar(context)) {
                return 0;
            }
            return getInternalDimensionSize(resources, "navigation_bar_width");
        }

        @TargetApi(14)
        private boolean hasNavBar(Context context) {
            return b.gC(context);
        }

        private int getInternalDimensionSize(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier <= 0) {
                return 0;
            }
            return resources.getDimensionPixelSize(identifier);
        }

        @SuppressLint({"NewApi"})
        private float getSmallestWidthDp(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            return Math.min(displayMetrics.widthPixels / displayMetrics.density, displayMetrics.heightPixels / displayMetrics.density);
        }

        public boolean isNavigationAtBottom() {
            return this.mSmallestWidthDp >= 600.0f || this.mInPortrait;
        }

        public int getStatusBarHeight() {
            return this.mStatusBarHeight;
        }

        public boolean hasNavigtionBar() {
            return this.mHasNavigationBar;
        }

        public int getNavigationBarHeight() {
            return this.mNavigationBarHeight;
        }

        public int getNavigationBarWidth() {
            return this.mNavigationBarWidth;
        }
    }
}
