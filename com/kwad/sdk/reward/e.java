package com.kwad.sdk.reward;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.BaseSystemDialogFragment;
/* loaded from: classes10.dex */
public class e extends BaseSystemDialogFragment {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static e f73411a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f73412b;

    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(Activity activity, String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, activity, str, aVar) == null) {
            a(activity, str, aVar, null, null);
        }
    }

    public static void a(Activity activity, String str, a aVar, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, activity, str, aVar, str2, str3) == null) {
            f73411a = new e();
            Bundle bundle = new Bundle();
            bundle.putString("key_title", str);
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("key_closeBtnText", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("key_continueBtnText", str3);
            }
            f73411a.setArguments(bundle);
            f73411a.a(aVar);
            f73411a.show(activity.getFragmentManager(), "videoCloseDialog");
        }
    }

    private void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            this.f73412b = aVar;
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            e eVar = f73411a;
            return eVar != null && eVar.b();
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Dialog dialog = getDialog();
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onActivityCreated(bundle);
            Window window = getDialog().getWindow();
            if (window == null) {
                return;
            }
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            a aVar = this.f73412b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            getDialog().requestWindowFeature(1);
            View inflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
            Bundle arguments = getArguments();
            ((TextView) inflate.findViewById(R.id.ksad_title)).setText(arguments.getString("key_title"));
            TextView textView = (TextView) inflate.findViewById(R.id.ksad_close_btn);
            TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_continue_btn);
            if (arguments.containsKey("key_closeBtnText")) {
                textView.setText(arguments.getString("key_closeBtnText", "关闭广告"));
            }
            if (arguments.containsKey("key_continueBtnText")) {
                textView2.setText(arguments.getString("key_continueBtnText", "继续观看"));
            }
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.reward.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f73413a;

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
                    this.f73413a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f73413a.dismiss();
                        if (this.f73413a.f73412b != null) {
                            this.f73413a.f73412b.b();
                        }
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.reward.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f73414a;

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
                    this.f73414a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f73414a.dismiss();
                        if (this.f73414a.f73412b != null) {
                            this.f73414a.f73412b.c();
                        }
                    }
                }
            });
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: com.kwad.sdk.reward.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f73415a;

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
                    this.f73415a = this;
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) ? i2 == 4 && keyEvent.getAction() == 0 : invokeLIL.booleanValue;
                }
            });
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
