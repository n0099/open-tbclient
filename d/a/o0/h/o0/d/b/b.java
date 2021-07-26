package d.a.o0.h.o0.d.b;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.view.button.userinfo.UserInfoButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.q0;
import d.a.o0.h.f0.e;
import d.a.o0.h.f0.h;
/* loaded from: classes7.dex */
public class b extends d.a.o0.h.o0.d.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f50685e;

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
            this.f50685e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || d.a.o0.h.o0.b.b() == null) {
                return;
            }
            this.f50685e.f50678e = new UserInfoButton(d.a.o0.h.o0.b.b(), this.f50685e);
            this.f50685e.f50678e.setType(this.f50685e.type);
            this.f50685e.f50678e.setButtonText(this.f50685e.text);
            this.f50685e.f50678e.setImageUrl(this.f50685e.image);
            this.f50685e.f50678e.setApiButtonStyle(this.f50685e.style);
            this.f50685e.z();
            this.f50685e.K();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(JsObject jsObject, d.a.o0.a.l0.c cVar) {
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
                super((JsObject) objArr2[0], (d.a.o0.a.l0.c) objArr2[1]);
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
