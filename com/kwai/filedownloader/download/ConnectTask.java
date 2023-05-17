package com.kwai.filedownloader.download;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public final class ConnectTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int aui;
    public final com.kwai.filedownloader.c.b auj;
    public com.kwai.filedownloader.download.a auk;
    public String aul;
    public Map<String, List<String>> aum;
    public List<String> aun;
    public final String url;

    /* loaded from: classes9.dex */
    public class Reconnect extends Throwable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2940866805654257562L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConnectTask this$0;

        public Reconnect(ConnectTask connectTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {connectTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = connectTask;
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public com.kwai.filedownloader.c.b auj;
        public String aul;
        public Integer auo;
        public com.kwai.filedownloader.download.a aup;
        public String url;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final ConnectTask Do() {
            InterceptResult invokeV;
            com.kwai.filedownloader.download.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Integer num = this.auo;
                if (num == null || (aVar = this.aup) == null || this.url == null) {
                    throw new IllegalArgumentException();
                }
                return new ConnectTask(aVar, num.intValue(), this.url, this.aul, this.auj, (byte) 0);
            }
            return (ConnectTask) invokeV.objValue;
        }

        public final a a(com.kwai.filedownloader.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
                this.auj = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(com.kwai.filedownloader.download.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.aup = aVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a cl(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.auo = Integer.valueOf(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a er(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.url = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a es(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.aul = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public ConnectTask(com.kwai.filedownloader.download.a aVar, int i, String str, String str2, com.kwai.filedownloader.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i), str, str2, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.aui = i;
        this.url = str;
        this.aul = str2;
        this.auj = bVar;
        this.auk = aVar;
    }

    public /* synthetic */ ConnectTask(com.kwai.filedownloader.download.a aVar, int i, String str, String str2, com.kwai.filedownloader.c.b bVar, byte b) {
        this(aVar, i, str, str2, bVar);
    }

    private void a(com.kwai.filedownloader.kwai.b bVar) {
        com.kwai.filedownloader.c.b bVar2;
        HashMap<String, List<String>> El;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, bVar) == null) || (bVar2 = this.auj) == null || (El = bVar2.El()) == null) {
            return;
        }
        if (com.kwai.filedownloader.e.d.awL) {
            com.kwai.filedownloader.e.d.g(this, "%d add outside header: %s", Integer.valueOf(this.aui), El);
        }
        for (Map.Entry<String, List<String>> entry : El.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                for (String str : value) {
                    bVar.addHeader(key, str);
                }
            }
        }
    }

    private void b(com.kwai.filedownloader.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bVar) == null) {
            if (!TextUtils.isEmpty(this.aul)) {
                bVar.addHeader(Util.IF_MATCH, this.aul);
            }
            com.kwai.filedownloader.download.a aVar = this.auk;
            bVar.addHeader("Range", aVar.aus == 0 ? com.kwai.filedownloader.e.f.h("bytes=%d-", Long.valueOf(aVar.aur)) : com.kwai.filedownloader.e.f.h("bytes=%d-%d", Long.valueOf(aVar.aur), Long.valueOf(this.auk.aus)));
        }
    }

    private void c(com.kwai.filedownloader.kwai.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar) == null) {
            com.kwai.filedownloader.c.b bVar2 = this.auj;
            if (bVar2 == null || bVar2.El().get("User-Agent") == null) {
                bVar.addHeader("User-Agent", com.kwai.filedownloader.e.f.ER());
            }
        }
    }

    public final com.kwai.filedownloader.kwai.b Dk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.kwai.filedownloader.kwai.b et = b.Dp().et(this.url);
            a(et);
            b(et);
            c(et);
            this.aum = et.U();
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "%s request header %s", Integer.valueOf(this.aui), this.aum);
            }
            et.execute();
            ArrayList arrayList = new ArrayList();
            this.aun = arrayList;
            return com.kwai.filedownloader.kwai.d.a(this.aum, et, arrayList);
        }
        return (com.kwai.filedownloader.kwai.b) invokeV.objValue;
    }

    public final boolean Dl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.auk.aur > 0 : invokeV.booleanValue;
    }

    public final String Dm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<String> list = this.aun;
            if (list == null || list.isEmpty()) {
                return null;
            }
            List<String> list2 = this.aun;
            return list2.get(list2.size() - 1);
        }
        return (String) invokeV.objValue;
    }

    public final com.kwai.filedownloader.download.a Dn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.auk : (com.kwai.filedownloader.download.a) invokeV.objValue;
    }

    public final Map<String, List<String>> getRequestHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.aum : (Map) invokeV.objValue;
    }
}
