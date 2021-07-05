package d.a.t0.b.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
public abstract class f extends OutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public IOException f70525e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70526f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f70527g;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f70526f = true;
        }
    }

    public void g() throws IOException {
        IOException iOException;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (iOException = this.f70525e) != null) {
            throw iOException;
        }
    }

    public void n() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.f70527g) {
                if (this.f70526f) {
                    throw new IOException("Stream has been closed.");
                }
                return;
            }
            g();
            throw new IOException("Writing after request completed.");
        }
    }

    public abstract void o() throws IOException;

    public abstract UploadDataProvider r();

    public abstract void s() throws IOException;

    public void t(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iOException) == null) {
            this.f70525e = iOException;
            this.f70527g = true;
        }
    }
}
