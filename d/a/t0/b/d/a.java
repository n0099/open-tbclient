package d.a.t0.b.d;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class a extends InputStream {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final String f70497i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f70498e;

    /* renamed from: f  reason: collision with root package name */
    public b f70499f;

    /* renamed from: g  reason: collision with root package name */
    public long f70500g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f70501h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-263829472, "Ld/a/t0/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-263829472, "Ld/a/t0/b/d/a;");
                return;
            }
        }
        f70497i = a.class.getName();
    }

    public a(InputStream inputStream, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70500g = 0L;
        this.f70501h = false;
        this.f70498e = inputStream;
        this.f70499f = bVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return this.f70498e.available();
            } catch (IOException e2) {
                this.f70499f.b(e2, this.f70500g);
                throw e2;
            }
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f70501h) {
            return;
        }
        this.f70501h = true;
        try {
            try {
                if (this.f70498e.read() == -1) {
                    this.f70499f.onComplete(this.f70500g);
                } else {
                    this.f70499f.a(this.f70500g);
                }
                this.f70498e.close();
            } catch (Exception unused) {
                this.f70498e.close();
            } catch (Throwable th) {
                try {
                    this.f70498e.close();
                } catch (Exception e2) {
                    this.f70499f.b(e2, this.f70500g);
                }
                throw th;
            }
        } catch (Exception e3) {
            this.f70499f.b(e3, this.f70500g);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            if (this.f70501h) {
                return -1;
            }
            try {
                int read = this.f70498e.read(bArr, 0, bArr.length);
                if (read >= 0) {
                    this.f70500g += read;
                } else {
                    this.f70501h = true;
                    this.f70499f.onComplete(this.f70500g);
                }
                return read;
            } catch (IOException e2) {
                this.f70499f.b(e2, this.f70500g);
                throw e2;
            } catch (IllegalStateException e3) {
                Log.e(f70497i, "Exception reading data from InputStream", e3);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                try {
                    this.f70498e.reset();
                } catch (IOException e2) {
                    this.f70499f.b(e2, this.f70500g);
                    throw e2;
                }
            }
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            long skip = this.f70498e.skip(j);
            this.f70500g += skip;
            return skip;
        }
        return invokeJ.longValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
            if (this.f70501h) {
                return -1;
            }
            try {
                int read = this.f70498e.read(bArr, i2, i3);
                if (read >= 0) {
                    this.f70500g += read;
                } else {
                    this.f70501h = true;
                    this.f70499f.onComplete(this.f70500g);
                }
                return read;
            } catch (IOException e2) {
                this.f70499f.b(e2, this.f70500g);
                throw e2;
            } catch (IllegalStateException e3) {
                Log.e(f70497i, "Exception reading data from InputStream", e3);
                return -1;
            }
        }
        return invokeLII.intValue;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f70501h) {
                return -1;
            }
            try {
                int read = this.f70498e.read();
                if (read >= 0) {
                    this.f70500g += read;
                } else {
                    this.f70501h = true;
                    this.f70499f.onComplete(this.f70500g);
                }
                return read;
            } catch (IOException e2) {
                this.f70499f.b(e2, this.f70500g);
                throw e2;
            } catch (IllegalStateException e3) {
                Log.e(f70497i, "Exception reading data from InputStream", e3);
                return -1;
            }
        }
        return invokeV.intValue;
    }
}
