package d.a.j0.o1;

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
    public TbPageContext<?> f57252a;

    /* renamed from: b  reason: collision with root package name */
    public TableLayout f57253b;

    /* renamed from: c  reason: collision with root package name */
    public View f57254c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57255d;

    /* renamed from: e  reason: collision with root package name */
    public View f57256e;

    public g(TbPageContext<?> tbPageContext) {
        this.f57252a = tbPageContext;
    }

    public View a(c cVar, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f57252a.getPageActivity()).inflate(R.layout.search_topic_item, (ViewGroup) null);
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
        b(linearLayout, i2, this.f57253b, 2);
        return linearLayout;
    }

    public final void b(View view, int i2, TableLayout tableLayout, int i3) {
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.f57252a.getResources().getDimensionPixelSize(R.dimen.ds360), -2);
        if (i2 % i3 == 0) {
            TableRow tableRow = new TableRow(this.f57252a.getPageActivity());
            tableRow.addView(view, layoutParams);
            tableLayout.addView(tableRow);
        } else if (tableLayout.getChildCount() != 0) {
            ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1)).addView(view, layoutParams);
        }
    }

    public void c() {
        this.f57253b.removeAllViews();
        this.f57254c.setVisibility(8);
        this.f57253b.setVisibility(8);
        this.f57255d.setVisibility(8);
    }

    public View d() {
        View inflate = LayoutInflater.from(this.f57252a.getPageActivity()).inflate(R.layout.search_topic, (ViewGroup) null);
        this.f57254c = inflate;
        View findViewById = inflate.findViewById(R.id.titleTopDivider);
        this.f57256e = findViewById;
        findViewById.setVisibility(0);
        this.f57253b = (TableLayout) this.f57254c.findViewById(R.id.search_topic_layout);
        TextView textView = (TextView) this.f57254c.findViewById(R.id.square_search_fourm_header_text);
        this.f57255d = textView;
        textView.setText(this.f57252a.getResources().getString(R.string.hot_topic_title));
        return this.f57254c;
    }

    public final String e(String str, int i2) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() <= i2) {
            return str;
        }
        String substring = str.substring(0, i2 - 1);
        return substring + this.f57252a.getString(R.string.ellipsis);
    }

    @SuppressLint({"ResourceAsColor"})
    public void f(int i2) {
        this.f57252a.getLayoutMode().j(this.f57254c);
        int childCount = this.f57253b.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            TableRow tableRow = (TableRow) this.f57253b.getChildAt(i3);
            int childCount2 = tableRow.getChildCount();
            for (int i4 = 0; i4 < childCount2; i4++) {
                LinearLayout linearLayout = (LinearLayout) tableRow.getChildAt(i4);
                if (linearLayout.getChildCount() != 0) {
                    TextView textView = (TextView) linearLayout.getChildAt(0);
                    ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                    if (i3 == childCount - 1 && i4 == childCount2 - 1) {
                        textView.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
                    } else {
                        g(imageView, imageView.getTag() != null ? ((Integer) imageView.getTag()).intValue() : 0, i2);
                        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, i2);
                    }
                    SkinManager.setBackgroundResource(textView, R.drawable.square_search_item_bg, i2);
                }
            }
        }
    }

    public final void g(ImageView imageView, int i2, int i3) {
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(null);
        if (i2 == 1) {
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_new, i3);
        } else if (i2 == 2) {
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_hot, i3);
        } else if (i2 != 3) {
            imageView.setVisibility(8);
        } else {
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_recommend, i3);
        }
    }

    public void h(String str) {
        if (this.f57255d != null) {
            if (!StringUtils.isNull(str)) {
                this.f57255d.setText(str);
            } else {
                this.f57255d.setText(this.f57252a.getResources().getString(R.string.hot_topic_title));
            }
        }
    }

    public void i(boolean z) {
        this.f57256e.setVisibility(z ? 0 : 8);
    }

    public void j() {
        f(TbadkCoreApplication.getInst().getSkinType());
        this.f57254c.setVisibility(0);
        this.f57253b.setVisibility(0);
        this.f57255d.setVisibility(0);
    }
}
