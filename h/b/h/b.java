package h.b.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes8.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f60271h;

    /* renamed from: i  reason: collision with root package name */
    public String f60272i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super(Framedata.Opcode.CLOSING);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Framedata.Opcode) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        r("");
        q(1000);
    }

    @Override // h.b.h.f, org.java_websocket.framing.Framedata
    public ByteBuffer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f60271h == 1005) {
                return h.b.k.b.a();
            }
            return super.a();
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // h.b.h.d, h.b.h.f
    public void h() throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.h();
            if (this.f60271h == 1007 && this.f60272i == null) {
                throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
            }
            if (this.f60271h == 1005 && this.f60272i.length() > 0) {
                throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
            }
            int i2 = this.f60271h;
            if (i2 > 1015 && i2 < 3000) {
                throw new InvalidDataException(1002, "Trying to send an illegal close code!");
            }
            int i3 = this.f60271h;
            if (i3 == 1006 || i3 == 1015 || i3 == 1005 || i3 > 4999 || i3 < 1000 || i3 == 1004) {
                throw new InvalidFrameException("closecode must not be sent over the wire: " + this.f60271h);
            }
        }
    }

    @Override // h.b.h.f
    public void j(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
            this.f60271h = 1005;
            this.f60272i = "";
            byteBuffer.mark();
            if (byteBuffer.remaining() == 0) {
                this.f60271h = 1000;
            } else if (byteBuffer.remaining() == 1) {
                this.f60271h = 1002;
            } else {
                if (byteBuffer.remaining() >= 2) {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    allocate.position(2);
                    allocate.putShort(byteBuffer.getShort());
                    allocate.position(0);
                    this.f60271h = allocate.getInt();
                }
                byteBuffer.reset();
                try {
                    int position = byteBuffer.position();
                    try {
                        byteBuffer.position(byteBuffer.position() + 2);
                        this.f60272i = h.b.k.c.e(byteBuffer);
                        byteBuffer.position(position);
                    } catch (IllegalArgumentException unused) {
                        throw new InvalidDataException(1007);
                    }
                } catch (InvalidDataException unused2) {
                    this.f60271h = 1007;
                    this.f60272i = null;
                }
            }
        }
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60271h : invokeV.intValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f60272i : (String) invokeV.objValue;
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f60271h = i2;
            if (i2 == 1015) {
                this.f60271h = 1005;
                this.f60272i = "";
            }
            s();
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.f60272i = str;
            s();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            byte[] f2 = h.b.k.c.f(this.f60272i);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(this.f60271h);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(f2.length + 2);
            allocate2.put(allocate);
            allocate2.put(f2);
            allocate2.rewind();
            super.j(allocate2);
        }
    }

    @Override // h.b.h.f
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return super.toString() + "code: " + this.f60271h;
        }
        return (String) invokeV.objValue;
    }
}
