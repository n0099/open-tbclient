package d.a.q0.a.y0.i;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.y0.d;
import d.a.q0.a.y0.i.c;
import d.a.q0.a.y0.i.d.e;
/* loaded from: classes8.dex */
public final class a extends d.a.q0.a.y0.b<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.f f51770h;

    /* renamed from: d.a.q0.a.y0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1034a implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f51771a;

        public C1034a(a aVar) {
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
            this.f51771a = aVar;
        }

        @Override // d.a.q0.a.y0.i.c.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51771a.f51702b == null) {
                return;
            }
            this.f51771a.f51702b.onCallback(this.f51771a, "onConfirmBtnClick", null);
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
        C1034a c1034a = new C1034a(this);
        this.f51770h = c1034a;
        cVar.D0(c1034a);
        this.f51701a.a(new d.a.q0.a.y0.i.d.d());
        this.f51701a.a(new d.a.q0.a.y0.i.d.c());
        this.f51701a.a(new e());
        this.f51701a.a(new d.a.q0.a.y0.i.d.a());
        this.f51701a.a(new d.a.q0.a.y0.i.d.b());
    }
}
