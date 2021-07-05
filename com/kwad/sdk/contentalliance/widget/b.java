package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.TranslateAnimation;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b extends ViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f35861a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f35862b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35863c;

    /* renamed from: d  reason: collision with root package name */
    public float f35864d;

    /* renamed from: e  reason: collision with root package name */
    public a f35865e;

    /* renamed from: f  reason: collision with root package name */
    public float f35866f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35867g;

    /* renamed from: h  reason: collision with root package name */
    public float f35868h;

    /* renamed from: i  reason: collision with root package name */
    public float f35869i;
    public float j;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i2, float f2);

        void a(int i2, int i3, int i4, int i5);

        void a(boolean z, int i2, float f2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35861a = 0;
        this.f35862b = new Rect();
        this.f35863c = true;
        this.f35864d = 0.0f;
        this.f35867g = false;
        this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            if (!this.f35862b.isEmpty()) {
                b();
            }
            this.f35864d = -1.0f;
        }
    }

    private void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65538, this, f2) == null) {
            if (this.f35862b.isEmpty()) {
                this.f35862b.set(getLeft(), getTop(), getRight(), getBottom());
            }
            this.f35863c = false;
            int i2 = (int) (f2 * 0.5f);
            layout(getLeft() + i2, getTop(), getRight() + i2, getBottom());
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(getLeft(), this.f35862b.left, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            startAnimation(translateAnimation);
            Rect rect = this.f35862b;
            layout(rect.left, rect.top, rect.right, rect.bottom);
            this.f35862b.setEmpty();
            this.f35863c = true;
            a aVar = this.f35865e;
            if (aVar != null) {
                aVar.a(this.f35861a, this.f35862b.left - getLeft());
            }
        }
    }

    private int getSideEdgeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            if (getScrollX() >= this.f35866f) {
                return 2;
            }
            return this.f35861a == 0 ? 1 : 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f35868h = motionEvent.getRawX();
                this.f35869i = motionEvent.getRawY();
                this.f35867g = false;
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (action == 2 && !this.f35867g) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float f2 = rawX - this.f35868h;
                float f3 = rawY - this.f35869i;
                if (Math.abs(f2) > this.j && Math.abs(f2) > Math.abs(f3)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else if (Math.abs(f3) - Math.abs(f2) > this.j) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                this.f35867g = true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                this.f35861a = getCurrentItem();
                float f2 = 0.0f;
                if (getAdapter() != null) {
                    for (int i2 = 0; i2 < getAdapter().getCount(); i2++) {
                        f2 += getAdapter().getPageWidth(i2);
                    }
                }
                this.f35866f = (f2 - 1.0f) * getMeasuredWidth();
                if (this.f35861a == 0 || getScrollX() >= this.f35866f) {
                    this.f35864d = motionEvent.getX();
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (!z || (aVar = this.f35865e) == null || i2 == this.f35862b.left) {
                return;
            }
            aVar.a(getCurrentItem() == 0, this.f35861a, this.f35862b.left - getLeft());
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            a aVar = this.f35865e;
            if (aVar != null) {
                aVar.a(i2, i3, i4, i5);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if ((getLeft() + r2) != r7.f35862b.left) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        layout(getLeft() + r2, getTop(), getRight() + r2, getBottom());
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0097, code lost:
        if ((getLeft() + r2) >= r7.f35862b.left) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b2, code lost:
        if ((getRight() + r2) <= r7.f35862b.right) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bb A[RETURN] */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1) {
                a();
            } else if (actionMasked == 2) {
                int sideEdgeType = getSideEdgeType();
                if (sideEdgeType > 0 && this.f35864d < 0.0f) {
                    this.f35864d = motionEvent.getX(0);
                }
                if (getAdapter().getCount() == 1) {
                    float x = motionEvent.getX(0);
                    float f2 = x - this.f35864d;
                    this.f35864d = x;
                    if (f2 > 10.0f || f2 < -10.0f) {
                        a(f2);
                    } else if (!this.f35863c) {
                        i2 = (int) (f2 * 0.5f);
                    }
                    if (!this.f35863c) {
                        return true;
                    }
                } else {
                    if (sideEdgeType > 0) {
                        float x2 = motionEvent.getX(0);
                        float f3 = x2 - this.f35864d;
                        this.f35864d = x2;
                        if (sideEdgeType == 1) {
                            if (f3 <= 10.0f) {
                                if (!this.f35863c) {
                                    i2 = (int) (f3 * 0.5f);
                                }
                            }
                            a(f3);
                        } else {
                            if (f3 >= -10.0f) {
                                if (!this.f35863c) {
                                    i2 = (int) (f3 * 0.5f);
                                }
                            }
                            a(f3);
                        }
                    } else {
                        this.f35863c = true;
                    }
                    if (!this.f35863c) {
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setDragListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f35865e = aVar;
        }
    }
}
