package d.b.i0.z2.i;

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
import d.b.b.a.e;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tbclient.GetForumsFromForumClass.ForumSpaceForumInfo;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final Map<Long, Integer> f63520e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<SquareForumListActivity> f63521f;

    /* renamed from: g  reason: collision with root package name */
    public int f63522g;

    /* renamed from: h  reason: collision with root package name */
    public List<ForumSpaceForumInfo> f63523h;
    public LikeModel i;
    public View.OnClickListener j;

    /* renamed from: d.b.i0.z2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1721a extends e {
        public C1721a() {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            if (AntiHelper.m(a.this.i.getErrorCode(), a.this.i.getErrorString())) {
                AntiHelper.u(a.this.f63521f.getPageActivity(), a.this.i.getErrorString());
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
                    a.this.f63521f.showToast(R.string.neterror);
                } else if (ViewHelper.checkUpIsLogin(a.this.f63521f.getPageActivity())) {
                    String valueOf2 = view.getTag(R.id.forum_title) == null ? "" : String.valueOf(view.getTag(R.id.forum_title));
                    valueOf = view.getTag(R.id.forum_desc) != null ? String.valueOf(view.getTag(R.id.forum_desc)) : "";
                    a.this.i.H(valueOf2, valueOf);
                    if (a.this.f63522g != 1) {
                        if (a.this.f63522g == 2) {
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
                a.this.f63521f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f63521f.getContext()).createNormalCfg(valueOf3, null)));
                if (a.this.f63522g != 1) {
                    if (a.this.f63522g == 2) {
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
        public TextView f63526a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f63527b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63528c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63529d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63530e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f63531f;

        public c(a aVar) {
        }

        public /* synthetic */ c(a aVar, C1721a c1721a) {
            this(aVar);
        }
    }

    public a(TbPageContext<SquareForumListActivity> tbPageContext, int i) {
        this.f63521f = tbPageContext;
        this.f63522g = i;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.i = likeModel;
        likeModel.setLoadDataCallBack(new C1721a());
        this.j = new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public ForumSpaceForumInfo getItem(int i) {
        if (getCount() > 1 && i != 0) {
            return (ForumSpaceForumInfo) ListUtils.getItem(this.f63523h, i - 1);
        }
        return null;
    }

    public void e(List<ForumSpaceForumInfo> list) {
        this.f63523h = list;
        notifyDataSetChanged();
    }

    public void f(Long l, boolean z) {
        Integer valueOf;
        if (this.f63520e.containsKey(l)) {
            Integer num = this.f63520e.get(l);
            if (z) {
                valueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                valueOf = Integer.valueOf(num.intValue() - 1);
            }
            this.f63520e.put(l, valueOf);
        } else if (!this.f63520e.containsKey(l)) {
            this.f63520e.put(l, z ? 1 : -1);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.getCount(this.f63523h) > 0) {
            return ListUtils.getCount(this.f63523h) + 1;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i == 0) {
            if (view == null || !(view instanceof TbImageView)) {
                view = LayoutInflater.from(this.f63521f.getPageActivity()).inflate(R.layout.square_forum_list_header, (ViewGroup) null);
            }
            SkinManager.setImageResource((TbImageView) view, this.f63522g == 1 ? R.drawable.pic_batuijian_bg_red : R.drawable.pic_batuijian_bg_yellow);
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
            return view;
        }
        ForumSpaceForumInfo item = getItem(i);
        if (item == null) {
            return null;
        }
        if (view == null || !(view.getTag(R.id.forum_rank) instanceof c)) {
            view = LayoutInflater.from(this.f63521f.getPageActivity()).inflate(R.layout.square_forum_list_item, (ViewGroup) null);
            c cVar = new c(this, null);
            cVar.f63526a = (TextView) view.findViewById(R.id.forum_rank);
            cVar.f63527b = (BarImageView) view.findViewById(R.id.forum_image);
            cVar.f63531f = (TextView) view.findViewById(R.id.forum_like);
            cVar.f63528c = (TextView) view.findViewById(R.id.forum_title);
            cVar.f63529d = (TextView) view.findViewById(R.id.forum_desc);
            cVar.f63530e = (TextView) view.findViewById(R.id.forum_value);
            l.c(this.f63521f.getPageActivity(), cVar.f63531f, 20, 20, 20, 20);
            cVar.f63531f.setOnClickListener(this.j);
            view.setOnClickListener(this.j);
            view.setTag(R.id.forum_rank, cVar);
        }
        SkinManager.setBackgroundResource(view, R.drawable.square_list_item_bg_selector);
        c cVar2 = (c) view.getTag(R.id.forum_rank);
        if (i == 1) {
            cVar2.f63526a.setText("");
            SkinManager.setBackgroundResource(cVar2.f63526a, R.drawable.icon_grade_shaitu1);
        } else if (i == 2) {
            cVar2.f63526a.setText("");
            SkinManager.setBackgroundResource(cVar2.f63526a, R.drawable.icon_grade_shaitu2);
        } else if (i == 3) {
            cVar2.f63526a.setText("");
            SkinManager.setBackgroundResource(cVar2.f63526a, R.drawable.icon_grade_shaitu3);
        } else if (i < 10) {
            TextView textView = cVar2.f63526a;
            textView.setText("0" + i);
            cVar2.f63526a.setBackgroundResource(0);
        } else {
            TextView textView2 = cVar2.f63526a;
            textView2.setText("" + i);
            cVar2.f63526a.setBackgroundResource(0);
        }
        SkinManager.setViewTextColor(cVar2.f63526a, R.color.CAM_X0108);
        cVar2.f63527b.W(item.avatar, 10, false);
        cVar2.f63528c.setText(item.forum_name + this.f63521f.getString(R.string.forum));
        SkinManager.setViewTextColor(cVar2.f63528c, R.color.CAM_X0105);
        Integer num = this.f63520e.get(item.forum_id);
        int intValue = item.like_num.intValue() + (num == null ? 0 : num.intValue());
        cVar2.f63529d.setText(this.f63521f.getString(R.string.attention) + ":" + StringHelper.numberUniformFormat(intValue) + GlideException.IndentedAppendable.INDENT + this.f63521f.getString(R.string.text_post) + ":" + StringHelper.numberUniformFormat(item.post_num.intValue()));
        SkinManager.setViewTextColor(cVar2.f63529d, R.color.CAM_X0109);
        cVar2.f63530e.setText(item._abstract);
        SkinManager.setViewTextColor(cVar2.f63530e, R.color.CAM_X0109);
        cVar2.f63531f.setTag(R.id.forum_title, item.forum_name);
        cVar2.f63531f.setTag(R.id.forum_desc, item.forum_id);
        int intValue2 = this.f63520e.get(item.forum_id) == null ? 0 : this.f63520e.get(item.forum_id).intValue();
        if ((item.is_like.intValue() == 0 && intValue2 > 0) || (item.is_like.intValue() == 1 && intValue2 >= 0)) {
            cVar2.f63531f.setText(R.string.relate_forum_is_followed);
            cVar2.f63531f.setBackgroundResource(0);
            SkinManager.setViewTextColor(cVar2.f63531f, R.color.CAM_X0109);
        } else {
            cVar2.f63531f.setText(R.string.attention);
            cVar2.f63531f.setBackgroundResource(R.drawable.btn_blue_bg);
            SkinManager.setViewTextColor(cVar2.f63531f, R.color.CAM_X0101);
        }
        view.setTag(R.id.forum_title, item.forum_name);
        return view;
    }
}
