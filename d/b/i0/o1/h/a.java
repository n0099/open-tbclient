package d.b.i0.o1.h;

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
import d.b.c.a.e;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final Context f58807e;

    /* renamed from: g  reason: collision with root package name */
    public List<ForumInfo> f58809g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f58810h;
    public String i;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f58808f = true;
    public LikeModel j = new LikeModel(null);

    /* renamed from: d.b.i0.o1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1421a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumInfo f58811e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f58812f;

        /* renamed from: d.b.i0.o1.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1422a extends e {
            public C1422a() {
            }

            @Override // d.b.c.a.e
            public void c(Object obj) {
                if (a.this.j.getErrorCode() != 0) {
                    l.K(a.this.f58807e, R.string.attention_fail);
                    return;
                }
                View$OnClickListenerC1421a.this.f58812f.f58819e.setText(R.string.followed);
                l.K(a.this.f58807e, R.string.attention_success);
                View$OnClickListenerC1421a.this.f58812f.f58819e.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(View$OnClickListenerC1421a.this.f58812f.f58819e, R.color.CAM_X0109);
                View$OnClickListenerC1421a.this.f58812f.f58819e.setOnClickListener(null);
            }
        }

        public View$OnClickListenerC1421a(ForumInfo forumInfo, b bVar) {
            this.f58811e = forumInfo;
            this.f58812f = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTER_FORUM_SUG_SHOW).param("obj_type", "3").param("fid", this.f58811e.forum_id.intValue()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            LikeModel likeModel = a.this.j;
            ForumInfo forumInfo = this.f58811e;
            likeModel.H(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
            a.this.j.setLoadDataCallBack(new C1422a());
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58815a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f58816b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58817c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58818d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f58819e;

        public b(a aVar) {
        }

        public /* synthetic */ b(a aVar, View$OnClickListenerC1421a view$OnClickListenerC1421a) {
            this(aVar);
        }
    }

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.f58807e = context;
        this.f58809g = arrayList;
    }

    public void c(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.i)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.i.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.i.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void d(List<ForumInfo> list) {
        this.f58809g = list;
        this.f58810h = new ArrayList<>();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f58809g.size()) {
                break;
            } else if (this.f58809g.get(i2).has_concerned.intValue() == 0) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        this.f58810h.addAll(this.f58809g);
        if (i > 0) {
            this.f58810h.add(i, "divider");
        }
        if (this.f58809g != null) {
            notifyDataSetChanged();
        }
    }

    public void e(String str) {
        this.i = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f58810h == null || TextUtils.isEmpty(this.i)) {
            return 0;
        }
        return this.f58810h.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.f58810h.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        String str;
        Object item = getItem(i);
        if (item instanceof ForumInfo) {
            ForumInfo forumInfo = (ForumInfo) item;
            if (view == null) {
                view = LayoutInflater.from(this.f58807e).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                bVar = new b(this, null);
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                bVar.f58816b = barImageView;
                barImageView.setGifIconSupport(false);
                bVar.f58815a = (TextView) view.findViewById(R.id.name);
                bVar.f58817c = (TextView) view.findViewById(R.id.forum_member_count);
                bVar.f58818d = (TextView) view.findViewById(R.id.forum_thread_count);
                bVar.f58819e = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (forumInfo == null) {
                return view;
            }
            String str2 = forumInfo.avatar;
            bVar.f58816b.setTag(str2);
            bVar.f58816b.W(str2, 15, false);
            bVar.f58816b.invalidate();
            if (this.f58808f) {
                str = this.f58807e.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
            } else {
                str = forumInfo.forum_name;
            }
            c(bVar.f58815a, str);
            bVar.f58816b.setTag(forumInfo.avatar);
            TextView textView = bVar.f58817c;
            textView.setText(this.f58807e.getString(R.string.attention) + " " + forumInfo.concern_num);
            TextView textView2 = bVar.f58818d;
            textView2.setText(this.f58807e.getString(R.string.text_post) + " " + forumInfo.post_num);
            SkinManager.setViewTextColor(bVar.f58817c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(bVar.f58818d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(bVar.f58815a, R.color.CAM_X0105);
            if (forumInfo.has_concerned.intValue() > 0) {
                bVar.f58819e.setText(R.string.followed);
                SkinManager.setBackgroundResource(bVar.f58819e, 0);
                SkinManager.setViewTextColor(bVar.f58819e, R.color.CAM_X0109);
                bVar.f58819e.setOnClickListener(null);
                return view;
            }
            bVar.f58819e.setText(R.string.attention);
            SkinManager.setBackgroundResource(bVar.f58819e, R.drawable.search_like_btn_bg);
            SkinManager.setViewTextColor(bVar.f58819e, R.color.CAM_X0302);
            bVar.f58819e.setOnClickListener(new View$OnClickListenerC1421a(forumInfo, bVar));
            return view;
        } else if (item instanceof String) {
            View inflate = LayoutInflater.from(this.f58807e).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
            SkinManager.setBackgroundColor(inflate.findViewById(R.id.card_divider_top_margin), R.color.CAM_X0204);
            return inflate;
        } else {
            return view;
        }
    }
}
