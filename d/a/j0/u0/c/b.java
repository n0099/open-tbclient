package d.a.j0.u0.c;

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
import d.a.j0.u0.b.g;
import d.a.j0.u0.c.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1605a> f61369f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f61370g;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f61372i;
    public boolean j;

    /* renamed from: e  reason: collision with root package name */
    public int f61368e = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61371h = false;
    public int k = -1;
    public View.OnClickListener l = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                b.this.f61370g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.f61370g.showToast(R.string.neterror);
        }
    }

    /* renamed from: d.a.j0.u0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1606b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61374a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61375b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f61376c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61377d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61378e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f61379f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61380g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f61381h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f61382i;
        public TextView j;
        public TextView k;

        public C1606b() {
        }

        public /* synthetic */ C1606b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.f61370g = myGiftListActivity;
        this.j = z;
    }

    public final void b(View view) {
        this.f61370g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f61370g.getLayoutMode().j(view);
    }

    public final View c() {
        NoDataViewFactory.c cVar = null;
        View inflate = LayoutInflater.from(this.f61370g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f61370g.getResources().getString(R.string.send_gift), this.f61370g.getSendGiftClickListener()));
        this.f61370g.getResources().getDimension(R.dimen.tbds200);
        this.f61370g.getResources().getDimension(R.dimen.ds140);
        String userSex = this.f61370g.getUserSex();
        this.f61370g.getPageContext().getString(R.string.no_gift);
        String string = this.f61370g.getPageContext().getString(R.string.come_on);
        String format = String.format(this.f61370g.getPageContext().getString(R.string.send_him_gift_note), userSex);
        Activity pageActivity = this.f61370g.getPageContext().getPageActivity();
        NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
        if (!this.j) {
            string = format;
        }
        NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
        if (!this.j && TbadkApplication.getInst().isGiftSwitchOn()) {
            cVar = a2;
        }
        this.f61372i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.f61370g.getLayoutMode().k(skinType == 1);
        this.f61370g.getLayoutMode().j(inflate);
        this.f61372i.f(this.f61370g.getPageContext(), skinType);
        this.f61372i.setVisibility(0);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1605a getItem(int i2) {
        if (this.f61371h) {
            return null;
        }
        int itemId = (int) getItemId(i2);
        List<a.C1605a> list = this.f61369f;
        if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f61369f.size()) {
            return null;
        }
        return this.f61369f.get(itemId);
    }

    public void e(List<a.C1605a> list, int i2) {
        if (list != null && list.size() > 0) {
            this.f61371h = false;
        } else {
            this.f61371h = true;
        }
        this.f61369f = list;
        this.k = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f61371h) {
            return 1;
        }
        List<a.C1605a> list = this.f61369f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f61369f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1606b c1606b;
        if (this.f61371h) {
            return c();
        }
        if (view != null && view.getTag(R.id.tag_first) != null) {
            c1606b = (C1606b) view.getTag(R.id.tag_first);
        } else {
            view = LayoutInflater.from(this.f61370g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            c1606b = new C1606b(null);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
            c1606b.f61374a = tbImageView;
            tbImageView.setRadius(l.e(this.f61370g.getBaseContext(), 25.0f));
            c1606b.f61375b = (TextView) view.findViewById(R.id.item_rank_text);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1606b.f61376c = headImageView;
            headImageView.setRadius(l.e(this.f61370g.getBaseContext(), 50.0f));
            c1606b.f61376c.setOnClickListener(this.l);
            c1606b.f61376c.setPlaceHolder(1);
            c1606b.f61377d = (TextView) view.findViewById(R.id.user_name);
            c1606b.f61381h = (TextView) view.findViewById(R.id.gift_num);
            c1606b.f61380g = (TextView) view.findViewById(R.id.gift_value_text);
            c1606b.f61379f = (TextView) view.findViewById(R.id.gift_name);
            c1606b.f61378e = (TextView) view.findViewById(R.id.time);
            c1606b.f61382i = (TextView) view.findViewById(R.id.paly_icon);
            c1606b.j = (TextView) view.findViewById(R.id.reward_prefix);
            c1606b.k = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, c1606b);
        }
        if (!this.j) {
            c1606b.f61378e.setVisibility(8);
            c1606b.f61382i.setVisibility(8);
        } else {
            c1606b.f61382i.setVisibility(0);
        }
        a.C1605a item = getItem(i2);
        if (item != null) {
            if (this.f61370g.userType == 1) {
                c1606b.f61376c.V(item.f61356c, 12, false);
                int i3 = item.j;
                if (i3 == 1) {
                    c1606b.f61374a.setVisibility(0);
                    c1606b.f61374a.setImageResource(R.drawable.icon_frs_no1);
                    c1606b.f61375b.setVisibility(8);
                } else if (i3 == 2) {
                    c1606b.f61374a.setVisibility(0);
                    c1606b.f61374a.setImageResource(R.drawable.icon_frs_no2);
                    c1606b.f61375b.setVisibility(8);
                } else if (i3 == 3) {
                    c1606b.f61374a.setVisibility(0);
                    c1606b.f61374a.setImageResource(R.drawable.icon_frs_no3);
                    c1606b.f61375b.setVisibility(8);
                } else {
                    c1606b.f61374a.setVisibility(8);
                    c1606b.f61375b.setVisibility(0);
                    TextView textView = c1606b.f61375b;
                    textView.setText(item.j + "");
                }
            } else {
                c1606b.f61376c.V(item.f61357d, 10, false);
                c1606b.f61374a.setVisibility(8);
                c1606b.f61375b.setVisibility(8);
            }
            c1606b.f61376c.setDrawBorder(false);
            c1606b.f61377d.setText(TextUtils.isEmpty(item.k) ? item.f61355b : item.k);
            c1606b.f61376c.setTag(R.id.tag_first, Long.valueOf(item.f61354a));
            c1606b.f61376c.setTag(R.id.tag_second, item.f61355b);
            c1606b.f61379f.setText(this.f61370g.getPageContext().getString(R.string.send_to_you));
            TextView textView2 = c1606b.f61380g;
            textView2.setText(this.f61370g.getPageContext().getString(R.string.gift_value) + item.f61360g);
            if (item.f61359f < 1) {
                c1606b.f61381h.setVisibility(8);
            } else {
                TextView textView3 = c1606b.f61381h;
                textView3.setText(this.f61370g.getPageContext().getString(R.string.mutil_sign) + item.f61359f);
                c1606b.f61381h.setVisibility(0);
            }
            String formatTime = StringHelper.getFormatTime(item.f61358e * 1000);
            c1606b.f61378e.setText(formatTime);
            if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                c1606b.f61378e.setVisibility(8);
                c1606b.f61380g.setText(formatTime);
                SkinManager.setViewTextColor(c1606b.f61380g, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(c1606b.f61380g, R.color.CAM_X0301, 1);
            }
            c1606b.j.setVisibility(0);
            c1606b.k.setVisibility(0);
            if (item.f61361h > 0) {
                if (Integer.parseInt(item.f61362i) == 1) {
                    c1606b.k.setText(g.a(item.f61361h, 1, this.k));
                } else if (Integer.parseInt(item.f61362i) == 2) {
                    c1606b.k.setText(g.a(item.f61361h, 2, this.k));
                } else {
                    c1606b.j.setVisibility(8);
                    c1606b.k.setVisibility(8);
                }
            } else {
                c1606b.j.setVisibility(8);
                c1606b.k.setVisibility(8);
            }
        }
        b(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f61368e;
    }
}
