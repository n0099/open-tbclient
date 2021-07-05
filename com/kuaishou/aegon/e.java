package com.kuaishou.aegon;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final /* synthetic */ class e implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SignalStrengthListener f34018a;

    /* renamed from: b  reason: collision with root package name */
    public final int f34019b;

    /* renamed from: c  reason: collision with root package name */
    public final int f34020c;

    public e(SignalStrengthListener signalStrengthListener, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signalStrengthListener, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34018a = signalStrengthListener;
        this.f34019b = i2;
        this.f34020c = i3;
    }

    public static Runnable a(SignalStrengthListener signalStrengthListener, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, signalStrengthListener, i2, i3)) == null) ? new e(signalStrengthListener, i2, i3) : (Runnable) invokeLII.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f34018a.nativeOnSignalStrengthValueUpdate(this.f34019b, this.f34020c);
        }
    }
}
