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
/* loaded from: classes10.dex */
public class ConnectTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f74141a;

    /* renamed from: b  reason: collision with root package name */
    public final String f74142b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwai.filedownloader.d.b f74143c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.filedownloader.download.a f74144d;

    /* renamed from: e  reason: collision with root package name */
    public String f74145e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f74146f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f74147g;

    /* renamed from: com.kwai.filedownloader.download.ConnectTask$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = connectTask;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Integer f74148a;

        /* renamed from: b  reason: collision with root package name */
        public String f74149b;

        /* renamed from: c  reason: collision with root package name */
        public String f74150c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwai.filedownloader.d.b f74151d;

        /* renamed from: e  reason: collision with root package name */
        public com.kwai.filedownloader.download.a f74152e;

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
                }
            }
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f74148a = Integer.valueOf(i2);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a a(com.kwai.filedownloader.d.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
                this.f74151d = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(com.kwai.filedownloader.download.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.f74152e = aVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f74149b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public ConnectTask a() {
            InterceptResult invokeV;
            com.kwai.filedownloader.download.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Integer num = this.f74148a;
                if (num == null || (aVar = this.f74152e) == null || this.f74149b == null) {
                    throw new IllegalArgumentException();
                }
                return new ConnectTask(aVar, num.intValue(), this.f74149b, this.f74150c, this.f74151d, null);
            }
            return (ConnectTask) invokeV.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f74150c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public ConnectTask(com.kwai.filedownloader.download.a aVar, int i2, String str, String str2, com.kwai.filedownloader.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i2), str, str2, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74141a = i2;
        this.f74142b = str;
        this.f74145e = str2;
        this.f74143c = bVar;
        this.f74144d = aVar;
    }

    public /* synthetic */ ConnectTask(com.kwai.filedownloader.download.a aVar, int i2, String str, String str2, com.kwai.filedownloader.d.b bVar, AnonymousClass1 anonymousClass1) {
        this(aVar, i2, str, str2, bVar);
    }

    private void a(com.kwai.filedownloader.a.b bVar) {
        com.kwai.filedownloader.d.b bVar2;
        HashMap<String, List<String>> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, bVar) == null) || (bVar2 = this.f74143c) == null || (a2 = bVar2.a()) == null) {
            return;
        }
        if (com.kwai.filedownloader.f.d.f74244a) {
            com.kwai.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.f74141a), a2);
        }
        for (Map.Entry<String, List<String>> entry : a2.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                for (String str : value) {
                    bVar.a(key, str);
                }
            }
        }
    }

    private void b(com.kwai.filedownloader.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, bVar) == null) || bVar.a(this.f74145e, this.f74144d.f74171a)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f74145e)) {
            bVar.a(Util.IF_MATCH, this.f74145e);
        }
        com.kwai.filedownloader.download.a aVar = this.f74144d;
        bVar.a("Range", aVar.f74173c == 0 ? com.kwai.filedownloader.f.f.a("bytes=%d-", Long.valueOf(aVar.f74172b)) : com.kwai.filedownloader.f.f.a("bytes=%d-%d", Long.valueOf(aVar.f74172b), Long.valueOf(this.f74144d.f74173c)));
    }

    private void c(com.kwai.filedownloader.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar) == null) {
            com.kwai.filedownloader.d.b bVar2 = this.f74143c;
            if (bVar2 == null || bVar2.a().get("User-Agent") == null) {
                bVar.a("User-Agent", com.kwai.filedownloader.f.f.e());
            }
        }
    }

    public com.kwai.filedownloader.a.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.kwai.filedownloader.a.b a2 = b.a().a(this.f74142b);
            a(a2);
            b(a2);
            c(a2);
            this.f74146f = a2.b();
            if (com.kwai.filedownloader.f.d.f74244a) {
                com.kwai.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.f74141a), this.f74146f);
            }
            a2.d();
            ArrayList arrayList = new ArrayList();
            this.f74147g = arrayList;
            return com.kwai.filedownloader.a.d.a(this.f74146f, a2, arrayList);
        }
        return (com.kwai.filedownloader.a.b) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f74144d.f74172b > 0 : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<String> list = this.f74147g;
            if (list == null || list.isEmpty()) {
                return null;
            }
            List<String> list2 = this.f74147g;
            return list2.get(list2.size() - 1);
        }
        return (String) invokeV.objValue;
    }

    public Map<String, List<String>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f74146f : (Map) invokeV.objValue;
    }

    public com.kwai.filedownloader.download.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f74144d : (com.kwai.filedownloader.download.a) invokeV.objValue;
    }
}
