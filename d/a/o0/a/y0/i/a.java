package d.a.o0.a.y0.i;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.y0.d;
import d.a.o0.a.y0.i.c;
import d.a.o0.a.y0.i.d.e;
/* loaded from: classes7.dex */
public final class a extends d.a.o0.a.y0.b<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.f f48972h;

    /* renamed from: d.a.o0.a.y0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0992a implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f48973a;

        public C0992a(a aVar) {
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
            this.f48973a = aVar;
        }

        @Override // d.a.o0.a.y0.i.c.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48973a.f48904b == null) {
                return;
            }
            this.f48973a.f48904b.onCallback(this.f48973a, "onConfirmBtnClick", null);
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
        C0992a c0992a = new C0992a(this);
        this.f48972h = c0992a;
        cVar.D0(c0992a);
        this.f48903a.a(new d.a.o0.a.y0.i.d.d());
        this.f48903a.a(new d.a.o0.a.y0.i.d.c());
        this.f48903a.a(new e());
        this.f48903a.a(new d.a.o0.a.y0.i.d.a());
        this.f48903a.a(new d.a.o0.a.y0.i.d.b());
    }
}
