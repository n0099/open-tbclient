package d.a.n0.b3.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.forumlist.SquareForumListActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.bumptech.glide.load.engine.GlideException;
import d.a.c.a.e;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tbclient.GetForumsFromForumClass.ForumSpaceForumInfo;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final Map<Long, Integer> f52161e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<SquareForumListActivity> f52162f;

    /* renamed from: g  reason: collision with root package name */
    public int f52163g;

    /* renamed from: h  reason: collision with root package name */
    public List<ForumSpaceForumInfo> f52164h;

    /* renamed from: i  reason: collision with root package name */
    public LikeModel f52165i;
    public View.OnClickListener j;

    /* renamed from: d.a.n0.b3.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1224a extends e {
        public C1224a() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (AntiHelper.m(a.this.f52165i.getErrorCode(), a.this.f52165i.getErrorString())) {
                AntiHelper.u(a.this.f52162f.getPageActivity(), a.this.f52165i.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String valueOf;
            if (view.getId() == R.id.forum_like) {
                if (!j.z()) {
                    a.this.f52162f.showToast(R.string.neterror);
                } else if (ViewHelper.checkUpIsLogin(a.this.f52162f.getPageActivity())) {
                    String valueOf2 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    valueOf = view.getTag(R.id.forum_desc) != null ? String.valueOf(view.getTag(R.id.forum_desc)) : "";
                    a.this.f52165i.H(valueOf2, valueOf);
                    if (a.this.f52163g != 1) {
                        if (a.this.f52163g == 2) {
                            TiebaStatic.log(new StatisticItem("c10587").param("fid", valueOf));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c10566").param("fid", valueOf));
                }
            } else if (view.getId() != R.id.square_forum_list_image) {
                String valueOf3 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                valueOf = view.getTag(R.id.forum_desc) != null ? String.valueOf(view.getTag(R.id.forum_desc)) : "";
                a.this.f52162f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f52162f.getContext()).createNormalCfg(valueOf3, null)));
                if (a.this.f52163g != 1) {
                    if (a.this.f52163g == 2) {
                        TiebaStatic.log(new StatisticItem("c10586").param("obj_type", 1).param("fid", valueOf));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem("c10565").param("obj_type", 1).param("fid", valueOf));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f52168a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f52169b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f52170c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f52171d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f52172e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f52173f;

        public c(a aVar) {
        }

        public /* synthetic */ c(a aVar, C1224a c1224a) {
            this(aVar);
        }
    }

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i2) {
        this.f52162f = tbPageContext;
        this.f52163g = i2;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f52165i = likeModel;
        likeModel.setLoadDataCallBack(new C1224a());
        this.j = new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public ForumSpaceForumInfo getItem(int i2) {
        if (getCount() > 1 && i2 != 0) {
            return (ForumSpaceForumInfo) ListUtils.getItem(this.f52164h, i2 - 1);
        }
        return null;
    }

    public void e(List<ForumSpaceForumInfo> list) {
        this.f52164h = list;
        notifyDataSetChanged();
    }

    public void f(Long l, boolean z) {
        Integer valueOf;
        if (this.f52161e.containsKey(l)) {
            Integer num = this.f52161e.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.f52161e.put(l, valueOf);
        } else if (!this.f52161e.containsKey(l)) {
            this.f52161e.put(l, z ? 1 : -1);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.getCount(this.f52164h) > 0) {
            return ListUtils.getCount(this.f52164h) + 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (i2 == 0) {
            if (view == null || !(view instanceof TbImageView)) {
                view = LayoutInflater.from(this.f52162f.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null);
            }
            SkinManager.setImageResource((TbImageView) view, this.f52163g == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
            return view;
        }
        ForumSpaceForumInfo item = getItem(i2);
        if (item == null) {
            return null;
        }
        if (view == null || !(view.getTag(R.id.forum_rank) instanceof c)) {
            view = LayoutInflater.from(this.f52162f.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
            c cVar = new c(this, null);
            cVar.f52168a = (TextView) view.findViewById(R.id.forum_rank);
            cVar.f52169b = (BarImageView) view.findViewById(R.id.forum_image);
            cVar.f52173f = (TextView) view.findViewById(R.id.forum_like);
            cVar.f52170c = (TextView) view.findViewById(R.id.forum_title);
            cVar.f52171d = (TextView) view.findViewById(R.id.forum_desc);
            cVar.f52172e = (TextView) view.findViewById(R.id.forum_value);
            l.c(this.f52162f.getPageActivity(), cVar.f52173f, 20, 20, 20, 20);
            cVar.f52173f.setOnClickListener(this.j);
            view.setOnClickListener(this.j);
            view.setTag(R.id.forum_rank, cVar);
        }
        SkinManager.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
        c cVar2 = (c) view.getTag(R.id.forum_rank);
        if (i2 == 1) {
            cVar2.f52168a.setText("");
            SkinManager.setBackgroundResource(cVar2.f52168a, R.drawable.icon_grade_shaitu1);
        } else if (i2 == 2) {
            cVar2.f52168a.setText("");
            SkinManager.setBackgroundResource(cVar2.f52168a, R.drawable.icon_grade_shaitu2);
        } else if (i2 == 3) {
            cVar2.f52168a.setText("");
            SkinManager.setBackgroundResource(cVar2.f52168a, R.drawable.icon_grade_shaitu3);
        } else if (i2 < 10) {
            TextView textView = cVar2.f52168a;
            textView.setText("0" + i2);
            cVar2.f52168a.setBackgroundResource(0);
        } else {
            TextView textView2 = cVar2.f52168a;
            textView2.setText("" + i2);
            cVar2.f52168a.setBackgroundResource(0);
        }
        SkinManager.setViewTextColor(cVar2.f52168a, R.color.CAM_X0108);
        cVar2.f52169b.V(item.avatar, 10, false);
        cVar2.f52170c.setText(item.forum_name + this.f52162f.getString(R.string.forum));
        SkinManager.setViewTextColor(cVar2.f52170c, R.color.CAM_X0105);
        Integer num = this.f52161e.get(item.forum_id);
        int intValue = item.like_num.intValue() + (num == null ? 0 : num.intValue());
        cVar2.f52171d.setText(this.f52162f.getString(R.string.attention) + ":" + StringHelper.numberUniformFormat(intValue) + GlideException.IndentedAppendable.INDENT + this.f52162f.getString(R.string.text_post) + ":" + StringHelper.numberUniformFormat(item.post_num.intValue()));
        SkinManager.setViewTextColor(cVar2.f52171d, R.color.CAM_X0109);
        cVar2.f52172e.setText(item._abstract);
        SkinManager.setViewTextColor(cVar2.f52172e, R.color.CAM_X0109);
        cVar2.f52173f.setTag(R.id.forum_title, item.forum_name);
        cVar2.f52173f.setTag(R.id.forum_desc, item.forum_id);
        int intValue2 = this.f52161e.get(item.forum_id) == null ? 0 : this.f52161e.get(item.forum_id).intValue();
        if ((item.is_like.intValue() == 0 && intValue2 > 0) || (item.is_like.intValue() == 1 && intValue2 >= 0)) {
            cVar2.f52173f.setText(R.string.relate_forum_is_followed);
            cVar2.f52173f.setBackgroundResource(0);
            SkinManager.setViewTextColor(cVar2.f52173f, R.color.CAM_X0109);
        } else {
            cVar2.f52173f.setText(R.string.attention);
            cVar2.f52173f.setBackgroundResource(R.drawable.btn_blue_bg);
            SkinManager.setViewTextColor(cVar2.f52173f, R.color.CAM_X0101);
        }
        view.setTag(R.id.forum_title, item.forum_name);
        return view;
    }
}
