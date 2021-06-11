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
                UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(m.this.f42909e), new String[]{tag.toString()});
                return;
            }
            m.this.y0(TbadkCoreApplication.getCurrentAccountInfo());
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.x = new a();
    }

    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        x0(i2, view, viewGroup, (n) obj, (PrivateMgrApplyViewHolder) viewHolder);
        return view;
    }

    public void onDestroy() {
        d.a.m0.s.i.b bVar = this.w;
        if (bVar != null) {
            bVar.s();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: w0 */
    public PrivateMgrApplyViewHolder Q(ViewGroup viewGroup) {
        return new PrivateMgrApplyViewHolder(LayoutInflater.from(this.f42909e).inflate(R.layout.private_member_apply, (ViewGroup) null));
    }

    public View x0(int i2, View view, ViewGroup viewGroup, n nVar, PrivateMgrApplyViewHolder privateMgrApplyViewHolder) {
        super.X(i2, view, viewGroup, nVar, privateMgrApplyViewHolder);
        if (nVar != null && !nVar.g() && privateMgrApplyViewHolder != null) {
            if (nVar.g()) {
                privateMgrApplyViewHolder.f15054e.setVisibility(8);
                return view;
            }
            boolean z = true;
            if (privateMgrApplyViewHolder.f15055f != this.r) {
                SkinManager.setBackgroundColor(privateMgrApplyViewHolder.f15053d, R.color.CAM_X0204);
                SkinManager.setViewTextColor(privateMgrApplyViewHolder.f15051b, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(privateMgrApplyViewHolder.f15050a, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(privateMgrApplyViewHolder.f15052c, R.drawable.frs_member_manito_bg);
            }
            int b2 = nVar.b();
            String string = this.f42909e.getResources().getString(R.string.tbtitle_quota_is_full);
            if (b2 == -1) {
                int e2 = nVar.e();
                String numberUniformFormat = StringHelper.numberUniformFormat(e2);
                if (e2 > 0) {
                    string = String.format(this.f42909e.getResources().getString(R.string.tbtitle_apply_assist_left_num_tip), numberUniformFormat);
                    privateMgrApplyViewHolder.f15052c.setOnClickListener(this.x);
                    privateMgrApplyViewHolder.f15051b.setText(string);
                    privateMgrApplyViewHolder.f15052c.setTag(y, nVar.c());
                    privateMgrApplyViewHolder.f15052c.setEnabled(z);
                    privateMgrApplyViewHolder.f15052c.setClickable(z);
                    privateMgrApplyViewHolder.f15051b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f15055f = this.r;
                }
                z = false;
                privateMgrApplyViewHolder.f15052c.setOnClickListener(this.x);
                privateMgrApplyViewHolder.f15051b.setText(string);
                privateMgrApplyViewHolder.f15052c.setTag(y, nVar.c());
                privateMgrApplyViewHolder.f15052c.setEnabled(z);
                privateMgrApplyViewHolder.f15052c.setClickable(z);
                privateMgrApplyViewHolder.f15051b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                privateMgrApplyViewHolder.f15055f = this.r;
            } else {
                if (b2 == 0) {
                    string = this.f42909e.getResources().getString(R.string.tbtitle_is_assist);
                } else if (b2 == 1) {
                    string = this.f42909e.getResources().getString(R.string.tbtitle_assist_applying);
                } else {
                    if (b2 == 2) {
                        string = this.f42909e.getResources().getString(R.string.tbtitle_assist_apply_failed);
                    }
                    z = false;
                }
                privateMgrApplyViewHolder.f15052c.setOnClickListener(this.x);
                privateMgrApplyViewHolder.f15051b.setText(string);
                privateMgrApplyViewHolder.f15052c.setTag(y, nVar.c());
                privateMgrApplyViewHolder.f15052c.setEnabled(z);
                privateMgrApplyViewHolder.f15052c.setClickable(z);
                privateMgrApplyViewHolder.f15051b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                privateMgrApplyViewHolder.f15055f = this.r;
            }
        }
        return view;
    }

    public final void y0(AccountData accountData) {
        d.a.c.a.f<?> a2 = d.a.c.a.j.a(this.f42909e);
        Activity pageActivity = a2 instanceof TbPageContext ? ((TbPageContext) a2).getPageActivity() : null;
        if (this.w == null) {
            this.w = new d.a.m0.s.i.b(pageActivity);
        }
        this.w.p();
        this.w.u(accountData);
        this.w.z(1);
    }
}
