package com.kwai.sodler.lib.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String aix;
    public String axW;
    public final byte[] axY;
    public e axx;
    public int ayb;
    public int ayc;
    public StringBuffer ayd;
    public String aye;
    public String ayf;
    public boolean ayg;
    public a ayh;
    public com.kwai.sodler.lib.ext.b ayi;
    public Throwable ayj;
    public long ayk;
    public List ayl;
    public com.kwai.sodler.lib.c.b aym;
    public String mDownloadUrl;
    public int mState;
    public String mVersion;

    public f() {
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
        this.mState = -1;
        this.ayb = 0;
        this.axY = new byte[0];
        this.ayd = new StringBuffer(String.valueOf(-1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(com.kwai.sodler.lib.c.b bVar) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.aym = bVar;
        this.axW = bVar.ayz;
        this.mVersion = bVar.version;
    }

    private List ak(String str, String str2) {
        InterceptResult invokeLL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(this.axx.Fa().eP(str));
                if (file.exists() && (list = file.list()) != null && list.length != 0) {
                    for (String str3 : list) {
                        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || !str2.equals(str3) || !this.axx.Fa().aj(str, str3)) {
                            this.axx.Fa().ag(str, str3);
                        } else {
                            com.kwai.sodler.lib.c.a aVar = new com.kwai.sodler.lib.c.a();
                            aVar.ayz = str;
                            aVar.version = str3;
                            aVar.nQ = true;
                            arrayList.add(aVar);
                        }
                    }
                    Collections.sort(arrayList);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public final e Fk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.axx : (e) invokeV.objValue;
    }

    public final String Fl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.ayd.toString() : (String) invokeV.objValue;
    }

    public final Throwable Fm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ayj : (Throwable) invokeV.objValue;
    }

    public final boolean Fn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            cG(-1);
            this.ayl = null;
            int i = this.ayb + 1;
            this.ayb = i;
            return i <= this.ayc;
        }
        return invokeV.booleanValue;
    }

    public final boolean Fo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.ayg : invokeV.booleanValue;
    }

    public final int Fp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.ayb : invokeV.intValue;
    }

    public final String Fq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !TextUtils.isEmpty(this.aye) ? this.aye : this.ayf : (String) invokeV.objValue;
    }

    public final a Fr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.ayh : (a) invokeV.objValue;
    }

    public final com.kwai.sodler.lib.ext.b Fs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.ayi : (com.kwai.sodler.lib.ext.b) invokeV.objValue;
    }

    public final String Ft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.aix : (String) invokeV.objValue;
    }

    public final List Fu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.ayl : (List) invokeV.objValue;
    }

    public final com.kwai.sodler.lib.c.b Fv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.aym : (com.kwai.sodler.lib.c.b) invokeV.objValue;
    }

    public final void Fw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String id = getId();
            if (TextUtils.isEmpty(id) || this.ayl != null) {
                return;
            }
            this.ayl = ak(id, getVersion());
        }
    }

    public final void Fx() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            cG(-3);
        }
    }

    public final f a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, eVar)) == null) {
            this.axx = eVar;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final void a(com.kwai.sodler.lib.ext.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.ayi = bVar;
        }
    }

    @Deprecated
    public final void ad(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.ayk = j;
        }
    }

    public final void b(com.kwai.sodler.lib.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.aym = bVar;
        }
    }

    public final void c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.ayh = aVar;
        }
    }

    public final f cG(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            synchronized (this.axY) {
                this.mState = i;
            }
            return eW(String.valueOf(i));
        }
        return (f) invokeI.objValue;
    }

    public final void cH(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i) == null) || i <= 0) {
            return;
        }
        this.ayc = i;
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.axY) {
                cG(-7);
            }
        }
    }

    public final void eT(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.mVersion = str;
        }
    }

    public final f eW(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                StringBuffer stringBuffer = this.ayd;
                stringBuffer.append(" --> ");
                stringBuffer.append(str);
            }
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final void eX(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.aye = str;
        }
    }

    public final void eY(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.ayf = str;
        }
    }

    public final void eZ(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.aix = str;
        }
    }

    public final void fa(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.mDownloadUrl = str;
        }
    }

    public abstract a fb(String str);

    public final String getDownloadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mDownloadUrl : (String) invokeV.objValue;
    }

    public final String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.axW : (String) invokeV.objValue;
    }

    public final int getState() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            synchronized (this.axY) {
                i = this.mState;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mVersion : (String) invokeV.objValue;
    }

    public final boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mState == -7 : invokeV.booleanValue;
    }

    public final f q(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, th)) == null) {
            this.ayj = th;
            return eW(th.getLocalizedMessage());
        }
        return (f) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return "PluginRequest{mId='" + this.axW + "'}";
        }
        return (String) invokeV.objValue;
    }
}
