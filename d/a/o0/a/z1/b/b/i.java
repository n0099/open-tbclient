package d.a.o0.a.z1.b.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class i extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a f49246f;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b f49247a;

        /* renamed from: b  reason: collision with root package name */
        public final i f49248b;

        /* renamed from: c  reason: collision with root package name */
        public Context f49249c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f49250d;

        /* renamed from: d.a.o0.a.z1.b.b.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1011a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f49251e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f49252f;

            public View$OnClickListenerC1011a(a aVar, DialogInterface.OnClickListener onClickListener) {
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
                this.f49252f = aVar;
                this.f49251e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f49252f.f49248b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f49251e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f49252f.f49248b, -1);
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DialogInterface.OnClickListener f49253e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f49254f;

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
                this.f49254f = aVar;
                this.f49253e = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f49254f.f49248b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.f49253e;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.f49254f.f49248b, -2);
                    }
                }
            }
        }

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49250d = false;
            i b2 = b(context);
            this.f49248b = b2;
            b2.d(this);
            this.f49247a = new b((ViewGroup) this.f49248b.getWindow().getDecorView());
            this.f49249c = context;
        }

        public i a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f49248b.setOnCancelListener(this.f49247a.f49260f);
                this.f49248b.setOnDismissListener(this.f49247a.f49261g);
                this.f49248b.setOnShowListener(this.f49247a.f49262h);
                this.f49248b.d(this);
                return this.f49248b;
            }
            return (i) invokeV.objValue;
        }

        public abstract i b(Context context);

        public a c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f49248b.setCanceledOnTouchOutside(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a d(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, onClickListener)) == null) {
                e(this.f49249c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, charSequence, onClickListener)) == null) {
                this.f49247a.f49256b.setText(charSequence);
                this.f49247a.f49256b.setOnClickListener(new b(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a f(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, onCancelListener)) == null) {
                this.f49247a.f49260f = onCancelListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f49247a.f49257c.setText(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a h(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, onClickListener)) == null) {
                i(this.f49249c.getText(i2), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence, onClickListener)) == null) {
                this.f49247a.f49255a.setText(charSequence);
                this.f49247a.f49255a.setOnClickListener(new View$OnClickListenerC1011a(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a j(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
                this.f49247a.f49259e.removeAllViews();
                this.f49247a.f49259e.addView(view);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public i k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                i a2 = a();
                if (this.f49250d) {
                    a2.getWindow().setType(2003);
                }
                try {
                    a2.show();
                } catch (WindowManager.BadTokenException unused) {
                }
                return a2;
            }
            return (i) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f49255a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49256b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f49257c;

        /* renamed from: d  reason: collision with root package name */
        public View f49258d;

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout f49259e;

        /* renamed from: f  reason: collision with root package name */
        public DialogInterface.OnCancelListener f49260f;

        /* renamed from: g  reason: collision with root package name */
        public DialogInterface.OnDismissListener f49261g;

        /* renamed from: h  reason: collision with root package name */
        public DialogInterface.OnShowListener f49262h;

        /* renamed from: i  reason: collision with root package name */
        public FrameLayout f49263i;
        public FrameLayout j;
        public View k;
        public ViewGroup l;
        public RelativeLayout m;
        public LinearLayout n;
        public View o;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = viewGroup;
            this.j = (FrameLayout) viewGroup.findViewById(d.a.o0.a.f.dialog_root);
            this.f49257c = (TextView) viewGroup.findViewById(d.a.o0.a.f.title_picker);
            this.f49255a = (TextView) viewGroup.findViewById(d.a.o0.a.f.positive_button);
            this.f49256b = (TextView) viewGroup.findViewById(d.a.o0.a.f.negative_button);
            this.f49258d = viewGroup.findViewById(d.a.o0.a.f.dialog_customPanel);
            this.f49259e = (FrameLayout) viewGroup.findViewById(d.a.o0.a.f.dialog_custom_content);
            this.m = (RelativeLayout) viewGroup.findViewById(d.a.o0.a.f.searchbox_alert_dialog);
            this.n = (LinearLayout) viewGroup.findViewById(d.a.o0.a.f.btn_panel);
            this.o = viewGroup.findViewById(d.a.o0.a.f.dialog_customPanel);
            this.f49263i = (FrameLayout) viewGroup.findViewById(d.a.o0.a.f.dialog_root);
            this.k = viewGroup.findViewById(d.a.o0.a.f.nightmode_mask);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f49246f : (a) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(d.a.o0.a.g.swanapp_picker_dialog);
            getWindow().setLayout(-1, -2);
            getWindow().setGravity(80);
            a(false);
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f49246f = aVar;
        }
    }
}
