package d.a.k0.o1.h;

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
    public final Context f57964e;

    /* renamed from: g  reason: collision with root package name */
    public List<ForumInfo> f57966g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f57967h;

    /* renamed from: i  reason: collision with root package name */
    public String f57968i;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f57965f = true;
    public LikeModel j = new LikeModel(null);

    /* renamed from: d.a.k0.o1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1455a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumInfo f57969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f57970f;

        /* renamed from: d.a.k0.o1.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1456a extends e {
            public C1456a() {
            }

            @Override // d.a.c.a.e
            public void c(Object obj) {
                if (a.this.j.getErrorCode() != 0) {
                    l.L(a.this.f57964e, R.string.attention_fail);
                    return;
                }
                View$OnClickListenerC1455a.this.f57970f.f57977e.setText(R.string.followed);
                l.L(a.this.f57964e, R.string.attention_success);
                View$OnClickListenerC1455a.this.f57970f.f57977e.setBackgroundDrawable(null);
                SkinManager.setViewTextColor(View$OnClickListenerC1455a.this.f57970f.f57977e, R.color.CAM_X0109);
                View$OnClickListenerC1455a.this.f57970f.f57977e.setOnClickListener(null);
            }
        }

        public View$OnClickListenerC1455a(ForumInfo forumInfo, b bVar) {
            this.f57969e = forumInfo;
            this.f57970f = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTER_FORUM_SUG_SHOW).param("obj_type", "3").param("fid", this.f57969e.forum_id.intValue()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            LikeModel likeModel = a.this.j;
            ForumInfo forumInfo = this.f57969e;
            likeModel.H(forumInfo.forum_name, String.valueOf(forumInfo.forum_id));
            a.this.j.setLoadDataCallBack(new C1456a());
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57973a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f57974b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57975c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57976d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f57977e;

        public b(a aVar) {
        }

        public /* synthetic */ b(a aVar, View$OnClickListenerC1455a view$OnClickListenerC1455a) {
            this(aVar);
        }
    }

    public a(Context context, ArrayList<ForumInfo> arrayList) {
        this.f57964e = context;
        this.f57966g = arrayList;
    }

    public void c(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f57968i)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f57968i.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f57968i.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void d(List<ForumInfo> list) {
        this.f57966g = list;
        this.f57967h = new ArrayList<>();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f57966g.size()) {
                break;
            } else if (this.f57966g.get(i3).has_concerned.intValue() == 0) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        this.f57967h.addAll(this.f57966g);
        if (i2 > 0) {
            this.f57967h.add(i2, "divider");
        }
        if (this.f57966g != null) {
            notifyDataSetChanged();
        }
    }

    public void e(String str) {
        this.f57968i = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f57967h == null || TextUtils.isEmpty(this.f57968i)) {
            return 0;
        }
        return this.f57967h.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        int count = getCount();
        if (count <= 0 || i2 >= count) {
            return null;
        }
        return this.f57967h.get(i2);
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
                view = LayoutInflater.from(this.f57964e).inflate(R.layout.forum_search_sug_item, (ViewGroup) null);
                bVar = new b(this, null);
                BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                bVar.f57974b = barImageView;
                barImageView.setGifIconSupport(false);
                bVar.f57973a = (TextView) view.findViewById(R.id.name);
                bVar.f57975c = (TextView) view.findViewById(R.id.forum_member_count);
                bVar.f57976d = (TextView) view.findViewById(R.id.forum_thread_count);
                bVar.f57977e = (TextView) view.findViewById(R.id.follow_text_view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (forumInfo == null) {
                return view;
            }
            String str2 = forumInfo.avatar;
            bVar.f57974b.setTag(str2);
            bVar.f57974b.V(str2, 15, false);
            bVar.f57974b.invalidate();
            if (this.f57965f) {
                str = this.f57964e.getString(R.string.chosen_pb_original_bar, forumInfo.forum_name);
            } else {
                str = forumInfo.forum_name;
            }
            c(bVar.f57973a, str);
            bVar.f57974b.setTag(forumInfo.avatar);
            TextView textView = bVar.f57975c;
            textView.setText(this.f57964e.getString(R.string.attention) + " " + forumInfo.concern_num);
            TextView textView2 = bVar.f57976d;
            textView2.setText(this.f57964e.getString(R.string.text_post) + " " + forumInfo.post_num);
            SkinManager.setViewTextColor(bVar.f57975c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(bVar.f57976d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(bVar.f57973a, R.color.CAM_X0105);
            if (forumInfo.has_concerned.intValue() > 0) {
                bVar.f57977e.setText(R.string.followed);
                SkinManager.setBackgroundResource(bVar.f57977e, 0);
                SkinManager.setViewTextColor(bVar.f57977e, R.color.CAM_X0109);
                bVar.f57977e.setOnClickListener(null);
                return view;
            }
            bVar.f57977e.setText(R.string.attention);
            SkinManager.setBackgroundResource(bVar.f57977e, R.drawable.search_like_btn_bg);
            SkinManager.setViewTextColor(bVar.f57977e, R.color.CAM_X0302);
            bVar.f57977e.setOnClickListener(new View$OnClickListenerC1455a(forumInfo, bVar));
            return view;
        } else if (item instanceof String) {
            View inflate = LayoutInflater.from(this.f57964e).inflate(R.layout.forum_search_divider_view, (ViewGroup) null);
            SkinManager.setBackgroundColor(inflate.findViewById(R.id.card_divider_top_margin), R.color.CAM_X0204);
            return inflate;
        } else {
            return view;
        }
    }
}
