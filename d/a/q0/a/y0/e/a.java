package d.a.q0.a.y0.e;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.y0.d;
import d.a.q0.a.y0.e.c;
import d.a.q0.a.y0.e.d.e;
/* loaded from: classes8.dex */
public class a extends d.a.q0.a.y0.b<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.f f51710h;

    /* renamed from: d.a.q0.a.y0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1026a implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f51711a;

        public C1026a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51711a = aVar;
        }

        @Override // d.a.q0.a.y0.e.c.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51711a.f51702b == null) {
                return;
            }
            this.f51711a.f51702b.onCallback(this.f51711a, "onCustomKeyboardHide", null);
        }

        @Override // d.a.q0.a.y0.e.c.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f51711a.f51702b == null) {
                return;
            }
            this.f51711a.f51702b.onCallback(this.f51711a, "onCustomKeyboardShow", Integer.valueOf(i2));
        }

        @Override // d.a.q0.a.y0.e.c.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f51711a.f51702b == null) {
                return;
            }
            this.f51711a.f51702b.onCallback(this.f51711a, "committext", str);
        }

        @Override // d.a.q0.a.y0.e.c.f
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f51711a.f51702b == null) {
                return;
            }
            this.f51711a.f51702b.onCallback(this.f51711a, "deletebutton", new KeyEvent(0, 67));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C1026a c1026a = new C1026a(this);
        this.f51710h = c1026a;
        cVar.C0(c1026a);
        this.f51701a.a(new e());
        this.f51701a.a(new d.a.q0.a.y0.e.d.a());
        this.f51701a.a(new d.a.q0.a.y0.e.d.d());
        this.f51701a.a(new d.a.q0.a.y0.e.d.c());
        this.f51701a.a(new d.a.q0.a.y0.e.d.b());
    }
}
