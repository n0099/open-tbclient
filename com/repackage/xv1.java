package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur9;
import com.repackage.yv1;
/* loaded from: classes7.dex */
public abstract class xv1<V extends View, M extends yv1> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public yw1 a;
    @Nullable
    public V b;
    @NonNull
    public M c;
    @Nullable
    public M d;
    @Nullable
    public SwanAppComponentContainerView e;
    @Nullable
    public as9 f;
    public int g;

    /* loaded from: classes7.dex */
    public class a extends as9<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String e;
        public final /* synthetic */ xv1 f;

        public a(xv1 xv1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = xv1Var;
            this.e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.repackage.xv1 */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.repackage.xv1 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.repackage.vr9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xv1 xv1Var = this.f;
                xv1Var.b = xv1Var.v(xv1Var.a.getContext());
                xv1 xv1Var2 = this.f;
                xv1Var2.A(xv1Var2.b);
                this.f.e.setTargetView(this.f.b, 0);
                xv1 xv1Var3 = this.f;
                xv1Var3.C(xv1Var3.b, this.f.c, new ax1(true));
                if (xv1.h) {
                    Log.d("Component-Base", this.e + " insert delayed（view）: success");
                }
            }
        }

        @Override // com.repackage.vr9
        @SuppressLint({"BDThrowableCheck"})
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                ix1.o("Component-Base", this.e + " insert delayed（view）: fail");
                if (xv1.h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.f.B();
            }
        }

        @Override // com.repackage.vr9
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                ix1.o("Component-Base", this.e + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ur9.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ xv1 b;

        public b(xv1 xv1Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv1Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xv1Var;
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.a, com.repackage.is9
        public void call(as9<? super Object> as9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
                if (xv1.h) {
                    Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
                }
                if (this.a != Thread.currentThread().getId()) {
                    bx1.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.b.f = as9Var;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends of3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(xv1 xv1Var, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv1Var, str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = z;
        }

        @Override // com.repackage.of3, android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) ? this.j && super.onTouch(view2, motionEvent) : invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755158242, "Lcom/repackage/xv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755158242, "Lcom/repackage/xv1;");
                return;
            }
        }
        h = sg1.a;
    }

    public xv1(@Nullable Context context, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        M j = j(m);
        this.c = j;
        yw1 c2 = vw1.c(j);
        this.a = c2;
        if (c2 != null) {
            if (context != null) {
                c2.c(context);
                return;
            }
            return;
        }
        ix1.c("Component-Base", o() + " context is null !");
    }

    public void A(@NonNull V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
        }
    }

    @NonNull
    @UiThread
    public final zv1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String o = o();
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start remove=====================");
            }
            yw1 yw1Var = this.a;
            if (yw1Var == null) {
                bx1.a("Component-Base", o + " remove with a null component context!");
                return new zv1(202, "component context is null");
            } else if (this.e == null) {
                ix1.c("Component-Base", o + " remove must after insert");
                return new zv1(202, "component remove must after insert");
            } else if (!yw1Var.a().e(this)) {
                String str = o + " remove fail";
                ix1.c("Component-Base", str);
                return new zv1(1001, str);
            } else {
                z();
                if (h) {
                    Log.d("Component-Base", o + " remove: success");
                }
                return new zv1(0, "success");
            }
        }
        return (zv1) invokeV.objValue;
    }

    @CallSuper
    public void C(@NonNull V v, @NonNull M m, @NonNull ax1 ax1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, v, m, ax1Var) == null) {
            D(m, ax1Var);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void D(@NonNull M m, @NonNull ax1 ax1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, m, ax1Var) == null) {
            if (this.e == null) {
                bx1.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (ax1Var.a(1)) {
                this.e.setHidden(m.f);
            }
            if (ax1Var.a(2)) {
                r(this.e, m);
            }
        }
    }

    public final void E() {
        as9 as9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (as9Var = this.f) == null || as9Var.isUnsubscribed()) {
            return;
        }
        this.f.unsubscribe();
    }

    @NonNull
    public final xv1 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.g = i | this.g;
            return this;
        }
        return (xv1) invokeI.objValue;
    }

    public final boolean h(@NonNull yw1 yw1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, yw1Var)) == null) {
            boolean b2 = yw1Var.a().b(this);
            x(b2);
            return b2;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public final zv1 i(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, m)) == null) {
            if (m == null) {
                return new zv1(202, "model is null");
            }
            if (TextUtils.isEmpty(m.c)) {
                return new zv1(202, "slave id is empty");
            }
            if (!m.isValid()) {
                return new zv1(202, "model is invalid");
            }
            return new zv1(0, "model is valid");
        }
        return (zv1) invokeL.objValue;
    }

    @NonNull
    @UiThread
    public final zv1 insert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String o = o();
            zv1 i = i(this.c);
            if (!i.a()) {
                ix1.c("Component-Base", o + " insert with a invalid model => " + i.b);
                return i;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start insert=====================");
            }
            yw1 yw1Var = this.a;
            if (yw1Var == null) {
                ix1.c("Component-Base", o + " insert with a null component context!");
                return new zv1(202, "component context is null");
            }
            Context context = yw1Var.getContext();
            if (this.e != null || this.b != null) {
                ix1.o("Component-Base", o + " repeat insert");
            }
            V v = v(this.a.getContext());
            this.b = v;
            A(v);
            SwanAppComponentContainerView u = u(context);
            this.e = u;
            u.setTargetView(this.b);
            C(this.b, this.c, new ax1(true));
            if (h(this.a)) {
                if (h) {
                    Log.d("Component-Base", o + " insert: success");
                }
                return new zv1(0, "success");
            }
            ix1.c("Component-Base", o + " insert: attach fail");
            return new zv1(1001, "attach fail");
        }
        return (zv1) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        InterceptResult invokeL;
        yv1 yv1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            try {
                yv1Var = (yv1) m.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                bx1.b("Component-Base", "model must implement cloneable", e);
                yv1Var = null;
                if (yv1Var == null) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                bx1.b("Component-Base", "clone model fail ！", e2);
                yv1Var = null;
                if (yv1Var == null) {
                }
            }
            if (yv1Var == null) {
                bx1.a("Component-Base", "clone model fail ！");
                return m;
            }
            return (M) yv1Var;
        }
        return (M) invokeL.objValue;
    }

    @NonNull
    @CallSuper
    public ax1 k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, m, m2)) == null) {
            ax1 ax1Var = new ax1();
            oq2 oq2Var = m2.h;
            if (oq2Var != null && oq2Var.b(m.h)) {
                ax1Var.b(3);
            }
            if (m.f != m2.f) {
                ax1Var.b(1);
            }
            if (m.g != m2.g) {
                ax1Var.b(2);
            }
            return ax1Var;
        }
        return (ax1) invokeLL.objValue;
    }

    @NonNull
    public final M l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? j(this.c) : (M) invokeV.objValue;
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.e : (SwanAppComponentContainerView) invokeV.objValue;
    }

    @NonNull
    public final M n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.c : (M) invokeV.objValue;
    }

    @NonNull
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            zv1 i = i(this.c);
            if (i.a()) {
                return this.c.d();
            }
            return "【illegal component#" + i.b + "】";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public final M p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.d : (M) invokeV.objValue;
    }

    @Nullable
    public final V q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.b : (V) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanAppComponentContainerView, m) == null) {
            swanAppComponentContainerView.setOnTouchListener(new c(this, m.c, m.b, m.a, m.g));
        }
    }

    public final boolean s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) ? (this.g & i) == i : invokeI.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.d != null : invokeV.booleanValue;
    }

    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) ? new SwanAppComponentContainerView(context) : (SwanAppComponentContainerView) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.repackage.xv1<V extends android.view.View, M extends com.repackage.yv1> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @UiThread
    public /* bridge */ /* synthetic */ zv1 update(@NonNull aw1 aw1Var) {
        return update((xv1<V, M>) ((yv1) aw1Var));
    }

    @NonNull
    public abstract V v(@NonNull Context context);

    @Nullable
    @UiThread
    public final as9 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            zv1 i = i(this.c);
            if (!i.a()) {
                ix1.c("Component-Base", o + " insert delayed with a invalid model => " + i.b);
                return null;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
            }
            if (this.a == null) {
                bx1.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.e != null) {
                ix1.o("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            as9 as9Var = this.f;
            if (as9Var != null && !as9Var.isUnsubscribed()) {
                this.f.unsubscribe();
                this.f = null;
                ix1.o("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.e = u(this.a.getContext());
            D(this.c, new ax1(true));
            if (h(this.a)) {
                if (h) {
                    Log.d("Component-Base", o + " insert delayed（container view）: success");
                }
                ur9.a(new b(this, Thread.currentThread().getId())).u(new a(this, o));
                return this.f;
            }
            ix1.c("Component-Base", o + " insert delayed: attach fail");
            return null;
        }
        return (as9) invokeV.objValue;
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    @CallSuper
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (h) {
                Log.d("Component-Base", o() + " onDestroy");
            }
            E();
        }
    }

    @CallSuper
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            E();
        }
    }

    @NonNull
    @UiThread
    public final zv1 update(@NonNull M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, m)) == null) {
            String o = o();
            zv1 i = i(m);
            if (!i.a()) {
                ix1.c("Component-Base", o + " update with a invalid model => " + i.b);
                return i;
            }
            if (h) {
                Log.i("Component-Base", "=====================" + o + " start update=====================");
            }
            M m2 = this.c;
            if (m2 == m) {
                String str = o + " update with the same model";
                bx1.a("Component-Base", str);
                return new zv1(202, str);
            } else if (!TextUtils.equals(m2.b, m.b)) {
                String str2 = o + " update with different id: " + this.c.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.b;
                bx1.a("Component-Base", str2);
                return new zv1(202, str2);
            } else if (!TextUtils.equals(this.c.c, m.c)) {
                String str3 = o + " update with different slave id: " + this.c.c + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.c;
                bx1.a("Component-Base", str3);
                return new zv1(202, str3);
            } else if (this.b != null && this.e != null) {
                if (this.a == null) {
                    bx1.a("Component-Base", o + " update with a null component context!");
                    return new zv1(202, "component context is null");
                }
                M m3 = this.c;
                this.d = m3;
                ax1 k = k(m3, m);
                M j = j(m);
                this.c = j;
                C(this.b, j, k);
                boolean f = this.a.a().f(this, k);
                this.d = null;
                if (!f) {
                    String str4 = o + " update component fail";
                    ix1.c("Component-Base", str4);
                    return new zv1(1001, str4);
                }
                if (h) {
                    Log.d("Component-Base", o + " component update: success");
                }
                return new zv1(0, "success");
            } else {
                String str5 = o + " update must after insert succeeded";
                bx1.a("Component-Base", str5);
                return new zv1(202, str5);
            }
        }
        return (zv1) invokeL.objValue;
    }
}
