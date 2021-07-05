package com.kwad.sdk.entry.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.widget.b;
import com.kwad.sdk.contentalliance.widget.e;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class EntryViewPager extends FrameLayout implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.b f37288a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f37289b;

    /* renamed from: c  reason: collision with root package name */
    public b f37290c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37291d;

    /* renamed from: e  reason: collision with root package name */
    public c f37292e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37293f;

    /* loaded from: classes7.dex */
    public class a extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EntryViewPager f37296a;

        /* renamed from: b  reason: collision with root package name */
        public PagerAdapter f37297b;

        public a(EntryViewPager entryViewPager, PagerAdapter pagerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {entryViewPager, pagerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37296a = entryViewPager;
            this.f37297b = pagerAdapter;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull View view, int i2, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, obj) == null) {
                if (obj == this.f37296a.f37289b) {
                    ((ViewGroup) view).removeView(this.f37296a.f37289b);
                } else {
                    this.f37297b.destroyItem(view, i2, obj);
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2, obj) == null) {
                if (obj == this.f37296a.f37289b) {
                    viewGroup.removeView(this.f37296a.f37289b);
                } else {
                    this.f37297b.destroyItem(viewGroup, i2, obj);
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                this.f37297b.finishUpdate(view);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(@NonNull ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
                this.f37297b.finishUpdate(viewGroup);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37297b.getCount() + 1 : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? this.f37297b.getItemPosition(obj) : invokeL.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? this.f37297b.getPageTitle(i2) : (CharSequence) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                if (i2 != getCount() - 1 || this.f37296a.f37289b == null) {
                    return this.f37297b.getPageWidth(i2);
                }
                return 0.12f;
            }
            return invokeI.floatValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2)) == null) {
                if (i2 == getCount() - 1) {
                    ((ViewGroup) view).addView(this.f37296a.f37289b);
                    return this.f37296a.f37289b;
                }
                return this.f37297b.instantiateItem(view, i2);
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, viewGroup, i2)) == null) {
                if (i2 == getCount() - 1) {
                    viewGroup.addView(this.f37296a.f37289b);
                    return this.f37296a.f37289b;
                }
                return this.f37297b.instantiateItem(viewGroup, i2);
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, view, obj)) == null) ? this.f37297b.isViewFromObject(view, obj) : invokeLL.booleanValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.f37297b.notifyDataSetChanged();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, dataSetObserver) == null) {
                this.f37297b.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, parcelable, classLoader) == null) {
                this.f37297b.restoreState(parcelable, classLoader);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public Parcelable saveState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37297b.saveState() : (Parcelable) invokeV.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull View view, int i2, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048591, this, view, i2, obj) == null) {
                this.f37297b.setPrimaryItem(view, i2, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048592, this, viewGroup, i2, obj) == null) {
                this.f37297b.setPrimaryItem(viewGroup, i2, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
                this.f37297b.startUpdate(view);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void startUpdate(@NonNull ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, viewGroup) == null) {
                this.f37297b.startUpdate(viewGroup);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, dataSetObserver) == null) {
                this.f37297b.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EntryViewPager f37298a;

        /* renamed from: b  reason: collision with root package name */
        public float f37299b;

        /* renamed from: c  reason: collision with root package name */
        public float[] f37300c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f37301d;

        public b(EntryViewPager entryViewPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {entryViewPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37298a = entryViewPager;
            this.f37299b = ao.a(this.f37298a.getContext(), 4.0f);
            this.f37300c = new float[8];
            b();
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                setColor(Color.parseColor("#FFF2F2F2"));
                a(ao.a(this.f37298a.getContext(), 12.0f));
                a(Color.parseColor("#9c9c9c"));
                setCornerRadius(this.f37299b);
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37301d : invokeV.booleanValue;
        }

        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                if (f2 <= 0.0f) {
                    a("左\r\n滑\r\n查\r\n看\r\n更\r\n多\r\n视\r\n频");
                    setCornerRadius(this.f37299b);
                    this.f37301d = false;
                    return;
                }
                float f3 = f2 * 4.5f;
                float[] fArr = this.f37300c;
                fArr[0] = f3;
                fArr[1] = f3;
                float f4 = this.f37299b;
                fArr[2] = f4;
                fArr[3] = f4;
                fArr[4] = f4;
                fArr[5] = f4;
                fArr[6] = f3;
                fArr[7] = f3;
                setCornerRadii(fArr);
                this.f37301d = false;
                if (f3 >= (getBounds().height() * 2) / 3) {
                    a("松\r\n开\n查\n看");
                    this.f37301d = true;
                }
                invalidateSelf();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryViewPager(@NonNull Context context) {
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
        this.f37293f = true;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37293f = true;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.kwad.sdk.contentalliance.widget.b bVar = new com.kwad.sdk.contentalliance.widget.b(getContext());
            this.f37288a = bVar;
            if (this.f37293f) {
                bVar.setDragListener(this);
            }
            addView(this.f37288a);
            this.f37289b = new TextView(getContext());
            b bVar2 = new b(this);
            this.f37290c = bVar2;
            bVar2.b(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65540, this, f2) == null) {
            int width = getWidth();
            int top = this.f37288a.getTop();
            int bottom = this.f37288a.getBottom();
            this.f37290c.b(this.f37289b.getWidth());
            this.f37290c.setBounds((int) ((width - f2) - this.f37289b.getWidth()), top, width, bottom);
            this.f37290c.b(f2);
        }
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            b bVar = this.f37290c;
            boolean z = bVar != null && bVar.a();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, z) { // from class: com.kwad.sdk.entry.view.EntryViewPager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f37294a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ EntryViewPager f37295b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37295b = this;
                    this.f37294a = z;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.f37295b.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        if (!this.f37294a || valueAnimator.getAnimatedFraction() < 1.0f || this.f37295b.f37292e == null) {
                            return;
                        }
                        this.f37295b.f37292e.a();
                    }
                }
            });
            ofFloat.start();
        }
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            if (this.f37289b.getRight() <= 0) {
                this.f37291d = false;
            } else if (i2 < this.f37289b.getLeft() - this.f37288a.getMeasuredWidth()) {
                this.f37291d = false;
            } else {
                this.f37291d = true;
                int width = getWidth();
                this.f37290c.setBounds(width - (this.f37288a.getMeasuredWidth() - (this.f37289b.getLeft() - i2)), this.f37288a.getTop(), width, this.f37288a.getBottom());
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.widget.b.a
    public void a(boolean z, int i2, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Float.valueOf(f2)}) == null) && !z && this.f37291d) {
            a(f2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (this.f37291d) {
                this.f37290c.draw(canvas);
            }
            super.dispatchDraw(canvas);
        }
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pagerAdapter) == null) {
            if (this.f37293f) {
                pagerAdapter = new a(this, pagerAdapter);
            }
            this.f37288a.setAdapter(pagerAdapter);
        }
    }

    public void setDragSideEnable(boolean z) {
        com.kwad.sdk.contentalliance.widget.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f37293f = z;
            if (z || (bVar = this.f37288a) == null) {
                return;
            }
            bVar.setDragListener(null);
        }
    }

    public void setOffscreenPageLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f37288a.setOffscreenPageLimit(i2);
        }
    }

    public void setOnDragOpenListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.f37292e = cVar;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onPageChangeListener) == null) {
            this.f37288a.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void setPageMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f37288a.setPageMargin(i2);
        }
    }
}
