package d.a.c.h.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f44701c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f44702a;

    /* renamed from: b  reason: collision with root package name */
    public a f44703b;

    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f44704a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f44705b;

        public a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44705b = cVar;
            this.f44704a = str;
        }

        public final void b(String str) {
            File[] listFiles;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                File m = Util.m();
                String k = Util.k(str);
                if (m == null || !m.exists() || (listFiles = m.listFiles()) == null) {
                    return;
                }
                int length = listFiles.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (listFiles[i2] != null && listFiles[i2].isFile() && listFiles[i2].getName().startsWith(k)) {
                        try {
                            f.p(listFiles[i2]);
                            d.a.c.h.h.a.b().o("plugin_del_temp", "deltmp_suc", str, listFiles[i2].getName());
                        } catch (Throwable th) {
                            d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                            b2.r("plugin_del_temp", "deltmp_fail", str, listFiles[i2].getName() + "-" + th.getMessage());
                        }
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                String str = this.f44704a;
                if (str != null) {
                    b(str);
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((a) bool);
                this.f44705b.f44703b = null;
                if (this.f44705b.f44702a.size() > 0) {
                    Iterator it = this.f44705b.f44702a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String str = (String) it.next();
                        if (str != null && str.equals(this.f44704a)) {
                            this.f44705b.f44702a.remove(str);
                            break;
                        }
                    }
                }
                this.f44705b.f();
            }
        }
    }

    public c() {
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
        this.f44702a = new ArrayList<>();
    }

    public static c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (f44701c == null) {
                synchronized (c.class) {
                    if (f44701c == null) {
                        f44701c = new c();
                    }
                }
            }
            return f44701c;
        }
        return (c) invokeV.objValue;
    }

    public void d(PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pluginSetting) == null) || pluginSetting == null || TextUtils.isEmpty(pluginSetting.packageName)) {
            return;
        }
        boolean z = false;
        Iterator<String> it = this.f44702a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next != null && next.equals(pluginSetting.packageName)) {
                z = true;
                break;
            }
        }
        if (!z) {
            this.f44702a.add(pluginSetting.packageName);
        }
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f44702a.size() > 0 && this.f44703b == null) {
            a aVar = new a(this, this.f44702a.get(0));
            this.f44703b = aVar;
            aVar.execute(new String[0]);
        }
    }
}
