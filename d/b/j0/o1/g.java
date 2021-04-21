package d.b.j0.o1;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f59223a;

    /* renamed from: b  reason: collision with root package name */
    public TableLayout f59224b;

    /* renamed from: c  reason: collision with root package name */
    public View f59225c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59226d;

    /* renamed from: e  reason: collision with root package name */
    public View f59227e;

    public g(TbPageContext<?> tbPageContext) {
        this.f59223a = tbPageContext;
    }

    public View a(c cVar, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f59223a.getPageActivity()).inflate(R.layout.search_topic_item, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.text_search_topic_item_text);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.image_search_topic_item);
        if (cVar != null) {
            int c2 = cVar.c();
            imageView.setVisibility(0);
            imageView.setTag(Integer.valueOf(c2));
            g(imageView, c2, TbadkCoreApplication.getInst().getSkinType());
            textView.setText(e(cVar.b(), 8));
            linearLayout.setTag(cVar);
        } else {
            textView.setText(R.string.hot_forum_title_more);
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            imageView.setVisibility(8);
        }
        b(linearLayout, i, this.f59224b, 2);
        return linearLayout;
    }

    public final void b(View view, int i, TableLayout tableLayout, int i2) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.f59223a.getResources().getDimensionPixelSize(R.dimen.ds360), -2);
        if (i % i2 == 0) {
            TableRow tableRow = new TableRow(this.f59223a.getPageActivity());
            tableRow.addView(view, layoutParams);
            tableLayout.addView(tableRow);
        } else if (tableLayout.getChildCount() != 0) {
            ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1)).addView(view, layoutParams);
        }
    }

    public void c() {
        this.f59224b.removeAllViews();
        this.f59225c.setVisibility(8);
        this.f59224b.setVisibility(8);
        this.f59226d.setVisibility(8);
    }

    public View d() {
        View inflate = LayoutInflater.from(this.f59223a.getPageActivity()).inflate(R.layout.search_topic, (ViewGroup) null);
        this.f59225c = inflate;
        View findViewById = inflate.findViewById(R.id.titleTopDivider);
        this.f59227e = findViewById;
        findViewById.setVisibility(0);
        this.f59224b = (TableLayout) this.f59225c.findViewById(R.id.search_topic_layout);
        TextView textView = (TextView) this.f59225c.findViewById(R.id.square_search_fourm_header_text);
        this.f59226d = textView;
        textView.setText(this.f59223a.getResources().getString(R.string.hot_topic_title));
        return this.f59225c;
    }

    public final String e(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() <= i) {
            return str;
        }
        String substring = str.substring(0, i - 1);
        return substring + this.f59223a.getString(R.string.ellipsis);
    }

    @SuppressLint({"ResourceAsColor"})
    public void f(int i) {
        this.f59223a.getLayoutMode().j(this.f59225c);
        int childCount = this.f59224b.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            TableRow tableRow = (TableRow) this.f59224b.getChildAt(i2);
            int childCount2 = tableRow.getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                LinearLayout linearLayout = (LinearLayout) tableRow.getChildAt(i3);
                if (linearLayout.getChildCount() != 0) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (i2 == childCount - 1 && i3 == childCount2 - 1) {
                        textView.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
                    } else {
                        g(imageView, imageView.getTag() != null ? ((Integer) imageView.getTag()).intValue() : 0, i);
                        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, i);
                    }
                    SkinManager.setBackgroundResource(textView, R.drawable.square_search_item_bg, i);
                }
            }
        }
    }

    public final void g(ImageView imageView, int i, int i2) {
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(null);
        if (i == 1) {
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_new, i2);
        } else if (i == 2) {
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_hot, i2);
        } else if (i != 3) {
            imageView.setVisibility(8);
        } else {
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_recommend, i2);
        }
    }

    public void h(String str) {
        if (this.f59226d != null) {
            if (!StringUtils.isNull(str)) {
                this.f59226d.setText(str);
            } else {
                this.f59226d.setText(this.f59223a.getResources().getString(R.string.hot_topic_title));
            }
        }
    }

    public void i(boolean z) {
        this.f59227e.setVisibility(z ? 0 : 8);
    }

    public void j() {
        f(TbadkCoreApplication.getInst().getSkinType());
        this.f59225c.setVisibility(0);
        this.f59224b.setVisibility(0);
        this.f59226d.setVisibility(0);
    }
}
