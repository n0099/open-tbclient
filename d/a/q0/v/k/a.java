package d.a.q0.v.k;

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
import d.a.q0.a.k;
import d.a.q0.a.v2.q;
import d.a.q0.a.y0.d;
import d.a.q0.a.y0.f.a;
import java.util.Map;
/* loaded from: classes8.dex */
public class a implements d.a.q0.a.y0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f54501e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f54502a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC1030a f54503b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f54504c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f54505d;

    /* renamed from: d.a.q0.v.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1212a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54506e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f54507f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f54508g;

        public RunnableC1212a(a aVar, String str, Map map) {
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
            this.f54508g = aVar;
            this.f54506e = str;
            this.f54507f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f54508g.f54505d) {
                    if (a.f54501e) {
                        Log.d("MediaExtractorWidget", "media extractor already released");
                        return;
                    }
                    return;
                }
                this.f54508g.f54504c.setDataSource(this.f54508g.getContext(), Uri.parse(d.a.q0.a.y0.j.a.a(this.f54506e)), this.f54507f);
                Bundle metaData = this.f54508g.f54504c.getMetaData();
                if (this.f54508g.f54503b != null) {
                    this.f54508g.f54503b.a(metaData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1436358178, "Ld/a/q0/v/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1436358178, "Ld/a/q0/v/k/a;");
                return;
            }
        }
        f54501e = k.f49133a;
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
        this.f54502a = str;
        this.f54505d = false;
    }

    @Override // d.a.q0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f54504c = new CyberExtractor(true);
            aVar.a(true);
        }
    }

    @Override // d.a.q0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54502a : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.q0.a.c1.a.b() : (Context) invokeV.objValue;
    }

    @Override // d.a.q0.a.y0.d
    @Nullable
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.y0.f.a
    public void k(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        q.i(new RunnableC1212a(this, str, map), "loadMetadata");
    }

    @Override // d.a.q0.a.y0.f.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f54505d = true;
            CyberExtractor cyberExtractor = this.f54504c;
            if (cyberExtractor != null) {
                cyberExtractor.release();
            }
            this.f54504c = null;
            a.InterfaceC1030a interfaceC1030a = this.f54503b;
            if (interfaceC1030a != null) {
                interfaceC1030a.onRelease();
            }
            this.f54503b = null;
        }
    }

    @Override // d.a.q0.a.y0.f.a
    public void w(a.InterfaceC1030a interfaceC1030a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC1030a) == null) {
            this.f54503b = interfaceC1030a;
        }
    }
}
