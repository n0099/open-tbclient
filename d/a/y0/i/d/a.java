package d.a.y0.i.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.y0.i.h;
import d.a.y0.t.s;
/* loaded from: classes9.dex */
public class a implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.y0.g.a f71099a;

    /* renamed from: b  reason: collision with root package name */
    public float f71100b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f71101c;

    public a() {
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
        this.f71100b = 1.0f;
        this.f71101c = true;
    }

    @Override // d.a.y0.i.h
    public int a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i2)) == null) {
            d.a.y0.g.a aVar = this.f71099a;
            if (aVar == null || !aVar.putBytes(bArr, i2)) {
                return 0;
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    @Override // d.a.y0.i.h
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() && this.f71101c && this.f71100b != 1.0f : invokeV.booleanValue;
    }

    @Override // d.a.y0.i.h
    public boolean a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5)) == null) {
            if (this.f71099a == null) {
                this.f71099a = (d.a.y0.g.a) s.a("com.baidu.ugc.audioedit.AudioSpeedOperator");
            }
            d.a.y0.g.a aVar = this.f71099a;
            if (aVar != null) {
                aVar.init(i4, i3);
                this.f71099a.setSpeed(1.0f);
                return false;
            }
            return false;
        }
        return invokeIIII.booleanValue;
    }

    @Override // d.a.y0.i.h
    public byte[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            d.a.y0.g.a aVar = this.f71099a;
            return aVar != null ? aVar.getOutPutBytes() : new byte[0];
        }
        return (byte[]) invokeI.objValue;
    }

    public void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.f71100b = f2;
            d.a.y0.g.a aVar = this.f71099a;
            if (aVar != null) {
                aVar.setSpeed(f2);
            }
        }
    }

    @Override // d.a.y0.i.h
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f71099a != null : invokeV.booleanValue;
    }

    @Override // d.a.y0.i.h
    public void c() {
        d.a.y0.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f71099a) == null) {
            return;
        }
        aVar.flush();
    }

    @Override // d.a.y0.i.h
    public void d() {
        d.a.y0.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f71099a) == null) {
            return;
        }
        aVar.close();
        this.f71099a = null;
    }

    @Override // d.a.y0.i.h
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }
}
