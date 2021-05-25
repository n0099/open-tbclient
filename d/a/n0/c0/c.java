package d.a.n0.c0;

import android.content.ClipboardManager;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import d.a.c.e.p.l;
import d.a.m0.b1.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.n0.c0.a> f52295e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f52296f;

    /* renamed from: g  reason: collision with root package name */
    public int f52297g;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.c0.a f52298e;

        public a(d.a.n0.c0.a aVar) {
            this.f52298e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            String h2 = this.f52298e.h();
            if (StringUtils.isNull(h2)) {
                return false;
            }
            ClipboardManager clipboardManager = (ClipboardManager) c.this.f52296f.getPageActivity().getSystemService("clipboard");
            clipboardManager.setText(h2);
            if (clipboardManager.getText() != null) {
                l.L(c.this.f52296f.getPageActivity(), R.string.copy_to_clip);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.c0.a f52300e;

        public b(d.a.n0.c0.a aVar) {
            this.f52300e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(c.this.f52296f, new String[]{this.f52300e.c()});
        }
    }

    /* renamed from: d.a.n0.c0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1229c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f52302a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f52303b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f52304c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f52305d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f52306e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f52307f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f52308g;

        /* renamed from: h  reason: collision with root package name */
        public View f52309h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f52310i;
        public TextView j;
    }

    public c(TbPageContext<?> tbPageContext, int i2) {
        this.f52296f = tbPageContext;
        this.f52297g = i2;
    }

    public final SpannableString b(int i2, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2, AbsoluteSizeSpan absoluteSizeSpan, int i3) {
        String string = this.f52296f.getString(i2);
        String formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(i3, j);
        String str = string + "    [icon]" + formatOverBaiwanNum;
        SpannableString spannableString = new SpannableString(str);
        UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
        Drawable moneyIcon = CurrencySwitchUtil.getMoneyIcon(i3);
        int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds24);
        moneyIcon.setBounds(0, 0, g2, g2);
        d dVar = new d(moneyIcon);
        dVar.b(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
        UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, foregroundColorSpan2);
        UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, absoluteSizeSpan);
        return spannableString;
    }

    public final SpannableString c(int i2, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        String string = this.f52296f.getString(i2);
        String long2String = StringHelper.long2String(j, "yyyy-MM-dd HH:mm");
        String str = string + "    " + long2String;
        SpannableString spannableString = new SpannableString(str);
        UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
        UtilHelper.setSpan(spannableString, str, long2String, foregroundColorSpan2);
        return spannableString;
    }

    public final SpannableString d(int i2, String str, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        String str2 = this.f52296f.getString(i2) + "    " + str;
        SpannableString spannableString = new SpannableString(str2);
        UtilHelper.setSpan(spannableString, str2, str2, foregroundColorSpan);
        UtilHelper.setSpan(spannableString, str2, str, foregroundColorSpan2);
        return spannableString;
    }

    public final void e(C1229c c1229c, d.a.n0.c0.a aVar) {
        SpannableString spannableString;
        SpannableString spannableString2;
        SpannableString spannableString3;
        SpannableString spannableString4;
        String l;
        int i2;
        int i3;
        if (c1229c == null || aVar == null) {
            return;
        }
        c1229c.f52308g.setText(this.f52296f.getString(R.string.order_id) + "    ");
        c1229c.f52302a.setText(aVar.h());
        c1229c.f52302a.setOnLongClickListener(new a(aVar));
        if (aVar.k() == 1) {
            c1229c.f52303b.V(String.valueOf(R.drawable.icon_payment_success), 24, false);
            SkinManager.setViewTextColor(c1229c.f52303b, R.color.CAM_X0305, 1);
        } else {
            c1229c.f52303b.V(String.valueOf(R.drawable.icon_payment_fail), 24, false);
            SkinManager.setViewTextColor(c1229c.f52303b, R.color.CAM_X0109, 1);
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105));
        new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(24, true);
        int i4 = this.f52297g;
        if (i4 == 1) {
            SpannableString d2 = d(R.string.buy_product, aVar.l(), foregroundColorSpan, foregroundColorSpan2);
            spannableString3 = b(R.string.consumption_t_bean, aVar.m(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, aVar.e());
            spannableString = c(R.string.buy_time, aVar.d(), foregroundColorSpan, foregroundColorSpan2);
            spannableString4 = d2;
            spannableString2 = null;
        } else if (i4 == 2) {
            SpannableString d3 = d(R.string.get_with_product, aVar.l(), foregroundColorSpan, foregroundColorSpan2);
            spannableString3 = b(CurrencySwitchUtil.isYyIsConvert(aVar.e()) ? R.string.get_y_bean : R.string.get_t_bean, aVar.m(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan, aVar.e());
            spannableString = c(R.string.buy_time, aVar.d(), foregroundColorSpan, foregroundColorSpan2);
            String str = "" + aVar.j();
            String str2 = this.f52296f.getString(R.string.alternative_account) + "    " + str;
            SpannableString spannableString5 = new SpannableString(str2);
            UtilHelper.setSpan(spannableString5, str2, str2, foregroundColorSpan);
            UtilHelper.setSpan(spannableString5, str2, str, foregroundColorSpan2);
            spannableString2 = spannableString5;
            spannableString4 = d3;
        } else if (i4 == 3) {
            String string = this.f52296f.getString(R.string.recharge_product);
            if (CurrencySwitchUtil.isYyIsConvert(aVar.e())) {
                l = String.format(this.f52296f.getString(R.string.ydou_rmb), g(Double.valueOf(aVar.i())));
            } else {
                l = aVar.l();
            }
            String str3 = string + "    " + l;
            spannableString4 = new SpannableString(str3);
            UtilHelper.setSpan(spannableString4, str3, str3, foregroundColorSpan);
            UtilHelper.setSpan(spannableString4, str3, l, foregroundColorSpan2);
            String str4 = ("" + aVar.g()) + this.f52296f.getString(R.string.recharge_use_money);
            String str5 = this.f52296f.getString(R.string.recharge_money) + "    " + str4;
            SpannableString spannableString6 = new SpannableString(str5);
            UtilHelper.setSpan(spannableString6, str5, str5, foregroundColorSpan);
            UtilHelper.setSpan(spannableString6, str5, str4, foregroundColorSpan2);
            UtilHelper.setSpan(spannableString6, str5, str4, absoluteSizeSpan);
            spannableString3 = spannableString6;
            SpannableString c2 = c(R.string.recharge_time, aVar.f(), foregroundColorSpan, foregroundColorSpan2);
            String str6 = "" + aVar.j();
            String str7 = this.f52296f.getString(R.string.recharge_account) + "    " + str6;
            spannableString2 = new SpannableString(str7);
            UtilHelper.setSpan(spannableString2, str7, str7, foregroundColorSpan);
            UtilHelper.setSpan(spannableString2, str7, str6, foregroundColorSpan2);
            spannableString = c2;
        } else {
            spannableString = null;
            spannableString2 = null;
            spannableString3 = null;
            spannableString4 = null;
        }
        c1229c.f52304c.setText(spannableString4);
        c1229c.f52305d.setText(spannableString3);
        c1229c.f52306e.setText(spannableString);
        if (!StringUtils.isNull(aVar.j()) && ((i3 = this.f52297g) == 3 || i3 == 2)) {
            c1229c.f52307f.setVisibility(0);
            c1229c.f52307f.setText(spannableString2);
        } else {
            c1229c.f52307f.setVisibility(8);
        }
        if (!StringUtils.isNull(aVar.b())) {
            c1229c.f52310i.setText(aVar.b());
            if (!StringUtils.isNull(aVar.a())) {
                c1229c.j.setText(aVar.a());
                i2 = 0;
                c1229c.j.setVisibility(0);
            } else {
                i2 = 0;
                c1229c.j.setVisibility(8);
            }
            c1229c.j.setOnClickListener(new b(aVar));
            c1229c.f52309h.setVisibility(i2);
            return;
        }
        c1229c.f52309h.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public d.a.n0.c0.a getItem(int i2) {
        ArrayList<d.a.n0.c0.a> arrayList = this.f52295e;
        if (arrayList == null || arrayList.size() <= 0 || i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f52295e.get(i2);
    }

    public final String g(Double d2) {
        if (d2.doubleValue() == d2.intValue()) {
            return d2.intValue() + "";
        }
        return d2 + "";
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d.a.n0.c0.a> arrayList = this.f52295e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1229c c1229c;
        d.a.n0.c0.a item = getItem(i2);
        if (view != null) {
            c1229c = (C1229c) view.getTag();
        } else {
            view = LayoutInflater.from(this.f52296f.getPageActivity()).inflate(R.layout.records_item_layout, viewGroup, false);
            c1229c = new C1229c();
            c1229c.f52302a = (TextView) view.findViewById(R.id.order_id_textview);
            c1229c.f52303b = (TbImageView) view.findViewById(R.id.order_status_textview);
            c1229c.f52304c = (TextView) view.findViewById(R.id.order_title_textview);
            c1229c.f52305d = (TextView) view.findViewById(R.id.order_price_textview);
            c1229c.f52308g = (TextView) view.findViewById(R.id.order_id_tip);
            c1229c.f52307f = (TextView) view.findViewById(R.id.order_account_textview);
            c1229c.f52306e = (TextView) view.findViewById(R.id.order_time_textview);
            c1229c.f52309h = view.findViewById(R.id.order_activity_content);
            c1229c.f52310i = (TextView) view.findViewById(R.id.activity_desc_textview);
            c1229c.j = (TextView) view.findViewById(R.id.activity_button_textview);
            view.setTag(c1229c);
        }
        e(c1229c, item);
        this.f52296f.getLayoutMode().j(view);
        return view;
    }

    public void h(ArrayList<d.a.n0.c0.a> arrayList) {
        this.f52295e = arrayList;
    }
}
