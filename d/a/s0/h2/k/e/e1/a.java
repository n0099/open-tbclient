package d.a.s0.h2.k.e.e1;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.relatelist.RelateRecThreadListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.s0.h2.h.e;
import d.a.s0.h2.k.e.t0;
import java.util.ArrayList;
import java.util.List;
import tbclient.RelateRecThread.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f60498a;

    /* renamed from: b  reason: collision with root package name */
    public final RelateRecThreadListModel f60499b;

    /* renamed from: c  reason: collision with root package name */
    public t0 f60500c;

    /* renamed from: d  reason: collision with root package name */
    public PbModel f60501d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.r0.m.a f60502e;

    /* renamed from: d.a.s0.h2.k.e.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1465a implements d.a.r0.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60503a;

        public C1465a(a aVar) {
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
            this.f60503a = aVar;
        }

        @Override // d.a.r0.m.a
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.f60503a.f60500c == null || this.f60503a.f60500c.G0() == null) {
                return;
            }
            this.f60503a.f60500c.G0().K();
        }

        @Override // d.a.r0.m.a
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.f60503a.f60501d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    e D0 = this.f60503a.f60501d.D0();
                    String first_class = D0.m() != null ? D0.m().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.f60503a.f60500c == null || this.f60503a.f60500c.G0() == null) {
                            return;
                        }
                        this.f60503a.f60500c.G0().K();
                        return;
                    }
                    this.f60503a.f60498a.addAll(b.b(list, first_class, this.f60503a.f60501d.C0()));
                    D0.D0(this.f60503a.f60498a);
                    Integer num = dataRes.rec_type;
                    D0.A0(num == null ? 0 : num.intValue());
                }
                if (this.f60503a.f60500c != null && !ListUtils.isEmpty(this.f60503a.f60498a)) {
                    this.f60503a.f60500c.h3();
                }
                if (this.f60503a.f60500c.G0() == null || !this.f60503a.f60500c.G0().m() || ListUtils.isEmpty(this.f60503a.f60498a)) {
                    return;
                }
                this.f60503a.f60500c.G0().j();
            }
        }
    }

    public a(d.a.s0.h2.o.b bVar, BdUniqueId bdUniqueId, t0 t0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId, t0Var, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60498a = new ArrayList();
        this.f60502e = new C1465a(this);
        this.f60500c = t0Var;
        this.f60501d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(bVar.getPageContext(), bdUniqueId);
        this.f60499b = relateRecThreadListModel;
        relateRecThreadListModel.D(this.f60502e);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.f60501d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.T0()) || this.f60501d.D0() == null || this.f60501d.D0().Y()) {
                return false;
            }
            int R = this.f60501d.R();
            int C0 = this.f60501d.C0();
            if (R == 1 || C0 == 2 || C0 == 3) {
                String forumId = this.f60501d.getForumId();
                if (TextUtils.isEmpty(forumId) && this.f60501d.D0().m() != null) {
                    forumId = this.f60501d.D0().m().getId();
                }
                long f2 = d.a.c.e.m.b.f(forumId, 0L);
                long f3 = d.a.c.e.m.b.f(this.f60501d.T0(), 0L);
                Log.e("RecThreadList", "************reqRecThreadList************");
                return this.f60499b.C(f2, f3, R, C0);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f60498a.clear();
            this.f60499b.onDestroy();
        }
    }

    public void f(t0 t0Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t0Var, pbModel) == null) {
            this.f60500c = t0Var;
            this.f60501d = pbModel;
        }
    }
}
