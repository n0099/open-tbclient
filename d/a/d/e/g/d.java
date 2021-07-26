package d.a.d.e.g;

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
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Configuration f41672a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41673b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f41674c;

    /* renamed from: d  reason: collision with root package name */
    public a f41675d;

    /* loaded from: classes7.dex */
    public interface a {
        void onDismiss();

        void onShown();
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41674c = new ArrayList();
        this.f41672a = new Configuration();
    }

    public d a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (!this.f41673b) {
                this.f41674c.add(bVar);
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (d) invokeL.objValue;
    }

    public c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = new c();
            cVar.i((b[]) this.f41674c.toArray(new b[this.f41674c.size()]));
            cVar.j(this.f41672a);
            cVar.h(this.f41675d);
            this.f41674c = null;
            this.f41672a = null;
            this.f41675d = null;
            this.f41673b = true;
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public d c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f41673b) {
                throw new BuildException("Already created. rebuild a new one.");
            }
            if (i2 >= 0 && i2 <= 255) {
                this.f41672a.mAlpha = i2;
                return this;
            }
            throw new BuildException("Illegal alpha value, should between [0-255]");
        }
        return (d) invokeI.objValue;
    }

    public d d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (!this.f41673b) {
                this.f41672a.mAutoDismiss = z;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (d) invokeZ.objValue;
    }

    public d e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (this.f41673b) {
                throw new BuildException("Already created. rebuild a new one.");
            }
            if (i2 > 0) {
                this.f41672a.mEnterAnimationId = i2;
                return this;
            }
            throw new BuildException("Illegal animation resource id.");
        }
        return (d) invokeI.objValue;
    }

    public d f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (this.f41673b) {
                throw new BuildException("Already created. rebuild a new one.");
            }
            if (i2 > 0) {
                this.f41672a.mExitAnimationId = i2;
                return this;
            }
            throw new BuildException("Illegal animation resource id.");
        }
        return (d) invokeI.objValue;
    }

    public d g(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            if (!this.f41673b) {
                this.f41675d = aVar;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (d) invokeL.objValue;
    }

    public d h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f41672a.mOutsideTouchable = z;
            return this;
        }
        return (d) invokeZ.objValue;
    }

    public d i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (!this.f41673b) {
                this.f41672a.mOverlayTarget = z;
                return this;
            }
            throw new BuildException("Already created, rebuild a new one.");
        }
        return (d) invokeZ.objValue;
    }

    public d j(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
            if (this.f41673b) {
                throw new BuildException("Already created. rebuild a new one.");
            }
            if (view != null) {
                this.f41672a.mTargetView = view;
                return this;
            }
            throw new BuildException("Illegal view.");
        }
        return (d) invokeL.objValue;
    }

    public d k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (this.f41673b) {
                throw new BuildException("Already created. rebuild a new one.");
            }
            if (i2 > 0) {
                this.f41672a.mTargetViewId = i2;
                return this;
            }
            throw new BuildException("Illegal view id.");
        }
        return (d) invokeI.objValue;
    }
}
