package com.repackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class dr4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_SIZE_BIG = 1;
    public static final int DIALOG_SIZE_FOR_FORUM_OPRATION = 10;
    public static final int DIALOG_SIZE_FOR_FRS_LIKE_POSTER = 9;
    public static final int DIALOG_SIZE_FOR_NEW_PRIVATE = 7;
    public static final int DIALOG_SIZE_FOR_PRIVACY_POLICY_GUIDE = 8;
    public static final int DIALOG_SIZE_FOR_PRIVATE = 3;
    public static final int DIALOG_SIZE_PRIVATE = 2;
    public static final int DIALOG_SIZE_SMALL = 0;
    public static final int DIALOG_SIZW_PRIVACY_BUTTON = 6;
    public static final int DIALOG_SIZW_PUSH_PERMISSION = 4;
    public static final int DIALOG_SIZW_YOUNGSTER = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public int animRes;
    public View bdDialog_divider_line;
    public boolean cancelableFlag;
    public int dialogSize;
    public View dividerWithButton;
    public Handler handler;
    public TextView introTextView;
    public boolean isAutoNight;
    public boolean isMessageShowCenter;
    public boolean isOnlyMessageShowCenter;
    public boolean isTitleShowCenter;
    public final Activity mActivity;
    public int mButtonTextColorId;
    public DialogInterface.OnCancelListener mCancelListenr;
    public boolean mCancelable;
    public Button mCloseButton;
    public e mCloseButtonListener;
    public View mContentView;
    public AlertDialog mDialog;
    public boolean mDialogCreated;
    public int mDialogGravity;
    public DialogInterface.OnDismissListener mDismissListener;
    public String mMessage;
    public e mNegativeButtonListener;
    public String mNegativeButtonTip;
    public int mNegativeTextColorId;
    public DialogInterface.OnKeyListener mOnKeyListener;
    public e mPositiveButtonListener;
    public String mPositiveButtonTip;
    public ViewGroup mRealView;
    public final ViewGroup mRootView;
    public String mTitle;
    public TextView noButton;
    public TextView noTipAgain;
    public ImageView noTipAgainCheckBox;
    public boolean noTipAgainChecked;
    public f onNoTipAgainCheckListener;
    public TextView titleTextView;
    public boolean useNoTipAgainStyle;
    public TextView yesButton;
    public Object yesTag;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;

        public a(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                dr4 dr4Var = this.a;
                dr4Var.noTipAgainChecked = !dr4Var.noTipAgainChecked;
                this.a.setCheckBoxDrawable();
                if (this.a.onNoTipAgainCheckListener != null) {
                    this.a.onNoTipAgainCheckListener.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicBoolean a;

        public b(dr4 dr4Var, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr4Var, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (view2 instanceof EditText) {
                    this.a.set(true);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;

        public c(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dr4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.show(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final dr4 a;
        public final e b;

        public d(dr4 dr4Var, dr4 dr4Var2, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr4Var, dr4Var2, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dr4Var2;
            this.b = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (eVar = this.b) == null) {
                return;
            }
            eVar.onClick(this.a);
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void onClick(dr4 dr4Var);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a();
    }

    public dr4(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDialogGravity = -1;
        this.isOnlyMessageShowCenter = true;
        this.isMessageShowCenter = false;
        this.isTitleShowCenter = false;
        this.mButtonTextColorId = -1;
        this.mNegativeTextColorId = -1;
        this.dialogSize = 0;
        this.mDialogCreated = false;
        this.cancelableFlag = true;
        this.mCancelable = true;
        this.isAutoNight = true;
        this.useNoTipAgainStyle = false;
        this.noTipAgainChecked = false;
        this.animRes = -1;
        this.mActivity = activity;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d021d, (ViewGroup) null);
        this.mRootView = viewGroup;
        this.mRealView = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f091a3e);
    }

    private void changeContentWithNoTipAgainSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            SkinManager.setViewTextColor(this.titleTextView, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.introTextView, (int) R.color.CAM_X0107);
            setCheckBoxDrawable();
            SkinManager.setViewTextColor(this.noTipAgain, (int) R.color.CAM_X0107);
            initButtonStyle();
        }
    }

    private void initButtonStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            TextView textView = this.noButton;
            if (textView != null) {
                vr4 d2 = vr4.d(textView);
                d2.x(R.color.CAM_X0302);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0211);
            }
            TextView textView2 = this.yesButton;
            if (textView2 != null) {
                vr4 d3 = vr4.d(textView2);
                d3.x(R.color.CAM_X0302);
                d3.n(R.string.J_X06);
                d3.f(R.color.CAM_X0211);
            }
        }
    }

    private void mouldButtons(boolean z, boolean z2) {
        View view2;
        View view3;
        View view4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z && z2) {
                View view5 = this.dividerWithButton;
                if (view5 != null) {
                    view5.setVisibility(0);
                }
                View view6 = this.bdDialog_divider_line;
                if (view6 != null) {
                    view6.setVisibility(0);
                    return;
                }
                return;
            }
            if (isAutoNight()) {
                TbadkCoreApplication.getInst().getSkinType();
            }
            View view7 = this.dividerWithButton;
            if (view7 != null) {
                view7.setVisibility(8);
            }
            if (!z && !z2) {
                TextView textView = this.yesButton;
                if (textView == null || this.noButton == null || this.dividerWithButton == null || this.bdDialog_divider_line == null) {
                    return;
                }
                textView.setVisibility(8);
                this.noButton.setVisibility(8);
                this.dividerWithButton.setVisibility(8);
                this.bdDialog_divider_line.setVisibility(8);
            } else if (z) {
                vr4 d2 = vr4.d(this.yesButton);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0211);
                if (this.noButton == null || this.dividerWithButton == null || (view4 = this.bdDialog_divider_line) == null) {
                    return;
                }
                view4.setVisibility(0);
                this.yesButton.setVisibility(0);
                this.noButton.setVisibility(8);
            } else if (z2) {
                vr4 d3 = vr4.d(this.noButton);
                d3.n(R.string.J_X06);
                d3.f(R.color.CAM_X0211);
                if (this.yesButton == null || this.dividerWithButton == null || (view3 = this.bdDialog_divider_line) == null) {
                    return;
                }
                view3.setVisibility(0);
                this.noButton.setVisibility(0);
                this.yesButton.setVisibility(8);
            } else if (this.yesButton == null || this.noButton == null || (view2 = this.bdDialog_divider_line) == null) {
            } else {
                view2.setVisibility(8);
                this.yesButton.setVisibility(8);
                this.noButton.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckBoxDrawable() {
        ImageView imageView;
        Drawable maskDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (imageView = this.noTipAgainCheckBox) == null) {
            return;
        }
        if (this.noTipAgainChecked) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.obfuscated_res_0x7f0805dd, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.obfuscated_res_0x7f0805dc, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public dr4 show(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, this, z)) == null) {
            if (this.mDialogCreated) {
                AlertDialog alertDialog = this.mDialog;
                if (alertDialog != null) {
                    if (z) {
                        sg.i(alertDialog, this.mActivity);
                    } else {
                        alertDialog.show();
                    }
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.mActivity).create();
                this.mDialog = create;
                create.setCanceledOnTouchOutside(this.cancelableFlag);
                this.mDialog.setCancelable(this.mCancelable);
                this.mDialog.setOnKeyListener(this.mOnKeyListener);
                DialogInterface.OnCancelListener onCancelListener = this.mCancelListenr;
                if (onCancelListener != null) {
                    this.mDialog.setOnCancelListener(onCancelListener);
                }
                DialogInterface.OnDismissListener onDismissListener = this.mDismissListener;
                if (onDismissListener != null) {
                    this.mDialog.setOnDismissListener(onDismissListener);
                }
                if (z) {
                    sg.i(this.mDialog, this.mActivity);
                } else {
                    this.mDialog.show();
                }
                if (this.mDialog.getWindow().getDecorView().getParent() == null) {
                    return this;
                }
                Window window = this.mDialog.getWindow();
                if (this.mDialogGravity == -1) {
                    this.mDialogGravity = 17;
                }
                window.setGravity(this.mDialogGravity);
                window.setBackgroundDrawableResource(R.drawable.obfuscated_res_0x7f0811a8);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.7f;
                attributes.width = -1;
                DisplayMetrics r = pi.r(this.mActivity);
                if (r != null) {
                    int dialogMargin = getDialogMargin();
                    if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                        attributes.width = r.heightPixels - (dialogMargin * 2);
                    } else {
                        attributes.width = r.widthPixels - (dialogMargin * 2);
                    }
                }
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setContentView(this.mRootView);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ViewHelper.processAllViewsIn(this.mRootView, false, new b(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
                int i = this.animRes;
                if (i != -1) {
                    window.setWindowAnimations(i);
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (dr4) invokeZ.objValue;
    }

    public void autoChangeSkinType(@Nullable d9<?> d9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d9Var) == null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
            if (d9Var instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) d9Var;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().e = !isAutoNight();
                tbPageContext.getLayoutMode().j(this.mRootView);
                if (this.mContentView != null) {
                    tbPageContext.getLayoutMode().j(this.mContentView);
                }
            }
            ViewGroup viewGroup = this.mRootView;
            if (viewGroup != null) {
                viewGroup.setBackgroundResource(R.drawable.obfuscated_res_0x7f0811a8);
            }
            if (this.mRealView != null && ((i = this.dialogSize) == 2 || i == 5 || i == 10 || i == 9)) {
                this.mRealView.setBackgroundResource(R.drawable.obfuscated_res_0x7f08048d);
            } else {
                SkinManager.setBackgroundResource(this.mRealView, R.drawable.dialog_background, skinType);
            }
            changeContentWithNoTipAgainSkinType();
        }
    }

    public dr4 create(@Nullable d9<?> d9Var) {
        InterceptResult invokeL;
        boolean z;
        TextView textView;
        TextView textView2;
        TextView textView3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d9Var)) == null) {
            if (this.mDialogCreated) {
                return this;
            }
            boolean z2 = true;
            this.mDialogCreated = true;
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.obfuscated_res_0x7f090779);
            this.yesButton = (TextView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f092547);
            this.noButton = (TextView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0915cc);
            this.dividerWithButton = this.mRootView.findViewById(R.id.obfuscated_res_0x7f0907e1);
            this.bdDialog_divider_line = this.mRootView.findViewById(R.id.obfuscated_res_0x7f09033c);
            this.mCloseButton = (Button) this.mRootView.findViewById(R.id.obfuscated_res_0x7f09062d);
            initButtonStyle();
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                if (this.mContentView.getParent() != null) {
                    if (this.mContentView.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
                        linearLayout.addView(this.mContentView);
                    }
                } else {
                    linearLayout.addView(this.mContentView);
                }
            } else {
                View createContentViewWithNoTipAgain = this.useNoTipAgainStyle ? createContentViewWithNoTipAgain() : isShowTitleAndMessage();
                if (createContentViewWithNoTipAgain != null) {
                    linearLayout.removeAllViews();
                    if (createContentViewWithNoTipAgain.getParent() != null) {
                        if (createContentViewWithNoTipAgain.getParent() instanceof ViewGroup) {
                            ((ViewGroup) createContentViewWithNoTipAgain.getParent()).removeView(createContentViewWithNoTipAgain);
                            linearLayout.addView(createContentViewWithNoTipAgain);
                        }
                    } else {
                        linearLayout.addView(createContentViewWithNoTipAgain);
                    }
                }
            }
            autoChangeSkinType(d9Var);
            if (this.mCloseButtonListener != null) {
                this.mCloseButton.setVisibility(0);
                this.mCloseButton.setOnClickListener(new d(this, this, this.mCloseButtonListener));
                int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
                if (this.dialogSize == 10) {
                    SkinManager.setBackgroundResource(this.mCloseButton, R.drawable.obfuscated_res_0x7f0807e4);
                } else {
                    SkinManager.setBackgroundResource(this.mCloseButton, R.drawable.icon_popup_close_n, skinType);
                }
            }
            if (this.mButtonTextColorId != -1) {
                TextView textView4 = this.yesButton;
                if (textView4 != null) {
                    vr4.d(textView4).x(this.mButtonTextColorId);
                }
                TextView textView5 = this.noButton;
                if (textView5 != null) {
                    vr4.d(textView5).x(this.mButtonTextColorId);
                }
            }
            if (this.mNegativeTextColorId != -1 && (textView3 = this.noButton) != null) {
                vr4.d(textView3).x(this.mNegativeTextColorId);
            }
            if (TextUtils.isEmpty(this.mPositiveButtonTip) || (textView2 = this.yesButton) == null) {
                z = false;
            } else {
                textView2.setText(this.mPositiveButtonTip);
                this.yesButton.setTag(this.yesTag);
                e eVar = this.mPositiveButtonListener;
                if (eVar != null) {
                    this.yesButton.setOnClickListener(new d(this, this, eVar));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.mNegativeButtonTip) || (textView = this.noButton) == null) {
                z2 = false;
            } else {
                textView.setText(this.mNegativeButtonTip);
                e eVar2 = this.mNegativeButtonListener;
                if (eVar2 != null) {
                    this.noButton.setOnClickListener(new d(this, this, eVar2));
                }
            }
            mouldButtons(z, z2);
            return this;
        }
        return (dr4) invokeL.objValue;
    }

    public View createContentViewWithNoTipAgain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.obfuscated_res_0x7f0d0223, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920be);
            this.titleTextView = textView;
            textView.setText(this.mTitle);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090f0d);
            this.introTextView = textView2;
            textView2.setText(this.mMessage);
            this.noTipAgain = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915ec);
            this.noTipAgainCheckBox = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0905e2);
            setCheckBoxDrawable();
            this.noTipAgainCheckBox.setOnClickListener(new a(this));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (alertDialog = this.mDialog) == null) {
            return;
        }
        sg.a(alertDialog, this.mActivity);
    }

    public Dialog getDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDialog : (Dialog) invokeV.objValue;
    }

    public int getDialogMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.dialogSize;
            return pi.f(this.mActivity, i == 0 ? R.dimen.obfuscated_res_0x7f070308 : i == 1 ? R.dimen.obfuscated_res_0x7f070225 : (i == 2 || i == 6) ? R.dimen.tbds44 : i == 3 ? R.dimen.tbds45 : (i == 4 || i == 5) ? R.dimen.tbds50 : i == 7 ? R.dimen.tbds206 : (i == 8 || i == 9 || i == 10) ? R.dimen.tbds120 : R.dimen.tbds0);
        }
        return invokeV.intValue;
    }

    public DialogInterface.OnKeyListener getOnKeyListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mOnKeyListener : (DialogInterface.OnKeyListener) invokeV.objValue;
    }

    public ViewGroup getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mRealView : (ViewGroup) invokeV.objValue;
    }

    public Window getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mDialog.getWindow() : (Window) invokeV.objValue;
    }

    public Object getYesButtonTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.yesTag : invokeV.objValue;
    }

    public void hide() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (alertDialog = this.mDialog) == null) {
            return;
        }
        alertDialog.hide();
    }

    public boolean isAutoNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.isAutoNight : invokeV.booleanValue;
    }

    public boolean isNoTipAgainChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.noTipAgainChecked : invokeV.booleanValue;
    }

    public View isShowTitleAndMessage() {
        InterceptResult invokeV;
        LinearLayout linearLayout;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            boolean z = !StringUtils.isNull(this.mTitle);
            boolean z2 = !StringUtils.isNull(this.mMessage);
            TextView textView2 = null;
            if (z || z2) {
                if (z && z2) {
                    linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.obfuscated_res_0x7f0d014d, (ViewGroup) null);
                    textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0920f0);
                    textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09145c);
                    if (this.isMessageShowCenter) {
                        textView2.setGravity(17);
                        textView.setGravity(17);
                    }
                    if (this.isTitleShowCenter) {
                        textView2.setGravity(17);
                    }
                    textView2.setText(this.mTitle);
                    textView.setText(this.mMessage);
                } else {
                    LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.obfuscated_res_0x7f0d014c, (ViewGroup) null);
                    TextView textView3 = (TextView) linearLayout2.findViewById(R.id.obfuscated_res_0x7f09145c);
                    if (z) {
                        textView3.setText(this.mTitle);
                    } else {
                        if (this.isOnlyMessageShowCenter) {
                            textView3.setGravity(17);
                        }
                        textView3.setText(this.mMessage);
                    }
                    linearLayout = linearLayout2;
                    textView = textView3;
                }
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                return linearLayout;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AlertDialog alertDialog = this.mDialog;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mDialogCreated = false;
        }
    }

    public void setAnimRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.animRes = i;
        }
    }

    public void setAutoNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.isAutoNight = z;
        }
    }

    public dr4 setButtonTextColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            this.mButtonTextColorId = i;
            return this;
        }
        return (dr4) invokeI.objValue;
    }

    public dr4 setCancelable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            this.mCancelable = z;
            return this;
        }
        return (dr4) invokeZ.objValue;
    }

    public dr4 setCanceledOnTouchOutside(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            this.cancelableFlag = z;
            return this;
        }
        return (dr4) invokeZ.objValue;
    }

    public dr4 setCloseButton(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, eVar)) == null) {
            if (eVar != null) {
                this.mCloseButtonListener = eVar;
            }
            return this;
        }
        return (dr4) invokeL.objValue;
    }

    public dr4 setContentView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, view2)) == null) {
            this.mContentView = view2;
            return this;
        }
        return (dr4) invokeL.objValue;
    }

    public dr4 setContentViewId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.mContentView = LayoutInflater.from(activity).inflate(i, (ViewGroup) null);
            }
            return this;
        }
        return (dr4) invokeI.objValue;
    }

    public dr4 setContentViewSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            this.dialogSize = i;
            return this;
        }
        return (dr4) invokeI.objValue;
    }

    public dr4 setGravity(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            this.mDialogGravity = i;
            return this;
        }
        return (dr4) invokeI.objValue;
    }

    public dr4 setMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.mMessage = str;
            return this;
        }
        return (dr4) invokeL.objValue;
    }

    public dr4 setMessageId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.mMessage = activity.getResources().getString(i);
            }
            return this;
        }
        return (dr4) invokeI.objValue;
    }

    public void setMessageShowCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.isMessageShowCenter = z;
        }
    }

    public dr4 setNegativeButton(String str, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, str, eVar)) == null) {
            this.mNegativeButtonTip = str;
            this.mNegativeButtonListener = eVar;
            return this;
        }
        return (dr4) invokeLL.objValue;
    }

    public dr4 setNegativeTextColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            this.mNegativeTextColorId = i;
            return this;
        }
        return (dr4) invokeI.objValue;
    }

    public void setNoBtnClickable(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048608, this, z) == null) || (textView = this.noButton) == null) {
            return;
        }
        textView.setClickable(z);
    }

    public dr4 setOnCalcelListener(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, onCancelListener)) == null) {
            this.mCancelListenr = onCancelListener;
            return this;
        }
        return (dr4) invokeL.objValue;
    }

    public dr4 setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, onDismissListener)) == null) {
            this.mDismissListener = onDismissListener;
            return this;
        }
        return (dr4) invokeL.objValue;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onKeyListener) == null) {
            this.mOnKeyListener = onKeyListener;
        }
    }

    public void setOnNoTipAgainCheckListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, fVar) == null) {
            this.onNoTipAgainCheckListener = fVar;
        }
    }

    public void setOnlyMessageShowCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.isOnlyMessageShowCenter = z;
        }
    }

    public dr4 setPositiveButton(String str, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, str, eVar)) == null) {
            this.mPositiveButtonTip = str;
            this.mPositiveButtonListener = eVar;
            return this;
        }
        return (dr4) invokeLL.objValue;
    }

    public void setRealView(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, viewGroup) == null) {
            this.mRealView = viewGroup;
        }
    }

    public dr4 setTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) {
            this.mTitle = str;
            return this;
        }
        return (dr4) invokeL.objValue;
    }

    public void setTitleShowCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.isTitleShowCenter = z;
        }
    }

    public void setUseNoTipAgainStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.useNoTipAgainStyle = z;
        }
    }

    public void setYesBtnClickable(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048621, this, z) == null) || (textView = this.yesButton) == null) {
            return;
        }
        textView.setClickable(z);
    }

    public void setYesButtonTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, obj) == null) {
            this.yesTag = obj;
        }
    }

    public dr4 showNoCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? show(false) : (dr4) invokeV.objValue;
    }

    public dr4 setTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i)) == null) {
            setTitle(this.mActivity.getResources().getString(i));
            return this;
        }
        return (dr4) invokeI.objValue;
    }

    public dr4 setNegativeButton(int i, e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048605, this, i, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.mNegativeButtonTip = activity.getResources().getString(i);
                this.mNegativeButtonListener = eVar;
            }
            return this;
        }
        return (dr4) invokeIL.objValue;
    }

    public dr4 setPositiveButton(int i, e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048614, this, i, eVar)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                this.mPositiveButtonTip = activity.getResources().getString(i);
                this.mPositiveButtonListener = eVar;
            }
            return this;
        }
        return (dr4) invokeIL.objValue;
    }

    public dr4 show() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? show(true) : (dr4) invokeV.objValue;
    }

    public void show(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j) == null) {
            Handler handler = new Handler();
            this.handler = handler;
            handler.postDelayed(new c(this), j);
        }
    }
}
