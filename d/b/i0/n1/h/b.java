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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public String f57120e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f57121f;

    /* renamed from: g  reason: collision with root package name */
    public Context f57122g;

    /* renamed from: d.b.i0.n1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1358b {

        /* renamed from: a  reason: collision with root package name */
        public int f57123a;

        /* renamed from: b  reason: collision with root package name */
        public View f57124b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57125c;

        /* renamed from: d  reason: collision with root package name */
        public View f57126d;

        public C1358b(b bVar) {
            this.f57123a = 3;
        }
    }

    public b(Context context, ArrayList<String> arrayList) {
        this.f57122g = context;
        this.f57121f = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.f57121f.get(i);
    }

    public void b(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f57120e)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f57120e.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f57120e.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void c(List<String> list) {
        this.f57121f = list;
        if (list != null) {
            notifyDataSetChanged();
        }
    }

    public void d(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f57120e = str.trim();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f57121f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1358b c1358b;
        if (view == null) {
            view = LayoutInflater.from(this.f57122g).inflate(R.layout.search_suggest_item, (ViewGroup) null);
            c1358b = new C1358b();
            c1358b.f57124b = view.findViewById(R.id.rootview);
            c1358b.f57125c = (TextView) view.findViewById(R.id.searchSuggestTitle);
            c1358b.f57126d = view.findViewById(R.id.searchItemSep);
            view.setTag(c1358b);
        } else {
            c1358b = (C1358b) view.getTag();
        }
        String item = getItem(i);
        if (StringUtils.isNull(item)) {
            return view;
        }
        b(c1358b.f57125c, item);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != c1358b.f57123a) {
            c1358b.f57123a = skinType;
            SkinManager.setBackgroundResource(c1358b.f57124b, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(c1358b.f57125c, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(c1358b.f57126d, R.color.CAM_X0204);
        }
        return view;
    }
}
