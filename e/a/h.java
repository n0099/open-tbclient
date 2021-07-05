package e.a;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
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
    public final Future<SharedPreferences> f75233a;

    /* renamed from: b  reason: collision with root package name */
    public final a f75234b;

    /* renamed from: c  reason: collision with root package name */
    public final String f75235c;

    /* renamed from: d  reason: collision with root package name */
    public T f75236d;

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
        this.f75233a = future;
        this.f75234b = aVar;
        this.f75235c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c A[Catch: all -> 0x0012, DONT_GENERATE, TryCatch #1 {, blocks: (B:6:0x0009, B:16:0x002c, B:18:0x002e, B:20:0x0045, B:22:0x004c, B:21:0x0049, B:11:0x0015, B:13:0x001e), top: B:29:0x0009, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002e A[Catch: all -> 0x0012, TryCatch #1 {, blocks: (B:6:0x0009, B:16:0x002c, B:18:0x002e, B:20:0x0045, B:22:0x004c, B:21:0x0049, B:11:0x0015, B:13:0x001e), top: B:29:0x0009, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(T t) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            this.f75236d = t;
            synchronized (this.f75233a) {
                try {
                    sharedPreferences = this.f75233a.get();
                } catch (InterruptedException e2) {
                    Log.e("SA.PersistentIdentity", "Cannot read distinct ids from sharedPreferences.", e2);
                    sharedPreferences = null;
                    if (sharedPreferences == null) {
                    }
                } catch (ExecutionException e3) {
                    Log.e("SA.PersistentIdentity", "Cannot read distinct ids from sharedPreferences.", e3.getCause());
                    sharedPreferences = null;
                    if (sharedPreferences == null) {
                    }
                }
                if (sharedPreferences == null) {
                    return;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(this.f75235c, this.f75234b.a(this.f75236d));
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: e.a.h<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public T b() {
        InterceptResult invokeV;
        Object load;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f75236d == null) {
                synchronized (this.f75233a) {
                    String str = null;
                    try {
                        SharedPreferences sharedPreferences = this.f75233a.get();
                        if (sharedPreferences != null) {
                            str = sharedPreferences.getString(this.f75235c, null);
                        }
                    } catch (InterruptedException e2) {
                        Log.e("SA.PersistentIdentity", "Cannot read distinct ids from sharedPreferences.", e2);
                    } catch (ExecutionException e3) {
                        Log.e("SA.PersistentIdentity", "Cannot read distinct ids from sharedPreferences.", e3.getCause());
                    }
                    if (str == null) {
                        load = this.f75234b.create();
                    } else {
                        load = this.f75234b.load(str);
                    }
                    if (load != null) {
                        a(load);
                    }
                }
            }
            return this.f75236d;
        }
        return (T) invokeV.objValue;
    }
}
