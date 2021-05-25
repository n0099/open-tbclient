package d.a.n0.p0.c;

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
import com.baidu.tieba.forumMember.member.PrivateMgrApplyViewHolder;
/* loaded from: classes4.dex */
public class m extends d.a.n0.r0.k<n, PrivateMgrApplyViewHolder> {
    public static final int y = R.id.private_apply_tip;
    public d.a.m0.s.i.b w;
    public View.OnClickListener x;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                Object tag = view.getTag(m.y);
                if (tag == null || tag.toString().equals("")) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(m.this.f39228e), new String[]{tag.toString()});
                return;
            }
            m.this.x0(TbadkCoreApplication.getCurrentAccountInfo());
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.x = new a();
    }

    @Override // d.a.n0.r0.k, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        w0(i2, view, viewGroup, (n) obj, (PrivateMgrApplyViewHolder) viewHolder);
        return view;
    }

    public void onDestroy() {
        d.a.m0.s.i.b bVar = this.w;
        if (bVar != null) {
            bVar.s();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: v0 */
    public PrivateMgrApplyViewHolder P(ViewGroup viewGroup) {
        return new PrivateMgrApplyViewHolder(LayoutInflater.from(this.f39228e).inflate(R.layout.private_member_apply, (ViewGroup) null));
    }

    public View w0(int i2, View view, ViewGroup viewGroup, n nVar, PrivateMgrApplyViewHolder privateMgrApplyViewHolder) {
        super.W(i2, view, viewGroup, nVar, privateMgrApplyViewHolder);
        if (nVar != null && !nVar.h() && privateMgrApplyViewHolder != null) {
            if (nVar.h()) {
                privateMgrApplyViewHolder.f14997e.setVisibility(8);
                return view;
            }
            boolean z = true;
            if (privateMgrApplyViewHolder.f14998f != this.r) {
                SkinManager.setBackgroundColor(privateMgrApplyViewHolder.f14996d, R.color.CAM_X0204);
                SkinManager.setViewTextColor(privateMgrApplyViewHolder.f14994b, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(privateMgrApplyViewHolder.f14993a, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(privateMgrApplyViewHolder.f14995c, R.drawable.frs_member_manito_bg);
            }
            int c2 = nVar.c();
            String string = this.f39228e.getResources().getString(R.string.tbtitle_quota_is_full);
            if (c2 == -1) {
                int f2 = nVar.f();
                String numberUniformFormat = StringHelper.numberUniformFormat(f2);
                if (f2 > 0) {
                    string = String.format(this.f39228e.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                    privateMgrApplyViewHolder.f14995c.setOnClickListener(this.x);
                    privateMgrApplyViewHolder.f14994b.setText(string);
                    privateMgrApplyViewHolder.f14995c.setTag(y, nVar.e());
                    privateMgrApplyViewHolder.f14995c.setEnabled(z);
                    privateMgrApplyViewHolder.f14995c.setClickable(z);
                    privateMgrApplyViewHolder.f14994b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f14998f = this.r;
                }
                z = false;
                privateMgrApplyViewHolder.f14995c.setOnClickListener(this.x);
                privateMgrApplyViewHolder.f14994b.setText(string);
                privateMgrApplyViewHolder.f14995c.setTag(y, nVar.e());
                privateMgrApplyViewHolder.f14995c.setEnabled(z);
                privateMgrApplyViewHolder.f14995c.setClickable(z);
                privateMgrApplyViewHolder.f14994b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                privateMgrApplyViewHolder.f14998f = this.r;
            } else {
                if (c2 == 0) {
                    string = this.f39228e.getResources().getString(R.string.tbtitle_is_assist);
                } else if (c2 == 1) {
                    string = this.f39228e.getResources().getString(R.string.tbtitle_assist_applying);
                } else {
                    if (c2 == 2) {
                        string = this.f39228e.getResources().getString(R.string.tbtitle_assist_apply_failed);
                    }
                    z = false;
                }
                privateMgrApplyViewHolder.f14995c.setOnClickListener(this.x);
                privateMgrApplyViewHolder.f14994b.setText(string);
                privateMgrApplyViewHolder.f14995c.setTag(y, nVar.e());
                privateMgrApplyViewHolder.f14995c.setEnabled(z);
                privateMgrApplyViewHolder.f14995c.setClickable(z);
                privateMgrApplyViewHolder.f14994b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                privateMgrApplyViewHolder.f14998f = this.r;
            }
        }
        return view;
    }

    public final void x0(AccountData accountData) {
        d.a.c.a.f<?> a2 = d.a.c.a.j.a(this.f39228e);
        Activity pageActivity = a2 instanceof TbPageContext ? ((TbPageContext) a2).getPageActivity() : null;
        if (this.w == null) {
            this.w = new d.a.m0.s.i.b(pageActivity);
        }
        this.w.p();
        this.w.u(accountData);
        this.w.z(1);
    }
}
