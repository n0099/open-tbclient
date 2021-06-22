package d.a.o0.b3.h;

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
    public TbPageContext f55950e;

    /* renamed from: g  reason: collision with root package name */
    public LikeModel f55952g;

    /* renamed from: i  reason: collision with root package name */
    public int f55954i;

    /* renamed from: f  reason: collision with root package name */
    public int f55951f = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f55953h = 0;
    public boolean j = true;
    public ForumDetailActivityConfig.FromType k = ForumDetailActivityConfig.FromType.BAR_DIR;
    public ForumInfoData[] l = new ForumInfoData[0];

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f55955a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f55956b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f55957c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f55958d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f55959e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f55960f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f55961g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f55962h;

        public a(b bVar) {
        }
    }

    public b(TbPageContext tbPageContext, int i2) {
        this.f55954i = 0;
        this.f55950e = tbPageContext;
        this.f55954i = i2;
    }

    public ForumInfoData[] a() {
        return this.l;
    }

    public String b(int i2) {
        if (i2 >= 100000) {
            return String.valueOf(i2 / 10000) + this.f55950e.getString(R.string.member_count_unit);
        }
        return String.valueOf(i2);
    }

    public boolean c() {
        LikeModel likeModel = this.f55952g;
        if (likeModel == null) {
            return false;
        }
        return likeModel.K();
    }

    public void d(boolean z) {
        notifyDataSetChanged();
    }

    public void e(int i2) {
        this.f55953h = i2;
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
        int i2 = this.f55953h;
        return i2 <= forumInfoDataArr.length ? i2 : forumInfoDataArr.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (i2 > this.f55953h) {
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
            view = View.inflate(this.f55950e.getContext(), R.layout.forum_list_forum_item, null);
            a aVar = new a(this);
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            aVar.f55955a = barImageView;
            barImageView.setGifIconSupport(false);
            aVar.f55958d = (TextView) view.findViewById(R.id.name);
            aVar.f55959e = (TextView) view.findViewById(R.id.member_count);
            aVar.f55960f = (TextView) view.findViewById(R.id.thread_count);
            aVar.f55961g = (TextView) view.findViewById(R.id.slogan);
            aVar.f55962h = (TextView) view.findViewById(R.id.like);
            aVar.f55956b = (TextView) view.findViewById(R.id.rank_badge);
            aVar.f55957c = (TextView) view.findViewById(R.id.rise_no);
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
        this.f55950e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f55950e.getLayoutMode().j(view);
        ForumInfoData[] forumInfoDataArr = this.l;
        ForumInfoData forumInfoData = forumInfoDataArr[i2];
        String str = forumInfoDataArr[i2].avatar;
        aVar2.f55955a.setTag(str);
        aVar2.f55955a.invalidate();
        aVar2.f55955a.U(str, 10, false);
        aVar2.f55958d.setText(forumInfoData.forum_name);
        aVar2.f55958d.setTag(Integer.valueOf(forumInfoData.forum_id));
        aVar2.f55962h.setTag(forumInfoData.forum_name);
        TextView textView = aVar2.f55959e;
        textView.setText(this.f55950e.getString(R.string.attention) + " " + b(forumInfoData.member_count));
        TextView textView2 = aVar2.f55960f;
        textView2.setText(this.f55950e.getString(R.string.text_post) + " " + b(forumInfoData.thread_count));
        aVar2.f55961g.setText(forumInfoData.slogan);
        if (this.f55954i == 0) {
            aVar2.f55957c.setVisibility(8);
            if (!this.j) {
                aVar2.f55956b.setVisibility(8);
            } else {
                aVar2.f55956b.setVisibility(0);
                aVar2.f55956b.setText((CharSequence) null);
                aVar2.f55956b.setBackgroundDrawable(null);
                if (i2 == 0) {
                    SkinManager.setBackgroundResource(aVar2.f55956b, R.drawable.icon_brief_grade_orange);
                } else if (i2 == 1) {
                    SkinManager.setBackgroundResource(aVar2.f55956b, R.drawable.icon_brief_grade_blue);
                } else if (i2 != 2) {
                    aVar2.f55956b.setText(String.format("%02d", Integer.valueOf(i2 + 1)));
                } else {
                    SkinManager.setBackgroundResource(aVar2.f55956b, R.drawable.icon_brief_grade_green);
                }
            }
        } else {
            aVar2.f55956b.setVisibility(8);
            aVar2.f55957c.setVisibility(0);
            aVar2.f55957c.setText((CharSequence) null);
            aVar2.f55957c.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            TextView textView3 = aVar2.f55957c;
            textView3.setText(this.f55950e.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.f55950e.getString(R.string.number));
        }
        aVar2.f55962h.setOnClickListener(this);
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
        this.f55952g = likeModel;
    }

    public void k() {
        for (int i2 = 0; i2 < this.f55953h; i2++) {
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
            TiebaStatic.eventStat(this.f55950e.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.f55950e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f55950e.getPageActivity()).createNormalCfg((String) view.getTag(), null).setCallFrom(5)));
            return;
        }
        a aVar = (a) view.getTag();
        if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class) && SwitchManager.getInstance().findType(BarDetailForDirSwitch.BAR_DETAIL_DIR) == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f55950e.getPageActivity(), String.valueOf(aVar.f55958d.getTag()), this.k)));
            return;
        }
        TiebaStatic.eventStat(this.f55950e.getContext(), "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.f55950e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f55950e.getPageActivity()).createNormalCfg(aVar.f55958d.getText().toString(), null)));
    }
}
