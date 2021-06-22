package d.a.o0.v0.c;

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
import d.a.o0.v0.b.g;
import d.a.o0.v0.c.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1744a> f66090f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f66091g;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f66093i;
    public boolean j;

    /* renamed from: e  reason: collision with root package name */
    public int f66089e = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66092h = false;
    public int k = -1;
    public View.OnClickListener l = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                b.this.f66091g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.f66091g.showToast(R.string.neterror);
        }
    }

    /* renamed from: d.a.o0.v0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1745b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f66095a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f66096b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f66097c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f66098d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f66099e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f66100f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f66101g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f66102h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f66103i;
        public TextView j;
        public TextView k;

        public C1745b() {
        }

        public /* synthetic */ C1745b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.f66091g = myGiftListActivity;
        this.j = z;
    }

    public final void b(View view) {
        this.f66091g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f66091g.getLayoutMode().j(view);
    }

    public final View c() {
        NoDataViewFactory.c cVar = null;
        View inflate = LayoutInflater.from(this.f66091g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f66091g.getResources().getString(R.string.send_gift), this.f66091g.getSendGiftClickListener()));
        this.f66091g.getResources().getDimension(R.dimen.tbds200);
        this.f66091g.getResources().getDimension(R.dimen.ds140);
        String userSex = this.f66091g.getUserSex();
        this.f66091g.getPageContext().getString(R.string.no_gift);
        String string = this.f66091g.getPageContext().getString(R.string.come_on);
        String format = String.format(this.f66091g.getPageContext().getString(R.string.send_him_gift_note), userSex);
        Activity pageActivity = this.f66091g.getPageContext().getPageActivity();
        NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
        if (!this.j) {
            string = format;
        }
        NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
        if (!this.j && TbadkApplication.getInst().isGiftSwitchOn()) {
            cVar = a2;
        }
        this.f66093i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.f66091g.getLayoutMode().k(skinType == 1);
        this.f66091g.getLayoutMode().j(inflate);
        this.f66093i.f(this.f66091g.getPageContext(), skinType);
        this.f66093i.setVisibility(0);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1744a getItem(int i2) {
        if (this.f66092h) {
            return null;
        }
        int itemId = (int) getItemId(i2);
        List<a.C1744a> list = this.f66090f;
        if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f66090f.size()) {
            return null;
        }
        return this.f66090f.get(itemId);
    }

    public void e(List<a.C1744a> list, int i2) {
        if (list != null && list.size() > 0) {
            this.f66092h = false;
        } else {
            this.f66092h = true;
        }
        this.f66090f = list;
        this.k = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f66092h) {
            return 1;
        }
        List<a.C1744a> list = this.f66090f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f66090f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1745b c1745b;
        if (this.f66092h) {
            return c();
        }
        if (view != null && view.getTag(R.id.tag_first) != null) {
            c1745b = (C1745b) view.getTag(R.id.tag_first);
        } else {
            view = LayoutInflater.from(this.f66091g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            c1745b = new C1745b(null);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
            c1745b.f66095a = tbImageView;
            tbImageView.setRadius(l.e(this.f66091g.getBaseContext(), 25.0f));
            c1745b.f66096b = (TextView) view.findViewById(R.id.item_rank_text);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1745b.f66097c = headImageView;
            headImageView.setRadius(l.e(this.f66091g.getBaseContext(), 50.0f));
            c1745b.f66097c.setOnClickListener(this.l);
            c1745b.f66097c.setPlaceHolder(1);
            c1745b.f66098d = (TextView) view.findViewById(R.id.user_name);
            c1745b.f66102h = (TextView) view.findViewById(R.id.gift_num);
            c1745b.f66101g = (TextView) view.findViewById(R.id.gift_value_text);
            c1745b.f66100f = (TextView) view.findViewById(R.id.gift_name);
            c1745b.f66099e = (TextView) view.findViewById(R.id.time);
            c1745b.f66103i = (TextView) view.findViewById(R.id.paly_icon);
            c1745b.j = (TextView) view.findViewById(R.id.reward_prefix);
            c1745b.k = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, c1745b);
        }
        if (!this.j) {
            c1745b.f66099e.setVisibility(8);
            c1745b.f66103i.setVisibility(8);
        } else {
            c1745b.f66103i.setVisibility(0);
        }
        a.C1744a item = getItem(i2);
        if (item != null) {
            if (this.f66091g.userType == 1) {
                c1745b.f66097c.U(item.f66077c, 12, false);
                int i3 = item.j;
                if (i3 == 1) {
                    c1745b.f66095a.setVisibility(0);
                    c1745b.f66095a.setImageResource(R.drawable.icon_frs_no1);
                    c1745b.f66096b.setVisibility(8);
                } else if (i3 == 2) {
                    c1745b.f66095a.setVisibility(0);
                    c1745b.f66095a.setImageResource(R.drawable.icon_frs_no2);
                    c1745b.f66096b.setVisibility(8);
                } else if (i3 == 3) {
                    c1745b.f66095a.setVisibility(0);
                    c1745b.f66095a.setImageResource(R.drawable.icon_frs_no3);
                    c1745b.f66096b.setVisibility(8);
                } else {
                    c1745b.f66095a.setVisibility(8);
                    c1745b.f66096b.setVisibility(0);
                    TextView textView = c1745b.f66096b;
                    textView.setText(item.j + "");
                }
            } else {
                c1745b.f66097c.U(item.f66078d, 10, false);
                c1745b.f66095a.setVisibility(8);
                c1745b.f66096b.setVisibility(8);
            }
            c1745b.f66097c.setDrawBorder(false);
            c1745b.f66098d.setText(TextUtils.isEmpty(item.k) ? item.f66076b : item.k);
            c1745b.f66097c.setTag(R.id.tag_first, Long.valueOf(item.f66075a));
            c1745b.f66097c.setTag(R.id.tag_second, item.f66076b);
            c1745b.f66100f.setText(this.f66091g.getPageContext().getString(R.string.send_to_you));
            TextView textView2 = c1745b.f66101g;
            textView2.setText(this.f66091g.getPageContext().getString(R.string.gift_value) + item.f66081g);
            if (item.f66080f < 1) {
                c1745b.f66102h.setVisibility(8);
            } else {
                TextView textView3 = c1745b.f66102h;
                textView3.setText(this.f66091g.getPageContext().getString(R.string.mutil_sign) + item.f66080f);
                c1745b.f66102h.setVisibility(0);
            }
            String formatTime = StringHelper.getFormatTime(item.f66079e * 1000);
            c1745b.f66099e.setText(formatTime);
            if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                c1745b.f66099e.setVisibility(8);
                c1745b.f66101g.setText(formatTime);
                SkinManager.setViewTextColor(c1745b.f66101g, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(c1745b.f66101g, R.color.CAM_X0301, 1);
            }
            c1745b.j.setVisibility(0);
            c1745b.k.setVisibility(0);
            if (item.f66082h > 0) {
                if (Integer.parseInt(item.f66083i) == 1) {
                    c1745b.k.setText(g.a(item.f66082h, 1, this.k));
                } else if (Integer.parseInt(item.f66083i) == 2) {
                    c1745b.k.setText(g.a(item.f66082h, 2, this.k));
                } else {
                    c1745b.j.setVisibility(8);
                    c1745b.k.setVisibility(8);
                }
            } else {
                c1745b.j.setVisibility(8);
                c1745b.k.setVisibility(8);
            }
        }
        b(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f66089e;
    }
}
