package com.slidingmenu.lib;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.slidingmenu.lib.CustomViewAbove;
/* loaded from: classes.dex */
public class SlidingMenu extends RelativeLayout {
    public static final int LEFT = 0;
    public static final int LEFT_RIGHT = 2;
    public static final int RIGHT = 1;
    public static final int SLIDING_CONTENT = 1;
    public static final int SLIDING_WINDOW = 0;
    private static final String TAG = "SlidingMenu";
    public static final int TOUCHMODE_FULLSCREEN = 1;
    public static final int TOUCHMODE_MARGIN = 0;
    public static final int TOUCHMODE_NONE = 2;
    private boolean mActionbarOverlay;
    private OnCloseListener mCloseListener;
    private Handler mHandler;
    private OnOpenListener mOpenListener;
    private CustomViewAbove mViewAbove;
    private CustomViewBehind mViewBehind;

    /* loaded from: classes.dex */
    public interface CanvasTransformer {
        void transformCanvas(Canvas canvas, float f);
    }

    /* loaded from: classes.dex */
    public interface OnCloseListener {
        void onClose();
    }

    /* loaded from: classes.dex */
    public interface OnClosedListener {
        void onClosed();
    }

    /* loaded from: classes.dex */
    public interface OnOpenListener {
        void onOpen();
    }

    /* loaded from: classes.dex */
    public interface OnOpenedListener {
        void onOpened();
    }

