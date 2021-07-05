package com.kwad.sdk.glide.request.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.request.target.ViewTarget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Deprecated
/* loaded from: classes7.dex */
public abstract class k<T extends View, Z> extends com.kwad.sdk.glide.request.a.a<Z> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f38340b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public static Integer f38341c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final T f38342a;

    /* renamed from: d  reason: collision with root package name */
    public final a f38343d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public View.OnAttachStateChangeListener f38344e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38345f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38346g;

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        @Nullable
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        public static Integer f38347a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public boolean f38348b;

        /* renamed from: c  reason: collision with root package name */
        public final View f38349c;

        /* renamed from: d  reason: collision with root package name */
        public final List<i> f38350d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public ViewTreeObserver$OnPreDrawListenerC0468a f38351e;

        /* renamed from: com.kwad.sdk.glide.request.a.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0468a implements ViewTreeObserver.OnPreDrawListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final WeakReference<a> f38352a;

            public ViewTreeObserver$OnPreDrawListenerC0468a(@NonNull a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38352a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (Log.isLoggable(ViewTarget.TAG, 2)) {
                        Log.v(ViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
                    }
                    a aVar = this.f38352a.get();
                    if (aVar != null) {
                        aVar.a();
                        return true;
                    }
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        public a(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38350d = new ArrayList();
            this.f38349c = view;
        }

        private int a(int i2, int i3, int i4) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(65537, this, i2, i3, i4)) == null) {
                int i5 = i3 - i4;
                if (i5 > 0) {
                    return i5;
                }
                if (this.f38348b && this.f38349c.isLayoutRequested()) {
                    return 0;
                }
                int i6 = i2 - i4;
                if (i6 > 0) {
                    return i6;
                }
                if (this.f38349c.isLayoutRequested() || i3 != -2) {
                    return 0;
                }
                if (Log.isLoggable(ViewTarget.TAG, 4)) {
                    Log.i(ViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
                }
                return a(this.f38349c.getContext());
            }
            return invokeIII.intValue;
        }

        public static int a(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                if (f38347a == null) {
                    Display defaultDisplay = ((WindowManager) com.kwad.sdk.glide.g.j.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                    Point point = new Point();
                    defaultDisplay.getSize(point);
                    f38347a = Integer.valueOf(Math.max(point.x, point.y));
                }
                return f38347a.intValue();
            }
            return invokeL.intValue;
        }

        private void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(65539, this, i2, i3) == null) {
                Iterator it = new ArrayList(this.f38350d).iterator();
                while (it.hasNext()) {
                    ((i) it.next()).a(i2, i3);
                }
            }
        }

        private boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65540, this, i2)) == null) ? i2 > 0 || i2 == Integer.MIN_VALUE : invokeI.booleanValue;
        }

        private boolean b(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, this, i2, i3)) == null) ? a(i2) && a(i3) : invokeII.booleanValue;
        }

        private int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
                int paddingTop = this.f38349c.getPaddingTop() + this.f38349c.getPaddingBottom();
                ViewGroup.LayoutParams layoutParams = this.f38349c.getLayoutParams();
                return a(this.f38349c.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
            }
            return invokeV.intValue;
        }

        private int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
                int paddingLeft = this.f38349c.getPaddingLeft() + this.f38349c.getPaddingRight();
                ViewGroup.LayoutParams layoutParams = this.f38349c.getLayoutParams();
                return a(this.f38349c.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
            }
            return invokeV.intValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f38350d.isEmpty()) {
                return;
            }
            int d2 = d();
            int c2 = c();
            if (b(d2, c2)) {
                a(d2, c2);
                b();
            }
        }

        public void a(@NonNull i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar) == null) {
                int d2 = d();
                int c2 = c();
                if (b(d2, c2)) {
                    iVar.a(d2, c2);
                    return;
                }
                if (!this.f38350d.contains(iVar)) {
                    this.f38350d.add(iVar);
                }
                if (this.f38351e == null) {
                    ViewTreeObserver viewTreeObserver = this.f38349c.getViewTreeObserver();
                    ViewTreeObserver$OnPreDrawListenerC0468a viewTreeObserver$OnPreDrawListenerC0468a = new ViewTreeObserver$OnPreDrawListenerC0468a(this);
                    this.f38351e = viewTreeObserver$OnPreDrawListenerC0468a;
                    viewTreeObserver.addOnPreDrawListener(viewTreeObserver$OnPreDrawListenerC0468a);
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ViewTreeObserver viewTreeObserver = this.f38349c.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.f38351e);
                }
                this.f38351e = null;
                this.f38350d.clear();
            }
        }

        public void b(@NonNull i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
                this.f38350d.remove(iVar);
            }
        }
    }

    public k(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38342a = (T) com.kwad.sdk.glide.g.j.a(t);
        this.f38343d = new a(t);
    }

    private void a() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (onAttachStateChangeListener = this.f38344e) == null || this.f38346g) {
            return;
        }
        this.f38342a.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f38346g = true;
    }

    private void a(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, obj) == null) {
            Integer num = f38341c;
            if (num != null) {
                this.f38342a.setTag(num.intValue(), obj);
                return;
            }
            f38340b = true;
            this.f38342a.setTag(obj);
        }
    }

    private void f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && (onAttachStateChangeListener = this.f38344e) != null && this.f38346g) {
            this.f38342a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f38346g = false;
        }
    }

    @Nullable
    private Object g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            Integer num = f38341c;
            return num == null ? this.f38342a.getTag() : this.f38342a.getTag(num.intValue());
        }
        return invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void a(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
            super.a(drawable);
            this.f38343d.b();
            if (this.f38345f) {
                return;
            }
            f();
        }
    }

    @Override // com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void a(@NonNull i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar) == null) {
            this.f38343d.a(iVar);
        }
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void a(@Nullable com.kwad.sdk.glide.request.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            a((Object) cVar);
        }
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    @Nullable
    public com.kwad.sdk.glide.request.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object g2 = g();
            if (g2 != null) {
                if (g2 instanceof com.kwad.sdk.glide.request.c) {
                    return (com.kwad.sdk.glide.request.c) g2;
                }
                throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
            }
            return null;
        }
        return (com.kwad.sdk.glide.request.c) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void b(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) {
            super.b(drawable);
            a();
        }
    }

    @Override // com.kwad.sdk.glide.request.a.j
    @CallSuper
    public void b(@NonNull i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iVar) == null) {
            this.f38343d.b(iVar);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "Target for: " + this.f38342a;
        }
        return (String) invokeV.objValue;
    }
}
