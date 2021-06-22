package d.a.o0.y1.d;

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
import d.a.c.e.p.l;
import d.a.o0.y1.e.c;
/* loaded from: classes5.dex */
public class b extends d.a.c.k.e.a<c, a> {

    /* loaded from: classes5.dex */
    public static class a extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f67197a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f67198b;

        /* renamed from: c  reason: collision with root package name */
        public View f67199c;

        public a(View view, TextView textView, View view2) {
            super(view);
            this.f67197a = 3;
            this.f67198b = textView;
            this.f67199c = view2;
        }

        public void b(c cVar) {
            if (cVar != null) {
                this.f67198b.setText(cVar.f67246e);
                this.f67199c.setVisibility(cVar.f67247f ? 0 : 8);
            }
        }

        public void c(int i2) {
            if (this.f67197a != i2) {
                SkinManager.setViewTextColor(this.f67198b, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f67199c, R.color.CAM_X0204);
                this.f67197a = i2;
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.y1.e.a.f67240b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public a Q(ViewGroup viewGroup) {
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
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, c cVar, a aVar) {
        if (cVar == null || aVar == null) {
            return null;
        }
        aVar.b(cVar);
        aVar.c(TbadkCoreApplication.getInst().getSkinType());
        return aVar.a();
    }
}
