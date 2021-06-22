package d.a.o0.p1.h;

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
    public String f61903e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f61904f;

    /* renamed from: g  reason: collision with root package name */
    public Context f61905g;

    /* renamed from: d.a.o0.p1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1527b {

        /* renamed from: a  reason: collision with root package name */
        public int f61906a;

        /* renamed from: b  reason: collision with root package name */
        public View f61907b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61908c;

        /* renamed from: d  reason: collision with root package name */
        public View f61909d;

        public C1527b(b bVar) {
            this.f61906a = 3;
        }
    }

    public b(Context context, ArrayList<String> arrayList) {
        this.f61905g = context;
        this.f61904f = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i2) {
        int count = getCount();
        if (count <= 0 || i2 >= count) {
            return null;
        }
        return this.f61904f.get(i2);
    }

    public void b(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f61903e)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f61903e.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f61903e.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void c(List<String> list) {
        this.f61904f = list;
        if (list != null) {
            notifyDataSetChanged();
        }
    }

    public void d(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f61903e = str.trim();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f61904f;
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
        C1527b c1527b;
        if (view == null) {
            view = LayoutInflater.from(this.f61905g).inflate(R.layout.search_suggest_item, (ViewGroup) null);
            c1527b = new C1527b();
            c1527b.f61907b = view.findViewById(R.id.rootview);
            c1527b.f61908c = (TextView) view.findViewById(R.id.searchSuggestTitle);
            c1527b.f61909d = view.findViewById(R.id.searchItemSep);
            view.setTag(c1527b);
        } else {
            c1527b = (C1527b) view.getTag();
        }
        String item = getItem(i2);
        if (StringUtils.isNull(item)) {
            return view;
        }
        b(c1527b.f61908c, item);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != c1527b.f61906a) {
            c1527b.f61906a = skinType;
            SkinManager.setBackgroundResource(c1527b.f61907b, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(c1527b.f61908c, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(c1527b.f61909d, R.color.CAM_X0204);
        }
        return view;
    }
}
