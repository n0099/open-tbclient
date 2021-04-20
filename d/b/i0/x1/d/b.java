package d.b.i0.x1.d;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.x1.e.c;
/* loaded from: classes3.dex */
public class b extends d.b.c.j.e.a<c, a> {

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f63897a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63898b;

        /* renamed from: c  reason: collision with root package name */
        public View f63899c;

        public a(View view, TextView textView, View view2) {
            super(view);
            this.f63897a = 3;
            this.f63898b = textView;
            this.f63899c = view2;
        }

        public void b(c cVar) {
            if (cVar != null) {
                this.f63898b.setText(cVar.f63944e);
                this.f63899c.setVisibility(cVar.f63945f ? 0 : 8);
            }
        }

        public void c(int i) {
            if (this.f63897a != i) {
                SkinManager.setViewTextColor(this.f63898b, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f63899c, R.color.CAM_X0204);
                this.f63897a = i;
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.x1.e.a.f63939b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public a R(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setPadding(l.g(viewGroup.getContext(), R.dimen.tbds44), 0, l.g(viewGroup.getContext(), R.dimen.tbds44), l.g(viewGroup.getContext(), R.dimen.tbds12));
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        View view = new View(viewGroup.getContext());
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, l.g(viewGroup.getContext(), R.dimen.tbds1)));
        TextView textView = new TextView(viewGroup.getContext());
        textView.setTextColor(viewGroup.getContext().getResources().getColor(R.color.CAM_X0105));
        textView.setTextSize(0, l.g(viewGroup.getContext(), R.dimen.tbds47));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setIncludeFontPadding(false);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(0, l.g(viewGroup.getContext(), R.dimen.tbds48), 0, 0);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        a aVar = new a(linearLayout, textView, view);
        aVar.c(TbadkCoreApplication.getInst().getSkinType());
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, c cVar, a aVar) {
        if (cVar == null || aVar == null) {
            return null;
        }
        aVar.b(cVar);
        aVar.c(TbadkCoreApplication.getInst().getSkinType());
        return aVar.a();
    }
}
