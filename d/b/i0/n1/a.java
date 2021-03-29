package d.b.i0.n1;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final BaseActivity<?> f57084e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f57085f = true;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ForumSuggestModel.Forum> f57086g;

    /* renamed from: h  reason: collision with root package name */
    public String f57087h;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f57088a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57089b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f57090c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57091d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f57092e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f57093f;

        public b(a aVar) {
        }
    }

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.f57084e = baseActivity;
        this.f57086g = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.f57086g.get(i);
    }

    public String b(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.f57084e.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f57087h)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f57087h.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f57087h.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void d(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.f57086g = arrayList;
        if (arrayList != null) {
            notifyDataSetChanged();
        }
    }

    public void e(String str) {
        this.f57087h = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<ForumSuggestModel.Forum> arrayList = this.f57086g;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.f57084e.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            bVar = new b();
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            bVar.f57090c = barImageView;
            barImageView.setGifIconSupport(false);
            bVar.f57089b = (TextView) view.findViewById(R.id.name);
            bVar.f57091d = (TextView) view.findViewById(R.id.forum_member_count);
            bVar.f57092e = (TextView) view.findViewById(R.id.forum_thread_count);
            bVar.f57093f = (TextView) view.findViewById(R.id.slogan);
            bVar.f57088a = view.findViewById(R.id.offical_icon);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item == null) {
            return view;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        String str2 = item.avatar;
        bVar.f57090c.setTag(str2);
        bVar.f57090c.W(str2, 10, false);
        bVar.f57090c.invalidate();
        if (this.f57085f) {
            str = this.f57084e.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
        } else {
            str = item.forum_name;
        }
        c(bVar.f57089b, str);
        bVar.f57090c.setTag(item.avatar);
        TextView textView = bVar.f57091d;
        textView.setText(this.f57084e.getPageContext().getString(R.string.attention) + " " + b(item.member_num));
        TextView textView2 = bVar.f57092e;
        textView2.setText(this.f57084e.getPageContext().getString(R.string.text_post) + " " + b(item.thread_num));
        if (!this.f57085f && TextUtils.isEmpty(item.slogan)) {
            bVar.f57093f.setVisibility(8);
        } else {
            bVar.f57093f.setVisibility(0);
            bVar.f57093f.setText(item.slogan);
        }
        if (item.is_offical == 1) {
            bVar.f57088a.setVisibility(0);
            SkinManager.setBackgroundResource(bVar.f57088a, R.drawable.icon_search_official);
        } else {
            bVar.f57088a.setVisibility(8);
        }
        this.f57084e.getLayoutMode().k(skinType == 1);
        this.f57084e.getLayoutMode().j(view);
        return view;
    }
}
