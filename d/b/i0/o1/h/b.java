package d.b.i0.o1.h;

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
    public String f58820e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f58821f;

    /* renamed from: g  reason: collision with root package name */
    public Context f58822g;

    /* renamed from: d.b.i0.o1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1423b {

        /* renamed from: a  reason: collision with root package name */
        public int f58823a;

        /* renamed from: b  reason: collision with root package name */
        public View f58824b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58825c;

        /* renamed from: d  reason: collision with root package name */
        public View f58826d;

        public C1423b(b bVar) {
            this.f58823a = 3;
        }
    }

    public b(Context context, ArrayList<String> arrayList) {
        this.f58822g = context;
        this.f58821f = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.f58821f.get(i);
    }

    public void b(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f58820e)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f58820e.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f58820e.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void c(List<String> list) {
        this.f58821f = list;
        if (list != null) {
            notifyDataSetChanged();
        }
    }

    public void d(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f58820e = str.trim();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f58821f;
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
        C1423b c1423b;
        if (view == null) {
            view = LayoutInflater.from(this.f58822g).inflate(R.layout.search_suggest_item, (ViewGroup) null);
            c1423b = new C1423b();
            c1423b.f58824b = view.findViewById(R.id.rootview);
            c1423b.f58825c = (TextView) view.findViewById(R.id.searchSuggestTitle);
            c1423b.f58826d = view.findViewById(R.id.searchItemSep);
            view.setTag(c1423b);
        } else {
            c1423b = (C1423b) view.getTag();
        }
        String item = getItem(i);
        if (StringUtils.isNull(item)) {
            return view;
        }
        b(c1423b.f58825c, item);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != c1423b.f58823a) {
            c1423b.f58823a = skinType;
            SkinManager.setBackgroundResource(c1423b.f58824b, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(c1423b.f58825c, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(c1423b.f58826d, R.color.CAM_X0204);
        }
        return view;
    }
}
