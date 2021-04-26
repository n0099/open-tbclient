package d.a.j0.a3.h;

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
    public TbPageContext f51270e;

    /* renamed from: g  reason: collision with root package name */
    public LikeModel f51272g;

    /* renamed from: i  reason: collision with root package name */
    public int f51274i;

    /* renamed from: f  reason: collision with root package name */
    public int f51271f = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f51273h = 0;
    public boolean j = true;
    public ForumDetailActivityConfig.FromType k = ForumDetailActivityConfig.FromType.BAR_DIR;
    public ForumInfoData[] l = new ForumInfoData[0];

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f51275a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f51276b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f51277c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f51278d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f51279e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f51280f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f51281g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f51282h;

        public a(b bVar) {
        }
    }

    public b(TbPageContext tbPageContext, int i2) {
        this.f51274i = 0;
        this.f51270e = tbPageContext;
        this.f51274i = i2;
    }

    public ForumInfoData[] a() {
        return this.l;
    }

    public String b(int i2) {
        if (i2 >= 100000) {
            return String.valueOf(i2 / 10000) + this.f51270e.getString(R.string.member_count_unit);
        }
        return String.valueOf(i2);
    }

    public boolean c() {
        LikeModel likeModel = this.f51272g;
        if (likeModel == null) {
            return false;
        }
        return likeModel.G();
    }

    public void d(boolean z) {
        notifyDataSetChanged();
    }

    public void e(int i2) {
        this.f51273h = i2;
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
        int i2 = this.f51273h;
        return i2 <= forumInfoDataArr.length ? i2 : forumInfoDataArr.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (i2 > this.f51273h) {
            return null;
        }
        return this.l[i2];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.f51270e.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a(this);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.f51275a = barImageView;
            barImageView.setGifIconSupport(false);
            aVar.f51278d = (TextView) view.findViewById(R.id.name);
            aVar.f51279e = (TextView) view.findViewById(R.id.member_count);
            aVar.f51280f = (TextView) view.findViewById(R.id.thread_count);
            aVar.f51281g = (TextView) view.findViewById(R.id.slogan);
            aVar.f51282h = (TextView) view.findViewById(R.id.like);
            aVar.f51276b = (TextView) view.findViewById(R.id.rank_badge);
            aVar.f51277c = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(aVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(findViewById2, R.color.CAM_X0204);
        if (i2 == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a aVar2 = (a) view.getTag();
        this.f51270e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f51270e.getLayoutMode().j(view);
        ForumInfoData[] forumInfoDataArr = this.l;
        ForumInfoData forumInfoData = forumInfoDataArr[i2];
        String str = forumInfoDataArr[i2].avatar;
        aVar2.f51275a.setTag(str);
        aVar2.f51275a.invalidate();
        aVar2.f51275a.V(str, 10, false);
        aVar2.f51278d.setText(forumInfoData.forum_name);
        aVar2.f51278d.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.f51282h.setTag(forumInfoData.forum_name);
        TextView textView = aVar2.f51279e;
        textView.setText(this.f51270e.getString(R.string.attention) + " " + b(forumInfoData.member_count));
        TextView textView2 = aVar2.f51280f;
        textView2.setText(this.f51270e.getString(R.string.text_post) + " " + b(forumInfoData.thread_count));
        aVar2.f51281g.setText(forumInfoData.slogan);
        if (this.f51274i == 0) {
            aVar2.f51277c.setVisibility(8);
            if (!this.j) {
                aVar2.f51276b.setVisibility(8);
            } else {
                aVar2.f51276b.setVisibility(0);
                aVar2.f51276b.setText((CharSequence) null);
                aVar2.f51276b.setBackgroundDrawable(null);
                if (i2 == 0) {
                    SkinManager.setBackgroundResource(aVar2.f51276b, R.drawable.icon_brief_grade_orange);
                } else if (i2 == 1) {
                    SkinManager.setBackgroundResource(aVar2.f51276b, R.drawable.icon_brief_grade_blue);
                } else if (i2 != 2) {
                    aVar2.f51276b.setText(String.format("%02d", Integer.valueOf(i2 + 1)));
                } else {
                    SkinManager.setBackgroundResource(aVar2.f51276b, R.drawable.icon_brief_grade_green);
                }
            }
        } else {
            aVar2.f51276b.setVisibility(8);
            aVar2.f51277c.setVisibility(0);
            aVar2.f51277c.setText((CharSequence) null);
            aVar2.f51277c.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            TextView textView3 = aVar2.f51277c;
            textView3.setText(this.f51270e.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.f51270e.getString(R.string.number));
        }
        aVar2.f51282h.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    public void h(Boolean bool) {
        this.j = bool.booleanValue();
    }

    public void i(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return;
        }
        notifyDataSetChanged();
    }

    public void j(LikeModel likeModel) {
        this.f51272g = likeModel;
    }

    public void k() {
        for (int i2 = 0; i2 < this.f51273h; i2++) {
            int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(this.l[i2].forum_name);
            if (hasLikeForum == 1) {
                this.l[i2].is_like = 1;
            } else if (hasLikeForum == -1) {
                this.l[i2].is_like = 0;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.like) {
            TiebaStatic.eventStat(this.f51270e.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.f51270e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f51270e.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f51270e.getPageActivity(), String.valueOf(aVar.f51278d.getTag()), this.k)));
            return;
        }
        TiebaStatic.eventStat(this.f51270e.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.f51270e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f51270e.getPageActivity()).createNormalCfg(aVar.f51278d.getText().toString(), null)));
    }
}
