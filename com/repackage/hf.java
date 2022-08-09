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
/* loaded from: classes6.dex */
public class hf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Configuration a;
    public boolean b;
    public List<ff> c;
    public a d;

    /* loaded from: classes6.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public hf() {
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

    public hf a(ff ffVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ffVar)) == null) {
            if (!this.b) {
                this.c.add(ffVar);
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (hf) invokeL.objValue;
    }

    public gf b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            gf gfVar = new gf();
            gfVar.i((ff[]) this.c.toArray(new ff[this.c.size()]));
            gfVar.j(this.a);
            gfVar.h(this.d);
            this.c = null;
            this.a = null;
            this.d = null;
            this.b = true;
            return gfVar;
        }
        return (gf) invokeV.objValue;
    }

    public hf c(int i) {
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
        return (hf) invokeI.objValue;
    }

    public hf d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (!this.b) {
                this.a.mAutoDismiss = z;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (hf) invokeZ.objValue;
    }

    public hf e(int i) {
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
        return (hf) invokeI.objValue;
    }

    public hf f(int i) {
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
        return (hf) invokeI.objValue;
    }

    public hf g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (!this.b) {
                this.a.mKeyBackEventDismiss = z;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (hf) invokeZ.objValue;
    }

    public hf h(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (!this.b) {
                this.d = aVar;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (hf) invokeL.objValue;
    }

    public hf i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.a.mOutsideTouchable = z;
            return this;
        }
        return (hf) invokeZ.objValue;
    }

    public hf j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            if (!this.b) {
                this.a.mOverlayTarget = z;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (hf) invokeZ.objValue;
    }

    public hf k(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view2)) == null) {
            if (this.b) {
                throw new BuildException("Already created. rebuild a new one.");
            }
            if (view2 != null) {
                this.a.mTargetView = view2;
                return this;
            }
            throw new BuildException("Illegal view.");
        }
        return (hf) invokeL.objValue;
    }

    public hf l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (this.b) {
                throw new BuildException("Already created. rebuild a new one.");
            }
            if (i > 0) {
                this.a.mTargetViewId = i;
                return this;
            }
            throw new BuildException("Illegal view id.");
        }
        return (hf) invokeI.objValue;
    }
}
