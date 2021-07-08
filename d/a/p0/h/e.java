package d.a.p0.h;

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
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.w0;
import d.a.p0.h.g;
import d.a.p0.h.j;
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
        public final /* synthetic */ TbPageContext f56632a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f56633b;

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
            this.f56632a = tbPageContext;
            this.f56633b = hVar;
        }

        @Override // d.a.p0.h.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (d.a.c.e.p.j.A()) {
                    e.e(jSONArray, this.f56633b.b(), this.f56633b.c());
                } else {
                    l.L(this.f56632a.getContext(), R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements g.InterfaceC1395g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f56634a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f56635b;

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
            this.f56634a = tbPageContext;
            this.f56635b = hVar;
        }

        @Override // d.a.p0.h.g.InterfaceC1395g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (d.a.c.e.p.j.A()) {
                    e.e(jSONArray, this.f56635b.b(), this.f56635b.c());
                } else {
                    l.L(this.f56634a.getContext(), R.string.neterror);
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
        AntiData c2 = d.a.p0.u0.b.e().c();
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
        List<b2> f2 = d.a.p0.u0.b.e().f();
        for (int i3 = 0; i3 < f2.size(); i3++) {
            jSONArray.put(f2.get(i3).n1());
        }
        w0 w0Var = new w0();
        w0Var.j(sparseArray);
        w0Var.i(hVar.a());
        w0Var.o(jSONArray);
        w0Var.l(d.a.p0.u0.b.e().d());
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
        AntiData c2 = d.a.p0.u0.b.e().c();
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
        List<b2> f2 = d.a.p0.u0.b.e().f();
        for (int i3 = 0; i3 < f2.size(); i3++) {
            jSONArray.put(f2.get(i3).n1());
        }
        w0 w0Var = new w0();
        w0Var.j(sparseArray);
        w0Var.i(hVar.a());
        w0Var.o(jSONArray);
        w0Var.l(d.a.p0.u0.b.e().d());
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
