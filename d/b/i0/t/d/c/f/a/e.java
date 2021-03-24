package d.b.i0.t.d.c.f.a;

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
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class e extends d.b.b.j.e.a<d.b.i0.t.d.c.f.b.b, LiveTabConcernOfflineViewHolder> {
    public TbPageContext m;
    public b0<d.b.i0.t.d.c.f.b.b> n;

    /* loaded from: classes4.dex */
    public class a extends b0<d.b.i0.t.d.c.f.b.b> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.t.d.c.f.b.b bVar) {
            e.this.i0(bVar);
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.d.c.f.b.b.k);
        this.n = new a();
        this.m = tbPageContext;
    }

    public final void i0(d.b.i0.t.d.c.f.b.b bVar) {
        if (bVar == null) {
            return;
        }
        String str = bVar.f60357e;
        if (StringUtils.isNull(str) || d.b.b.e.m.b.f(str, 0L) == 0) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.m.getPageActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.m.getPageActivity()).createNormalConfig(d.b.b.e.m.b.f(str, 0L), !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str), false)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public LiveTabConcernOfflineViewHolder R(ViewGroup viewGroup) {
        d.b.i0.t.d.c.f.d.f fVar = new d.b.i0.t.d.c.f.d.f(this.m, viewGroup);
        fVar.q(this.n);
        return new LiveTabConcernOfflineViewHolder(fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.d.c.f.b.b bVar, LiveTabConcernOfflineViewHolder liveTabConcernOfflineViewHolder) {
        d.b.i0.t.d.c.f.d.f fVar;
        if (liveTabConcernOfflineViewHolder == null || (fVar = liveTabConcernOfflineViewHolder.f14798a) == null) {
            return null;
        }
        fVar.n(bVar);
        return liveTabConcernOfflineViewHolder.a();
    }
}
