package com.repackage;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public SeekBar b;
    public View c;
    public int d;
    public ViewTreeObserver.OnGlobalLayoutListener e;

    /* loaded from: classes5.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(bk8 bk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && z) {
                p48 p48Var = new p48();
                p48Var.a = 1;
                p48Var.b = i;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921635, p48Var));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                seekBar.setProgressDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f08126b));
                p48 p48Var = new p48();
                p48Var.a = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921635, p48Var));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                seekBar.setProgressDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f08126c));
                p48 p48Var = new p48();
                p48Var.a = 3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921635, p48Var));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk8 a;

        public b(bk8 bk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bk8Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.b.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.b.getLayoutParams();
                if (layoutParams.bottomMargin != this.a.d) {
                    layoutParams.bottomMargin = this.a.c.getHeight() - li.f(this.a.a, R.dimen.tbds16);
                    this.a.b.setLayoutParams(layoutParams);
                    this.a.d = layoutParams.bottomMargin;
                }
            }
        }
    }

    public bk8(BaseFragmentActivity baseFragmentActivity, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = -1;
        this.e = new b(this);
        this.a = baseFragmentActivity;
        this.c = view2;
        SeekBar seekBar = (SeekBar) baseFragmentActivity.findViewById(R.id.obfuscated_res_0x7f092346);
        this.b = seekBar;
        seekBar.setOnSeekBarChangeListener(new a(this));
        view2.getViewTreeObserver().addOnGlobalLayoutListener(this.e);
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.b.setVisibility(z ? 0 : 4);
        }
    }
}
