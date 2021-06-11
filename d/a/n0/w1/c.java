package d.a.n0.w1;

import android.annotation.SuppressLint;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
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
import d.a.m0.r.f0.q.c;
import d.a.m0.r.q.g1;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class c extends d.a.n0.w1.b {

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f66202h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66203i;
    public int j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1755c f66204e;

        public a(C1755c c1755c) {
            this.f66204e = c1755c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f66204e.f66209c.getLayout();
            if (layout != null) {
                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                    this.f66204e.f66209c.setCompoundDrawablePadding(l.g(c.this.f66202h, R.dimen.tbds10));
                } else {
                    this.f66204e.f66209c.setCompoundDrawablePadding(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.f {
        public b() {
        }

        @Override // d.a.m0.r.f0.q.c.f
        public void a(boolean z) {
            if (z) {
                l.L(c.this.f66202h, R.string.attention_success);
            } else {
                l.L(c.this.f66202h, R.string.unfollow_success);
            }
        }
    }

    /* renamed from: d.a.n0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1755c {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f66207a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f66208b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f66209c;

        /* renamed from: d  reason: collision with root package name */
        public View f66210d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f66211e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f66212f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f66213g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f66214h;

        /* renamed from: i  reason: collision with root package name */
        public d.a.m0.r.f0.q.c f66215i;
        public ImageView j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public C1755c(c cVar) {
        }

        public /* synthetic */ C1755c(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(PersonListActivity personListActivity, boolean z, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f66202h = null;
        this.f66203i = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.f66202h = personListActivity;
        this.f66203i = z;
        this.j = i2;
        this.k = onClickListener2;
        this.l = onClickListener;
        this.f66199e = new ArrayList<>();
    }

    @Override // d.a.n0.w1.b
    public void a(g1 g1Var) {
        if (g1Var == null || g1Var.b() == null) {
            return;
        }
        Iterator<UserData> it = g1Var.b().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            UserData next = it.next();
            if (next != null) {
                next.setIsLike(next.getHave_attention() > 0);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (this.f66199e == null) {
            this.f66199e = new ArrayList<>();
        }
        arrayList.addAll(g1Var.b());
        if (!ListUtils.isEmpty(this.f66199e)) {
            ArrayList<UserData> arrayList2 = this.f66199e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f66199e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f66199e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f66199e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f66199e.addAll(arrayList);
                }
            }
        }
        int i2 = 0;
        while (i2 < arrayList.size() - 1) {
            UserData userData2 = (UserData) arrayList.get(i2);
            i2++;
            UserData userData3 = (UserData) arrayList.get(i2);
            if (userData2 != null && userData3 != null && userData2.isNewFan && !userData3.isNewFan) {
                userData2.isLastNewFan = true;
            }
        }
        if (ListUtils.isEmpty(this.f66199e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f66199e.addAll(arrayList);
    }

    @Override // d.a.n0.w1.b
    public boolean d(long j) {
        ArrayList<UserData> arrayList;
        if (j != 0 && (arrayList = this.f66199e) != null && arrayList.size() != 0) {
            Iterator<UserData> it = this.f66199e.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && next.getUserIdLong() == j) {
                    this.f66199e.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f66200f) {
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
        if (this.f66200f) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f66199e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return 1;
        }
        return this.f66199e.get(i2).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1755c c1755c;
        if (this.f66199e == null) {
            return view;
        }
        int itemViewType = getItemViewType(i2);
        if (view != null && (view.getTag() instanceof C1755c)) {
            c1755c = (C1755c) view.getTag();
        } else {
            c1755c = new C1755c(this, null);
            if (itemViewType == 0) {
                view = LayoutInflater.from(this.f66202h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                c1755c.f66207a = viewGroup2;
                viewGroup2.setOnClickListener(this.l);
                ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                c1755c.f66208b = clickableHeaderImageView;
                clickableHeaderImageView.setRadius(l.g(this.f66202h.getPageContext().getPageActivity(), R.dimen.ds90));
                c1755c.f66208b.setAutoChangeStyle(true);
                c1755c.f66208b.setClickable(false);
                ((LinearLayout.LayoutParams) c1755c.f66208b.getLayoutParams()).setMargins(l.g(this.f66202h, R.dimen.ds34), 0, 0, 0);
                c1755c.f66212f = (LinearLayout) view.findViewById(R.id.info);
                c1755c.f66213g = (LinearLayout) view.findViewById(R.id.tail_container);
                EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                c1755c.f66209c = eMTextView;
                eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(c1755c));
                View a2 = d.a.m0.d.c.b().a(this.f66202h.getPageContext().getPageActivity(), 5);
                c1755c.f66210d = a2;
                if (a2 != null) {
                    a2.setVisibility(8);
                    c1755c.f66213g.addView(c1755c.f66210d, 1);
                }
                c1755c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                c1755c.f66211e = (EMTextView) view.findViewById(R.id.intro);
                NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                c1755c.f66214h = newMyFansUserLikeButton;
                newMyFansUserLikeButton.setContext(this.f66202h.getPageContext());
                ((LinearLayout.LayoutParams) c1755c.f66214h.getLayoutParams()).setMargins(0, 0, l.g(this.f66202h, R.dimen.ds34), 0);
                d.a.m0.r.f0.q.c cVar = new d.a.m0.r.f0.q.c(this.f66202h.getPageContext(), c1755c.f66214h);
                c1755c.f66215i = cVar;
                cVar.n((d.a.m0.r.f0.q.a) ListUtils.getItem(this.f66199e, i2));
                c1755c.f66215i.o(new b());
                c1755c.k = null;
                c1755c.m = null;
                c1755c.j = (ImageView) view.findViewById(R.id.diver_buttom_px);
            } else if (itemViewType == 2) {
                view = LayoutInflater.from(this.f66202h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                c1755c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
            } else {
                view = LayoutInflater.from(this.f66202h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                c1755c.f66209c = (EMTextView) view.findViewById(R.id.pb_more_text);
                view.setOnClickListener(this.k);
                c1755c.k = (ProgressBar) view.findViewById(R.id.progress);
                c1755c.m = null;
            }
            view.setTag(c1755c);
        }
        NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1755c.f66214h;
        if (newMyFansUserLikeButton2 != null) {
            newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
        }
        if (itemViewType == 0) {
            if (this.f66200f) {
                c1755c.f66212f.setVisibility(8);
                c1755c.l.setVisibility(0);
                if (this.f66203i) {
                    c1755c.l.setText(R.string.not_have_fans);
                } else {
                    int i3 = this.j;
                    if (i3 == 2) {
                        c1755c.l.setText(R.string.her_no_fan_other);
                    } else if (i3 == 1) {
                        c1755c.l.setText(R.string.him_no_fan_other);
                    } else {
                        c1755c.l.setText(R.string.no_fan_other);
                    }
                }
            } else {
                c1755c.f66207a.setTag(Integer.valueOf(i2));
                UserData userData = (UserData) ListUtils.getItem(this.f66199e, i2);
                if (userData == null) {
                    return view;
                }
                c1755c.l.setVisibility(8);
                UtilHelper.showHeadImageViewBigV(c1755c.f66208b, userData, 0);
                c1755c.f66209c.setText(UtilHelper.getUserName(userData));
                c1755c.f66208b.setPlaceHolder(1);
                c1755c.f66208b.U(userData.getAvater(), 12, false);
                if (c1755c.f66210d != null && userData.getAlaUserData() != null) {
                    if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                        c1755c.f66210d.setVisibility(8);
                    } else {
                        c1755c.f66210d.setVisibility(0);
                        d.a.m0.d.b bVar = new d.a.m0.d.b();
                        bVar.f52936a = userData.getAlaUserData();
                        bVar.f52937b = 5;
                        c1755c.f66210d.setTag(bVar);
                    }
                }
                if (k.isEmpty(userData.getIntro())) {
                    c1755c.f66211e.setVisibility(8);
                } else {
                    c1755c.f66211e.setVisibility(0);
                    c1755c.f66211e.setText(userData.getIntro());
                }
                String userId = userData.getUserId();
                userData.setIsLike(userData.getHave_attention() > 0);
                c1755c.f66215i.n(userData);
                if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    c1755c.f66214h.setVisibility(8);
                } else {
                    c1755c.f66214h.setStatsParams(2, userId);
                    c1755c.f66215i.m("9");
                    c1755c.f66214h.setVisibility(0);
                }
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1755c.j.getLayoutParams();
            if (ListUtils.getItem(this.f66199e, i2) != null && ((UserData) ListUtils.getItem(this.f66199e, i2)).isLastNewFan) {
                layoutParams.height = l.g(this.f66202h, R.dimen.ds12);
                layoutParams.setMargins(0, 0, 0, 0);
                c1755c.j.setVisibility(0);
            } else {
                c1755c.j.setVisibility(8);
                layoutParams.height = l.g(this.f66202h, R.dimen.ds1);
                layoutParams.setMargins(l.g(this.f66202h, R.dimen.ds34), 0, l.g(this.f66202h, R.dimen.ds34), 0);
            }
            c1755c.j.setLayoutParams(layoutParams);
            c1755c.k = null;
        } else if (itemViewType == 2) {
            c1755c.m.setText(R.string.new_fans);
            c1755c.m.setVisibility(0);
        } else {
            c1755c.f66209c.setText(this.f66202h.getPageContext().getString(R.string.loading));
            c1755c.k.setVisibility(0);
        }
        h(view, c1755c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public final void h(View view, C1755c c1755c) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f66202h.getLayoutMode().k(skinType == 1);
        this.f66202h.getLayoutMode().j(view);
        if (c1755c != null) {
            TextView textView = c1755c.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(c1755c.m, R.color.CAM_X0205);
            }
            ImageView imageView = c1755c.j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.color.CAM_X0204);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton = c1755c.f66214h;
            if (newMyFansUserLikeButton != null) {
                newMyFansUserLikeButton.r(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        if (this.f66200f) {
            return false;
        }
        return super.isEnabled(i2);
    }
}
