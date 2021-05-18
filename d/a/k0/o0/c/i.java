package d.a.k0.o0.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivityConfig;
import com.baidu.tieba.forumMember.member.FrsMemberTeamViewHolder;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.MemberGroupInfo;
/* loaded from: classes4.dex */
public class i extends d.a.k0.q0.k<j, FrsMemberTeamViewHolder> {
    public View.OnClickListener w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            String str = "";
            if (view.getTag() instanceof BawuRoleInfoPub) {
                BawuRoleInfoPub bawuRoleInfoPub = (BawuRoleInfoPub) view.getTag();
                i.this.o.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(i.this.f39564e, "" + bawuRoleInfoPub.user_id, bawuRoleInfoPub.user_name)));
            } else if (view.getId() == R.id.title_text_view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    Integer num = (Integer) tag;
                    if (i.this.y(num.intValue()) instanceof j) {
                        jVar = (j) i.this.y(num.intValue());
                        if (jVar != null || jVar.e() == null) {
                        }
                        String[] split = StringUtils.isNull(jVar.e().member_group_type) ? null : jVar.e().member_group_type.split("_");
                        if (split != null && split.length == 2) {
                            str = split[0];
                        }
                        if (StringUtils.isNull(str) || !str.equalsIgnoreCase("1")) {
                            return;
                        }
                        i.this.o.sendMessage(new CustomMessage(2002001, new BawuTeamInfoActivityConfig(i.this.f39564e, d.a.c.e.m.b.f(jVar.c(), 0L))));
                        return;
                    }
                }
                jVar = null;
                if (jVar != null) {
                }
            }
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.w = new a();
    }

    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        x0(i2, view, viewGroup, (j) obj, (FrsMemberTeamViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: w0 */
    public FrsMemberTeamViewHolder P(ViewGroup viewGroup) {
        return new FrsMemberTeamViewHolder(LayoutInflater.from(this.f39564e).inflate(R.layout.forum_member_team_user_view, (ViewGroup) null), this.w);
    }

    public View x0(int i2, View view, ViewGroup viewGroup, j jVar, FrsMemberTeamViewHolder frsMemberTeamViewHolder) {
        MemberGroupInfo e2;
        List<BawuRoleInfoPub> list;
        super.W(i2, view, viewGroup, jVar, frsMemberTeamViewHolder);
        if (jVar != null && jVar.e() != null && (list = (e2 = jVar.e()).member_group_list) != null && list.size() > 0 && !StringUtils.isNull(e2.member_group_type)) {
            frsMemberTeamViewHolder.f15076a.setTag(Integer.valueOf(i2));
            String[] split = !StringUtils.isNull(e2.member_group_type) ? e2.member_group_type.split("_") : null;
            String str = (split == null || split.length != 2) ? "" : split[1];
            TextView textView = frsMemberTeamViewHolder.f15076a;
            textView.setText(str + "(" + e2.member_group_num + SmallTailInfo.EMOTION_SUFFIX);
            int i3 = 0;
            for (BawuRoleInfoPub bawuRoleInfoPub : e2.member_group_list) {
                if (i3 > 3) {
                    break;
                } else if (bawuRoleInfoPub != null) {
                    frsMemberTeamViewHolder.b(bawuRoleInfoPub, i3);
                    i3++;
                }
            }
            frsMemberTeamViewHolder.c(this.r == 1);
            SkinManager.setBackgroundColor(frsMemberTeamViewHolder.n, R.color.CAM_X0201);
            SkinManager.setViewTextColor(frsMemberTeamViewHolder.f15076a, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(frsMemberTeamViewHolder.j, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(frsMemberTeamViewHolder.k, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(frsMemberTeamViewHolder.l, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(frsMemberTeamViewHolder.m, R.color.CAM_X0106, 1);
            frsMemberTeamViewHolder.f15076a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
        }
        return view;
    }
}
