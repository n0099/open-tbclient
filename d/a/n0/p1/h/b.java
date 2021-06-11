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
    public String f61778e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f61779f;

    /* renamed from: g  reason: collision with root package name */
    public Context f61780g;

    /* renamed from: d.a.n0.p1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1523b {

        /* renamed from: a  reason: collision with root package name */
        public int f61781a;

        /* renamed from: b  reason: collision with root package name */
        public View f61782b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61783c;

        /* renamed from: d  reason: collision with root package name */
        public View f61784d;

        public C1523b(b bVar) {
            this.f61781a = 3;
        }
    }

    public b(Context context, ArrayList<String> arrayList) {
        this.f61780g = context;
        this.f61779f = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i2) {
        int count = getCount();
        if (count <= 0 || i2 >= count) {
            return null;
        }
        return this.f61779f.get(i2);
    }

    public void b(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f61778e)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f61778e.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f61778e.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void c(List<String> list) {
        this.f61779f = list;
        if (list != null) {
            notifyDataSetChanged();
        }
    }

    public void d(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f61778e = str.trim();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f61779f;
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
        C1523b c1523b;
        if (view == null) {
            view = LayoutInflater.from(this.f61780g).inflate(R.layout.search_suggest_item, (ViewGroup) null);
            c1523b = new C1523b();
            c1523b.f61782b = view.findViewById(R.id.rootview);
            c1523b.f61783c = (TextView) view.findViewById(R.id.searchSuggestTitle);
            c1523b.f61784d = view.findViewById(R.id.searchItemSep);
            view.setTag(c1523b);
        } else {
            c1523b = (C1523b) view.getTag();
        }
        String item = getItem(i2);
        if (StringUtils.isNull(item)) {
            return view;
        }
        b(c1523b.f61783c, item);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != c1523b.f61781a) {
            c1523b.f61781a = skinType;
            SkinManager.setBackgroundResource(c1523b.f61782b, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(c1523b.f61783c, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(c1523b.f61784d, R.color.CAM_X0204);
        }
        return view;
    }
}
