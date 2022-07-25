package com.repackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class ad5 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<WeakReference<Activity>> a;
    public ArrayList<WeakReference<Activity>> b;
    public int c;
    public final CustomMessageListener d;
    public final lm4 e;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ad5 ad5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ad5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int skinType;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer) && this.a.c != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
                this.a.c = skinType;
                if (ad5.f) {
                    this.a.r();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends lm4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad5 a;

        public b(ad5 ad5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ad5Var;
        }

        @Override // com.repackage.lm4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
                this.a.b.add(new WeakReference(activity));
            }
        }

        @Override // com.repackage.lm4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                Iterator it = this.a.b.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() != null && weakReference.get() == activity) {
                        this.a.b.remove(weakReference);
                        return;
                    }
                }
            }
        }

        @Override // com.repackage.lm4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && ad5.f) {
                ad5 ad5Var = this.a;
                if (ad5Var.j(ad5Var.l(activity))) {
                    this.a.a.add(new WeakReference(activity));
                }
            }
        }

        @Override // com.repackage.lm4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && ad5.f) {
                ad5 ad5Var = this.a;
                if (ad5Var.t(ad5Var.l(activity))) {
                    Iterator it = this.a.a.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (activity != null && activity == weakReference.get()) {
                            this.a.a.remove(weakReference);
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ad5 a;

        public c(ad5 ad5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ad5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q(view2.getContext());
                this.a.u(false);
                this.a.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final ad5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-532591169, "Lcom/repackage/ad5$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-532591169, "Lcom/repackage/ad5$d;");
                    return;
                }
            }
            a = new ad5(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755860609, "Lcom/repackage/ad5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755860609, "Lcom/repackage/ad5;");
        }
    }

    public /* synthetic */ ad5(a aVar) {
        this();
    }

    public static final ad5 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? d.a : (ad5) invokeV.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    public final boolean j(FrameLayout frameLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, frameLayout)) == null) {
            if (frameLayout == null) {
                return false;
            }
            try {
                Object tag = frameLayout.getTag(R.id.obfuscated_res_0x7f091f2e);
                ViewGroup viewGroup = 0;
                ViewGroup viewGroup2 = tag instanceof ViewGroup ? (ViewGroup) tag : null;
                if (viewGroup2 == null || viewGroup2.getParent() == null) {
                    viewGroup = viewGroup2;
                } else if (viewGroup2.getParent() == frameLayout) {
                    return false;
                } else {
                    frameLayout.setTag(R.id.obfuscated_res_0x7f091f2e, null);
                }
                if (viewGroup == null) {
                    viewGroup = n(frameLayout.getContext());
                }
                if (viewGroup == null) {
                    return false;
                }
                frameLayout.addView(viewGroup);
                frameLayout.setTag(R.id.obfuscated_res_0x7f091f2e, viewGroup);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds339), pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds89));
                layoutParams.gravity = 83;
                layoutParams.bottomMargin = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds442) + UtilHelper.getNavigationBarHeight(frameLayout.getContext());
                viewGroup.setLayoutParams(layoutParams);
                c cVar = new c(this);
                viewGroup.setClickable(true);
                viewGroup.setOnClickListener(cVar);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BackBaiduBoxViewEvent backBaiduBoxViewEvent = new BackBaiduBoxViewEvent();
            backBaiduBoxViewEvent.isShow = f;
            s65.i(backBaiduBoxViewEvent);
        }
    }

    public final FrameLayout l(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity != null) {
                try {
                    if (!activity.isFinishing() && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                        View decorView = activity.getWindow().getDecorView();
                        if (decorView instanceof FrameLayout) {
                            return (FrameLayout) decorView;
                        }
                        return null;
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (FrameLayout) invokeL.objValue;
    }

    public final ViewGroup n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0485, (ViewGroup) null);
            o(viewGroup, context);
            return viewGroup;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public final void o(ViewGroup viewGroup, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, viewGroup, context) == null) || viewGroup == null || context == null) {
            return;
        }
        SkinManager.setViewTextColor((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09220c), (int) R.color.CAM_X0101);
        float f2 = pi.f(context, R.dimen.tbds424);
        TBSelector.makeDrawableSelector().setShape(0).setType(1).trRadius(f2).brRadius(f2).defaultColor(R.color.topic_disagree_des_color).into(viewGroup);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091d7f), R.drawable.obfuscated_res_0x7f0805f5, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange((ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091d80), R.drawable.obfuscated_res_0x7f0805d5, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public final boolean p(View view2) {
        InterceptResult invokeL;
        IBinder windowToken;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            if (view2 == null || (windowToken = view2.getWindowToken()) == null) {
                return false;
            }
            try {
                if (windowToken.isBinderAlive()) {
                    return windowToken.pingBinder();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, context) == null) || context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://donothing"));
            if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                context.startActivity(intent);
            } else {
                v();
            }
        } catch (Exception unused) {
            v();
        }
    }

    public final void r() {
        FrameLayout l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<WeakReference<Activity>> it = this.a.iterator();
            while (it.hasNext()) {
                WeakReference<Activity> next = it.next();
                if (next != null && next.get() != null && !next.get().isFinishing() && (l = l(next.get())) != null) {
                    Object tag = l.getTag(R.id.obfuscated_res_0x7f091f2e);
                    if (tag instanceof ViewGroup) {
                        o((ViewGroup) tag, l.getContext());
                    }
                }
            }
        }
    }

    public void s(Application application) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, application) == null) || application == null) {
            return;
        }
        try {
            application.registerActivityLifecycleCallbacks(this.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean t(FrameLayout frameLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, frameLayout)) == null) {
            if (frameLayout == null) {
                return false;
            }
            try {
                Object tag = frameLayout.getTag(R.id.obfuscated_res_0x7f091f2e);
                ViewGroup viewGroup = tag instanceof ViewGroup ? (ViewGroup) tag : null;
                if (viewGroup != null && viewGroup.getParent() != null && viewGroup.getParent() == frameLayout && p(frameLayout) && p(viewGroup)) {
                    frameLayout.removeView(viewGroup);
                    frameLayout.setTag(R.id.obfuscated_res_0x7f091f2e, null);
                    return true;
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || f == z) {
            return;
        }
        f = z;
        if (z) {
            Iterator<WeakReference<Activity>> it = this.b.iterator();
            while (it.hasNext()) {
                WeakReference<Activity> next = it.next();
                if (next.get() != null && !next.get().isFinishing()) {
                    Activity activity = next.get();
                    if (j(l(activity))) {
                        this.a.add(new WeakReference<>(activity));
                    }
                }
            }
            return;
        }
        Iterator<WeakReference<Activity>> it2 = this.b.iterator();
        while (it2.hasNext()) {
            WeakReference<Activity> next2 = it2.next();
            if (next2.get() != null && !next2.get().isFinishing()) {
                t(l(next2.get()));
            }
        }
        this.a.clear();
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            pi.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0c79);
        }
    }

    public ad5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.c = TbadkCoreApplication.getInst().getSkinType();
        this.d = new a(this, 2001304);
        this.e = new b(this);
        MessageManager.getInstance().registerListener(this.d);
    }
}
