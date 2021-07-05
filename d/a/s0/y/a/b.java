package d.a.s0.y.a;

import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.y.a.a;
import d.a.s0.z3.m.a;
/* loaded from: classes9.dex */
public class b implements d.a.s0.y.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.s0.z3.m.a f69480a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f69481b;

    /* renamed from: c  reason: collision with root package name */
    public a.c f69482c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f69483d;

    /* renamed from: e  reason: collision with root package name */
    public a.InterfaceC1888a f69484e;

    /* loaded from: classes9.dex */
    public class a implements a.InterfaceC1919a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f69485a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69485a = bVar;
        }

        @Override // d.a.s0.z3.m.a.InterfaceC1919a
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f69485a.f69483d != null) {
                    return this.f69485a.f69483d.a();
                }
                return 1.0f;
            }
            return invokeV.floatValue;
        }

        @Override // d.a.s0.z3.m.a.InterfaceC1919a
        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                if (this.f69485a.f69484e != null) {
                    this.f69485a.f69484e.a(f2);
                }
                TextView textView = this.f69485a.f69481b;
                b bVar = this.f69485a;
                textView.setText(bVar.h(bVar.getProgress()));
            }
        }

        @Override // d.a.s0.z3.m.a.InterfaceC1919a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f69485a.f69482c == null) {
                return;
            }
            this.f69485a.f69482c.a();
        }

        @Override // d.a.s0.z3.m.a.InterfaceC1919a
        public void onProgress(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                this.f69485a.f69481b.setText(this.f69485a.h(f2));
            }
        }
    }

    public b(d.a.s0.z3.m.a aVar, TextView textView, a.c cVar, a.b bVar, a.InterfaceC1888a interfaceC1888a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, textView, cVar, bVar, interfaceC1888a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69480a = aVar;
        this.f69481b = textView;
        this.f69482c = cVar;
        this.f69483d = bVar;
        this.f69484e = interfaceC1888a;
        i();
    }

    @Override // d.a.s0.y.a.a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar != null) {
                aVar.a();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.y.a.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar != null) {
                return aVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.y.a.a
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar != null) {
                return aVar.getMaxDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.s0.y.a.a
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar != null) {
                return aVar.getProgress();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // d.a.s0.y.a.a
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar != null) {
                return aVar.getSlideNum();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final String h(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
            if (f2 >= getMaxDuration()) {
                f2 = getMaxDuration();
            }
            if (f2 > 60.0f) {
                return ((int) (f2 / 60.0f)) + "'" + String.format("%.1f", Float.valueOf(f2 % 60.0f));
            }
            return String.format("%.1f", Float.valueOf(f2));
        }
        return (String) invokeF.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar == null) {
                return false;
            }
            aVar.setOnProgressListener(new a(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.y.a.a
    public boolean pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar != null) {
                aVar.stop();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.y.a.a
    public boolean reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar != null) {
                aVar.reset();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.y.a.a
    public boolean setMaxDuration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar != null) {
                aVar.setMaxDuration(i2);
                this.f69480a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // d.a.s0.y.a.a
    public boolean setMinDuration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar != null) {
                aVar.setMinDuration(i2);
                this.f69480a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // d.a.s0.y.a.a
    public boolean setProgress(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar != null) {
                aVar.setProgress(j);
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // d.a.s0.y.a.a
    public boolean setShowDeleteLastTip(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar != null) {
                aVar.setShowDeleteLastTip(z);
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // d.a.s0.y.a.a
    public boolean start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d.a.s0.z3.m.a aVar = this.f69480a;
            if (aVar != null) {
                aVar.start();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
