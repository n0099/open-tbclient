package d.a.n0.a.y0.e;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.y0.d;
import d.a.n0.a.y0.e.c;
import d.a.n0.a.y0.e.d.e;
/* loaded from: classes7.dex */
public class a extends d.a.n0.a.y0.b<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.f f48408h;

    /* renamed from: d.a.n0.a.y0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0975a implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f48409a;

        public C0975a(a aVar) {
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
            this.f48409a = aVar;
        }

        @Override // d.a.n0.a.y0.e.c.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48409a.f48400b == null) {
                return;
            }
            this.f48409a.f48400b.onCallback(this.f48409a, "onCustomKeyboardHide", null);
        }

        @Override // d.a.n0.a.y0.e.c.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f48409a.f48400b == null) {
                return;
            }
            this.f48409a.f48400b.onCallback(this.f48409a, "onCustomKeyboardShow", Integer.valueOf(i2));
        }

        @Override // d.a.n0.a.y0.e.c.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f48409a.f48400b == null) {
                return;
            }
            this.f48409a.f48400b.onCallback(this.f48409a, "committext", str);
        }

        @Override // d.a.n0.a.y0.e.c.f
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f48409a.f48400b == null) {
                return;
            }
            this.f48409a.f48400b.onCallback(this.f48409a, "deletebutton", new KeyEvent(0, 67));
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
        C0975a c0975a = new C0975a(this);
        this.f48408h = c0975a;
        cVar.C0(c0975a);
        this.f48399a.a(new e());
        this.f48399a.a(new d.a.n0.a.y0.e.d.a());
        this.f48399a.a(new d.a.n0.a.y0.e.d.d());
        this.f48399a.a(new d.a.n0.a.y0.e.d.c());
        this.f48399a.a(new d.a.n0.a.y0.e.d.b());
    }
}
