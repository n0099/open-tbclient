package d.a.q0.b.d;

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
/* loaded from: classes8.dex */
public class a extends InputStream {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final String f66990i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f66991e;

    /* renamed from: f  reason: collision with root package name */
    public b f66992f;

    /* renamed from: g  reason: collision with root package name */
    public long f66993g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66994h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(863566621, "Ld/a/q0/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(863566621, "Ld/a/q0/b/d/a;");
                return;
            }
        }
        f66990i = a.class.getName();
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
        this.f66993g = 0L;
        this.f66994h = false;
        this.f66991e = inputStream;
        this.f66992f = bVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return this.f66991e.available();
            } catch (IOException e2) {
                this.f66992f.b(e2, this.f66993g);
                throw e2;
            }
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f66994h) {
            return;
        }
        this.f66994h = true;
        try {
            try {
                if (this.f66991e.read() == -1) {
                    this.f66992f.onComplete(this.f66993g);
                } else {
                    this.f66992f.a(this.f66993g);
                }
                this.f66991e.close();
            } catch (Exception unused) {
                this.f66991e.close();
            } catch (Throwable th) {
                try {
                    this.f66991e.close();
                } catch (Exception e2) {
                    this.f66992f.b(e2, this.f66993g);
                }
                throw th;
            }
        } catch (Exception e3) {
            this.f66992f.b(e3, this.f66993g);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            if (this.f66994h) {
                return -1;
            }
            try {
                int read = this.f66991e.read(bArr, 0, bArr.length);
                if (read >= 0) {
                    this.f66993g += read;
                } else {
                    this.f66994h = true;
                    this.f66992f.onComplete(this.f66993g);
                }
                return read;
            } catch (IOException e2) {
                this.f66992f.b(e2, this.f66993g);
                throw e2;
            } catch (IllegalStateException e3) {
                Log.e(f66990i, "Exception reading data from InputStream", e3);
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
                    this.f66991e.reset();
                } catch (IOException e2) {
                    this.f66992f.b(e2, this.f66993g);
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
            long skip = this.f66991e.skip(j);
            this.f66993g += skip;
            return skip;
        }
        return invokeJ.longValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
            if (this.f66994h) {
                return -1;
            }
            try {
                int read = this.f66991e.read(bArr, i2, i3);
                if (read >= 0) {
                    this.f66993g += read;
                } else {
                    this.f66994h = true;
                    this.f66992f.onComplete(this.f66993g);
                }
                return read;
            } catch (IOException e2) {
                this.f66992f.b(e2, this.f66993g);
                throw e2;
            } catch (IllegalStateException e3) {
                Log.e(f66990i, "Exception reading data from InputStream", e3);
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
            if (this.f66994h) {
                return -1;
            }
            try {
                int read = this.f66991e.read();
                if (read >= 0) {
                    this.f66993g += read;
                } else {
                    this.f66994h = true;
                    this.f66992f.onComplete(this.f66993g);
                }
                return read;
            } catch (IOException e2) {
                this.f66992f.b(e2, this.f66993g);
                throw e2;
            } catch (IllegalStateException e3) {
                Log.e(f66990i, "Exception reading data from InputStream", e3);
                return -1;
            }
        }
        return invokeV.intValue;
    }
}
