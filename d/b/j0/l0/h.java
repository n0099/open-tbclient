package d.b.j0.l0;

import android.app.Dialog;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f58351e;

    /* renamed from: f  reason: collision with root package name */
    public View f58352f;

    /* renamed from: g  reason: collision with root package name */
    public SpannableString f58353g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58354h;
    public TextView i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = h.this;
            d.b.c.e.m.g.b(hVar, hVar.f58351e);
        }
    }

    public h(TbPageContext tbPageContext, int i) {
        super(tbPageContext.getContext(), i);
        this.f58351e = tbPageContext;
    }

    public final void b() {
        TbPageContext tbPageContext = this.f58351e;
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().k(this.j == 1);
            this.f58351e.getLayoutMode().j(this.f58352f);
        }
    }

    public void c() {
        this.f58352f = LayoutInflater.from(this.f58351e.getPageActivity()).inflate(R.layout.face_buy_fail, (ViewGroup) null);
        this.j = TbadkApplication.getInst().getSkinType();
        String string = getContext().getResources().getString(R.string.query_buy_fail_tel);
        this.f58353g = new SpannableString(string);
        this.f58353g.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10159)), 5, string.length(), 33);
        setContentView(this.f58352f, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds364)));
        TextView textView = (TextView) findViewById(R.id.telphone);
        this.f58354h = textView;
        textView.setText(this.f58353g);
        TextView textView2 = (TextView) findViewById(R.id.confirm);
        this.i = textView2;
        textView2.setOnClickListener(new a());
        setCancelable(true);
        b();
    }

    public void d() {
        this.f58352f = LayoutInflater.from(this.f58351e.getPageActivity()).inflate(R.layout.face_buy_loading, (ViewGroup) null);
        this.j = TbadkApplication.getInst().getSkinType();
        setContentView(this.f58352f, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds282)));
        setCancelable(false);
        b();
    }
}
