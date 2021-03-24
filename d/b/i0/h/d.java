package d.b.i0.h;

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
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import d.b.i0.h.f;
import d.b.i0.h.i;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes4.dex */
public class d {

    /* loaded from: classes4.dex */
    public static class a implements i.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f55070a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f55071b;

        public a(TbPageContext tbPageContext, g gVar) {
            this.f55070a = tbPageContext;
            this.f55071b = gVar;
        }

        @Override // d.b.i0.h.i.h
        public void a(JSONArray jSONArray) {
            if (j.A()) {
                d.e(jSONArray, this.f55071b.b(), this.f55071b.c());
            } else {
                l.K(this.f55070a.getContext(), R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements f.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f55072a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f55073b;

        public b(TbPageContext tbPageContext, g gVar) {
            this.f55072a = tbPageContext;
            this.f55073b = gVar;
        }

        @Override // d.b.i0.h.f.g
        public void a(JSONArray jSONArray) {
            if (j.A()) {
                d.e(jSONArray, this.f55073b.b(), this.f55073b.c());
            } else {
                l.K(this.f55072a.getContext(), R.string.neterror);
            }
        }
    }

    public static void b(TbPageContext tbPageContext, g gVar) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        f fVar = new f(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        AntiData c2 = d.b.i0.p0.b.e().c();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (c2 != null && c2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c2.getDelThreadInfoList();
            for (int i = 0; i < delThreadInfoList.size(); i++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        List<a2> f2 = d.b.i0.p0.b.e().f();
        for (int i2 = 0; i2 < f2.size(); i2++) {
            jSONArray.put(f2.get(i2).w1());
        }
        v0 v0Var = new v0();
        v0Var.j(sparseArray);
        v0Var.i(gVar.a());
        v0Var.o(jSONArray);
        v0Var.l(d.b.i0.p0.b.e().d());
        fVar.w(v0Var);
        fVar.x(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_5)});
        fVar.z("1");
        fVar.y(new b(tbPageContext, gVar));
    }

    public static void c(TbPageContext tbPageContext, g gVar, h hVar, UserData userData) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        i iVar = new i(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), hVar, userData);
        AntiData c2 = d.b.i0.p0.b.e().c();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (c2 != null && c2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c2.getDelThreadInfoList();
            for (int i = 0; i < delThreadInfoList.size(); i++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        List<a2> f2 = d.b.i0.p0.b.e().f();
        for (int i2 = 0; i2 < f2.size(); i2++) {
            jSONArray.put(f2.get(i2).w1());
        }
        v0 v0Var = new v0();
        v0Var.j(sparseArray);
        v0Var.i(gVar.a());
        v0Var.o(jSONArray);
        v0Var.l(d.b.i0.p0.b.e().d());
        iVar.A(v0Var);
        iVar.B(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_5)});
        iVar.D("1");
        iVar.C(new a(tbPageContext, gVar));
    }

    public static void d(int i, TbPageContext tbPageContext, g gVar, h hVar, UserData userData) {
        if (1 == i) {
            c(tbPageContext, gVar, hVar, userData);
        } else {
            b(tbPageContext, gVar);
        }
    }

    public static void e(JSONArray jSONArray, ForumManageModel forumManageModel, a2 a2Var) {
        if (forumManageModel == null || a2Var == null || a2Var.T() == null) {
            return;
        }
        String userId = a2Var.T().getUserId();
        String o0 = a2Var.o0();
        String i0 = a2Var.i0();
        String valueOf = String.valueOf(a2Var.c0());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            forumManageModel.M(StringHelper.JsonArrayToString(jSONArray));
        }
        forumManageModel.N(valueOf, i0, o0, null, 0, 1, isCurrentAccount, a2Var.V());
    }
}
