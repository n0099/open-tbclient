package d.a.o0.d1.f.f;

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
import d.a.o0.d1.c.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<p> f56500e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f56501f;

    /* renamed from: g  reason: collision with root package name */
    public int f56502g;

    /* renamed from: h  reason: collision with root package name */
    public int f56503h;

    /* renamed from: i  reason: collision with root package name */
    public final int f56504i;

    public b(Context context, int i2) {
        this.f56502g = 0;
        this.f56503h = 0;
        this.f56501f = context;
        this.f56502g = context.getResources().getDimensionPixelSize(R.dimen.fontsize28);
        this.f56503h = context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.f56504i = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public p getItem(int i2) {
        if (i2 < 0 || i2 >= this.f56500e.size()) {
            return null;
        }
        return this.f56500e.get(i2);
    }

    public void b(List<p> list) {
        this.f56500e.clear();
        if (list != null && list.size() > 0) {
            this.f56500e.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f56500e.size();
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
            textView = new TextView(this.f56501f);
            textView.setGravity(17);
            textView.setTextSize(0, this.f56502g);
            int i3 = this.f56503h;
            textView.setPadding(0, i3, 0, i3);
        }
        p pVar = (p) ListUtils.getItem(this.f56500e, i2);
        if (pVar == null) {
            return null;
        }
        textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(pVar.f56425e, 8, null));
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
        if (i2 == this.f56504i) {
            SkinManager.setBackgroundResource(textView, R.drawable.btn_label_white_s);
        } else if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            textView.setBackgroundResource(R.drawable.topic_btn_more_item);
        } else {
            textView.setBackgroundResource(R.drawable.topic_btn_more_item_1);
        }
        return textView;
    }
}
