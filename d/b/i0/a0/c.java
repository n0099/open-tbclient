package d.b.i0.a0;

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
import d.b.b.e.p.l;
import d.b.h0.b1.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.b.i0.a0.a> f51851e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f51852f;

    /* renamed from: g  reason: collision with root package name */
    public int f51853g;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.a0.a f51854e;

        public a(d.b.i0.a0.a aVar) {
            this.f51854e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            String g2 = this.f51854e.g();
            if (StringUtils.isNull(g2)) {
                return false;
            }
            ClipboardManager clipboardManager = (ClipboardManager) c.this.f51852f.getPageActivity().getSystemService("clipboard");
            clipboardManager.setText(g2);
            if (clipboardManager.getText() != null) {
                l.K(c.this.f51852f.getPageActivity(), R.string.copy_to_clip);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.a0.a f51856e;

        public b(d.b.i0.a0.a aVar) {
            this.f51856e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(c.this.f51852f, new String[]{this.f51856e.c()});
        }
    }

    /* renamed from: d.b.i0.a0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1118c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f51858a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f51859b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f51860c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f51861d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f51862e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f51863f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f51864g;

        /* renamed from: h  reason: collision with root package name */
        public View f51865h;
        public TextView i;
        public TextView j;
    }

    public c(TbPageContext<?> tbPageContext, int i) {
        this.f51852f = tbPageContext;
        this.f51853g = i;
    }

    public final SpannableString b(int i, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2, AbsoluteSizeSpan absoluteSizeSpan) {
        String string = this.f51852f.getString(i);
        String formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(j);
        String str = string + "    [icon]" + formatOverBaiwanNum;
        SpannableString spannableString = new SpannableString(str);
        UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_huobi_tdou);
        int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds24);
        drawable.setBounds(0, 0, g2, g2);
        d dVar = new d(drawable);
        dVar.b(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
        UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, foregroundColorSpan2);
        UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, absoluteSizeSpan);
        return spannableString;
    }

    public final SpannableString c(int i, long j, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        String string = this.f51852f.getString(i);
        String long2String = StringHelper.long2String(j, StringUtils.TIMEFORMAT);
        String str = string + "    " + long2String;
        SpannableString spannableString = new SpannableString(str);
        UtilHelper.setSpan(spannableString, str, str, foregroundColorSpan);
        UtilHelper.setSpan(spannableString, str, long2String, foregroundColorSpan2);
        return spannableString;
    }

    public final SpannableString d(int i, String str, ForegroundColorSpan foregroundColorSpan, ForegroundColorSpan foregroundColorSpan2) {
        String str2 = this.f51852f.getString(i) + "    " + str;
        SpannableString spannableString = new SpannableString(str2);
        UtilHelper.setSpan(spannableString, str2, str2, foregroundColorSpan);
        UtilHelper.setSpan(spannableString, str2, str, foregroundColorSpan2);
        return spannableString;
    }

    public final void e(C1118c c1118c, d.b.i0.a0.a aVar) {
        SpannableString spannableString;
        SpannableString spannableString2;
        SpannableString spannableString3;
        SpannableString spannableString4;
        SpannableString spannableString5;
        int i;
        int i2;
        if (c1118c == null || aVar == null) {
            return;
        }
        c1118c.f51864g.setText(this.f51852f.getString(R.string.order_id) + "    ");
        c1118c.f51858a.setText(aVar.g());
        c1118c.f51858a.setOnLongClickListener(new a(aVar));
        if (aVar.i() == 1) {
            c1118c.f51859b.W(String.valueOf(R.drawable.icon_payment_success), 24, false);
            SkinManager.setViewTextColor(c1118c.f51859b, R.color.CAM_X0305, 1);
        } else {
            c1118c.f51859b.W(String.valueOf(R.drawable.icon_payment_fail), 24, false);
            SkinManager.setViewTextColor(c1118c.f51859b, R.color.CAM_X0109, 1);
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105));
        new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(24, true);
        int i3 = this.f51853g;
        if (i3 == 1) {
            spannableString4 = d(R.string.buy_product, aVar.j(), foregroundColorSpan, foregroundColorSpan2);
            spannableString3 = b(R.string.consumption_t_bean, aVar.k(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan);
            spannableString = c(R.string.buy_time, aVar.d(), foregroundColorSpan, foregroundColorSpan2);
            spannableString2 = null;
        } else {
            if (i3 == 2) {
                spannableString5 = d(R.string.get_with_product, aVar.j(), foregroundColorSpan, foregroundColorSpan2);
                spannableString3 = b(R.string.get_t_bean, aVar.k(), foregroundColorSpan, foregroundColorSpan2, absoluteSizeSpan);
                spannableString = c(R.string.buy_time, aVar.d(), foregroundColorSpan, foregroundColorSpan2);
                String str = "" + aVar.h();
                String str2 = this.f51852f.getString(R.string.alternative_account) + "    " + str;
                spannableString2 = new SpannableString(str2);
                UtilHelper.setSpan(spannableString2, str2, str2, foregroundColorSpan);
                UtilHelper.setSpan(spannableString2, str2, str, foregroundColorSpan2);
            } else if (i3 == 3) {
                String string = this.f51852f.getString(R.string.recharge_product);
                String j = aVar.j();
                String str3 = string + "    " + j;
                SpannableString spannableString6 = new SpannableString(str3);
                UtilHelper.setSpan(spannableString6, str3, str3, foregroundColorSpan);
                UtilHelper.setSpan(spannableString6, str3, j, foregroundColorSpan2);
                String str4 = ("" + aVar.f()) + this.f51852f.getString(R.string.recharge_use_money);
                String str5 = this.f51852f.getString(R.string.recharge_money) + "    " + str4;
                SpannableString spannableString7 = new SpannableString(str5);
                UtilHelper.setSpan(spannableString7, str5, str5, foregroundColorSpan);
                UtilHelper.setSpan(spannableString7, str5, str4, foregroundColorSpan2);
                UtilHelper.setSpan(spannableString7, str5, str4, absoluteSizeSpan);
                spannableString3 = spannableString7;
                spannableString5 = spannableString6;
                spannableString = c(R.string.recharge_time, aVar.e(), foregroundColorSpan, foregroundColorSpan2);
                String str6 = "" + aVar.h();
                String str7 = this.f51852f.getString(R.string.recharge_account) + "    " + str6;
                spannableString2 = new SpannableString(str7);
                UtilHelper.setSpan(spannableString2, str7, str7, foregroundColorSpan);
                UtilHelper.setSpan(spannableString2, str7, str6, foregroundColorSpan2);
            } else {
                spannableString = null;
                spannableString2 = null;
                spannableString3 = null;
                spannableString4 = null;
            }
            spannableString4 = spannableString5;
        }
        c1118c.f51860c.setText(spannableString4);
        c1118c.f51861d.setText(spannableString3);
        c1118c.f51862e.setText(spannableString);
        if (!StringUtils.isNull(aVar.h()) && ((i2 = this.f51853g) == 3 || i2 == 2)) {
            c1118c.f51863f.setVisibility(0);
            c1118c.f51863f.setText(spannableString2);
        } else {
            c1118c.f51863f.setVisibility(8);
        }
        if (!StringUtils.isNull(aVar.b())) {
            c1118c.i.setText(aVar.b());
            if (!StringUtils.isNull(aVar.a())) {
                c1118c.j.setText(aVar.a());
                i = 0;
                c1118c.j.setVisibility(0);
            } else {
                i = 0;
                c1118c.j.setVisibility(8);
            }
            c1118c.j.setOnClickListener(new b(aVar));
            c1118c.f51865h.setVisibility(i);
            return;
        }
        c1118c.f51865h.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public d.b.i0.a0.a getItem(int i) {
        ArrayList<d.b.i0.a0.a> arrayList = this.f51851e;
        if (arrayList == null || arrayList.size() <= 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.f51851e.get(i);
    }

    public void g(ArrayList<d.b.i0.a0.a> arrayList) {
        this.f51851e = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<d.b.i0.a0.a> arrayList = this.f51851e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1118c c1118c;
        d.b.i0.a0.a item = getItem(i);
        if (view != null) {
            c1118c = (C1118c) view.getTag();
        } else {
            view = LayoutInflater.from(this.f51852f.getPageActivity()).inflate(R.layout.records_item_layout, viewGroup, false);
            c1118c = new C1118c();
            c1118c.f51858a = (TextView) view.findViewById(R.id.order_id_textview);
            c1118c.f51859b = (TbImageView) view.findViewById(R.id.order_status_textview);
            c1118c.f51860c = (TextView) view.findViewById(R.id.order_title_textview);
            c1118c.f51861d = (TextView) view.findViewById(R.id.order_price_textview);
            c1118c.f51864g = (TextView) view.findViewById(R.id.order_id_tip);
            c1118c.f51863f = (TextView) view.findViewById(R.id.order_account_textview);
            c1118c.f51862e = (TextView) view.findViewById(R.id.order_time_textview);
            c1118c.f51865h = view.findViewById(R.id.order_activity_content);
            c1118c.i = (TextView) view.findViewById(R.id.activity_desc_textview);
            c1118c.j = (TextView) view.findViewById(R.id.activity_button_textview);
            view.setTag(c1118c);
        }
        e(c1118c, item);
        this.f51852f.getLayoutMode().j(view);
        return view;
    }
}
