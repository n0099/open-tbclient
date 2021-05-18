package d.a.k0.q0.o2;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.frs.FrsFragment;
import d.a.j0.r.s.a;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f59075a;

    /* renamed from: b  reason: collision with root package name */
    public b f59076b;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Void, Boolean> {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a(b bVar) {
            }

            @Override // d.a.j0.r.s.a.e
            public void onClick(d.a.j0.r.s.a aVar) {
                if (aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        /* renamed from: d.a.k0.q0.o2.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1516b implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PopInfo f59078e;

            public C1516b(PopInfo popInfo) {
                this.f59078e = popInfo;
            }

            @Override // d.a.j0.r.s.a.e
            public void onClick(d.a.j0.r.s.a aVar) {
                UrlManager.getInstance().dealOneLink(c.this.f59075a.getPageContext(), new String[]{this.f59078e.ahead_url});
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
            d.a.c.e.d.l<String> g2 = d.a.j0.r.r.a.f().g("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.f59075a.g0().getForum().getName());
            if (g2.get(encode) == null) {
                g2.g(encode, "1");
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.c() && c.this.f59075a.isAdded()) {
                PopInfo popInfo = c.this.f59075a.g0().enterFrsDialogInfo;
                d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(c.this.f59075a.getActivity());
                aVar.setTitle(popInfo.title);
                aVar.setMessage(popInfo.v_title);
                aVar.isShowTitleAndMessage();
                aVar.setNegativeButton(popInfo.ok_info, new a(this));
                aVar.setPositiveButton(popInfo.ahead_info, new C1516b(popInfo));
                aVar.create(c.this.f59075a.getPageContext()).show();
            }
        }
    }

    public c(FrsFragment frsFragment) {
        this.f59075a = frsFragment;
    }

    public final boolean c() {
        PopInfo popInfo = this.f59075a.g0().enterFrsDialogInfo;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.f59075a.g0().enterFrsDialogInfo.if_pop.intValue() == 0) ? false : true;
    }

    public void d() {
        FrsFragment frsFragment;
        if (!TbadkCoreApplication.isLogin() || (frsFragment = this.f59075a) == null || frsFragment.g0() == null || this.f59075a.g0().getForum() == null || StringUtils.isNull(this.f59075a.g0().getForum().getName()) || this.f59075a.g0().enterFrsDialogInfo == null || !c() || this.f59076b != null) {
            return;
        }
        b bVar = new b();
        this.f59076b = bVar;
        bVar.execute(new Void[0]);
    }
}
