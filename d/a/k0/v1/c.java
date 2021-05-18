package d.a.k0.v1;

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
import d.a.j0.r.f0.q.c;
import d.a.j0.r.q.g1;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c extends d.a.k0.v1.b {

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f62381h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62382i;
    public int j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1685c f62383e;

        public a(C1685c c1685c) {
            this.f62383e = c1685c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f62383e.f62388c.getLayout();
            if (layout != null) {
                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                    this.f62383e.f62388c.setCompoundDrawablePadding(l.g(c.this.f62381h, R.dimen.tbds10));
                } else {
                    this.f62383e.f62388c.setCompoundDrawablePadding(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.f {
        public b() {
        }

        @Override // d.a.j0.r.f0.q.c.f
        public void a(boolean z) {
            if (z) {
                l.L(c.this.f62381h, R.string.attention_success);
            } else {
                l.L(c.this.f62381h, R.string.unfollow_success);
            }
        }
    }

    /* renamed from: d.a.k0.v1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1685c {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f62386a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f62387b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f62388c;

        /* renamed from: d  reason: collision with root package name */
        public View f62389d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f62390e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f62391f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f62392g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f62393h;

        /* renamed from: i  reason: collision with root package name */
        public d.a.j0.r.f0.q.c f62394i;
        public ImageView j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public C1685c(c cVar) {
        }

        public /* synthetic */ C1685c(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(PersonListActivity personListActivity, boolean z, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f62381h = null;
        this.f62382i = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.f62381h = personListActivity;
        this.f62382i = z;
        this.j = i2;
        this.k = onClickListener2;
        this.l = onClickListener;
        this.f62378e = new ArrayList<>();
    }

    @Override // d.a.k0.v1.b
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
        if (this.f62378e == null) {
            this.f62378e = new ArrayList<>();
        }
        arrayList.addAll(g1Var.b());
        if (!ListUtils.isEmpty(this.f62378e)) {
            ArrayList<UserData> arrayList2 = this.f62378e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f62378e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f62378e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f62378e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f62378e.addAll(arrayList);
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
        if (ListUtils.isEmpty(this.f62378e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f62378e.addAll(arrayList);
    }

    @Override // d.a.k0.v1.b
    public boolean d(long j) {
        ArrayList<UserData> arrayList;
        if (j != 0 && (arrayList = this.f62378e) != null && arrayList.size() != 0) {
            Iterator<UserData> it = this.f62378e.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && next.getUserIdLong() == j) {
                    this.f62378e.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f62379f) {
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
        if (this.f62379f) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f62378e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return 1;
        }
        return this.f62378e.get(i2).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1685c c1685c;
        if (this.f62378e == null) {
            return view;
        }
        int itemViewType = getItemViewType(i2);
        if (view != null && (view.getTag() instanceof C1685c)) {
            c1685c = (C1685c) view.getTag();
        } else {
            c1685c = new C1685c(this, null);
            if (itemViewType == 0) {
                view = LayoutInflater.from(this.f62381h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                c1685c.f62386a = viewGroup2;
                viewGroup2.setOnClickListener(this.l);
                ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                c1685c.f62387b = clickableHeaderImageView;
                clickableHeaderImageView.setRadius(l.g(this.f62381h.getPageContext().getPageActivity(), R.dimen.ds90));
                c1685c.f62387b.setAutoChangeStyle(true);
                c1685c.f62387b.setClickable(false);
                ((LinearLayout.LayoutParams) c1685c.f62387b.getLayoutParams()).setMargins(l.g(this.f62381h, R.dimen.ds34), 0, 0, 0);
                c1685c.f62391f = (LinearLayout) view.findViewById(R.id.info);
                c1685c.f62392g = (LinearLayout) view.findViewById(R.id.tail_container);
                EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                c1685c.f62388c = eMTextView;
                eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(c1685c));
                View a2 = d.a.j0.d.c.b().a(this.f62381h.getPageContext().getPageActivity(), 5);
                c1685c.f62389d = a2;
                if (a2 != null) {
                    a2.setVisibility(8);
                    c1685c.f62392g.addView(c1685c.f62389d, 1);
                }
                c1685c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                c1685c.f62390e = (EMTextView) view.findViewById(R.id.intro);
                NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                c1685c.f62393h = newMyFansUserLikeButton;
                newMyFansUserLikeButton.setContext(this.f62381h.getPageContext());
                ((LinearLayout.LayoutParams) c1685c.f62393h.getLayoutParams()).setMargins(0, 0, l.g(this.f62381h, R.dimen.ds34), 0);
                d.a.j0.r.f0.q.c cVar = new d.a.j0.r.f0.q.c(this.f62381h.getPageContext(), c1685c.f62393h);
                c1685c.f62394i = cVar;
                cVar.n((d.a.j0.r.f0.q.a) ListUtils.getItem(this.f62378e, i2));
                c1685c.f62394i.o(new b());
                c1685c.k = null;
                c1685c.m = null;
                c1685c.j = (ImageView) view.findViewById(R.id.diver_buttom_px);
            } else if (itemViewType == 2) {
                view = LayoutInflater.from(this.f62381h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                c1685c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
            } else {
                view = LayoutInflater.from(this.f62381h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                c1685c.f62388c = (EMTextView) view.findViewById(R.id.pb_more_text);
                view.setOnClickListener(this.k);
                c1685c.k = (ProgressBar) view.findViewById(R.id.progress);
                c1685c.m = null;
            }
            view.setTag(c1685c);
        }
        NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1685c.f62393h;
        if (newMyFansUserLikeButton2 != null) {
            newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
        }
        if (itemViewType == 0) {
            if (this.f62379f) {
                c1685c.f62391f.setVisibility(8);
                c1685c.l.setVisibility(0);
                if (this.f62382i) {
                    c1685c.l.setText(R.string.not_have_fans);
                } else {
                    int i3 = this.j;
                    if (i3 == 2) {
                        c1685c.l.setText(R.string.her_no_fan_other);
                    } else if (i3 == 1) {
                        c1685c.l.setText(R.string.him_no_fan_other);
                    } else {
                        c1685c.l.setText(R.string.no_fan_other);
                    }
                }
            } else {
                c1685c.f62386a.setTag(Integer.valueOf(i2));
                UserData userData = (UserData) ListUtils.getItem(this.f62378e, i2);
                if (userData == null) {
                    return view;
                }
                c1685c.l.setVisibility(8);
                UtilHelper.showHeadImageViewBigV(c1685c.f62387b, userData, 0);
                c1685c.f62388c.setText(UtilHelper.getUserName(userData));
                c1685c.f62387b.setPlaceHolder(1);
                c1685c.f62387b.V(userData.getAvater(), 12, false);
                if (c1685c.f62389d != null && userData.getAlaUserData() != null) {
                    if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                        c1685c.f62389d.setVisibility(8);
                    } else {
                        c1685c.f62389d.setVisibility(0);
                        d.a.j0.d.b bVar = new d.a.j0.d.b();
                        bVar.f49218a = userData.getAlaUserData();
                        bVar.f49219b = 5;
                        c1685c.f62389d.setTag(bVar);
                    }
                }
                if (k.isEmpty(userData.getIntro())) {
                    c1685c.f62390e.setVisibility(8);
                } else {
                    c1685c.f62390e.setVisibility(0);
                    c1685c.f62390e.setText(userData.getIntro());
                }
                String userId = userData.getUserId();
                userData.setIsLike(userData.getHave_attention() > 0);
                c1685c.f62394i.n(userData);
                if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    c1685c.f62393h.setVisibility(8);
                } else {
                    c1685c.f62393h.setStatsParams(2, userId);
                    c1685c.f62394i.m(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9);
                    c1685c.f62393h.setVisibility(0);
                }
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1685c.j.getLayoutParams();
            if (ListUtils.getItem(this.f62378e, i2) != null && ((UserData) ListUtils.getItem(this.f62378e, i2)).isLastNewFan) {
                layoutParams.height = l.g(this.f62381h, R.dimen.ds12);
                layoutParams.setMargins(0, 0, 0, 0);
                c1685c.j.setVisibility(0);
            } else {
                c1685c.j.setVisibility(8);
                layoutParams.height = l.g(this.f62381h, R.dimen.ds1);
                layoutParams.setMargins(l.g(this.f62381h, R.dimen.ds34), 0, l.g(this.f62381h, R.dimen.ds34), 0);
            }
            c1685c.j.setLayoutParams(layoutParams);
            c1685c.k = null;
        } else if (itemViewType == 2) {
            c1685c.m.setText(R.string.new_fans);
            c1685c.m.setVisibility(0);
        } else {
            c1685c.f62388c.setText(this.f62381h.getPageContext().getString(R.string.loading));
            c1685c.k.setVisibility(0);
        }
        h(view, c1685c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public final void h(View view, C1685c c1685c) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f62381h.getLayoutMode().k(skinType == 1);
        this.f62381h.getLayoutMode().j(view);
        if (c1685c != null) {
            TextView textView = c1685c.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(c1685c.m, R.color.CAM_X0205);
            }
            ImageView imageView = c1685c.j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.color.CAM_X0204);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton = c1685c.f62393h;
            if (newMyFansUserLikeButton != null) {
                newMyFansUserLikeButton.r(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        if (this.f62379f) {
            return false;
        }
        return super.isEnabled(i2);
    }
}
