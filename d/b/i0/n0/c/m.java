package d.b.i0.n0.c;

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
public class m extends d.b.i0.p0.k<n, PrivateMgrApplyViewHolder> {
    public static final int y = R.id.private_apply_tip;
    public d.b.h0.s.i.b w;
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
                UrlManager.getInstance().dealOneLink((TbPageContext) d.b.b.a.j.a(m.this.f42358e), new String[]{tag.toString()});
                return;
            }
            m.this.y0(TbadkCoreApplication.getCurrentAccountInfo());
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.x = new a();
    }

    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        x0(i, view, viewGroup, (n) obj, (PrivateMgrApplyViewHolder) viewHolder);
        return view;
    }

    public void onDestroy() {
        d.b.h0.s.i.b bVar = this.w;
        if (bVar != null) {
            bVar.s();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: w0 */
    public PrivateMgrApplyViewHolder R(ViewGroup viewGroup) {
        return new PrivateMgrApplyViewHolder(LayoutInflater.from(this.f42358e).inflate(R.layout.private_member_apply, (ViewGroup) null));
    }

    public View x0(int i, View view, ViewGroup viewGroup, n nVar, PrivateMgrApplyViewHolder privateMgrApplyViewHolder) {
        super.X(i, view, viewGroup, nVar, privateMgrApplyViewHolder);
        if (nVar != null && !nVar.g() && privateMgrApplyViewHolder != null) {
            if (nVar.g()) {
                privateMgrApplyViewHolder.f15946e.setVisibility(8);
                return view;
            }
            boolean z = true;
            if (privateMgrApplyViewHolder.f15947f != this.r) {
                SkinManager.setBackgroundColor(privateMgrApplyViewHolder.f15945d, R.color.CAM_X0204);
                SkinManager.setViewTextColor(privateMgrApplyViewHolder.f15943b, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(privateMgrApplyViewHolder.f15942a, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(privateMgrApplyViewHolder.f15944c, R.drawable.frs_member_manito_bg);
            }
            int a2 = nVar.a();
            String string = this.f42358e.getResources().getString(R.string.tbtitle_quota_is_full);
            if (a2 == -1) {
                int f2 = nVar.f();
                String numberUniformFormat = StringHelper.numberUniformFormat(f2);
                if (f2 > 0) {
                    string = String.format(this.f42358e.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                    privateMgrApplyViewHolder.f15944c.setOnClickListener(this.x);
                    privateMgrApplyViewHolder.f15943b.setText(string);
                    privateMgrApplyViewHolder.f15944c.setTag(y, nVar.e());
                    privateMgrApplyViewHolder.f15944c.setEnabled(z);
                    privateMgrApplyViewHolder.f15944c.setClickable(z);
                    privateMgrApplyViewHolder.f15943b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f15947f = this.r;
                }
                z = false;
                privateMgrApplyViewHolder.f15944c.setOnClickListener(this.x);
                privateMgrApplyViewHolder.f15943b.setText(string);
                privateMgrApplyViewHolder.f15944c.setTag(y, nVar.e());
                privateMgrApplyViewHolder.f15944c.setEnabled(z);
                privateMgrApplyViewHolder.f15944c.setClickable(z);
                privateMgrApplyViewHolder.f15943b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                privateMgrApplyViewHolder.f15947f = this.r;
            } else {
                if (a2 == 0) {
                    string = this.f42358e.getResources().getString(R.string.tbtitle_is_assist);
                } else if (a2 == 1) {
                    string = this.f42358e.getResources().getString(R.string.tbtitle_assist_applying);
                } else {
                    if (a2 == 2) {
                        string = this.f42358e.getResources().getString(R.string.tbtitle_assist_apply_failed);
                    }
                    z = false;
                }
                privateMgrApplyViewHolder.f15944c.setOnClickListener(this.x);
                privateMgrApplyViewHolder.f15943b.setText(string);
                privateMgrApplyViewHolder.f15944c.setTag(y, nVar.e());
                privateMgrApplyViewHolder.f15944c.setEnabled(z);
                privateMgrApplyViewHolder.f15944c.setClickable(z);
                privateMgrApplyViewHolder.f15943b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                privateMgrApplyViewHolder.f15947f = this.r;
            }
        }
        return view;
    }

    public final void y0(AccountData accountData) {
        d.b.b.a.f<?> a2 = d.b.b.a.j.a(this.f42358e);
        Activity pageActivity = a2 instanceof TbPageContext ? ((TbPageContext) a2).getPageActivity() : null;
        if (this.w == null) {
            this.w = new d.b.h0.s.i.b(pageActivity);
        }
        this.w.p();
        this.w.u(accountData);
        this.w.z(1);
    }
}
