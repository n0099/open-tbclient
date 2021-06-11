package d.a.n0.p1;

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
    public final BaseActivity<?> f61740e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f61741f = true;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ForumSuggestModel.Forum> f61742g;

    /* renamed from: h  reason: collision with root package name */
    public String f61743h;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f61744a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61745b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f61746c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61747d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61748e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f61749f;

        public b(a aVar) {
        }
    }

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.f61740e = baseActivity;
        this.f61742g = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ForumSuggestModel.Forum getItem(int i2) {
        int count = getCount();
        if (count <= 0 || i2 >= count) {
            return null;
        }
        return this.f61742g.get(i2);
    }

    public String b(int i2) {
        if (i2 >= 100000) {
            return String.valueOf(i2 / 10000) + this.f61740e.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i2);
    }

    public void c(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f61743h)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f61743h.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f61743h.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void d(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.f61742g = arrayList;
        if (arrayList != null) {
            notifyDataSetChanged();
        }
    }

    public void e(String str) {
        this.f61743h = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<ForumSuggestModel.Forum> arrayList = this.f61742g;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        String str;
        if (view == null) {
            view = LayoutInflater.from(this.f61740e.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            bVar = new b();
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            bVar.f61746c = barImageView;
            barImageView.setGifIconSupport(false);
            bVar.f61745b = (TextView) view.findViewById(R.id.name);
            bVar.f61747d = (TextView) view.findViewById(R.id.forum_member_count);
            bVar.f61748e = (TextView) view.findViewById(R.id.forum_thread_count);
            bVar.f61749f = (TextView) view.findViewById(R.id.slogan);
            bVar.f61744a = view.findViewById(R.id.offical_icon);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i2);
        if (item == null) {
            return view;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        String str2 = item.avatar;
        bVar.f61746c.setTag(str2);
        bVar.f61746c.U(str2, 10, false);
        bVar.f61746c.invalidate();
        if (this.f61741f) {
            str = this.f61740e.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
        } else {
            str = item.forum_name;
        }
        c(bVar.f61745b, str);
        bVar.f61746c.setTag(item.avatar);
        TextView textView = bVar.f61747d;
        textView.setText(this.f61740e.getPageContext().getString(R.string.attention) + " " + b(item.member_num));
        TextView textView2 = bVar.f61748e;
        textView2.setText(this.f61740e.getPageContext().getString(R.string.text_post) + " " + b(item.thread_num));
        if (!this.f61741f && TextUtils.isEmpty(item.slogan)) {
            bVar.f61749f.setVisibility(8);
        } else {
            bVar.f61749f.setVisibility(0);
            bVar.f61749f.setText(item.slogan);
        }
        if (item.is_offical == 1) {
            bVar.f61744a.setVisibility(0);
            SkinManager.setBackgroundResource(bVar.f61744a, R.drawable.icon_search_official);
        } else {
            bVar.f61744a.setVisibility(8);
        }
        this.f61740e.getLayoutMode().k(skinType == 1);
        this.f61740e.getLayoutMode().j(view);
        return view;
    }
}
