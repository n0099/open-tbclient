package d.b.i0.t0.c;

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
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.i0.t0.b.g;
import d.b.i0.t0.c.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1581a> f61045f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f61046g;
    public NoDataView i;
    public boolean j;

    /* renamed from: e  reason: collision with root package name */
    public int f61044e = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61047h = false;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                b.this.f61046g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.f61046g.showToast(R.string.neterror);
        }
    }

    /* renamed from: d.b.i0.t0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1582b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61049a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61050b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f61051c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61052d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61053e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f61054f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61055g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f61056h;
        public TextView i;
        public TextView j;
        public TextView k;

        public C1582b() {
        }

        public /* synthetic */ C1582b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.f61046g = myGiftListActivity;
        this.j = z;
    }

    public final void b(View view) {
        this.f61046g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f61046g.getLayoutMode().j(view);
    }

    public final View c() {
        NoDataViewFactory.c cVar = null;
        View inflate = LayoutInflater.from(this.f61046g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f61046g.getResources().getString(R.string.send_gift), this.f61046g.getSendGiftClickListener()));
        this.f61046g.getResources().getDimension(R.dimen.tbds200);
        this.f61046g.getResources().getDimension(R.dimen.ds140);
        String userSex = this.f61046g.getUserSex();
        this.f61046g.getPageContext().getString(R.string.no_gift);
        String string = this.f61046g.getPageContext().getString(R.string.come_on);
        String format = String.format(this.f61046g.getPageContext().getString(R.string.send_him_gift_note), userSex);
        Activity pageActivity = this.f61046g.getPageContext().getPageActivity();
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
        this.f61046g.getLayoutMode().k(skinType == 1);
        this.f61046g.getLayoutMode().j(inflate);
        this.i.f(this.f61046g.getPageContext(), skinType);
        this.i.setVisibility(0);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1581a getItem(int i) {
        if (this.f61047h) {
            return null;
        }
        int itemId = (int) getItemId(i);
        List<a.C1581a> list = this.f61045f;
        if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f61045f.size()) {
            return null;
        }
        return this.f61045f.get(itemId);
    }

    public void e(List<a.C1581a> list) {
        if (list != null && list.size() > 0) {
            this.f61047h = false;
        } else {
            this.f61047h = true;
        }
        this.f61045f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f61047h) {
            return 1;
        }
        List<a.C1581a> list = this.f61045f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f61045f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1582b c1582b;
        if (this.f61047h) {
            return c();
        }
        if (view != null && view.getTag(R.id.tag_first) != null) {
            c1582b = (C1582b) view.getTag(R.id.tag_first);
        } else {
            view = LayoutInflater.from(this.f61046g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            c1582b = new C1582b(null);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
            c1582b.f61049a = tbImageView;
            tbImageView.setRadius(l.e(this.f61046g.getBaseContext(), 25.0f));
            c1582b.f61050b = (TextView) view.findViewById(R.id.item_rank_text);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1582b.f61051c = headImageView;
            headImageView.setRadius(l.e(this.f61046g.getBaseContext(), 50.0f));
            c1582b.f61051c.setOnClickListener(this.k);
            c1582b.f61051c.setPlaceHolder(1);
            c1582b.f61052d = (TextView) view.findViewById(R.id.user_name);
            c1582b.f61056h = (TextView) view.findViewById(R.id.gift_num);
            c1582b.f61055g = (TextView) view.findViewById(R.id.gift_value_text);
            c1582b.f61054f = (TextView) view.findViewById(R.id.gift_name);
            c1582b.f61053e = (TextView) view.findViewById(R.id.time);
            c1582b.i = (TextView) view.findViewById(R.id.paly_icon);
            c1582b.j = (TextView) view.findViewById(R.id.reward_prefix);
            c1582b.k = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, c1582b);
        }
        if (!this.j) {
            c1582b.f61053e.setVisibility(8);
            c1582b.i.setVisibility(8);
        } else {
            c1582b.i.setVisibility(0);
        }
        a.C1581a item = getItem(i);
        if (item != null) {
            if (this.f61046g.userType == 1) {
                c1582b.f61051c.W(item.f61033c, 12, false);
                int i2 = item.j;
                if (i2 == 1) {
                    c1582b.f61049a.setVisibility(0);
                    c1582b.f61049a.setImageResource(R.drawable.icon_frs_no1);
                    c1582b.f61050b.setVisibility(8);
                } else if (i2 == 2) {
                    c1582b.f61049a.setVisibility(0);
                    c1582b.f61049a.setImageResource(R.drawable.icon_frs_no2);
                    c1582b.f61050b.setVisibility(8);
                } else if (i2 == 3) {
                    c1582b.f61049a.setVisibility(0);
                    c1582b.f61049a.setImageResource(R.drawable.icon_frs_no3);
                    c1582b.f61050b.setVisibility(8);
                } else {
                    c1582b.f61049a.setVisibility(8);
                    c1582b.f61050b.setVisibility(0);
                    TextView textView = c1582b.f61050b;
                    textView.setText(item.j + "");
                }
            } else {
                c1582b.f61051c.W(item.f61034d, 10, false);
                c1582b.f61049a.setVisibility(8);
                c1582b.f61050b.setVisibility(8);
            }
            c1582b.f61051c.setDrawBorder(false);
            c1582b.f61052d.setText(TextUtils.isEmpty(item.k) ? item.f61032b : item.k);
            c1582b.f61051c.setTag(R.id.tag_first, Long.valueOf(item.f61031a));
            c1582b.f61051c.setTag(R.id.tag_second, item.f61032b);
            c1582b.f61054f.setText(this.f61046g.getPageContext().getString(R.string.send_to_you));
            TextView textView2 = c1582b.f61055g;
            textView2.setText(this.f61046g.getPageContext().getString(R.string.gift_value) + item.f61037g);
            if (item.f61036f < 1) {
                c1582b.f61056h.setVisibility(8);
            } else {
                TextView textView3 = c1582b.f61056h;
                textView3.setText(this.f61046g.getPageContext().getString(R.string.mutil_sign) + item.f61036f);
                c1582b.f61056h.setVisibility(0);
            }
            c1582b.f61053e.setText(StringHelper.getFormatTime(item.f61035e * 1000));
            c1582b.j.setVisibility(0);
            c1582b.k.setVisibility(0);
            if (item.f61038h > 0) {
                if (Integer.parseInt(item.i) == 1) {
                    c1582b.k.setText(g.a(item.f61038h, 1));
                } else if (Integer.parseInt(item.i) == 2) {
                    c1582b.k.setText(g.a(item.f61038h, 2));
                } else {
                    c1582b.j.setVisibility(8);
                    c1582b.k.setVisibility(8);
                }
            } else {
                c1582b.j.setVisibility(8);
                c1582b.k.setVisibility(8);
            }
        }
        b(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f61044e;
    }
}
