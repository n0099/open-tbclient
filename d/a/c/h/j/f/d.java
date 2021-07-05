package d.a.c.h.j.f;

import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f44709c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PluginNetConfigInfos f44710a;

    /* renamed from: b  reason: collision with root package name */
    public b f44711b;

    /* loaded from: classes8.dex */
    public class a implements d.a.c.h.j.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c.h.j.f.a f44712a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f44713b;

        public a(d dVar, d.a.c.h.j.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44713b = dVar;
            this.f44712a = aVar;
        }

        @Override // d.a.c.h.j.f.a
        public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), cVar, pluginNetConfigInfos, str}) == null) {
                if (z) {
                    this.f44713b.f44710a = pluginNetConfigInfos;
                }
                d.a.c.h.j.f.a aVar = this.f44712a;
                if (aVar != null) {
                    aVar.a(z, cVar, this.f44713b.f44710a, str);
                }
            }
        }
    }

    public d() {
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
        this.f44710a = new PluginNetConfigInfos();
    }

    public static d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f44709c == null) {
                synchronized (d.class) {
                    if (f44709c == null) {
                        f44709c = new d();
                    }
                }
            }
            return f44709c;
        }
        return (d) invokeV.objValue;
    }

    public PluginNetConfigInfos d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f44710a : (PluginNetConfigInfos) invokeV.objValue;
    }

    public void e(PluginSettings pluginSettings, boolean z, d.a.c.h.j.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{pluginSettings, Boolean.valueOf(z), aVar}) == null) {
            c g2 = g(pluginSettings);
            b bVar = this.f44711b;
            if (bVar != null) {
                bVar.a(z, g2, new a(this, aVar));
            }
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f44711b = bVar;
        }
    }

    public c g(PluginSettings pluginSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pluginSettings)) == null) {
            c cVar = new c();
            ArrayList arrayList = new ArrayList();
            if (pluginSettings.getPlugins() != null) {
                for (Map.Entry<String, PluginSetting> entry : pluginSettings.getPlugins().entrySet()) {
                    PluginSetting value = entry.getValue();
                    if (value != null) {
                        arrayList.add(new BasicNameValuePair(value.packageName, String.valueOf(value.versionCode)));
                    }
                }
            }
            cVar.b(arrayList);
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
