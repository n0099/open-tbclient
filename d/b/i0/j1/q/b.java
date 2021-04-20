package d.b.i0.j1.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.b.i0.j1.p.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<e> f57492e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f57493f;

    /* renamed from: g  reason: collision with root package name */
    public int f57494g;

    /* renamed from: h  reason: collision with root package name */
    public int f57495h;
    public final int i;

    public b(Context context, int i) {
        this.f57494g = 0;
        this.f57495h = 0;
        this.f57493f = context;
        this.f57494g = context.getResources().getDimensionPixelSize(R.dimen.fontsize28);
        this.f57495h = context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.i = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i) {
        if (i < 0 || i >= this.f57492e.size()) {
            return null;
        }
        return this.f57492e.get(i);
    }

    public void b(List<e> list) {
        this.f57492e.clear();
        if (list != null && list.size() > 0) {
            this.f57492e.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f57492e.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = new TextView(this.f57493f);
            textView.setGravity(17);
            textView.setTextSize(0, this.f57494g);
            int i2 = this.f57495h;
            textView.setPadding(0, i2, 0, i2);
        }
        e eVar = (e) ListUtils.getItem(this.f57492e, i);
        if (eVar == null) {
            return null;
        }
        textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(eVar.f57480c, 8, null));
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
        if (i == this.i) {
            SkinManager.setBackgroundResource(textView, R.drawable.btn_label_white_s);
        } else {
            SkinManager.setBackgroundResource(textView, R.drawable.lego_btn_more_item);
        }
        return textView;
    }
}
