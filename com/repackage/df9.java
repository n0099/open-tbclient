package com.repackage;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.of9;
import com.win.opensdk.PBError;
import com.win.opensdk.PBMediaView;
import com.win.opensdk.PBNative;
import com.win.opensdk.PBNativeListener;
import java.util.List;
/* loaded from: classes5.dex */
public class df9 extends ye9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PBNative a;

    /* loaded from: classes5.dex */
    public class a implements PBNativeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if9 a;

        public a(df9 df9Var, if9 if9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df9Var, if9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if9Var;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((of9.a) this.a).a();
            }
        }

        @Override // com.win.opensdk.PBNativeListener
        public void onDisplayed() {
            Ssp.Pid pid;
            Ssp.Pid pid2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                of9.a aVar = (of9.a) this.a;
                aVar.getClass();
                LogPrinter.d();
                aVar.d.onAdShow(aVar.c, aVar.a, new String[0]);
                aVar.a = true;
                synchronized (aVar.d.i) {
                    of9.b bVar = aVar.d.i.get(aVar.c);
                    if (bVar != null) {
                        FunAdInteractionListener funAdInteractionListener = bVar.c;
                        String str = bVar.a;
                        pid = aVar.d.mPid;
                        String str2 = pid.ssp.type;
                        pid2 = aVar.d.mPid;
                        funAdInteractionListener.onAdShow(str, str2, pid2.pid);
                    }
                }
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
                ((of9.a) this.a).b(pBError.getMsg(), pBError.getCode());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ((of9.a) this.a).c();
            }
        }
    }

    public df9(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new PBNative(context.getApplicationContext(), str);
    }

    @Override // com.repackage.ve9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.destroy();
        }
    }

    @Override // com.repackage.ve9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.load();
        }
    }

    @Override // com.repackage.ye9
    public void c(View view2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, obj) == null) {
            this.a.registerViewForInteraction(view2, (PBMediaView) obj);
        }
    }

    @Override // com.repackage.ye9
    public void d(View view2, Object obj, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, view2, obj, list) == null) {
            this.a.registerViewForInteraction(view2, (PBMediaView) obj, list);
        }
    }

    @Override // com.repackage.ye9
    public void e(if9 if9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, if9Var) == null) {
            this.a.setNativeListener(new a(this, if9Var));
        }
    }

    @Override // com.repackage.ye9
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.getBody() : (String) invokeV.objValue;
    }

    @Override // com.repackage.ye9
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.getCallToAction() : (String) invokeV.objValue;
    }

    @Override // com.repackage.ye9
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.getHeadline() : (String) invokeV.objValue;
    }

    @Override // com.repackage.ye9
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.getIM() : (String) invokeV.objValue;
    }

    @Override // com.repackage.ye9
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.getIcon() : (String) invokeV.objValue;
    }

    @Override // com.repackage.ye9
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.getMediaViewHeight() : invokeV.intValue;
    }

    @Override // com.repackage.ye9
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.getMediaViewWidth() : invokeV.intValue;
    }

    @Override // com.repackage.ye9
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.isD() : invokeV.booleanValue;
    }

    @Override // com.repackage.ye9
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a.isReady() : invokeV.booleanValue;
    }

    @Override // com.repackage.ye9
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            String adType = this.a.getAdType();
            adType.hashCode();
            return adType.equals("h5") || adType.equals("video");
        }
        return invokeV.booleanValue;
    }
}
