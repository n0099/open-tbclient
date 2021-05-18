package d.a.k0.t.d.c.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernNotificationViewHolder;
import d.a.k0.x.b0;
/* loaded from: classes4.dex */
public class d extends d.a.c.j.e.a<d.a.k0.t.d.c.f.b.a, LiveTabConcernNotificationViewHolder> {
    public TbPageContext m;
    public boolean n;
    public b0<d.a.k0.t.d.c.f.b.a> o;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.k0.t.d.c.f.b.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.k0.t.d.c.f.b.a aVar) {
            if (view.getId() == R.id.id_tab_live_sub_notification_close_btn) {
                if (d.this.n) {
                    return;
                }
                d.this.n = true;
                AlaSharedPrefHelper.getInstance().putLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, System.currentTimeMillis());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921421));
            } else if (view.getId() == R.id.id_tab_live_sub_notification_close_go_to_open) {
                d.a.k0.t.d.c.f.c.a.b(d.this.m);
            }
        }
    }

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.t.d.c.f.b.a.f61244e);
        this.n = false;
        this.o = new a();
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public LiveTabConcernNotificationViewHolder P(ViewGroup viewGroup) {
        d.a.k0.t.d.c.f.d.e eVar = new d.a.k0.t.d.c.f.d.e(this.m, viewGroup);
        eVar.o(this.o);
        return new LiveTabConcernNotificationViewHolder(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.t.d.c.f.b.a aVar, LiveTabConcernNotificationViewHolder liveTabConcernNotificationViewHolder) {
        d.a.k0.t.d.c.f.d.e eVar;
        if (liveTabConcernNotificationViewHolder == null || (eVar = liveTabConcernNotificationViewHolder.f13855a) == null) {
            return null;
        }
        this.n = false;
        eVar.m(aVar);
        return liveTabConcernNotificationViewHolder.a();
    }
}
