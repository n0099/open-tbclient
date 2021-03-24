package d.b.i0.n1.h;

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
import d.b.b.a.e;
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final Context f57107e;

    /* renamed from: g  reason: collision with root package name */
    public List<ForumInfo> f57109g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f57110h;
    public String i;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f57108f = true;
    public LikeModel j = new LikeModel(null);

    /* renamed from: d.b.i0.n1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1356a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumInfo f57111e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f57112f;

        /* renamed from: d.b.i0.n1.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1357a extends e {
            public C1357a() {
            }

            @Override // d.b.b.a.e
            public void c(Object obj) {
                if (a.this.j.getErrorCode() != 0) {
                    l.K(a.this.f57107e, R.string.attention_fail);
                    return;
                }
                View$OnClickListenerC1356a.this.f57112f.f57119e.setText(R.string.followed);
                l.K(a.this.f57107e, R.string.attention_success);
                View$OnClickListenerC1356a.this.f57112f.f57119e.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(View$OnClickListenerC1356a.this.f57112f.f57119e, R.color.CAM_X0109);
                View$OnClickListenerC1356a.this.f57112f.f57119e.setOnClickListener(null);
            }
        }

        public View$OnClickListenerC1356a(ForumInfo forumInfo, b bVar) {
            this.f57111e = forumInfo;
            this.f57112f = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTER_FORUM_SUG_SHOW).param("obj_type", "3").param("fid", this.f57111e.forum_id.intValue()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            LikeModel likeModel = a.this.j;
            ForumInfo forumInfo = this.f57111e;
            likeModel.H(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
            a.this.j.setLoadDataCallBack(new C1357a());
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57115a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f57116b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57117c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57118d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f57119e;

        public b(a aVar) {
        }

        public /* synthetic */ b(a aVar, View$OnClickListenerC1356a view$OnClickListenerC1356a) {
            this(aVar);
        }
    }

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.f57107e = context;
        this.f57109g = arrayList;
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
        this.f57109g = list;
        this.f57110h = new ArrayList<>();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f57109g.size()) {
                break;
            } else if (this.f57109g.get(i2).has_concerned.intValue() == 0) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        this.f57110h.addAll(this.f57109g);
        if (i > 0) {
            this.f57110h.add(i, "divider");
        }
        if (this.f57109g != null) {
            notifyDataSetChanged();
        }
    }

    public void e(String str) {
        this.i = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f57110h == null || TextUtils.isEmpty(this.i)) {
            return 0;
        }
        return this.f57110h.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.f57110h.get(i);
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
                view = LayoutInflater.from(this.f57107e).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                bVar = new b(this, null);
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                bVar.f57116b = barImageView;
                barImageView.setGifIconSupport(false);
                bVar.f57115a = (TextView) view.findViewById(R.id.name);
                bVar.f57117c = (TextView) view.findViewById(R.id.forum_member_count);
                bVar.f57118d = (TextView) view.findViewById(R.id.forum_thread_count);
                bVar.f57119e = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (forumInfo == null) {
                return view;
            }
            String str2 = forumInfo.avatar;
            bVar.f57116b.setTag(str2);
            bVar.f57116b.W(str2, 15, false);
            bVar.f57116b.invalidate();
            if (this.f57108f) {
                str = this.f57107e.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
            } else {
                str = forumInfo.forum_name;
            }
            c(bVar.f57115a, str);
            bVar.f57116b.setTag(forumInfo.avatar);
            TextView textView = bVar.f57117c;
            textView.setText(this.f57107e.getString(R.string.attention) + " " + forumInfo.concern_num);
            TextView textView2 = bVar.f57118d;
            textView2.setText(this.f57107e.getString(R.string.text_post) + " " + forumInfo.post_num);
            SkinManager.setViewTextColor(bVar.f57117c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(bVar.f57118d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(bVar.f57115a, R.color.CAM_X0105);
            if (forumInfo.has_concerned.intValue() > 0) {
                bVar.f57119e.setText(R.string.followed);
                SkinManager.setBackgroundResource(bVar.f57119e, 0);
                SkinManager.setViewTextColor(bVar.f57119e, R.color.CAM_X0109);
                bVar.f57119e.setOnClickListener(null);
                return view;
            }
            bVar.f57119e.setText(R.string.attention);
            SkinManager.setBackgroundResource(bVar.f57119e, R.drawable.search_like_btn_bg);
            SkinManager.setViewTextColor(bVar.f57119e, R.color.CAM_X0302);
            bVar.f57119e.setOnClickListener(new View$OnClickListenerC1356a(forumInfo, bVar));
            return view;
        } else if (item instanceof String) {
            View inflate = LayoutInflater.from(this.f57107e).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
            SkinManager.setBackgroundColor(inflate.findViewById(R.id.card_divider_top_margin), R.color.CAM_X0204);
            return inflate;
        } else {
            return view;
        }
    }
}
