package d.a.n0.r0.o2;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.frs.FrsFragment;
import d.a.m0.r.s.a;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f62907a;

    /* renamed from: b  reason: collision with root package name */
    public b f62908b;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Void, Boolean> {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a(b bVar) {
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                if (aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        /* renamed from: d.a.n0.r0.o2.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1585b implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PopInfo f62910e;

            public C1585b(PopInfo popInfo) {
                this.f62910e = popInfo;
            }

            @Override // d.a.m0.r.s.a.e
            public void onClick(d.a.m0.r.s.a aVar) {
                UrlManager.getInstance().dealOneLink(c.this.f62907a.getPageContext(), new String[]{this.f62910e.ahead_url});
                if (aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            d.a.c.e.d.l<String> g2 = d.a.m0.r.r.a.f().g("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.f62907a.j0().getForum().getName());
            if (g2.get(encode) == null) {
                g2.g(encode, "1");
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.c() && c.this.f62907a.isAdded()) {
                PopInfo popInfo = c.this.f62907a.j0().enterFrsDialogInfo;
                d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(c.this.f62907a.getActivity());
                aVar.setTitle(popInfo.title);
                aVar.setMessage(popInfo.v_title);
                aVar.isShowTitleAndMessage();
                aVar.setNegativeButton(popInfo.ok_info, new a(this));
                aVar.setPositiveButton(popInfo.ahead_info, new C1585b(popInfo));
                aVar.create(c.this.f62907a.getPageContext()).show();
            }
        }
    }

    public c(FrsFragment frsFragment) {
        this.f62907a = frsFragment;
    }

    public final boolean c() {
        PopInfo popInfo = this.f62907a.j0().enterFrsDialogInfo;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.f62907a.j0().enterFrsDialogInfo.if_pop.intValue() == 0) ? false : true;
    }

    public void d() {
        FrsFragment frsFragment;
        if (!TbadkCoreApplication.isLogin() || (frsFragment = this.f62907a) == null || frsFragment.j0() == null || this.f62907a.j0().getForum() == null || StringUtils.isNull(this.f62907a.j0().getForum().getName()) || this.f62907a.j0().enterFrsDialogInfo == null || !c() || this.f62908b != null) {
            return;
        }
        b bVar = new b();
        this.f62908b = bVar;
        bVar.execute(new Void[0]);
    }
}
