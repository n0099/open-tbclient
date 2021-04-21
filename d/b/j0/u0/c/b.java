package d.b.j0.u0.c;

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
import d.b.j0.u0.b.g;
import d.b.j0.u0.c.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1665a> f63156f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f63157g;
    public NoDataView i;
    public boolean j;

    /* renamed from: e  reason: collision with root package name */
    public int f63155e = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63158h = false;
    public View.OnClickListener k = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                b.this.f63157g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                return;
            }
            b.this.f63157g.showToast(R.string.neterror);
        }
    }

    /* renamed from: d.b.j0.u0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1666b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f63160a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63161b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f63162c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63163d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63164e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f63165f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f63166g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f63167h;
        public TextView i;
        public TextView j;
        public TextView k;

        public C1666b() {
        }

        public /* synthetic */ C1666b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        this.f63157g = myGiftListActivity;
        this.j = z;
    }

    public final void b(View view) {
        this.f63157g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f63157g.getLayoutMode().j(view);
    }

    public final View c() {
        NoDataViewFactory.c cVar = null;
        View inflate = LayoutInflater.from(this.f63157g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
        NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f63157g.getResources().getString(R.string.send_gift), this.f63157g.getSendGiftClickListener()));
        this.f63157g.getResources().getDimension(R.dimen.tbds200);
        this.f63157g.getResources().getDimension(R.dimen.ds140);
        String userSex = this.f63157g.getUserSex();
        this.f63157g.getPageContext().getString(R.string.no_gift);
        String string = this.f63157g.getPageContext().getString(R.string.come_on);
        String format = String.format(this.f63157g.getPageContext().getString(R.string.send_him_gift_note), userSex);
        Activity pageActivity = this.f63157g.getPageContext().getPageActivity();
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
        this.f63157g.getLayoutMode().k(skinType == 1);
        this.f63157g.getLayoutMode().j(inflate);
        this.i.f(this.f63157g.getPageContext(), skinType);
        this.i.setVisibility(0);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1665a getItem(int i) {
        if (this.f63158h) {
            return null;
        }
        int itemId = (int) getItemId(i);
        List<a.C1665a> list = this.f63156f;
        if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f63156f.size()) {
            return null;
        }
        return this.f63156f.get(itemId);
    }

    public void e(List<a.C1665a> list) {
        if (list != null && list.size() > 0) {
            this.f63158h = false;
        } else {
            this.f63158h = true;
        }
        this.f63156f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f63158h) {
            return 1;
        }
        List<a.C1665a> list = this.f63156f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f63156f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1666b c1666b;
        if (this.f63158h) {
            return c();
        }
        if (view != null && view.getTag(R.id.tag_first) != null) {
            c1666b = (C1666b) view.getTag(R.id.tag_first);
        } else {
            view = LayoutInflater.from(this.f63157g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
            c1666b = new C1666b(null);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
            c1666b.f63160a = tbImageView;
            tbImageView.setRadius(l.e(this.f63157g.getBaseContext(), 25.0f));
            c1666b.f63161b = (TextView) view.findViewById(R.id.item_rank_text);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
            c1666b.f63162c = headImageView;
            headImageView.setRadius(l.e(this.f63157g.getBaseContext(), 50.0f));
            c1666b.f63162c.setOnClickListener(this.k);
            c1666b.f63162c.setPlaceHolder(1);
            c1666b.f63163d = (TextView) view.findViewById(R.id.user_name);
            c1666b.f63167h = (TextView) view.findViewById(R.id.gift_num);
            c1666b.f63166g = (TextView) view.findViewById(R.id.gift_value_text);
            c1666b.f63165f = (TextView) view.findViewById(R.id.gift_name);
            c1666b.f63164e = (TextView) view.findViewById(R.id.time);
            c1666b.i = (TextView) view.findViewById(R.id.paly_icon);
            c1666b.j = (TextView) view.findViewById(R.id.reward_prefix);
            c1666b.k = (TextView) view.findViewById(R.id.reward_num);
            view.setTag(R.id.tag_first, c1666b);
        }
        if (!this.j) {
            c1666b.f63164e.setVisibility(8);
            c1666b.i.setVisibility(8);
        } else {
            c1666b.i.setVisibility(0);
        }
        a.C1665a item = getItem(i);
        if (item != null) {
            if (this.f63157g.userType == 1) {
                c1666b.f63162c.W(item.f63144c, 12, false);
                int i2 = item.j;
                if (i2 == 1) {
                    c1666b.f63160a.setVisibility(0);
                    c1666b.f63160a.setImageResource(R.drawable.icon_frs_no1);
                    c1666b.f63161b.setVisibility(8);
                } else if (i2 == 2) {
                    c1666b.f63160a.setVisibility(0);
                    c1666b.f63160a.setImageResource(R.drawable.icon_frs_no2);
                    c1666b.f63161b.setVisibility(8);
                } else if (i2 == 3) {
                    c1666b.f63160a.setVisibility(0);
                    c1666b.f63160a.setImageResource(R.drawable.icon_frs_no3);
                    c1666b.f63161b.setVisibility(8);
                } else {
                    c1666b.f63160a.setVisibility(8);
                    c1666b.f63161b.setVisibility(0);
                    TextView textView = c1666b.f63161b;
                    textView.setText(item.j + "");
                }
            } else {
                c1666b.f63162c.W(item.f63145d, 10, false);
                c1666b.f63160a.setVisibility(8);
                c1666b.f63161b.setVisibility(8);
            }
            c1666b.f63162c.setDrawBorder(false);
            c1666b.f63163d.setText(TextUtils.isEmpty(item.k) ? item.f63143b : item.k);
            c1666b.f63162c.setTag(R.id.tag_first, Long.valueOf(item.f63142a));
            c1666b.f63162c.setTag(R.id.tag_second, item.f63143b);
            c1666b.f63165f.setText(this.f63157g.getPageContext().getString(R.string.send_to_you));
            TextView textView2 = c1666b.f63166g;
            textView2.setText(this.f63157g.getPageContext().getString(R.string.gift_value) + item.f63148g);
            if (item.f63147f < 1) {
                c1666b.f63167h.setVisibility(8);
            } else {
                TextView textView3 = c1666b.f63167h;
                textView3.setText(this.f63157g.getPageContext().getString(R.string.mutil_sign) + item.f63147f);
                c1666b.f63167h.setVisibility(0);
            }
            c1666b.f63164e.setText(StringHelper.getFormatTime(item.f63146e * 1000));
            c1666b.j.setVisibility(0);
            c1666b.k.setVisibility(0);
            if (item.f63149h > 0) {
                if (Integer.parseInt(item.i) == 1) {
                    c1666b.k.setText(g.a(item.f63149h, 1));
                } else if (Integer.parseInt(item.i) == 2) {
                    c1666b.k.setText(g.a(item.f63149h, 2));
                } else {
                    c1666b.j.setVisibility(8);
                    c1666b.k.setVisibility(8);
                }
            } else {
                c1666b.j.setVisibility(8);
                c1666b.k.setVisibility(8);
            }
        }
        b(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.f63155e;
    }
}
