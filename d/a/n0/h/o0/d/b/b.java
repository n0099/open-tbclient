package d.a.n0.h.o0.d.b;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.view.button.userinfo.UserInfoButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.v2.q0;
import d.a.n0.h.f0.e;
import d.a.n0.h.f0.h;
/* loaded from: classes7.dex */
public class b extends d.a.n0.h.o0.d.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f50181e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50181e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.a.n0.h.o0.b.b() == null) {
                return;
            }
            this.f50181e.f50174e = new UserInfoButton(d.a.n0.h.o0.b.b(), this.f50181e);
            this.f50181e.f50174e.setType(this.f50181e.type);
            this.f50181e.f50174e.setButtonText(this.f50181e.text);
            this.f50181e.f50174e.setImageUrl(this.f50181e.image);
            this.f50181e.f50174e.setApiButtonStyle(this.f50181e.style);
            this.f50181e.z();
            this.f50181e.K();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(JsObject jsObject, d.a.n0.a.l0.c cVar) {
        super(jsObject, cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((JsObject) objArr2[0], (d.a.n0.a.l0.c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        q0.b0(new a(this));
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || h.d()) {
            return;
        }
        e.l("Button shows early.");
    }
}
