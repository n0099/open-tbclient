package d.b.i0.z2.h;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes5.dex */
public class b extends BaseAdapter implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f63497e;

    /* renamed from: g  reason: collision with root package name */
    public LikeModel f63499g;
    public int i;

    /* renamed from: f  reason: collision with root package name */
    public int f63498f = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f63500h = 0;
    public boolean j = true;
    public ForumDetailActivityConfig.FromType k = ForumDetailActivityConfig.FromType.BAR_DIR;
    public ForumInfoData[] l = new ForumInfoData[0];

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f63501a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63502b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63503c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63504d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63505e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f63506f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f63507g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f63508h;

        public a(b bVar) {
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        this.i = 0;
        this.f63497e = tbPageContext;
        this.i = i;
    }

    public ForumInfoData[] a() {
        return this.l;
    }

    public String b(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.f63497e.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public boolean c() {
        LikeModel likeModel = this.f63499g;
        if (likeModel == null) {
            return false;
        }
        return likeModel.G();
    }

    public void d(boolean z) {
        notifyDataSetChanged();
    }

    public void e(int i) {
        this.f63500h = i;
        notifyDataSetChanged();
    }

    public void f(ForumInfoData[] forumInfoDataArr) {
        this.l = forumInfoDataArr;
        if (forumInfoDataArr != null) {
            notifyDataSetChanged();
        }
    }

    public void g(ForumDetailActivityConfig.FromType fromType) {
        this.k = fromType;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ForumInfoData[] forumInfoDataArr = this.l;
        if (forumInfoDataArr == null) {
            return 0;
        }
        int i = this.f63500h;
        return i <= forumInfoDataArr.length ? i : forumInfoDataArr.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.f63500h) {
            return null;
        }
        return this.l[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.f63497e.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a(this);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.f63501a = barImageView;
            barImageView.setGifIconSupport(false);
            aVar.f63504d = (TextView) view.findViewById(R.id.name);
            aVar.f63505e = (TextView) view.findViewById(R.id.member_count);
            aVar.f63506f = (TextView) view.findViewById(R.id.thread_count);
            aVar.f63507g = (TextView) view.findViewById(R.id.slogan);
            aVar.f63508h = (TextView) view.findViewById(R.id.like);
            aVar.f63502b = (TextView) view.findViewById(R.id.rank_badge);
            aVar.f63503c = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(findViewById2, R.color.CAM_X0204);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.f63497e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f63497e.getLayoutMode().j(view);
        ForumInfoData[] forumInfoDataArr = this.l;
        ForumInfoData forumInfoData = forumInfoDataArr[i];
        String str = forumInfoDataArr[i].avatar;
        aVar2.f63501a.setTag(str);
        aVar2.f63501a.invalidate();
        aVar2.f63501a.W(str, 10, false);
        aVar2.f63504d.setText(forumInfoData.forum_name);
        aVar2.f63504d.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.f63508h.setTag(forumInfoData.forum_name);
        TextView textView = aVar2.f63505e;
        textView.setText(this.f63497e.getString(R.string.attention) + " " + b(forumInfoData.member_count));
        TextView textView2 = aVar2.f63506f;
        textView2.setText(this.f63497e.getString(R.string.text_post) + " " + b(forumInfoData.thread_count));
        aVar2.f63507g.setText(forumInfoData.slogan);
        if (this.i == 0) {
            aVar2.f63503c.setVisibility(8);
            if (!this.j) {
                aVar2.f63502b.setVisibility(8);
            } else {
                aVar2.f63502b.setVisibility(0);
                aVar2.f63502b.setText((CharSequence) null);
                aVar2.f63502b.setBackgroundDrawable(null);
                if (i == 0) {
                    SkinManager.setBackgroundResource(aVar2.f63502b, R.drawable.icon_brief_grade_orange);
                } else if (i == 1) {
                    SkinManager.setBackgroundResource(aVar2.f63502b, R.drawable.icon_brief_grade_blue);
                } else if (i != 2) {
                    aVar2.f63502b.setText(String.format("%02d", Integer.valueOf(i + 1)));
                } else {
                    SkinManager.setBackgroundResource(aVar2.f63502b, R.drawable.icon_brief_grade_green);
                }
            }
        } else {
            aVar2.f63502b.setVisibility(8);
            aVar2.f63503c.setVisibility(0);
            aVar2.f63503c.setText((CharSequence) null);
            aVar2.f63503c.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            TextView textView3 = aVar2.f63503c;
            textView3.setText(this.f63497e.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.f63497e.getString(R.string.number));
        }
        aVar2.f63508h.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    public void h(Boolean bool) {
        this.j = bool.booleanValue();
    }

    public void i(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        notifyDataSetChanged();
    }

    public void j(LikeModel likeModel) {
        this.f63499g = likeModel;
    }

    public void k() {
        for (int i = 0; i < this.f63500h; i++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.l[i].forum_name);
            if (hasLikeForum == 1) {
                this.l[i].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.l[i].is_like = 0;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.f63497e.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.f63497e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f63497e.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f63497e.getPageActivity(), String.valueOf(aVar.f63504d.getTag()), this.k)));
            return;
        }
        TiebaStatic.eventStat(this.f63497e.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.f63497e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f63497e.getPageActivity()).createNormalCfg(aVar.f63504d.getText().toString(), null)));
    }
}
