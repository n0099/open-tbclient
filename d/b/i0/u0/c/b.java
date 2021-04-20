package d.b.i0.u0.c;

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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.u0.b.g;
import d.b.i0.u0.c.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1642a> f62735f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f62736g;
    public NoDataView i;
    public boolean j;

    /* renamed from: e  reason: collision with root package name */
    public int f62734e = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62737h = false;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                b.this.f62736g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.f62736g.showToast(R.string.neterror);
        }
    }

    /* renamed from: d.b.i0.u0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1643b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62739a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62740b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f62741c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62742d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62743e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f62744f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f62745g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f62746h;
        public TextView i;
        public TextView j;
        public TextView k;

        public C1643b() {
        }

        public /* synthetic */ C1643b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.f62736g = myGiftListActivity;
        this.j = z;
    }

    public final void b(View view) {
        this.f62736g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f62736g.getLayoutMode().j(view);
    }

    public final View c() {
        NoDataViewFactory.c cVar = null;
        View inflate = LayoutInflater.from(this.f62736g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f62736g.getResources().getString(R.string.send_gift), this.f62736g.getSendGiftClickListener()));
        this.f62736g.getResources().getDimension(R.dimen.tbds200);
        this.f62736g.getResources().getDimension(R.dimen.ds140);
        String userSex = this.f62736g.getUserSex();
        this.f62736g.getPageContext().getString(R.string.no_gift);
        String string = this.f62736g.getPageContext().getString(R.string.come_on);
        String format = String.format(this.f62736g.getPageContext().getString(R.string.send_him_gift_note), userSex);
        Activity pageActivity = this.f62736g.getPageContext().getPageActivity();
        NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
        if (!this.j) {
            string = format;
        }
        NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
        if (!this.j && TbadkApplication.getInst().isGiftSwitchOn()) {
            cVar = a2;
        }
        this.i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
        int skinType = TbadkApplication.getInst().getSkinType();
        this.f62736g.getLayoutMode().k(skinType == 1);
        this.f62736g.getLayoutMode().j(inflate);
        this.i.f(this.f62736g.getPageContext(), skinType);
        this.i.setVisibility(0);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1642a getItem(int i) {
        if (this.f62737h) {
            return null;
        }
        int itemId = (int) getItemId(i);
        List<a.C1642a> list = this.f62735f;
        if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f62735f.size()) {
            return null;
        }
        return this.f62735f.get(itemId);
    }

    public void e(List<a.C1642a> list) {
        if (list != null && list.size() > 0) {
            this.f62737h = false;
        } else {
            this.f62737h = true;
        }
        this.f62735f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f62737h) {
            return 1;
        }
        List<a.C1642a> list = this.f62735f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f62735f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1643b c1643b;
        if (this.f62737h) {
            return c();
        }
        if (view != null && view.getTag(R.id.tag_first) != null) {
            c1643b = (C1643b) view.getTag(R.id.tag_first);
        } else {
            view = LayoutInflater.from(this.f62736g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            c1643b = new C1643b(null);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
            c1643b.f62739a = tbImageView;
            tbImageView.setRadius(l.e(this.f62736g.getBaseContext(), 25.0f));
            c1643b.f62740b = (TextView) view.findViewById(R.id.item_rank_text);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1643b.f62741c = headImageView;
            headImageView.setRadius(l.e(this.f62736g.getBaseContext(), 50.0f));
            c1643b.f62741c.setOnClickListener(this.k);
            c1643b.f62741c.setPlaceHolder(1);
            c1643b.f62742d = (TextView) view.findViewById(R.id.user_name);
            c1643b.f62746h = (TextView) view.findViewById(R.id.gift_num);
            c1643b.f62745g = (TextView) view.findViewById(R.id.gift_value_text);
            c1643b.f62744f = (TextView) view.findViewById(R.id.gift_name);
            c1643b.f62743e = (TextView) view.findViewById(R.id.time);
            c1643b.i = (TextView) view.findViewById(R.id.paly_icon);
            c1643b.j = (TextView) view.findViewById(R.id.reward_prefix);
            c1643b.k = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, c1643b);
        }
        if (!this.j) {
            c1643b.f62743e.setVisibility(8);
            c1643b.i.setVisibility(8);
        } else {
            c1643b.i.setVisibility(0);
        }
        a.C1642a item = getItem(i);
        if (item != null) {
            if (this.f62736g.userType == 1) {
                c1643b.f62741c.W(item.f62723c, 12, false);
                int i2 = item.j;
                if (i2 == 1) {
                    c1643b.f62739a.setVisibility(0);
                    c1643b.f62739a.setImageResource(R.drawable.icon_frs_no1);
                    c1643b.f62740b.setVisibility(8);
                } else if (i2 == 2) {
                    c1643b.f62739a.setVisibility(0);
                    c1643b.f62739a.setImageResource(R.drawable.icon_frs_no2);
                    c1643b.f62740b.setVisibility(8);
                } else if (i2 == 3) {
                    c1643b.f62739a.setVisibility(0);
                    c1643b.f62739a.setImageResource(R.drawable.icon_frs_no3);
                    c1643b.f62740b.setVisibility(8);
                } else {
                    c1643b.f62739a.setVisibility(8);
                    c1643b.f62740b.setVisibility(0);
                    TextView textView = c1643b.f62740b;
                    textView.setText(item.j + "");
                }
            } else {
                c1643b.f62741c.W(item.f62724d, 10, false);
                c1643b.f62739a.setVisibility(8);
                c1643b.f62740b.setVisibility(8);
            }
            c1643b.f62741c.setDrawBorder(false);
            c1643b.f62742d.setText(TextUtils.isEmpty(item.k) ? item.f62722b : item.k);
            c1643b.f62741c.setTag(R.id.tag_first, Long.valueOf(item.f62721a));
            c1643b.f62741c.setTag(R.id.tag_second, item.f62722b);
            c1643b.f62744f.setText(this.f62736g.getPageContext().getString(R.string.send_to_you));
            TextView textView2 = c1643b.f62745g;
            textView2.setText(this.f62736g.getPageContext().getString(R.string.gift_value) + item.f62727g);
            if (item.f62726f < 1) {
                c1643b.f62746h.setVisibility(8);
            } else {
                TextView textView3 = c1643b.f62746h;
                textView3.setText(this.f62736g.getPageContext().getString(R.string.mutil_sign) + item.f62726f);
                c1643b.f62746h.setVisibility(0);
            }
            c1643b.f62743e.setText(StringHelper.getFormatTime(item.f62725e * 1000));
            c1643b.j.setVisibility(0);
            c1643b.k.setVisibility(0);
            if (item.f62728h > 0) {
                if (Integer.parseInt(item.i) == 1) {
                    c1643b.k.setText(g.a(item.f62728h, 1));
                } else if (Integer.parseInt(item.i) == 2) {
                    c1643b.k.setText(g.a(item.f62728h, 2));
                } else {
                    c1643b.j.setVisibility(8);
                    c1643b.k.setVisibility(8);
                }
            } else {
                c1643b.j.setVisibility(8);
                c1643b.k.setVisibility(8);
            }
        }
        b(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f62734e;
    }
}
