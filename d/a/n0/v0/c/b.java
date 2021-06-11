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
    public List<a.C1740a> f65965f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f65966g;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f65968i;
    public boolean j;

    /* renamed from: e  reason: collision with root package name */
    public int f65964e = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65967h = false;
    public int k = -1;
    public View.OnClickListener l = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                b.this.f65966g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.f65966g.showToast(R.string.neterror);
        }
    }

    /* renamed from: d.a.n0.v0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1741b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f65970a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f65971b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f65972c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65973d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f65974e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f65975f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65976g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f65977h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f65978i;
        public TextView j;
        public TextView k;

        public C1741b() {
        }

        public /* synthetic */ C1741b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.f65966g = myGiftListActivity;
        this.j = z;
    }

    public final void b(View view) {
        this.f65966g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f65966g.getLayoutMode().j(view);
    }

    public final View c() {
        NoDataViewFactory.c cVar = null;
        View inflate = LayoutInflater.from(this.f65966g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f65966g.getResources().getString(R.string.send_gift), this.f65966g.getSendGiftClickListener()));
        this.f65966g.getResources().getDimension(R.dimen.tbds200);
        this.f65966g.getResources().getDimension(R.dimen.ds140);
        String userSex = this.f65966g.getUserSex();
        this.f65966g.getPageContext().getString(R.string.no_gift);
        String string = this.f65966g.getPageContext().getString(R.string.come_on);
        String format = String.format(this.f65966g.getPageContext().getString(R.string.send_him_gift_note), userSex);
        Activity pageActivity = this.f65966g.getPageContext().getPageActivity();
        NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
        if (!this.j) {
            string = format;
        }
        NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
        if (!this.j && TbadkApplication.getInst().isGiftSwitchOn()) {
            cVar = a2;
        }
        this.f65968i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.f65966g.getLayoutMode().k(skinType == 1);
        this.f65966g.getLayoutMode().j(inflate);
        this.f65968i.f(this.f65966g.getPageContext(), skinType);
        this.f65968i.setVisibility(0);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1740a getItem(int i2) {
        if (this.f65967h) {
            return null;
        }
        int itemId = (int) getItemId(i2);
        List<a.C1740a> list = this.f65965f;
        if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f65965f.size()) {
            return null;
        }
        return this.f65965f.get(itemId);
    }

    public void e(List<a.C1740a> list, int i2) {
        if (list != null && list.size() > 0) {
            this.f65967h = false;
        } else {
            this.f65967h = true;
        }
        this.f65965f = list;
        this.k = i2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f65967h) {
            return 1;
        }
        List<a.C1740a> list = this.f65965f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f65965f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1741b c1741b;
        if (this.f65967h) {
            return c();
        }
        if (view != null && view.getTag(R.id.tag_first) != null) {
            c1741b = (C1741b) view.getTag(R.id.tag_first);
        } else {
            view = LayoutInflater.from(this.f65966g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            c1741b = new C1741b(null);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
            c1741b.f65970a = tbImageView;
            tbImageView.setRadius(l.e(this.f65966g.getBaseContext(), 25.0f));
            c1741b.f65971b = (TextView) view.findViewById(R.id.item_rank_text);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1741b.f65972c = headImageView;
            headImageView.setRadius(l.e(this.f65966g.getBaseContext(), 50.0f));
            c1741b.f65972c.setOnClickListener(this.l);
            c1741b.f65972c.setPlaceHolder(1);
            c1741b.f65973d = (TextView) view.findViewById(R.id.user_name);
            c1741b.f65977h = (TextView) view.findViewById(R.id.gift_num);
            c1741b.f65976g = (TextView) view.findViewById(R.id.gift_value_text);
            c1741b.f65975f = (TextView) view.findViewById(R.id.gift_name);
            c1741b.f65974e = (TextView) view.findViewById(R.id.time);
            c1741b.f65978i = (TextView) view.findViewById(R.id.paly_icon);
            c1741b.j = (TextView) view.findViewById(R.id.reward_prefix);
            c1741b.k = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, c1741b);
        }
        if (!this.j) {
            c1741b.f65974e.setVisibility(8);
            c1741b.f65978i.setVisibility(8);
        } else {
            c1741b.f65978i.setVisibility(0);
        }
        a.C1740a item = getItem(i2);
        if (item != null) {
            if (this.f65966g.userType == 1) {
                c1741b.f65972c.U(item.f65952c, 12, false);
                int i3 = item.j;
                if (i3 == 1) {
                    c1741b.f65970a.setVisibility(0);
                    c1741b.f65970a.setImageResource(R.drawable.icon_frs_no1);
                    c1741b.f65971b.setVisibility(8);
                } else if (i3 == 2) {
                    c1741b.f65970a.setVisibility(0);
                    c1741b.f65970a.setImageResource(R.drawable.icon_frs_no2);
                    c1741b.f65971b.setVisibility(8);
                } else if (i3 == 3) {
                    c1741b.f65970a.setVisibility(0);
                    c1741b.f65970a.setImageResource(R.drawable.icon_frs_no3);
                    c1741b.f65971b.setVisibility(8);
                } else {
                    c1741b.f65970a.setVisibility(8);
                    c1741b.f65971b.setVisibility(0);
                    TextView textView = c1741b.f65971b;
                    textView.setText(item.j + "");
                }
            } else {
                c1741b.f65972c.U(item.f65953d, 10, false);
                c1741b.f65970a.setVisibility(8);
                c1741b.f65971b.setVisibility(8);
            }
            c1741b.f65972c.setDrawBorder(false);
            c1741b.f65973d.setText(TextUtils.isEmpty(item.k) ? item.f65951b : item.k);
            c1741b.f65972c.setTag(R.id.tag_first, Long.valueOf(item.f65950a));
            c1741b.f65972c.setTag(R.id.tag_second, item.f65951b);
            c1741b.f65975f.setText(this.f65966g.getPageContext().getString(R.string.send_to_you));
            TextView textView2 = c1741b.f65976g;
            textView2.setText(this.f65966g.getPageContext().getString(R.string.gift_value) + item.f65956g);
            if (item.f65955f < 1) {
                c1741b.f65977h.setVisibility(8);
            } else {
                TextView textView3 = c1741b.f65977h;
                textView3.setText(this.f65966g.getPageContext().getString(R.string.mutil_sign) + item.f65955f);
                c1741b.f65977h.setVisibility(0);
            }
            String formatTime = StringHelper.getFormatTime(item.f65954e * 1000);
            c1741b.f65974e.setText(formatTime);
            if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                c1741b.f65974e.setVisibility(8);
                c1741b.f65976g.setText(formatTime);
                SkinManager.setViewTextColor(c1741b.f65976g, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(c1741b.f65976g, R.color.CAM_X0301, 1);
            }
            c1741b.j.setVisibility(0);
            c1741b.k.setVisibility(0);
            if (item.f65957h > 0) {
                if (Integer.parseInt(item.f65958i) == 1) {
                    c1741b.k.setText(g.a(item.f65957h, 1, this.k));
                } else if (Integer.parseInt(item.f65958i) == 2) {
                    c1741b.k.setText(g.a(item.f65957h, 2, this.k));
                } else {
                    c1741b.j.setVisibility(8);
                    c1741b.k.setVisibility(8);
                }
            } else {
                c1741b.j.setVisibility(8);
                c1741b.k.setVisibility(8);
            }
        }
        b(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f65964e;
    }
}
