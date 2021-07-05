package com.kwad.sdk.contentalliance.b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f34300a;
    public static final i al;

    /* renamed from: c  reason: collision with root package name */
    public static final Comparator<C0408b> f34301c;

    /* renamed from: d  reason: collision with root package name */
    public static final Interpolator f34302d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public float I;
    public float J;
    public float K;
    public float L;
    public int M;
    public VelocityTracker N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public EdgeEffectCompat T;
    public EdgeEffectCompat U;
    public boolean V;
    public boolean W;
    public boolean aa;
    public int ab;
    public long ac;
    public List<ViewPager.OnPageChangeListener> ad;
    public ViewPager.OnPageChangeListener ae;
    public e af;
    public f ag;
    public ViewPager.PageTransformer ah;
    public Method ai;
    public int aj;
    public ArrayList<View> ak;
    public final Runnable am;
    public int an;

    /* renamed from: b  reason: collision with root package name */
    public int f34303b;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<C0408b> f34304e;

    /* renamed from: f  reason: collision with root package name */
    public int f34305f;

    /* renamed from: g  reason: collision with root package name */
    public final C0408b f34306g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f34307h;

    /* renamed from: i  reason: collision with root package name */
    public PagerAdapter f34308i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Parcelable n;
    public ClassLoader o;
    public Scroller p;
    public g q;
    public List<DataSetObserver> r;
    public int s;
    public Drawable t;
    public int u;
    public int v;
    public float w;
    public float x;
    public int y;
    public int z;

    /* loaded from: classes7.dex */
    public interface a {
    }

    /* renamed from: com.kwad.sdk.contentalliance.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0408b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Object f34310a;

        /* renamed from: b  reason: collision with root package name */
        public int f34311b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f34312c;

        /* renamed from: d  reason: collision with root package name */
        public float f34313d;

        /* renamed from: e  reason: collision with root package name */
        public float f34314e;

        public C0408b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f34315a;

        /* renamed from: b  reason: collision with root package name */
        public int f34316b;

        /* renamed from: c  reason: collision with root package name */
        public float f34317c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34318d;

        /* renamed from: e  reason: collision with root package name */
        public int f34319e;

        /* renamed from: f  reason: collision with root package name */
        public int f34320f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(-1, -1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34317c = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, AttributeSet attributeSet) {
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
            this.f34317c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f34300a);
            this.f34316b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes7.dex */
    public class d extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f34321a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34321a = bVar;
        }

        private boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.f34321a.f34308i != null && this.f34321a.f34308i.getCount() > 1 : invokeV.booleanValue;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setClassName(ViewPager.class.getName());
                AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
                obtain.setScrollable(a());
                if (accessibilityEvent.getEventType() != 4096 || this.f34321a.f34308i == null) {
                    return;
                }
                obtain.setItemCount(this.f34321a.f34308i.getCount());
                obtain.setFromIndex(this.f34321a.j);
                obtain.setToIndex(this.f34321a.j);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, accessibilityNodeInfoCompat) == null) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
                accessibilityNodeInfoCompat.setScrollable(a());
                if (this.f34321a.d(1)) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
                if (this.f34321a.d(-1)) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            InterceptResult invokeLIL;
            b bVar;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view, i2, bundle)) == null) {
                if (super.performAccessibilityAction(view, i2, bundle)) {
                    return true;
                }
                if (i2 != 4096) {
                    if (i2 != 8192 || !this.f34321a.d(-1)) {
                        return false;
                    }
                    bVar = this.f34321a;
                    i3 = bVar.j - 1;
                } else if (!this.f34321a.d(1)) {
                    return false;
                } else {
                    bVar = this.f34321a;
                    i3 = bVar.j + 1;
                }
                bVar.setCurrentItem(i3);
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes7.dex */
    public class g extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f34322a;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34322a = bVar;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34322a.m();
                this.f34322a.o();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f34322a.m();
                this.f34322a.p();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<h> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f34323a;

        /* renamed from: b  reason: collision with root package name */
        public Parcelable f34324b;

        /* renamed from: c  reason: collision with root package name */
        public ClassLoader f34325c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-373472836, "Lcom/kwad/sdk/contentalliance/b/b$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-373472836, "Lcom/kwad/sdk/contentalliance/b/b$h;");
                    return;
                }
            }
            CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<h>() { // from class: com.kwad.sdk.contentalliance.b.b.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
                /* renamed from: a */
                public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, parcel, classLoader)) == null) ? new h(parcel, classLoader) : (h) invokeLL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
                /* renamed from: a */
                public h[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new h[i2] : (h[]) invokeI.objValue;
                }
            });
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            classLoader = classLoader == null ? h.class.getClassLoader() : classLoader;
            this.f34323a = parcel.readInt();
            this.f34324b = parcel.readParcelable(classLoader);
            this.f34325c = classLoader;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f34323a + "}";
            }
            return (String) invokeV.objValue;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f34323a);
                parcel.writeParcelable(this.f34324b, i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements Comparator<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, view2)) == null) {
                c cVar = (c) view.getLayoutParams();
                c cVar2 = (c) view2.getLayoutParams();
                boolean z = cVar.f34315a;
                return z != cVar2.f34315a ? z ? 1 : -1 : cVar.f34319e - cVar2.f34319e;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-702063808, "Lcom/kwad/sdk/contentalliance/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-702063808, "Lcom/kwad/sdk/contentalliance/b/b;");
                return;
            }
        }
        f34300a = new int[]{16842931};
        f34301c = new Comparator<C0408b>() { // from class: com.kwad.sdk.contentalliance.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(C0408b c0408b, C0408b c0408b2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, c0408b, c0408b2)) == null) ? c0408b.f34311b - c0408b2.f34311b : invokeLL.intValue;
            }
        };
        f34302d = new Interpolator() { // from class: com.kwad.sdk.contentalliance.b.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                InterceptResult invokeF;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeF = interceptable2.invokeF(1048576, this, f2)) == null) {
                    float f3 = f2 - 1.0f;
                    return (f3 * f3 * f3 * f3 * f3) + 1.0f;
                }
                return invokeF.floatValue;
            }
        };
        al = new i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34304e = new ArrayList<>();
        this.f34306g = new C0408b();
        this.f34307h = new Rect();
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = null;
        this.o = null;
        this.w = -3.4028235E38f;
        this.x = Float.MAX_VALUE;
        this.D = 1;
        this.M = -1;
        this.V = true;
        this.W = false;
        this.am = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.b.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34309a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34309a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34309a.setScrollState(0);
                    this.f34309a.n();
                    this.f34309a.c();
                }
            }
        };
        this.an = 0;
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f34304e = new ArrayList<>();
        this.f34306g = new C0408b();
        this.f34307h = new Rect();
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = null;
        this.o = null;
        this.w = -3.4028235E38f;
        this.x = Float.MAX_VALUE;
        this.D = 1;
        this.M = -1;
        this.V = true;
        this.W = false;
        this.am = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.b.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34309a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34309a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34309a.setScrollState(0);
                    this.f34309a.n();
                    this.f34309a.c();
                }
            }
        };
        this.an = 0;
        l();
    }

    private float a(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, motionEvent, i2)) == null) ? (i2 == -1 || motionEvent.getPointerCount() <= i2) ? motionEvent.getX() : MotionEventCompat.getX(motionEvent, i2) : invokeLI.floatValue;
    }

    private Rect a(Rect rect, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, rect, view)) == null) {
            if (rect == null) {
                rect = new Rect();
            }
            if (view == null) {
                rect.set(0, 0, 0, 0);
                return rect;
            }
            rect.left = view.getLeft();
            rect.right = view.getRight();
            rect.top = view.getTop();
            rect.bottom = view.getBottom();
            ViewParent parent = view.getParent();
            while ((parent instanceof ViewGroup) && parent != this) {
                ViewGroup viewGroup = (ViewGroup) parent;
                rect.left += viewGroup.getLeft();
                rect.right += viewGroup.getRight();
                rect.top += viewGroup.getTop();
                rect.bottom += viewGroup.getBottom();
                parent = viewGroup.getParent();
            }
            return rect;
        }
        return (Rect) invokeLL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                if (!((c) getChildAt(i2).getLayoutParams()).f34315a) {
                    removeViewAt(i2);
                    i2--;
                }
                i2++;
            }
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65543, this, i2, i3, i4, i5) == null) {
            if (i3 > 0 && !this.f34304e.isEmpty()) {
                int scrollY = (int) ((getScrollY() / (((i3 - getPaddingTop()) - getPaddingBottom()) + i5)) * (((i2 - getPaddingTop()) - getPaddingBottom()) + i4));
                scrollTo(getScrollX(), scrollY);
                if (this.p.isFinished()) {
                    return;
                }
                this.p.startScroll(0, scrollY, 0, (int) (c(this.j).f34314e * i2), this.p.getDuration() - this.p.timePassed());
                return;
            }
            C0408b c2 = c(this.j);
            int min = (int) ((c2 != null ? Math.min(c2.f34314e, this.x) : 0.0f) * ((i2 - getPaddingTop()) - getPaddingBottom()));
            if (min != getScrollY()) {
                a(false);
                scrollTo(getScrollX(), min);
            }
        }
    }

    private void a(int i2, boolean z, int i3, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            C0408b c2 = c(i2);
            int clientHeight = c2 != null ? (int) (getClientHeight() * Math.max(this.w, Math.min(c2.f34314e, this.x))) : 0;
            if (z) {
                a(0, clientHeight, i3, z3);
                if (z2) {
                    f(i2);
                    return;
                }
                return;
            }
            if (z2) {
                f(i2);
            }
            a(false);
            scrollTo(0, clientHeight);
            h(clientHeight);
            if (!z2 || this.an == 2) {
                return;
            }
            c();
        }
    }

    private void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.M) {
                int i2 = actionIndex == 0 ? 1 : 0;
                this.J = b(motionEvent, i2);
                this.M = MotionEventCompat.getPointerId(motionEvent, i2);
                VelocityTracker velocityTracker = this.N;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    private void a(C0408b c0408b, int i2, C0408b c0408b2) {
        int i3;
        int i4;
        C0408b c0408b3;
        C0408b c0408b4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65546, this, c0408b, i2, c0408b2) == null) {
            int count = this.f34308i.getCount();
            int clientHeight = getClientHeight();
            float f2 = clientHeight > 0 ? this.s / clientHeight : 0.0f;
            if (c0408b2 != null) {
                int i5 = c0408b2.f34311b;
                int i6 = c0408b.f34311b;
                if (i5 < i6) {
                    float f3 = c0408b2.f34314e + c0408b2.f34313d + f2;
                    int i7 = i5 + 1;
                    int i8 = 0;
                    while (i7 <= c0408b.f34311b && i8 < this.f34304e.size()) {
                        while (true) {
                            c0408b4 = this.f34304e.get(i8);
                            if (i7 <= c0408b4.f34311b || i8 >= this.f34304e.size() - 1) {
                                break;
                            }
                            i8++;
                        }
                        while (i7 < c0408b4.f34311b) {
                            f3 += this.f34308i.getPageWidth(i7) + f2;
                            i7++;
                        }
                        c0408b4.f34314e = f3;
                        f3 += c0408b4.f34313d + f2;
                        i7++;
                    }
                } else if (i5 > i6) {
                    int size = this.f34304e.size() - 1;
                    float f4 = c0408b2.f34314e;
                    while (true) {
                        i5--;
                        if (i5 < c0408b.f34311b || size < 0) {
                            break;
                        }
                        while (true) {
                            c0408b3 = this.f34304e.get(size);
                            if (i5 >= c0408b3.f34311b || size <= 0) {
                                break;
                            }
                            size--;
                        }
                        while (i5 > c0408b3.f34311b) {
                            f4 -= this.f34308i.getPageWidth(i5) + f2;
                            i5--;
                        }
                        f4 -= c0408b3.f34313d + f2;
                        c0408b3.f34314e = f4;
                    }
                }
            }
            int size2 = this.f34304e.size();
            float f5 = c0408b.f34314e;
            int i9 = c0408b.f34311b;
            int i10 = i9 - 1;
            this.w = i9 == 0 ? f5 : -3.4028235E38f;
            int i11 = count - 1;
            this.x = c0408b.f34311b == i11 ? (c0408b.f34314e + c0408b.f34313d) - 1.0f : Float.MAX_VALUE;
            int i12 = i2 - 1;
            while (i12 >= 0) {
                C0408b c0408b5 = this.f34304e.get(i12);
                while (true) {
                    i4 = c0408b5.f34311b;
                    if (i10 <= i4) {
                        break;
                    }
                    f5 -= this.f34308i.getPageWidth(i10) + f2;
                    i10--;
                }
                f5 -= c0408b5.f34313d + f2;
                c0408b5.f34314e = f5;
                if (i4 == 0) {
                    this.w = f5;
                }
                i12--;
                i10--;
            }
            float f6 = c0408b.f34314e + c0408b.f34313d + f2;
            int i13 = c0408b.f34311b + 1;
            int i14 = i2 + 1;
            while (i14 < size2) {
                C0408b c0408b6 = this.f34304e.get(i14);
                while (true) {
                    i3 = c0408b6.f34311b;
                    if (i13 >= i3) {
                        break;
                    }
                    f6 += this.f34308i.getPageWidth(i13) + f2;
                    i13++;
                }
                if (i3 == i11) {
                    this.x = (c0408b6.f34313d + f6) - 1.0f;
                }
                c0408b6.f34314e = f6;
                f6 += c0408b6.f34313d + f2;
                i14++;
                i13++;
            }
            this.W = false;
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
            boolean z2 = this.an == 2;
            if (z2) {
                setScrollingCacheEnabled(false);
                this.p.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.p.getCurrX();
                int currY = this.p.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                }
            }
            this.C = false;
            for (int i2 = 0; i2 < this.f34304e.size(); i2++) {
                C0408b c0408b = this.f34304e.get(i2);
                if (c0408b.f34312c) {
                    c0408b.f34312c = false;
                    z2 = true;
                }
            }
            if (z2) {
                if (z) {
                    ViewCompat.postOnAnimation(this, this.am);
                } else {
                    this.am.run();
                }
            }
        }
    }

    private boolean a(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (f2 < ((float) this.H) && f3 > 0.0f) || (f2 > ((float) (getHeight() - this.H)) && f3 < 0.0f) : invokeCommon.booleanValue;
    }

    private float b(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65550, this, motionEvent, i2)) == null) ? (i2 == -1 || motionEvent.getPointerCount() <= i2) ? motionEvent.getY() : MotionEventCompat.getY(motionEvent, i2) : invokeLI.floatValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || this.aj == 0) {
            return;
        }
        ArrayList<View> arrayList = this.ak;
        if (arrayList == null) {
            this.ak = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.ak.add(getChildAt(i2));
        }
        Collections.sort(this.ak, al);
    }

    private void b(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            List<ViewPager.OnPageChangeListener> list = this.ad;
            if (list != null) {
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ViewPager.OnPageChangeListener onPageChangeListener = this.ad.get(i4);
                    if (onPageChangeListener != null) {
                        onPageChangeListener.onPageScrolled(i2, f2, i3);
                    }
                }
            }
            ViewPager.OnPageChangeListener onPageChangeListener2 = this.ae;
            if (onPageChangeListener2 != null) {
                onPageChangeListener2.onPageScrolled(i2, f2, i3);
            }
        }
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, this, z) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ViewCompat.setLayerType(getChildAt(i2), z ? 2 : 0, null);
            }
        }
    }

    private void c(boolean z) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65555, this, z) == null) || (parent = getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(z);
    }

    private C0408b d() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            int clientHeight = getClientHeight();
            float f2 = 0.0f;
            float scrollY = clientHeight > 0 ? getScrollY() / clientHeight : 0.0f;
            float f3 = clientHeight > 0 ? this.s / clientHeight : 0.0f;
            C0408b c0408b = null;
            float f4 = 0.0f;
            int i3 = -1;
            int i4 = 0;
            boolean z = true;
            while (i4 < this.f34304e.size()) {
                C0408b c0408b2 = this.f34304e.get(i4);
                if (!z && c0408b2.f34311b != (i2 = i3 + 1)) {
                    c0408b2 = this.f34306g;
                    c0408b2.f34314e = f2 + f4 + f3;
                    c0408b2.f34311b = i2;
                    c0408b2.f34313d = this.f34308i.getPageWidth(i2);
                    i4--;
                }
                f2 = c0408b2.f34314e;
                float f5 = c0408b2.f34313d + f2 + f3;
                if (!z && scrollY < f2) {
                    return c0408b;
                }
                if (scrollY < f5 || i4 == this.f34304e.size() - 1) {
                    return c0408b2;
                }
                i3 = c0408b2.f34311b;
                f4 = c0408b2.f34313d;
                i4++;
                c0408b = c0408b2;
                z = false;
            }
            return c0408b;
        }
        return (C0408b) invokeV.objValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            this.E = false;
            this.F = false;
            VelocityTracker velocityTracker = this.N;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.N = null;
            }
        }
    }

    private void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, this, i2) == null) {
            List<ViewPager.OnPageChangeListener> list = this.ad;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ViewPager.OnPageChangeListener onPageChangeListener = this.ad.get(i3);
                    if (onPageChangeListener != null) {
                        onPageChangeListener.onPageSelected(i2);
                    }
                }
            }
            ViewPager.OnPageChangeListener onPageChangeListener2 = this.ae;
            if (onPageChangeListener2 != null) {
                onPageChangeListener2.onPageSelected(i2);
            }
        }
    }

    private void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65559, this, i2) == null) {
            List<ViewPager.OnPageChangeListener> list = this.ad;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ViewPager.OnPageChangeListener onPageChangeListener = this.ad.get(i3);
                    if (onPageChangeListener != null) {
                        onPageChangeListener.onPageScrollStateChanged(i2);
                    }
                }
            }
            ViewPager.OnPageChangeListener onPageChangeListener2 = this.ae;
            if (onPageChangeListener2 != null) {
                onPageChangeListener2.onPageScrollStateChanged(i2);
            }
        }
    }

    private int getClientHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) ? (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom() : invokeV.intValue;
    }

    private boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65561, this, i2)) == null) {
            if (this.f34304e.size() == 0) {
                this.aa = false;
                a(0, 0.0f, 0);
                if (this.aa) {
                    return false;
                }
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            C0408b d2 = d();
            int clientHeight = getClientHeight();
            int i3 = this.s;
            int i4 = clientHeight + i3;
            float f2 = clientHeight;
            int i5 = d2.f34311b;
            float f3 = ((i2 / f2) - d2.f34314e) / (d2.f34313d + (i3 / f2));
            this.aa = false;
            a(i5, f3, (int) (i4 * f3));
            if (this.aa) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65563, this, i2) == null) || this.an == i2) {
            return;
        }
        this.an = i2;
        if (this.ah != null) {
            b(i2 != 0);
        }
        g(i2);
    }

    private void setScrollingCacheEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65564, this, z) == null) || this.B == z) {
            return;
        }
        this.B = z;
    }

    public float a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (float) Math.sin((float) ((f2 - 0.5f) * 0.4712389167638204d)) : invokeF.floatValue;
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 : invokeI.intValue;
    }

    public int a(int i2, float f2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (Math.abs(i4) <= this.Q || Math.abs(i3) <= this.O) {
                i2 = (int) (i2 + f2 + (i2 >= this.j ? 0.4f : 0.6f));
            } else if (i3 <= 0) {
                i2++;
            }
            if (this.f34304e.size() > 0) {
                ArrayList<C0408b> arrayList = this.f34304e;
                return Math.max(this.f34304e.get(0).f34311b, Math.min(i2, arrayList.get(arrayList.size() - 1).f34311b));
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public C0408b a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            C0408b c0408b = new C0408b();
            c0408b.f34311b = i2;
            c0408b.f34310a = this.f34308i.instantiateItem((ViewGroup) this, i2);
            c0408b.f34313d = this.f34308i.getPageWidth(i2);
            if (i3 < 0 || i3 >= this.f34304e.size()) {
                this.f34304e.add(c0408b);
            } else {
                this.f34304e.add(i3, c0408b);
            }
            return c0408b;
        }
        return (C0408b) invokeII.objValue;
    }

    public C0408b a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            for (int i2 = 0; i2 < this.f34304e.size(); i2++) {
                C0408b c0408b = this.f34304e.get(i2);
                if (this.f34308i.isViewFromObject(view, c0408b.f34310a)) {
                    return c0408b;
                }
            }
            return null;
        }
        return (C0408b) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i2, float f2, int i3) {
        int max;
        int i4;
        int top;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            if (this.ab > 0) {
                int scrollY = getScrollY();
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int childCount = getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    c cVar = (c) childAt.getLayoutParams();
                    if (cVar.f34315a) {
                        int i6 = cVar.f34316b & 112;
                        if (i6 != 16) {
                            if (i6 == 48) {
                                i4 = childAt.getHeight() + paddingTop;
                            } else if (i6 != 80) {
                                i4 = paddingTop;
                            } else {
                                max = (height - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            top = (paddingTop + scrollY) - childAt.getTop();
                            if (top != 0) {
                                childAt.offsetTopAndBottom(top);
                            }
                            paddingTop = i4;
                        } else {
                            max = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i7 = max;
                        i4 = paddingTop;
                        paddingTop = i7;
                        top = (paddingTop + scrollY) - childAt.getTop();
                        if (top != 0) {
                        }
                        paddingTop = i4;
                    }
                }
            }
            b(i2, f2, i3);
            if (this.ah != null) {
                int scrollY2 = getScrollY();
                int childCount2 = getChildCount();
                for (int i8 = 0; i8 < childCount2; i8++) {
                    View childAt2 = getChildAt(i8);
                    if (!((c) childAt2.getLayoutParams()).f34315a) {
                        this.ah.transformPage(childAt2, (childAt2.getTop() - scrollY2) / getClientHeight());
                    }
                }
            }
            this.aa = true;
        }
    }

    public void a(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int i5 = i2 - scrollX;
            int i6 = i3 - scrollY;
            if (i5 == 0 && i6 == 0) {
                a(false);
                n();
                if (z) {
                    c();
                }
                setScrollState(0);
                return;
            }
            setScrollingCacheEnabled(true);
            setScrollState(2);
            int clientHeight = getClientHeight();
            int i7 = clientHeight / 2;
            float f2 = clientHeight;
            float f3 = i7;
            float a2 = f3 + (a(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
            int abs = Math.abs(i4);
            this.p.startScroll(scrollX, scrollY, i5, i6, Math.min(abs > 0 ? Math.round(Math.abs(a2 / abs) * 1000.0f) * 4 : ((int) (((Math.abs(i6) / ((f2 * this.f34308i.getPageWidth(this.j)) + this.s)) + 1.0f) * 100.0f)) * 2, 600));
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            com.kwad.sdk.core.d.a.b("VerticalViewPager", "setCurrentItem item=" + i2 + " smoothScroll=" + z);
            this.C = false;
            a(i2, z, false);
        }
    }

    public void a(int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            a(i2, z, z2, 0);
        }
    }

    public void a(int i2, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            a(i2, z, z2, i3, false);
        }
    }

    public void a(int i2, boolean z, boolean z2, int i3, boolean z3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            PagerAdapter pagerAdapter = this.f34308i;
            if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
                setScrollingCacheEnabled(false);
            } else if (z2 || this.j != i2 || this.f34304e.size() == 0) {
                if (i2 < 0) {
                    i4 = 0;
                } else {
                    if (i2 >= this.f34308i.getCount()) {
                        i2 = this.f34308i.getCount() - 1;
                    }
                    i4 = i2;
                }
                int i5 = this.D;
                int i6 = this.j;
                if (i4 > i6 + i5 || i4 < i6 - i5) {
                    for (int i7 = 0; i7 < this.f34304e.size(); i7++) {
                        this.f34304e.get(i7).f34312c = true;
                    }
                }
                boolean z4 = this.j != i4;
                if (!this.V) {
                    b(i4);
                    a(i4, z, i3, z4, z3);
                    return;
                }
                this.k = i4;
                this.j = i4;
                if (z4) {
                    f(i4);
                }
                requestLayout();
            } else {
                setScrollingCacheEnabled(false);
            }
        }
    }

    public void a(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dataSetObserver) == null) {
            if (this.r == null) {
                this.r = new ArrayList();
            }
            this.r.add(dataSetObserver);
        }
    }

    public void a(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onPageChangeListener) == null) {
            if (this.ad == null) {
                this.ad = new ArrayList();
            }
            this.ad.add(onPageChangeListener);
        }
    }

    public boolean a(KeyEvent keyEvent) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, keyEvent)) == null) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 21) {
                    i2 = 17;
                } else if (keyCode == 22) {
                    i2 = 66;
                } else if (keyCode == 61 && Build.VERSION.SDK_INT >= 11) {
                    if (keyEvent.hasNoModifiers()) {
                        i2 = 2;
                    } else if (keyEvent.hasModifiers(1)) {
                        return e(1);
                    }
                }
                return e(i2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean a(View view, boolean z, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (childAt.isEnabled() && childAt.getVisibility() == 0 && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && (i6 = i3 + scrollX) >= childAt.getLeft() && i6 < childAt.getRight() && a(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
            return z && ViewCompat.canScrollVertically(view, -i2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        C0408b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, arrayList, i2, i3) == null) {
            int size = arrayList.size();
            int descendantFocusability = getDescendantFocusability();
            if (descendantFocusability != 393216) {
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f34311b == this.j) {
                        childAt.addFocusables(arrayList, i2, i3);
                    }
                }
            }
            if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
                if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                    return;
                }
                arrayList.add(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        C0408b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f34311b == this.j) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048593, this, view, i2, layoutParams) == null) {
            if (!checkLayoutParams(layoutParams)) {
                layoutParams = generateLayoutParams(layoutParams);
            }
            c cVar = (c) layoutParams;
            boolean z = cVar.f34315a | (view instanceof a);
            cVar.f34315a = z;
            if (!this.A) {
                if (view.getParent() instanceof ViewGroup) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                super.addView(view, i2, layoutParams);
            } else if (cVar != null && z) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            } else {
                cVar.f34318d = true;
                addViewInLayout(view, i2, layoutParams);
            }
        }
    }

    public C0408b b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048594, this, view)) != null) {
            return (C0408b) invokeL.objValue;
        }
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
        if (r11 == r12) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d5, code lost:
        if (r1 >= 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e3, code lost:
        if (r1 >= 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f1, code lost:
        if (r1 >= 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f3, code lost:
        r11 = r17.f34304e.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00fc, code lost:
        r11 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(int i2) {
        int i3;
        C0408b c0408b;
        String hexString;
        C0408b c0408b2;
        C0408b a2;
        C0408b c0408b3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            int i4 = this.j;
            if (i4 != i2) {
                i3 = i4 < i2 ? IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER : 33;
                c0408b = c(this.j);
                int i5 = this.j;
                if (i5 != i2) {
                    this.k = i5;
                }
                this.j = i2;
            } else {
                i3 = 2;
                c0408b = null;
            }
            if (this.f34308i == null) {
                b();
            } else if (this.C) {
                b();
            } else if (getWindowToken() != null) {
                this.f34308i.startUpdate((ViewGroup) this);
                int i6 = this.D;
                int max = Math.max(0, this.j - i6);
                int count = this.f34308i.getCount();
                int min = Math.min(count - 1, this.j + i6);
                if (count != this.f34303b) {
                    try {
                        hexString = getResources().getResourceName(getId());
                    } catch (Resources.NotFoundException unused) {
                        hexString = Integer.toHexString(getId());
                    }
                    throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f34303b + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.f34308i.getClass());
                }
                int i7 = 0;
                while (true) {
                    if (i7 >= this.f34304e.size()) {
                        break;
                    }
                    c0408b2 = this.f34304e.get(i7);
                    int i8 = c0408b2.f34311b;
                    int i9 = this.j;
                    if (i8 < i9) {
                        i7++;
                    }
                }
                c0408b2 = null;
                if (c0408b2 == null && count > 0) {
                    c0408b2 = a(this.j, i7);
                }
                if (c0408b2 != null && i6 > 0) {
                    int i10 = i7 - 1;
                    C0408b c0408b4 = i10 >= 0 ? this.f34304e.get(i10) : null;
                    int clientHeight = getClientHeight();
                    float paddingLeft = clientHeight <= 0 ? 0.0f : (2.0f - c0408b2.f34313d) + (getPaddingLeft() / clientHeight);
                    float f2 = 0.0f;
                    for (int i11 = this.j - 1; i11 >= 0; i11--) {
                        if (f2 < paddingLeft || i11 >= max) {
                            if (c0408b4 == null || i11 != c0408b4.f34311b) {
                                f2 += a(i11, i10 + 1).f34313d;
                                i7++;
                            } else {
                                f2 += c0408b4.f34313d;
                                i10--;
                            }
                        } else if (c0408b4 == null) {
                            break;
                        } else {
                            if (i11 == c0408b4.f34311b && !c0408b4.f34312c) {
                                this.f34304e.remove(i10);
                                this.f34308i.destroyItem((ViewGroup) this, i11, c0408b4.f34310a);
                                i10--;
                                i7--;
                            }
                        }
                        c0408b4 = c0408b3;
                    }
                    float f3 = c0408b2.f34313d;
                    int i12 = i7 + 1;
                    if (f3 < 2.0f) {
                        C0408b c0408b5 = i12 < this.f34304e.size() ? this.f34304e.get(i12) : null;
                        float paddingRight = clientHeight <= 0 ? 0.0f : (getPaddingRight() / clientHeight) + 2.0f;
                        int i13 = this.j;
                        while (true) {
                            i13++;
                            if (i13 >= count) {
                                break;
                            } else if (f3 < paddingRight || i13 <= min) {
                                if (c0408b5 == null || i13 != c0408b5.f34311b) {
                                    C0408b a3 = a(i13, i12);
                                    i12++;
                                    f3 += a3.f34313d;
                                    c0408b5 = i12 < this.f34304e.size() ? this.f34304e.get(i12) : null;
                                } else {
                                    f3 += c0408b5.f34313d;
                                    i12++;
                                    if (i12 < this.f34304e.size()) {
                                    }
                                }
                            } else if (c0408b5 == null) {
                                break;
                            } else if (i13 == c0408b5.f34311b && !c0408b5.f34312c) {
                                this.f34304e.remove(i12);
                                this.f34308i.destroyItem((ViewGroup) this, i13, c0408b5.f34310a);
                                if (i12 < this.f34304e.size()) {
                                }
                            }
                        }
                    }
                    a(c0408b2, i7, c0408b);
                }
                this.f34308i.setPrimaryItem((ViewGroup) this, this.j, c0408b2 != null ? c0408b2.f34310a : null);
                this.f34308i.finishUpdate((ViewGroup) this);
                int childCount = getChildCount();
                for (int i14 = 0; i14 < childCount; i14++) {
                    View childAt = getChildAt(i14);
                    c cVar = (c) childAt.getLayoutParams();
                    cVar.f34320f = i14;
                    if (!cVar.f34315a && cVar.f34317c == 0.0f && (a2 = a(childAt)) != null) {
                        cVar.f34317c = a2.f34313d;
                        cVar.f34319e = a2.f34311b;
                    }
                }
                b();
                if (hasFocus()) {
                    View findFocus = findFocus();
                    C0408b b2 = findFocus != null ? b(findFocus) : null;
                    if (b2 == null || b2.f34311b != this.j) {
                        for (int i15 = 0; i15 < getChildCount(); i15++) {
                            View childAt2 = getChildAt(i15);
                            C0408b a4 = a(childAt2);
                            if (a4 != null && a4.f34311b == this.j && childAt2.requestFocus(i3)) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public void b(DataSetObserver dataSetObserver) {
        List<DataSetObserver> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, dataSetObserver) == null) || (list = this.r) == null) {
            return;
        }
        list.remove(dataSetObserver);
    }

    public void b(ViewPager.OnPageChangeListener onPageChangeListener) {
        List<ViewPager.OnPageChangeListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, onPageChangeListener) == null) || (list = this.ad) == null) {
            return;
        }
        list.remove(onPageChangeListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(float f2) {
        InterceptResult invokeF;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048598, this, f2)) == null) {
            float f3 = this.J - f2;
            this.J = f2;
            float scrollY = getScrollY() + f3;
            float clientHeight = getClientHeight();
            float f4 = this.w * clientHeight;
            float f5 = this.x * clientHeight;
            boolean z3 = true;
            if (this.f34304e.size() > 0) {
                C0408b c0408b = this.f34304e.get(0);
                ArrayList<C0408b> arrayList = this.f34304e;
                C0408b c0408b2 = arrayList.get(arrayList.size() - 1);
                if (c0408b.f34311b != 0) {
                    f4 = c0408b.f34314e * clientHeight;
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (c0408b2.f34311b != this.f34308i.getCount() - 1) {
                    f5 = c0408b2.f34314e * clientHeight;
                    z3 = z2;
                    z = false;
                    if (scrollY >= f4) {
                        r5 = z3 ? this.T.onPull(Math.abs(f4 - scrollY) / clientHeight) : false;
                        scrollY = f4;
                    } else if (scrollY > f5) {
                        r5 = z ? this.U.onPull(Math.abs(scrollY - f5) / clientHeight) : false;
                        scrollY = f5;
                    }
                    int i2 = (int) scrollY;
                    this.I += scrollY - i2;
                    int a2 = a(i2);
                    scrollTo(getScrollX(), a2);
                    h(a(a2));
                    return r5;
                }
                z3 = z2;
            }
            z = true;
            if (scrollY >= f4) {
            }
            int i22 = (int) scrollY;
            this.I += scrollY - i22;
            int a22 = a(i22);
            scrollTo(getScrollX(), a22);
            h(a(a22));
            return r5;
        }
        return invokeF.booleanValue;
    }

    public C0408b c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            for (int i3 = 0; i3 < this.f34304e.size(); i3++) {
                C0408b c0408b = this.f34304e.get(i3);
                if (c0408b.f34311b == i2) {
                    return c0408b;
                }
            }
            return null;
        }
        return (C0408b) invokeI.objValue;
    }

    public void c() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (fVar = this.ag) == null) {
            return;
        }
        fVar.a();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, layoutParams)) == null) ? (layoutParams instanceof c) && super.checkLayoutParams(layoutParams) : invokeL.booleanValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.p.isFinished() || !this.p.computeScrollOffset()) {
                a(true);
                return;
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.p.getCurrX();
            int currY = this.p.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!h(currY)) {
                    this.p.abortAnimation();
                    scrollTo(currX, 0);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            if (this.f34308i == null) {
                return false;
            }
            int clientHeight = getClientHeight();
            int scrollY = getScrollY();
            return i2 < 0 ? scrollY > ((int) (((float) clientHeight) * this.w)) : i2 > 0 && scrollY < ((int) (((float) clientHeight) * this.x));
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, keyEvent)) == null) ? super.dispatchKeyEvent(keyEvent) || a(keyEvent) : invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        C0408b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, accessibilityEvent)) == null) {
            if (accessibilityEvent.getEventType() == 4096) {
                return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f34311b == this.j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, canvas) == null) {
            super.draw(canvas);
            int overScrollMode = ViewCompat.getOverScrollMode(this);
            boolean z = false;
            if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.f34308i) != null && pagerAdapter.getCount() > 1)) {
                if (!this.T.isFinished()) {
                    int save = canvas.save();
                    int height = getHeight();
                    int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    canvas.translate(getPaddingLeft(), this.w * height);
                    this.T.setSize(width, height);
                    z = false | this.T.draw(canvas);
                    canvas.restoreToCount(save);
                }
                if (!this.U.isFinished()) {
                    int save2 = canvas.save();
                    int height2 = getHeight();
                    int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    canvas.rotate(180.0f);
                    canvas.translate((-width2) - getPaddingLeft(), (-(this.x + 1.0f)) * height2);
                    this.U.setSize(width2, height2);
                    z |= this.U.draw(canvas);
                    canvas.restoreToCount(save2);
                }
            } else {
                this.T.finish();
                this.U.finish();
            }
            if (z) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.t;
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            drawable.setState(getDrawableState());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(int i2) {
        InterceptResult invokeI;
        boolean z;
        View findNextFocus;
        boolean r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            View findFocus = findFocus();
            boolean z2 = false;
            if (findFocus != this) {
                if (findFocus != null) {
                    ViewParent parent = findFocus.getParent();
                    while (true) {
                        if (!(parent instanceof ViewGroup)) {
                            z = false;
                            break;
                        } else if (parent == this) {
                            z = true;
                            break;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                    if (!z) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(findFocus.getClass().getSimpleName());
                        for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                            sb.append(" => ");
                            sb.append(parent2.getClass().getSimpleName());
                        }
                        com.kwad.sdk.core.d.a.a("VerticalViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    }
                }
                findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
                if (findNextFocus != null || findNextFocus == findFocus) {
                    if (i2 != 33 || i2 == 1) {
                        z2 = q();
                    } else if (i2 == 130 || i2 == 2) {
                        z2 = r();
                    }
                } else if (i2 == 33) {
                    int i3 = a(this.f34307h, findNextFocus).top;
                    int i4 = a(this.f34307h, findFocus).top;
                    if (findFocus != null && i3 >= i4) {
                        r = q();
                        z2 = r;
                    }
                    r = findNextFocus.requestFocus();
                    z2 = r;
                } else if (i2 == 130) {
                    int i5 = a(this.f34307h, findNextFocus).bottom;
                    int i6 = a(this.f34307h, findFocus).bottom;
                    if (findFocus != null && i5 <= i6) {
                        r = r();
                        z2 = r;
                    }
                    r = findNextFocus.requestFocus();
                    z2 = r;
                }
                if (z2) {
                    playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
                }
                return z2;
            }
            findFocus = null;
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
            if (findNextFocus != null) {
            }
            if (i2 != 33) {
            }
            z2 = q();
            if (z2) {
            }
            return z2;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? new c() : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, attributeSet)) == null) ? new c(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, layoutParams)) == null) ? generateDefaultLayoutParams() : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public PagerAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f34308i : (PagerAdapter) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048613, this, i2, i3)) == null) {
            if (this.aj == 2) {
                i3 = (i2 - 1) - i3;
            }
            return ((c) this.ak.get(i3).getLayoutParams()).f34320f;
        }
        return invokeII.intValue;
    }

    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.j : invokeV.intValue;
    }

    public int getOffscreenPageLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.D : invokeV.intValue;
    }

    public int getPageMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.s : invokeV.intValue;
    }

    public int getPreItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.k : invokeV.intValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            setWillNotDraw(false);
            setDescendantFocusability(262144);
            setFocusable(true);
            Context context = getContext();
            this.p = new Scroller(context, f34302d);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            float f2 = context.getResources().getDisplayMetrics().density;
            this.f34305f = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
            this.O = (int) (400.0f * f2);
            this.P = viewConfiguration.getScaledMaximumFlingVelocity();
            this.T = new EdgeEffectCompat(context);
            this.U = new EdgeEffectCompat(context);
            this.Q = (int) (25.0f * f2);
            this.R = (int) (2.0f * f2);
            this.G = (int) (f2 * 16.0f);
            ViewCompat.setAccessibilityDelegate(this, new d(this));
            if (ViewCompat.getImportantForAccessibility(this) == 0) {
                ViewCompat.setImportantForAccessibility(this, 1);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            int count = this.f34308i.getCount();
            this.f34303b = count;
            boolean z = this.f34304e.size() < (this.D * 2) + 1 && this.f34304e.size() < count;
            int i2 = this.j;
            int i3 = 0;
            boolean z2 = false;
            while (i3 < this.f34304e.size()) {
                C0408b c0408b = this.f34304e.get(i3);
                int itemPosition = this.f34308i.getItemPosition(c0408b);
                if (itemPosition != -1) {
                    if (itemPosition == -2) {
                        this.f34304e.remove(i3);
                        i3--;
                        if (!z2) {
                            this.f34308i.startUpdate((ViewGroup) this);
                            z2 = true;
                        }
                        this.f34308i.destroyItem((ViewGroup) this, c0408b.f34311b, c0408b.f34310a);
                        int i4 = this.j;
                        if (i4 == c0408b.f34311b) {
                            i2 = Math.max(0, Math.min(i4, count - 1));
                        }
                    } else {
                        int i5 = c0408b.f34311b;
                        if (i5 != itemPosition) {
                            if (i5 == this.j) {
                                i2 = itemPosition;
                            }
                            c0408b.f34311b = itemPosition;
                        }
                    }
                    z = true;
                }
                i3++;
            }
            if (z2) {
                this.f34308i.finishUpdate((ViewGroup) this);
            }
            Collections.sort(this.f34304e, f34301c);
            if (z) {
                int childCount = getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    c cVar = (c) getChildAt(i6).getLayoutParams();
                    if (!cVar.f34315a) {
                        cVar.f34317c = 0.0f;
                    }
                }
                a(i2, false, true);
                requestLayout();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            b(this.j);
        }
    }

    public void o() {
        List<DataSetObserver> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (list = this.r) == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            DataSetObserver dataSetObserver = this.r.get(i2);
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onAttachedToWindow();
            this.V = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            com.kwad.sdk.core.d.a.b("VerticalViewPager", "onDetachedFromWindow");
            removeCallbacks(this.am);
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int height;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.s <= 0 || this.t == null || this.f34304e.size() <= 0 || this.f34308i == null) {
                return;
            }
            int scrollY = getScrollY();
            float height2 = getHeight();
            float f4 = this.s / height2;
            int i2 = 0;
            C0408b c0408b = this.f34304e.get(0);
            float f5 = c0408b.f34314e;
            int size = this.f34304e.size();
            int i3 = c0408b.f34311b;
            int i4 = this.f34304e.get(size - 1).f34311b;
            while (i3 < i4) {
                while (i3 > c0408b.f34311b && i2 < size) {
                    i2++;
                    c0408b = this.f34304e.get(i2);
                }
                if (i3 == c0408b.f34311b) {
                    float f6 = c0408b.f34314e;
                    float f7 = c0408b.f34313d;
                    f2 = (f6 + f7) * height2;
                    f5 = f6 + f7 + f4;
                } else {
                    float pageWidth = this.f34308i.getPageWidth(i3);
                    f2 = (f5 + pageWidth) * height2;
                    f5 += pageWidth + f4;
                }
                int i5 = this.s;
                if (i5 + f2 > scrollY) {
                    f3 = f4;
                    this.t.setBounds(this.u, (int) f2, this.v, (int) (i5 + f2 + 0.5f));
                    this.t.draw(canvas);
                } else {
                    f3 = f4;
                }
                if (f2 > scrollY + height) {
                    return;
                }
                i3++;
                f4 = f3;
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 3 || action == 1) {
                this.E = false;
                this.F = false;
                this.M = -1;
                VelocityTracker velocityTracker = this.N;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.N = null;
                }
                return false;
            }
            if (action != 0) {
                if (this.E) {
                    return true;
                }
                if (this.F) {
                    return false;
                }
            }
            if (action == 0) {
                float x = motionEvent.getX();
                this.K = x;
                this.I = x;
                float y = motionEvent.getY();
                this.L = y;
                this.J = y;
                this.M = MotionEventCompat.getPointerId(motionEvent, 0);
                this.F = false;
                this.p.computeScrollOffset();
                if (this.an != 2 || Math.abs(this.p.getFinalY() - this.p.getCurrY()) <= this.R) {
                    a(false);
                    this.E = false;
                } else {
                    this.p.abortAnimation();
                    this.C = false;
                    n();
                    this.E = true;
                    c(true);
                    setScrollState(1);
                }
            } else if (action == 2) {
                int i2 = this.M;
                if (i2 != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
                    float b2 = b(motionEvent, findPointerIndex);
                    float f2 = b2 - this.J;
                    float abs = Math.abs(f2);
                    float a2 = a(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(a2 - this.K);
                    boolean z = !a(this.J, f2);
                    boolean a3 = a((View) this, false, (int) f2, (int) a2, (int) b2);
                    int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (i3 != 0 && z && a3) {
                        this.I = a2;
                        this.J = b2;
                        this.F = true;
                        return false;
                    }
                    if (abs > this.f34305f && abs > abs2) {
                        this.E = true;
                        c(true);
                        setScrollState(1);
                        float f3 = this.L;
                        this.J = i3 > 0 ? f3 + this.f34305f : f3 - this.f34305f;
                        this.I = a2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > this.f34305f) {
                        this.F = true;
                    }
                    if (this.E && b(b2)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                }
            } else if (action == 6) {
                a(motionEvent);
            }
            if (this.N == null) {
                this.N = VelocityTracker.obtain();
            }
            this.N.addMovement(motionEvent);
            return this.E;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        C0408b a2;
        int max;
        int i6;
        int max2;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            int i8 = i4 - i2;
            int i9 = i5 - i3;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int scrollY = getScrollY();
            int i10 = 0;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8) {
                    c cVar = (c) childAt.getLayoutParams();
                    if (cVar.f34315a) {
                        int i12 = cVar.f34316b;
                        int i13 = i12 & 7;
                        int i14 = i12 & 112;
                        if (i13 != 1) {
                            if (i13 == 3) {
                                i6 = childAt.getMeasuredWidth() + paddingLeft;
                            } else if (i13 != 5) {
                                i6 = paddingLeft;
                            } else {
                                max = (i8 - paddingRight) - childAt.getMeasuredWidth();
                                paddingRight += childAt.getMeasuredWidth();
                            }
                            if (i14 == 16) {
                                if (i14 == 48) {
                                    i7 = childAt.getMeasuredHeight() + paddingTop;
                                } else if (i14 != 80) {
                                    i7 = paddingTop;
                                } else {
                                    max2 = (i9 - paddingBottom) - childAt.getMeasuredHeight();
                                    paddingBottom += childAt.getMeasuredHeight();
                                }
                                int i15 = paddingTop + scrollY;
                                childAt.layout(paddingLeft, i15, childAt.getMeasuredWidth() + paddingLeft, i15 + childAt.getMeasuredHeight());
                                i10++;
                                paddingTop = i7;
                                paddingLeft = i6;
                            } else {
                                max2 = Math.max((i9 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            }
                            int i16 = max2;
                            i7 = paddingTop;
                            paddingTop = i16;
                            int i152 = paddingTop + scrollY;
                            childAt.layout(paddingLeft, i152, childAt.getMeasuredWidth() + paddingLeft, i152 + childAt.getMeasuredHeight());
                            i10++;
                            paddingTop = i7;
                            paddingLeft = i6;
                        } else {
                            max = Math.max((i8 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                        }
                        int i17 = max;
                        i6 = paddingLeft;
                        paddingLeft = i17;
                        if (i14 == 16) {
                        }
                        int i162 = max2;
                        i7 = paddingTop;
                        paddingTop = i162;
                        int i1522 = paddingTop + scrollY;
                        childAt.layout(paddingLeft, i1522, childAt.getMeasuredWidth() + paddingLeft, i1522 + childAt.getMeasuredHeight());
                        i10++;
                        paddingTop = i7;
                        paddingLeft = i6;
                    }
                }
            }
            int i18 = (i9 - paddingTop) - paddingBottom;
            for (int i19 = 0; i19 < childCount; i19++) {
                View childAt2 = getChildAt(i19);
                if (childAt2.getVisibility() != 8) {
                    c cVar2 = (c) childAt2.getLayoutParams();
                    if (!cVar2.f34315a && (a2 = a(childAt2)) != null) {
                        float f2 = i18;
                        int i20 = ((int) (a2.f34314e * f2)) + paddingTop;
                        if (cVar2.f34318d) {
                            cVar2.f34318d = false;
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec((i8 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f2 * cVar2.f34317c), 1073741824));
                        }
                        childAt2.layout(paddingLeft, i20, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i20);
                    }
                }
            }
            this.u = paddingLeft;
            this.v = i8 - paddingRight;
            this.ab = i10;
            if (this.V) {
                a(this.j, false, 0, false, false);
            }
            this.V = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ac  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        c cVar;
        c cVar2;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048627, this, i2, i3) == null) {
            setMeasuredDimension(ViewGroup.getDefaultSize(0, i2), ViewGroup.getDefaultSize(0, i3));
            int measuredHeight = getMeasuredHeight();
            this.H = Math.min(measuredHeight / 10, this.G);
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int i7 = 0;
            while (true) {
                boolean z = true;
                int i8 = 1073741824;
                if (i7 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8 && (cVar2 = (c) childAt.getLayoutParams()) != null && cVar2.f34315a) {
                    int i9 = cVar2.f34316b;
                    int i10 = i9 & 7;
                    int i11 = i9 & 112;
                    boolean z2 = i11 == 48 || i11 == 80;
                    if (i10 != 3 && i10 != 5) {
                        z = false;
                    }
                    int i12 = Integer.MIN_VALUE;
                    if (z2) {
                        i12 = 1073741824;
                    } else if (z) {
                        i4 = 1073741824;
                        i5 = ((ViewGroup.LayoutParams) cVar2).width;
                        if (i5 == -2) {
                            if (i5 == -1) {
                                i5 = measuredWidth;
                            }
                            i12 = 1073741824;
                        } else {
                            i5 = measuredWidth;
                        }
                        i6 = ((ViewGroup.LayoutParams) cVar2).height;
                        if (i6 != -2) {
                            i6 = paddingTop;
                            i8 = i4;
                        } else if (i6 == -1) {
                            i6 = paddingTop;
                        }
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, i12), View.MeasureSpec.makeMeasureSpec(i6, i8));
                        if (!z2) {
                            paddingTop -= childAt.getMeasuredHeight();
                        } else if (z) {
                            measuredWidth -= childAt.getMeasuredWidth();
                        }
                    }
                    i4 = Integer.MIN_VALUE;
                    i5 = ((ViewGroup.LayoutParams) cVar2).width;
                    if (i5 == -2) {
                    }
                    i6 = ((ViewGroup.LayoutParams) cVar2).height;
                    if (i6 != -2) {
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, i12), View.MeasureSpec.makeMeasureSpec(i6, i8));
                    if (!z2) {
                    }
                }
                i7++;
            }
            this.y = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            this.z = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
            this.A = true;
            n();
            this.A = false;
            int childCount2 = getChildCount();
            for (int i13 = 0; i13 < childCount2; i13++) {
                View childAt2 = getChildAt(i13);
                if (childAt2.getVisibility() != 8 && ((cVar = (c) childAt2.getLayoutParams()) == null || !cVar.f34315a)) {
                    childAt2.measure(this.y, View.MeasureSpec.makeMeasureSpec((int) (paddingTop * cVar.f34317c), 1073741824));
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        InterceptResult invokeIL;
        int i3;
        int i4;
        C0408b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048628, this, i2, rect)) == null) {
            int childCount = getChildCount();
            int i5 = -1;
            if ((i2 & 2) != 0) {
                i5 = childCount;
                i3 = 0;
                i4 = 1;
            } else {
                i3 = childCount - 1;
                i4 = -1;
            }
            while (i3 != i5) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (a2 = a(childAt)) != null && a2.f34311b == this.j && childAt.requestFocus(i2, rect)) {
                    return true;
                }
                i3 += i4;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, parcelable) == null) {
            if (!(parcelable instanceof h)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            h hVar = (h) parcelable;
            super.onRestoreInstanceState(hVar.getSuperState());
            PagerAdapter pagerAdapter = this.f34308i;
            if (pagerAdapter != null) {
                pagerAdapter.restoreState(hVar.f34324b, hVar.f34325c);
                a(hVar.f34323a, false, true);
                return;
            }
            this.l = hVar.f34323a;
            this.n = hVar.f34324b;
            this.o = hVar.f34325c;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? super.onSaveInstanceState() : (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048631, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i3 != i5) {
                int i6 = this.s;
                a(i3, i5, i6, i6);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0180  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        PagerAdapter pagerAdapter;
        int pointerId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, motionEvent)) == null) {
            if (this.S) {
                return true;
            }
            boolean z = false;
            if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f34308i) == null || pagerAdapter.getCount() == 0) {
                return false;
            }
            if (this.N == null) {
                this.N = VelocityTracker.obtain();
            }
            this.N.addMovement(motionEvent);
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action == 1) {
                    if (this.E) {
                        VelocityTracker velocityTracker = this.N;
                        velocityTracker.computeCurrentVelocity(1000, this.P);
                        int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.M);
                        this.C = true;
                        int clientHeight = getClientHeight();
                        int scrollY = getScrollY();
                        C0408b d2 = d();
                        if (d2 != null) {
                            a(a(d2.f34311b, ((scrollY / clientHeight) - d2.f34314e) / d2.f34313d, yVelocity, (int) (b(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.M)) - this.L)), true, true, yVelocity, true);
                            this.M = -1;
                            e();
                            z = this.T.onRelease() | this.U.onRelease();
                        }
                    }
                    this.ac = System.currentTimeMillis();
                } else if (action == 2) {
                    if (!this.E) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.M);
                        float b2 = b(motionEvent, findPointerIndex);
                        float abs = Math.abs(b2 - this.J);
                        float a2 = a(motionEvent, findPointerIndex);
                        float abs2 = Math.abs(a2 - this.I);
                        if (abs > this.f34305f && abs > abs2) {
                            this.E = true;
                            c(true);
                            float f2 = this.L;
                            this.J = b2 - f2 > 0.0f ? f2 + this.f34305f : f2 - this.f34305f;
                            this.I = a2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    if (this.E) {
                        z = false | b(b(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.M)));
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                        this.J = b(motionEvent, actionIndex);
                        pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    } else if (action == 6) {
                        a(motionEvent);
                        this.J = b(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.M));
                    }
                } else if (this.E) {
                    a(this.j, true, 0, false, false);
                    this.M = -1;
                    e();
                    z = this.T.onRelease() | this.U.onRelease();
                }
                if (z) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                return true;
            }
            this.p.abortAnimation();
            this.C = false;
            n();
            float x = motionEvent.getX();
            this.K = x;
            this.I = x;
            float y = motionEvent.getY();
            this.L = y;
            this.J = y;
            pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.M = pointerId;
            if (z) {
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void p() {
        List<DataSetObserver> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (list = this.r) == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            DataSetObserver dataSetObserver = this.r.get(i2);
            if (dataSetObserver != null) {
                dataSetObserver.onInvalidated();
            }
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            int i2 = this.j;
            if (i2 > 0) {
                a(i2 - 1, true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            PagerAdapter pagerAdapter = this.f34308i;
            if (pagerAdapter == null || this.j >= pagerAdapter.getCount() - 1) {
                return false;
            }
            a(this.j + 1, true);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, view) == null) {
            if (this.A) {
                removeViewInLayout(view);
            } else {
                super.removeView(view);
            }
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, pagerAdapter) == null) {
            PagerAdapter pagerAdapter2 = this.f34308i;
            if (pagerAdapter2 != null) {
                pagerAdapter2.unregisterDataSetObserver(this.q);
                this.f34308i.startUpdate((ViewGroup) this);
                for (int i2 = 0; i2 < this.f34304e.size(); i2++) {
                    C0408b c0408b = this.f34304e.get(i2);
                    this.f34308i.destroyItem((ViewGroup) this, c0408b.f34311b, c0408b.f34310a);
                }
                this.f34308i.finishUpdate((ViewGroup) this);
                this.f34304e.clear();
                a();
                int i3 = this.j;
                if (i3 != 0) {
                    this.k = i3;
                } else {
                    this.k = -1;
                }
                this.j = 0;
                scrollTo(0, 0);
            }
            int i4 = this.m;
            if (i4 > 0) {
                this.k = -1;
                this.j = i4;
                this.m = -1;
            }
            PagerAdapter pagerAdapter3 = this.f34308i;
            this.f34308i = pagerAdapter;
            this.f34303b = 0;
            if (pagerAdapter != null) {
                if (this.q == null) {
                    this.q = new g();
                }
                this.f34308i.registerDataSetObserver(this.q);
                this.C = false;
                boolean z = this.V;
                this.V = true;
                this.f34303b = this.f34308i.getCount();
                if (this.l >= 0) {
                    this.f34308i.restoreState(this.n, this.o);
                    a(this.l, false, true);
                    this.l = -1;
                    this.n = null;
                    this.o = null;
                } else if (z) {
                    requestLayout();
                } else {
                    n();
                }
            }
            e eVar = this.af;
            if (eVar == null || pagerAdapter3 == pagerAdapter) {
                return;
            }
            eVar.a(pagerAdapter3, pagerAdapter);
        }
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048638, this, z) == null) || Build.VERSION.SDK_INT < 7) {
            return;
        }
        if (this.ai == null) {
            try {
                this.ai = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e2) {
                com.kwad.sdk.core.d.a.a("VerticalViewPager", "Can't find setChildrenDrawingOrderEnabled", e2);
            }
        }
        try {
            this.ai.invoke(this, Boolean.valueOf(z));
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.a("VerticalViewPager", "Error changing children drawing order", e3);
        }
    }

    public void setCurrentItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            com.kwad.sdk.core.d.a.b("VerticalViewPager", "setCurrentItem item=" + i2);
            this.C = false;
            a(i2, this.V ^ true, false);
        }
    }

    public void setInitStartPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.m = i2;
        }
    }

    public void setOffscreenPageLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            if (i2 < 1) {
                com.kwad.sdk.core.d.a.a("VerticalViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
                i2 = 1;
            }
            if (i2 != this.D) {
                this.D = i2;
                n();
            }
        }
    }

    public void setOnAdapterChangeListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, eVar) == null) {
            this.af = eVar;
        }
    }

    public void setOnPageScrollEndListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, fVar) == null) {
            this.ag = fVar;
        }
    }

    public void setPageMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            int i3 = this.s;
            this.s = i2;
            int height = getHeight();
            a(height, height, i2, i3);
            requestLayout();
        }
    }

    public void setPageMarginDrawable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            setPageMarginDrawable(getContext().getResources().getDrawable(i2));
        }
    }

    public void setPageMarginDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, drawable) == null) {
            this.t = drawable;
            if (drawable != null) {
                refreshDrawableState();
            }
            setWillNotDraw(drawable == null);
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, drawable)) == null) ? super.verifyDrawable(drawable) || drawable == this.t : invokeL.booleanValue;
    }
}
