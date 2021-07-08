package d.a.n0.a.k2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes7.dex */
public abstract class a implements e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final ReadWriteLock f45868c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public File f45869a;

    /* renamed from: b  reason: collision with root package name */
    public final long f45870b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1257058699, "Ld/a/n0/a/k2/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1257058699, "Ld/a/n0/a/k2/f/a;");
                return;
            }
        }
        f45868c = new ReentrantReadWriteLock();
    }

    public a() {
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
        this.f45869a = d();
        this.f45870b = getMaxSize();
    }

    @Override // d.a.n0.a.k2.f.e
    public boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            f45868c.readLock().lock();
            try {
                return e() + j > this.f45870b;
            } finally {
                f45868c.readLock().unlock();
            }
        }
        return invokeJ.booleanValue;
    }

    @Override // d.a.n0.a.k2.f.e
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            f45868c.writeLock().lock();
            try {
                try {
                    if (this.f45869a == null) {
                        this.f45869a = d();
                    }
                    File file = this.f45869a;
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    d.a.n0.t.d.N(String.valueOf(e() + j).getBytes(), file);
                } catch (Exception e2) {
                    if (k.f45831a) {
                        e2.printStackTrace();
                    }
                }
            } finally {
                f45868c.writeLock().unlock();
            }
        }
    }

    @NonNull
    public abstract String c();

    public final File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new File(c() + File.separator + "record.pro");
        }
        return (File) invokeV.objValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f45869a == null) {
                this.f45869a = d();
            }
            File file = this.f45869a;
            if (file.exists() && file.isFile()) {
                String D = d.a.n0.t.d.D(file);
                try {
                    if (!TextUtils.isEmpty(D) && TextUtils.isDigitsOnly(D.trim())) {
                        return Long.valueOf(D.trim()).longValue();
                    }
                } catch (Exception e2) {
                    if (k.f45831a) {
                        e2.printStackTrace();
                    }
                }
            }
            return 0L;
        }
        return invokeV.longValue;
    }
}
