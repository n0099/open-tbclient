package d.a.n0.a.y0.i;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.y0.d;
import d.a.n0.a.y0.i.c;
import d.a.n0.a.y0.i.d.e;
/* loaded from: classes7.dex */
public final class a extends d.a.n0.a.y0.b<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.f f48468h;

    /* renamed from: d.a.n0.a.y0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0983a implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f48469a;

        public C0983a(a aVar) {
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
            this.f48469a = aVar;
        }

        @Override // d.a.n0.a.y0.i.c.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48469a.f48400b == null) {
                return;
            }
            this.f48469a.f48400b.onCallback(this.f48469a, "onConfirmBtnClick", null);
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
        C0983a c0983a = new C0983a(this);
        this.f48468h = c0983a;
        cVar.D0(c0983a);
        this.f48399a.a(new d.a.n0.a.y0.i.d.d());
        this.f48399a.a(new d.a.n0.a.y0.i.d.c());
        this.f48399a.a(new e());
        this.f48399a.a(new d.a.n0.a.y0.i.d.a());
        this.f48399a.a(new d.a.n0.a.y0.i.d.b());
    }
}
