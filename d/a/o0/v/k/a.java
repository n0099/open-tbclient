package d.a.o0.v.k;

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
import d.a.o0.a.k;
import d.a.o0.a.v2.q;
import d.a.o0.a.y0.d;
import d.a.o0.a.y0.f.a;
import java.util.Map;
/* loaded from: classes7.dex */
public class a implements d.a.o0.a.y0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f51703e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f51704a;

    /* renamed from: b  reason: collision with root package name */
    public a.InterfaceC0988a f51705b;

    /* renamed from: c  reason: collision with root package name */
    public CyberExtractor f51706c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f51707d;

    /* renamed from: d.a.o0.v.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1170a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51708e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f51709f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f51710g;

        public RunnableC1170a(a aVar, String str, Map map) {
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
            this.f51710g = aVar;
            this.f51708e = str;
            this.f51709f = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f51710g.f51707d) {
                    if (a.f51703e) {
                        Log.d("MediaExtractorWidget", "media extractor already released");
                        return;
                    }
                    return;
                }
                this.f51710g.f51706c.setDataSource(this.f51710g.getContext(), Uri.parse(d.a.o0.a.y0.j.a.a(this.f51708e)), this.f51709f);
                Bundle metaData = this.f51710g.f51706c.getMetaData();
                if (this.f51710g.f51705b != null) {
                    this.f51710g.f51705b.a(metaData);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(756299808, "Ld/a/o0/v/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(756299808, "Ld/a/o0/v/k/a;");
                return;
            }
        }
        f51703e = k.f46335a;
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
        this.f51704a = str;
        this.f51707d = false;
    }

    @Override // d.a.o0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f51706c = new CyberExtractor(true);
            aVar.a(true);
        }
    }

    @Override // d.a.o0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51704a : (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.o0.a.c1.a.b() : (Context) invokeV.objValue;
    }

    @Override // d.a.o0.a.y0.d
    @Nullable
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.y0.f.a
    public void k(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        q.i(new RunnableC1170a(this, str, map), "loadMetadata");
    }

    @Override // d.a.o0.a.y0.f.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f51707d = true;
            CyberExtractor cyberExtractor = this.f51706c;
            if (cyberExtractor != null) {
                cyberExtractor.release();
            }
            this.f51706c = null;
            a.InterfaceC0988a interfaceC0988a = this.f51705b;
            if (interfaceC0988a != null) {
                interfaceC0988a.onRelease();
            }
            this.f51705b = null;
        }
    }

    @Override // d.a.o0.a.y0.f.a
    public void w(a.InterfaceC0988a interfaceC0988a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0988a) == null) {
            this.f51705b = interfaceC0988a;
        }
    }
}
