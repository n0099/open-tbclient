package d.a.n0.v.j.b;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.m0.r.s.a;
import d.a.n0.v.j.d.m;
/* loaded from: classes4.dex */
public class j extends d.a.c.j.e.a<m, CardViewHolder<d.a.n0.v.j.h.a>> {
    public TbPageContext m;
    public d.a.n0.m3.d n;
    public boolean o;
    public String p;
    public String q;
    public String r;
    public TextView s;
    public boolean t;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f62031e;

        public a(m mVar) {
            this.f62031e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.m0(this.f62031e);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b(j jVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f62033a;

        public c(TbPageContext tbPageContext) {
            this.f62033a = tbPageContext;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            String str = j.this.o ? j.this.p : "0";
            String str2 = j.this.o ? j.this.q : null;
            String str3 = j.this.o ? j.this.r : null;
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
            d.a.c.e.i.a.l().h(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.f62033a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
        }
    }

    public j(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), m.f62068f);
        this.o = false;
        this.t = false;
        this.m = tbPageContext;
    }

    public void a(String str) {
        this.q = str;
    }

    public final void j0(m mVar, d.a.n0.v.j.h.a aVar) {
        if (mVar.h() == null) {
            return;
        }
        this.s = aVar.s();
        w0();
        aVar.x(8);
        aVar.y(this.f39228e.getResources().getString(R.string.ala_person_center_publish_live));
        aVar.n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void m0(m mVar) {
        if (mVar == null || mVar.h() == null) {
            return;
        }
        d.a.m0.r.d0.b.j().t(d.a.m0.r.d0.b.n("live_publish_live_has_showed"), true);
        x0(this.s, null, false);
        s0();
        TiebaStatic.log("c13618");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: n0 */
    public CardViewHolder<d.a.n0.v.j.h.a> P(ViewGroup viewGroup) {
        return new CardViewHolder<>(new d.a.n0.v.j.h.a(this.m));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: p0 */
    public View W(int i2, View view, ViewGroup viewGroup, m mVar, CardViewHolder<d.a.n0.v.j.h.a> cardViewHolder) {
        if (cardViewHolder.b() == null) {
            return null;
        }
        j0(mVar, cardViewHolder.b());
        cardViewHolder.b().l().setOnClickListener(new a(mVar));
        return cardViewHolder.b().l();
    }

    public final void q0(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new c(tbPageContext));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public final void s0() {
        Plugin plugin2;
        if (Build.VERSION.SDK_INT < 21) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.m.getPageActivity());
            aVar.setAutoNight(false);
            aVar.setTitle(R.string.prompt);
            aVar.setMessage(this.m.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.know, new b(this));
            aVar.create(this.m).show();
        } else if (ViewHelper.checkUpIsLogin(this.m.getPageActivity())) {
            if (this.n == null) {
                this.n = new d.a.n0.m3.d(this.m);
            }
            if (this.o) {
                if (this.n.c()) {
                    return;
                }
            } else if (this.n.d()) {
                return;
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                d.a.c.e.p.l.L(this.m.getPageActivity(), R.string.plugin_config_not_found);
            } else {
                q0(this.m);
            }
        }
    }

    public void t0(String str) {
        this.p = str;
    }

    public void u0(String str) {
        this.r = str;
    }

    public void v0(boolean z) {
        this.o = z;
    }

    public final void w0() {
        if (this.t) {
            return;
        }
        this.t = true;
        if (!d.a.m0.r.d0.b.j().g(d.a.m0.r.d0.b.n("live_publish_live_has_showed"), false)) {
            d.a.m0.r.d0.b.j().t(d.a.m0.r.d0.b.n("live_publish_live_has_showed"), true);
            x0(this.s, null, true);
            return;
        }
        x0(this.s, null, false);
    }

    public final void x0(TextView textView, String str, boolean z) {
        if (textView == null || this.m == null) {
            return;
        }
        if (z) {
            textView.setText("");
            Drawable drawable = this.m.getResources().getDrawable(R.drawable.ala_person_center_red_tip_drawable);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            textView.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        if (str != null) {
            textView.setText(str);
        } else {
            textView.setText("");
        }
        textView.setCompoundDrawables(null, null, null, null);
    }
}
