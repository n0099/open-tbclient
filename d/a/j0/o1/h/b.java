package d.a.j0.o1.h;

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
    public String f57271e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f57272f;

    /* renamed from: g  reason: collision with root package name */
    public Context f57273g;

    /* renamed from: d.a.j0.o1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1385b {

        /* renamed from: a  reason: collision with root package name */
        public int f57274a;

        /* renamed from: b  reason: collision with root package name */
        public View f57275b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57276c;

        /* renamed from: d  reason: collision with root package name */
        public View f57277d;

        public C1385b(b bVar) {
            this.f57274a = 3;
        }
    }

    public b(Context context, ArrayList<String> arrayList) {
        this.f57273g = context;
        this.f57272f = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i2) {
        int count = getCount();
        if (count <= 0 || i2 >= count) {
            return null;
        }
        return this.f57272f.get(i2);
    }

    public void b(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f57271e)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f57271e.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f57271e.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void c(List<String> list) {
        this.f57272f = list;
        if (list != null) {
            notifyDataSetChanged();
        }
    }

    public void d(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f57271e = str.trim();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f57272f;
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
        C1385b c1385b;
        if (view == null) {
            view = LayoutInflater.from(this.f57273g).inflate(R.layout.search_suggest_item, (ViewGroup) null);
            c1385b = new C1385b();
            c1385b.f57275b = view.findViewById(R.id.rootview);
            c1385b.f57276c = (TextView) view.findViewById(R.id.searchSuggestTitle);
            c1385b.f57277d = view.findViewById(R.id.searchItemSep);
            view.setTag(c1385b);
        } else {
            c1385b = (C1385b) view.getTag();
        }
        String item = getItem(i2);
        if (StringUtils.isNull(item)) {
            return view;
        }
        b(c1385b.f57276c, item);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != c1385b.f57274a) {
            c1385b.f57274a = skinType;
            SkinManager.setBackgroundResource(c1385b.f57275b, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(c1385b.f57276c, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(c1385b.f57277d, R.color.CAM_X0204);
        }
        return view;
    }
}
