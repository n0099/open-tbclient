package d.a.n0.d1.f.f;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.n0.d1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<p> f52686e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f52687f;

    /* renamed from: g  reason: collision with root package name */
    public int f52688g;

    /* renamed from: h  reason: collision with root package name */
    public int f52689h;

    /* renamed from: i  reason: collision with root package name */
    public final int f52690i;

    public b(Context context, int i2) {
        this.f52688g = 0;
        this.f52689h = 0;
        this.f52687f = context;
        this.f52688g = context.getResources().getDimensionPixelSize(R.dimen.fontsize28);
        this.f52689h = context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.f52690i = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public p getItem(int i2) {
        if (i2 < 0 || i2 >= this.f52686e.size()) {
            return null;
        }
        return this.f52686e.get(i2);
    }

    public void b(List<p> list) {
        this.f52686e.clear();
        if (list != null && list.size() > 0) {
            this.f52686e.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f52686e.size();
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
            textView = new TextView(this.f52687f);
            textView.setGravity(17);
            textView.setTextSize(0, this.f52688g);
            int i3 = this.f52689h;
            textView.setPadding(0, i3, 0, i3);
        }
        p pVar = (p) ListUtils.getItem(this.f52686e, i2);
        if (pVar == null) {
            return null;
        }
        textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(pVar.f52611e, 8, null));
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
        if (i2 == this.f52690i) {
            SkinManager.setBackgroundResource(textView, R.drawable.btn_label_white_s);
        } else if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            textView.setBackgroundResource(R.drawable.topic_btn_more_item);
        } else {
            textView.setBackgroundResource(R.drawable.topic_btn_more_item_1);
        }
        return textView;
    }
}
