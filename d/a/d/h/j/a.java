package d.a.d.h.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static a f42208d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f42209a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f42210b;

    /* renamed from: c  reason: collision with root package name */
    public C0568a f42211c;

    /* renamed from: d.a.d.h.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0568a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f42212a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f42213b;

        public C0568a(a aVar, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42213b = aVar;
            this.f42212a = bVar;
        }

        public final boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                try {
                    f.p(new File(str));
                    d.a.d.h.h.a.b().o("plugin_del_unuse", "delete_unuse", str, null);
                } catch (Throwable th) {
                    d.a.d.h.h.a.b().o("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
                }
                int length = str.length();
                if (length < 4) {
                    return false;
                }
                File file = new File(str.substring(0, length - 4));
                if (file.exists() && file.isDirectory()) {
                    try {
                        f.p(file);
                        d.a.d.h.h.a.b().o("plugin_del_unuse", "delete_unuse", str, null);
                        return true;
                    } catch (Throwable th2) {
                        d.a.d.h.h.a.b().o("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
                        return true;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                b bVar = this.f42212a;
                if (bVar != null) {
                    return Boolean.valueOf(b(bVar.f42214a));
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((C0568a) bool);
                this.f42213b.f42211c = null;
                if (this.f42213b.f42210b.size() > 0) {
                    Iterator it = this.f42213b.f42210b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        if (this.f42213b.g(this.f42212a, bVar)) {
                            this.f42213b.f42210b.remove(bVar);
                            break;
                        }
                    }
                }
                if (bool != null && bool.booleanValue() && this.f42213b.f42209a != null) {
                    c cVar = this.f42213b.f42209a;
                    b bVar2 = this.f42212a;
                    cVar.a(bVar2.f42215b, bVar2.f42214a);
                }
                this.f42213b.i();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f42214a;

        /* renamed from: b  reason: collision with root package name */
        public String f42215b;

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42215b = str;
            this.f42214a = str2;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(String str, String str2);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42210b = new ArrayList<>();
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f42208d == null) {
                synchronized (a.class) {
                    if (f42208d == null) {
                        f42208d = new a();
                    }
                }
            }
            return f42208d;
        }
        return (a) invokeV.objValue;
    }

    public void f(ArrayList<b> arrayList, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, arrayList, cVar) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f42209a = cVar;
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f42214a) && !TextUtils.isEmpty(next.f42215b)) {
                boolean z = false;
                Iterator<b> it2 = this.f42210b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (g(it2.next(), next)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f42210b.add(next);
                }
            }
        }
        i();
    }

    public final boolean g(b bVar, b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2)) == null) ? (bVar == null || bVar2 == null || TextUtils.isEmpty(bVar2.f42214a) || TextUtils.isEmpty(bVar2.f42215b) || TextUtils.isEmpty(bVar.f42214a) || TextUtils.isEmpty(bVar.f42215b) || !bVar2.f42215b.equals(bVar.f42215b) || !bVar2.f42214a.equals(bVar.f42214a)) ? false : true : invokeLL.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f42210b.size() != 0 && this.f42211c == null) {
            C0568a c0568a = new C0568a(this, this.f42210b.get(0));
            this.f42211c = c0568a;
            c0568a.execute(new String[0]);
        }
    }
}
