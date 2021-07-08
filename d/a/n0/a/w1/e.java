package d.a.n0.a.w1;

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
import d.a.n0.a.h0.g.f;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static e f48184c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f48185a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f48186b;

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
        public WeakReference<d.a.n0.a.a2.e> f48187a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f48188b;

        /* renamed from: c  reason: collision with root package name */
        public String f48189c;

        /* renamed from: d  reason: collision with root package name */
        public MediaModel f48190d;

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
            if (f48184c == null) {
                synchronized (e.class) {
                    if (f48184c == null) {
                        f48184c = new e();
                    }
                }
            }
            return f48184c;
        }
        return (e) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f48185a = null;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.f48186b.get();
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
            d.a.n0.a.a2.e i2 = d.a.n0.a.a2.e.i();
            f J = d.a.n0.a.g1.f.V().J();
            if (i2 != null && J != null) {
                b bVar = new b(this, null);
                this.f48185a = bVar;
                bVar.f48187a = new WeakReference<>(i2);
                this.f48185a.f48188b = new WeakReference<>(J);
                b bVar2 = this.f48185a;
                bVar2.f48189c = str;
                bVar2.f48190d = mediaModel;
                return;
            }
            this.f48185a = null;
        }
    }

    public void e(d.a.n0.a.a2.e eVar, ReplyEditorParams replyEditorParams, d.a.n0.a.w1.a aVar) {
        f J;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, eVar, replyEditorParams, aVar) == null) || (J = d.a.n0.a.g1.f.V().J()) == null || eVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", replyEditorParams);
        b bVar = this.f48185a;
        if (bVar != null && eVar == bVar.f48187a.get() && J == this.f48185a.f48188b.get()) {
            bundle.putBoolean(MediaTrackConfig.AE_IMPORT_DRAFT, true);
            bundle.putString("content", this.f48185a.f48189c);
            bundle.putParcelable("image", this.f48185a.f48190d);
        }
        d dVar = new d();
        dVar.j1(bundle);
        dVar.P1(aVar);
        dVar.t1(J.u(), "ReplyEditor");
        this.f48186b = new WeakReference<>(dVar);
    }
}
