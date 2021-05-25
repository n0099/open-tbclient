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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public String f58087e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f58088f;

    /* renamed from: g  reason: collision with root package name */
    public Context f58089g;

    /* renamed from: d.a.n0.p1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1467b {

        /* renamed from: a  reason: collision with root package name */
        public int f58090a;

        /* renamed from: b  reason: collision with root package name */
        public View f58091b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58092c;

        /* renamed from: d  reason: collision with root package name */
        public View f58093d;

        public C1467b(b bVar) {
            this.f58090a = 3;
        }
    }

    public b(Context context, ArrayList<String> arrayList) {
        this.f58089g = context;
        this.f58088f = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i2) {
        int count = getCount();
        if (count <= 0 || i2 >= count) {
            return null;
        }
        return this.f58088f.get(i2);
    }

    public void b(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f58087e)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f58087e.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f58087e.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void c(List<String> list) {
        this.f58088f = list;
        if (list != null) {
            notifyDataSetChanged();
        }
    }

    public void d(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f58087e = str.trim();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f58088f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1467b c1467b;
        if (view == null) {
            view = LayoutInflater.from(this.f58089g).inflate(R.layout.search_suggest_item, (ViewGroup) null);
            c1467b = new C1467b();
            c1467b.f58091b = view.findViewById(R.id.rootview);
            c1467b.f58092c = (TextView) view.findViewById(R.id.searchSuggestTitle);
            c1467b.f58093d = view.findViewById(R.id.searchItemSep);
            view.setTag(c1467b);
        } else {
            c1467b = (C1467b) view.getTag();
        }
        String item = getItem(i2);
        if (StringUtils.isNull(item)) {
            return view;
        }
        b(c1467b.f58092c, item);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != c1467b.f58090a) {
            c1467b.f58090a = skinType;
            SkinManager.setBackgroundResource(c1467b.f58091b, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(c1467b.f58092c, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(c1467b.f58093d, R.color.CAM_X0204);
        }
        return view;
    }
}
