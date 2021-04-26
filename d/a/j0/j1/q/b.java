package d.a.j0.j1.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.j0.j1.p.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<e> f55886e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f55887f;

    /* renamed from: g  reason: collision with root package name */
    public int f55888g;

    /* renamed from: h  reason: collision with root package name */
    public int f55889h;

    /* renamed from: i  reason: collision with root package name */
    public final int f55890i;

    public b(Context context, int i2) {
        this.f55888g = 0;
        this.f55889h = 0;
        this.f55887f = context;
        this.f55888g = context.getResources().getDimensionPixelSize(R.dimen.fontsize28);
        this.f55889h = context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.f55890i = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i2) {
        if (i2 < 0 || i2 >= this.f55886e.size()) {
            return null;
        }
        return this.f55886e.get(i2);
    }

    public void b(List<e> list) {
        this.f55886e.clear();
        if (list != null && list.size() > 0) {
            this.f55886e.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f55886e.size();
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
            textView = new TextView(this.f55887f);
            textView.setGravity(17);
            textView.setTextSize(0, this.f55888g);
            int i3 = this.f55889h;
            textView.setPadding(0, i3, 0, i3);
        }
        e eVar = (e) ListUtils.getItem(this.f55886e, i2);
        if (eVar == null) {
            return null;
        }
        textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(eVar.f55873c, 8, null));
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
        if (i2 == this.f55890i) {
            SkinManager.setBackgroundResource(textView, R.drawable.btn_label_white_s);
        } else {
            SkinManager.setBackgroundResource(textView, R.drawable.lego_btn_more_item);
        }
        return textView;
    }
}
