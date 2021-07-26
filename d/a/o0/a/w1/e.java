package d.a.o0.a.w1;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.h0.g.f;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static e f48688c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f48689a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f48690b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<d.a.o0.a.a2.e> f48691a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f48692b;

        /* renamed from: c  reason: collision with root package name */
        public String f48693c;

        /* renamed from: d  reason: collision with root package name */
        public MediaModel f48694d;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }

    public e() {
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

    public static e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f48688c == null) {
                synchronized (e.class) {
                    if (f48688c == null) {
                        f48688c = new e();
                    }
                }
            }
            return f48688c;
        }
        return (e) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f48689a = null;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.f48690b.get();
            if (dVar != null) {
                dVar.C1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, mediaModel) == null) {
            d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
            f J = d.a.o0.a.g1.f.V().J();
            if (i2 != null && J != null) {
                b bVar = new b(this, null);
                this.f48689a = bVar;
                bVar.f48691a = new WeakReference<>(i2);
                this.f48689a.f48692b = new WeakReference<>(J);
                b bVar2 = this.f48689a;
                bVar2.f48693c = str;
                bVar2.f48694d = mediaModel;
                return;
            }
            this.f48689a = null;
        }
    }

    public void e(d.a.o0.a.a2.e eVar, ReplyEditorParams replyEditorParams, d.a.o0.a.w1.a aVar) {
        f J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, eVar, replyEditorParams, aVar) == null) || (J = d.a.o0.a.g1.f.V().J()) == null || eVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", replyEditorParams);
        b bVar = this.f48689a;
        if (bVar != null && eVar == bVar.f48691a.get() && J == this.f48689a.f48692b.get()) {
            bundle.putBoolean(MediaTrackConfig.AE_IMPORT_DRAFT, true);
            bundle.putString("content", this.f48689a.f48693c);
            bundle.putParcelable("image", this.f48689a.f48694d);
        }
        d dVar = new d();
        dVar.j1(bundle);
        dVar.P1(aVar);
        dVar.t1(J.u(), "ReplyEditor");
        this.f48690b = new WeakReference<>(dVar);
    }
}
