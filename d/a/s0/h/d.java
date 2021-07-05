package d.a.s0.h;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.w0;
import d.a.s0.h.f;
import d.a.s0.h.i;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements i.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f59876a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f59877b;

        public a(TbPageContext tbPageContext, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59876a = tbPageContext;
            this.f59877b = gVar;
        }

        @Override // d.a.s0.h.i.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (j.A()) {
                    d.e(jSONArray, this.f59877b.b(), this.f59877b.c());
                } else {
                    l.L(this.f59876a.getContext(), R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f59878a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f59879b;

        public b(TbPageContext tbPageContext, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59878a = tbPageContext;
            this.f59879b = gVar;
        }

        @Override // d.a.s0.h.f.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (j.A()) {
                    d.e(jSONArray, this.f59879b.b(), this.f59879b.c());
                } else {
                    l.L(this.f59878a.getContext(), R.string.neterror);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, gVar) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        f fVar = new f(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        AntiData c2 = d.a.s0.u0.b.e().c();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (c2 != null && c2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c2.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        List<b2> f2 = d.a.s0.u0.b.e().f();
        for (int i3 = 0; i3 < f2.size(); i3++) {
            jSONArray.put(f2.get(i3).n1());
        }
        w0 w0Var = new w0();
        w0Var.j(sparseArray);
        w0Var.i(gVar.a());
        w0Var.o(jSONArray);
        w0Var.l(d.a.s0.u0.b.e().d());
        fVar.w(w0Var);
        fVar.x(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_5)});
        fVar.z("1");
        fVar.y(new b(tbPageContext, gVar));
    }

    public static void c(TbPageContext tbPageContext, g gVar, h hVar, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, gVar, hVar, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        i iVar = new i(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), hVar, userData);
        AntiData c2 = d.a.s0.u0.b.e().c();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (c2 != null && c2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c2.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        List<b2> f2 = d.a.s0.u0.b.e().f();
        for (int i3 = 0; i3 < f2.size(); i3++) {
            jSONArray.put(f2.get(i3).n1());
        }
        w0 w0Var = new w0();
        w0Var.j(sparseArray);
        w0Var.i(gVar.a());
        w0Var.o(jSONArray);
        w0Var.l(d.a.s0.u0.b.e().d());
        iVar.A(w0Var);
        iVar.B(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_5)});
        iVar.D("1");
        iVar.C(new a(tbPageContext, gVar));
    }

    public static void d(int i2, TbPageContext tbPageContext, g gVar, h hVar, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), tbPageContext, gVar, hVar, userData}) == null) {
            if (1 == i2) {
                c(tbPageContext, gVar, hVar, userData);
            } else {
                b(tbPageContext, gVar);
            }
        }
    }

    public static void e(JSONArray jSONArray, ForumManageModel forumManageModel, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65540, null, jSONArray, forumManageModel, b2Var) == null) || forumManageModel == null || b2Var == null || b2Var.H() == null) {
            return;
        }
        String userId = b2Var.H().getUserId();
        String c0 = b2Var.c0();
        String W = b2Var.W();
        String valueOf = String.valueOf(b2Var.Q());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            forumManageModel.Q(StringHelper.JsonArrayToString(jSONArray));
        }
        forumManageModel.R(valueOf, W, c0, null, 0, 1, isCurrentAccount, b2Var.J());
    }
}
