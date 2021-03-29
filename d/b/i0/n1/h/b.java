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
    public String f57121e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f57122f;

    /* renamed from: g  reason: collision with root package name */
    public Context f57123g;

    /* renamed from: d.b.i0.n1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1359b {

        /* renamed from: a  reason: collision with root package name */
        public int f57124a;

        /* renamed from: b  reason: collision with root package name */
        public View f57125b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57126c;

        /* renamed from: d  reason: collision with root package name */
        public View f57127d;

        public C1359b(b bVar) {
            this.f57124a = 3;
        }
    }

    public b(Context context, ArrayList<String> arrayList) {
        this.f57123g = context;
        this.f57122f = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.f57122f.get(i);
    }

    public void b(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f57121e)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f57121e.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f57121e.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void c(List<String> list) {
        this.f57122f = list;
        if (list != null) {
            notifyDataSetChanged();
        }
    }

    public void d(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f57121e = str.trim();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f57122f;
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
        C1359b c1359b;
        if (view == null) {
            view = LayoutInflater.from(this.f57123g).inflate(R.layout.search_suggest_item, (ViewGroup) null);
            c1359b = new C1359b();
            c1359b.f57125b = view.findViewById(R.id.rootview);
            c1359b.f57126c = (TextView) view.findViewById(R.id.searchSuggestTitle);
            c1359b.f57127d = view.findViewById(R.id.searchItemSep);
            view.setTag(c1359b);
        } else {
            c1359b = (C1359b) view.getTag();
        }
        String item = getItem(i);
        if (StringUtils.isNull(item)) {
            return view;
        }
        b(c1359b.f57126c, item);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != c1359b.f57124a) {
            c1359b.f57124a = skinType;
            SkinManager.setBackgroundResource(c1359b.f57125b, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(c1359b.f57126c, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(c1359b.f57127d, R.color.CAM_X0204);
        }
        return view;
    }
}
