package com.repackage;

import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dv5;
import com.repackage.wt8;
/* loaded from: classes5.dex */
public class ev5 implements dv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wt8 a;
    public TextView b;
    public dv5.c c;
    public dv5.b d;
    public dv5.a e;

    /* loaded from: classes5.dex */
    public class a implements wt8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ev5 a;

        public a(ev5 ev5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ev5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ev5Var;
        }

        @Override // com.repackage.wt8.a
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.d != null) {
                    return this.a.d.a();
                }
                return 1.0f;
            }
            return invokeV.floatValue;
        }

        @Override // com.repackage.wt8.a
        public void b(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                if (this.a.e != null) {
                    this.a.e.a(f);
                }
                TextView textView = this.a.b;
                ev5 ev5Var = this.a;
                textView.setText(ev5Var.h(ev5Var.getProgress()));
            }
        }

        @Override // com.repackage.wt8.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.a();
        }

        @Override // com.repackage.wt8.a
        public void onProgress(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
                this.a.b.setText(this.a.h(f));
            }
        }
    }

    public ev5(wt8 wt8Var, TextView textView, dv5.c cVar, dv5.b bVar, dv5.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wt8Var, textView, cVar, bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = wt8Var;
        this.b = textView;
        this.c = cVar;
        this.d = bVar;
        this.e = aVar;
        i();
    }

    @Override // com.repackage.dv5
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var != null) {
                wt8Var.a();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.dv5
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var != null) {
                return wt8Var.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.dv5
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var != null) {
                return wt8Var.getMaxDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.dv5
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var != null) {
                return wt8Var.getProgress();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.repackage.dv5
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var != null) {
                return wt8Var.getSlideNum();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final String h(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f)) == null) {
            if (f >= getMaxDuration()) {
                f = getMaxDuration();
            }
            if (f > 60.0f) {
                return ((int) (f / 60.0f)) + "'" + String.format("%.1f", Float.valueOf(f % 60.0f));
            }
            return String.format("%.1f", Float.valueOf(f));
        }
        return (String) invokeF.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var == null) {
                return false;
            }
            wt8Var.setOnProgressListener(new a(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.dv5
    public boolean pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var != null) {
                wt8Var.stop();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.dv5
    public boolean reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var != null) {
                wt8Var.reset();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.dv5
    public boolean setMaxDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var != null) {
                wt8Var.setMaxDuration(i);
                this.a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.repackage.dv5
    public boolean setMinDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var != null) {
                wt8Var.setMinDuration(i);
                this.a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.repackage.dv5
    public boolean setProgress(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var != null) {
                wt8Var.setProgress(j);
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // com.repackage.dv5
    public boolean setShowDeleteLastTip(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var != null) {
                wt8Var.setShowDeleteLastTip(z);
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.repackage.dv5
    public boolean start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            wt8 wt8Var = this.a;
            if (wt8Var != null) {
                wt8Var.start();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
