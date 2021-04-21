package d.b.j0.c1.f.f;

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
import d.b.j0.c1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<p> f54036e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f54037f;

    /* renamed from: g  reason: collision with root package name */
    public int f54038g;

    /* renamed from: h  reason: collision with root package name */
    public int f54039h;
    public final int i;

    public b(Context context, int i) {
        this.f54038g = 0;
        this.f54039h = 0;
        this.f54037f = context;
        this.f54038g = context.getResources().getDimensionPixelSize(R.dimen.fontsize28);
        this.f54039h = context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.i = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public p getItem(int i) {
        if (i < 0 || i >= this.f54036e.size()) {
            return null;
        }
        return this.f54036e.get(i);
    }

    public void b(List<p> list) {
        this.f54036e.clear();
        if (list != null && list.size() > 0) {
            this.f54036e.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f54036e.size();
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
            textView = new TextView(this.f54037f);
            textView.setGravity(17);
            textView.setTextSize(0, this.f54038g);
            int i2 = this.f54039h;
            textView.setPadding(0, i2, 0, i2);
        }
        p pVar = (p) ListUtils.getItem(this.f54036e, i);
        if (pVar == null) {
            return null;
        }
        textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(pVar.f53967e, 8, null));
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
        if (i == this.i) {
            SkinManager.setBackgroundResource(textView, R.drawable.btn_label_white_s);
        } else if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            textView.setBackgroundResource(R.drawable.topic_btn_more_item);
        } else {
            textView.setBackgroundResource(R.drawable.topic_btn_more_item_1);
        }
        return textView;
    }
}
