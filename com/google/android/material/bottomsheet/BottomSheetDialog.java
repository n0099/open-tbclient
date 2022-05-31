package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes4.dex */
public class BottomSheetDialog extends AppCompatDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BottomSheetBehavior<FrameLayout> behavior;
    @NonNull
    public BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    public boolean cancelable;
    public boolean canceledOnTouchOutside;
    public boolean canceledOnTouchOutsideSet;
    public FrameLayout container;
    public boolean dismissWithAnimation;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomSheetDialog(@NonNull Context context) {
        this(context, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private FrameLayout ensureContainerAndBehavior() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.container == null) {
                FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0212, null);
                this.container = frameLayout;
                BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from((FrameLayout) frameLayout.findViewById(R.id.obfuscated_res_0x7f090771));
                this.behavior = from;
                from.addBottomSheetCallback(this.bottomSheetCallback);
                this.behavior.setHideable(this.cancelable);
            }
            return this.container;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public static int getThemeResId(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            if (i == 0) {
                TypedValue typedValue = new TypedValue();
                return context.getTheme().resolveAttribute(R.attr.obfuscated_res_0x7f0400eb, typedValue, true) ? typedValue.resourceId : R.style.obfuscated_res_0x7f10022b;
            }
            return i;
        }
        return invokeLI.intValue;
    }

    private View wrapInBottomSheet(int i, @Nullable View view2, @Nullable ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65541, this, i, view2, layoutParams)) == null) {
            ensureContainerAndBehavior();
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(R.id.obfuscated_res_0x7f0906dc);
            if (i != 0 && view2 == null) {
                view2 = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
            }
            FrameLayout frameLayout = (FrameLayout) this.container.findViewById(R.id.obfuscated_res_0x7f090771);
            frameLayout.removeAllViews();
            if (layoutParams == null) {
                frameLayout.addView(view2);
            } else {
                frameLayout.addView(view2, layoutParams);
            }
            coordinatorLayout.findViewById(R.id.obfuscated_res_0x7f092121).setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomSheetDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        BottomSheetDialog bottomSheetDialog = this.this$0;
                        if (bottomSheetDialog.cancelable && bottomSheetDialog.isShowing() && this.this$0.shouldWindowCloseOnTouchOutside()) {
                            this.this$0.cancel();
                        }
                    }
                }
            });
            ViewCompat.setAccessibilityDelegate(frameLayout, new AccessibilityDelegateCompat(this) { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomSheetDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View view3, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view3, accessibilityNodeInfoCompat) == null) {
                        super.onInitializeAccessibilityNodeInfo(view3, accessibilityNodeInfoCompat);
                        if (this.this$0.cancelable) {
                            accessibilityNodeInfoCompat.addAction(1048576);
                            accessibilityNodeInfoCompat.setDismissable(true);
                            return;
                        }
                        accessibilityNodeInfoCompat.setDismissable(false);
                    }
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public boolean performAccessibilityAction(View view3, int i2, Bundle bundle) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view3, i2, bundle)) == null) {
                        if (i2 == 1048576) {
                            BottomSheetDialog bottomSheetDialog = this.this$0;
                            if (bottomSheetDialog.cancelable) {
                                bottomSheetDialog.cancel();
                                return true;
                            }
                        }
                        return super.performAccessibilityAction(view3, i2, bundle);
                    }
                    return invokeLIL.booleanValue;
                }
            });
            frameLayout.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomSheetDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, motionEvent)) == null) {
                        return true;
                    }
                    return invokeLL.booleanValue;
                }
            });
            return this.container;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BottomSheetBehavior<FrameLayout> behavior = getBehavior();
            if (this.dismissWithAnimation && behavior.getState() != 5) {
                behavior.setState(5);
            } else {
                super.cancel();
            }
        }
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> getBehavior() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.behavior == null) {
                ensureContainerAndBehavior();
            }
            return this.behavior;
        }
        return (BottomSheetBehavior) invokeV.objValue;
    }

    public boolean getDismissWithAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dismissWithAnimation : invokeV.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            Window window = getWindow();
            if (window != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    window.addFlags(Integer.MIN_VALUE);
                }
                window.setLayout(-1, -1);
            }
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStart();
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior == null || bottomSheetBehavior.getState() != 5) {
                return;
            }
            this.behavior.setState(4);
        }
    }

    public void removeDefaultCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.setCancelable(z);
            if (this.cancelable != z) {
                this.cancelable = z;
                BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
                if (bottomSheetBehavior != null) {
                    bottomSheetBehavior.setHideable(z);
                }
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            super.setCanceledOnTouchOutside(z);
            if (z && !this.cancelable) {
                this.cancelable = true;
            }
            this.canceledOnTouchOutside = z;
            this.canceledOnTouchOutsideSet = true;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@LayoutRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.setContentView(wrapInBottomSheet(i, null, null));
        }
    }

    public void setDismissWithAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.dismissWithAnimation = z;
        }
    }

    public boolean shouldWindowCloseOnTouchOutside() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!this.canceledOnTouchOutsideSet) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
                this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
                this.canceledOnTouchOutsideSet = true;
            }
            return this.canceledOnTouchOutside;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetDialog(@NonNull Context context, @StyleRes int i) {
        super(context, getThemeResId(context, i));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback(this) { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BottomSheetDialog this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(@NonNull View view2, float f) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLF(1048576, this, view2, f) == null) {
                }
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(@NonNull View view2, int i4) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i4) == null) && i4 == 5) {
                    this.this$0.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            super.setContentView(wrapInBottomSheet(0, view2, null));
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view2, layoutParams) == null) {
            super.setContentView(wrapInBottomSheet(0, view2, layoutParams));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetDialog(@NonNull Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), onCancelListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback(this) { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BottomSheetDialog this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(@NonNull View view2, float f) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLF(1048576, this, view2, f) == null) {
                }
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(@NonNull View view2, int i4) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i4) == null) && i4 == 5) {
                    this.this$0.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
        this.cancelable = z;
    }
}
