package d.b.j0.o1;

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
    public final BaseActivity<?> f59204e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f59205f = true;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ForumSuggestModel.Forum> f59206g;

    /* renamed from: h  reason: collision with root package name */
    public String f59207h;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f59208a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59209b;

        /* renamed from: c  reason: collision with root package name */
        public BarImageView f59210c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59211d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f59212e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f59213f;

        public b(a aVar) {
        }
    }

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.f59204e = baseActivity;
        this.f59206g = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.f59206g.get(i);
    }

    public String b(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.f59204e.getPageContext().getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void c(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f59207h)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f59207h.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f59207h.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void d(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.f59206g = arrayList;
        if (arrayList != null) {
            notifyDataSetChanged();
        }
    }

    public void e(String str) {
        this.f59207h = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<ForumSuggestModel.Forum> arrayList = this.f59206g;
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
            view = LayoutInflater.from(this.f59204e.getPageContext().getPageActivity()).inflate(R.layout.square_dialog_search_item, (ViewGroup) null);
            bVar = new b();
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
            bVar.f59210c = barImageView;
            barImageView.setGifIconSupport(false);
            bVar.f59209b = (TextView) view.findViewById(R.id.name);
            bVar.f59211d = (TextView) view.findViewById(R.id.forum_member_count);
            bVar.f59212e = (TextView) view.findViewById(R.id.forum_thread_count);
            bVar.f59213f = (TextView) view.findViewById(R.id.slogan);
            bVar.f59208a = view.findViewById(R.id.offical_icon);
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
        bVar.f59210c.setTag(str2);
        bVar.f59210c.W(str2, 10, false);
        bVar.f59210c.invalidate();
        if (this.f59205f) {
            str = this.f59204e.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
        } else {
            str = item.forum_name;
        }
        c(bVar.f59209b, str);
        bVar.f59210c.setTag(item.avatar);
        TextView textView = bVar.f59211d;
        textView.setText(this.f59204e.getPageContext().getString(R.string.attention) + " " + b(item.member_num));
        TextView textView2 = bVar.f59212e;
        textView2.setText(this.f59204e.getPageContext().getString(R.string.text_post) + " " + b(item.thread_num));
        if (!this.f59205f && TextUtils.isEmpty(item.slogan)) {
            bVar.f59213f.setVisibility(8);
        } else {
            bVar.f59213f.setVisibility(0);
            bVar.f59213f.setText(item.slogan);
        }
        if (item.is_offical == 1) {
            bVar.f59208a.setVisibility(0);
            SkinManager.setBackgroundResource(bVar.f59208a, R.drawable.icon_search_official);
        } else {
            bVar.f59208a.setVisibility(8);
        }
        this.f59204e.getLayoutMode().k(skinType == 1);
        this.f59204e.getLayoutMode().j(view);
        return view;
    }
}
