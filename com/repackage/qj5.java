package com.repackage;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class qj5 implements sj5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String f = "qj5";
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public final jj5 b;
    public final DownloadCacheKey c;
    public int d;
    public final Set<tj5> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755378187, "Lcom/repackage/qj5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755378187, "Lcom/repackage/qj5;");
        }
    }

    public qj5(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadCacheKey};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Object();
        this.d = 0;
        this.e = new HashSet();
        this.c = downloadCacheKey;
        this.b = new jj5();
    }

    @Override // com.repackage.sj5
    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) || this.c == null) {
            return;
        }
        if (um4.e()) {
            String str2 = f;
            Log.e(str2, str + " pause download");
        }
        AdDownloadData b = lj5.d().b(this.c);
        b.extra().setStatus(DownloadStatus.STATUS_PAUSED);
        if (f()) {
            return;
        }
        for (tj5 tj5Var : this.e) {
            tj5Var.c(this.c, b.getPercent());
        }
    }

    @Override // com.repackage.sj5
    public void b(String str, StopStatus stopStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, stopStatus) == null) || this.c == null) {
            return;
        }
        if (um4.e()) {
            String str2 = f;
            Log.e(str2, str + " stop download");
        }
        lj5.d().b(this.c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (tj5 tj5Var : this.e) {
            tj5Var.f(this.c, stopStatus);
        }
    }

    @Override // com.repackage.sj5
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.c == null) {
            return;
        }
        if (um4.e()) {
            String str2 = f;
            Log.e(str2, str + " start downloading");
        }
        lj5.d().b(this.c).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
        if (f()) {
            return;
        }
        for (tj5 tj5Var : this.e) {
            tj5Var.e(this.c);
        }
    }

    @Override // com.repackage.sj5
    public void d(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) || this.c == null) {
            return;
        }
        if (um4.e()) {
            String str2 = f;
            Log.e(str2, str + " downloading: " + String.valueOf(i));
        }
        AdDownloadData b = lj5.d().b(this.c);
        b.extra().setPercent(i);
        if (f()) {
            return;
        }
        for (tj5 tj5Var : this.e) {
            tj5Var.g(this.c, b.getPercent());
        }
    }

    public boolean e(tj5 tj5Var) {
        InterceptResult invokeL;
        boolean add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tj5Var)) == null) {
            synchronized (this.a) {
                add = this.e.add(tj5Var);
            }
            return add;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e.isEmpty() : invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.c == null) {
            return;
        }
        AdDownloadData b = lj5.d().b(this.c);
        this.b.b(710, this.c.mPackageName, b.getExtInfo(), b);
        b.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        b.extra().setPercent(100);
        if (f()) {
            return;
        }
        for (tj5 tj5Var : this.e) {
            tj5Var.b(this.c);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.c == null) {
            return;
        }
        lj5.d().b(this.c).extra().setStatus(DownloadStatus.STATUS_NONE);
        if (f()) {
            return;
        }
        for (tj5 tj5Var : this.e) {
            tj5Var.d(this.c);
        }
    }

    public boolean i(tj5 tj5Var) {
        InterceptResult invokeL;
        boolean remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tj5Var)) == null) {
            synchronized (this.a) {
                remove = this.e.remove(tj5Var);
            }
            return remove;
        }
        return invokeL.booleanValue;
    }

    public void j(int i, @Nullable String str, String str2, AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), str, str2, adDownloadData}) == null) {
            this.b.b(i, str, str2, adDownloadData);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.d = i;
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.d : invokeV.intValue;
    }

    @Override // com.repackage.sj5
    public void onSuccess(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) || this.c == null) {
            return;
        }
        AdDownloadData b = lj5.d().b(this.c);
        this.b.b(704, this.c.mPackageName, b.getExtInfo(), b);
        if (um4.e()) {
            String str3 = f;
            Log.e(str3, str + " download succeed");
        }
        b.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        b.extra().setPercent(100);
        lj5.d().b(this.c).extra().setDownloadPath(str2);
        if (f()) {
            return;
        }
        for (tj5 tj5Var : this.e) {
            tj5Var.a(this.c, str2, false);
        }
    }
}
