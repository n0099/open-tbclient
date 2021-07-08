package d.a.n0.v.k;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.n0.a.k;
import d.a.n0.a.v2.q;
import d.a.n0.a.y0.d;
import d.a.n0.a.y0.f.a;
import java.util.Map;
/* loaded from: classes7.dex */
public class a implements d.a.n0.a.y0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f51199e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f51200a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0979a f51201b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f51202c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f51203d;

    /* renamed from: d.a.n0.v.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1161a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51204e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f51205f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f51206g;

        public RunnableC1161a(a aVar, String str, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51206g = aVar;
            this.f51204e = str;
            this.f51205f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f51206g.f51203d) {
                    if (a.f51199e) {
                        Log.d("MediaExtractorWidget", "media extractor already released");
                        return;
                    }
                    return;
                }
                this.f51206g.f51202c.setDataSource(this.f51206g.getContext(), Uri.parse(d.a.n0.a.y0.j.a.a(this.f51204e)), this.f51205f);
                Bundle metaData = this.f51206g.f51202c.getMetaData();
                if (this.f51206g.f51201b != null) {
                    this.f51206g.f51201b.a(metaData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1731213025, "Ld/a/n0/v/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1731213025, "Ld/a/n0/v/k/a;");
                return;
            }
        }
        f51199e = k.f45831a;
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51200a = str;
        this.f51203d = false;
    }

    @Override // d.a.n0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f51202c = new CyberExtractor(true);
            aVar.a(true);
        }
    }

    @Override // d.a.n0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51200a : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.n0.a.c1.a.b() : (Context) invokeV.objValue;
    }

    @Override // d.a.n0.a.y0.d
    @Nullable
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.y0.f.a
    public void k(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        q.i(new RunnableC1161a(this, str, map), "loadMetadata");
    }

    @Override // d.a.n0.a.y0.f.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f51203d = true;
            CyberExtractor cyberExtractor = this.f51202c;
            if (cyberExtractor != null) {
                cyberExtractor.release();
            }
            this.f51202c = null;
            a.InterfaceC0979a interfaceC0979a = this.f51201b;
            if (interfaceC0979a != null) {
                interfaceC0979a.onRelease();
            }
            this.f51201b = null;
        }
    }

    @Override // d.a.n0.a.y0.f.a
    public void w(a.InterfaceC0979a interfaceC0979a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0979a) == null) {
            this.f51201b = interfaceC0979a;
        }
    }
}
