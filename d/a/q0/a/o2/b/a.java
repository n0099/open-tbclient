package d.a.q0.a.o2.b;

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
import d.a.q0.a.a1.e;
import d.a.q0.a.j2.h;
import d.a.q0.a.k;
import d.a.q0.a.r1.i;
import d.a.q0.a.v2.q0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f49862a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f49863b;

    /* renamed from: c  reason: collision with root package name */
    public int f49864c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a.h0.g.f f49865d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppConfigData.l f49866e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<SwanAppBottomTabIconView> f49867f;

    /* renamed from: g  reason: collision with root package name */
    public List<SwanAppConfigData.m> f49868g;

    /* renamed from: h  reason: collision with root package name */
    public String f49869h;

    /* renamed from: i  reason: collision with root package name */
    public String f49870i;

    /* renamed from: d.a.q0.a.o2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC0903a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49871e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f49872f;

        public View$OnClickListenerC0903a(a aVar, int i2) {
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
            this.f49872f = aVar;
            this.f49871e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49872f.g(this.f49871e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f49873e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f49874f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f49875g;

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
            this.f49875g = aVar;
            this.f49873e = swanAppBottomTabIconView;
            this.f49874f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49873e.setIconView(this.f49874f);
                if (this.f49875g.f49869h == null) {
                    this.f49873e.setTextColor(this.f49875g.f49866e.f11500a);
                } else {
                    this.f49873e.setTextColor(SwanAppConfigData.s(this.f49875g.f49869h));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f49876e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f49877f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f49878g;

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
            this.f49878g = aVar;
            this.f49876e = swanAppBottomTabIconView;
            this.f49877f = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49876e.setIconView(this.f49877f);
                if (this.f49878g.f49870i == null) {
                    this.f49876e.setTextColor(this.f49878g.f49866e.f11501b);
                } else {
                    this.f49876e.setTextColor(SwanAppConfigData.s(this.f49878g.f49870i));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49879e;

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
            this.f49879e = aVar;
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
                this.f49879e.f49863b.setVisibility(8);
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

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f49880e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49881f;

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
            this.f49880e = swanAppBottomTabIconView;
            this.f49881f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49880e.setTextView(this.f49881f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppBottomTabIconView f49882e;

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
            this.f49882e = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49882e.setRedDotVisibleState(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1614882278, "Ld/a/q0/a/o2/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1614882278, "Ld/a/q0/a/o2/b/a;");
                return;
            }
        }
        j = k.f49133a;
    }

    public a(d.a.q0.a.h0.g.f fVar) {
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
        this.f49864c = 0;
        this.f49865d = fVar;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, swanAppBottomTabIconView, mVar)) == null) {
            d.a.q0.a.f1.e.b n = n();
            if (n == null) {
                return false;
            }
            String l = d.a.q0.a.u1.a.a.l(n);
            if (TextUtils.isEmpty(l)) {
                l = e.C0680e.i(n.H(), n.u1()).getPath();
            }
            String str = l + File.separator + mVar.f11508b;
            if (d.a.q0.t.d.u(str)) {
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
            this.f49869h = str;
        }
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, swanAppBottomTabIconView, mVar)) == null) {
            d.a.q0.a.f1.e.b n = n();
            if (n == null) {
                return false;
            }
            String l = d.a.q0.a.u1.a.a.l(n);
            if (TextUtils.isEmpty(l)) {
                l = e.C0680e.i(n.H(), n.u1()).getPath();
            }
            String str = l + File.separator + mVar.f11509c;
            if (d.a.q0.t.d.u(str)) {
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
            this.f49870i = str;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            for (int i2 = 0; i2 < this.f49868g.size(); i2++) {
                if (this.f49868g.get(i2).f11507a.equals(str)) {
                    u(i2);
                    this.f49864c = i2;
                    return;
                }
            }
        }
    }

    public void f(View view, Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, view, context, str) == null) && this.f49865d.Z1()) {
            SwanAppConfigData s = d.a.q0.a.g1.f.V().s();
            if (s == null) {
                if (j) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            SwanAppConfigData.l lVar = s.f11461f;
            this.f49866e = lVar;
            List<SwanAppConfigData.m> list = lVar.f11504e;
            this.f49868g = list;
            int size = list.size();
            this.f49867f = new ArrayList<>(size);
            this.f49862a = view.findViewById(d.a.q0.a.f.bottom_bar_shadow);
            y(this.f49866e.f11502c);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(d.a.q0.a.f.ai_apps_bottom_tab);
            this.f49863b = linearLayout;
            linearLayout.setVisibility(0);
            this.f49863b.setBackgroundColor(this.f49866e.f11503d);
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.m mVar = this.f49868g.get(i2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, size);
                layoutParams.gravity = 1;
                if (TextUtils.equals(mVar.f11507a, !TextUtils.isEmpty(str) ? str : d.a.q0.a.g1.f.V().f()) && !z) {
                    C(swanAppBottomTabIconView, mVar);
                    this.f49864c = i2;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, mVar);
                }
                swanAppBottomTabIconView.setTextView(mVar.f11510d);
                swanAppBottomTabIconView.setOnClickListener(new View$OnClickListenerC0903a(this, i2));
                this.f49867f.add(swanAppBottomTabIconView);
                this.f49863b.addView(swanAppBottomTabIconView, layoutParams);
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
            if (this.f49864c == i2) {
                return;
            }
            this.f49864c = i2;
            this.f49865d.pause();
            d.a.q0.a.l1.b g2 = d.a.q0.a.l1.b.g(this.f49868g.get(i2).f11507a, d.a.q0.a.g1.f.V().A());
            h.f(g2.f49291e, "5");
            this.f49865d.Y2(g2, uuid);
            d.a.q0.a.h0.g.f.F3("switchTab");
            this.f49865d.resume();
        }
    }

    public boolean h(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, str, str2, str3, str4)) == null) {
            if (this.f49862a == null || this.f49863b == null) {
                return false;
            }
            y(SwanAppConfigData.s(str4));
            z(str3);
            B(str);
            D(str2);
            Iterator<SwanAppBottomTabIconView> it = this.f49867f.iterator();
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
                this.f49867f.get(i2).setBadgeVisibleState(false);
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
            View view = this.f49862a;
            if (view == null || this.f49863b == null) {
                return false;
            }
            view.setVisibility(8);
            if (z) {
                l();
                return true;
            }
            this.f49863b.setVisibility(8);
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
            if (q(i2) && (swanAppBottomTabIconView = this.f49867f.get(i2)) != null) {
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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f49863b, "translationY", 0.0f, d.a.q0.a.c1.a.b().getResources().getDimensionPixelSize(d.a.q0.a.d.aiapps_bottom_tab_height));
            ofFloat.setDuration(240L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addListener(new d(this));
            ofFloat.start();
        }
    }

    public LinearLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f49863b : (LinearLayout) invokeV.objValue;
    }

    public final d.a.q0.a.f1.e.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
            if (i2 != null) {
                return i2.N();
            }
            return null;
        }
        return (d.a.q0.a.f1.e.b) invokeV.objValue;
    }

    public int o(String str) {
        InterceptResult invokeL;
        List<SwanAppConfigData.m> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (list = this.f49868g) != null && list.size() != 0) {
                for (int i2 = 0; i2 < this.f49868g.size(); i2++) {
                    SwanAppConfigData.m mVar = this.f49868g.get(i2);
                    if (mVar != null && TextUtils.equals(mVar.f11507a, str)) {
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
            LinearLayout linearLayout = this.f49863b;
            return linearLayout != null && linearLayout.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            ArrayList<SwanAppBottomTabIconView> arrayList = this.f49867f;
            return arrayList != null && i2 < arrayList.size() && i2 >= 0;
        }
        return invokeI.booleanValue;
    }

    public boolean r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            View view = this.f49862a;
            if (view == null || this.f49863b == null) {
                return false;
            }
            view.setVisibility(0);
            this.f49863b.setVisibility(0);
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
                this.f49867f.get(i2).setRedDotVisibleState(true);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f49863b, "translationY", d.a.q0.a.c1.a.b().getResources().getDimensionPixelSize(d.a.q0.a.d.aiapps_bottom_tab_height), 0.0f);
            ofFloat.setDuration(z ? 240L : 0L);
            ofFloat.start();
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            A(this.f49867f.get(this.f49864c), this.f49868g.get(this.f49864c));
            C(this.f49867f.get(i2), this.f49868g.get(i2));
        }
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            HashMap hashMap = new HashMap();
            SwanAppConfigData.m mVar = this.f49868g.get(i2);
            String j3 = this.f49865d.j3(d.a.q0.a.l1.b.g(mVar.f11507a, d.a.q0.a.g1.f.V().A()).f49291e);
            hashMap.put("index", String.valueOf(i2));
            hashMap.put("pagePath", mVar.f11507a);
            hashMap.put("text", mVar.f11510d);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, j3);
            d.a.q0.a.g1.f.V().v(new d.a.q0.a.o0.d.b("onTabItemTap", hashMap));
        }
    }

    public boolean w(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i2, str)) == null) {
            if (q(i2)) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f49867f.get(i2);
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
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f49867f.get(i2);
                q0.b0(new e(this, swanAppBottomTabIconView, str));
                if (!TextUtils.isEmpty(str2)) {
                    this.f49868g.get(i2).f11508b = str2;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.f49868g.get(i2).f11509c = str3;
                }
                if (swanAppBottomTabIconView.a()) {
                    return C(swanAppBottomTabIconView, this.f49868g.get(i2));
                }
                return A(swanAppBottomTabIconView, this.f49868g.get(i2));
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
            this.f49862a.setVisibility(0);
            this.f49862a.setBackgroundColor(-1);
        } else if (-16777216 == i2) {
            this.f49862a.setVisibility(0);
            this.f49862a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(d.a.q0.a.c.aiapps_tabbar_top_divider_color));
        } else {
            this.f49862a.setVisibility(0);
            this.f49862a.setBackgroundColor(-1);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.f49863b.setBackgroundColor(SwanAppConfigData.s(str));
        }
    }
}
