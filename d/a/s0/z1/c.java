package d.a.s0.z1;

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
import d.a.r0.r.f0.s.c;
import d.a.r0.r.q.h1;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class c extends d.a.s0.z1.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public PersonListActivity f69723h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f69724i;
    public int j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: classes9.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C1902c f69725e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f69726f;

        public a(c cVar, C1902c c1902c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c1902c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69726f = cVar;
            this.f69725e = c1902c;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.f69725e.f69730c.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.f69725e.f69730c.setCompoundDrawablePadding(l.g(this.f69726f.f69723h, R.dimen.tbds10));
            } else {
                this.f69725e.f69730c.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f69727a;

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
            this.f69727a = cVar;
        }

        @Override // d.a.r0.r.f0.s.c.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l.L(this.f69727a.f69723h, R.string.attention_success);
                } else {
                    l.L(this.f69727a.f69723h, R.string.unfollow_success);
                }
            }
        }
    }

    /* renamed from: d.a.s0.z1.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1902c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f69728a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f69729b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f69730c;

        /* renamed from: d  reason: collision with root package name */
        public View f69731d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f69732e;

        /* renamed from: f  reason: collision with root package name */
        public LinearLayout f69733f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f69734g;

        /* renamed from: h  reason: collision with root package name */
        public NewMyFansUserLikeButton f69735h;

        /* renamed from: i  reason: collision with root package name */
        public d.a.r0.r.f0.s.c f69736i;
        public ImageView j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public C1902c(c cVar) {
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

        public /* synthetic */ C1902c(c cVar, a aVar) {
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
        this.f69723h = null;
        this.f69724i = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.f69723h = personListActivity;
        this.f69724i = z;
        this.j = i2;
        this.k = onClickListener2;
        this.l = onClickListener;
        this.f69720e = new ArrayList<>();
    }

    @Override // d.a.s0.z1.b
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
        if (this.f69720e == null) {
            this.f69720e = new ArrayList<>();
        }
        arrayList.addAll(h1Var.b());
        if (!ListUtils.isEmpty(this.f69720e)) {
            ArrayList<UserData> arrayList2 = this.f69720e;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.f69720e;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.f69720e;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.f69720e) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.f69720e.addAll(arrayList);
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
        if (ListUtils.isEmpty(this.f69720e)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.f69720e.addAll(arrayList);
    }

    @Override // d.a.s0.z1.b
    public boolean d(long j) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j != 0 && (arrayList = this.f69720e) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.f69720e.iterator();
                while (it.hasNext()) {
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j) {
                        this.f69720e.remove(next);
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
            if (this.f69721f) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.f69720e;
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
            ArrayList<UserData> arrayList = this.f69720e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f69720e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            ArrayList<UserData> arrayList = this.f69720e;
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
            if (this.f69721f) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.f69720e;
            if (arrayList == null || i2 >= arrayList.size()) {
                return 1;
            }
            return this.f69720e.get(i2).mAttentionType == 0 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1902c c1902c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (this.f69720e == null) {
                return view;
            }
            int itemViewType = getItemViewType(i2);
            if (view != null && (view.getTag() instanceof C1902c)) {
                c1902c = (C1902c) view.getTag();
            } else {
                c1902c = new C1902c(this, null);
                if (itemViewType == 0) {
                    view = LayoutInflater.from(this.f69723h.getPageContext().getPageActivity()).inflate(R.layout.person_list_item, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.item_view);
                    c1902c.f69728a = viewGroup2;
                    viewGroup2.setOnClickListener(this.l);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) view.findViewById(R.id.photo);
                    c1902c.f69729b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(l.g(this.f69723h.getPageContext().getPageActivity(), R.dimen.ds90));
                    c1902c.f69729b.setAutoChangeStyle(true);
                    c1902c.f69729b.setClickable(false);
                    ((LinearLayout.LayoutParams) c1902c.f69729b.getLayoutParams()).setMargins(l.g(this.f69723h, R.dimen.ds34), 0, 0, 0);
                    c1902c.f69733f = (LinearLayout) view.findViewById(R.id.info);
                    c1902c.f69734g = (LinearLayout) view.findViewById(R.id.tail_container);
                    EMTextView eMTextView = (EMTextView) view.findViewById(R.id.name);
                    c1902c.f69730c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, c1902c));
                    View a2 = d.a.r0.d.c.b().a(this.f69723h.getPageContext().getPageActivity(), 5);
                    c1902c.f69731d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        c1902c.f69734g.addView(c1902c.f69731d, 1);
                    }
                    c1902c.l = (TextView) view.findViewById(R.id.at_list_nodata);
                    c1902c.f69732e = (EMTextView) view.findViewById(R.id.intro);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) view.findViewById(R.id.attention_btn);
                    c1902c.f69735h = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.f69723h.getPageContext());
                    ((LinearLayout.LayoutParams) c1902c.f69735h.getLayoutParams()).setMargins(0, 0, l.g(this.f69723h, R.dimen.ds34), 0);
                    d.a.r0.r.f0.s.c cVar = new d.a.r0.r.f0.s.c(this.f69723h.getPageContext(), c1902c.f69735h);
                    c1902c.f69736i = cVar;
                    cVar.n((d.a.r0.r.f0.s.a) ListUtils.getItem(this.f69720e, i2));
                    c1902c.f69736i.o(new b(this));
                    c1902c.k = null;
                    c1902c.m = null;
                    c1902c.j = (ImageView) view.findViewById(R.id.diver_buttom_px);
                } else if (itemViewType == 2) {
                    view = LayoutInflater.from(this.f69723h.getPageContext().getPageActivity()).inflate(R.layout.my_fan_list_title, (ViewGroup) null);
                    c1902c.m = (TextView) view.findViewById(R.id.my_new_fan_title);
                } else {
                    view = LayoutInflater.from(this.f69723h.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    c1902c.f69730c = (EMTextView) view.findViewById(R.id.pb_more_text);
                    view.setOnClickListener(this.k);
                    c1902c.k = (ProgressBar) view.findViewById(R.id.progress);
                    c1902c.m = null;
                }
                view.setTag(c1902c);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = c1902c.f69735h;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i2));
            }
            if (itemViewType == 0) {
                if (this.f69721f) {
                    c1902c.f69733f.setVisibility(8);
                    c1902c.l.setVisibility(0);
                    if (this.f69724i) {
                        c1902c.l.setText(R.string.not_have_fans);
                    } else {
                        int i3 = this.j;
                        if (i3 == 2) {
                            c1902c.l.setText(R.string.her_no_fan_other);
                        } else if (i3 == 1) {
                            c1902c.l.setText(R.string.him_no_fan_other);
                        } else {
                            c1902c.l.setText(R.string.no_fan_other);
                        }
                    }
                } else {
                    c1902c.f69728a.setTag(Integer.valueOf(i2));
                    UserData userData = (UserData) ListUtils.getItem(this.f69720e, i2);
                    if (userData == null) {
                        return view;
                    }
                    c1902c.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(c1902c.f69729b, userData, 0);
                    c1902c.f69730c.setText(UtilHelper.getUserName(userData));
                    c1902c.f69729b.setPlaceHolder(1);
                    c1902c.f69729b.M(userData.getAvater(), 12, false);
                    if (c1902c.f69731d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            c1902c.f69731d.setVisibility(8);
                        } else {
                            c1902c.f69731d.setVisibility(0);
                            d.a.r0.d.b bVar = new d.a.r0.d.b();
                            bVar.f55179a = userData.getAlaUserData();
                            bVar.f55180b = 5;
                            c1902c.f69731d.setTag(bVar);
                        }
                    }
                    if (k.isEmpty(userData.getIntro())) {
                        c1902c.f69732e.setVisibility(8);
                    } else {
                        c1902c.f69732e.setVisibility(0);
                        c1902c.f69732e.setText(userData.getIntro());
                    }
                    String userId = userData.getUserId();
                    userData.setIsLike(userData.getHave_attention() > 0);
                    c1902c.f69736i.n(userData);
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        c1902c.f69735h.setVisibility(8);
                    } else {
                        c1902c.f69735h.setStatsParams(2, userId);
                        c1902c.f69736i.m("9");
                        c1902c.f69735h.setVisibility(0);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1902c.j.getLayoutParams();
                if (ListUtils.getItem(this.f69720e, i2) != null && ((UserData) ListUtils.getItem(this.f69720e, i2)).isLastNewFan) {
                    layoutParams.height = l.g(this.f69723h, R.dimen.ds12);
                    layoutParams.setMargins(0, 0, 0, 0);
                    c1902c.j.setVisibility(0);
                } else {
                    c1902c.j.setVisibility(8);
                    layoutParams.height = l.g(this.f69723h, R.dimen.ds1);
                    layoutParams.setMargins(l.g(this.f69723h, R.dimen.ds34), 0, l.g(this.f69723h, R.dimen.ds34), 0);
                }
                c1902c.j.setLayoutParams(layoutParams);
                c1902c.k = null;
            } else if (itemViewType == 2) {
                c1902c.m.setText(R.string.new_fans);
                c1902c.m.setVisibility(0);
            } else {
                c1902c.f69730c.setText(this.f69723h.getPageContext().getString(R.string.loading));
                c1902c.k.setVisibility(0);
            }
            h(view, c1902c);
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

    public final void h(View view, C1902c c1902c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, c1902c) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f69723h.getLayoutMode().k(skinType == 1);
            this.f69723h.getLayoutMode().j(view);
            if (c1902c != null) {
                TextView textView = c1902c.m;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(c1902c.m, R.color.CAM_X0205);
                }
                ImageView imageView = c1902c.j;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.color.CAM_X0204);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = c1902c.f69735h;
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
            if (this.f69721f) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
