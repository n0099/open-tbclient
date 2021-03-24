package d.b.i0.b1.f.f;

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
import d.b.i0.b1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<p> f52213e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f52214f;

    /* renamed from: g  reason: collision with root package name */
    public int f52215g;

    /* renamed from: h  reason: collision with root package name */
    public int f52216h;
    public final int i;

    public b(Context context, int i) {
        this.f52215g = 0;
        this.f52216h = 0;
        this.f52214f = context;
        this.f52215g = context.getResources().getDimensionPixelSize(R.dimen.fontsize28);
        this.f52216h = context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.i = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public p getItem(int i) {
        if (i < 0 || i >= this.f52213e.size()) {
            return null;
        }
        return this.f52213e.get(i);
    }

    public void b(List<p> list) {
        this.f52213e.clear();
        if (list != null && list.size() > 0) {
            this.f52213e.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f52213e.size();
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
            textView = new TextView(this.f52214f);
            textView.setGravity(17);
            textView.setTextSize(0, this.f52215g);
            int i2 = this.f52216h;
            textView.setPadding(0, i2, 0, i2);
        }
        p pVar = (p) ListUtils.getItem(this.f52213e, i);
        if (pVar == null) {
            return null;
        }
        textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(pVar.f52144e, 8, null));
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
