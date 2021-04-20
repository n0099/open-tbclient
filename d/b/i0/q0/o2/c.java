package d.b.i0.q0.o2;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.frs.FrsFragment;
import d.b.h0.r.s.a;
import java.net.URLEncoder;
import tbclient.PopInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f59826a;

    /* renamed from: b  reason: collision with root package name */
    public b f59827b;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Void, Boolean> {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a(b bVar) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                if (aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        /* renamed from: d.b.i0.q0.o2.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1480b implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PopInfo f59829e;

            public C1480b(PopInfo popInfo) {
                this.f59829e = popInfo;
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                UrlManager.getInstance().dealOneLink(c.this.f59826a.getPageContext(), new String[]{this.f59829e.ahead_url});
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
            d.b.c.e.d.l<String> g2 = d.b.h0.r.r.a.f().g("tb.enter_frs_dialog_list");
            String encode = URLEncoder.encode(c.this.f59826a.S().getForum().getName());
            if (g2.get(encode) == null) {
                g2.g(encode, "1");
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && c.this.c() && c.this.f59826a.isAdded()) {
                PopInfo popInfo = c.this.f59826a.S().enterFrsDialogInfo;
                d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(c.this.f59826a.getActivity());
                aVar.setTitle(popInfo.title);
                aVar.setMessage(popInfo.v_title);
                aVar.isShowTitleAndMessage();
                aVar.setNegativeButton(popInfo.ok_info, new a(this));
                aVar.setPositiveButton(popInfo.ahead_info, new C1480b(popInfo));
                aVar.create(c.this.f59826a.getPageContext()).show();
            }
        }
    }

    public c(FrsFragment frsFragment) {
        this.f59826a = frsFragment;
    }

    public final boolean c() {
        PopInfo popInfo = this.f59826a.S().enterFrsDialogInfo;
        return (popInfo == null || StringUtils.isNull(popInfo.ahead_info) || StringUtils.isNull(popInfo.ahead_url) || StringUtils.isNull(popInfo.ok_info) || StringUtils.isNull(popInfo.title) || StringUtils.isNull(popInfo.v_title) || this.f59826a.S().enterFrsDialogInfo.if_pop.intValue() == 0) ? false : true;
    }

    public void d() {
        FrsFragment frsFragment;
        if (!TbadkCoreApplication.isLogin() || (frsFragment = this.f59826a) == null || frsFragment.S() == null || this.f59826a.S().getForum() == null || StringUtils.isNull(this.f59826a.S().getForum().getName()) || this.f59826a.S().enterFrsDialogInfo == null || !c() || this.f59827b != null) {
            return;
        }
        b bVar = new b();
        this.f59827b = bVar;
        bVar.execute(new Void[0]);
    }
}
