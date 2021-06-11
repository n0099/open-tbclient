package d.a.n0.k1.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.n0.k1.p.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<e> f60462e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f60463f;

    /* renamed from: g  reason: collision with root package name */
    public int f60464g;

    /* renamed from: h  reason: collision with root package name */
    public int f60465h;

    /* renamed from: i  reason: collision with root package name */
    public final int f60466i;

    public b(Context context, int i2) {
        this.f60464g = 0;
        this.f60465h = 0;
        this.f60463f = context;
        this.f60464g = context.getResources().getDimensionPixelSize(R.dimen.fontsize28);
        this.f60465h = context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.f60466i = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i2) {
        if (i2 < 0 || i2 >= this.f60462e.size()) {
            return null;
        }
        return this.f60462e.get(i2);
    }

    public void b(List<e> list) {
        this.f60462e.clear();
        if (list != null && list.size() > 0) {
            this.f60462e.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f60462e.size();
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
            textView = new TextView(this.f60463f);
            textView.setGravity(17);
            textView.setTextSize(0, this.f60464g);
            int i3 = this.f60465h;
            textView.setPadding(0, i3, 0, i3);
        }
        e eVar = (e) ListUtils.getItem(this.f60462e, i2);
        if (eVar == null) {
            return null;
        }
        textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(eVar.f60449c, 8, null));
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
        if (i2 == this.f60466i) {
            SkinManager.setBackgroundResource(textView, R.drawable.btn_label_white_s);
        } else {
            SkinManager.setBackgroundResource(textView, R.drawable.lego_btn_more_item);
        }
        return textView;
    }
}
