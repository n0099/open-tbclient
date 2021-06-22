package d.a.o0.v.d.c.f.a;

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
import d.a.o0.z.b0;
/* loaded from: classes4.dex */
public class e extends d.a.c.k.e.a<d.a.o0.v.d.c.f.b.b, LiveTabConcernOfflineViewHolder> {
    public TbPageContext m;
    public b0<d.a.o0.v.d.c.f.b.b> n;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.o0.v.d.c.f.b.b> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.o0.v.d.c.f.b.b bVar) {
            e.this.g0(bVar);
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.v.d.c.f.b.b.k);
        this.n = new a();
        this.m = tbPageContext;
    }

    public final void g0(d.a.o0.v.d.c.f.b.b bVar) {
        if (bVar == null) {
            return;
        }
        String str = bVar.f65371e;
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
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public LiveTabConcernOfflineViewHolder Q(ViewGroup viewGroup) {
        d.a.o0.v.d.c.f.d.f fVar = new d.a.o0.v.d.c.f.d.f(this.m, viewGroup);
        fVar.p(this.n);
        return new LiveTabConcernOfflineViewHolder(fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.v.d.c.f.b.b bVar, LiveTabConcernOfflineViewHolder liveTabConcernOfflineViewHolder) {
        d.a.o0.v.d.c.f.d.f fVar;
        if (liveTabConcernOfflineViewHolder == null || (fVar = liveTabConcernOfflineViewHolder.f13906a) == null) {
            return null;
        }
        fVar.n(bVar);
        return liveTabConcernOfflineViewHolder.a();
    }
}
