package d.a.j0.v1;

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
import d.a.i0.r.q.g1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d extends d.a.j0.v1.b {

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f61671h;
    public boolean j;
    public boolean k;
    public int l;
    public String m;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61672i = false;
    public HashSet<Long> n = new HashSet<>();

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61673e;

        public a(b bVar) {
            this.f61673e = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f61673e.f61677c.getLayout();
            if (layout != null) {
                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                    this.f61673e.f61677c.setCompoundDrawablePadding(l.g(d.this.f61671h, R.dimen.tbds10));
                } else {
                    this.f61673e.f61677c.setCompoundDrawablePadding(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f61675a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f61676b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f61677c;

        /* renamed from: d  reason: collision with root package name */
        public View f61678d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f61679e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f61680f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f61681g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f61682h;

        /* renamed from: i  reason: collision with root package name */
        public NewMyFansUserLikeButton f61683i;
        public d.a.i0.r.f0.q.c j;
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
        this.f61671h = null;
        this.j = false;
        this.k = true;
        this.l = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.f61671h = personListActivity;
        this.j = z;
        this.k = z2;
        this.l = i2;
        this.o = onClickListener2;
        this.p = onClickListener3;
        this.q = onClickListener;
        this.f61654e = new ArrayList<>();
    }

    @Override // d.a.j0.v1.b
    public void a(g1 g1Var) {
        if (g1Var == null) {
            return;
        }
        this.m = g1Var.f49170i;
        ArrayList arrayList = new ArrayList();
        if (this.f61654e.isEmpty() && !ListUtils.isEmpty(g1Var.a())) {
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
        this.f61654e.addAll(arrayList);
        if (this.f61654e.isEmpty() || this.f61654e.get(0).mAttentionType == 3) {
            return;
        }
        UserData userData2 = new UserData();
        userData2.mAttentionType = 3;
        this.f61654e.add(0, userData2);
    }

    @Override // d.a.j0.v1.b
    public boolean d(long j) {
        ArrayList<UserData> arrayList;
        boolean z = false;
        if (j != 0 && (arrayList = this.f61654e) != null && arrayList.size() != 0) {
            Iterator<UserData> it = this.f61654e.iterator();
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
        if (this.f61672i) {
            return 1;
        }
        ArrayList<UserData> arrayList = this.f61654e;
        int size = arrayList != null ? arrayList.size() : 0;
        return c() ? size + 1 : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<UserData> arrayList = this.f61654e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f61654e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        ArrayList<UserData> arrayList = this.f61654e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return -1L;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f61672i) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f61654e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return 1;
        }
        if (this.f61654e.get(i2).mAttentionType == 0) {
            return 2;
        }
        return this.f61654e.get(i2).mAttentionType == 3 ? 3 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        String str;
        if (this.f61654e == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        } else {
            bVar = new b(this, null);
            if (getItemViewType(i2) == 0) {
                view = LayoutInflater.from(this.f61671h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                bVar.f61675a = viewGroup2;
                viewGroup2.setOnClickListener(this.q);
                ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                bVar.f61676b = clickableHeaderImageView;
                clickableHeaderImageView.setRadius(l.g(this.f61671h.getPageContext().getPageActivity(), R.dimen.ds90));
                bVar.f61676b.setAutoChangeStyle(true);
                bVar.f61676b.setClickable(false);
                bVar.f61681g = (LinearLayout) view.findViewById(R.id.info);
                bVar.f61682h = (LinearLayout) view.findViewById(R.id.tail_container);
                EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                bVar.f61677c = eMTextView;
                eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(bVar));
                View a2 = d.a.i0.d.c.b().a(this.f61671h.getPageContext().getPageActivity(), 5);
                bVar.f61678d = a2;
                if (a2 != null) {
                    a2.setVisibility(8);
                    bVar.f61682h.addView(bVar.f61678d, 1);
                }
                bVar.l = (TextView) view.findViewById(R.id.at_list_nodata);
                bVar.f61679e = (EMTextView) view.findViewById(R.id.intro);
                TextView textView = (TextView) view.findViewById(R.id.chat);
                bVar.f61680f = textView;
                textView.setOnClickListener(this.o);
                NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                bVar.f61683i = newMyFansUserLikeButton;
                newMyFansUserLikeButton.setContext(this.f61671h.getPageContext());
                bVar.j = new d.a.i0.r.f0.q.c(this.f61671h.getPageContext(), bVar.f61683i);
                bVar.k = null;
                bVar.m = null;
                bVar.n = null;
            } else if (getItemViewType(i2) == 2) {
                view = LayoutInflater.from(this.f61671h.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                TextView textView2 = (TextView) view.findViewById(R.id.person_list_title);
                bVar.m = textView2;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds16);
                bVar.m.setLayoutParams(layoutParams);
                bVar.n = (LinearLayout) view.findViewById(R.id.newheader_root);
            } else if (getItemViewType(i2) == 3) {
                view = LayoutInflater.from(this.f61671h.getPageContext().getPageActivity()).inflate(R.layout.attention_list_follow_from_title, (ViewGroup) null);
                bVar.o = (EMTextView) view.findViewById(R.id.attention_follow_tip_text);
            } else {
                view = LayoutInflater.from(this.f61671h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                bVar.f61677c = (EMTextView) view.findViewById(R.id.pb_more_text);
                view.setOnClickListener(this.p);
                bVar.k = (ProgressBar) view.findViewById(R.id.progress);
                bVar.m = null;
                bVar.n = null;
            }
            view.setTag(bVar);
        }
        NewMyFansUserLikeButton newMyFansUserLikeButton2 = bVar.f61683i;
        if (newMyFansUserLikeButton2 != null) {
            newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
        }
        if (getItemViewType(i2) == 0) {
            if (this.f61672i) {
                bVar.f61681g.setVisibility(8);
                bVar.f61680f.setVisibility(8);
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
                UserData userData = (UserData) ListUtils.getItem(this.f61654e, i2);
                if (userData == null) {
                    return null;
                }
                bVar.f61675a.setTag(Integer.valueOf(i2));
                bVar.f61680f.setVisibility(0);
                bVar.l.setVisibility(8);
                UtilHelper.showHeadImageViewBigV(bVar.f61676b, userData, 0);
                bVar.f61677c.setText(UtilHelper.getUserName(userData));
                bVar.f61676b.setPlaceHolder(1);
                bVar.f61676b.V(userData.getAvater(), 12, false);
                if (bVar.f61678d != null && userData.getAlaUserData() != null) {
                    if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                        bVar.f61678d.setVisibility(8);
                    } else {
                        bVar.f61678d.setVisibility(0);
                        d.a.i0.d.b bVar2 = new d.a.i0.d.b();
                        bVar2.f48390a = userData.getAlaUserData();
                        bVar2.f48391b = 5;
                        bVar.f61678d.setTag(bVar2);
                    }
                }
                if (k.isEmpty(userData.getIntro())) {
                    bVar.f61679e.setVisibility(8);
                } else {
                    bVar.f61679e.setVisibility(0);
                    EMTextView eMTextView2 = bVar.f61679e;
                    if (TextUtils.isEmpty(userData.getFollowFrom()) && this.k) {
                        str = userData.getIntro();
                    } else {
                        str = userData.getFollowFrom() + " " + userData.getIntro();
                    }
                    eMTextView2.setText(str);
                }
                bVar.f61680f.setTag(Integer.valueOf(i2));
                String userId = userData.getUserId();
                bVar.f61683i.setStatsParams(1, userId);
                userData.setIsLike(userData.getHave_attention() > 0);
                bVar.j.n(userData);
                if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                    bVar.f61683i.setVisibility(8);
                    bVar.f61680f.setVisibility(8);
                } else {
                    bVar.f61680f.setVisibility(8);
                    bVar.f61683i.setVisibility(0);
                }
            }
            bVar.k = null;
        } else if (getItemViewType(i2) == 3) {
            if (!this.k || TextUtils.isEmpty(this.m)) {
                bVar.o.setVisibility(8);
            }
            bVar.o.setText(this.m);
        } else if (getItemViewType(i2) != 2 || getItemViewType(i2) != 3) {
            bVar.f61677c.setText(this.f61671h.getPageContext().getString(R.string.loading));
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
        this.f61671h.getLayoutMode().k(skinType == 1);
        this.f61671h.getLayoutMode().j(view);
        if (bVar != null) {
            TextView textView = bVar.f61680f;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
                SkinManager.setBackgroundResource(bVar.f61680f, R.drawable.btn_focus_border_bg);
                bVar.f61680f.setEnabled(true);
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
            NewMyFansUserLikeButton newMyFansUserLikeButton = bVar.f61683i;
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
        if (this.f61672i) {
            return false;
        }
        return super.isEnabled(i2);
    }
}
