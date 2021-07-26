package d.a.o0.a.o2.b;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.AnyThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.tabbar.view.SwanAppBottomTabIconView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a1.e;
import d.a.o0.a.j2.h;
import d.a.o0.a.k;
import d.a.o0.a.r1.i;
import d.a.o0.a.v2.q0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f47064a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f47065b;

    /* renamed from: c  reason: collision with root package name */
    public int f47066c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.a.h0.g.f f47067d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppConfigData.l f47068e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<SwanAppBottomTabIconView> f47069f;

    /* renamed from: g  reason: collision with root package name */
    public List<SwanAppConfigData.m> f47070g;

    /* renamed from: h  reason: collision with root package name */
    public String f47071h;

    /* renamed from: i  reason: collision with root package name */
    public String f47072i;

    /* renamed from: d.a.o0.a.o2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC0861a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f47073e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47074f;

        public View$OnClickListenerC0861a(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47074f = aVar;
            this.f47073e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47074f.g(this.f47073e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f47075e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f47076f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f47077g;

        public b(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppBottomTabIconView, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47077g = aVar;
            this.f47075e = swanAppBottomTabIconView;
            this.f47076f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47075e.setIconView(this.f47076f);
                if (this.f47077g.f47071h == null) {
                    this.f47075e.setTextColor(this.f47077g.f47068e.f11543a);
                } else {
                    this.f47075e.setTextColor(SwanAppConfigData.s(this.f47077g.f47071h));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f47078e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f47079f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f47080g;

        public c(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppBottomTabIconView, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47080g = aVar;
            this.f47078e = swanAppBottomTabIconView;
            this.f47079f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47078e.setIconView(this.f47079f);
                if (this.f47080g.f47072i == null) {
                    this.f47078e.setTextColor(this.f47080g.f47068e.f11544b);
                } else {
                    this.f47078e.setTextColor(SwanAppConfigData.s(this.f47080g.f47072i));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47081e;

        public d(a aVar) {
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
            this.f47081e = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f47081e.f47065b.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f47082e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47083f;

        public e(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppBottomTabIconView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47082e = swanAppBottomTabIconView;
            this.f47083f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47082e.setTextView(this.f47083f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f47084e;

        public f(a aVar, SwanAppBottomTabIconView swanAppBottomTabIconView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppBottomTabIconView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47084e = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47084e.setRedDotVisibleState(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1873047716, "Ld/a/o0/a/o2/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1873047716, "Ld/a/o0/a/o2/b/a;");
                return;
            }
        }
        j = k.f46335a;
    }

    public a(d.a.o0.a.h0.g.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47066c = 0;
        this.f47067d = fVar;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, swanAppBottomTabIconView, mVar)) == null) {
            d.a.o0.a.f1.e.b n = n();
            if (n == null) {
                return false;
            }
            String l = d.a.o0.a.u1.a.a.l(n);
            if (TextUtils.isEmpty(l)) {
                l = e.C0638e.i(n.H(), n.u1()).getPath();
            }
            String str = l + File.separator + mVar.f11551b;
            if (d.a.o0.t.d.u(str)) {
                swanAppBottomTabIconView.setmIsSelect(false);
                q0.b0(new b(this, swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f47071h = str;
        }
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, swanAppBottomTabIconView, mVar)) == null) {
            d.a.o0.a.f1.e.b n = n();
            if (n == null) {
                return false;
            }
            String l = d.a.o0.a.u1.a.a.l(n);
            if (TextUtils.isEmpty(l)) {
                l = e.C0638e.i(n.H(), n.u1()).getPath();
            }
            String str = l + File.separator + mVar.f11552c;
            if (d.a.o0.t.d.u(str)) {
                swanAppBottomTabIconView.setmIsSelect(true);
                q0.b0(new c(this, swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f47072i = str;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            for (int i2 = 0; i2 < this.f47070g.size(); i2++) {
                if (this.f47070g.get(i2).f11550a.equals(str)) {
                    u(i2);
                    this.f47066c = i2;
                    return;
                }
            }
        }
    }

    public void f(View view, Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, view, context, str) == null) && this.f47067d.Z1()) {
            SwanAppConfigData s = d.a.o0.a.g1.f.V().s();
            if (s == null) {
                if (j) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            SwanAppConfigData.l lVar = s.f11504f;
            this.f47068e = lVar;
            List<SwanAppConfigData.m> list = lVar.f11547e;
            this.f47070g = list;
            int size = list.size();
            this.f47069f = new ArrayList<>(size);
            this.f47064a = view.findViewById(d.a.o0.a.f.bottom_bar_shadow);
            y(this.f47068e.f11545c);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(d.a.o0.a.f.ai_apps_bottom_tab);
            this.f47065b = linearLayout;
            linearLayout.setVisibility(0);
            this.f47065b.setBackgroundColor(this.f47068e.f11546d);
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.m mVar = this.f47070g.get(i2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, size);
                layoutParams.gravity = 1;
                if (TextUtils.equals(mVar.f11550a, !TextUtils.isEmpty(str) ? str : d.a.o0.a.g1.f.V().f()) && !z) {
                    C(swanAppBottomTabIconView, mVar);
                    this.f47066c = i2;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, mVar);
                }
                swanAppBottomTabIconView.setTextView(mVar.f11553d);
                swanAppBottomTabIconView.setOnClickListener(new View$OnClickListenerC0861a(this, i2));
                this.f47069f.add(swanAppBottomTabIconView);
                this.f47065b.addView(swanAppBottomTabIconView, layoutParams);
            }
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            u(i2);
            v(i2);
            if (this.f47066c == i2) {
                return;
            }
            this.f47066c = i2;
            this.f47067d.pause();
            d.a.o0.a.l1.b g2 = d.a.o0.a.l1.b.g(this.f47070g.get(i2).f11550a, d.a.o0.a.g1.f.V().A());
            h.f(g2.f46493e, "5");
            this.f47067d.Y2(g2, uuid);
            d.a.o0.a.h0.g.f.F3("switchTab");
            this.f47067d.resume();
        }
    }

    public boolean h(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, str, str2, str3, str4)) == null) {
            if (this.f47064a == null || this.f47065b == null) {
                return false;
            }
            y(SwanAppConfigData.s(str4));
            z(str3);
            B(str);
            D(str2);
            Iterator<SwanAppBottomTabIconView> it = this.f47069f.iterator();
            while (it.hasNext()) {
                SwanAppBottomTabIconView next = it.next();
                if (next.a()) {
                    next.setTextColor(SwanAppConfigData.s(str2));
                } else {
                    next.setTextColor(SwanAppConfigData.s(str));
                }
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (q(i2)) {
                this.f47069f.get(i2).setBadgeVisibleState(false);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            View view = this.f47064a;
            if (view == null || this.f47065b == null) {
                return false;
            }
            view.setVisibility(8);
            if (z) {
                l();
                return true;
            }
            this.f47065b.setVisibility(8);
            return true;
        }
        return invokeZ.booleanValue;
    }

    @AnyThread
    public boolean k(int i2) {
        InterceptResult invokeI;
        SwanAppBottomTabIconView swanAppBottomTabIconView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (q(i2) && (swanAppBottomTabIconView = this.f47069f.get(i2)) != null) {
                q0.b0(new f(this, swanAppBottomTabIconView));
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f47065b, "translationY", 0.0f, d.a.o0.a.c1.a.b().getResources().getDimensionPixelSize(d.a.o0.a.d.aiapps_bottom_tab_height));
            ofFloat.setDuration(240L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addListener(new d(this));
            ofFloat.start();
        }
    }

    public LinearLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f47065b : (LinearLayout) invokeV.objValue;
    }

    public final d.a.o0.a.f1.e.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
            if (i2 != null) {
                return i2.N();
            }
            return null;
        }
        return (d.a.o0.a.f1.e.b) invokeV.objValue;
    }

    public int o(String str) {
        InterceptResult invokeL;
        List<SwanAppConfigData.m> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (list = this.f47070g) != null && list.size() != 0) {
                for (int i2 = 0; i2 < this.f47070g.size(); i2++) {
                    SwanAppConfigData.m mVar = this.f47070g.get(i2);
                    if (mVar != null && TextUtils.equals(mVar.f11550a, str)) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LinearLayout linearLayout = this.f47065b;
            return linearLayout != null && linearLayout.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            ArrayList<SwanAppBottomTabIconView> arrayList = this.f47069f;
            return arrayList != null && i2 < arrayList.size() && i2 >= 0;
        }
        return invokeI.booleanValue;
    }

    public boolean r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            View view = this.f47064a;
            if (view == null || this.f47065b == null) {
                return false;
            }
            view.setVisibility(0);
            this.f47065b.setVisibility(0);
            t(z);
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (q(i2)) {
                this.f47069f.get(i2).setRedDotVisibleState(true);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f47065b, "translationY", d.a.o0.a.c1.a.b().getResources().getDimensionPixelSize(d.a.o0.a.d.aiapps_bottom_tab_height), 0.0f);
            ofFloat.setDuration(z ? 240L : 0L);
            ofFloat.start();
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            A(this.f47069f.get(this.f47066c), this.f47070g.get(this.f47066c));
            C(this.f47069f.get(i2), this.f47070g.get(i2));
        }
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            HashMap hashMap = new HashMap();
            SwanAppConfigData.m mVar = this.f47070g.get(i2);
            String j3 = this.f47067d.j3(d.a.o0.a.l1.b.g(mVar.f11550a, d.a.o0.a.g1.f.V().A()).f46493e);
            hashMap.put("index", String.valueOf(i2));
            hashMap.put("pagePath", mVar.f11550a);
            hashMap.put("text", mVar.f11553d);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, j3);
            d.a.o0.a.g1.f.V().v(new d.a.o0.a.o0.d.b("onTabItemTap", hashMap));
        }
    }

    public boolean w(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i2, str)) == null) {
            if (q(i2)) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f47069f.get(i2);
                swanAppBottomTabIconView.setBadgeVisibleState(true);
                swanAppBottomTabIconView.setBadgeText(str);
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public boolean x(int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), str, str2, str3})) == null) {
            if (q(i2)) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f47069f.get(i2);
                q0.b0(new e(this, swanAppBottomTabIconView, str));
                if (!TextUtils.isEmpty(str2)) {
                    this.f47070g.get(i2).f11551b = str2;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.f47070g.get(i2).f11552c = str3;
                }
                if (swanAppBottomTabIconView.a()) {
                    return C(swanAppBottomTabIconView, this.f47070g.get(i2));
                }
                return A(swanAppBottomTabIconView, this.f47070g.get(i2));
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || AppRuntime.getAppContext() == null) {
            return;
        }
        if (-1 == i2) {
            this.f47064a.setVisibility(0);
            this.f47064a.setBackgroundColor(-1);
        } else if (-16777216 == i2) {
            this.f47064a.setVisibility(0);
            this.f47064a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(d.a.o0.a.c.aiapps_tabbar_top_divider_color));
        } else {
            this.f47064a.setVisibility(0);
            this.f47064a.setBackgroundColor(-1);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.f47065b.setBackgroundColor(SwanAppConfigData.s(str));
        }
    }
}
