package com.slidingmenu.lib;

import android.app.Activity;
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
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class SlidingMenu extends RelativeLayout {
    private OnAboveViewScrollListener mAboveViewScrollListener;
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
    public interface OnAboveViewScrollListener {
    }

    /* loaded from: classes.dex */
    public interface OnCloseListener {
    }

    /* loaded from: classes.dex */
    public interface OnClosedListener {
        void onClosed();
    }

    /* loaded from: classes.dex */
    public interface OnOpenListener {
    }

    /* loaded from: classes.dex */
    public interface OnOpenedListener {
        void onOpened();
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

    public void setSettleDuration(int i) {
        this.mViewAbove.setSettleDuration(i);
    }

    public float getPercentOpen() {
        return this.mViewAbove.getPercentOpen();
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

    public void showMenu(boolean z) {
        this.mViewAbove.setCurrentItem(0, z);
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

    public void setAboveCanvasTransformer(CanvasTransformer canvasTransformer) {
        this.mViewAbove.setCanvasTransformer(canvasTransformer);
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

    public void setFadeType(int i) {
        this.mViewBehind.setFadeType(i);
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

    public void setOnAboveViewScrollListener(OnAboveViewScrollListener onAboveViewScrollListener) {
        this.mAboveViewScrollListener = onAboveViewScrollListener;
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.slidingmenu.lib.SlidingMenu.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (SavedState) null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
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
    protected boolean fitSystemWindows(Rect rect) {
        int i = rect.left;
        int i2 = rect.right;
        int i3 = rect.top;
        int i4 = rect.bottom;
        if (!this.mActionbarOverlay) {
            Log.v("SlidingMenu", "setting padding!");
            setPadding(i, i3, i2, i4);
            return true;
        }
        return true;
    }

    public void manageLayers(float f) {
        if (Build.VERSION.SDK_INT >= 11) {
            final int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) > 0 && (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) < 0 ? 2 : 0;
            if (i != getContent().getLayerType()) {
                this.mHandler.post(new Runnable() { // from class: com.slidingmenu.lib.SlidingMenu.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.v("SlidingMenu", "changing layerType. hardware? " + (i == 2));
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
