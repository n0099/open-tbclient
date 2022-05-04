package com.repackage;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.ShareSDKImageView;
import com.baidu.tieba.sharewrite.WriteShareActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jz8;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class tf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public View b;
    public WriteData c;
    public EditText d;
    public View e;
    public View f;
    public LinearLayout g;
    public EditText h;
    public TextView i;
    public RelativeLayout j;
    public PostPrefixData k;
    public TextView l;
    public jz8 m;
    public ImageView n;
    public View o;
    public LinearLayout p;
    public LinearLayout q;
    public ShareSDKImageView r;
    public TextView s;
    public TextView t;
    public WriteShareActivity u;
    public k35 v;
    public boolean w;
    public int x;
    public int y;

    /* loaded from: classes7.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf8 a;

        public a(tf8 tf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf8Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
                if (z) {
                    if (this.a.r.getLoadedWidth() == 0 || this.a.r.getLoadedHeight() == 0) {
                        return;
                    }
                    tf8 tf8Var = this.a;
                    tf8Var.x = tf8Var.r.getLoadedWidth();
                    tf8 tf8Var2 = this.a;
                    tf8Var2.y = tf8Var2.r.getLoadedHeight();
                    if (this.a.u != null) {
                        this.a.u.getWriteData().setShareSummaryImgWidth(this.a.x);
                        this.a.u.getWriteData().setShareSummaryImgHeight(this.a.y);
                        this.a.w = true;
                        this.a.A();
                        return;
                    }
                    return;
                }
                this.a.w = false;
                this.a.A();
                if (this.a.u != null) {
                    this.a.u.shareFailed(R.string.obfuscated_res_0x7f0f111f);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.w = false;
                this.a.A();
                if (this.a.u != null) {
                    this.a.u.shareFailed(R.string.obfuscated_res_0x7f0f111f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements g35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf8 a;

        public b(tf8 tf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf8Var;
        }

        @Override // com.repackage.g35
        public void a(fo foVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, foVar, str, z) == null) || (tbImageView = (TbImageView) this.a.p.findViewWithTag(str)) == null || foVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf8 a;

        public c(tf8 tf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l.setVisibility(0);
                this.a.o.setSelected(true);
                rg.l(this.a.m, view2, oi.d(this.a.u.getPageContext().getContext(), 15.0f), oi.d(this.a.u.getPageContext().getContext(), 1.0f));
                if (this.a.u != null) {
                    this.a.u.hidenSoftKeyPad();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf8 a;

        public d(tf8 tf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l.setSelected(true);
                rg.l(this.a.m, view2, oi.d(this.a.u.getPageContext().getContext(), 15.0f), oi.d(this.a.u.getPageContext().getContext(), 1.0f));
                if (this.a.u != null) {
                    this.a.u.hidenSoftKeyPad();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements jz8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf8 a;

        public e(tf8 tf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf8Var;
        }

        @Override // com.repackage.jz8.a
        public void onPrefixItemClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.u.setCurrentPrefixPosition(i);
                this.a.l.setText(this.a.k.getPrefixs().get(i));
                this.a.m.c(i);
                this.a.A();
                rg.d(this.a.m, this.a.u.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf8 a;

        public f(tf8 tf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf8Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o.setSelected(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf8 a;

        public g(tf8 tf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf8Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.A();
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
    public class h implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(tf8 tf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf8 a;

        public i(tf8 tf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf8Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.A();
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

    public tf8(WriteShareActivity writeShareActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writeShareActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.w = false;
        this.x = 0;
        this.y = 0;
        this.u = writeShareActivity;
        this.c = writeShareActivity.getWriteData();
        if (this.v == null) {
            this.v = new k35();
        }
        w();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "1";
            if (this.c.getType() == 3) {
                String trim = this.d.getText().toString().trim();
                PostPrefixData postPrefixData = this.k;
                if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                    if (this.u.getCurrentPrefixPosition() == this.k.getPrefixs().size() - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.c.setIsNoTitle(true);
                        } else {
                            this.c.setIsNoTitle(false);
                        }
                    } else {
                        this.c.setIsNoTitle(false);
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.c.setIsNoTitle(true);
                } else {
                    this.c.setIsNoTitle(false);
                }
                if (str == null && str.length() > 0 && this.w) {
                    this.i.setEnabled(true);
                    return;
                } else {
                    this.i.setEnabled(false);
                }
            }
            str = null;
            if (str == null) {
            }
            this.i.setEnabled(false);
        }
    }

    public void B(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onFocusChangeListener) == null) {
            this.d.setOnFocusChangeListener(onFocusChangeListener);
            this.h.setOnFocusChangeListener(onFocusChangeListener);
            this.b.setOnFocusChangeListener(onFocusChangeListener);
            this.i.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.b.setOnClickListener(onClickListener);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.i.setOnClickListener(onClickListener);
        }
    }

    public void E(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.g.setOnClickListener(onClickListener);
        }
    }

    public void F(PostPrefixData postPrefixData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, postPrefixData) == null) {
            this.k = postPrefixData;
            u();
        }
    }

    public final void m(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, editText, i2) == null) {
            Editable text = editText.getText();
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            editText.setText((CharSequence) null);
            editText.setHintTextColor(i2);
            editText.setText(text);
            editText.setSelection(selectionStart, selectionEnd);
        }
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public TextView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : (TextView) invokeV.objValue;
    }

    public EditText p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.h : (EditText) invokeV.objValue;
    }

    public EditText q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d : (EditText) invokeV.objValue;
    }

    public TextView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public jz8 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : (jz8) invokeV.objValue;
    }

    public ShareSDKImageView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.r : (ShareSDKImageView) invokeV.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.o = this.u.findViewById(R.id.obfuscated_res_0x7f0918ad);
            this.l = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0918ac);
            this.n = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0918d1);
            PostPrefixData postPrefixData = this.k;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.o.setVisibility(0);
                ArrayList<String> prefixs = this.k.getPrefixs();
                int size = prefixs.size();
                this.l.setText(prefixs.get(0));
                this.u.setCurrentPrefixPosition(0);
                this.o.setOnClickListener(new c(this));
                ImageView imageView = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0918d1);
                this.n = imageView;
                if (size > 1) {
                    imageView.setVisibility(0);
                    this.l.setOnClickListener(new d(this));
                }
                jz8 jz8Var = new jz8(this.u.getPageContext().getContext());
                this.m = jz8Var;
                jz8Var.d(oi.d(this.u.getPageContext().getContext(), 225.0f));
                this.m.setOutsideTouchable(true);
                this.m.setFocusable(true);
                this.m.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0204));
                this.m.e(new e(this));
                this.m.setOnDismissListener(new f(this));
                int color = SkinManager.getColor(R.color.common_color_10097);
                SkinManager.setBackgroundResource(this.l, R.drawable.write_prefix_item_selector);
                SkinManager.setImageResource(this.n, R.drawable.icon_title_down);
                this.l.setTextColor(color);
                for (int i2 = 0; i2 < size; i2++) {
                    TextView textView = new TextView(this.u.getPageContext().getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, oi.d(this.u.getPageContext().getContext(), 45.0f));
                    textView.setLayoutParams(layoutParams);
                    textView.setText(prefixs.get(i2));
                    textView.setGravity(19);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                    textView.setTextSize(1, 16.0f);
                    textView.setTextColor(color);
                    SkinManager.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                    textView.setPadding(oi.d(this.u.getPageContext().getContext(), this.u.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702e9)), 0, oi.d(this.u.getPageContext().getContext(), this.u.getResources().getDimension(R.dimen.obfuscated_res_0x7f07027c)), 0);
                    this.m.a(textView);
                    if (i2 != size - 1) {
                        layoutParams.bottomMargin = oi.d(this.u.getPageContext().getContext(), 1.0f);
                        textView.setGravity(19);
                        textView.setPadding(oi.d(this.u.getPageContext().getContext(), this.u.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702e9)), 0, oi.d(this.u.getPageContext().getContext(), this.u.getResources().getDimension(R.dimen.obfuscated_res_0x7f07027c)), 0);
                    }
                }
                this.m.c(0);
                return;
            }
            this.o.setVisibility(8);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.p = (LinearLayout) this.u.findViewById(R.id.obfuscated_res_0x7f0918b7);
            ShareSDKImageView shareSDKImageView = (ShareSDKImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0918b6);
            this.r = shareSDKImageView;
            shareSDKImageView.setIsRound(false);
            this.r.setDrawBorder(false);
            this.r.setAutoChangeStyle(true);
            this.r.setRadius(0);
            this.s = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0918bd);
            this.t = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0918b4);
            WriteData writeData = this.c;
            if (writeData != null) {
                if (writeData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                    this.r.setEvent(new a(this));
                }
                if (this.c.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                    if (this.c.getShareSummaryImg() != null && this.c.getShareSummaryImg().trim().length() > 0) {
                        this.r.K(this.c.getShareSummaryImg(), 10, true);
                    } else {
                        this.w = true;
                        A();
                    }
                } else {
                    Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.c.getShareLocalImageData());
                    if (Bytes2Bitmap != null) {
                        this.r.setImageBitmap(Bytes2Bitmap);
                    } else {
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        if (!TextUtils.isEmpty(this.c.getShareLocalImageUri())) {
                            imageFileInfo.setFilePath(FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.c.getShareLocalImageUri())));
                        }
                        imageFileInfo.clearAllActions();
                        imageFileInfo.addPersistAction(u35.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
                        this.r.setTag(imageFileInfo.toCachedKey(true));
                        if (this.v.d(imageFileInfo, new b(this), true) != null) {
                            this.r.invalidate();
                        }
                    }
                    this.w = true;
                    A();
                }
                WriteData writeData2 = this.c;
                writeData2.setShareSummaryImgType(ii.r(writeData2.getShareSummaryImg()));
                this.s.setText(this.c.getShareSummaryTitle());
                this.t.setText(this.c.getShareSummaryContent());
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.u.findViewById(R.id.obfuscated_res_0x7f0923ad);
            this.a = navigationBar;
            this.b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setTitleText(this.u.getPageContext().getString(R.string.obfuscated_res_0x7f0f1123));
            this.i = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.u.getPageContext().getString(R.string.obfuscated_res_0x7f0f10e8));
            this.j = (RelativeLayout) this.u.findViewById(R.id.obfuscated_res_0x7f091642);
            this.e = this.u.findViewById(R.id.obfuscated_res_0x7f090f36);
            this.f = this.u.findViewById(R.id.obfuscated_res_0x7f0918d2);
            this.p = (LinearLayout) this.u.findViewById(R.id.obfuscated_res_0x7f0918b7);
            this.q = (LinearLayout) this.u.findViewById(R.id.obfuscated_res_0x7f0918b5);
            this.r = (ShareSDKImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0918b6);
            this.s = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0918bd);
            this.t = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0918b4);
            y();
            x();
            LinearLayout linearLayout = (LinearLayout) this.u.findViewById(R.id.obfuscated_res_0x7f0918a2);
            this.g = linearLayout;
            linearLayout.setDrawingCacheEnabled(false);
            this.d.setVisibility(0);
            this.h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            A();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            EditText editText = (EditText) this.u.findViewById(R.id.obfuscated_res_0x7f0918a0);
            this.h = editText;
            editText.setDrawingCacheEnabled(false);
            if (this.c.getContent() != null && this.c.getContent().length() > 0) {
                SpannableString j = TbFaceManager.e().j(this.u.getPageContext().getContext(), this.c.getContent());
                this.h.setText(j);
                this.h.setSelection(j.length());
            }
            this.h.setOnTouchListener(new h(this));
            this.h.addTextChangedListener(new i(this));
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.d = (EditText) this.u.findViewById(R.id.obfuscated_res_0x7f0918c2);
            if (this.c.getType() == 3) {
                if (this.c.getTitle() != null && this.c.getTitle().trim().length() > 0) {
                    this.d.setText(this.c.getTitle());
                    this.d.setSelection(this.c.getTitle().length());
                } else {
                    String str = this.u.getPageContext().getString(R.string.obfuscated_res_0x7f0f1149) + this.c.getShareSummaryTitle();
                    this.d.setText(str);
                    if (str.length() < 20) {
                        this.d.setSelection(str.length());
                    } else {
                        this.d.setSelection(20);
                    }
                }
            }
            this.d.addTextChangedListener(new g(this));
        }
    }

    public void z(int i2) {
        WriteShareActivity writeShareActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (writeShareActivity = this.u) == null) {
            return;
        }
        writeShareActivity.getLayoutMode().k(i2 == 1);
        this.u.getLayoutMode().j(this.j);
        this.a.onChangeSkinType(this.u.getPageContext(), i2);
        SkinManager.setTopBarCommonFinishButton(this.i, i2);
        SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0111);
        SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
        int color = SkinManager.getColor(R.color.CAM_X0105);
        int color2 = SkinManager.getColor(R.color.CAM_X0110);
        this.d.setTextColor(color);
        this.h.setTextColor(color);
        this.s.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        m(this.d, color2);
        m(this.h, color2);
        A();
    }
}
