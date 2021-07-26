package d.a.q0.n1.s;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.model.LegoPageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.d.e.d.l;
import d.a.p0.b1.f0;
import d.a.p0.b1.i0;
import d.a.p0.b1.n;
import java.io.IOException;
import tbclient.Lego.DataRes;
/* loaded from: classes8.dex */
public class c implements d.a.q0.n1.s.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LegoPageModel f61315a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.n1.s.b f61316b;

    /* renamed from: c  reason: collision with root package name */
    public LegoPageModel.b f61317c;

    /* loaded from: classes8.dex */
    public class a implements LegoPageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f61318a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61318a = cVar;
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j, String str, DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) || this.f61318a.f61316b == null) {
                return;
            }
            this.f61318a.f61316b.c(j, str, dataRes, z);
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i2), str2}) == null) || this.f61318a.f61316b == null) {
                return;
            }
            this.f61318a.f61316b.b(j, str, str2, i2);
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j, String str, DataRes dataRes, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f61318a.f61316b == null) {
                return;
            }
            this.f61318a.f61316b.a(true, dataRes, !z, j, str, i2);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends f0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f61319a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f61320b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f61321c;

        public b(c cVar, l lVar, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, lVar, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61319a = lVar;
            this.f61320b = j;
            this.f61321c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                l lVar = this.f61319a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f61320b);
                sb.append("_");
                sb.append(TextUtils.isEmpty(this.f61321c) ? "" : this.f61321c);
                byte[] bArr = (byte[]) lVar.get(sb.toString());
                if (bArr != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException unused) {
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* renamed from: d.a.q0.n1.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1571c implements n<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f61322a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f61323b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f61324c;

        public C1571c(c cVar, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61324c = cVar;
            this.f61322a = j;
            this.f61323b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f61324c.f(this.f61322a, this.f61323b, dataRes);
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61317c = new a(this);
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.f61315a = legoPageModel;
        legoPageModel.z(this.f61317c);
    }

    @Override // d.a.q0.n1.s.a
    public void a(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, str) == null) {
            i0.b(new b(this, d.a.p0.s.r.a.f().d("tb.lego_update"), j, str), new C1571c(this, j, str));
        }
    }

    @Override // d.a.q0.n1.s.a
    public void b(d.a.q0.n1.s.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f61316b = bVar;
        }
    }

    @Override // d.a.q0.n1.s.a
    public void c(int i2, long j, String str, int i3, String str2) {
        LegoPageModel legoPageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i3), str2}) == null) || (legoPageModel = this.f61315a) == null) {
            return;
        }
        legoPageModel.x(i2, j, str, i3, str2);
    }

    public final void f(long j, String str, DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, dataRes}) == null) || j < 0) {
            return;
        }
        d.a.q0.n1.s.b bVar = this.f61316b;
        if (bVar != null) {
            bVar.a(false, dataRes, false, j, str, 1);
        }
        this.f61315a.x(2, j, str, 1, "");
    }
}
