package d.a.n0.p1.h;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import d.a.c.a.e;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final Context f61764e;

    /* renamed from: g  reason: collision with root package name */
    public List<ForumInfo> f61766g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f61767h;

    /* renamed from: i  reason: collision with root package name */
    public String f61768i;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f61765f = true;
    public LikeModel j = new LikeModel(null);

    /* renamed from: d.a.n0.p1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1521a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumInfo f61769e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f61770f;

        /* renamed from: d.a.n0.p1.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1522a extends e {
            public C1522a() {
            }

            @Override // d.a.c.a.e
            public void c(Object obj) {
                if (a.this.j.getErrorCode() != 0) {
                    l.L(a.this.f61764e, R.string.attention_fail);
                    return;
                }
                View$OnClickListenerC1521a.this.f61770f.f61777e.setText(R.string.followed);
                l.L(a.this.f61764e, R.string.attention_success);
                View$OnClickListenerC1521a.this.f61770f.f61777e.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(View$OnClickListenerC1521a.this.f61770f.f61777e, R.color.CAM_X0109);
                View$OnClickListenerC1521a.this.f61770f.f61777e.setOnClickListener(null);
            }
        }

        public View$OnClickListenerC1521a(ForumInfo forumInfo, b bVar) {
            this.f61769e = forumInfo;
            this.f61770f = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTER_FORUM_SUG_SHOW).param("obj_type", "3").param("fid", this.f61769e.forum_id.intValue()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            LikeModel likeModel = a.this.j;
            ForumInfo forumInfo = this.f61769e;
            likeModel.L(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
            a.this.j.setLoadDataCallBack(new C1522a());
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61773a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f61774b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61775c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61776d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61777e;

        public b(a aVar) {
        }

        public /* synthetic */ b(a aVar, View$OnClickListenerC1521a view$OnClickListenerC1521a) {
            this(aVar);
        }
    }

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.f61764e = context;
        this.f61766g = arrayList;
    }

    public void c(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f61768i)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f61768i.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f61768i.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void d(List<ForumInfo> list) {
        this.f61766g = list;
        this.f61767h = new ArrayList<>();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f61766g.size()) {
                break;
            } else if (this.f61766g.get(i3).has_concerned.intValue() == 0) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        this.f61767h.addAll(this.f61766g);
        if (i2 > 0) {
            this.f61767h.add(i2, "divider");
        }
        if (this.f61766g != null) {
            notifyDataSetChanged();
        }
    }

    public void e(String str) {
        this.f61768i = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f61767h == null || TextUtils.isEmpty(this.f61768i)) {
            return 0;
        }
        return this.f61767h.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        int count = getCount();
        if (count <= 0 || i2 >= count) {
            return null;
        }
        return this.f61767h.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        String str;
        Object item = getItem(i2);
        if (item instanceof ForumInfo) {
            ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.f61764e).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                bVar = new b(this, null);
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                bVar.f61774b = barImageView;
                barImageView.setGifIconSupport(false);
                bVar.f61773a = (TextView) view.findViewById(R.id.name);
                bVar.f61775c = (TextView) view.findViewById(R.id.forum_member_count);
                bVar.f61776d = (TextView) view.findViewById(R.id.forum_thread_count);
                bVar.f61777e = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (forumInfo == null) {
                return view;
            }
            String str2 = forumInfo.avatar;
            bVar.f61774b.setTag(str2);
            bVar.f61774b.U(str2, 15, false);
            bVar.f61774b.invalidate();
            if (this.f61765f) {
                str = this.f61764e.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
            } else {
                str = forumInfo.forum_name;
            }
            c(bVar.f61773a, str);
            bVar.f61774b.setTag(forumInfo.avatar);
            TextView textView = bVar.f61775c;
            textView.setText(this.f61764e.getString(R.string.attention) + " " + forumInfo.concern_num);
            TextView textView2 = bVar.f61776d;
            textView2.setText(this.f61764e.getString(R.string.text_post) + " " + forumInfo.post_num);
            SkinManager.setViewTextColor(bVar.f61775c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(bVar.f61776d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(bVar.f61773a, R.color.CAM_X0105);
            if (forumInfo.has_concerned.intValue() > 0) {
                bVar.f61777e.setText(R.string.followed);
                SkinManager.setBackgroundResource(bVar.f61777e, 0);
                SkinManager.setViewTextColor(bVar.f61777e, R.color.CAM_X0109);
                bVar.f61777e.setOnClickListener(null);
                return view;
            }
            bVar.f61777e.setText(R.string.attention);
            SkinManager.setBackgroundResource(bVar.f61777e, R.drawable.search_like_btn_bg);
            SkinManager.setViewTextColor(bVar.f61777e, R.color.CAM_X0302);
            bVar.f61777e.setOnClickListener(new View$OnClickListenerC1521a(forumInfo, bVar));
            return view;
        } else if (item instanceof String) {
            View inflate = LayoutInflater.from(this.f61764e).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
            SkinManager.setBackgroundColor(inflate.findViewById(R.id.card_divider_top_margin), R.color.CAM_X0204);
            return inflate;
        } else {
            return view;
        }
    }
}
