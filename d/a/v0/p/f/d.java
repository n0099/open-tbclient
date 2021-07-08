package d.a.v0.p.f;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.MediaMuxerWrapper;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final MediaMuxer f68207a;

    /* renamed from: b  reason: collision with root package name */
    public int f68208b;

    /* renamed from: c  reason: collision with root package name */
    public int f68209c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68210d;

    public d(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68208b = 2;
        this.f68209c = 0;
        this.f68210d = false;
        this.f68207a = new MediaMuxer(str, 0);
    }

    public synchronized int a(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        int addTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaFormat)) == null) {
            synchronized (this) {
                if (this.f68210d) {
                    throw new IllegalStateException("muxer already started");
                }
                addTrack = this.f68207a.addTrack(mediaFormat);
                d.a.v0.t.c.j(MediaMuxerWrapper.TAG, "addTrack:trackNum=" + this.f68208b + ",trackIx=" + addTrack + ",format=" + mediaFormat);
            }
            return addTrack;
        }
        return invokeL.intValue;
    }

    public synchronized void b(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, byteBuffer, bufferInfo) == null) {
            synchronized (this) {
                if (this.f68209c > 0) {
                    this.f68207a.writeSampleData(i2, byteBuffer, bufferInfo);
                }
            }
        }
    }

    public synchronized boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                d.a.v0.t.c.k(MediaMuxerWrapper.TAG, "start:");
                int i2 = this.f68209c + 1;
                this.f68209c = i2;
                if (this.f68208b > 0 && i2 == this.f68208b) {
                    this.f68207a.start();
                    this.f68210d = true;
                    notifyAll();
                    d.a.v0.t.c.k(MediaMuxerWrapper.TAG, "MediaMuxer started:");
                }
                z = this.f68210d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                d.a.v0.t.c.k(MediaMuxerWrapper.TAG, "stop:mStatredCount=" + this.f68209c);
                int i2 = this.f68209c + (-1);
                this.f68209c = i2;
                if (this.f68208b > 0 && i2 <= 0) {
                    if (this.f68210d) {
                        this.f68207a.stop();
                    }
                    this.f68207a.release();
                    this.f68210d = false;
                    d.a.v0.t.c.k(MediaMuxerWrapper.TAG, "MediaMuxer stopped:");
                }
            }
        }
    }

    public synchronized boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                z = this.f68210d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
