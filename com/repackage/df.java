package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.guide.BuildException;
import com.baidu.adp.lib.guide.Configuration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class df {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Configuration a;
    public boolean b;
    public List<bf> c;
    public a d;

    /* loaded from: classes5.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public df() {
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
        this.c = new ArrayList();
        this.a = new Configuration();
    }

    public df a(bf bfVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bfVar)) == null) {
            if (!this.b) {
                this.c.add(bfVar);
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (df) invokeL.objValue;
    }

    public cf b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cf cfVar = new cf();
            cfVar.j((bf[]) this.c.toArray(new bf[this.c.size()]));
            cfVar.k(this.a);
            cfVar.i(this.d);
            this.c = null;
            this.a = null;
            this.d = null;
            this.b = true;
            return cfVar;
        }
        return (cf) invokeV.objValue;
    }

    public df c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (this.b) {
                throw new BuildException("Already created. rebuild a new one.");
            }
            if (i >= 0 && i <= 255) {
                this.a.mAlpha = i;
                return this;
            }
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        return (df) invokeI.objValue;
    }

    public df d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (!this.b) {
                this.a.mAutoDismiss = z;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (df) invokeZ.objValue;
    }

    public df e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (this.b) {
                throw new BuildException("Already created. rebuild a new one.");
            }
            if (i > 0) {
                this.a.mEnterAnimationId = i;
                return this;
            }
            throw new BuildException("Illegal animation resource id.");
        }
        return (df) invokeI.objValue;
    }

    public df f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (this.b) {
                throw new BuildException("Already created. rebuild a new one.");
            }
            if (i > 0) {
                this.a.mExitAnimationId = i;
                return this;
            }
            throw new BuildException("Illegal animation resource id.");
        }
        return (df) invokeI.objValue;
    }

    public df g(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            if (!this.b) {
                this.d = aVar;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (df) invokeL.objValue;
    }

    public df h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.a.mOutsideTouchable = z;
            return this;
        }
        return (df) invokeZ.objValue;
    }

    public df i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (!this.b) {
                this.a.mOverlayTarget = z;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (df) invokeZ.objValue;
    }

    public df j(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view2)) == null) {
            if (this.b) {
                throw new BuildException("Already created. rebuild a new one.");
            }
            if (view2 != null) {
                this.a.mTargetView = view2;
                return this;
            }
            throw new BuildException("Illegal view.");
        }
        return (df) invokeL.objValue;
    }

    public df k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.b) {
                throw new BuildException("Already created. rebuild a new one.");
            }
            if (i > 0) {
                this.a.mTargetViewId = i;
                return this;
            }
            throw new BuildException("Illegal view id.");
        }
        return (df) invokeI.objValue;
    }
}
