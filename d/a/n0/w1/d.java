package d.a.n0.w1;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton;
import com.baidu.tieba.myAttentionAndFans.PersonListActivity;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.q.g1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class d extends d.a.n0.w1.b {

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f66216h;
    public boolean j;
    public boolean k;
    public int l;
    public String m;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66217i = false;
    public HashSet<Long> n = new HashSet<>();
    public NewMyFansUserLikeButton.b r = new b();

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66218e;

        public a(c cVar) {
            this.f66218e = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f66218e.f66223c.getLayout();
            if (layout != null) {
                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                    this.f66218e.f66223c.setCompoundDrawablePadding(l.g(d.this.f66216h, R.dimen.tbds10));
                } else {
                    this.f66218e.f66223c.setCompoundDrawablePadding(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NewMyFansUserLikeButton.b {
        public b() {
        }

        @Override // com.baidu.tieba.myAttentionAndFans.NewMyFansUserLikeButton.b
        public void callback() {
            if (d.this.f66216h != null) {
                d.this.f66216h.hideFollowSwitchGuideTip();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f66221a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f66222b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f66223c;

        /* renamed from: d  reason: collision with root package name */
        public View f66224d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f66225e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f66226f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f66227g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f66228h;

        /* renamed from: i  reason: collision with root package name */
        public NewMyFansUserLikeButton f66229i;
        public d.a.m0.r.f0.q.c j;
        public ProgressBar k;
        public TextView l;
        public TextView m;
        public LinearLayout n;
        public EMTextView o;

        public c(d dVar) {
        }

        public /* synthetic */ c(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.f66216h = null;
        this.j = false;
        this.k = true;
        this.l = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.f66216h = personListActivity;
        this.j = z;
        this.k = z2;
        this.l = i2;
        this.o = onClickListener2;
        this.p = onClickListener3;
        this.q = onClickListener;
        this.f66199e = new ArrayList<>();
    }

    @Override // d.a.n0.w1.b
    public void a(g1 g1Var) {
        if (g1Var == null) {
            return;
        }
        this.m = g1Var.f53709i;
        ArrayList arrayList = new ArrayList();
        if (this.f66199e.isEmpty() && !ListUtils.isEmpty(g1Var.a())) {
            Iterator<UserData> it = g1Var.a().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.n.add(Long.valueOf(d.a.c.e.m.b.f(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(g1Var.a());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(i(g1Var.b()));
        this.f66199e.addAll(arrayList);
        if (this.f66199e.isEmpty() || this.f66199e.get(0).mAttentionType == 3) {
            return;
        }
        UserData userData2 = new UserData();
        userData2.mAttentionType = 3;
        this.f66199e.add(0, userData2);
    }

    @Override // d.a.n0.w1.b
    public boolean d(long j) {
        ArrayList<UserData> arrayList;
        boolean z = false;
        if (j != 0 && (arrayList = this.f66199e) != null && arrayList.size() != 0) {
            Iterator<UserData> it = this.f66199e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                UserData next = it.next();
                if (next != null && next.getUserIdLong() == j) {
                    z = true;
                    if (next.getLikeStatus() == 2) {
                        next.setLikeStatus(1);
                    }
                }
            }
        }
        return z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f66217i) {
            return 1;
        }
        ArrayList<UserData> arrayList = this.f66199e;
        int size = arrayList != null ? arrayList.size() : 0;
        return c() ? size + 1 : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<UserData> arrayList = this.f66199e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f66199e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        ArrayList<UserData> arrayList = this.f66199e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return -1L;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f66217i) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f66199e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return 1;
        }
        if (this.f66199e.get(i2).mAttentionType == 0) {
            return 2;
        }
        return this.f66199e.get(i2).mAttentionType == 3 ? 3 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        String str;
        if (this.f66199e == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof c)) {
            cVar = (c) view.getTag();
        } else {
            cVar = new c(this, null);
            if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f66216h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                cVar.f66221a = viewGroup2;
                viewGroup2.setOnClickListener(this.q);
                ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                cVar.f66222b = clickableHeaderImageView;
                clickableHeaderImageView.setRadius(l.g(this.f66216h.getPageContext().getPageActivity(), R.dimen.ds90));
                cVar.f66222b.setAutoChangeStyle(true);
                cVar.f66222b.setClickable(false);
                cVar.f66227g = (LinearLayout) view.findViewById(R.id.info);
                cVar.f66228h = (LinearLayout) view.findViewById(R.id.tail_container);
                EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                cVar.f66223c = eMTextView;
                eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(cVar));
                View a2 = d.a.m0.d.c.b().a(this.f66216h.getPageContext().getPageActivity(), 5);
                cVar.f66224d = a2;
                if (a2 != null) {
                    a2.setVisibility(8);
                    cVar.f66228h.addView(cVar.f66224d, 1);
                }
                cVar.l = (TextView) view.findViewById(R.id.at_list_nodata);
                cVar.f66225e = (EMTextView) view.findViewById(R.id.intro);
                TextView textView = (TextView) view.findViewById(R.id.chat);
                cVar.f66226f = textView;
                textView.setOnClickListener(this.o);
                NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                cVar.f66229i = newMyFansUserLikeButton;
                newMyFansUserLikeButton.setContext(this.f66216h.getPageContext());
                cVar.f66229i.setCallback(this.r);
                cVar.j = new d.a.m0.r.f0.q.c(this.f66216h.getPageContext(), cVar.f66229i);
                cVar.k = null;
                cVar.m = null;
                cVar.n = null;
            } else if (getItemViewType(i2) == 2) {
                view = LayoutInflater.from(this.f66216h.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                cVar.m = (TextView) view.findViewById(R.id.person_list_title);
                cVar.n = (LinearLayout) view.findViewById(R.id.newheader_root);
            } else if (getItemViewType(i2) == 3) {
                view = LayoutInflater.from(this.f66216h.getPageContext().getPageActivity()).inflate(R.layout.attention_list_follow_from_title, (ViewGroup) null);
                cVar.o = (EMTextView) view.findViewById(R.id.attention_follow_tip_text);
            } else {
                view = LayoutInflater.from(this.f66216h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                cVar.f66223c = (EMTextView) view.findViewById(R.id.pb_more_text);
                view.setOnClickListener(this.p);
                cVar.k = (ProgressBar) view.findViewById(R.id.progress);
                cVar.m = null;
                cVar.n = null;
            }
            view.setTag(cVar);
        }
        NewMyFansUserLikeButton newMyFansUserLikeButton2 = cVar.f66229i;
        if (newMyFansUserLikeButton2 != null) {
            newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
        }
        if (getItemViewType(i2) == 0) {
            if (this.f66217i) {
                cVar.f66227g.setVisibility(8);
                cVar.f66226f.setVisibility(8);
                cVar.l.setVisibility(0);
                if (this.j) {
                    if (this.k) {
                        cVar.l.setText(R.string.not_have_attention);
                    } else {
                        int i3 = this.l;
                        if (i3 == 2) {
                            cVar.l.setText(R.string.her_no_attention_other);
                        } else if (i3 == 1) {
                            cVar.l.setText(R.string.him_no_attention_other);
                        } else {
                            cVar.l.setText(R.string.no_attention_other);
                        }
                    }
                } else if (this.k) {
                    cVar.l.setText(R.string.not_have_fans);
                } else {
                    int i4 = this.l;
                    if (i4 == 2) {
                        cVar.l.setText(R.string.her_no_fan_other);
                    } else if (i4 == 1) {
                        cVar.l.setText(R.string.him_no_fan_other);
                    } else {
                        cVar.l.setText(R.string.no_fan_other);
                    }
                }
            } else {
                UserData userData = (UserData) ListUtils.getItem(this.f66199e, i2);
                if (userData == null) {
                    return null;
                }
                cVar.f66221a.setTag(Integer.valueOf(i2));
                cVar.f66226f.setVisibility(0);
                cVar.l.setVisibility(8);
                UtilHelper.showHeadImageViewBigV(cVar.f66222b, userData, 0);
                cVar.f66223c.setText(UtilHelper.getUserName(userData));
                cVar.f66222b.setPlaceHolder(1);
                cVar.f66222b.U(userData.getAvater(), 12, false);
                if (cVar.f66224d != null && userData.getAlaUserData() != null) {
                    if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                        cVar.f66224d.setVisibility(8);
                    } else {
                        cVar.f66224d.setVisibility(0);
                        d.a.m0.d.b bVar = new d.a.m0.d.b();
                        bVar.f52936a = userData.getAlaUserData();
                        bVar.f52937b = 5;
                        cVar.f66224d.setTag(bVar);
                    }
                }
                if (k.isEmpty(userData.getIntro())) {
                    cVar.f66225e.setVisibility(8);
                } else {
                    cVar.f66225e.setVisibility(0);
                    EMTextView eMTextView2 = cVar.f66225e;
                    if (TextUtils.isEmpty(userData.getFollowFrom()) && this.k) {
                        str = userData.getIntro();
                    } else {
                        str = userData.getFollowFrom() + " " + userData.getIntro();
                    }
                    eMTextView2.setText(str);
                }
                cVar.f66226f.setTag(Integer.valueOf(i2));
                String userId = userData.getUserId();
                cVar.f66229i.setStatsParams(1, userId);
                userData.setIsLike(userData.getHave_attention() > 0);
                cVar.j.n(userData);
                if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                    cVar.f66229i.setVisibility(8);
                    cVar.f66226f.setVisibility(8);
                } else {
                    cVar.f66226f.setVisibility(8);
                    cVar.f66229i.setVisibility(0);
                }
            }
            cVar.k = null;
        } else if (getItemViewType(i2) == 3) {
            if (!this.k || TextUtils.isEmpty(this.m)) {
                cVar.o.setVisibility(8);
            }
            cVar.o.setText(this.m);
        } else if (getItemViewType(i2) == 2) {
            cVar.m.setText(this.m);
        } else if (getItemViewType(i2) != 2 || getItemViewType(i2) != 3) {
            cVar.f66223c.setText(this.f66216h.getPageContext().getString(R.string.loading));
            cVar.k.setVisibility(0);
        }
        h(view, cVar);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public final void h(View view, c cVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f66216h.getLayoutMode().k(skinType == 1);
        this.f66216h.getLayoutMode().j(view);
        if (cVar != null) {
            TextView textView = cVar.f66226f;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
                SkinManager.setBackgroundResource(cVar.f66226f, R.drawable.btn_focus_border_bg);
                cVar.f66226f.setEnabled(true);
            }
            LinearLayout linearLayout = cVar.n;
            if (linearLayout != null && cVar.m != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0205);
                SkinManager.setViewTextColor(cVar.m, R.color.CAM_X0110);
            }
            EMTextView eMTextView = cVar.o;
            if (eMTextView != null) {
                SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0105);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton = cVar.f66229i;
            if (newMyFansUserLikeButton != null) {
                newMyFansUserLikeButton.r(skinType);
            }
        }
    }

    public final ArrayList<UserData> i(ArrayList<UserData> arrayList) {
        if (ListUtils.isEmpty(arrayList) || this.n.isEmpty()) {
            return arrayList;
        }
        ArrayList<UserData> arrayList2 = new ArrayList<>();
        Iterator<UserData> it = arrayList.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && !StringUtils.isNull(next.getUserId()) && !this.n.contains(Long.valueOf(d.a.c.e.m.b.f(next.getUserId(), 0L)))) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        if (this.f66217i) {
            return false;
        }
        return super.isEnabled(i2);
    }
}
