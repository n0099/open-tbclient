package com.repackage;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.widget.floatball.FullScreenLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class ew6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<Activity> a;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ew6 ew6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew6Var, Integer.valueOf(i)};
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
            this.a = ew6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof pq4)) {
                this.a.d((pq4) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mf5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ew6 ew6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.mf5
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                fw6.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final ew6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-400497906, "Lcom/repackage/ew6$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-400497906, "Lcom/repackage/ew6$c;");
                    return;
                }
            }
            a = new ew6();
        }
    }

    public ew6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashSet();
    }

    public static ew6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a : (ew6) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().registerListener(new a(this, 2921698));
        }
    }

    public final void d(pq4 pq4Var) {
        Activity activity;
        m05 m05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pq4Var) == null) || pq4Var == null || (activity = pq4Var.b) == null || pq4Var.c == null || !"com.duowan.mobile.basemedia.watchlive.activity.LiveTemplateActivity".equals(activity.getClass().getName())) {
            return;
        }
        if (!Lifecycle.Event.ON_START.equals(pq4Var.c)) {
            if (Lifecycle.Event.ON_DESTROY.equals(pq4Var.c)) {
                this.a.remove(pq4Var.b);
            }
        } else if (this.a.contains(pq4Var.b) || (m05Var = TbSingleton.getInstance().mLiveActivityGuide) == null || !m05Var.isValid()) {
        } else {
            FullScreenLayout fullScreenLayout = new FullScreenLayout(pq4Var.b);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            fullScreenLayout.setFloatData(m05Var);
            fullScreenLayout.setClickListener(new b(this));
            pq4Var.b.addContentView(fullScreenLayout, layoutParams);
            fw6.b();
            this.a.add(pq4Var.b);
            pq4Var.b.getWindow().setCallback(new dw6(pq4Var.b, fullScreenLayout));
        }
    }
}
