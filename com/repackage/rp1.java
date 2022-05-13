package com.repackage;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xo1;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rp1 extends np1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements xo1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp1 a;

        /* renamed from: com.repackage.rp1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0504a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            /* renamed from: com.repackage.rp1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0505a implements ValueAnimator.AnimatorUpdateListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ bn1 a;

                public C0505a(RunnableC0504a runnableC0504a, bn1 bn1Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0504a, bn1Var};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = bn1Var;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                        this.a.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            }

            public RunnableC0504a(a aVar, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = i;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                bn1 i;
                int f;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i = hm2.U().i()) == null) {
                    return;
                }
                if (!(i instanceof NgWebView)) {
                    f = le3.f(this.c.a.getContext(), this.a);
                } else {
                    f = rp1.z(i, le3.f(this.c.a.getContext(), this.a));
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(i.getWebViewScrollY(), f);
                ofInt.setDuration(this.b);
                ofInt.addUpdateListener(new C0505a(this, i));
                ofInt.start();
            }
        }

        public a(rp1 rp1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp1Var;
        }

        @Override // com.repackage.xo1.a
        public us1 a(u03 u03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, u03Var, jSONObject, str)) == null) {
                int optInt = jSONObject.optInt("scrollTop", -1);
                int optInt2 = jSONObject.optInt("duration", -1);
                if (optInt > -1 && optInt2 > -1) {
                    oe3.e0(new RunnableC0504a(this, optInt, optInt2));
                    return new us1(0);
                }
                ux1.c("PageScrollToApi", "illegal scrollTop or duration");
                return new us1(1001, "illegal params");
            }
            return (us1) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rp1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static int z(@NonNull bn1 bn1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bn1Var, i)) == null) {
            int contentHeight = ((int) (bn1Var.getContentHeight() * bn1Var.getScale())) - ((Integer) hm2.U().r().second).intValue();
            if (contentHeight <= 0) {
                return 0;
            }
            return i > contentHeight ? contentHeight : i;
        }
        return invokeLI.intValue;
    }

    public us1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#pageScrollTo", false);
            return l(str, false, new a(this));
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "PageScrollToApi" : (String) invokeV.objValue;
    }
}
