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
    public TbPageContext f60936e;

    /* renamed from: f  reason: collision with root package name */
    public View f60937f;

    /* renamed from: g  reason: collision with root package name */
    public SpannableString f60938g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60939h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f60940i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = h.this;
            d.a.c.e.m.g.b(hVar, hVar.f60936e);
        }
    }

    public h(TbPageContext tbPageContext, int i2) {
        super(tbPageContext.getContext(), i2);
        this.f60936e = tbPageContext;
    }

    public final void b() {
        TbPageContext tbPageContext = this.f60936e;
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().k(this.j == 1);
            this.f60936e.getLayoutMode().j(this.f60937f);
        }
    }

    public void c() {
        this.f60937f = LayoutInflater.from(this.f60936e.getPageActivity()).inflate(R.layout.face_buy_fail, (ViewGroup) null);
        this.j = TbadkApplication.getInst().getSkinType();
        String string = getContext().getResources().getString(R.string.query_buy_fail_tel);
        this.f60938g = new SpannableString(string);
        this.f60938g.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10159)), 5, string.length(), 33);
        setContentView(this.f60937f, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds364)));
        TextView textView = (TextView) findViewById(R.id.telphone);
        this.f60939h = textView;
        textView.setText(this.f60938g);
        TextView textView2 = (TextView) findViewById(R.id.confirm);
        this.f60940i = textView2;
        textView2.setOnClickListener(new a());
        setCancelable(true);
        b();
    }

    public void d() {
        this.f60937f = LayoutInflater.from(this.f60936e.getPageActivity()).inflate(R.layout.face_buy_loading, (ViewGroup) null);
        this.j = TbadkApplication.getInst().getSkinType();
        setContentView(this.f60937f, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds282)));
        setCancelable(false);
        b();
    }
}
