package com.repackage;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.HeadItem;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fk8;
import com.repackage.ui6;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ti6 extends si6 {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView m;
    public TextView n;
    public TextView o;
    public View p;
    public RankStarView q;
    public EditText r;
    public TextView s;
    public Editable t;

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
    public class b implements ui6.b {
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

        @Override // com.repackage.ui6.b
        public void a(InputMethodManager inputMethodManager) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, inputMethodManager) == null) || inputMethodManager == null) {
                return;
            }
            ti6 ti6Var = this.a;
            ti6Var.a.HidenSoftKeyPad(inputMethodManager, ti6Var.r);
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
                this.a.t = editable;
                if (this.a.t.length() > 500) {
                    this.a.s.setText(String.format(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0700), Integer.valueOf(500 - this.a.t.length())));
                    this.a.s.setVisibility(0);
                } else {
                    this.a.s.setVisibility(8);
                }
                this.a.t();
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
    public class d implements fk8.f {
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

        @Override // com.repackage.fk8.f
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || writeData == null) {
                return;
            }
            this.a.q.setStarCount(writeData.getOtherGrade());
            this.a.r.setText(writeData.getOtherComment());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755289744, "Lcom/repackage/ti6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755289744, "Lcom/repackage/ti6;");
                return;
            }
        }
        u = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        v = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        w = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
        x = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        y = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        z = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
        A = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ti6(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, forumWriteData, serializableItemInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragmentActivity) objArr2[0], (ForumWriteData) objArr2[1], (SerializableItemInfo) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.si6
    public void c() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (forumWriteData = this.b) == null) {
            return;
        }
        fk8.r(String.valueOf(forumWriteData.forumId), new d(this));
    }

    @Override // com.repackage.si6
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0049, (ViewGroup) null);
            this.c = inflate;
            this.d = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f091515);
            this.m = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090f76);
            this.n = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090fa6);
            this.o = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090fa1);
            this.p = this.c.findViewById(R.id.obfuscated_res_0x7f0907ea);
            this.q = (RankStarView) this.c.findViewById(R.id.obfuscated_res_0x7f090f9d);
            this.r = (EditText) this.c.findViewById(R.id.obfuscated_res_0x7f091621);
            this.s = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09246c);
            this.m.setPlaceHolder(2);
            this.m.setConrers(15);
            this.m.setRadius(oi.f(this.a, R.dimen.tbds10));
            this.q.setStarSpacing(oi.f(this.a, R.dimen.tbds24));
            this.q.setClickable(true);
            this.r.setLineSpacing(oi.f(this.a, R.dimen.tbds16), 1.0f);
            SerializableItemInfo serializableItemInfo = this.h;
            if (serializableItemInfo != null) {
                v(serializableItemInfo.getTags());
                this.n.setText(this.h.getName());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                if (this.h.getIconSize() == 1.0d) {
                    layoutParams.width = u;
                    layoutParams.height = v;
                } else if (this.h.getIconSize() == 0.67d) {
                    layoutParams.width = w;
                    layoutParams.height = x;
                } else {
                    layoutParams.width = y;
                    layoutParams.height = z;
                }
                this.m.setLayoutParams(layoutParams);
                this.m.K(this.h.icon_url, 10, false);
                if (this.h.getScore() != null && this.h.getScore().isCommented == 1) {
                    this.q.setStarCount(this.h.getScore().getCommentStar());
                }
            }
            this.c.findViewById(R.id.obfuscated_res_0x7f091bff).setOnTouchListener(new a(this));
            this.i.h(new b(this));
        }
    }

    @Override // com.repackage.si6
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.r.addTextChangedListener(new c(this));
        }
    }

    @Override // com.repackage.si6
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i();
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
            this.q.e(TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
            this.r.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0301);
            TbImageView tbImageView = this.m;
            if (tbImageView != null) {
                tbImageView.setPlaceHolder(2);
                this.m.invalidate();
            }
        }
    }

    @Override // com.repackage.si6
    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.b == null) {
            return;
        }
        WriteData writeData = new WriteData();
        writeData.setOtherGrade(this.q.getStarCount());
        writeData.setOtherComment(this.r.getText().toString());
        fk8.B(String.valueOf(this.b.forumId), writeData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2 == this.f) {
                l();
            } else if (view2 == this.g) {
                if (!TextUtils.isEmpty(this.t) && this.t.length() >= 20) {
                    if (this.t.length() > 500) {
                        oi.M(this.a, R.string.obfuscated_res_0x7f0f0ced);
                        return;
                    } else {
                        this.i.g(this.t.toString(), u(), this.b);
                        return;
                    }
                }
                oi.M(this.a, R.string.obfuscated_res_0x7f0f0cee);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!TextUtils.isEmpty(this.t) && this.t.length() >= 20 && this.t.length() <= 500) {
                this.g.setAlpha(1.0f);
            } else {
                this.g.setAlpha(0.5f);
            }
        }
    }

    public final String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new HeadItem("", String.valueOf(this.q.getStarCount()), 2));
            return this.j.toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public final void v(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                this.o.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    spannableStringBuilder.append((CharSequence) list.get(i));
                    if (i != list.size() - 1) {
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                        spannableStringBuilder2.setSpan(new cv4(A), 0, spannableStringBuilder2.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                    }
                }
                this.o.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return;
            }
            this.o.setVisibility(8);
        }
    }
}
