package d.a.q0.v3.i.d;

import android.annotation.TargetApi;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@TargetApi(18)
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f66078a;

    /* renamed from: b  reason: collision with root package name */
    public String f66079b;

    /* renamed from: c  reason: collision with root package name */
    public String f66080c;

    /* renamed from: d  reason: collision with root package name */
    public String f66081d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66082e;

    /* renamed from: f  reason: collision with root package name */
    public c f66083f;

    /* renamed from: g  reason: collision with root package name */
    public f f66084g;

    /* renamed from: h  reason: collision with root package name */
    public d f66085h;

    /* renamed from: i  reason: collision with root package name */
    public e f66086i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes8.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Context context, String str, String str2, e eVar, c cVar) {
            super(context, str, str2, eVar, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, str, str2, eVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (e) objArr2[3], (c) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = bVar;
        }

        @Override // d.a.q0.v3.i.d.f
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.j = true;
                this.j.d();
            }
        }
    }

    /* renamed from: d.a.q0.v3.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1808b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1808b(b bVar, Context context, String str, e eVar, c cVar) {
            super(context, str, eVar, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, str, eVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (e) objArr2[2], (c) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = bVar;
        }

        @Override // d.a.q0.v3.i.d.d
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.k = true;
                this.j.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void onGenFilterVideoFail(int i2, String str);

        void onGenFilterVideoRecordError(int i2, String str);

        void onGenFilterVideoSuccess(String str);
    }

    public b(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66082e = false;
        this.f66078a = context;
        this.f66079b = str;
        this.f66080c = str2;
        this.f66081d = str3;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.j && this.k && !this.l) {
            this.f66086i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f fVar = this.f66084g;
            if (fVar != null) {
                fVar.interrupt();
                this.f66084g = null;
            }
            d dVar = this.f66085h;
            if (dVar != null) {
                dVar.interrupt();
                this.f66085h = null;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66082e : invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f66083f != null) {
                File file = new File(this.f66080c);
                if (file.exists() && file.length() > 0) {
                    this.f66083f.onGenFilterVideoSuccess(this.f66080c);
                } else {
                    this.f66083f.onGenFilterVideoFail(223, "Err empty outputFile");
                }
            }
            this.f66082e = false;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f66083f = cVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f66082e) {
            return;
        }
        this.f66082e = true;
        this.j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f66080c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f66083f;
            if (cVar != null) {
                cVar.onGenFilterVideoFail(222, d.a.q0.x1.a.a(e2));
            }
        }
        try {
            this.f66086i = new e(this.f66080c);
            a aVar = new a(this, this.f66078a, this.f66079b, this.f66081d, this.f66086i, this.f66083f);
            this.f66084g = aVar;
            aVar.start();
            C1808b c1808b = new C1808b(this, this.f66078a, this.f66079b, this.f66086i, this.f66083f);
            this.f66085h = c1808b;
            c1808b.start();
        } catch (Exception unused) {
        }
    }
}
