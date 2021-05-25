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
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.f0.q.c;
import d.a.m0.r.q.g1;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c extends d.a.n0.w1.b {

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f62487h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62488i;
    public int j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1698c f62489e;

        public a(C1698c c1698c) {
            this.f62489e = c1698c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f62489e.f62494c.getLayout();
            if (layout != null) {
                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                    this.f62489e.f62494c.setCompoundDrawablePadding(l.g(c.this.f62487h, R.dimen.tbds10));
                } else {
                    this.f62489e.f62494c.setCompoundDrawablePadding(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.f {
        public b() {
        }

        @Override // d.a.m0.r.f0.q.c.f
        public void a(boolean z) {
            if (z) {
                l.L(c.this.f62487h, R.string.attention_success);
            } else {
                l.L(c.this.f62487h, R.string.unfollow_success);
            }
        }
    }

    /* renamed from: d.a.n0.w1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1698c {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f62492a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f62493b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f62494c;

        /* renamed from: d  reason: collision with root package name */
        public View f62495d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f62496e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f62497f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f62498g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f62499h;

        /* renamed from: i  reason: collision with root package name */
        public d.a.m0.r.f0.q.c f62500i;
        public ImageView j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public C1698c(c cVar) {
        }

        public /* synthetic */ C1698c(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(PersonListActivity personListActivity, boolean z, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f62487h = null;
        this.f62488i = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.f62487h = personListActivity;
        this.f62488i = z;
        this.j = i2;
        this.k = onClickListener2;
        this.l = onClickListener;
        this.f62484e = new ArrayList<>();
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
        if (this.f62484e == null) {
            this.f62484e = new ArrayList<>();
        }
        arrayList.addAll(g1Var.b());
        if (!ListUtils.isEmpty(this.f62484e)) {
            ArrayList<UserData> arrayList2 = this.f62484e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f62484e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f62484e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f62484e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f62484e.addAll(arrayList);
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
        if (ListUtils.isEmpty(this.f62484e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f62484e.addAll(arrayList);
    }

    @Override // d.a.n0.w1.b
    public boolean d(long j) {
        ArrayList<UserData> arrayList;
        if (j != 0 && (arrayList = this.f62484e) != null && arrayList.size() != 0) {
            Iterator<UserData> it = this.f62484e.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && next.getUserIdLong() == j) {
                    this.f62484e.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f62485f) {
            return 1;
        }
        ArrayList<UserData> arrayList = this.f62484e;
        int size = arrayList != null ? arrayList.size() : 0;
        return c() ? size + 1 : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        ArrayList<UserData> arrayList = this.f62484e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.f62484e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        ArrayList<UserData> arrayList = this.f62484e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return -1L;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (this.f62485f) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f62484e;
        if (arrayList == null || i2 >= arrayList.size()) {
            return 1;
        }
        return this.f62484e.get(i2).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1698c c1698c;
        if (this.f62484e == null) {
            return view;
        }
        int itemViewType = getItemViewType(i2);
        if (view != null && (view.getTag() instanceof C1698c)) {
            c1698c = (C1698c) view.getTag();
        } else {
            c1698c = new C1698c(this, null);
            if (itemViewType == 0) {
                view = LayoutInflater.from(this.f62487h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                c1698c.f62492a = viewGroup2;
                viewGroup2.setOnClickListener(this.l);
                ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                c1698c.f62493b = clickableHeaderImageView;
                clickableHeaderImageView.setRadius(l.g(this.f62487h.getPageContext().getPageActivity(), R.dimen.ds90));
                c1698c.f62493b.setAutoChangeStyle(true);
                c1698c.f62493b.setClickable(false);
                ((LinearLayout.LayoutParams) c1698c.f62493b.getLayoutParams()).setMargins(l.g(this.f62487h, R.dimen.ds34), 0, 0, 0);
                c1698c.f62497f = (LinearLayout) view.findViewById(R.id.info);
                c1698c.f62498g = (LinearLayout) view.findViewById(R.id.tail_container);
                EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                c1698c.f62494c = eMTextView;
                eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(c1698c));
                View a2 = d.a.m0.d.c.b().a(this.f62487h.getPageContext().getPageActivity(), 5);
                c1698c.f62495d = a2;
                if (a2 != null) {
                    a2.setVisibility(8);
                    c1698c.f62498g.addView(c1698c.f62495d, 1);
                }
                c1698c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                c1698c.f62496e = (EMTextView) view.findViewById(R.id.intro);
                NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                c1698c.f62499h = newMyFansUserLikeButton;
                newMyFansUserLikeButton.setContext(this.f62487h.getPageContext());
                ((LinearLayout.LayoutParams) c1698c.f62499h.getLayoutParams()).setMargins(0, 0, l.g(this.f62487h, R.dimen.ds34), 0);
                d.a.m0.r.f0.q.c cVar = new d.a.m0.r.f0.q.c(this.f62487h.getPageContext(), c1698c.f62499h);
                c1698c.f62500i = cVar;
                cVar.n((d.a.m0.r.f0.q.a) ListUtils.getItem(this.f62484e, i2));
                c1698c.f62500i.o(new b());
                c1698c.k = null;
                c1698c.m = null;
                c1698c.j = (ImageView) view.findViewById(R.id.diver_buttom_px);
            } else if (itemViewType == 2) {
                view = LayoutInflater.from(this.f62487h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                c1698c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
            } else {
                view = LayoutInflater.from(this.f62487h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                c1698c.f62494c = (EMTextView) view.findViewById(R.id.pb_more_text);
                view.setOnClickListener(this.k);
                c1698c.k = (ProgressBar) view.findViewById(R.id.progress);
                c1698c.m = null;
            }
            view.setTag(c1698c);
        }
        NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1698c.f62499h;
        if (newMyFansUserLikeButton2 != null) {
            newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
        }
        if (itemViewType == 0) {
            if (this.f62485f) {
                c1698c.f62497f.setVisibility(8);
                c1698c.l.setVisibility(0);
                if (this.f62488i) {
                    c1698c.l.setText(R.string.not_have_fans);
                } else {
                    int i3 = this.j;
                    if (i3 == 2) {
                        c1698c.l.setText(R.string.her_no_fan_other);
                    } else if (i3 == 1) {
                        c1698c.l.setText(R.string.him_no_fan_other);
                    } else {
                        c1698c.l.setText(R.string.no_fan_other);
                    }
                }
            } else {
                c1698c.f62492a.setTag(Integer.valueOf(i2));
                UserData userData = (UserData) ListUtils.getItem(this.f62484e, i2);
                if (userData == null) {
                    return view;
                }
                c1698c.l.setVisibility(8);
                UtilHelper.showHeadImageViewBigV(c1698c.f62493b, userData, 0);
                c1698c.f62494c.setText(UtilHelper.getUserName(userData));
                c1698c.f62493b.setPlaceHolder(1);
                c1698c.f62493b.V(userData.getAvater(), 12, false);
                if (c1698c.f62495d != null && userData.getAlaUserData() != null) {
                    if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                        c1698c.f62495d.setVisibility(8);
                    } else {
                        c1698c.f62495d.setVisibility(0);
                        d.a.m0.d.b bVar = new d.a.m0.d.b();
                        bVar.f49262a = userData.getAlaUserData();
                        bVar.f49263b = 5;
                        c1698c.f62495d.setTag(bVar);
                    }
                }
                if (k.isEmpty(userData.getIntro())) {
                    c1698c.f62496e.setVisibility(8);
                } else {
                    c1698c.f62496e.setVisibility(0);
                    c1698c.f62496e.setText(userData.getIntro());
                }
                String userId = userData.getUserId();
                userData.setIsLike(userData.getHave_attention() > 0);
                c1698c.f62500i.n(userData);
                if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    c1698c.f62499h.setVisibility(8);
                } else {
                    c1698c.f62499h.setStatsParams(2, userId);
                    c1698c.f62500i.m(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9);
                    c1698c.f62499h.setVisibility(0);
                }
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1698c.j.getLayoutParams();
            if (ListUtils.getItem(this.f62484e, i2) != null && ((UserData) ListUtils.getItem(this.f62484e, i2)).isLastNewFan) {
                layoutParams.height = l.g(this.f62487h, R.dimen.ds12);
                layoutParams.setMargins(0, 0, 0, 0);
                c1698c.j.setVisibility(0);
            } else {
                c1698c.j.setVisibility(8);
                layoutParams.height = l.g(this.f62487h, R.dimen.ds1);
                layoutParams.setMargins(l.g(this.f62487h, R.dimen.ds34), 0, l.g(this.f62487h, R.dimen.ds34), 0);
            }
            c1698c.j.setLayoutParams(layoutParams);
            c1698c.k = null;
        } else if (itemViewType == 2) {
            c1698c.m.setText(R.string.new_fans);
            c1698c.m.setVisibility(0);
        } else {
            c1698c.f62494c.setText(this.f62487h.getPageContext().getString(R.string.loading));
            c1698c.k.setVisibility(0);
        }
        h(view, c1698c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public final void h(View view, C1698c c1698c) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f62487h.getLayoutMode().k(skinType == 1);
        this.f62487h.getLayoutMode().j(view);
        if (c1698c != null) {
            TextView textView = c1698c.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(c1698c.m, R.color.CAM_X0205);
            }
            ImageView imageView = c1698c.j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.color.CAM_X0204);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton = c1698c.f62499h;
            if (newMyFansUserLikeButton != null) {
                newMyFansUserLikeButton.r(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        if (this.f62485f) {
            return false;
        }
        return super.isEnabled(i2);
    }
}
