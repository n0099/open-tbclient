package com.repackage;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.SearchMajorActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.HeadItem;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.si6;
import com.repackage.yj8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ti6 extends qi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RankStarView A;
    public RankStarView B;
    public Editable C;
    public Editable D;
    public TextView E;
    public TextView F;
    public TbImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public EditText v;
    public EditText w;
    public ImageView x;
    public View y;
    public View z;

    /* loaded from: classes7.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti6 a;

        public a(ti6 ti6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent == null || motionEvent.getAction() != 2) {
                    return false;
                }
                oi.w(this.a.a, view2);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements si6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti6 a;

        public b(ti6 ti6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti6Var;
        }

        @Override // com.repackage.si6.b
        public void a(InputMethodManager inputMethodManager) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, inputMethodManager) == null) || inputMethodManager == null) {
                return;
            }
            ti6 ti6Var = this.a;
            ti6Var.a.HidenSoftKeyPad(inputMethodManager, ti6Var.v);
            ti6 ti6Var2 = this.a;
            ti6Var2.a.HidenSoftKeyPad(inputMethodManager, ti6Var2.w);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti6 a;

        public c(ti6 ti6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti6Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.C = editable;
                if (this.a.C.length() <= 500) {
                    this.a.E.setVisibility(4);
                } else {
                    this.a.E.setText((500 - this.a.C.length()) + "/500");
                    this.a.E.setVisibility(0);
                }
                this.a.B();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti6 a;

        public d(ti6 ti6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti6Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.D = editable;
                if (this.a.D.length() <= 500) {
                    this.a.F.setVisibility(4);
                } else {
                    this.a.F.setText((500 - this.a.D.length()) + "/500");
                    this.a.F.setVisibility(0);
                }
                this.a.B();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti6 a;

        public e(ti6 ti6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092252) {
                    ti6 ti6Var = this.a;
                    if (ti6Var.A(ti6Var.v)) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                        if (motionEvent.getAction() == 1) {
                            view2.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti6 a;

        public f(ti6 ti6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09225b) {
                    ti6 ti6Var = this.a;
                    if (ti6Var.A(ti6Var.w)) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                        if (motionEvent.getAction() == 1) {
                            view2.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements yj8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti6 a;

        public g(ti6 ti6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti6Var;
        }

        @Override // com.repackage.yj8.f
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || writeData == null) {
                return;
            }
            try {
                this.a.B.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
            } catch (NumberFormatException unused) {
                this.a.B.setStarCount(0.0f);
            }
            try {
                this.a.A.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
            } catch (NumberFormatException unused2) {
                this.a.A.setStarCount(0.0f);
            }
            this.a.r.setText(writeData.getmUniversitySubjectContent());
            this.a.v.setText(writeData.getmUniversityComment());
            this.a.w.setText(writeData.getmUniversitySubjectComment());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ti6(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, forumWriteData, serializableItemInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragmentActivity) objArr2[0], (ForumWriteData) objArr2[1], (SerializableItemInfo) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean A(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, editText)) == null) {
            int scrollY = editText.getScrollY();
            int height = editText.getLayout().getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom());
            if (height == 0) {
                return false;
            }
            return scrollY > 0 || scrollY < height - 1;
        }
        return invokeL.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TextUtils.isEmpty(this.C) && this.C.length() >= 20 && !TextUtils.isEmpty(this.D) && this.D.length() >= 20 && !this.a.getString(R.string.obfuscated_res_0x7f0f10d6).equals(this.r.getText()) && this.C.length() <= 500 && this.D.length() <= 500) {
                this.g.setAlpha(1.0f);
            } else {
                this.g.setAlpha(0.5f);
            }
        }
    }

    public final String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            int starCount = this.B.getStarCount();
            int starCount2 = this.A.getStarCount();
            if (starCount != 0) {
                arrayList.add(new HeadItem("学校评分", String.valueOf(starCount2), 2));
            }
            arrayList.add(new HeadItem("专业", this.r.getText().toString(), 1));
            if (starCount2 != 0) {
                arrayList.add(new HeadItem("专业评分", String.valueOf(starCount), 2));
            }
            return this.j.toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public final String D(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list != null) {
                StringBuilder sb = new StringBuilder();
                for (String str : list) {
                    sb.append(str);
                    sb.append(" ");
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.qi6
    public void c() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (forumWriteData = this.b) == null) {
            return;
        }
        yj8.r(String.valueOf(forumWriteData.forumId), new g(this));
    }

    @Override // com.repackage.qi6
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d005c, (ViewGroup) null);
            this.c = inflate;
            this.d = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f091514);
            this.m = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f092258);
            this.n = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092259);
            this.o = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092255);
            this.p = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092256);
            this.q = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09225a);
            this.r = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09225d);
            this.x = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091dba);
            this.s = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09225e);
            this.t = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092254);
            this.u = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091db7);
            EditText editText = (EditText) this.c.findViewById(R.id.obfuscated_res_0x7f092252);
            this.v = editText;
            editText.setLineSpacing(oi.f(this.a, R.dimen.tbds16), 1.0f);
            EditText editText2 = (EditText) this.c.findViewById(R.id.obfuscated_res_0x7f09225b);
            this.w = editText2;
            editText2.setLineSpacing(oi.f(this.a, R.dimen.tbds16), 1.0f);
            this.E = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092253);
            this.F = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09225c);
            this.z = this.c.findViewById(R.id.obfuscated_res_0x7f091c79);
            RankStarView rankStarView = (RankStarView) this.c.findViewById(R.id.obfuscated_res_0x7f092257);
            this.A = rankStarView;
            rankStarView.setClickable(true);
            this.A.setStarSpacing(oi.f(this.a, R.dimen.tbds24));
            RankStarView rankStarView2 = (RankStarView) this.c.findViewById(R.id.obfuscated_res_0x7f09225f);
            this.B = rankStarView2;
            rankStarView2.setClickable(true);
            this.B.setStarSpacing(oi.f(this.a, R.dimen.tbds24));
            this.y = this.c.findViewById(R.id.obfuscated_res_0x7f0907ea);
            SerializableItemInfo serializableItemInfo = this.h;
            if (serializableItemInfo != null) {
                this.o.setText(D(serializableItemInfo.getTags()));
                this.n.setText(this.h.getName());
                this.m.K(this.h.icon_url, 10, false);
            }
            this.m.setPlaceHolder(2);
            this.m.setPageId(this.a.getUniqueId());
            this.m.setConrers(15);
            this.m.setRadius(oi.f(this.a, R.dimen.tbds10));
            this.c.findViewById(R.id.obfuscated_res_0x7f091bfe).setOnTouchListener(new a(this));
            this.i.h(new b(this));
        }
    }

    @Override // com.repackage.qi6
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.z.setOnClickListener(this);
            this.v.addTextChangedListener(new c(this));
            this.w.addTextChangedListener(new d(this));
            this.v.setOnTouchListener(new e(this));
            this.w.setOnTouchListener(new f(this));
        }
    }

    @Override // com.repackage.qi6
    public void h(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) && i2 == -1 && intent != null && i == 25047) {
            String stringExtra = intent.getStringExtra(IntentConfig.SEARCH_MAJOR_NAME);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.r.setText(stringExtra);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.x, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            B();
        }
    }

    @Override // com.repackage.qi6
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.i();
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            if (this.a.getString(R.string.obfuscated_res_0x7f0f10d6).equals(this.r.getText())) {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.x, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.x, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.E, (int) R.color.CAM_X0301);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0301);
            this.v.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.w.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            TbImageView tbImageView = this.m;
            if (tbImageView != null) {
                tbImageView.setPlaceHolder(2);
                this.m.invalidate();
            }
        }
    }

    @Override // com.repackage.qi6
    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.b == null) {
            return;
        }
        WriteData writeData = new WriteData();
        int starCount = this.B.getStarCount();
        writeData.setmUniversityGrade(String.valueOf(this.A.getStarCount()));
        writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
        writeData.setmUniversitySubjectContent(this.r.getText().toString());
        writeData.setmUniversityComment(this.v.getText().toString());
        writeData.setmUniversitySubjectComment(this.w.getText().toString());
        yj8.B(String.valueOf(this.b.forumId), writeData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            if (view2 == this.f) {
                l();
            } else if (view2 == this.z) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchMajorActivityConfig(this.a, 25047)));
            } else if (view2 == this.g) {
                if (!TextUtils.isEmpty(this.C) && !TextUtils.isEmpty(this.D) && !this.a.getString(R.string.obfuscated_res_0x7f0f10d6).equals(this.r.getText())) {
                    if (this.C.length() < 20) {
                        oi.M(this.a, R.string.obfuscated_res_0x7f0f1482);
                        return;
                    } else if (this.D.length() < 20) {
                        oi.M(this.a, R.string.obfuscated_res_0x7f0f11ed);
                        return;
                    } else if (this.C.length() > 500) {
                        oi.M(this.a, R.string.obfuscated_res_0x7f0f1480);
                        return;
                    } else if (this.D.length() > 500) {
                        oi.M(this.a, R.string.obfuscated_res_0x7f0f11ec);
                        return;
                    } else {
                        this.i.g("学校评价：" + ((Object) this.C) + "\n专业评价：" + ((Object) this.D), C(), this.b);
                        return;
                    }
                }
                oi.M(this.a, R.string.obfuscated_res_0x7f0f1481);
            }
        }
    }
}
