package d.b.i0.v1;

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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton;
import com.baidu.tieba.myAttentionAndFans.PersonListActivity;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.h0.r.f0.q.c;
import d.b.h0.r.q.g1;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c extends d.b.i0.v1.b {

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f63005h;
    public boolean i;
    public int j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1657c f63006e;

        public a(C1657c c1657c) {
            this.f63006e = c1657c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f63006e.f63011c.getLayout();
            if (layout != null) {
                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                    this.f63006e.f63011c.setCompoundDrawablePadding(l.g(c.this.f63005h, R.dimen.tbds10));
                } else {
                    this.f63006e.f63011c.setCompoundDrawablePadding(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.d {
        public b() {
        }

        @Override // d.b.h0.r.f0.q.c.d
        public void a(boolean z) {
            if (z) {
                l.K(c.this.f63005h, R.string.attention_success);
            } else {
                l.K(c.this.f63005h, R.string.unfollow_success);
            }
        }
    }

    /* renamed from: d.b.i0.v1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1657c {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f63009a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f63010b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63011c;

        /* renamed from: d  reason: collision with root package name */
        public View f63012d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63013e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f63014f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f63015g;

        /* renamed from: h  reason: collision with root package name */
        public MyFansUserLikeButton f63016h;
        public d.b.h0.r.f0.q.c i;
        public ImageView j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public C1657c(c cVar) {
        }

        public /* synthetic */ C1657c(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f63005h = null;
        this.i = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.f63005h = personListActivity;
        this.i = z;
        this.j = i;
        this.k = onClickListener2;
        this.l = onClickListener;
        this.f63002e = new ArrayList<>();
    }

    @Override // d.b.i0.v1.b
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
        if (this.f63002e == null) {
            this.f63002e = new ArrayList<>();
        }
        arrayList.addAll(g1Var.b());
        if (!ListUtils.isEmpty(this.f63002e)) {
            ArrayList<UserData> arrayList2 = this.f63002e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f63002e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f63002e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f63002e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f63002e.addAll(arrayList);
                }
            }
        }
        int i = 0;
        while (i < arrayList.size() - 1) {
            UserData userData2 = (UserData) arrayList.get(i);
            i++;
            UserData userData3 = (UserData) arrayList.get(i);
            if (userData2 != null && userData3 != null && userData2.isNewFan && !userData3.isNewFan) {
                userData2.isLastNewFan = true;
            }
        }
        if (ListUtils.isEmpty(this.f63002e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f63002e.addAll(arrayList);
    }

    @Override // d.b.i0.v1.b
    public boolean d(long j) {
        ArrayList<UserData> arrayList;
        if (j != 0 && (arrayList = this.f63002e) != null && arrayList.size() != 0) {
            Iterator<UserData> it = this.f63002e.iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && next.getUserIdLong() == j) {
                    this.f63002e.remove(next);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f63003f) {
            return 1;
        }
        ArrayList<UserData> arrayList = this.f63002e;
        int size = arrayList != null ? arrayList.size() : 0;
        return c() ? size + 1 : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<UserData> arrayList = this.f63002e;
        if (arrayList == null || i >= arrayList.size()) {
            return null;
        }
        return this.f63002e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        ArrayList<UserData> arrayList = this.f63002e;
        if (arrayList == null || i >= arrayList.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f63003f) {
            return 0;
        }
        ArrayList<UserData> arrayList = this.f63002e;
        if (arrayList == null || i >= arrayList.size()) {
            return 1;
        }
        return this.f63002e.get(i).mAttentionType == 0 ? 2 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1657c c1657c;
        if (this.f63002e == null) {
            return view;
        }
        int itemViewType = getItemViewType(i);
        if (view != null && (view.getTag() instanceof C1657c)) {
            c1657c = (C1657c) view.getTag();
        } else {
            c1657c = new C1657c(this, null);
            if (itemViewType == 0) {
                view = LayoutInflater.from(this.f63005h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                c1657c.f63009a = viewGroup2;
                viewGroup2.setOnClickListener(this.l);
                ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                c1657c.f63010b = clickableHeaderImageView;
                clickableHeaderImageView.setRadius(l.g(this.f63005h.getPageContext().getPageActivity(), R.dimen.ds90));
                c1657c.f63010b.setAutoChangeStyle(true);
                c1657c.f63010b.setClickable(false);
                ((LinearLayout.LayoutParams) c1657c.f63010b.getLayoutParams()).setMargins(l.g(this.f63005h, R.dimen.ds34), 0, 0, 0);
                c1657c.f63014f = (LinearLayout) view.findViewById(R.id.info);
                c1657c.f63015g = (LinearLayout) view.findViewById(R.id.tail_container);
                TextView textView = (TextView) view.findViewById(R.id.name);
                c1657c.f63011c = textView;
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new a(c1657c));
                View a2 = d.b.h0.d.b.b().a(this.f63005h.getPageContext().getPageActivity(), 5);
                c1657c.f63012d = a2;
                if (a2 != null) {
                    a2.setVisibility(8);
                    c1657c.f63015g.addView(c1657c.f63012d, 1);
                }
                c1657c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                c1657c.f63013e = (TextView) view.findViewById(R.id.intro);
                MyFansUserLikeButton myFansUserLikeButton = (MyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                c1657c.f63016h = myFansUserLikeButton;
                myFansUserLikeButton.setContext(this.f63005h.getPageContext());
                ((LinearLayout.LayoutParams) c1657c.f63016h.getLayoutParams()).setMargins(0, 0, l.g(this.f63005h, R.dimen.ds34), 0);
                d.b.h0.r.f0.q.c cVar = new d.b.h0.r.f0.q.c(this.f63005h.getPageContext(), c1657c.f63016h);
                c1657c.i = cVar;
                cVar.n((d.b.h0.r.f0.q.a) ListUtils.getItem(this.f63002e, i));
                c1657c.i.o(new b());
                c1657c.k = null;
                c1657c.m = null;
                c1657c.j = (ImageView) view.findViewById(R.id.diver_buttom_px);
            } else if (itemViewType == 2) {
                view = LayoutInflater.from(this.f63005h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                c1657c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
            } else {
                view = LayoutInflater.from(this.f63005h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                c1657c.f63011c = (TextView) view.findViewById(R.id.pb_more_text);
                view.setOnClickListener(this.k);
                c1657c.k = (ProgressBar) view.findViewById(R.id.progress);
                c1657c.m = null;
            }
            view.setTag(c1657c);
        }
        MyFansUserLikeButton myFansUserLikeButton2 = c1657c.f63016h;
        if (myFansUserLikeButton2 != null) {
            myFansUserLikeButton2.setTag(Integer.valueOf(i));
        }
        if (itemViewType == 0) {
            if (this.f63003f) {
                c1657c.f63014f.setVisibility(8);
                c1657c.l.setVisibility(0);
                if (this.i) {
                    c1657c.l.setText(R.string.not_have_fans);
                } else {
                    int i2 = this.j;
                    if (i2 == 2) {
                        c1657c.l.setText(R.string.her_no_fan_other);
                    } else if (i2 == 1) {
                        c1657c.l.setText(R.string.him_no_fan_other);
                    } else {
                        c1657c.l.setText(R.string.no_fan_other);
                    }
                }
            } else {
                c1657c.f63009a.setTag(Integer.valueOf(i));
                UserData userData = (UserData) ListUtils.getItem(this.f63002e, i);
                if (userData == null) {
                    return view;
                }
                c1657c.l.setVisibility(8);
                UtilHelper.showHeadImageViewBigV(c1657c.f63010b, userData, 0);
                c1657c.f63011c.setText(UtilHelper.getUserName(userData));
                c1657c.f63010b.setPlaceHolder(1);
                c1657c.f63010b.W(userData.getAvater(), 12, false);
                if (c1657c.f63012d != null && userData.getAlaUserData() != null) {
                    if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                        c1657c.f63012d.setVisibility(8);
                    } else {
                        c1657c.f63012d.setVisibility(0);
                        d.b.h0.d.a aVar = new d.b.h0.d.a();
                        aVar.f50479a = userData.getAlaUserData();
                        aVar.f50480b = 5;
                        c1657c.f63012d.setTag(aVar);
                    }
                }
                if (k.isEmpty(userData.getIntro())) {
                    c1657c.f63013e.setVisibility(8);
                } else {
                    c1657c.f63013e.setVisibility(0);
                    c1657c.f63013e.setText(userData.getIntro());
                }
                String userId = userData.getUserId();
                userData.setIsLike(userData.getHave_attention() > 0);
                c1657c.i.n(userData);
                if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    c1657c.f63016h.setVisibility(8);
                } else {
                    c1657c.f63016h.setStatsParams(2, userId);
                    c1657c.i.m(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9);
                    c1657c.f63016h.setVisibility(0);
                }
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1657c.j.getLayoutParams();
            if (ListUtils.getItem(this.f63002e, i) != null && ((UserData) ListUtils.getItem(this.f63002e, i)).isLastNewFan) {
                layoutParams.height = l.g(this.f63005h, R.dimen.ds12);
                layoutParams.setMargins(0, 0, 0, 0);
                c1657c.j.setVisibility(0);
            } else {
                c1657c.j.setVisibility(8);
                layoutParams.height = l.g(this.f63005h, R.dimen.ds1);
                layoutParams.setMargins(l.g(this.f63005h, R.dimen.ds34), 0, l.g(this.f63005h, R.dimen.ds34), 0);
            }
            c1657c.j.setLayoutParams(layoutParams);
            c1657c.k = null;
        } else if (itemViewType == 2) {
            c1657c.m.setText(R.string.new_fans);
            c1657c.m.setVisibility(0);
        } else {
            c1657c.f63011c.setText(this.f63005h.getPageContext().getString(R.string.loading));
            c1657c.k.setVisibility(0);
        }
        h(view, c1657c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public final void h(View view, C1657c c1657c) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f63005h.getLayoutMode().k(skinType == 1);
        this.f63005h.getLayoutMode().j(view);
        if (c1657c != null) {
            TextView textView = c1657c.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(c1657c.m, R.color.CAM_X0205);
            }
            ImageView imageView = c1657c.j;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.color.CAM_X0204);
            }
            MyFansUserLikeButton myFansUserLikeButton = c1657c.f63016h;
            if (myFansUserLikeButton != null) {
                myFansUserLikeButton.g(skinType);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.f63003f) {
            return false;
        }
        return super.isEnabled(i);
    }
}
