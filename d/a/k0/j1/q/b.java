package d.a.k0.j1.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.k0.j1.p.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<e> f56593e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f56594f;

    /* renamed from: g  reason: collision with root package name */
    public int f56595g;

    /* renamed from: h  reason: collision with root package name */
    public int f56596h;

    /* renamed from: i  reason: collision with root package name */
    public final int f56597i;

    public b(Context context, int i2) {
        this.f56595g = 0;
        this.f56596h = 0;
        this.f56594f = context;
        this.f56595g = context.getResources().getDimensionPixelSize(R.dimen.fontsize28);
        this.f56596h = context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.f56597i = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i2) {
        if (i2 < 0 || i2 >= this.f56593e.size()) {
            return null;
        }
        return this.f56593e.get(i2);
    }

    public void b(List<e> list) {
        this.f56593e.clear();
        if (list != null && list.size() > 0) {
            this.f56593e.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f56593e.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            textView = new TextView(this.f56594f);
            textView.setGravity(17);
            textView.setTextSize(0, this.f56595g);
            int i3 = this.f56596h;
            textView.setPadding(0, i3, 0, i3);
        }
        e eVar = (e) ListUtils.getItem(this.f56593e, i2);
        if (eVar == null) {
            return null;
        }
        textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(eVar.f56580c, 8, null));
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
        if (i2 == this.f56597i) {
            SkinManager.setBackgroundResource(textView, R.drawable.btn_label_white_s);
        } else {
            SkinManager.setBackgroundResource(textView, R.drawable.lego_btn_more_item);
        }
        return textView;
    }
}
