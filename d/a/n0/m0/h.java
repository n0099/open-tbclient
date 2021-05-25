package d.a.n0.m0;

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
    public TbPageContext f57247e;

    /* renamed from: f  reason: collision with root package name */
    public View f57248f;

    /* renamed from: g  reason: collision with root package name */
    public SpannableString f57249g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57250h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f57251i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = h.this;
            d.a.c.e.m.g.b(hVar, hVar.f57247e);
        }
    }

    public h(TbPageContext tbPageContext, int i2) {
        super(tbPageContext.getContext(), i2);
        this.f57247e = tbPageContext;
    }

    public final void b() {
        TbPageContext tbPageContext = this.f57247e;
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().k(this.j == 1);
            this.f57247e.getLayoutMode().j(this.f57248f);
        }
    }

    public void c() {
        this.f57248f = LayoutInflater.from(this.f57247e.getPageActivity()).inflate(R.layout.face_buy_fail, (ViewGroup) null);
        this.j = TbadkApplication.getInst().getSkinType();
        String string = getContext().getResources().getString(R.string.query_buy_fail_tel);
        this.f57249g = new SpannableString(string);
        this.f57249g.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10159)), 5, string.length(), 33);
        setContentView(this.f57248f, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds364)));
        TextView textView = (TextView) findViewById(R.id.telphone);
        this.f57250h = textView;
        textView.setText(this.f57249g);
        TextView textView2 = (TextView) findViewById(R.id.confirm);
        this.f57251i = textView2;
        textView2.setOnClickListener(new a());
        setCancelable(true);
        b();
    }

    public void d() {
        this.f57248f = LayoutInflater.from(this.f57247e.getPageActivity()).inflate(R.layout.face_buy_loading, (ViewGroup) null);
        this.j = TbadkApplication.getInst().getSkinType();
        setContentView(this.f57248f, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds282)));
        setCancelable(false);
        b();
    }
}
