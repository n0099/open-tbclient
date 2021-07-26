package d.a.o0.a.l2.e;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e0.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46543g;

    /* renamed from: d.a.o0.a.l2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0812a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f46544e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f46545f;

        public RunnableC0812a(a aVar, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46545f = aVar;
            this.f46544e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46545f.m(this.f46544e);
                this.f46545f.j();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.o0.a.l2.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.l2.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.a.l2.e.b
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f46548b.a()) {
            long currentTimeMillis = b.f46546f ? System.currentTimeMillis() : 0L;
            this.f46547a.g(new RunnableC0812a(this, this.f46548b.n()));
            if (b.f46546f) {
                Log.d("SwanCookieSyncPolicy", "saveCacheToDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f46543g) {
            return;
        }
        long currentTimeMillis = b.f46546f ? System.currentTimeMillis() : 0L;
        this.f46547a.b();
        this.f46543g = true;
        if (b.f46546f) {
            Log.d("SwanCookieSyncPolicy", "clearExpiredCookies costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public ArrayList<d.a.o0.a.l2.a> k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            long currentTimeMillis = b.f46546f ? System.currentTimeMillis() : 0L;
            ArrayList<d.a.o0.a.l2.a> arrayList = new ArrayList<>();
            try {
                arrayList = this.f46547a.e(str);
            } catch (Exception e2) {
                d.h("SwanCookieSyncPolicy", Log.getStackTraceString(e2));
            }
            if (b.f46546f) {
                Log.d("SwanCookieSyncPolicy", "getCookiesForDomain costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long currentTimeMillis = b.f46546f ? System.currentTimeMillis() : 0L;
            this.f46547a.h();
            if (b.f46546f) {
                Log.d("SwanCookieSyncPolicy", "preInitDatabase costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final void m(ArrayList<d.a.o0.a.l2.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (b.f46546f) {
            Log.d("SwanCookieSyncPolicy", "syncFromRamToFlash start");
        }
        Iterator<d.a.o0.a.l2.a> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.o0.a.l2.a next = it.next();
            if (next != null) {
                if (b.f46546f) {
                    Log.d("SwanCookieSyncPolicy", "syncFromRamToFlash result cookie:" + next.toString());
                }
                int i2 = next.f46523i;
                if (i2 == 0) {
                    this.f46547a.a(next);
                    this.f46548b.y(next);
                } else if (i2 == 2) {
                    this.f46547a.d(next.f46515a, next.f46516b, next.f46517c);
                    this.f46548b.g(next);
                } else if (i2 == 3) {
                    this.f46547a.d(next.f46515a, next.f46516b, next.f46517c);
                    this.f46547a.a(next);
                    this.f46548b.y(next);
                }
            }
        }
    }
}
