package com.repackage;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fj2;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
/* loaded from: classes7.dex */
public class vb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public LinearLayout b;
    public int c;
    public rz1 d;
    public SwanAppConfigData.n e;
    public ArrayList<SwanAppBottomTabIconView> f;
    public List<SwanAppConfigData.o> g;
    public String h;
    public String i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ vb3 b;

        public a(vb3 vb3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb3Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vb3Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.g(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppBottomTabIconView a;
        public final /* synthetic */ Bitmap b;
        public final /* synthetic */ vb3 c;

        public b(vb3 vb3Var, SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb3Var, swanAppBottomTabIconView, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vb3Var;
            this.a = swanAppBottomTabIconView;
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setIconView(this.b);
                if (this.c.h == null) {
                    this.a.setTextColor(this.c.e.a);
                } else {
                    this.a.setTextColor(SwanAppConfigData.t(this.c.h));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppBottomTabIconView a;
        public final /* synthetic */ Bitmap b;
        public final /* synthetic */ vb3 c;

        public c(vb3 vb3Var, SwanAppBottomTabIconView swanAppBottomTabIconView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb3Var, swanAppBottomTabIconView, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vb3Var;
            this.a = swanAppBottomTabIconView;
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setIconView(this.b);
                if (this.c.i == null) {
                    this.a.setTextColor(this.c.e.b);
                } else {
                    this.a.setTextColor(SwanAppConfigData.t(this.c.i));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb3 a;

        public d(vb3 vb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vb3Var;
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
                this.a.b.setVisibility(8);
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
        public final /* synthetic */ SwanAppBottomTabIconView a;
        public final /* synthetic */ String b;

        public e(vb3 vb3Var, SwanAppBottomTabIconView swanAppBottomTabIconView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb3Var, swanAppBottomTabIconView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppBottomTabIconView;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setTextView(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppBottomTabIconView a;

        public f(vb3 vb3Var, SwanAppBottomTabIconView swanAppBottomTabIconView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb3Var, swanAppBottomTabIconView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppBottomTabIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setRedDotVisibleState(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755236982, "Lcom/repackage/vb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755236982, "Lcom/repackage/vb3;");
                return;
            }
        }
        j = tg1.a;
    }

    public vb3(rz1 rz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = rz1Var;
    }

    public final boolean A(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, swanAppBottomTabIconView, oVar)) == null) {
            gl2 n = n();
            if (n == null) {
                return false;
            }
            String l = iw2.l(n);
            if (TextUtils.isEmpty(l)) {
                l = fj2.e.i(n.H(), n.v1()).getPath();
            }
            String str = l + File.separator + oVar.b;
            if (mg4.v(str)) {
                swanAppBottomTabIconView.setmIsSelect(false);
                de3.e0(new b(this, swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.h = str;
        }
    }

    public final boolean C(SwanAppBottomTabIconView swanAppBottomTabIconView, SwanAppConfigData.o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, swanAppBottomTabIconView, oVar)) == null) {
            gl2 n = n();
            if (n == null) {
                return false;
            }
            String l = iw2.l(n);
            if (TextUtils.isEmpty(l)) {
                l = fj2.e.i(n.H(), n.v1()).getPath();
            }
            String str = l + File.separator + oVar.c;
            if (mg4.v(str)) {
                swanAppBottomTabIconView.setmIsSelect(true);
                de3.e0(new c(this, swanAppBottomTabIconView, BitmapFactory.decodeFile(str)));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.i = str;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            for (int i = 0; i < this.g.size(); i++) {
                if (this.g.get(i).a.equals(str)) {
                    u(i);
                    this.c = i;
                    return;
                }
            }
        }
    }

    public void f(View view2, Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, view2, context, str) == null) && this.d.d2()) {
            SwanAppConfigData s = wl2.U().s();
            if (s == null) {
                if (j) {
                    Log.e("bottomBarViewController", "configData is null." + Log.getStackTraceString(new Exception()));
                    return;
                }
                return;
            }
            SwanAppConfigData.n nVar = s.f;
            this.e = nVar;
            List<SwanAppConfigData.o> list = nVar.e;
            this.g = list;
            int size = list.size();
            this.f = new ArrayList<>(size);
            this.a = view2.findViewById(R.id.obfuscated_res_0x7f0903c2);
            y(this.e.c);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090178);
            this.b = linearLayout;
            linearLayout.setVisibility(0);
            this.b.setBackgroundColor(this.e.d);
            boolean z = false;
            for (int i = 0; i < size; i++) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = new SwanAppBottomTabIconView(context);
                SwanAppConfigData.o oVar = this.g.get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, size);
                layoutParams.gravity = 1;
                if (TextUtils.equals(oVar.a, !TextUtils.isEmpty(str) ? str : wl2.U().g()) && !z) {
                    C(swanAppBottomTabIconView, oVar);
                    this.c = i;
                    z = true;
                } else {
                    A(swanAppBottomTabIconView, oVar);
                }
                swanAppBottomTabIconView.setTextView(oVar.d);
                swanAppBottomTabIconView.setOnClickListener(new a(this, i));
                this.f.add(swanAppBottomTabIconView);
                this.b.addView(swanAppBottomTabIconView, layoutParams);
            }
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            String uuid = UUID.randomUUID().toString();
            pt2.b(uuid);
            u(i);
            v(i);
            if (this.c == i) {
                return;
            }
            this.c = i;
            this.d.pause();
            jq2 d2 = jq2.d(this.g.get(i).a, wl2.U().z());
            d2.e = "5";
            d2.f = uuid;
            x63.g(d2);
            this.d.k3(d2, uuid);
            rz1.T3("switchTab");
            this.d.resume();
        }
    }

    public boolean h(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, str, str2, str3, str4)) == null) {
            if (this.a == null || this.b == null) {
                return false;
            }
            y(SwanAppConfigData.t(str4));
            z(str3);
            B(str);
            D(str2);
            Iterator<SwanAppBottomTabIconView> it = this.f.iterator();
            while (it.hasNext()) {
                SwanAppBottomTabIconView next = it.next();
                if (next.a()) {
                    next.setTextColor(SwanAppConfigData.t(str2));
                } else {
                    next.setTextColor(SwanAppConfigData.t(str));
                }
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (q(i)) {
                this.f.get(i).setBadgeVisibleState(false);
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
            View view2 = this.a;
            if (view2 == null || this.b == null) {
                return false;
            }
            view2.setVisibility(8);
            if (z) {
                l();
                return true;
            }
            this.b.setVisibility(8);
            return true;
        }
        return invokeZ.booleanValue;
    }

    @AnyThread
    public boolean k(int i) {
        InterceptResult invokeI;
        SwanAppBottomTabIconView swanAppBottomTabIconView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (q(i) && (swanAppBottomTabIconView = this.f.get(i)) != null) {
                de3.e0(new f(this, swanAppBottomTabIconView));
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, AnimationProperty.TRANSLATE_Y, 0.0f, qj2.c().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700fc));
            ofFloat.setDuration(240L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addListener(new d(this));
            ofFloat.start();
        }
    }

    public LinearLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.b : (LinearLayout) invokeV.objValue;
    }

    public final gl2 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            j03 L = j03.L();
            if (L != null) {
                return L.X();
            }
            return null;
        }
        return (gl2) invokeV.objValue;
    }

    public int o(String str) {
        InterceptResult invokeL;
        List<SwanAppConfigData.o> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (list = this.g) != null && list.size() != 0) {
                for (int i = 0; i < this.g.size(); i++) {
                    SwanAppConfigData.o oVar = this.g.get(i);
                    if (oVar != null && TextUtils.equals(oVar.a, str)) {
                        return i;
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
            LinearLayout linearLayout = this.b;
            return linearLayout != null && linearLayout.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            ArrayList<SwanAppBottomTabIconView> arrayList = this.f;
            return arrayList != null && i < arrayList.size() && i >= 0;
        }
        return invokeI.booleanValue;
    }

    public boolean r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            View view2 = this.a;
            if (view2 == null || this.b == null) {
                return false;
            }
            view2.setVisibility(0);
            this.b.setVisibility(0);
            t(z);
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (q(i)) {
                this.f.get(i).setRedDotVisibleState(true);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, AnimationProperty.TRANSLATE_Y, qj2.c().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700fc), 0.0f);
            ofFloat.setDuration(z ? 240L : 0L);
            ofFloat.start();
        }
    }

    public final void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            A(this.f.get(this.c), this.g.get(this.c));
            C(this.f.get(i), this.g.get(i));
        }
    }

    public final void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            HashMap hashMap = new HashMap();
            SwanAppConfigData.o oVar = this.g.get(i);
            String v3 = this.d.v3(jq2.d(oVar.a, wl2.U().z()).a);
            hashMap.put("index", String.valueOf(i));
            hashMap.put("pagePath", oVar.a);
            hashMap.put("text", oVar.d);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, v3);
            wl2.U().u(new ka2("onTabItemTap", hashMap));
        }
    }

    public boolean w(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i, str)) == null) {
            if (q(i)) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f.get(i);
                swanAppBottomTabIconView.setBadgeVisibleState(true);
                swanAppBottomTabIconView.setBadgeText(str);
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public boolean x(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            if (q(i)) {
                SwanAppBottomTabIconView swanAppBottomTabIconView = this.f.get(i);
                de3.e0(new e(this, swanAppBottomTabIconView, str));
                if (!TextUtils.isEmpty(str2)) {
                    this.g.get(i).b = str2;
                }
                if (!TextUtils.isEmpty(str3)) {
                    this.g.get(i).c = str3;
                }
                if (swanAppBottomTabIconView.a()) {
                    return C(swanAppBottomTabIconView, this.g.get(i));
                }
                return A(swanAppBottomTabIconView, this.g.get(i));
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void y(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i) == null) || AppRuntime.getAppContext() == null) {
            return;
        }
        if (-1 == i) {
            this.a.setVisibility(0);
            this.a.setBackgroundColor(-1);
        } else if (-16777216 == i) {
            this.a.setVisibility(0);
            this.a.setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f0603dc));
        } else {
            this.a.setVisibility(0);
            this.a.setBackgroundColor(-1);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.b.setBackgroundColor(SwanAppConfigData.t(str));
        }
    }
}
