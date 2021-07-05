package d.a.c0.a.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c0.a.b;
import d.a.c0.a.h.i;
import d.a.c0.a.j.f;
import java.io.File;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static g f45026b;

    /* renamed from: c  reason: collision with root package name */
    public static d.a.c0.a.j.b f45027c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f45028a;

    /* loaded from: classes8.dex */
    public class a extends i.c<d.a.c0.a.h.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a f45029a;

        public a(g gVar, b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45029a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.a.h.i.c
        /* renamed from: e */
        public void a(d.a.c0.a.h.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, str) == null) {
                if (d.a.c0.a.b.n()) {
                    g.c("loadSDK onCompleted filePath: " + str);
                }
                super.a(aVar, str);
                b.a aVar2 = this.f45029a;
                if (aVar2 != null) {
                    aVar2.onResult(true, str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.a.h.i.c
        /* renamed from: f */
        public void b(d.a.c0.a.h.a aVar, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, aVar, exc) == null) {
                if (d.a.c0.a.b.n()) {
                    g.c("loadSDK onFailed failed: " + exc);
                }
                super.b(aVar, exc);
                b.a aVar2 = this.f45029a;
                if (aVar2 != null) {
                    aVar2.onResult(false, exc == null ? "unkown" : exc.getMessage());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.a.h.i.c
        /* renamed from: g */
        public void c(d.a.c0.a.h.a aVar, long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{aVar, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                super.c(aVar, j, j2, i2);
                b.a aVar2 = this.f45029a;
                if (aVar2 != null) {
                    aVar2.onProgress((int) j2, i2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a f45030a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45031b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f45032c;

        public b(g gVar, b.a aVar, String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar, str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45030a = aVar;
            this.f45031b = str;
            this.f45032c = file;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
            if (r1 == false) goto L22;
         */
        @Override // d.a.c0.a.j.f.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i2, d.a.c0.a.j.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, fVar) == null) {
                boolean z = false;
                boolean z2 = i2 == 2;
                if (d.a.c0.a.b.n()) {
                    g.c("onLoadAssets " + z2 + ", state " + i2);
                }
                if (this.f45030a != null) {
                    String str = z2 ? null : this.f45031b;
                    if (this.f45032c != null) {
                        d.a.c0.a.b.t(new d.a.c0.a.c(this.f45032c.getAbsolutePath()));
                    }
                    if (z2) {
                        boolean k0 = d.a.c0.a.a.k0();
                        if (d.a.c0.a.b.n()) {
                            g.c("loadAssets ARControllerProxy.loadSoFile " + k0);
                        }
                    }
                    z = z2;
                    this.f45030a.onResult(z, str);
                }
            }
        }
    }

    public g() {
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

    public static synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (g.class) {
                if (f45026b == null) {
                    f45026b = new g();
                }
            }
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            Log.e("DuAr_SDKLoader", "ar->" + str);
        }
    }

    public static g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (f45026b == null) {
                b();
            }
            return f45026b;
        }
        return (g) invokeV.objValue;
    }

    public final d.a.c0.a.j.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f45027c == null) {
                d.a.c0.a.j.b k = d.a.c0.a.j.b.k();
                d.a.c0.a.b.h();
                k.m(d.a.c0.a.b.c(), "arsource", new File(d.a.c0.a.c.a()));
                f45027c = k;
            }
            return f45027c;
        }
        return (d.a.c0.a.j.b) invokeV.objValue;
    }

    public File f() {
        InterceptResult invokeV;
        File l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = d.a.c0.a.b.p() && g();
            if (z) {
                l = d.d().h();
            } else {
                l = d.a.c0.a.h.a.j(d.a.c0.a.b.f()).l();
            }
            if (d.a.c0.a.b.n()) {
                c("sdkPath useLocal " + z + ", SDKPath " + l);
            }
            return l;
        }
        return (File) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f45028a == null) {
                this.f45028a = Boolean.FALSE;
                try {
                    String[] list = d.a.c0.a.b.c().getAssets().list("arsource");
                    this.f45028a = Boolean.valueOf(list != null && list.length > 0);
                    if (d.a.c0.a.b.n()) {
                        if (list == null) {
                            str = StringUtil.NULL_STRING;
                        } else {
                            str = "" + list.length;
                        }
                        c("hasAssetsResource: " + str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return this.f45028a.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = d.a.c0.a.b.p() && g();
            if (z) {
                q = d().o();
            } else {
                q = d.a.c0.a.h.a.j("live").q();
            }
            if (d.a.c0.a.b.n()) {
                c("isLocal " + z + ", isSDKLoaded " + q);
            }
            return q;
        }
        return invokeV.booleanValue;
    }

    public void i(Context context, String str, File file, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, file, aVar) == null) {
            String str2 = "loadAssets context=" + context + ", assetPath=" + str + ", SDcardFile=" + file;
            if (d.a.c0.a.b.n()) {
                c(str2);
            }
            if ((context == null || TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(file.getAbsolutePath())) && aVar != null) {
                aVar.onResult(false, str2);
            }
            d().r(context, str, file, new b(this, aVar, str2, file));
        }
    }

    public void j(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (d.a.c0.a.b.n()) {
                c("loadAssets hasAssetsResource=" + g());
            }
            if (d.a.c0.a.b.h() == null) {
                c("DuArResConfig null when loadAssets");
            } else if (TextUtils.isEmpty(d.a.c0.a.c.a())) {
                c("DuArResConfig data empty when loadAssets");
            } else {
                i(d.a.c0.a.b.c(), "arsource", new File(d.a.c0.a.c.a()), aVar);
            }
        }
    }

    public void k(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (d.a.c0.a.b.p() && g()) {
                j(aVar);
            } else if (d.a.c0.a.b.d() == null) {
                c("loadSDK with Downlader==null");
            } else {
                d.a.c0.a.h.a.j(d.a.c0.a.b.f()).v(d.a.c0.a.b.c(), new a(this, aVar));
            }
        }
    }
}
