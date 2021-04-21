package d.b.j0.o1.h;

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
    public String f59241e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f59242f;

    /* renamed from: g  reason: collision with root package name */
    public Context f59243g;

    /* renamed from: d.b.j0.o1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1446b {

        /* renamed from: a  reason: collision with root package name */
        public int f59244a;

        /* renamed from: b  reason: collision with root package name */
        public View f59245b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59246c;

        /* renamed from: d  reason: collision with root package name */
        public View f59247d;

        public C1446b(b bVar) {
            this.f59244a = 3;
        }
    }

    public b(Context context, ArrayList<String> arrayList) {
        this.f59243g = context;
        this.f59242f = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.f59242f.get(i);
    }

    public void b(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f59241e)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f59241e.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f59241e.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void c(List<String> list) {
        this.f59242f = list;
        if (list != null) {
            notifyDataSetChanged();
        }
    }

    public void d(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f59241e = str.trim();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f59242f;
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
        C1446b c1446b;
        if (view == null) {
            view = LayoutInflater.from(this.f59243g).inflate(R.layout.search_suggest_item, (ViewGroup) null);
            c1446b = new C1446b();
            c1446b.f59245b = view.findViewById(R.id.rootview);
            c1446b.f59246c = (TextView) view.findViewById(R.id.searchSuggestTitle);
            c1446b.f59247d = view.findViewById(R.id.searchItemSep);
            view.setTag(c1446b);
        } else {
            c1446b = (C1446b) view.getTag();
        }
        String item = getItem(i);
        if (StringUtils.isNull(item)) {
            return view;
        }
        b(c1446b.f59246c, item);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != c1446b.f59244a) {
            c1446b.f59244a = skinType;
            SkinManager.setBackgroundResource(c1446b.f59245b, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(c1446b.f59246c, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(c1446b.f59247d, R.color.CAM_X0204);
        }
        return view;
    }
}
