package d.a.c.h.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static a f41704d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f41705a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f41706b;

    /* renamed from: c  reason: collision with root package name */
    public C0559a f41707c;

    /* renamed from: d.a.c.h.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0559a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f41708a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f41709b;

        public C0559a(a aVar, b bVar) {
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
            this.f41709b = aVar;
            this.f41708a = bVar;
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
                    d.a.c.h.h.a.b().o("plugin_del_unuse", "delete_unuse", str, null);
                } catch (Throwable th) {
                    d.a.c.h.h.a.b().o("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
                }
                int length = str.length();
                if (length < 4) {
                    return false;
                }
                File file = new File(str.substring(0, length - 4));
                if (file.exists() && file.isDirectory()) {
                    try {
                        f.p(file);
                        d.a.c.h.h.a.b().o("plugin_del_unuse", "delete_unuse", str, null);
                        return true;
                    } catch (Throwable th2) {
                        d.a.c.h.h.a.b().o("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
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
                b bVar = this.f41708a;
                if (bVar != null) {
                    return Boolean.valueOf(b(bVar.f41710a));
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
                super.onPostExecute((C0559a) bool);
                this.f41709b.f41707c = null;
                if (this.f41709b.f41706b.size() > 0) {
                    Iterator it = this.f41709b.f41706b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        b bVar = (b) it.next();
                        if (this.f41709b.g(this.f41708a, bVar)) {
                            this.f41709b.f41706b.remove(bVar);
                            break;
                        }
                    }
                }
                if (bool != null && bool.booleanValue() && this.f41709b.f41705a != null) {
                    c cVar = this.f41709b.f41705a;
                    b bVar2 = this.f41708a;
                    cVar.a(bVar2.f41711b, bVar2.f41710a);
                }
                this.f41709b.i();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f41710a;

        /* renamed from: b  reason: collision with root package name */
        public String f41711b;

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
            this.f41711b = str;
            this.f41710a = str2;
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
        this.f41706b = new ArrayList<>();
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f41704d == null) {
                synchronized (a.class) {
                    if (f41704d == null) {
                        f41704d = new a();
                    }
                }
            }
            return f41704d;
        }
        return (a) invokeV.objValue;
    }

    public void f(ArrayList<b> arrayList, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, arrayList, cVar) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f41705a = cVar;
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f41710a) && !TextUtils.isEmpty(next.f41711b)) {
                boolean z = false;
                Iterator<b> it2 = this.f41706b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (g(it2.next(), next)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f41706b.add(next);
                }
            }
        }
        i();
    }

    public final boolean g(b bVar, b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2)) == null) ? (bVar == null || bVar2 == null || TextUtils.isEmpty(bVar2.f41710a) || TextUtils.isEmpty(bVar2.f41711b) || TextUtils.isEmpty(bVar.f41710a) || TextUtils.isEmpty(bVar.f41711b) || !bVar2.f41711b.equals(bVar.f41711b) || !bVar2.f41710a.equals(bVar.f41710a)) ? false : true : invokeLL.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f41706b.size() != 0 && this.f41707c == null) {
            C0559a c0559a = new C0559a(this, this.f41706b.get(0));
            this.f41707c = c0559a;
            c0559a.execute(new String[0]);
        }
    }
}
