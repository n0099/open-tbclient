package d.b.i0.z2;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignSingleModel;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes4.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.b {

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.z2.c f64287f;

    /* renamed from: g  reason: collision with root package name */
    public SignAllForumActivity f64288g;
    public boolean i;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f64286e = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, SignSingleModel> f64289h = new HashMap<>();
    public boolean j = true;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64290e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f64291f;

        public a(d dVar, c cVar) {
            this.f64290e = dVar;
            this.f64291f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f64290e.k()) {
                return;
            }
            this.f64291f.i.setVisibility(4);
            this.f64291f.j.setVisibility(0);
            this.f64291f.k.setText(R.string.signallforum_resigning);
            this.f64290e.t(true);
            SignSingleModel signSingleModel = new SignSingleModel(g.this.f64288g);
            signSingleModel.B(g.this);
            String str = this.f64290e.c() + "";
            synchronized (g.this) {
                g.this.f64289h.put(str, signSingleModel);
            }
            signSingleModel.C(this.f64290e.d(), str);
            TiebaStatic.log("signall_resign_click");
        }
    }

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f64293a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f64294b;

        public b(g gVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f64295a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f64296b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f64297c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f64298d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f64299e;

        /* renamed from: f  reason: collision with root package name */
        public FrameLayout f64300f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f64301g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f64302h;
        public ImageView i;
        public ProgressBar j;
        public TextView k;
        public TextView l;
        public TextView m;

        public c(g gVar) {
        }
    }

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.f64288g = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.b
    public void a(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.f64289h.remove(str);
        }
        i(str, true, signData, null);
    }

    public void d() {
        this.i = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.f64289h.entrySet()) {
                    entry.getValue().A();
                }
                this.f64289h.clear();
            }
        }
    }

    public final View e() {
        View inflate = LayoutInflater.from(this.f64288g.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.f64288g.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, this.f64288g.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.e.d(null, this.f64288g.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f64288g.getLayoutMode().k(skinType == 1);
        this.f64288g.getLayoutMode().j(inflate);
        a2.f(this.f64288g.getPageContext(), skinType);
        a2.setVisibility(0);
        a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return inflate;
    }

    public final View f(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.f64288g.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            c cVar = new c(this);
            BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            cVar.f64295a = barImageView;
            barImageView.setIsRound(false);
            cVar.f64295a.setGifIconSupport(false);
            cVar.f64297c = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            cVar.f64298d = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            cVar.f64299e = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            cVar.f64300f = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            cVar.f64301g = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            cVar.f64302h = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            cVar.i = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            cVar.j = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            cVar.k = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            cVar.l = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            cVar.f64296b = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            cVar.m = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(cVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.f64288g.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        b bVar = new b(this);
        bVar.f64293a = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        bVar.f64294b = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(bVar);
        return inflate2;
    }

    public final void g(View view, View view2, int i) {
        this.f64288g.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f64288g.getLayoutMode().j(view);
        c cVar = (c) view.getTag();
        d dVar = (d) getItem(i);
        if (dVar == null) {
            return;
        }
        String d2 = dVar.d();
        if (d2 != null && d2.length() > 8) {
            char[] charArray = d2.toCharArray();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= charArray.length) {
                    break;
                }
                i3 = StringUtils.isChinese(charArray[i2]) ? i3 + 2 : i3 + 1;
                if (i3 > 16) {
                    d2 = d2.substring(0, i2) + StringHelper.STRING_MORE;
                    break;
                }
                i2++;
            }
        }
        cVar.f64297c.setText(d2);
        SkinManager.setImageResource(cVar.f64298d, BitmapHelper.getSmallGradeResourceIdNew(dVar.i()));
        cVar.f64299e.setText(dVar.h() + "/" + dVar.g());
        cVar.m.clearAnimation();
        if (dVar.l()) {
            cVar.f64296b.setVisibility(0);
            cVar.l.setVisibility(8);
            cVar.f64301g.setVisibility(0);
            cVar.f64302h.setVisibility(8);
            cVar.f64301g.setText(String.format(this.f64288g.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.b())));
            if (dVar.m()) {
                cVar.f64299e.setText(this.f64288g.getPageContext().getString(R.string.signallforum_uplevel));
                cVar.m.setVisibility(8);
            } else {
                cVar.f64299e.setText(dVar.h() + "/" + dVar.g());
                cVar.m.setVisibility(0);
            }
            int e2 = dVar.e();
            if (e2 > 0) {
                cVar.m.setVisibility(0);
                cVar.m.setText("+" + e2);
            } else {
                cVar.m.setVisibility(8);
            }
        } else if (dVar.j()) {
            cVar.f64296b.setVisibility(0);
            cVar.l.setVisibility(8);
            cVar.m.setVisibility(8);
            cVar.f64301g.setVisibility(8);
            cVar.f64302h.setVisibility(0);
            if (dVar.k()) {
                cVar.i.setVisibility(4);
                cVar.j.setVisibility(0);
                cVar.k.setText(R.string.signallforum_resigning);
            } else {
                cVar.i.setVisibility(0);
                cVar.j.setVisibility(4);
                cVar.k.setText(R.string.signallforum_resign);
            }
            cVar.f64302h.setOnClickListener(new a(dVar, cVar));
        } else {
            cVar.f64301g.setVisibility(8);
            cVar.f64302h.setVisibility(8);
            cVar.m.setVisibility(8);
            cVar.f64296b.setVisibility(0);
            cVar.l.setVisibility(8);
        }
        String a2 = dVar.a();
        cVar.f64295a.setTag(a2);
        cVar.f64295a.setPlaceHolder(1);
        cVar.f64295a.W(a2, 10, false);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.j) {
            return this.f64286e.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f64286e.size() > i) {
            return this.f64286e.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof d.b.i0.z2.b ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (!this.j) {
            return e();
        }
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = f(itemViewType);
        }
        if (itemViewType == 1) {
            if (view.getTag() != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            } else {
                view = f(itemViewType);
                bVar = (b) view.getTag();
            }
            this.f64288g.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f64288g.getLayoutMode().j(view.findViewById(R.id.sign_all_forum_tip));
            bVar.f64293a.setText(((d.b.i0.z2.b) getItem(i)).x());
            j(bVar.f64294b, i);
        } else {
            if (view.getTag() == null || !(view.getTag() instanceof c)) {
                view = f(itemViewType);
            }
            g(view, viewGroup, i);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void h(d.b.i0.z2.c cVar) {
        if (cVar == null) {
            return;
        }
        this.f64287f = cVar;
        ArrayList<d> k = cVar.k();
        this.f64286e = k;
        if (k.size() == 0) {
            this.j = false;
        } else {
            this.j = true;
        }
        notifyDataSetChanged();
    }

    public final void i(String str, boolean z, SignData signData, String str2) {
        int size = this.f64286e.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.f64286e.get(i);
            if ((dVar.c() + "").equals(str)) {
                dVar.u(z);
                dVar.s(!z);
                dVar.t(false);
                if (z) {
                    dVar.o(signData.count_sign_num);
                    dVar.q(signData.sign_bonus_point);
                    dVar.r(1);
                    TbadkApplication.getInst().addSignedForum(dVar.d(), signData.sign_bonus_point, -1);
                    ArrayList<d> x = this.f64287f.x();
                    if (x.contains(dVar)) {
                        x.remove(dVar);
                        this.f64287f.r().add(dVar);
                    }
                } else {
                    dVar.p(str2);
                }
                if (this.i) {
                    return;
                }
                notifyDataSetChanged();
                return;
            }
        }
    }

    public final void j(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        d.b.i0.z2.c cVar = this.f64287f;
        int l = cVar == null ? 7 : cVar.l();
        ArrayList<d> arrayList = this.f64286e;
        if (arrayList == null || arrayList.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.f64286e.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.d())) {
                    if (next.i() >= l) {
                        if (next.l()) {
                            i2++;
                        } else {
                            i3++;
                        }
                    } else if (next.l()) {
                        i4++;
                    } else {
                        i5++;
                    }
                }
            }
        }
        if (i == 0 && i2 + i3 > 0) {
            format = String.format(this.f64288g.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            format = String.format(this.f64288g.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i4), Integer.valueOf(i5));
        }
        textView.setText(format);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.b
    public void onError(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.L(this.f64288g.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.f64289h.remove(str);
        }
        i(str, false, null, str2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            notifyDataSetChanged();
        }
    }
}
