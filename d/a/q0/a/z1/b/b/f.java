package d.a.q0.a.z1.b.b;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.z1.b.b.h;
/* loaded from: classes8.dex */
public class f extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public TextView f52006f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f52007g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f52008h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f52009i;
        public LinearLayout j;
        public LinearLayout k;
        public CheckBox l;

        /* renamed from: d.a.q0.a.z1.b.b.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class DialogInterface$OnKeyListenerC1051a implements DialogInterface.OnKeyListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f52010e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f52011f;

            public DialogInterface$OnKeyListenerC1051a(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52011f = aVar;
                this.f52010e = onClickListener;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                InterceptResult invokeLIL;
                DialogInterface.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i2, keyEvent)) == null) {
                    if (keyEvent.getAction() == 1 && i2 == 4 && keyEvent.getRepeatCount() == 0 && (onClickListener = this.f52010e) != null) {
                        onClickListener.onClick(dialogInterface, this.f52011f.c0());
                        return true;
                    }
                    return false;
                }
                return invokeLIL.booleanValue;
            }
        }

        /* loaded from: classes8.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f52012e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f52013f;

            public b(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52013f = aVar;
                this.f52012e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.f52012e) == null) {
                    return;
                }
                a aVar = this.f52013f;
                onClickListener.onClick(aVar.f52022b, aVar.c0());
            }
        }

        /* loaded from: classes8.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f52014e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f52015f;

            public c(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52015f = aVar;
                this.f52014e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.f52014e) == null) {
                    return;
                }
                a aVar = this.f52015f;
                onClickListener.onClick(aVar.f52022b, aVar.c0());
            }
        }

        /* loaded from: classes8.dex */
        public class d implements DialogInterface.OnShowListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnShowListener f52016a;

            public d(a aVar, DialogInterface.OnShowListener onShowListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onShowListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52016a = onShowListener;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                DialogInterface.OnShowListener onShowListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (onShowListener = this.f52016a) == null) {
                    return;
                }
                onShowListener.onShow(dialogInterface);
            }
        }

        /* loaded from: classes8.dex */
        public class e implements DialogInterface.OnDismissListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnDismissListener f52017e;

            public e(a aVar, DialogInterface.OnDismissListener onDismissListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onDismissListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52017e = onDismissListener;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                DialogInterface.OnDismissListener onDismissListener;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (onDismissListener = this.f52017e) == null) {
                    return;
                }
                onDismissListener.onDismiss(dialogInterface);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n(new d.a.q0.a.w2.h.a());
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.a.q0.a.g.swan_app_auth_hover_dialog, e(), false);
            W(viewGroup);
            this.j = (LinearLayout) viewGroup.findViewById(d.a.q0.a.f.auth_layout);
            this.f52008h = (TextView) viewGroup.findViewById(d.a.q0.a.f.auth_negative_button);
            this.f52009i = (TextView) viewGroup.findViewById(d.a.q0.a.f.auth_positive_button);
            this.k = (LinearLayout) viewGroup.findViewById(d.a.q0.a.f.know_it_layout);
            this.l = (CheckBox) viewGroup.findViewById(d.a.q0.a.f.hover_dialog_not_tips);
            this.f52006f = (TextView) viewGroup.findViewById(d.a.q0.a.f.hover_dialog_title);
            this.f52007g = (TextView) viewGroup.findViewById(d.a.q0.a.f.hover_dialog_tip);
            this.l.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(d.a.q0.a.e.swanapp_hover_dialog_tip_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.k.setVisibility(8);
            this.j.setVisibility(0);
            this.l.setVisibility(0);
            this.f52022b.setCancelable(false);
        }

        @Override // d.a.q0.a.z1.b.b.h.a
        public /* bridge */ /* synthetic */ h.a N(DialogInterface.OnShowListener onShowListener) {
            j0(onShowListener);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.z1.b.b.h.a
        /* renamed from: b0 */
        public f c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (f) super.c() : (f) invokeV.objValue;
        }

        public final int c0() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l.isChecked() ? 1 : 0 : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.z1.b.b.h.a
        /* renamed from: d0 */
        public f h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? new f(context) : (f) invokeL.objValue;
        }

        public a e0(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f52007g.setText(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f0(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f52006f.setText(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g0(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, onClickListener)) == null) {
                this.f52008h.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a h0(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, onClickListener)) == null) {
                super.M(new DialogInterface$OnKeyListenerC1051a(this, onClickListener));
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a i0(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onDismissListener)) == null) {
                super.L(new e(this, onDismissListener));
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a j0(DialogInterface.OnShowListener onShowListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, onShowListener)) == null) {
                super.N(new d(this, onShowListener));
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a k0(DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, onClickListener)) == null) {
                this.f52009i.setOnClickListener(new c(this, onClickListener));
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context, d.a.q0.a.i.SwanAppNoTitleDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setWindowAnimations(d.a.q0.a.i.action_sheet_animation);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            h.a c2 = c();
            c2.p(d.a.q0.a.e.aiapps_action_sheet_bg);
            c2.f(true);
            c2.k(false);
            c2.j();
            c2.t(false);
        }
    }
}
