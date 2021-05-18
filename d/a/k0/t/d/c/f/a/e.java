package d.a.k0.t.d.c.f.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernOfflineViewHolder;
import d.a.k0.x.b0;
/* loaded from: classes4.dex */
public class e extends d.a.c.j.e.a<d.a.k0.t.d.c.f.b.b, LiveTabConcernOfflineViewHolder> {
    public TbPageContext m;
    public b0<d.a.k0.t.d.c.f.b.b> n;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.k0.t.d.c.f.b.b> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.k0.t.d.c.f.b.b bVar) {
            e.this.f0(bVar);
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.t.d.c.f.b.b.k);
        this.n = new a();
        this.m = tbPageContext;
    }

    public final void f0(d.a.k0.t.d.c.f.b.b bVar) {
        if (bVar == null) {
            return;
        }
        String str = bVar.f61245e;
        if (StringUtils.isNull(str) || d.a.c.e.m.b.f(str, 0L) == 0) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.m.getPageActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.m.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(str, 0L), !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str), false)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public LiveTabConcernOfflineViewHolder P(ViewGroup viewGroup) {
        d.a.k0.t.d.c.f.d.f fVar = new d.a.k0.t.d.c.f.d.f(this.m, viewGroup);
        fVar.o(this.n);
        return new LiveTabConcernOfflineViewHolder(fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.t.d.c.f.b.b bVar, LiveTabConcernOfflineViewHolder liveTabConcernOfflineViewHolder) {
        d.a.k0.t.d.c.f.d.f fVar;
        if (liveTabConcernOfflineViewHolder == null || (fVar = liveTabConcernOfflineViewHolder.f13856a) == null) {
            return null;
        }
        fVar.m(bVar);
        return liveTabConcernOfflineViewHolder.a();
    }
}
