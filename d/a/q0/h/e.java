package d.a.q0.h;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
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
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.w0;
import d.a.q0.h.g;
import d.a.q0.h.j;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f57176a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f57177b;

        public a(TbPageContext tbPageContext, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57176a = tbPageContext;
            this.f57177b = hVar;
        }

        @Override // d.a.q0.h.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (d.a.d.e.p.j.A()) {
                    e.e(jSONArray, this.f57177b.b(), this.f57177b.c());
                } else {
                    l.L(this.f57176a.getContext(), R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements g.InterfaceC1404g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f57178a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f57179b;

        public b(TbPageContext tbPageContext, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57178a = tbPageContext;
            this.f57179b = hVar;
        }

        @Override // d.a.q0.h.g.InterfaceC1404g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (d.a.d.e.p.j.A()) {
                    e.e(jSONArray, this.f57179b.b(), this.f57179b.c());
                } else {
                    l.L(this.f57178a.getContext(), R.string.neterror);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, hVar) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        g gVar = new g(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        AntiData c2 = d.a.q0.u0.b.e().c();
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
        List<b2> f2 = d.a.q0.u0.b.e().f();
        for (int i3 = 0; i3 < f2.size(); i3++) {
            jSONArray.put(f2.get(i3).o1());
        }
        w0 w0Var = new w0();
        w0Var.j(sparseArray);
        w0Var.i(hVar.a());
        w0Var.o(jSONArray);
        w0Var.l(d.a.q0.u0.b.e().d());
        gVar.w(w0Var);
        gVar.x(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_5)});
        gVar.z("1");
        gVar.y(new b(tbPageContext, hVar));
    }

    public static void c(TbPageContext tbPageContext, h hVar, i iVar, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, hVar, iVar, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        j jVar = new j(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), iVar, userData);
        AntiData c2 = d.a.q0.u0.b.e().c();
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
        List<b2> f2 = d.a.q0.u0.b.e().f();
        for (int i3 = 0; i3 < f2.size(); i3++) {
            jSONArray.put(f2.get(i3).o1());
        }
        w0 w0Var = new w0();
        w0Var.j(sparseArray);
        w0Var.i(hVar.a());
        w0Var.o(jSONArray);
        w0Var.l(d.a.q0.u0.b.e().d());
        jVar.A(w0Var);
        jVar.B(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_5)});
        jVar.D("1");
        jVar.C(new a(tbPageContext, hVar));
    }

    public static void d(int i2, TbPageContext tbPageContext, h hVar, i iVar, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), tbPageContext, hVar, iVar, userData}) == null) {
            if (1 == i2) {
                c(tbPageContext, hVar, iVar, userData);
            } else {
                b(tbPageContext, hVar);
            }
        }
    }

    public static void e(JSONArray jSONArray, ForumManageModel forumManageModel, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray, forumManageModel, b2Var) == null) || forumManageModel == null || b2Var == null || b2Var.H() == null) {
            return;
        }
        String userId = b2Var.H().getUserId();
        String d0 = b2Var.d0();
        String X = b2Var.X();
        String valueOf = String.valueOf(b2Var.R());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            forumManageModel.Q(StringHelper.JsonArrayToString(jSONArray));
        }
        forumManageModel.R(valueOf, X, d0, null, 0, 1, isCurrentAccount, b2Var.J());
    }
}
