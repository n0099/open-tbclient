package d.a.q0.a.n2.g;

import android.os.FileObserver;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.d;
import d.a.q0.a.j2.c;
import d.a.q0.a.k;
import d.a.q0.a.v2.q;
import java.io.File;
/* loaded from: classes8.dex */
public final class b extends FileObserver {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f49748d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f49749a;

    /* renamed from: b  reason: collision with root package name */
    public int f49750b;

    /* renamed from: c  reason: collision with root package name */
    public int f49751c;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49752e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f49753f;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49753f = bVar;
            this.f49752e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.b bVar = new c.b(10019);
                bVar.l(String.valueOf(this.f49753f.f49751c));
                bVar.j(this.f49752e);
                bVar.h(d.g().getAppId());
                bVar.m();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1792730323, "Ld/a/q0/a/n2/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1792730323, "Ld/a/q0/a/n2/g/b;");
                return;
            }
        }
        f49748d = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull String str) {
        super(str, 1792);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49751c = 0;
        this.f49750b = 0;
        this.f49749a = str;
    }

    public void b(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            q.e().execute(new a(this, this.f49749a + File.separator + str));
        }
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            if ((i2 & 256) == 256) {
                this.f49750b++;
                if (f49748d) {
                    Log.i("SwanPkgFileObserver", "onEvent: create " + this.f49750b + " " + str);
                    return;
                }
                return;
            }
            this.f49751c++;
            if (f49748d) {
                Log.i("SwanPkgFileObserver", "onEvent: delete " + this.f49750b + " " + str);
            }
            b(str);
        }
    }
}
