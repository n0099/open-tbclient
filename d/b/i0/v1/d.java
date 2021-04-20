package d.b.i0.v1;

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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.MyFansUserLikeButton;
import com.baidu.tieba.myAttentionAndFans.PersonListActivity;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.h0.r.q.g1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d extends d.b.i0.v1.b {

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f63017h;
    public boolean j;
    public boolean k;
    public int l;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public boolean i = false;
    public HashSet<Long> m = new HashSet<>();

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f63018e;

        public a(b bVar) {
            this.f63018e = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout = this.f63018e.f63022c.getLayout();
            if (layout != null) {
                if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                    this.f63018e.f63022c.setCompoundDrawablePadding(l.g(d.this.f63017h, R.dimen.tbds10));
                } else {
                    this.f63018e.f63022c.setCompoundDrawablePadding(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f63020a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f63021b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63022c;

        /* renamed from: d  reason: collision with root package name */
        public View f63023d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63024e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f63025f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f63026g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f63027h;
        public MyFansUserLikeButton i;
        public d.b.h0.r.f0.q.c j;
        public ProgressBar k;
        public TextView l;
        public TextView m;
        public LinearLayout n;

        public b(d dVar) {
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.f63017h = null;
        this.j = false;
        this.k = true;
        this.l = 0;
        this.n = null;
        this.o = null;
        this.p = null;
        this.f63017h = personListActivity;
        this.j = z;
        this.k = z2;
        this.l = i;
        this.n = onClickListener2;
        this.o = onClickListener3;
        this.p = onClickListener;
        this.f63002e = new ArrayList<>();
    }

    @Override // d.b.i0.v1.b
    public void a(g1 g1Var) {
        ArrayList arrayList = new ArrayList();
        if (this.f63002e.isEmpty() && !ListUtils.isEmpty(g1Var.a())) {
            Iterator<UserData> it = g1Var.a().iterator();
            while (it.hasNext()) {
                UserData next = it.next();
                if (next != null && !StringUtils.isNull(next.getUserId())) {
                    this.m.add(Long.valueOf(d.b.c.e.m.b.f(next.getUserId(), 0L)));
                }
            }
            arrayList.addAll(g1Var.a());
            UserData userData = new UserData();
            userData.mAttentionType = 0;
            arrayList.add(userData);
        }
        arrayList.addAll(i(g1Var.b()));
        this.f63002e.addAll(arrayList);
    }

    @Override // d.b.i0.v1.b
    public boolean d(long j) {
        ArrayList<UserData> arrayList;
        boolean z = false;
        if (j != 0 && (arrayList = this.f63002e) != null && arrayList.size() != 0) {
            Iterator<UserData> it = this.f63002e.iterator();
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
        if (this.i) {
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
        if (this.i) {
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
        b bVar;
        if (this.f63002e == null) {
            return view;
        }
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        } else {
            bVar = new b(this, null);
            if (getItemViewType(i) == 0) {
                view = LayoutInflater.from(this.f63017h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                bVar.f63020a = viewGroup2;
                viewGroup2.setOnClickListener(this.p);
                ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                bVar.f63021b = clickableHeaderImageView;
                clickableHeaderImageView.setRadius(l.g(this.f63017h.getPageContext().getPageActivity(), R.dimen.ds90));
                bVar.f63021b.setAutoChangeStyle(true);
                bVar.f63021b.setClickable(false);
                bVar.f63026g = (LinearLayout) view.findViewById(R.id.info);
                bVar.f63027h = (LinearLayout) view.findViewById(R.id.tail_container);
                TextView textView = (TextView) view.findViewById(R.id.name);
                bVar.f63022c = textView;
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new a(bVar));
                View a2 = d.b.h0.d.b.b().a(this.f63017h.getPageContext().getPageActivity(), 5);
                bVar.f63023d = a2;
                if (a2 != null) {
                    a2.setVisibility(8);
                    bVar.f63027h.addView(bVar.f63023d, 1);
                }
                bVar.l = (TextView) view.findViewById(R.id.at_list_nodata);
                bVar.f63024e = (TextView) view.findViewById(R.id.intro);
                TextView textView2 = (TextView) view.findViewById(R.id.chat);
                bVar.f63025f = textView2;
                textView2.setOnClickListener(this.n);
                MyFansUserLikeButton myFansUserLikeButton = (MyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                bVar.i = myFansUserLikeButton;
                myFansUserLikeButton.setContext(this.f63017h.getPageContext());
                bVar.j = new d.b.h0.r.f0.q.c(this.f63017h.getPageContext(), bVar.i);
                bVar.k = null;
                bVar.m = null;
                bVar.n = null;
            } else if (getItemViewType(i) == 2) {
                view = LayoutInflater.from(this.f63017h.getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
                TextView textView3 = (TextView) view.findViewById(R.id.person_list_title);
                bVar.m = textView3;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds16);
                bVar.m.setLayoutParams(layoutParams);
                bVar.n = (LinearLayout) view.findViewById(R.id.newheader_root);
            } else {
                view = LayoutInflater.from(this.f63017h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                bVar.f63022c = (TextView) view.findViewById(R.id.pb_more_text);
                view.setOnClickListener(this.o);
                bVar.k = (ProgressBar) view.findViewById(R.id.progress);
                bVar.m = null;
                bVar.n = null;
            }
            view.setTag(bVar);
        }
        MyFansUserLikeButton myFansUserLikeButton2 = bVar.i;
        if (myFansUserLikeButton2 != null) {
            myFansUserLikeButton2.setTag(Integer.valueOf(i));
        }
        if (getItemViewType(i) == 0) {
            if (this.i) {
                bVar.f63026g.setVisibility(8);
                bVar.f63025f.setVisibility(8);
                bVar.l.setVisibility(0);
                if (this.j) {
                    if (this.k) {
                        bVar.l.setText(R.string.not_have_attention);
                    } else {
                        int i2 = this.l;
                        if (i2 == 2) {
                            bVar.l.setText(R.string.her_no_attention_other);
                        } else if (i2 == 1) {
                            bVar.l.setText(R.string.him_no_attention_other);
                        } else {
                            bVar.l.setText(R.string.no_attention_other);
                        }
                    }
                } else if (this.k) {
                    bVar.l.setText(R.string.not_have_fans);
                } else {
                    int i3 = this.l;
                    if (i3 == 2) {
                        bVar.l.setText(R.string.her_no_fan_other);
                    } else if (i3 == 1) {
                        bVar.l.setText(R.string.him_no_fan_other);
                    } else {
                        bVar.l.setText(R.string.no_fan_other);
                    }
                }
            } else {
                UserData userData = (UserData) ListUtils.getItem(this.f63002e, i);
                if (userData == null) {
                    return null;
                }
                bVar.f63020a.setTag(Integer.valueOf(i));
                bVar.f63025f.setVisibility(0);
                bVar.l.setVisibility(8);
                UtilHelper.showHeadImageViewBigV(bVar.f63021b, userData, 0);
                bVar.f63022c.setText(UtilHelper.getUserName(userData));
                bVar.f63021b.setPlaceHolder(1);
                bVar.f63021b.W(userData.getAvater(), 12, false);
                if (bVar.f63023d != null && userData.getAlaUserData() != null) {
                    if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                        bVar.f63023d.setVisibility(8);
                    } else {
                        bVar.f63023d.setVisibility(0);
                        d.b.h0.d.a aVar = new d.b.h0.d.a();
                        aVar.f50479a = userData.getAlaUserData();
                        aVar.f50480b = 5;
                        bVar.f63023d.setTag(aVar);
                    }
                }
                if (k.isEmpty(userData.getIntro())) {
                    bVar.f63024e.setVisibility(8);
                } else {
                    bVar.f63024e.setVisibility(0);
                    bVar.f63024e.setText(userData.getIntro());
                }
                bVar.f63025f.setTag(Integer.valueOf(i));
                String userId = userData.getUserId();
                bVar.i.setStatsParams(1, userId);
                userData.setIsLike(userData.getHave_attention() > 0);
                bVar.j.n(userData);
                if ((!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) || userData.mAttentionType == 1) {
                    bVar.i.setVisibility(8);
                    bVar.f63025f.setVisibility(8);
                } else {
                    bVar.f63025f.setVisibility(8);
                    bVar.i.setVisibility(0);
                }
            }
            bVar.k = null;
        } else if (getItemViewType(i) != 2) {
            bVar.f63022c.setText(this.f63017h.getPageContext().getString(R.string.loading));
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
        this.f63017h.getLayoutMode().k(skinType == 1);
        this.f63017h.getLayoutMode().j(view);
        if (bVar != null) {
            TextView textView = bVar.f63025f;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
                SkinManager.setBackgroundResource(bVar.f63025f, R.drawable.btn_focus_border_bg);
                bVar.f63025f.setEnabled(true);
            }
            LinearLayout linearLayout = bVar.n;
            if (linearLayout != null && bVar.m != null) {
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0205);
                SkinManager.setViewTextColor(bVar.m, R.color.CAM_X0110);
            }
            MyFansUserLikeButton myFansUserLikeButton = bVar.i;
            if (myFansUserLikeButton != null) {
                myFansUserLikeButton.g(skinType);
            }
        }
    }

    public final ArrayList<UserData> i(ArrayList<UserData> arrayList) {
        if (ListUtils.isEmpty(arrayList) || this.m.isEmpty()) {
            return arrayList;
        }
        ArrayList<UserData> arrayList2 = new ArrayList<>();
        Iterator<UserData> it = arrayList.iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (next != null && !StringUtils.isNull(next.getUserId()) && !this.m.contains(Long.valueOf(d.b.c.e.m.b.f(next.getUserId(), 0L)))) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.i) {
            return false;
        }
        return super.isEnabled(i);
    }
}
