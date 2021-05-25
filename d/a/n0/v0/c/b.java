package d.a.n0.v0.c;

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
import d.a.n0.v0.b.g;
import d.a.n0.v0.c.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1683a> f62250f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f62251g;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f62253i;
    public boolean j;

    /* renamed from: e  reason: collision with root package name */
    public int f62249e = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62252h = false;
    public int k = -1;
    public View.OnClickListener l = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                b.this.f62251g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.f62251g.showToast(R.string.neterror);
        }
    }

    /* renamed from: d.a.n0.v0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1684b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62255a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62256b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f62257c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62258d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62259e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f62260f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f62261g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f62262h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f62263i;
        public TextView j;
        public TextView k;

        public C1684b() {
        }

        public /* synthetic */ C1684b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.f62251g = myGiftListActivity;
        this.j = z;
    }

    public final void b(View view) {
        this.f62251g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f62251g.getLayoutMode().j(view);
    }

    public final View c() {
        NoDataViewFactory.c cVar = null;
        View inflate = LayoutInflater.from(this.f62251g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f62251g.getResources().getString(R.string.send_gift), this.f62251g.getSendGiftClickListener()));
        this.f62251g.getResources().getDimension(R.dimen.tbds200);
        this.f62251g.getResources().getDimension(R.dimen.ds140);
        String userSex = this.f62251g.getUserSex();
        this.f62251g.getPageContext().getString(R.string.no_gift);
        String string = this.f62251g.getPageContext().getString(R.string.come_on);
        String format = String.format(this.f62251g.getPageContext().getString(R.string.send_him_gift_note), userSex);
        Activity pageActivity = this.f62251g.getPageContext().getPageActivity();
        NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
        if (!this.j) {
            string = format;
        }
        NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
        if (!this.j && TbadkApplication.getInst().isGiftSwitchOn()) {
            cVar = a2;
        }
        this.f62253i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.f62251g.getLayoutMode().k(skinType == 1);
        this.f62251g.getLayoutMode().j(inflate);
        this.f62253i.f(this.f62251g.getPageContext(), skinType);
        this.f62253i.setVisibility(0);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1683a getItem(int i2) {
        if (this.f62252h) {
            return null;
        }
        int itemId = (int) getItemId(i2);
        List<a.C1683a> list = this.f62250f;
        if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f62250f.size()) {
            return null;
        }
        return this.f62250f.get(itemId);
    }

    public void e(List<a.C1683a> list, int i2) {
        if (list != null && list.size() > 0) {
            this.f62252h = false;
        } else {
            this.f62252h = true;
        }
        this.f62250f = list;
        this.k = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f62252h) {
            return 1;
        }
        List<a.C1683a> list = this.f62250f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f62250f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1684b c1684b;
        if (this.f62252h) {
            return c();
        }
        if (view != null && view.getTag(R.id.tag_first) != null) {
            c1684b = (C1684b) view.getTag(R.id.tag_first);
        } else {
            view = LayoutInflater.from(this.f62251g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            c1684b = new C1684b(null);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
            c1684b.f62255a = tbImageView;
            tbImageView.setRadius(l.e(this.f62251g.getBaseContext(), 25.0f));
            c1684b.f62256b = (TextView) view.findViewById(R.id.item_rank_text);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1684b.f62257c = headImageView;
            headImageView.setRadius(l.e(this.f62251g.getBaseContext(), 50.0f));
            c1684b.f62257c.setOnClickListener(this.l);
            c1684b.f62257c.setPlaceHolder(1);
            c1684b.f62258d = (TextView) view.findViewById(R.id.user_name);
            c1684b.f62262h = (TextView) view.findViewById(R.id.gift_num);
            c1684b.f62261g = (TextView) view.findViewById(R.id.gift_value_text);
            c1684b.f62260f = (TextView) view.findViewById(R.id.gift_name);
            c1684b.f62259e = (TextView) view.findViewById(R.id.time);
            c1684b.f62263i = (TextView) view.findViewById(R.id.paly_icon);
            c1684b.j = (TextView) view.findViewById(R.id.reward_prefix);
            c1684b.k = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, c1684b);
        }
        if (!this.j) {
            c1684b.f62259e.setVisibility(8);
            c1684b.f62263i.setVisibility(8);
        } else {
            c1684b.f62263i.setVisibility(0);
        }
        a.C1683a item = getItem(i2);
        if (item != null) {
            if (this.f62251g.userType == 1) {
                c1684b.f62257c.V(item.f62237c, 12, false);
                int i3 = item.j;
                if (i3 == 1) {
                    c1684b.f62255a.setVisibility(0);
                    c1684b.f62255a.setImageResource(R.drawable.icon_frs_no1);
                    c1684b.f62256b.setVisibility(8);
                } else if (i3 == 2) {
                    c1684b.f62255a.setVisibility(0);
                    c1684b.f62255a.setImageResource(R.drawable.icon_frs_no2);
                    c1684b.f62256b.setVisibility(8);
                } else if (i3 == 3) {
                    c1684b.f62255a.setVisibility(0);
                    c1684b.f62255a.setImageResource(R.drawable.icon_frs_no3);
                    c1684b.f62256b.setVisibility(8);
                } else {
                    c1684b.f62255a.setVisibility(8);
                    c1684b.f62256b.setVisibility(0);
                    TextView textView = c1684b.f62256b;
                    textView.setText(item.j + "");
                }
            } else {
                c1684b.f62257c.V(item.f62238d, 10, false);
                c1684b.f62255a.setVisibility(8);
                c1684b.f62256b.setVisibility(8);
            }
            c1684b.f62257c.setDrawBorder(false);
            c1684b.f62258d.setText(TextUtils.isEmpty(item.k) ? item.f62236b : item.k);
            c1684b.f62257c.setTag(R.id.tag_first, Long.valueOf(item.f62235a));
            c1684b.f62257c.setTag(R.id.tag_second, item.f62236b);
            c1684b.f62260f.setText(this.f62251g.getPageContext().getString(R.string.send_to_you));
            TextView textView2 = c1684b.f62261g;
            textView2.setText(this.f62251g.getPageContext().getString(R.string.gift_value) + item.f62241g);
            if (item.f62240f < 1) {
                c1684b.f62262h.setVisibility(8);
            } else {
                TextView textView3 = c1684b.f62262h;
                textView3.setText(this.f62251g.getPageContext().getString(R.string.mutil_sign) + item.f62240f);
                c1684b.f62262h.setVisibility(0);
            }
            String formatTime = StringHelper.getFormatTime(item.f62239e * 1000);
            c1684b.f62259e.setText(formatTime);
            if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                c1684b.f62259e.setVisibility(8);
                c1684b.f62261g.setText(formatTime);
                SkinManager.setViewTextColor(c1684b.f62261g, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(c1684b.f62261g, R.color.CAM_X0301, 1);
            }
            c1684b.j.setVisibility(0);
            c1684b.k.setVisibility(0);
            if (item.f62242h > 0) {
                if (Integer.parseInt(item.f62243i) == 1) {
                    c1684b.k.setText(g.a(item.f62242h, 1, this.k));
                } else if (Integer.parseInt(item.f62243i) == 2) {
                    c1684b.k.setText(g.a(item.f62242h, 2, this.k));
                } else {
                    c1684b.j.setVisibility(8);
                    c1684b.k.setVisibility(8);
                }
            } else {
                c1684b.j.setVisibility(8);
                c1684b.k.setVisibility(8);
            }
        }
        b(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f62249e;
    }
}
