package d.a.j0.z2;

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
import com.google.android.material.badge.BadgeDrawable;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.b {

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.z2.c f62995f;

    /* renamed from: g  reason: collision with root package name */
    public SignAllForumActivity f62996g;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62998i;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f62994e = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, SignSingleModel> f62997h = new HashMap<>();
    public boolean j = true;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62999e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f63000f;

        public a(d dVar, c cVar) {
            this.f62999e = dVar;
            this.f63000f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f62999e.k()) {
                return;
            }
            this.f63000f.f63012i.setVisibility(4);
            this.f63000f.j.setVisibility(0);
            this.f63000f.k.setText(R.string.signallforum_resigning);
            this.f62999e.t(true);
            SignSingleModel signSingleModel = new SignSingleModel(g.this.f62996g);
            signSingleModel.B(g.this);
            String str = this.f62999e.c() + "";
            synchronized (g.this) {
                g.this.f62997h.put(str, signSingleModel);
            }
            signSingleModel.C(this.f62999e.d(), str);
            TiebaStatic.log("signall_resign_click");
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f63002a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63003b;

        public b(g gVar) {
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f63004a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f63005b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63006c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f63007d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63008e;

        /* renamed from: f  reason: collision with root package name */
        public FrameLayout f63009f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f63010g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f63011h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f63012i;
        public ProgressBar j;
        public TextView k;
        public TextView l;
        public TextView m;

        public c(g gVar) {
        }
    }

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.f62996g = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.b
    public void a(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.f62997h.remove(str);
        }
        i(str, true, signData, null);
    }

    public void d() {
        this.f62998i = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.f62997h.entrySet()) {
                    entry.getValue().A();
                }
                this.f62997h.clear();
            }
        }
    }

    public final View e() {
        View inflate = LayoutInflater.from(this.f62996g.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.f62996g.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, this.f62996g.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.e.d(null, this.f62996g.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f62996g.getLayoutMode().k(skinType == 1);
        this.f62996g.getLayoutMode().j(inflate);
        a2.f(this.f62996g.getPageContext(), skinType);
        a2.setVisibility(0);
        a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return inflate;
    }

    public final View f(int i2) {
        if (i2 == 0) {
            View inflate = LayoutInflater.from(this.f62996g.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            c cVar = new c(this);
            BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            cVar.f63004a = barImageView;
            barImageView.setIsRound(false);
            cVar.f63004a.setGifIconSupport(false);
            cVar.f63006c = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            cVar.f63007d = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            cVar.f63008e = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            cVar.f63009f = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            cVar.f63010g = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            cVar.f63011h = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            cVar.f63012i = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            cVar.j = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            cVar.k = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            cVar.l = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            cVar.f63005b = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            cVar.m = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(cVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.f62996g.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        b bVar = new b(this);
        bVar.f63002a = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        bVar.f63003b = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(bVar);
        return inflate2;
    }

    public final void g(View view, View view2, int i2) {
        this.f62996g.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f62996g.getLayoutMode().j(view);
        c cVar = (c) view.getTag();
        d dVar = (d) getItem(i2);
        if (dVar == null) {
            return;
        }
        String d2 = dVar.d();
        if (d2 != null && d2.length() > 8) {
            char[] charArray = d2.toCharArray();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= charArray.length) {
                    break;
                }
                i4 = StringUtils.isChinese(charArray[i3]) ? i4 + 2 : i4 + 1;
                if (i4 > 16) {
                    d2 = d2.substring(0, i3) + StringHelper.STRING_MORE;
                    break;
                }
                i3++;
            }
        }
        cVar.f63006c.setText(d2);
        SkinManager.setImageResource(cVar.f63007d, BitmapHelper.getSmallGradeResourceIdNew(dVar.i()));
        cVar.f63008e.setText(dVar.h() + "/" + dVar.g());
        cVar.m.clearAnimation();
        if (dVar.l()) {
            cVar.f63005b.setVisibility(0);
            cVar.l.setVisibility(8);
            cVar.f63010g.setVisibility(0);
            cVar.f63011h.setVisibility(8);
            cVar.f63010g.setText(String.format(this.f62996g.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.b())));
            if (dVar.m()) {
                cVar.f63008e.setText(this.f62996g.getPageContext().getString(R.string.signallforum_uplevel));
                cVar.m.setVisibility(8);
            } else {
                cVar.f63008e.setText(dVar.h() + "/" + dVar.g());
                cVar.m.setVisibility(0);
            }
            int e2 = dVar.e();
            if (e2 > 0) {
                cVar.m.setVisibility(0);
                cVar.m.setText(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + e2);
            } else {
                cVar.m.setVisibility(8);
            }
        } else if (dVar.j()) {
            cVar.f63005b.setVisibility(0);
            cVar.l.setVisibility(8);
            cVar.m.setVisibility(8);
            cVar.f63010g.setVisibility(8);
            cVar.f63011h.setVisibility(0);
            if (dVar.k()) {
                cVar.f63012i.setVisibility(4);
                cVar.j.setVisibility(0);
                cVar.k.setText(R.string.signallforum_resigning);
            } else {
                cVar.f63012i.setVisibility(0);
                cVar.j.setVisibility(4);
                cVar.k.setText(R.string.signallforum_resign);
            }
            cVar.f63011h.setOnClickListener(new a(dVar, cVar));
        } else {
            cVar.f63010g.setVisibility(8);
            cVar.f63011h.setVisibility(8);
            cVar.m.setVisibility(8);
            cVar.f63005b.setVisibility(0);
            cVar.l.setVisibility(8);
        }
        String a2 = dVar.a();
        cVar.f63004a.setTag(a2);
        cVar.f63004a.setPlaceHolder(1);
        cVar.f63004a.V(a2, 10, false);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.j) {
            return this.f62994e.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        if (this.f62994e.size() > i2) {
            return this.f62994e.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return getItem(i2) instanceof d.a.j0.z2.b ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (!this.j) {
            return e();
        }
        int itemViewType = getItemViewType(i2);
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
            this.f62996g.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f62996g.getLayoutMode().j(view.findViewById(R.id.sign_all_forum_tip));
            bVar.f63002a.setText(((d.a.j0.z2.b) getItem(i2)).x());
            j(bVar.f63003b, i2);
        } else {
            if (view.getTag() == null || !(view.getTag() instanceof c)) {
                view = f(itemViewType);
            }
            g(view, viewGroup, i2);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void h(d.a.j0.z2.c cVar) {
        if (cVar == null) {
            return;
        }
        this.f62995f = cVar;
        ArrayList<d> k = cVar.k();
        this.f62994e = k;
        if (k.size() == 0) {
            this.j = false;
        } else {
            this.j = true;
        }
        notifyDataSetChanged();
    }

    public final void i(String str, boolean z, SignData signData, String str2) {
        int size = this.f62994e.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = this.f62994e.get(i2);
            if ((dVar.c() + "").equals(str)) {
                dVar.u(z);
                dVar.s(!z);
                dVar.t(false);
                if (z) {
                    dVar.o(signData.count_sign_num);
                    dVar.q(signData.sign_bonus_point);
                    dVar.r(1);
                    TbadkApplication.getInst().addSignedForum(dVar.d(), signData.sign_bonus_point, -1);
                    ArrayList<d> x = this.f62995f.x();
                    if (x.contains(dVar)) {
                        x.remove(dVar);
                        this.f62995f.r().add(dVar);
                    }
                } else {
                    dVar.p(str2);
                }
                if (this.f62998i) {
                    return;
                }
                notifyDataSetChanged();
                return;
            }
        }
    }

    public final void j(TextView textView, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        String format;
        d.a.j0.z2.c cVar = this.f62995f;
        int l = cVar == null ? 7 : cVar.l();
        ArrayList<d> arrayList = this.f62994e;
        if (arrayList == null || arrayList.size() <= 0) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        } else {
            Iterator<d> it = this.f62994e.iterator();
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.d())) {
                    if (next.i() >= l) {
                        if (next.l()) {
                            i3++;
                        } else {
                            i4++;
                        }
                    } else if (next.l()) {
                        i5++;
                    } else {
                        i6++;
                    }
                }
            }
        }
        if (i2 == 0 && i3 + i4 > 0) {
            format = String.format(this.f62996g.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i4));
        } else {
            format = String.format(this.f62996g.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i6));
        }
        textView.setText(format);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.b
    public void onError(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.M(this.f62996g.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.f62997h.remove(str);
        }
        i(str, false, null, str2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 0) {
            notifyDataSetChanged();
        }
    }
}
