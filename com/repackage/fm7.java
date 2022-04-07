package com.repackage;

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
import com.repackage.ov4;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class fm7 extends em7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonListActivity d;
    public boolean e;
    public int f;
    public View.OnClickListener g;
    public View.OnClickListener h;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ fm7 b;

        public a(fm7 fm7Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fm7Var;
            this.a = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (layout = this.a.c.getLayout()) == null) {
                return;
            }
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                this.a.c.setCompoundDrawablePadding(oi.f(this.b.d, R.dimen.tbds10));
            } else {
                this.a.c.setCompoundDrawablePadding(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ov4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fm7 a;

        public b(fm7 fm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fm7Var;
        }

        @Override // com.repackage.ov4.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    oi.M(this.a.d, R.string.obfuscated_res_0x7f0f02ac);
                } else {
                    oi.M(this.a.d, R.string.obfuscated_res_0x7f0f146e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;
        public ClickableHeaderImageView b;
        public EMTextView c;
        public View d;
        public EMTextView e;
        public LinearLayout f;
        public LinearLayout g;
        public NewMyFansUserLikeButton h;
        public ov4 i;
        public ImageView j;
        public ProgressBar k;
        public TextView l;
        public TextView m;

        public c(fm7 fm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(fm7 fm7Var, a aVar) {
            this(fm7Var);
        }
    }

    public fm7(PersonListActivity personListActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personListActivity, Boolean.valueOf(z), Integer.valueOf(i), onClickListener, onClickListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = true;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.d = personListActivity;
        this.e = z;
        this.f = i;
        this.g = onClickListener2;
        this.h = onClickListener;
        this.a = new ArrayList<>();
    }

    @Override // com.repackage.em7
    public void a(xp4 xp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, xp4Var) == null) || xp4Var == null || xp4Var.b() == null) {
            return;
        }
        Iterator<UserData> it = xp4Var.b().iterator();
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
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        arrayList.addAll(xp4Var.b());
        if (!ListUtils.isEmpty(this.a)) {
            ArrayList<UserData> arrayList2 = this.a;
            if (arrayList2.get(arrayList2.size() - 1) != null) {
                ArrayList<UserData> arrayList3 = this.a;
                if (arrayList3.get(arrayList3.size() - 1).isNewFan && !((UserData) arrayList.get(0)).isNewFan) {
                    ArrayList<UserData> arrayList4 = this.a;
                    arrayList4.get(arrayList4.size() - 1).isLastNewFan = true;
                    if (ListUtils.isEmpty(this.a) && arrayList.size() > 0 && ((UserData) arrayList.get(0)).isNewFan) {
                        UserData userData = new UserData();
                        userData.mAttentionType = 0;
                        arrayList.add(0, userData);
                    }
                    this.a.addAll(arrayList);
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
        if (ListUtils.isEmpty(this.a)) {
            UserData userData4 = new UserData();
            userData4.mAttentionType = 0;
            arrayList.add(0, userData4);
        }
        this.a.addAll(arrayList);
    }

    @Override // com.repackage.em7
    public boolean d(long j) {
        InterceptResult invokeJ;
        ArrayList<UserData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j != 0 && (arrayList = this.a) != null && arrayList.size() != 0) {
                Iterator<UserData> it = this.a.iterator();
                while (it.hasNext()) {
                    UserData next = it.next();
                    if (next != null && next.getUserIdLong() == j) {
                        this.a.remove(next);
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
            if (this.b) {
                return 1;
            }
            ArrayList<UserData> arrayList = this.a;
            int size = arrayList != null ? arrayList.size() : 0;
            return c() ? size + 1 : size;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return -1L;
            }
            return i;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (this.b) {
                return 0;
            }
            ArrayList<UserData> arrayList = this.a;
            if (arrayList == null || i >= arrayList.size()) {
                return 1;
            }
            return this.a.get(i).mAttentionType == 0 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (this.a == null) {
                return view2;
            }
            int itemViewType = getItemViewType(i);
            if (view2 != null && (view2.getTag() instanceof c)) {
                cVar = (c) view2.getTag();
                inflate = view2;
            } else {
                cVar = new c(this, null);
                if (itemViewType == 0) {
                    inflate = LayoutInflater.from(this.d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06c7, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090fac);
                    cVar.a = viewGroup2;
                    viewGroup2.setOnClickListener(this.h);
                    ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091823);
                    cVar.b = clickableHeaderImageView;
                    clickableHeaderImageView.setRadius(oi.f(this.d.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07030b));
                    cVar.b.setAutoChangeStyle(true);
                    cVar.b.setClickable(false);
                    ((ViewGroup.MarginLayoutParams) cVar.b.getLayoutParams()).setMargins(oi.f(this.d, R.dimen.obfuscated_res_0x7f07020f), 0, 0, 0);
                    cVar.f = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090eef);
                    cVar.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091eaf);
                    EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914e4);
                    cVar.c = eMTextView;
                    eMTextView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, cVar));
                    View a2 = yk4.b().a(this.d.getPageContext().getPageActivity(), 5);
                    cVar.d = a2;
                    if (a2 != null) {
                        a2.setVisibility(8);
                        cVar.g.addView(cVar.d, 1);
                    }
                    cVar.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902bc);
                    cVar.e = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f090f41);
                    NewMyFansUserLikeButton newMyFansUserLikeButton = (NewMyFansUserLikeButton) inflate.findViewById(R.id.obfuscated_res_0x7f0902c7);
                    cVar.h = newMyFansUserLikeButton;
                    newMyFansUserLikeButton.setContext(this.d.getPageContext());
                    ((LinearLayout.LayoutParams) cVar.h.getLayoutParams()).setMargins(0, 0, oi.f(this.d, R.dimen.obfuscated_res_0x7f07020f), 0);
                    ov4 ov4Var = new ov4(this.d.getPageContext(), cVar.h);
                    cVar.i = ov4Var;
                    ov4Var.n((mv4) ListUtils.getItem(this.a, i));
                    cVar.i.o(new b(this));
                    cVar.k = null;
                    cVar.m = null;
                    cVar.j = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0907df);
                } else if (itemViewType == 2) {
                    inflate = LayoutInflater.from(this.d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d058f, (ViewGroup) null);
                    cVar.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091492);
                } else {
                    inflate = LayoutInflater.from(this.d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0600, (ViewGroup) null);
                    cVar.c = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0916ea);
                    inflate.setOnClickListener(this.g);
                    cVar.k = (ProgressBar) inflate.findViewById(R.id.obfuscated_res_0x7f09191c);
                    cVar.m = null;
                }
                inflate.setTag(cVar);
            }
            NewMyFansUserLikeButton newMyFansUserLikeButton2 = cVar.h;
            if (newMyFansUserLikeButton2 != null) {
                newMyFansUserLikeButton2.setTag(Integer.valueOf(i));
            }
            if (itemViewType == 0) {
                if (this.b) {
                    cVar.f.setVisibility(8);
                    cVar.l.setVisibility(0);
                    if (this.e) {
                        cVar.l.setText(R.string.obfuscated_res_0x7f0f0c74);
                    } else {
                        int i2 = this.f;
                        if (i2 == 2) {
                            cVar.l.setText(R.string.obfuscated_res_0x7f0f0823);
                        } else if (i2 == 1) {
                            cVar.l.setText(R.string.obfuscated_res_0x7f0f0826);
                        } else {
                            cVar.l.setText(R.string.obfuscated_res_0x7f0f0c39);
                        }
                    }
                } else {
                    cVar.a.setTag(Integer.valueOf(i));
                    UserData userData = (UserData) ListUtils.getItem(this.a, i);
                    if (userData == null) {
                        return inflate;
                    }
                    cVar.l.setVisibility(8);
                    UtilHelper.showHeadImageViewBigV(cVar.b, userData, 0);
                    cVar.c.setText(UtilHelper.getUserName(userData));
                    cVar.b.setPlaceHolder(1);
                    cVar.b.K(userData.getAvater(), 12, false);
                    if (cVar.d != null && userData.getAlaUserData() != null) {
                        if (userData.getAlaUserData().anchor_live == 0 && userData.getAlaUserData().enter_live == 0) {
                            cVar.d.setVisibility(8);
                        } else {
                            cVar.d.setVisibility(0);
                            xk4 xk4Var = new xk4();
                            xk4Var.a = userData.getAlaUserData();
                            xk4Var.b = 5;
                            cVar.d.setTag(xk4Var);
                        }
                    }
                    if (ni.isEmpty(userData.getIntro())) {
                        cVar.e.setVisibility(8);
                    } else {
                        cVar.e.setVisibility(0);
                        cVar.e.setText(userData.getIntro());
                    }
                    String userId = userData.getUserId();
                    userData.setIsLike(userData.getHave_attention() > 0);
                    cVar.i.n(userData);
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        cVar.h.setVisibility(8);
                    } else {
                        cVar.h.setStatsParams(2, userId);
                        cVar.i.m("9");
                        cVar.h.setVisibility(0);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.j.getLayoutParams();
                if (ListUtils.getItem(this.a, i) != null && ((UserData) ListUtils.getItem(this.a, i)).isLastNewFan) {
                    layoutParams.height = oi.f(this.d, R.dimen.obfuscated_res_0x7f07023e);
                    layoutParams.setMargins(0, 0, 0, 0);
                    cVar.j.setVisibility(0);
                } else {
                    cVar.j.setVisibility(8);
                    layoutParams.height = oi.f(this.d, R.dimen.obfuscated_res_0x7f070198);
                    layoutParams.setMargins(oi.f(this.d, R.dimen.obfuscated_res_0x7f07020f), 0, oi.f(this.d, R.dimen.obfuscated_res_0x7f07020f), 0);
                }
                cVar.j.setLayoutParams(layoutParams);
                cVar.k = null;
            } else if (itemViewType == 2) {
                cVar.m.setText(R.string.obfuscated_res_0x7f0f0c1c);
                cVar.m.setVisibility(0);
            } else {
                cVar.c.setText(this.d.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a2e));
                cVar.k.setVisibility(0);
            }
            h(inflate, cVar);
            return inflate;
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

    public final void h(View view2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, cVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.d.getLayoutMode().k(skinType == 1);
            this.d.getLayoutMode().j(view2);
            if (cVar != null) {
                TextView textView = cVar.m;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(cVar.m, R.color.CAM_X0205);
                }
                ImageView imageView = cVar.j;
                if (imageView != null) {
                    SkinManager.setImageResource(imageView, R.color.CAM_X0204);
                }
                NewMyFansUserLikeButton newMyFansUserLikeButton = cVar.h;
                if (newMyFansUserLikeButton != null) {
                    newMyFansUserLikeButton.s(skinType);
                }
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.b) {
                return false;
            }
            return super.isEnabled(i);
        }
        return invokeI.booleanValue;
    }
}
