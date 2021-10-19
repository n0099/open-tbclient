package f.a;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes10.dex */
public abstract class h<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Future<SharedPreferences> f78729a;

    /* renamed from: b  reason: collision with root package name */
    public final a f78730b;

    /* renamed from: c  reason: collision with root package name */
    public final String f78731c;

    /* renamed from: d  reason: collision with root package name */
    public T f78732d;

    /* loaded from: classes10.dex */
    public interface a<T> {
        String a(T t);

        T create();

        T load(String str);
    }

    public h(Future<SharedPreferences> future, String str, a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {future, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f78729a = future;
        this.f78730b = aVar;
        this.f78731c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b A[Catch: all -> 0x0012, DONT_GENERATE, TryCatch #1 {, blocks: (B:6:0x0009, B:14:0x001b, B:16:0x001d, B:18:0x0034, B:20:0x003b, B:19:0x0038, B:11:0x0015), top: B:28:0x0009, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x001d A[Catch: all -> 0x0012, TryCatch #1 {, blocks: (B:6:0x0009, B:14:0x001b, B:16:0x001d, B:18:0x0034, B:20:0x003b, B:19:0x0038, B:11:0x0015), top: B:28:0x0009, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(T t) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            this.f78732d = t;
            synchronized (this.f78729a) {
                try {
                    sharedPreferences = this.f78729a.get();
                } catch (InterruptedException unused) {
                    sharedPreferences = null;
                    if (sharedPreferences == null) {
                    }
                } catch (ExecutionException e2) {
                    e2.getCause();
                    sharedPreferences = null;
                    if (sharedPreferences == null) {
                    }
                }
                if (sharedPreferences == null) {
                    return;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(this.f78731c, this.f78730b.a(this.f78732d));
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: f.a.h<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public T b() {
        InterceptResult invokeV;
        Object load;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f78732d == null) {
                synchronized (this.f78729a) {
                    String str = null;
                    try {
                        SharedPreferences sharedPreferences = this.f78729a.get();
                        if (sharedPreferences != null) {
                            str = sharedPreferences.getString(this.f78731c, null);
                        }
                    } catch (InterruptedException unused) {
                    } catch (ExecutionException e2) {
                        e2.getCause();
                    }
                    if (str == null) {
                        load = this.f78730b.create();
                    } else {
                        load = this.f78730b.load(str);
                    }
                    if (load != null) {
                        a(load);
                    }
                }
            }
            return this.f78732d;
        }
        return (T) invokeV.objValue;
    }
}
