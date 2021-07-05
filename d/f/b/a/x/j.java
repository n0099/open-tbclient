package d.f.b.a.x;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.audio.AudioProcessor;
import d.f.b.a.i0.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* loaded from: classes10.dex */
public final class j implements AudioProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f73614b;

    /* renamed from: c  reason: collision with root package name */
    public int f73615c;

    /* renamed from: d  reason: collision with root package name */
    public int f73616d;

    /* renamed from: e  reason: collision with root package name */
    public i f73617e;

    /* renamed from: f  reason: collision with root package name */
    public float f73618f;

    /* renamed from: g  reason: collision with root package name */
    public float f73619g;

    /* renamed from: h  reason: collision with root package name */
    public int f73620h;

    /* renamed from: i  reason: collision with root package name */
    public ByteBuffer f73621i;
    public ShortBuffer j;
    public ByteBuffer k;
    public long l;
    public long m;
    public boolean n;

    public j() {
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
        this.f73618f = 1.0f;
        this.f73619g = 1.0f;
        this.f73615c = -1;
        this.f73616d = -1;
        this.f73620h = -1;
        ByteBuffer byteBuffer = AudioProcessor.f32697a;
        this.f73621i = byteBuffer;
        this.j = byteBuffer.asShortBuffer();
        this.k = AudioProcessor.f32697a;
        this.f73614b = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            if (byteBuffer.hasRemaining()) {
                ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
                int remaining = byteBuffer.remaining();
                this.l += remaining;
                this.f73617e.s(asShortBuffer);
                byteBuffer.position(byteBuffer.position() + remaining);
            }
            int k = this.f73617e.k() * this.f73615c * 2;
            if (k > 0) {
                if (this.f73621i.capacity() < k) {
                    ByteBuffer order = ByteBuffer.allocateDirect(k).order(ByteOrder.nativeOrder());
                    this.f73621i = order;
                    this.j = order.asShortBuffer();
                } else {
                    this.f73621i.clear();
                    this.j.clear();
                }
                this.f73617e.j(this.j);
                this.m += k;
                this.f73621i.limit(k);
                this.k = this.f73621i;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        InterceptResult invokeV;
        i iVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n && ((iVar = this.f73617e) == null || iVar.k() == 0) : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f73615c : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f73620h : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f73617e.r();
            this.n = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f73617e = new i(this.f73616d, this.f73615c, this.f73618f, this.f73619g, this.f73620h);
            this.k = AudioProcessor.f32697a;
            this.l = 0L;
            this.m = 0L;
            this.n = false;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ByteBuffer byteBuffer = this.k;
            this.k = AudioProcessor.f32697a;
            return byteBuffer;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean h(int i2, int i3, int i4) throws AudioProcessor.UnhandledFormatException {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4)) == null) {
            if (i4 == 2) {
                int i5 = this.f73614b;
                if (i5 == -1) {
                    i5 = i2;
                }
                if (this.f73616d == i2 && this.f73615c == i3 && this.f73620h == i5) {
                    return false;
                }
                this.f73616d = i2;
                this.f73615c = i3;
                this.f73620h = i5;
                return true;
            }
            throw new AudioProcessor.UnhandledFormatException(i2, i3, i4);
        }
        return invokeIII.booleanValue;
    }

    public long i(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            long j2 = this.m;
            if (j2 >= 1024) {
                int i2 = this.f73620h;
                int i3 = this.f73616d;
                if (i2 == i3) {
                    return v.F(j, this.l, j2);
                }
                return v.F(j, this.l * i2, j2 * i3);
            }
            return (long) (this.f73618f * j);
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Math.abs(this.f73618f - 1.0f) >= 0.01f || Math.abs(this.f73619g - 1.0f) >= 0.01f || this.f73620h != this.f73616d : invokeV.booleanValue;
    }

    public float j(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f2)) == null) {
            this.f73619g = v.j(f2, 0.1f, 8.0f);
            return f2;
        }
        return invokeF.floatValue;
    }

    public float k(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
            float j = v.j(f2, 0.1f, 8.0f);
            this.f73618f = j;
            return j;
        }
        return invokeF.floatValue;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f73617e = null;
            ByteBuffer byteBuffer = AudioProcessor.f32697a;
            this.f73621i = byteBuffer;
            this.j = byteBuffer.asShortBuffer();
            this.k = AudioProcessor.f32697a;
            this.f73615c = -1;
            this.f73616d = -1;
            this.f73620h = -1;
            this.l = 0L;
            this.m = 0L;
            this.n = false;
            this.f73614b = -1;
        }
    }
}
