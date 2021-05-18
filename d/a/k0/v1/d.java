package d.a.k0.v1;

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
import d.a.j0.r.q.g1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d extends d.a.k0.v1.b {

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f62395h;
    public boolean j;
    public boolean k;
    public int l;
    public String m;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62396i = false;
    public HashSet<Long> n = new HashSet<>();

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f62397e;

        public a(b bVar) {
            this.f62397e = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f62397e.f62401c.getLayout();
            if (layout != null) {
                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                    this.f62397e.f62401c.setCompoundDrawablePadding(l.g(d.this.f62395h, R.dimen.tbds10));
                } else {
                    this.f62397e.f62401c.setCompoundDrawablePadding(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f62399a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f62400b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f62401c;

        /* renamed from: d  reason: collision with root package name */
        public View f62402d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f62403e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f62404f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f62405g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f62406h;

        /* renamed from: i  reason: collision with root package name */
        public NewMyFansUserLikeButton f62407i;
        public d.a.j0.r.f0.q.c j;
        public ProgressBar k;
        public TextView l;
        public TextView m;
        public LinearLayout n;
        public EMTextView o;

        public b(d dVar) {
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.f62395h = null;
        this.j = false;
        this.k = true;
        this.l = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.f62395h = personListActivity;
        this.j = z;
        this.k = z2;
        this.l = i2;
        this.o = onClickListener2;
        this.p = onClickListener3;
        this.q = onClickListener;
        this.f62378e = new ArrayList<>();
    }

    @Override // d.a.k0.v1.b
    public void a(g1 g1Var) {
        if (g1Var == null) {
            return;
        }
        this.m = g1Var.f49989i;
        ArrayList arrayList = new ArrayList();
        if (this.f62378e.isEmpty() && !ListUtils.isEmpty(g1Var.a())) {
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
        this.f62378e.addAll(arrayList);
        if (this.f62378e.isEmpty() || this.f62378e.get(0).mAttentionType == 3) {
            return;
        }
        UserData userData2 = new UserData();
        userData2.mAttentionType = 3;
        this.f62378e.add(0, userData2);
    }

    @Override // d.a.k0.v1.b
    public boolean d(long j) {
        ArrayList<UserData> arrayList;
        boolean z = false;
        if (j != 0 && (arrayList = this.f62378e) != null && arrayList.size() != 0) {
            Iterator<UserData> it = this.f62378e.iterator();
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
        if (this.f62396i) {
            return 1;
        }
        ArrayList<UserData> arrayList = this.f62378e;
        int size = arrayList != null ? arrayList.size() : 0;
        return c() ? size + 1 : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<UserData> arrayList = this.f62378e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f62378e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        ArrayList<UserData> arrayList = this.f62378e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return -1L;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f62396i) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f62378e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return 1;
        }
        if (this.f62378e.get(i2).mAttentionType == 0) {
            return 2;
        }
        return this.f62378e.get(i2).mAttentionType == 3 ? 3 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        String str;
        if (this.f62378e == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        } else {
            bVar = new b(this, null);
            if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f62395h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                bVar.f62399a = viewGroup2;
                viewGroup2.setOnClickListener(this.q);
                ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                bVar.f62400b = clickableHeaderImageView;
                clickableHeaderImageView.setRadius(l.g(this.f62395h.getPageContext().getPageActivity(), R.dimen.ds90));
                bVar.f62400b.setAutoChangeStyle(true);
                bVar.f62400b.setClickable(false);
                bVar.f62405g = (LinearLayout) view.findViewById(R.id.info);
                bVar.f62406h = (LinearLayout) view.findViewById(R.id.tail_container);
                EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                bVar.f62401c = eMTextView;
                eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(bVar));
                View a2 = d.a.j0.d.c.b().a(this.f62395h.getPageContext().getPageActivity(), 5);
                bVar.f62402d = a2;
                if (a2 != null) {
                    a2.setVisibility(8);
                    bVar.f62406h.addView(bVar.f62402d, 1);
                }
                bVar.l = (TextView) view.findViewById(R.id.at_list_nodata);
                bVar.f62403e = (EMTextView) view.findViewById(R.id.intro);
                TextView textView = (TextView) view.findViewById(R.id.chat);
                bVar.f62404f = textView;
                textView.setOnClickListener(this.o);
                NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                bVar.f62407i = newMyFansUserLikeButton;
                newMyFansUserLikeButton.setContext(this.f62395h.getPageContext());
                bVar.j = new d.a.j0.r.f0.q.c(this.f62395h.getPageContext(), bVar.f62407i);
                bVar.k = null;
                bVar.m = null;
                bVar.n = null;
            } else if (getItemViewType(i2) == 2) {
                view = LayoutInflater.from(this.f62395h.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                TextView textView2 = (TextView) view.findViewById(R.id.person_list_title);
                bVar.m = textView2;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds16);
                bVar.m.setLayoutParams(layoutParams);
                bVar.n = (LinearLayout) view.findViewById(R.id.newheader_root);
            } else if (getItemViewType(i2) == 3) {
                view = LayoutInflater.from(this.f62395h.getPageContext().getPageActivity()).inflate(R.layout.attention_list_follow_from_title, (ViewGroup) null);
                bVar.o = (EMTextView) view.findViewById(R.id.attention_follow_tip_text);
            } else {
                view = LayoutInflater.from(this.f62395h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                bVar.f62401c = (EMTextView) view.findViewById(R.id.pb_more_text);
                view.setOnClickListener(this.p);
                bVar.k = (ProgressBar) view.findViewById(R.id.progress);
                bVar.m = null;
                bVar.n = null;
            }
            view.setTag(bVar);
        }
        NewMyFansUserLikeButton newMyFansUserLikeButton2 = bVar.f62407i;
        if (newMyFansUserLikeButton2 != null) {
            newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
        }
        if (getItemViewType(i2) == 0) {
            if (this.f62396i) {
                bVar.f62405g.setVisibility(8);
                bVar.f62404f.setVisibility(8);
                bVar.l.setVisibility(0);
                if (this.j) {
                    if (this.k) {
                        bVar.l.setText(R.string.not_have_attention);
                    } else {
                        int i3 = this.l;
                        if (i3 == 2) {
                            bVar.l.setText(R.string.her_no_attention_other);
                        } else if (i3 == 1) {
                            bVar.l.setText(R.string.him_no_attention_other);
                        } else {
                            bVar.l.setText(R.string.no_attention_other);
                        }
                    }
                } else if (this.k) {
                    bVar.l.setText(R.string.not_have_fans);
                } else {
                    int i4 = this.l;
                    if (i4 == 2) {
                        bVar.l.setText(R.string.her_no_fan_other);
                    } else if (i4 == 1) {
                        bVar.l.setText(R.string.him_no_fan_other);
                    } else {
                        bVar.l.setText(R.string.no_fan_other);
                    }
                }
            } else {
                UserData userData = (UserData) ListUtils.getItem(this.f62378e, i2);
                if (userData == null) {
                    return null;
                }
                bVar.f62399a.setTag(Integer.valueOf(i2));
                bVar.f62404f.setVisibility(0);
                bVar.l.setVisibility(8);
                UtilHelper.showHeadImageViewBigV(bVar.f62400b, userData, 0);
                bVar.f62401c.setText(UtilHelper.getUserName(userData));
                bVar.f62400b.setPlaceHolder(1);
                bVar.f62400b.V(userData.getAvater(), 12, false);
                if (bVar.f62402d != null && userData.getAlaUserData() != null) {
                    if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                        bVar.f62402d.setVisibility(8);
                    } else {
                        bVar.f62402d.setVisibility(0);
                        d.a.j0.d.b bVar2 = new d.a.j0.d.b();
                        bVar2.f49218a = userData.getAlaUserData();
                        bVar2.f49219b = 5;
                        bVar.f62402d.setTag(bVar2);
                    }
                }
                if (k.isEmpty(userData.getIntro())) {
                    bVar.f62403e.setVisibility(8);
                } else {
                    bVar.f62403e.setVisibility(0);
                    EMTextView eMTextView2 = bVar.f62403e;
                    if (TextUtils.isEmpty(userData.getFollowFrom()) && this.k) {
                        str = userData.getIntro();
                    } else {
                        str = userData.getFollowFrom() + " " + userData.getIntro();
                    }
                    eMTextView2.setText(str);
                }
                bVar.f62404f.setTag(Integer.valueOf(i2));
                String userId = userData.getUserId();
                bVar.f62407i.setStatsParams(1, userId);
                userData.setIsLike(userData.getHave_attention() > 0);
                bVar.j.n(userData);
                if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                    bVar.f62407i.setVisibility(8);
                    bVar.f62404f.setVisibility(8);
                } else {
                    bVar.f62404f.setVisibility(8);
                    bVar.f62407i.setVisibility(0);
                }
            }
            bVar.k = null;
        } else if (getItemViewType(i2) == 3) {
            if (!this.k || TextUtils.isEmpty(this.m)) {
                bVar.o.setVisibility(8);
            }
            bVar.o.setText(this.m);
        } else if (getItemViewType(i2) != 2 || getItemViewType(i2) != 3) {
            bVar.f62401c.setText(this.f62395h.getPageContext().getString(R.string.loading));
            bVar.k.setVisibility(0);
        }
        h(view, bVar);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public final void h(View view, b bVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f62395h.getLayoutMode().k(skinType == 1);
        this.f62395h.getLayoutMode().j(view);
        if (bVar != null) {
            TextView textView = bVar.f62404f;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
                SkinManager.setBackgroundResource(bVar.f62404f, R.drawable.btn_focus_border_bg);
                bVar.f62404f.setEnabled(true);
            }
            LinearLayout linearLayout = bVar.n;
            if (linearLayout != null && bVar.m != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0205);
                SkinManager.setViewTextColor(bVar.m, R.color.CAM_X0110);
            }
            EMTextView eMTextView = bVar.o;
            if (eMTextView != null) {
                SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0105);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton = bVar.f62407i;
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
        if (this.f62396i) {
            return false;
        }
        return super.isEnabled(i2);
    }
}
