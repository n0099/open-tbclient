package d.a.k0.u0.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.k0.u0.b.g;
import d.a.k0.u0.c.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1670a> f62093f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f62094g;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f62096i;
    public boolean j;

    /* renamed from: e  reason: collision with root package name */
    public int f62092e = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62095h = false;
    public int k = -1;
    public View.OnClickListener l = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                b.this.f62094g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.f62094g.showToast(R.string.neterror);
        }
    }

    /* renamed from: d.a.k0.u0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1671b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62098a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62099b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f62100c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62101d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62102e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f62103f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f62104g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f62105h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f62106i;
        public TextView j;
        public TextView k;

        public C1671b() {
        }

        public /* synthetic */ C1671b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.f62094g = myGiftListActivity;
        this.j = z;
    }

    public final void b(View view) {
        this.f62094g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f62094g.getLayoutMode().j(view);
    }

    public final View c() {
        NoDataViewFactory.c cVar = null;
        View inflate = LayoutInflater.from(this.f62094g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f62094g.getResources().getString(R.string.send_gift), this.f62094g.getSendGiftClickListener()));
        this.f62094g.getResources().getDimension(R.dimen.tbds200);
        this.f62094g.getResources().getDimension(R.dimen.ds140);
        String userSex = this.f62094g.getUserSex();
        this.f62094g.getPageContext().getString(R.string.no_gift);
        String string = this.f62094g.getPageContext().getString(R.string.come_on);
        String format = String.format(this.f62094g.getPageContext().getString(R.string.send_him_gift_note), userSex);
        Activity pageActivity = this.f62094g.getPageContext().getPageActivity();
        NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
        if (!this.j) {
            string = format;
        }
        NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
        if (!this.j && TbadkApplication.getInst().isGiftSwitchOn()) {
            cVar = a2;
        }
        this.f62096i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.f62094g.getLayoutMode().k(skinType == 1);
        this.f62094g.getLayoutMode().j(inflate);
        this.f62096i.f(this.f62094g.getPageContext(), skinType);
        this.f62096i.setVisibility(0);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1670a getItem(int i2) {
        if (this.f62095h) {
            return null;
        }
        int itemId = (int) getItemId(i2);
        List<a.C1670a> list = this.f62093f;
        if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f62093f.size()) {
            return null;
        }
        return this.f62093f.get(itemId);
    }

    public void e(List<a.C1670a> list, int i2) {
        if (list != null && list.size() > 0) {
            this.f62095h = false;
        } else {
            this.f62095h = true;
        }
        this.f62093f = list;
        this.k = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f62095h) {
            return 1;
        }
        List<a.C1670a> list = this.f62093f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f62093f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1671b c1671b;
        if (this.f62095h) {
            return c();
        }
        if (view != null && view.getTag(R.id.tag_first) != null) {
            c1671b = (C1671b) view.getTag(R.id.tag_first);
        } else {
            view = LayoutInflater.from(this.f62094g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            c1671b = new C1671b(null);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
            c1671b.f62098a = tbImageView;
            tbImageView.setRadius(l.e(this.f62094g.getBaseContext(), 25.0f));
            c1671b.f62099b = (TextView) view.findViewById(R.id.item_rank_text);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1671b.f62100c = headImageView;
            headImageView.setRadius(l.e(this.f62094g.getBaseContext(), 50.0f));
            c1671b.f62100c.setOnClickListener(this.l);
            c1671b.f62100c.setPlaceHolder(1);
            c1671b.f62101d = (TextView) view.findViewById(R.id.user_name);
            c1671b.f62105h = (TextView) view.findViewById(R.id.gift_num);
            c1671b.f62104g = (TextView) view.findViewById(R.id.gift_value_text);
            c1671b.f62103f = (TextView) view.findViewById(R.id.gift_name);
            c1671b.f62102e = (TextView) view.findViewById(R.id.time);
            c1671b.f62106i = (TextView) view.findViewById(R.id.paly_icon);
            c1671b.j = (TextView) view.findViewById(R.id.reward_prefix);
            c1671b.k = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, c1671b);
        }
        if (!this.j) {
            c1671b.f62102e.setVisibility(8);
            c1671b.f62106i.setVisibility(8);
        } else {
            c1671b.f62106i.setVisibility(0);
        }
        a.C1670a item = getItem(i2);
        if (item != null) {
            if (this.f62094g.userType == 1) {
                c1671b.f62100c.V(item.f62080c, 12, false);
                int i3 = item.j;
                if (i3 == 1) {
                    c1671b.f62098a.setVisibility(0);
                    c1671b.f62098a.setImageResource(R.drawable.icon_frs_no1);
                    c1671b.f62099b.setVisibility(8);
                } else if (i3 == 2) {
                    c1671b.f62098a.setVisibility(0);
                    c1671b.f62098a.setImageResource(R.drawable.icon_frs_no2);
                    c1671b.f62099b.setVisibility(8);
                } else if (i3 == 3) {
                    c1671b.f62098a.setVisibility(0);
                    c1671b.f62098a.setImageResource(R.drawable.icon_frs_no3);
                    c1671b.f62099b.setVisibility(8);
                } else {
                    c1671b.f62098a.setVisibility(8);
                    c1671b.f62099b.setVisibility(0);
                    TextView textView = c1671b.f62099b;
                    textView.setText(item.j + "");
                }
            } else {
                c1671b.f62100c.V(item.f62081d, 10, false);
                c1671b.f62098a.setVisibility(8);
                c1671b.f62099b.setVisibility(8);
            }
            c1671b.f62100c.setDrawBorder(false);
            c1671b.f62101d.setText(TextUtils.isEmpty(item.k) ? item.f62079b : item.k);
            c1671b.f62100c.setTag(R.id.tag_first, Long.valueOf(item.f62078a));
            c1671b.f62100c.setTag(R.id.tag_second, item.f62079b);
            c1671b.f62103f.setText(this.f62094g.getPageContext().getString(R.string.send_to_you));
            TextView textView2 = c1671b.f62104g;
            textView2.setText(this.f62094g.getPageContext().getString(R.string.gift_value) + item.f62084g);
            if (item.f62083f < 1) {
                c1671b.f62105h.setVisibility(8);
            } else {
                TextView textView3 = c1671b.f62105h;
                textView3.setText(this.f62094g.getPageContext().getString(R.string.mutil_sign) + item.f62083f);
                c1671b.f62105h.setVisibility(0);
            }
            String formatTime = StringHelper.getFormatTime(item.f62082e * 1000);
            c1671b.f62102e.setText(formatTime);
            if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                c1671b.f62102e.setVisibility(8);
                c1671b.f62104g.setText(formatTime);
                SkinManager.setViewTextColor(c1671b.f62104g, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(c1671b.f62104g, R.color.CAM_X0301, 1);
            }
            c1671b.j.setVisibility(0);
            c1671b.k.setVisibility(0);
            if (item.f62085h > 0) {
                if (Integer.parseInt(item.f62086i) == 1) {
                    c1671b.k.setText(g.a(item.f62085h, 1, this.k));
                } else if (Integer.parseInt(item.f62086i) == 2) {
                    c1671b.k.setText(g.a(item.f62085h, 2, this.k));
                } else {
                    c1671b.j.setVisibility(8);
                    c1671b.k.setVisibility(8);
                }
            } else {
                c1671b.j.setVisibility(8);
                c1671b.k.setVisibility(8);
            }
        }
        b(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f62092e;
    }
}