    public SlidingMenu(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingMenu(Activity activity, int i) {
        this(activity, (AttributeSet) null);
        attachToActivity(activity, i);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActionbarOverlay = false;
        this.mHandler = new Handler();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.mViewBehind = new CustomViewBehind(context);
        addView(this.mViewBehind, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        this.mViewAbove = new CustomViewAbove(context);
        addView(this.mViewAbove, layoutParams2);
        this.mViewAbove.setCustomViewBehind(this.mViewBehind);
        this.mViewBehind.setCustomViewAbove(this.mViewAbove);
        this.mViewAbove.setOnPageChangeListener(new CustomViewAbove.OnPageChangeListener() { // from class: com.slidingmenu.lib.SlidingMenu.1
            public static final int POSITION_CLOSE = 1;
            public static final int POSITION_OPEN = 0;

            @Override // com.slidingmenu.lib.CustomViewAbove.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // com.slidingmenu.lib.CustomViewAbove.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (i2 == 0 && SlidingMenu.this.mOpenListener != null) {
                    SlidingMenu.this.mOpenListener.onOpen();
                } else if (i2 == 1 && SlidingMenu.this.mCloseListener != null) {
                    SlidingMenu.this.mCloseListener.onClose();
                }
            }
        });
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingMenu);
        setMode(obtainStyledAttributes.getInt(0, 0));
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        if (resourceId != -1) {
            setContent(resourceId);
        } else {
            setContent(new FrameLayout(context));
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(2, -1);
        if (resourceId2 != -1) {
            setMenu(resourceId2);
        } else {
            setMenu(new FrameLayout(context));
        }
        setTouchModeAbove(obtainStyledAttributes.getInt(6, 0));
        setTouchModeBehind(obtainStyledAttributes.getInt(7, 0));
        int dimension = (int) obtainStyledAttributes.getDimension(3, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(4, -1.0f);
        if (dimension != -1 && dimension2 != -1) {
            throw new IllegalStateException("Cannot set both behindOffset and behindWidth for a SlidingMenu");
        }
        if (dimension != -1) {
            setBehindOffset(dimension);
        } else if (dimension2 != -1) {
            setBehindWidth(dimension2);
        } else {
            setBehindOffset(0);
        }
        setBehindScrollScale(obtainStyledAttributes.getFloat(5, 0.33f));
        int resourceId3 = obtainStyledAttributes.getResourceId(8, -1);
        if (resourceId3 != -1) {
            setShadowDrawable(resourceId3);
        }
        setShadowWidth((int) obtainStyledAttributes.getDimension(9, 0.0f));
        setFadeEnabled(obtainStyledAttributes.getBoolean(10, true));
        setFadeDegree(obtainStyledAttributes.getFloat(11, 0.33f));
        setSelectorEnabled(obtainStyledAttributes.getBoolean(12, false));
        int resourceId4 = obtainStyledAttributes.getResourceId(13, -1);
        if (resourceId4 != -1) {
            setSelectorDrawable(resourceId4);
        }
        obtainStyledAttributes.recycle();
    }

    public void attachToActivity(Activity activity, int i) {
        attachToActivity(activity, i, false);
    }

    public void attachToActivity(Activity activity, int i, boolean z) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("slideStyle must be either SLIDING_WINDOW or SLIDING_CONTENT");
        }
        if (getParent() != null) {
            throw new IllegalStateException("This SlidingMenu appears to already be attached");
        }
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{16842836});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        switch (i) {
            case 0:
                this.mActionbarOverlay = false;
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
                viewGroup2.setBackgroundResource(resourceId);
                viewGroup.removeView(viewGroup2);
                viewGroup.addView(this);
                setContent(viewGroup2);
                return;
            case 1:
                this.mActionbarOverlay = z;
                ViewGroup viewGroup3 = (ViewGroup) activity.findViewById(16908290);
                View childAt = viewGroup3.getChildAt(0);
                viewGroup3.removeView(childAt);
                viewGroup3.addView(this);
                setContent(childAt);
                if (childAt.getBackground() == null) {
                    childAt.setBackgroundResource(resourceId);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setContent(int i) {
        setContent(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setContent(View view) {
        this.mViewAbove.setContent(view);
        showContent();
    }

    public View getContent() {
        return this.mViewAbove.getContent();
    }

    public void setMenu(int i) {
        setMenu(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setMenu(View view) {
        this.mViewBehind.setContent(view);
    }

    public View getMenu() {
        return this.mViewBehind.getContent();
    }

    public void setSecondaryMenu(int i) {
        setSecondaryMenu(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setSecondaryMenu(View view) {
        this.mViewBehind.setSecondaryContent(view);
    }

    public View getSecondaryMenu() {
        return this.mViewBehind.getSecondaryContent();
    }

    public void setSlidingEnabled(boolean z) {
        this.mViewAbove.setSlidingEnabled(z);
    }

    public boolean isSlidingEnabled() {
        return this.mViewAbove.isSlidingEnabled();
    }

    public void setMode(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalStateException("SlidingMenu mode must be LEFT, RIGHT, or LEFT_RIGHT");
        }
        this.mViewBehind.setMode(i);
    }

    public int getMode() {
        return this.mViewBehind.getMode();
    }

    public void setStatic(boolean z) {
        if (z) {
            setSlidingEnabled(false);
            this.mViewAbove.setCustomViewBehind(null);
            this.mViewAbove.setCurrentItem(1);
            return;
        }
        this.mViewAbove.setCurrentItem(1);
        this.mViewAbove.setCustomViewBehind(this.mViewBehind);
        setSlidingEnabled(true);
    }

    public void showMenu() {
        showMenu(true);
    }

    public void showMenu(boolean z) {
        this.mViewAbove.setCurrentItem(0, z);
    }

    public void showSecondaryMenu() {
        showSecondaryMenu(true);
    }

    public void showSecondaryMenu(boolean z) {
        this.mViewAbove.setCurrentItem(2, z);
    }

    public void showContent() {
        showContent(true);
    }

    public void showContent(boolean z) {
        this.mViewAbove.setCurrentItem(1, z);
    }

    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean z) {
        if (isMenuShowing()) {
            showContent(z);
        } else {
            showMenu(z);
        }
    }

    public boolean isMenuShowing() {
        return this.mViewAbove.getCurrentItem() == 0 || this.mViewAbove.getCurrentItem() == 2;
    }

    public boolean isSecondaryMenuShowing() {
        return this.mViewAbove.getCurrentItem() == 2;
    }

    public int getBehindOffset() {
        return ((RelativeLayout.LayoutParams) this.mViewBehind.getLayoutParams()).rightMargin;
    }

    public void setBehindOffset(int i) {
        this.mViewBehind.setWidthOffset(i);
    }

    public void setBehindOffsetRes(int i) {
        setBehindOffset((int) getContext().getResources().getDimension(i));
    }

    public void setAboveOffset(int i) {
        this.mViewAbove.setAboveOffset(i);
    }

    public void setAboveOffsetRes(int i) {
        setAboveOffset((int) getContext().getResources().getDimension(i));
    }

    public void setBehindWidth(int i) {
        int width;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        try {
            Point point = new Point();
            Display.class.getMethod("getSize", Point.class).invoke(defaultDisplay, point);
            width = point.x;
        } catch (Exception e) {
            width = defaultDisplay.getWidth();
        }
        setBehindOffset(width - i);
    }

    public void setBehindWidthRes(int i) {
        setBehindWidth((int) getContext().getResources().getDimension(i));
    }

    public float getBehindScrollScale() {
        return this.mViewBehind.getScrollScale();
    }

    public int getTouchmodeMarginThreshold() {
        return this.mViewBehind.getMarginThreshold();
    }

    public void setTouchmodeMarginThreshold(int i) {
        this.mViewBehind.setMarginThreshold(i);
    }

    public void setBehindScrollScale(float f) {
        if (f < 0.0f && f > 1.0f) {
            throw new IllegalStateException("ScrollScale must be between 0 and 1");
        }
        this.mViewBehind.setScrollScale(f);
    }

    public void setBehindCanvasTransformer(CanvasTransformer canvasTransformer) {
        this.mViewBehind.setCanvasTransformer(canvasTransformer);
    }

    public int getTouchModeAbove() {
        return this.mViewAbove.getTouchMode();
    }

    public void setTouchModeAbove(int i) {
        if (i != 1 && i != 0 && i != 2) {
            throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
        }
        this.mViewAbove.setTouchMode(i);
    }

    public void setTouchModeBehind(int i) {
        if (i != 1 && i != 0 && i != 2) {
            throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
        }
        this.mViewBehind.setTouchMode(i);
    }

    public void setShadowDrawable(int i) {
        setShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setShadowDrawable(Drawable drawable) {
        this.mViewBehind.setShadowDrawable(drawable);
    }

    public void setSecondaryShadowDrawable(int i) {
        setSecondaryShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setSecondaryShadowDrawable(Drawable drawable) {
        this.mViewBehind.setSecondaryShadowDrawable(drawable);
    }

    public void setShadowWidthRes(int i) {
        setShadowWidth((int) getResources().getDimension(i));
    }

    public void setShadowWidth(int i) {
        this.mViewBehind.setShadowWidth(i);
    }

    public void setFadeEnabled(boolean z) {
        this.mViewBehind.setFadeEnabled(z);
    }

    public void setFadeDegree(float f) {
        this.mViewBehind.setFadeDegree(f);
    }

    public void setSelectorEnabled(boolean z) {
        this.mViewBehind.setSelectorEnabled(true);
    }

    public void setSelectedView(View view) {
        this.mViewBehind.setSelectedView(view);
    }

    public void setSelectorDrawable(int i) {
        this.mViewBehind.setSelectorBitmap(BitmapFactory.decodeResource(getResources(), i));
    }

    public void setSelectorBitmap(Bitmap bitmap) {
        this.mViewBehind.setSelectorBitmap(bitmap);
    }

    public void addIgnoredView(View view) {
        this.mViewAbove.addIgnoredView(view);
    }

    public void removeIgnoredView(View view) {
        this.mViewAbove.removeIgnoredView(view);
    }

    public void clearIgnoredViews() {
        this.mViewAbove.clearIgnoredViews();
    }

    public void setOnOpenListener(OnOpenListener onOpenListener) {
        this.mOpenListener = onOpenListener;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.mCloseListener = onCloseListener;
    }

    public void setOnOpenedListener(OnOpenedListener onOpenedListener) {
        this.mViewAbove.setOnOpenedListener(onOpenedListener);
    }

    public void setOnClosedListener(OnClosedListener onClosedListener) {
        this.mViewAbove.setOnClosedListener(onClosedListener);
    }

    /* loaded from: classes.dex */
    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.slidingmenu.lib.SlidingMenu.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (SavedState) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int mItem;

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.mItem = i;
        }

        /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mItem = parcel.readInt();
        }

        public int getItem() {
            return this.mItem;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mItem);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mViewAbove.getCurrentItem());
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mViewAbove.setCurrentItem(savedState.getItem());
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected boolean fitSystemWindows(Rect rect) {
        int i = rect.left;
        int i2 = rect.right;
        int i3 = rect.top;
        int i4 = rect.bottom;
        if (!this.mActionbarOverlay) {
            Log.v(TAG, "setting padding!");
            setPadding(i, i3, i2, i4);
            return true;
        }
        return true;
    }

    @TargetApi(11)
    public void manageLayers(float f) {
        if (Build.VERSION.SDK_INT >= 11) {
            final int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) > 0 && (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) < 0 ? 2 : 0;
            if (i != getContent().getLayerType()) {
                this.mHandler.post(new Runnable() { // from class: com.slidingmenu.lib.SlidingMenu.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.v(SlidingMenu.TAG, "changing layerType. hardware? " + (i == 2));
                        SlidingMenu.this.getContent().setLayerType(i, null);
                        SlidingMenu.this.getMenu().setLayerType(i, null);
                        if (SlidingMenu.this.getSecondaryMenu() != null) {
                            SlidingMenu.this.getSecondaryMenu().setLayerType(i, null);
                        }
                    }
                });
            }
        }
    }
}
