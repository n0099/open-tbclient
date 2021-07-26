package d.a.q0.y.a;

import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.y.a.a;
import d.a.q0.z3.m.a;
/* loaded from: classes8.dex */
public class b implements d.a.q0.y.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.z3.m.a f66961a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f66962b;

    /* renamed from: c  reason: collision with root package name */
    public a.c f66963c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f66964d;

    /* renamed from: e  reason: collision with root package name */
    public a.InterfaceC1852a f66965e;

    /* loaded from: classes8.dex */
    public class a implements a.InterfaceC1883a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66966a;

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
            this.f66966a = bVar;
        }

        @Override // d.a.q0.z3.m.a.InterfaceC1883a
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f66966a.f66964d != null) {
                    return this.f66966a.f66964d.a();
                }
                return 1.0f;
            }
            return invokeV.floatValue;
        }

        @Override // d.a.q0.z3.m.a.InterfaceC1883a
        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                if (this.f66966a.f66965e != null) {
                    this.f66966a.f66965e.a(f2);
                }
                TextView textView = this.f66966a.f66962b;
                b bVar = this.f66966a;
                textView.setText(bVar.h(bVar.getProgress()));
            }
        }

        @Override // d.a.q0.z3.m.a.InterfaceC1883a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f66966a.f66963c == null) {
                return;
            }
            this.f66966a.f66963c.a();
        }

        @Override // d.a.q0.z3.m.a.InterfaceC1883a
        public void onProgress(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                this.f66966a.f66962b.setText(this.f66966a.h(f2));
            }
        }
    }

    public b(d.a.q0.z3.m.a aVar, TextView textView, a.c cVar, a.b bVar, a.InterfaceC1852a interfaceC1852a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, textView, cVar, bVar, interfaceC1852a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66961a = aVar;
        this.f66962b = textView;
        this.f66963c = cVar;
        this.f66964d = bVar;
        this.f66965e = interfaceC1852a;
        i();
    }

    @Override // d.a.q0.y.a.a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.a.q0.z3.m.a aVar = this.f66961a;
            if (aVar != null) {
                aVar.a();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.y.a.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.q0.z3.m.a aVar = this.f66961a;
            if (aVar != null) {
                return aVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.y.a.a
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.q0.z3.m.a aVar = this.f66961a;
            if (aVar != null) {
                return aVar.getMaxDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.q0.y.a.a
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.q0.z3.m.a aVar = this.f66961a;
            if (aVar != null) {
                return aVar.getProgress();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // d.a.q0.y.a.a
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.q0.z3.m.a aVar = this.f66961a;
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
            d.a.q0.z3.m.a aVar = this.f66961a;
            if (aVar == null) {
                return false;
            }
            aVar.setOnProgressListener(new a(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.y.a.a
    public boolean pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d.a.q0.z3.m.a aVar = this.f66961a;
            if (aVar != null) {
                aVar.stop();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.y.a.a
    public boolean reset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d.a.q0.z3.m.a aVar = this.f66961a;
            if (aVar != null) {
                aVar.reset();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.y.a.a
    public boolean setMaxDuration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            d.a.q0.z3.m.a aVar = this.f66961a;
            if (aVar != null) {
                aVar.setMaxDuration(i2);
                this.f66961a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // d.a.q0.y.a.a
    public boolean setMinDuration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            d.a.q0.z3.m.a aVar = this.f66961a;
            if (aVar != null) {
                aVar.setMinDuration(i2);
                this.f66961a.invalidate();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // d.a.q0.y.a.a
    public boolean setProgress(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            d.a.q0.z3.m.a aVar = this.f66961a;
            if (aVar != null) {
                aVar.setProgress(j);
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // d.a.q0.y.a.a
    public boolean setShowDeleteLastTip(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            d.a.q0.z3.m.a aVar = this.f66961a;
            if (aVar != null) {
                aVar.setShowDeleteLastTip(z);
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // d.a.q0.y.a.a
    public boolean start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d.a.q0.z3.m.a aVar = this.f66961a;
            if (aVar != null) {
                aVar.start();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
