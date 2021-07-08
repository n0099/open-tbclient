package d.l.a.a.a.a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.a.a.c.k;
import d.l.a.a.a.d.d;
import d.l.a.a.a.f.c;
/* loaded from: classes8.dex */
public class a implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.l.a.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class DialogInterface$OnClickListenerC2010a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.f.c f71069e;

        public DialogInterface$OnClickListenerC2010a(d.l.a.a.a.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71069e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            c.InterfaceC2012c interfaceC2012c;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (interfaceC2012c = this.f71069e.f71105h) == null) {
                return;
            }
            interfaceC2012c.b(dialogInterface);
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.f.c f71070e;

        public b(d.l.a.a.a.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71070e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            c.InterfaceC2012c interfaceC2012c;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (interfaceC2012c = this.f71070e.f71105h) == null) {
                return;
            }
            interfaceC2012c.a(dialogInterface);
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.f.c f71071e;

        public c(d.l.a.a.a.f.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71071e = cVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            c.InterfaceC2012c interfaceC2012c;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (interfaceC2012c = this.f71071e.f71105h) == null) {
                return;
            }
            interfaceC2012c.c(dialogInterface);
        }
    }

    public a() {
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

    @Override // d.l.a.a.a.c.k
    public void a(int i2, @Nullable Context context, d dVar, String str, Drawable drawable, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), context, dVar, str, drawable, Integer.valueOf(i3)}) == null) {
            Toast.makeText(context, str, 0).show();
        }
    }

    @Override // d.l.a.a.a.c.k
    public Dialog b(@NonNull d.l.a.a.a.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) ? a(cVar) : (Dialog) invokeL.objValue;
    }

    public static Dialog a(d.l.a.a.a.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cVar)) == null) {
            if (cVar == null) {
                return null;
            }
            AlertDialog show = new AlertDialog.Builder(cVar.f71098a).setTitle(cVar.f71099b).setMessage(cVar.f71100c).setPositiveButton(cVar.f71101d, new b(cVar)).setNegativeButton(cVar.f71102e, new DialogInterface$OnClickListenerC2010a(cVar)).show();
            show.setCanceledOnTouchOutside(cVar.f71103f);
            show.setOnCancelListener(new c(cVar));
            Drawable drawable = cVar.f71104g;
            if (drawable != null) {
                show.setIcon(drawable);
            }
            return show;
        }
        return (Dialog) invokeL.objValue;
    }
}
