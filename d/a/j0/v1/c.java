package d.a.j0.v1;

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
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.r.f0.q.c;
import d.a.i0.r.q.g1;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c extends d.a.j0.v1.b {

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f61657h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61658i;
    public int j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1620c f61659e;

        public a(C1620c c1620c) {
            this.f61659e = c1620c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f61659e.f61664c.getLayout();
            if (layout != null) {
                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                    this.f61659e.f61664c.setCompoundDrawablePadding(l.g(c.this.f61657h, R.dimen.tbds10));
                } else {
                    this.f61659e.f61664c.setCompoundDrawablePadding(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.d {
        public b() {
        }

        @Override // d.a.i0.r.f0.q.c.d
        public void a(boolean z) {
            if (z) {
                l.L(c.this.f61657h, R.string.attention_success);
            } else {
                l.L(c.this.f61657h, R.string.unfollow_success);
            }
        }
    }

    /* renamed from: d.a.j0.v1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1620c {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f61662a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f61663b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f61664c;

        /* renamed from: d  reason: collision with root package name */
        public View f61665d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f61666e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f61667f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f61668g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f61669h;

        /* renamed from: i  reason: collision with root package name */
        public d.a.i0.r.f0.q.c f61670i;
        public ImageView j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public C1620c(c cVar) {
        }

        public /* synthetic */ C1620c(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(PersonListActivity personListActivity, boolean z, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f61657h = null;
        this.f61658i = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.f61657h = personListActivity;
        this.f61658i = z;
        this.j = i2;
        this.k = onClickListener2;
        this.l = onClickListener;
        this.f61654e = new ArrayList<>();
    }

    @Override // d.a.j0.v1.b
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
        if (this.f61654e == null) {
            this.f61654e = new ArrayList<>();
        }
        arrayList.addAll(g1Var.b());
        if (!ListUtils.isEmpty(this.f61654e)) {
            ArrayList<UserData> arrayList2 = this.f61654e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f61654e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f61654e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f61654e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f61654e.addAll(arrayList);
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
        if (ListUtils.isEmpty(this.f61654e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f61654e.addAll(arrayList);
    }

    @Override // d.a.j0.v1.b
    public boolean d(long j) {
        ArrayList<UserData> arrayList;
        if (j != 0 && (arrayList = this.f61654e) != null && arrayList.size() != 0) {
            Iterator<UserData> it = this.f61654e.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && next.getUserIdLong() == j) {
                    this.f61654e.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f61655f) {
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
        if (this.f61655f) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f61654e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return 1;
        }
        return this.f61654e.get(i2).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1620c c1620c;
        if (this.f61654e == null) {
            return view;
        }
        int itemViewType = getItemViewType(i2);
        if (view != null && (view.getTag() instanceof C1620c)) {
            c1620c = (C1620c) view.getTag();
        } else {
            c1620c = new C1620c(this, null);
            if (itemViewType == 0) {
                view = LayoutInflater.from(this.f61657h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                c1620c.f61662a = viewGroup2;
                viewGroup2.setOnClickListener(this.l);
                ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                c1620c.f61663b = clickableHeaderImageView;
                clickableHeaderImageView.setRadius(l.g(this.f61657h.getPageContext().getPageActivity(), R.dimen.ds90));
                c1620c.f61663b.setAutoChangeStyle(true);
                c1620c.f61663b.setClickable(false);
                ((LinearLayout.LayoutParams) c1620c.f61663b.getLayoutParams()).setMargins(l.g(this.f61657h, R.dimen.ds34), 0, 0, 0);
                c1620c.f61667f = (LinearLayout) view.findViewById(R.id.info);
                c1620c.f61668g = (LinearLayout) view.findViewById(R.id.tail_container);
                EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                c1620c.f61664c = eMTextView;
                eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(c1620c));
                View a2 = d.a.i0.d.c.b().a(this.f61657h.getPageContext().getPageActivity(), 5);
                c1620c.f61665d = a2;
                if (a2 != null) {
                    a2.setVisibility(8);
                    c1620c.f61668g.addView(c1620c.f61665d, 1);
                }
                c1620c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                c1620c.f61666e = (EMTextView) view.findViewById(R.id.intro);
                NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                c1620c.f61669h = newMyFansUserLikeButton;
                newMyFansUserLikeButton.setContext(this.f61657h.getPageContext());
                ((LinearLayout.LayoutParams) c1620c.f61669h.getLayoutParams()).setMargins(0, 0, l.g(this.f61657h, R.dimen.ds34), 0);
                d.a.i0.r.f0.q.c cVar = new d.a.i0.r.f0.q.c(this.f61657h.getPageContext(), c1620c.f61669h);
                c1620c.f61670i = cVar;
                cVar.n((d.a.i0.r.f0.q.a) ListUtils.getItem(this.f61654e, i2));
                c1620c.f61670i.o(new b());
                c1620c.k = null;
                c1620c.m = null;
                c1620c.j = (ImageView) view.findViewById(R.id.diver_buttom_px);
            } else if (itemViewType == 2) {
                view = LayoutInflater.from(this.f61657h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                c1620c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
            } else {
                view = LayoutInflater.from(this.f61657h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                c1620c.f61664c = (EMTextView) view.findViewById(R.id.pb_more_text);
                view.setOnClickListener(this.k);
                c1620c.k = (ProgressBar) view.findViewById(R.id.progress);
                c1620c.m = null;
            }
            view.setTag(c1620c);
        }
        NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1620c.f61669h;
        if (newMyFansUserLikeButton2 != null) {
            newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
        }
        if (itemViewType == 0) {
            if (this.f61655f) {
                c1620c.f61667f.setVisibility(8);
                c1620c.l.setVisibility(0);
                if (this.f61658i) {
                    c1620c.l.setText(R.string.not_have_fans);
                } else {
                    int i3 = this.j;
                    if (i3 == 2) {
                        c1620c.l.setText(R.string.her_no_fan_other);
                    } else if (i3 == 1) {
                        c1620c.l.setText(R.string.him_no_fan_other);
                    } else {
                        c1620c.l.setText(R.string.no_fan_other);
                    }
                }
            } else {
                c1620c.f61662a.setTag(Integer.valueOf(i2));
                UserData userData = (UserData) ListUtils.getItem(this.f61654e, i2);
                if (userData == null) {
                    return view;
                }
                c1620c.l.setVisibility(8);
                UtilHelper.showHeadImageViewBigV(c1620c.f61663b, userData, 0);
                c1620c.f61664c.setText(UtilHelper.getUserName(userData));
                c1620c.f61663b.setPlaceHolder(1);
                c1620c.f61663b.V(userData.getAvater(), 12, false);
                if (c1620c.f61665d != null && userData.getAlaUserData() != null) {
                    if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                        c1620c.f61665d.setVisibility(8);
                    } else {
                        c1620c.f61665d.setVisibility(0);
                        d.a.i0.d.b bVar = new d.a.i0.d.b();
                        bVar.f48390a = userData.getAlaUserData();
                        bVar.f48391b = 5;
                        c1620c.f61665d.setTag(bVar);
                    }
                }
                if (k.isEmpty(userData.getIntro())) {
                    c1620c.f61666e.setVisibility(8);
                } else {
                    c1620c.f61666e.setVisibility(0);
                    c1620c.f61666e.setText(userData.getIntro());
                }
                String userId = userData.getUserId();
                userData.setIsLike(userData.getHave_attention() > 0);
                c1620c.f61670i.n(userData);
                if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    c1620c.f61669h.setVisibility(8);
                } else {
                    c1620c.f61669h.setStatsParams(2, userId);
                    c1620c.f61670i.m(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9);
                    c1620c.f61669h.setVisibility(0);
                }
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1620c.j.getLayoutParams();
            if (ListUtils.getItem(this.f61654e, i2) != null && ((UserData) ListUtils.getItem(this.f61654e, i2)).isLastNewFan) {
                layoutParams.height = l.g(this.f61657h, R.dimen.ds12);
                layoutParams.setMargins(0, 0, 0, 0);
                c1620c.j.setVisibility(0);
            } else {
                c1620c.j.setVisibility(8);
                layoutParams.height = l.g(this.f61657h, R.dimen.ds1);
                layoutParams.setMargins(l.g(this.f61657h, R.dimen.ds34), 0, l.g(this.f61657h, R.dimen.ds34), 0);
            }
            c1620c.j.setLayoutParams(layoutParams);
            c1620c.k = null;
        } else if (itemViewType == 2) {
            c1620c.m.setText(R.string.new_fans);
            c1620c.m.setVisibility(0);
        } else {
            c1620c.f61664c.setText(this.f61657h.getPageContext().getString(R.string.loading));
            c1620c.k.setVisibility(0);
        }
        h(view, c1620c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public final void h(View view, C1620c c1620c) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f61657h.getLayoutMode().k(skinType == 1);
        this.f61657h.getLayoutMode().j(view);
        if (c1620c != null) {
            TextView textView = c1620c.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(c1620c.m, R.color.CAM_X0205);
            }
            ImageView imageView = c1620c.j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.color.CAM_X0204);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton = c1620c.f61669h;
            if (newMyFansUserLikeButton != null) {
                newMyFansUserLikeButton.r(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        if (this.f61655f) {
            return false;
        }
        return super.isEnabled(i2);
    }
}
