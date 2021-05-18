package d.a.k0.o0.c;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.ManagerApplyViewHolder;
/* loaded from: classes4.dex */
public class k extends d.a.k0.q0.k<l, ManagerApplyViewHolder> {
    public static final int y = R.id.assist_apply_tip;
    public d.a.j0.s.i.b w;
    public View.OnClickListener x;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag(k.y);
            if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                k.this.x0(TbadkCoreApplication.getCurrentAccountInfo());
            } else {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(k.this.f39564e), new String[]{tag.toString()});
            }
        }
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.x = new a();
    }

    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        w0(i2, view, viewGroup, (l) obj, (ManagerApplyViewHolder) viewHolder);
        return view;
    }

    public void onDestroy() {
        d.a.j0.s.i.b bVar = this.w;
        if (bVar != null) {
            bVar.s();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: v0 */
    public ManagerApplyViewHolder P(ViewGroup viewGroup) {
        return new ManagerApplyViewHolder(LayoutInflater.from(this.f39564e).inflate(R.layout.frs_member_manager_apply, (ViewGroup) null));
    }

    public View w0(int i2, View view, ViewGroup viewGroup, l lVar, ManagerApplyViewHolder managerApplyViewHolder) {
        super.W(i2, view, viewGroup, lVar, managerApplyViewHolder);
        if (lVar != null && !lVar.f() && managerApplyViewHolder != null) {
            if (lVar.f()) {
                managerApplyViewHolder.f15088d.setVisibility(8);
                return view;
            }
            if (managerApplyViewHolder.f15089e != this.r) {
                SkinManager.setViewTextColor(managerApplyViewHolder.f15086b, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(managerApplyViewHolder.f15085a, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(managerApplyViewHolder.f15087c, R.drawable.frs_member_manito_bg);
            }
            int e2 = lVar.e();
            if (e2 > 0) {
                managerApplyViewHolder.f15086b.setText(String.format(this.f39564e.getResources().getString(R.string.apply_left_num_tip), StringHelper.numberUniformFormat(e2)));
                managerApplyViewHolder.f15087c.setTag(y, lVar.c());
                managerApplyViewHolder.f15087c.setOnClickListener(this.x);
                managerApplyViewHolder.f15087c.setEnabled(true);
                managerApplyViewHolder.f15087c.setClickable(true);
            } else {
                managerApplyViewHolder.f15086b.setText(this.f39564e.getResources().getString(R.string.apply_no_left_tip));
                managerApplyViewHolder.f15087c.setEnabled(false);
                managerApplyViewHolder.f15087c.setClickable(false);
            }
            managerApplyViewHolder.f15086b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            managerApplyViewHolder.f15089e = this.r;
        }
        return view;
    }

    public final void x0(AccountData accountData) {
        d.a.c.a.f<?> a2 = d.a.c.a.j.a(this.f39564e);
        Activity pageActivity = a2 instanceof TbPageContext ? ((TbPageContext) a2).getPageActivity() : null;
        if (this.w == null) {
            this.w = new d.a.j0.s.i.b(pageActivity);
        }
        this.w.p();
        this.w.u(accountData);
        this.w.z(1);
    }
}
