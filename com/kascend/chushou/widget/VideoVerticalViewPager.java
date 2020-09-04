package com.kascend.chushou.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kascend.chushou.player.ui.h5.H5Container;
import com.kascend.chushou.widget.guide.PaoGuideView;
import com.kascend.chushou.widget.menu.PlayShowH5View;
import com.kascend.chushou.widget.showplayer.PlayShowRecommendView;
import tv.chushou.zues.widget.viewpager.KasVerticalViewPager;
/* loaded from: classes6.dex */
public class VideoVerticalViewPager extends KasVerticalViewPager {
    private boolean a;
    private int[] alC;
    private int b;
    private float c;
    private float d;
    private boolean e;

    public VideoVerticalViewPager(Context context) {
        super(context);
        this.a = false;
        a(context);
    }

    public VideoVerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        a(context);
    }

    private void a(Context context) {
        this.b = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // tv.chushou.zues.widget.viewpager.KasVerticalViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        Log.d("VerticalViewPager", "onInterceptTouchEvent: mNoFocus:false");
        return false;
    }

    @Override // tv.chushou.zues.widget.viewpager.KasVerticalViewPager
    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (z) {
            if (view instanceof PlayShowRecommendView) {
                if (view.getVisibility() == 0) {
                    return true;
                }
            } else if (view instanceof PlayShowH5View) {
                if (view.getVisibility() == 0) {
                    return true;
                }
            } else if (view instanceof PaoGuideView) {
                if (view.getVisibility() == 0) {
                    return true;
                }
            } else if (view instanceof RecyclerView) {
                if ((view.getTag() instanceof String) && TextUtils.equals("VideoVerticalViewPager", (String) view.getTag()) && view.getVisibility() == 0) {
                    return true;
                }
            } else if (view instanceof H5Container) {
                if (view.getVisibility() == 0) {
                    return true;
                }
            } else if ((view instanceof FrameLayout) && (view.getTag() instanceof String) && TextUtils.equals("VideoVerticalViewPager", (String) view.getTag()) && view.getVisibility() == 0 && ((FrameLayout) view).getChildCount() != 0) {
                return true;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollVertically(-i);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000c A[ORIG_RETURN, RETURN] */
    @Override // tv.chushou.zues.widget.viewpager.KasVerticalViewPager, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.c = motionEvent.getY();
                this.d = motionEvent.getX();
                this.e = false;
                if (this.a) {
                    return super.onTouchEvent(motionEvent);
                }
                return false;
            case 1:
                if (!this.e) {
                    this.e = false;
                    return false;
                }
                this.e = false;
                if (this.a) {
                }
                break;
            case 2:
                if (this.e) {
                    return false;
                }
                float y = motionEvent.getY();
                float abs = Math.abs(motionEvent.getX() - this.d);
                float abs2 = Math.abs(y - this.c);
                if (abs > this.b && abs * 0.5f > abs2) {
                    this.e = true;
                    return false;
                }
                this.e = false;
                if (!this.e) {
                }
                break;
            default:
                if (this.a) {
                }
                break;
        }
    }

    public void setNoFocus(boolean z) {
        this.a = z;
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.alC = iArr;
        }
    }
}
