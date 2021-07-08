package d.a.w.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f68393d = "e";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MediaMuxer f68394a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f68395b;

    /* renamed from: c  reason: collision with root package name */
    public f f68396c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1705903961, "Ld/a/w/c/g/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1705903961, "Ld/a/w/c/g/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68395b = false;
    }

    public synchronized int a(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaFormat)) == null) {
            synchronized (this) {
                try {
                    int addTrack = this.f68394a.addTrack(mediaFormat);
                    if (addTrack >= 0) {
                        return addTrack;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Log.e(f68393d, "addMuxerTrack error!!!");
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public boolean b(String str, int i2, f fVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, fVar)) == null) {
            if (!d.a.w.c.h.a.a(str)) {
                d.a.w.c.h.a.b(str);
            }
            try {
                this.f68394a = new MediaMuxer(str, i2);
                this.f68396c = fVar;
                this.f68395b = false;
                return true;
            } catch (Exception e2) {
                Log.e(f68393d, "initMovieMuxer init error!!!");
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68395b : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f68395b) {
            return;
        }
        this.f68394a.release();
        this.f68394a = null;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                boolean z = true;
                try {
                    this.f68394a.start();
                    this.f68395b = true;
                } catch (Exception unused) {
                    Log.e(f68393d, "startMuxer error!!!");
                    z = false;
                }
                if (this.f68396c != null) {
                    this.f68396c.a(z);
                }
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                boolean z = false;
                try {
                    this.f68394a.stop();
                    this.f68395b = false;
                    z = true;
                } catch (Exception unused) {
                    Log.e(f68393d, "stopMuxer error!!!");
                }
                if (this.f68396c != null) {
                    this.f68396c.b(z);
                }
            }
        }
    }

    public boolean g(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, byteBuffer, bufferInfo)) == null) {
            if (i2 != -1) {
                try {
                    this.f68394a.writeSampleData(i2, byteBuffer, bufferInfo);
                    return true;
                } catch (Exception unused) {
                    Log.e(f68393d, "startMuxer error!!!");
                    return false;
                }
            }
            return false;
        }
        return invokeILL.booleanValue;
    }
}
