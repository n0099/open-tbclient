package d.a.p0.z1;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.r.f0.t.c;
import d.a.o0.r.q.h1;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class c extends d.a.p0.z1.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f66526h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66527i;
    public int j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1861c f66528e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f66529f;

        public a(c cVar, C1861c c1861c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c1861c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66529f = cVar;
            this.f66528e = c1861c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f66528e.f66533c.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f66528e.f66533c.setCompoundDrawablePadding(l.g(this.f66529f.f66526h, R.dimen.tbds10));
            } else {
                this.f66528e.f66533c.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f66530a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66530a = cVar;
        }

        @Override // d.a.o0.r.f0.t.c.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l.L(this.f66530a.f66526h, R.string.attention_success);
                } else {
                    l.L(this.f66530a.f66526h, R.string.unfollow_success);
                }
            }
        }
    }

    /* renamed from: d.a.p0.z1.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1861c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f66531a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f66532b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f66533c;

        /* renamed from: d  reason: collision with root package name */
        public View f66534d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f66535e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f66536f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f66537g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f66538h;

        /* renamed from: i  reason: collision with root package name */
        public d.a.o0.r.f0.t.c f66539i;
        public ImageView j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public C1861c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1861c(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(PersonListActivity personListActivity, boolean z, int i2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personListActivity, Boolean.valueOf(z), Integer.valueOf(i2), onClickListener, onClickListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66526h = null;
        this.f66527i = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.f66526h = personListActivity;
        this.f66527i = z;
        this.j = i2;
        this.k = onClickListener2;
        this.l = onClickListener;
        this.f66523e = new ArrayList<>();
    }

    @Override // d.a.p0.z1.b
    public void a(h1 h1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, h1Var) == null) || h1Var == null || h1Var.b() == null) {
            return;
        }
        Iterator<UserData> it = h1Var.b().iterator();
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
        if (this.f66523e == null) {
            this.f66523e = new ArrayList<>();
        }
        arrayList.addAll(h1Var.b());
        if (!ListUtils.isEmpty(this.f66523e)) {
            ArrayList<UserData> arrayList2 = this.f66523e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f66523e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f66523e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f66523e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f66523e.addAll(arrayList);
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
        if (ListUtils.isEmpty(this.f66523e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f66523e.addAll(arrayList);
    }

    @Override // d.a.p0.z1.b
    public boolean d(long j) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j != 0 && (arrayList = this.f66523e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f66523e.iterator();
                while (it.hasNext()) {
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j) {
                        this.f66523e.remove(next);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f66524f) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f66523e;
            int size = arrayList != null ? arrayList.size() : 0;
            return c() ? size + 1 : size;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f66523e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f66523e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f66523e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return -1L;
            }
            return i2;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (this.f66524f) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f66523e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            return this.f66523e.get(i2).mAttentionType == 0 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1861c c1861c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f66523e == null) {
                return view;
            }
            int itemViewType = getItemViewType(i2);
            if (view != null && (view.getTag() instanceof C1861c)) {
                c1861c = (C1861c) view.getTag();
            } else {
                c1861c = new C1861c(this, null);
                if (itemViewType == 0) {
                    view = LayoutInflater.from(this.f66526h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c1861c.f66531a = viewGroup2;
                    viewGroup2.setOnClickListener(this.l);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c1861c.f66532b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(l.g(this.f66526h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c1861c.f66532b.setAutoChangeStyle(true);
                    c1861c.f66532b.setClickable(false);
                    ((LinearLayout.LayoutParams) c1861c.f66532b.getLayoutParams()).setMargins(l.g(this.f66526h, R.dimen.ds34), 0, 0, 0);
                    c1861c.f66536f = (LinearLayout) view.findViewById(R.id.info);
                    c1861c.f66537g = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c1861c.f66533c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c1861c));
                    View a2 = d.a.o0.d.c.b().a(this.f66526h.getPageContext().getPageActivity(), 5);
                    c1861c.f66534d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c1861c.f66537g.addView(c1861c.f66534d, 1);
                    }
                    c1861c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                    c1861c.f66535e = (EMTextView) view.findViewById(R.id.intro);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c1861c.f66538h = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f66526h.getPageContext());
                    ((LinearLayout.LayoutParams) c1861c.f66538h.getLayoutParams()).setMargins(0, 0, l.g(this.f66526h, R.dimen.ds34), 0);
                    d.a.o0.r.f0.t.c cVar = new d.a.o0.r.f0.t.c(this.f66526h.getPageContext(), c1861c.f66538h);
                    c1861c.f66539i = cVar;
                    cVar.n((d.a.o0.r.f0.t.a) ListUtils.getItem(this.f66523e, i2));
                    c1861c.f66539i.o(new b(this));
                    c1861c.k = null;
                    c1861c.m = null;
                    c1861c.j = (ImageView) view.findViewById(R.id.diver_buttom_px);
                } else if (itemViewType == 2) {
                    view = LayoutInflater.from(this.f66526h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    c1861c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
                } else {
                    view = LayoutInflater.from(this.f66526h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c1861c.f66533c = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.k);
                    c1861c.k = (ProgressBar) view.findViewById(R.id.progress);
                    c1861c.m = null;
                }
                view.setTag(c1861c);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1861c.f66538h;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            if (itemViewType == 0) {
                if (this.f66524f) {
                    c1861c.f66536f.setVisibility(8);
                    c1861c.l.setVisibility(0);
                    if (this.f66527i) {
                        c1861c.l.setText(R.string.not_have_fans);
                    } else {
                        int i3 = this.j;
                        if (i3 == 2) {
                            c1861c.l.setText(R.string.her_no_fan_other);
                        } else if (i3 == 1) {
                            c1861c.l.setText(R.string.him_no_fan_other);
                        } else {
                            c1861c.l.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    c1861c.f66531a.setTag(Integer.valueOf(i2));
                    UserData userData = (UserData) ListUtils.getItem(this.f66523e, i2);
                    if (userData == null) {
                        return view;
                    }
                    c1861c.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c1861c.f66532b, userData, 0);
                    c1861c.f66533c.setText(UtilHelper.getUserName(userData));
                    c1861c.f66532b.setPlaceHolder(1);
                    c1861c.f66532b.M(userData.getAvater(), 12, false);
                    if (c1861c.f66534d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c1861c.f66534d.setVisibility(8);
                        } else {
                            c1861c.f66534d.setVisibility(0);
                            d.a.o0.d.b bVar = new d.a.o0.d.b();
                            bVar.f51884a = userData.getAlaUserData();
                            bVar.f51885b = 5;
                            c1861c.f66534d.setTag(bVar);
                        }
                    }
                    if (k.isEmpty(userData.getIntro())) {
                        c1861c.f66535e.setVisibility(8);
                    } else {
                        c1861c.f66535e.setVisibility(0);
                        c1861c.f66535e.setText(userData.getIntro());
                    }
                    String userId = userData.getUserId();
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c1861c.f66539i.n(userData);
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        c1861c.f66538h.setVisibility(8);
                    } else {
                        c1861c.f66538h.setStatsParams(2, userId);
                        c1861c.f66539i.m("9");
                        c1861c.f66538h.setVisibility(0);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1861c.j.getLayoutParams();
                if (ListUtils.getItem(this.f66523e, i2) != null && ((UserData) ListUtils.getItem(this.f66523e, i2)).isLastNewFan) {
                    layoutParams.height = l.g(this.f66526h, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    c1861c.j.setVisibility(0);
                } else {
                    c1861c.j.setVisibility(8);
                    layoutParams.height = l.g(this.f66526h, R.dimen.ds1);
                    layoutParams.setMargins(l.g(this.f66526h, R.dimen.ds34), 0, l.g(this.f66526h, R.dimen.ds34), 0);
                }
                c1861c.j.setLayoutParams(layoutParams);
                c1861c.k = null;
            } else if (itemViewType == 2) {
                c1861c.m.setText(R.string.new_fans);
                c1861c.m.setVisibility(0);
            } else {
                c1861c.f66533c.setText(this.f66526h.getPageContext().getString(R.string.loading));
                c1861c.k.setVisibility(0);
            }
            h(view, c1861c);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    public final void h(View view, C1861c c1861c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c1861c) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f66526h.getLayoutMode().k(skinType == 1);
            this.f66526h.getLayoutMode().j(view);
            if (c1861c != null) {
                TextView textView = c1861c.m;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(c1861c.m, R.color.CAM_X0205);
                }
                ImageView imageView = c1861c.j;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.color.CAM_X0204);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c1861c.f66538h;
                if (newMyFansUserLikeButton != null) {
                    newMyFansUserLikeButton.r(skinType);
                }
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.f66524f) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
