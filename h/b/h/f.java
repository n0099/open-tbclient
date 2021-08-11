package h.b.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes10.dex */
public abstract class f implements Framedata {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f78096a;

    /* renamed from: b  reason: collision with root package name */
    public Framedata.Opcode f78097b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f78098c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f78099d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f78100e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f78101f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f78102g;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f78103a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-654264417, "Lh/b/h/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-654264417, "Lh/b/h/f$a;");
                    return;
                }
            }
            int[] iArr = new int[Framedata.Opcode.values().length];
            f78103a = iArr;
            try {
                iArr[Framedata.Opcode.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f78103a[Framedata.Opcode.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f78103a[Framedata.Opcode.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f78103a[Framedata.Opcode.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f78103a[Framedata.Opcode.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f78103a[Framedata.Opcode.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f(Framedata.Opcode opcode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {opcode};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f78097b = opcode;
        this.f78098c = h.b.k.b.a();
        this.f78096a = true;
        this.f78099d = false;
        this.f78100e = false;
        this.f78101f = false;
        this.f78102g = false;
    }

    public static f g(Framedata.Opcode opcode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, opcode)) == null) {
            if (opcode != null) {
                switch (a.f78103a[opcode.ordinal()]) {
                    case 1:
                        return new g();
                    case 2:
                        return new h();
                    case 3:
                        return new i();
                    case 4:
                        return new h.b.h.a();
                    case 5:
                        return new b();
                    case 6:
                        return new c();
                    default:
                        throw new IllegalArgumentException("Supplied opcode is invalid");
                }
            }
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
        return (f) invokeL.objValue;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f78098c : (ByteBuffer) invokeV.objValue;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f78100e : invokeV.booleanValue;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f78101f : invokeV.booleanValue;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f78097b : (Framedata.Opcode) invokeV.objValue;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f78102g : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            if (this.f78096a == fVar.f78096a && this.f78099d == fVar.f78099d && this.f78100e == fVar.f78100e && this.f78101f == fVar.f78101f && this.f78102g == fVar.f78102g && this.f78097b == fVar.f78097b) {
                ByteBuffer byteBuffer = this.f78098c;
                ByteBuffer byteBuffer2 = fVar.f78098c;
                return byteBuffer != null ? byteBuffer.equals(byteBuffer2) : byteBuffer2 == null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f78096a : invokeV.booleanValue;
    }

    public abstract void h() throws InvalidDataException;

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int hashCode = (((this.f78096a ? 1 : 0) * 31) + this.f78097b.hashCode()) * 31;
            ByteBuffer byteBuffer = this.f78098c;
            return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.f78099d ? 1 : 0)) * 31) + (this.f78100e ? 1 : 0)) * 31) + (this.f78101f ? 1 : 0)) * 31) + (this.f78102g ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f78096a = z;
        }
    }

    public void j(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, byteBuffer) == null) {
            this.f78098c = byteBuffer;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f78100e = z;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f78101f = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f78102g = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f78099d = z;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Framedata{ optcode:");
            sb.append(d());
            sb.append(", fin:");
            sb.append(f());
            sb.append(", rsv1:");
            sb.append(b());
            sb.append(", rsv2:");
            sb.append(c());
            sb.append(", rsv3:");
            sb.append(e());
            sb.append(", payloadlength:[pos:");
            sb.append(this.f78098c.position());
            sb.append(", len:");
            sb.append(this.f78098c.remaining());
            sb.append("], payload:");
            sb.append(this.f78098c.remaining() > 1000 ? "(too big to display)" : new String(this.f78098c.array()));
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
