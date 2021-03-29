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
    public List<a.C1582a> f61046f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f61047g;
    public NoDataView i;
    public boolean j;

    /* renamed from: e  reason: collision with root package name */
    public int f61045e = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61048h = false;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                b.this.f61047g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.f61047g.showToast(R.string.neterror);
        }
    }

    /* renamed from: d.b.i0.t0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1583b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61050a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61051b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f61052c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61053d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61054e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f61055f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61056g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f61057h;
        public TextView i;
        public TextView j;
        public TextView k;

        public C1583b() {
        }

        public /* synthetic */ C1583b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.f61047g = myGiftListActivity;
        this.j = z;
    }

    public final void b(View view) {
        this.f61047g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f61047g.getLayoutMode().j(view);
    }

    public final View c() {
        NoDataViewFactory.c cVar = null;
        View inflate = LayoutInflater.from(this.f61047g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f61047g.getResources().getString(R.string.send_gift), this.f61047g.getSendGiftClickListener()));
        this.f61047g.getResources().getDimension(R.dimen.tbds200);
        this.f61047g.getResources().getDimension(R.dimen.ds140);
        String userSex = this.f61047g.getUserSex();
        this.f61047g.getPageContext().getString(R.string.no_gift);
        String string = this.f61047g.getPageContext().getString(R.string.come_on);
        String format = String.format(this.f61047g.getPageContext().getString(R.string.send_him_gift_note), userSex);
        Activity pageActivity = this.f61047g.getPageContext().getPageActivity();
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
        this.f61047g.getLayoutMode().k(skinType == 1);
        this.f61047g.getLayoutMode().j(inflate);
        this.i.f(this.f61047g.getPageContext(), skinType);
        this.i.setVisibility(0);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1582a getItem(int i) {
        if (this.f61048h) {
            return null;
        }
        int itemId = (int) getItemId(i);
        List<a.C1582a> list = this.f61046f;
        if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f61046f.size()) {
            return null;
        }
        return this.f61046f.get(itemId);
    }

    public void e(List<a.C1582a> list) {
        if (list != null && list.size() > 0) {
            this.f61048h = false;
        } else {
            this.f61048h = true;
        }
        this.f61046f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f61048h) {
            return 1;
        }
        List<a.C1582a> list = this.f61046f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f61046f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1583b c1583b;
        if (this.f61048h) {
            return c();
        }
        if (view != null && view.getTag(R.id.tag_first) != null) {
            c1583b = (C1583b) view.getTag(R.id.tag_first);
        } else {
            view = LayoutInflater.from(this.f61047g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            c1583b = new C1583b(null);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
            c1583b.f61050a = tbImageView;
            tbImageView.setRadius(l.e(this.f61047g.getBaseContext(), 25.0f));
            c1583b.f61051b = (TextView) view.findViewById(R.id.item_rank_text);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1583b.f61052c = headImageView;
            headImageView.setRadius(l.e(this.f61047g.getBaseContext(), 50.0f));
            c1583b.f61052c.setOnClickListener(this.k);
            c1583b.f61052c.setPlaceHolder(1);
            c1583b.f61053d = (TextView) view.findViewById(R.id.user_name);
            c1583b.f61057h = (TextView) view.findViewById(R.id.gift_num);
            c1583b.f61056g = (TextView) view.findViewById(R.id.gift_value_text);
            c1583b.f61055f = (TextView) view.findViewById(R.id.gift_name);
            c1583b.f61054e = (TextView) view.findViewById(R.id.time);
            c1583b.i = (TextView) view.findViewById(R.id.paly_icon);
            c1583b.j = (TextView) view.findViewById(R.id.reward_prefix);
            c1583b.k = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, c1583b);
        }
        if (!this.j) {
            c1583b.f61054e.setVisibility(8);
            c1583b.i.setVisibility(8);
        } else {
            c1583b.i.setVisibility(0);
        }
        a.C1582a item = getItem(i);
        if (item != null) {
            if (this.f61047g.userType == 1) {
                c1583b.f61052c.W(item.f61034c, 12, false);
                int i2 = item.j;
                if (i2 == 1) {
                    c1583b.f61050a.setVisibility(0);
                    c1583b.f61050a.setImageResource(R.drawable.icon_frs_no1);
                    c1583b.f61051b.setVisibility(8);
                } else if (i2 == 2) {
                    c1583b.f61050a.setVisibility(0);
                    c1583b.f61050a.setImageResource(R.drawable.icon_frs_no2);
                    c1583b.f61051b.setVisibility(8);
                } else if (i2 == 3) {
                    c1583b.f61050a.setVisibility(0);
                    c1583b.f61050a.setImageResource(R.drawable.icon_frs_no3);
                    c1583b.f61051b.setVisibility(8);
                } else {
                    c1583b.f61050a.setVisibility(8);
                    c1583b.f61051b.setVisibility(0);
                    TextView textView = c1583b.f61051b;
                    textView.setText(item.j + "");
                }
            } else {
                c1583b.f61052c.W(item.f61035d, 10, false);
                c1583b.f61050a.setVisibility(8);
                c1583b.f61051b.setVisibility(8);
            }
            c1583b.f61052c.setDrawBorder(false);
            c1583b.f61053d.setText(TextUtils.isEmpty(item.k) ? item.f61033b : item.k);
            c1583b.f61052c.setTag(R.id.tag_first, Long.valueOf(item.f61032a));
            c1583b.f61052c.setTag(R.id.tag_second, item.f61033b);
            c1583b.f61055f.setText(this.f61047g.getPageContext().getString(R.string.send_to_you));
            TextView textView2 = c1583b.f61056g;
            textView2.setText(this.f61047g.getPageContext().getString(R.string.gift_value) + item.f61038g);
            if (item.f61037f < 1) {
                c1583b.f61057h.setVisibility(8);
            } else {
                TextView textView3 = c1583b.f61057h;
                textView3.setText(this.f61047g.getPageContext().getString(R.string.mutil_sign) + item.f61037f);
                c1583b.f61057h.setVisibility(0);
            }
            c1583b.f61054e.setText(StringHelper.getFormatTime(item.f61036e * 1000));
            c1583b.j.setVisibility(0);
            c1583b.k.setVisibility(0);
            if (item.f61039h > 0) {
                if (Integer.parseInt(item.i) == 1) {
                    c1583b.k.setText(g.a(item.f61039h, 1));
                } else if (Integer.parseInt(item.i) == 2) {
                    c1583b.k.setText(g.a(item.f61039h, 2));
                } else {
                    c1583b.j.setVisibility(8);
                    c1583b.k.setVisibility(8);
                }
            } else {
                c1583b.j.setVisibility(8);
                c1583b.k.setVisibility(8);
            }
        }
        b(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f61045e;
    }
}
